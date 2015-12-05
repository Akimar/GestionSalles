/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.HoraireJour;
import com.iia.osiris.metier.Salarie;
import com.iia.osiris.metier.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akimar
 */
public abstract class SalleDAO {
    
     public static void getAllSalle(Connection cnx, Vector<Salle> vectorSalle)
    {
        PreparedStatement pstmtSalle = null;
        PreparedStatement pstmtHoraire = null;
        
        try 
        {
            HoraireJour[] disponibilite;
            int countDispo = 0;
            int i = 0;
            
            pstmtSalle = cnx.prepareStatement("SELECT Identifiant, NomSalle, NumeroTerminal FROM Salle;");  
            pstmtHoraire = cnx.prepareStatement("SELECT IdentifiantJour, HoraireDebMat, HoraireFinMat, HoraireDebSoir, HoraireFinSoir , Jour.Identifiant, Libelle  FROM Disponibilite INNER JOIN Jour ON Disponibilite.IdentifiantJour = Jour.Identifiant WHERE Disponibilite.IdentifiantSalle = ?");
            
            

            ResultSet rsSalle = pstmtSalle.executeQuery(); 
            ResultSet rsHoraire = null;
           
            
            while(rsSalle.next()) // pour chaque salle
            {
              pstmtHoraire.setInt(1, rsSalle.getInt("Identifiant"));
              rsHoraire = pstmtHoraire.executeQuery();
              
              countDispo = getCountDispo(cnx, rsSalle.getInt("Identifiant"));
              
              disponibilite = new HoraireJour[countDispo];
              
              while(rsHoraire.next() && i< countDispo)
              {
                disponibilite[i] = new HoraireJour(rsHoraire.getInt("Identifiant"), rsHoraire.getString("Libelle"),  rsHoraire.getTime("HoraireDebMat") , rsHoraire.getTime("HoraireFinMat"),  rsHoraire.getTime("HoraireDebSoir"),  rsHoraire.getTime("HoraireFinSoir"));
                i++;
              }
              
              i = 0;
              vectorSalle.add(new Salle(rsSalle.getInt("Identifiant"), rsSalle.getString("NumeroTerminal"), rsSalle.getString("NomSalle"), disponibilite));
            }
        }
        catch (Exception ex)
        {
        } 
        
        finally
        {
            if(pstmtHoraire != null)
            {
                try
                {
                    pstmtHoraire.close();
                }

                catch(SQLException ex)
                {

                }
            }
            
             if(pstmtSalle != null)
            {
                try
                {
                    pstmtSalle.close();
                }

                catch(SQLException ex)
                {

                }
            }
        }
    }
     
    public static int getCountDispo(Connection cnx, int id)
    {
        int nbDispo = 0;
         PreparedStatement pstmt = null;
        try 
        {
           pstmt = cnx.prepareStatement("SELECT COUNT(IdentifiantJour) FROM Disponibilite WHERE IdentifiantSalle =? ;");
           pstmt.setInt(1, id);
           ResultSet rs = pstmt.executeQuery();
           rs.next();
           
           nbDispo = rs.getInt(1);
        } 
        catch (SQLException ex) 
        {
           Logger.getLogger(SalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally
        {
            if(pstmt != null)
            {
                try
                {
                    pstmt.close();
                }

                catch(SQLException ex)
                {

                }
            }
            
            return  id;
        }
    }
}
