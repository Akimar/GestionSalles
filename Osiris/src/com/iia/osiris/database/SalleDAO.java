/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.model.HistoriqueSalleTableModel;
import com.iia.osiris.metier.HoraireJour;
import com.iia.osiris.metier.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Vector;



/**
 *
 * @author Akimar
 */
public abstract class SalleDAO {
    
    // récupère toutes les salles
    public static void getAllSalle(Connection cnx, Vector<Salle> vectorSalle)
    {
        PreparedStatement pstmtSalle = null;
        PreparedStatement pstmtHoraire = null;
        
        try 
        {
            HoraireJour[] disponibilite;
            int countDispo = 0;
            int i = 0;
            
            pstmtSalle = cnx.prepareStatement("SELECT Identifiant, NomSalle, NumeroTerminal FROM Salle ORDER BY NomSalle;");// get des salles  
            pstmtHoraire = cnx.prepareStatement("SELECT IdentifiantJour, HoraireDebMat, HoraireFinMat, HoraireDebSoir, HoraireFinSoir , Jour.Identifiant, Libelle  FROM Disponibilite INNER JOIN Jour ON Disponibilite.IdentifiantJour = Jour.Identifiant WHERE Disponibilite.IdentifiantSalle = ? ORDER BY Libelle;");// get des disponibilités d'une salle
            
            

            ResultSet rsSalle = pstmtSalle.executeQuery(); 
            ResultSet rsHoraire = null;
           
            
            while(rsSalle.next()) // pour chaque salle
            {
              pstmtHoraire.setInt(1, rsSalle.getInt("Identifiant"));
              rsHoraire = pstmtHoraire.executeQuery();
              
              countDispo = getCountDispo(cnx, rsSalle.getInt("Identifiant"));// get du nombre de jours pour lesquels les diponibilités existent en base
              
              disponibilite = new HoraireJour[countDispo];
              
              while(rsHoraire.next() && i< countDispo)// on remplit le tableau des diponibilités pour la salle
              {
                disponibilite[i] = new HoraireJour(rsHoraire.getInt("Identifiant"), rsHoraire.getString("Libelle"),  rsHoraire.getTime("HoraireDebMat") , rsHoraire.getTime("HoraireFinMat"),  rsHoraire.getTime("HoraireDebSoir"),  rsHoraire.getTime("HoraireFinSoir"));
                i++;
              }
              
              i = 0;
              vectorSalle.add(new Salle(rsSalle.getInt("Identifiant"), rsSalle.getString("NumeroTerminal"), rsSalle.getString("NomSalle"), disponibilite));// ajout de la salle dans les vector
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
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
                    ex.printStackTrace();
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
                    ex.printStackTrace();
                }
            }
        }
    }
     
    // get du nombre de jours pour lesquels les diponibilités existent en base
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
            
            return  nbDispo;
        }
    }
    
    //get des salariés ayant tenter d'accéder à une salle
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
            
            countAcces = getCountAccess(cnx, id); // get du nombre d'accès pour la salle
            
            if(countAcces == 0)
            {
                return null;
            }
            
            pstmt = cnx.prepareStatement("SELECT DateAcces, Nom, Prenom, Badge, EstAdmin, Autorise  FROM HistoriqueAcces INNER JOIN Salarie ON IdentifiantSalarie = Identifiant WHERE IdentifiantSalle = ?");// get des salariés
            pstmt.setInt(1,id);
                  
            ResultSet rs = pstmt.executeQuery();
            
            access = new String [countAcces][7];
            
            while(rs.next() && i<countAcces)
            {
               date = getDateFromDateTime(String.valueOf(rs.getTimestamp("DateAcces")));
               time = getTimeFromDateTime(String.valueOf(rs.getTimestamp("DateAcces")));
               date = HistoriqueSalleTableModel.changeDateFormat(date, true);
               access[i][0] = rs.getString("Nom");
               access[i][1] = rs.getString("Prenom");
               access[i][2] = rs.getString("Badge");
               access[i][3] = String.valueOf(rs.getBoolean("EstAdmin"));
               access[i][4] = date;
               access[i][5] = time;
               access[i][6] = String.valueOf(rs.getBoolean("Autorise"));
               
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
                    ex.printStackTrace();
                }
            }
        }
         
          return access;
    }
    
     // get du nombre d'accès pour la salle
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
            
            return  nbAcces;
        }
    } 
    
    //extrait la date d'un DATETIME MySQL
    public static String getDateFromDateTime(String dateTime)
    {
        String date;
        return date = dateTime.substring(0, 10);
    }
    
    //extrait l'heure d'un DATETIME MySQL
    public static String getTimeFromDateTime(String dateTime)
    {
        String time;
        return time = dateTime.substring(11, 19);
    }
    
   
    //Mise à jour des disponibilités d'une salle
    // LEs réservations dont les horaires ne correspondent plus aux créneaux de la salle sont supprimés via un trigger en base.
    public static void updateDispo(Connection cnx, String jour, Time horaireDebMat, Time horaireFinMat, Time horaireDebSoir, Time horaireFinSoir)
    {
        PreparedStatement pstmt = null;
        try 
        {
           pstmt = cnx.prepareStatement("UPDATE Disponibilite SET HoraireDebMat = ?, HoraireFinMat = ?, HoraireDebSoir = ?, HoraireFinSoir = ? WHERE IdentifiantJour = (SELECT Identifiant FROM Jour WHERE Libelle = ?);");
           pstmt.setTime(1, horaireDebMat);
           pstmt.setTime(2, horaireFinMat);
           pstmt.setTime(3, horaireDebSoir);
           pstmt.setTime(4, horaireFinSoir);
           pstmt.setString(5, jour);
         
           pstmt.executeUpdate();
         
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
                    ex.printStackTrace();
                }
            }
        }
    }
    
    //met à jour les infos de la salle
    public static void updateSalle(Connection cnx, int identifiant, String terminal, String salle)
    {
        PreparedStatement pstmt = null;
        try 
        {
            
            
            pstmt = cnx.prepareStatement("UPDATE Salle SET NomSalle = ?, NumeroTerminal = ? WHERE Identifiant = ?");
            pstmt.setString(1, salle);
            pstmt.setString(2, terminal);
           
            pstmt.setInt(3,identifiant);
                  
            pstmt.executeUpdate();
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
                    ex.printStackTrace();
                }
            }
        }
    }
}
