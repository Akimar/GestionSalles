/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.Salarie;
import com.iia.osiris.metier.Salle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Akimar
 */
public abstract class SalleDAO {
    
     public static void getAllSalle(Connection cnx, Vector<Salle> vectorSalle)
    {
        Statement stmtSalle = null;
        Statement stmtHoraire = null;
        try 
        {
            stmtSalle = cnx.createStatement();       
            ResultSet rsSalle = stmtSalle.executeQuery("SELECT Identifiant, NomSalle, NomTerminal FROM Salle"); 
                 
            stmtHoraire = cnx.createStatement();
            ResultSet rsHoraire = null;
            
            while(rsSalle.next()) // pour chaque salle
            {
               rsHoraire = stmtHoraire.executeQuery()
              vectorSalle.add(new Salle(rs.getInt("Identifiant"), rs.getString("NumeroTerminal"), ));
            }
                
        /*SELECT Salle.Identifiant AS 'IdentifientSalle', Jour.Identifiant AS 'IdentifientJour', NumeroTerminal, NomSalle, HoraireDebMat, HoraireFinMat, HoraireDebSoir, HoraireFinSoir, Jour FROM Salle INNER JOIN Disponibilite ON Salle.Identifiant = Disponibilite.IdentifiantSalle INNER JOIN Jour ON Disponibilite.IdentifiantJour = Jour.Identifiant;"); */
        }
        catch (Exception ex)
        {
        } 
        
        finally
        {
            if(stmt != null)
            {
                try
                {
                    stmt.close();
                }

                catch(SQLException ex)
                {

                }
            }
        }
    }
}
