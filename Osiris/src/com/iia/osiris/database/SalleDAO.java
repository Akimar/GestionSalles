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
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;

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
    
    public static String[][] getSalleAccess(Connection cnx, int id)
     {
        PreparedStatement pstmt = null;
        int countAcces = 0;
        int i = 0;
        String date;
        String time;
        
        String[][] access = null;
        
        try 
        {
            
            countAcces = getCountAccess(cnx, id);
            
            if(countAcces == 0)
            {
                return null;
            }
            
            pstmt = cnx.prepareStatement("SELECT DateAcces, Nom, Prenom, Badge, EstAdmin FROM HistoriqueAcces INNER JOIN Salarie ON IdentifiantSalarie = Identifiant WHERE IdentifiantSalle = ?");
            pstmt.setInt(1,id);
                  
            ResultSet rs = pstmt.executeQuery();
            
            access = new String [countAcces][6];
            
            while(rs.next() && i<countAcces)
            {
               date = getDateFromDateTime(String.valueOf(rs.getTimestamp("DateAcces")));
               time = getTimeFromDateTime(String.valueOf(rs.getTimestamp("DateAcces")));
               access[i][0] = rs.getString("Nom");
               access[i][1] = rs.getString("Prenom");
               access[i][2] = rs.getString("Badge");
               access[i][3] = String.valueOf(rs.getBoolean("EstAdmin"));
               access[i][4] = date;
               access[i][5] = time;
               
               i++;
            }
            
            
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
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
        }
         
          return access;
    }
    
     
    public static int getCountAccess(Connection cnx, int id)
    {
        int nbAcces = 0;
        
        PreparedStatement pstmt = null;
        try 
        {
           pstmt = cnx.prepareStatement("SELECT COUNT(*) FROM HistoriqueAcces WHERE IdentifiantSalle =? ;");
           pstmt.setInt(1, id);
           ResultSet rs = pstmt.executeQuery();
           rs.next();
           
           nbAcces = rs.getInt(1);
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
            
            return  nbAcces;
        }
    } 
    
    public static String getDateFromDateTime(String dateTime)
    {
        String date;
        return date = dateTime.substring(0, 10);
    }
    
    
    public static String getTimeFromDateTime(String dateTime)
    {
        String time;
        return time = dateTime.substring(11, 19);
    }
    
    public static String changeDateFormat(String date, boolean mysqlFormat)
    {
       
        if(mysqlFormat)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            
            String jour = date.substring(8);
            String mois = date.substring(5, 7);
            String annee = date.substring(0, 4);
            
            date = jour+"/"+mois+"/"+annee;
        }
        
        else
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            String jour = date.substring(0, 2);
            String mois = date.substring(3, 5);
            String annee = date.substring(7);
            
            date = annee+"-"+mois+"-"+jour;
        }
       return date;  
    }
}
