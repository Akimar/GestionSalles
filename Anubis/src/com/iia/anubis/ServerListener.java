/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.anubis;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Darkadok
 */
public abstract class ServerListener {
    
    public static void initialiserServer() {
        ServerSocket server = null;
        TerminalDaemon[] clients = new TerminalDaemon[20];//Nombre de terminaux (list prechargée)
        try {
            server = new ServerSocket(5020);//Port 5020 utilisé
            int i = 0;
            while (true)
            {
                Socket so = server.accept();//Attente d'une connection
                InetAddress ia = so.getInetAddress();//Adresse connectée
                System.out.println(ia.getHostAddress());
                
                TerminalDaemon client = new TerminalDaemon(so);//Creation d'un objet client
                client.setDaemon(true);
                client.start();//lancement du thread
                clients[i] = client;//list des clients
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally
        {
            if (server != null)
                try {
                    server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
