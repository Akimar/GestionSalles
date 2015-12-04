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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

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
    private Salle salle ;
    private String Message;

    public TerminalDaemon(Socket socket) throws IOException {
        this.socket = socket;
        this.os = socket.getOutputStream();
        this.is = socket.getInputStream();
        this.pw = new PrintWriter(os);
        this.br = new BufferedReader(new InputStreamReader(is));

    }

    public String getIdentifiantTerminal() {
        if (salle != null)
        {
            return salle.getNumeroTerminal();
        }
        else
        {
            return null;
        }
    }
    public void setIdentifiantTerminal(String IdentifiantTerminal) {
        if (salle == null)
        {
            salle = new Salle(-1, IdentifiantTerminal, null, null, null);
        }
        else
        {
            this.salle.setNumeroTerminal(IdentifiantTerminal);
        }
       
    }

    public String getMessage() {
        return Message;
    }

    @Override
    public void run() {
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
            System.out.println(this.getIdentifiantTerminal());
            try {
                cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                stmt = cnx.createStatement();
                resultSet = stmt.executeQuery("SELECT identifiant FROM salle WHERE NumeroTerminal = " + this.getIdentifiantTerminal());
                if (!resultSet.next()) {
                    stmt.executeUpdate("INSERT INTO salle VALUES (NULL, '" + this.getIdentifiantTerminal() + "', NULL, NULL)");
                    //a tester
                }
                else
                {
                    this.salle = new Salle(resultSet.getInt("Identifiant"), resultSet.getString("NumeroTerminal"), resultSet.getString("NomSalle"), null, null);
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

    public void reception() {
        String line;
        Connection cnx = null;
        Statement stmt = null;
        PreparedStatement prstmt = null;
        ResultSet resultSet = null;
        Salarie scanne = null;
        try {
            Thread.sleep((3000));//pour affichage
            cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
            this.envoyer("    En attente.");
            while ((line = br.readLine()) != null)//attend lecture terminal
            {
                this.Message = line;
                line = transformerChaineMessage(this.Message);
                if (line.equals("CME"))//action selon la lecture
                {
                    this.envoyer("    Bonjour Merlin");
                }
                if (line.equals("CSTAT")) {
                    this.envoyer("    Connected_to_" + InetAddress.getLocalHost().toString());
                }

                if (line.equals("CWHO")) {
                    this.envoyer("    Identifiant terminal : " + this.getIdentifiantTerminal());
                }
                if (line.matches("[A-Za-z0-9]+")) {
                    stmt = cnx.createStatement();
                    resultSet = stmt.executeQuery("SELECT * FROM salarie WHERE Badge = '"+ line +"';");
                    if (resultSet.next())
                    {
                        scanne = new Salarie (resultSet.getInt("Identifiant"), resultSet.getString("Nom"), resultSet.getString("Prenom"), resultSet.getString("Badge"), resultSet.getBoolean("EstAdmin"));
                        
                        //verifier qu'il a le droit d'entrer, ouvrir ou non la porte
                        prstmt = cnx.prepareStatement("SELECT * FROM reservation WHERE DateRes = ? AND IdentifiantSalle = ? ");
                        prstmt.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                        prstmt.setInt(2, salle.getIdentifiant());
                        resultSet = prstmt.executeQuery();// a tester
                        while (resultSet.next())
                        {
                            // a finir
                        }
                        
                    }
                    else
                    {
                        this.envoyer("    Badge detecté mais non reconnu");                       
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

    public String transformerChaineMessage(String input) {
        if (!input.equals("T042CINIT")) {
            return input.substring(4, this.Message.length() - 9);
        } else {
            return input;
        }

    }

}
