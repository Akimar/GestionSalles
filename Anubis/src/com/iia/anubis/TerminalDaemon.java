package com.iia.anubis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.iia.osiris.database.BDD_Util;
import com.iia.osiris.metier.Salarie;
import com.iia.osiris.metier.Salle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Darkadok
 */
public class TerminalDaemon extends Thread {

    private Socket socket;
    private InputStream is;
    private BufferedReader br;
    private OutputStream os;
    private PrintWriter pw;
    private Salle salle;
    private String Message;

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public TerminalDaemon(Socket socket) throws IOException {
        this.socket = socket;
        this.os = socket.getOutputStream();
        this.is = socket.getInputStream();
        this.pw = new PrintWriter(os);
        this.br = new BufferedReader(new InputStreamReader(is));

    }

    public String getIdentifiantTerminal() {
        if (this.getSalle() != null) {
            return this.getSalle().getNumeroTerminal();
        } else {
            return null;
        }
    }

    public void setIdentifiantTerminal(String IdentifiantTerminal) {
        if (salle == null) {
            salle = new Salle(-1, IdentifiantTerminal, null, null);
        } else {
            this.getSalle().setNumeroTerminal(IdentifiantTerminal);
        }

    }

    public String getMessage() {
        return Message;
    }

    @Override
    public void run() {//initialise le terminal
        String line;
        Connection cnx;
        Statement stmt;
        ResultSet resultSet;
        try {
            //Lors de premiere co, affichage de l'adresse serveur
            this.envoyer("    Connected_to_" + InetAddress.getLocalHost().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            line = br.readLine();//le terminal envoie son identité
            this.setIdentifiantTerminal(line.substring(line.length() - 4));//récupérée et mise en attribut
            System.out.println(this.getIdentifiantTerminal());//pour info-log
            try {
                cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                stmt = cnx.createStatement();
                resultSet = stmt.executeQuery("SELECT * FROM salle WHERE NumeroTerminal = '" + this.getIdentifiantTerminal() +"' ;");
                // on regarde si le terminal existe en base
                if (!resultSet.next()) {//si non on le créé
                    stmt.executeUpdate("INSERT INTO salle VALUES (NULL, '" + this.getIdentifiantTerminal() + "', 'VOID' );");
                    this.setSalle(new Salle(-1, line, null, null));
                } else {
                    this.setSalle(new Salle(resultSet.getInt("Identifiant"), resultSet.getString("NumeroTerminal"), resultSet.getString("NomSalle"), null));
                }
            } catch (Exception ex) {
                System.out.println(ex.getStackTrace());
            }
            //lancement processus attente message
            this.reception();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void reception() {//recoit et interprete les messages du terminal
        String line;
        Connection cnx = null;
        Statement stmt = null;
        CallableStatement costmt = null;
        ResultSet resultSet = null;
        Salarie scanne = null;
        boolean isBadge;
        boolean open = false;
        try {
            //Thread.sleep((3000));//pour affichage
            
            this.envoyer("    En attente.");
            while ((line = br.readLine()) != null)//attend lecture terminal
            {
                cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                this.Message = line;
                line = transformerChaineMessage(this.Message);
                isBadge = true;
                if (line.equals("CME"))//action selon la lecture
                {
                    this.envoyer("    Bonjour Merlin");
                    isBadge = false;
                }
                if (line.equals("CSTAT")) {
                    this.envoyer("    Connected_to_" + InetAddress.getLocalHost().toString());
                    isBadge = false;
                }

                if (line.equals("CWHO")) {
                    this.envoyer("    Identifiant terminal : " + this.getIdentifiantTerminal() + " => "+this.getSalle().getNom());
                    isBadge = false;
                }
                if (line.matches("[A-Za-z0-9]+") && isBadge) {//si c'est un badge
                    stmt = cnx.createStatement();
                    resultSet = stmt.executeQuery("SELECT * FROM salarie WHERE Badge = '" + line + "';");
                    if (resultSet.next()) {//si le badge est connu
                        scanne = new Salarie(resultSet.getInt("Identifiant"), resultSet.getString("Nom"), resultSet.getString("Prenom"), resultSet.getString("Badge"), resultSet.getBoolean("EstAdmin"));
                        costmt = cnx.prepareCall("{call ProcStockPassageBadge(?, ?)}");//procedure stockée
                        costmt.setInt(1, scanne.getIdentifiant());//id salarie
                        costmt.setInt(2, this.getSalle().getIdentifiant());//id Salle
                        resultSet = costmt.executeQuery();
                        while (resultSet.next()) {//proc renvoie le nombre de reservation qui matches avec l'heure et salle du badge
                            if (resultSet.getInt("Ouverture") > 0) {
                                open = true;
                            } else {
                                open = false;
                            }
                        }

                        if (open) {
                            this.envoyer("    Entree autorisee - " + scanne.getNom() + " " + scanne.getPrenom());
                        } else {
                            this.envoyer("    Entree non autorisee - " + scanne.getNom() + " " + scanne.getPrenom());
                        }
                        scanne = null;
                    } else {
                        this.envoyer("    Non reconnu");
                    }
                }
                Thread.sleep((5000));//pour affichage
                this.envoyer("    En attente.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void envoyer(String message) {//Methode servant à envoyer un message au terminal
        pw.println(message);
        pw.flush();
    }

    public String transformerChaineMessage(String input) {//Ne selectionne que la partie corps du message
        if (!input.matches("T[0-9]*CINIT")) {
            return input.substring(4, this.Message.length() - 9);
        } else {
            return input;
        }
    }
}
