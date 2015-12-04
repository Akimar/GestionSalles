package com.iia.anubis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

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
    private String IdentifiantTerminal;
    private String Message;

    public TerminalDaemon(Socket socket) throws IOException {
        this.socket = socket;
        this.os = socket.getOutputStream();
        this.is = socket.getInputStream();
        this.pw = new PrintWriter(os);
        this.br = new BufferedReader(new InputStreamReader(is));

    }

    public String getIdentifiantTerminal() {
        return IdentifiantTerminal;
    }

    public void setIdentifiantTerminal(String IdentifiantTerminal) {
        this.IdentifiantTerminal = IdentifiantTerminal;
    }

    public String getMessage() {
        return Message;
    }

    @Override
    public void run() {
        String line;
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

            //lancement processus attente message
            this.reception();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void reception() {
        String line;
        try {
            Thread.sleep((3000));
            this.envoyer("    En attente.");
            while ((line = br.readLine()) != null)//attend lecture terminal
            {
                this.Message = line;
                line = transformerChaineMessage(this.Message);
                if (line.equals("CME"))//action selon la lecture
                {
                    this.envoyer("    Bonjour Merlin");
                }
                if (line.equals("CSTAT"))
                {
                    this.envoyer("    Connected_to_" + InetAddress.getLocalHost().toString());
                }
                
                if (line.equals("CWHO"))
                {
                    this.envoyer("    Identifiant terminal : "+this.getIdentifiantTerminal());
                }
                if (line.equals("M0042949747464")) {
                    this.envoyer("    Badge reconnu");
                }
                Thread.sleep((5000));
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
        if (!input.equals("T042CINIT"))
        {
            return input.substring(4, this.Message.length() - 9);        
        }
        else
        {
            return input;
        }

    }

}
