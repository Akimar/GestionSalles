/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.Salarie;
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
public abstract class SalarieDAO {
    
    public static void getAllSalarie(Connection cnx, Vector<Salarie> vectorSalarie)
    {
        PreparedStatement pstmt = null;
        try 
        {
            pstmt = cnx.prepareStatement("SELECT *  FROM Salarie ORDER BY Nom, Prenom;");       
            ResultSet rs = pstmt.executeQuery(); 
                 
            while(rs.next()) // pour chaque salle
            {
                vectorSalarie.add(new Salarie(rs.getInt("Identifiant"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Badge"), rs.getBoolean("EstAdmin")));
            }
        }
        catch (Exception ex)
        {
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
    }
    
    public static int addSalarie(Connection cnx, String nom, String prenom, String badge, String mdp, boolean admin)
    {
       

        PreparedStatement pstmt = null;
        int id = -1;
        
        try 
        {
           mdp = Salarie.passEncrypt(mdp);

            pstmt = cnx.prepareStatement("INSERT INTO Salarie(Nom, Prenom, Badge, MotDePasse, EstAdmin) VALUES(?, ?, ?, ?, ?); ", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, badge);
            pstmt.setString(4, mdp);
            pstmt.setBoolean(5, admin);
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);    
        }
        catch (Exception ex)
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
        
        return id;
    }
    
    public static void updateSalarie(Connection cnx, int identifiant, String nom, String prenom, String badge, String mdp, boolean admin)
    {
        PreparedStatement pstmt = null;
        try 
        {
            
            if(mdp.isEmpty())
            {
                pstmt = cnx.prepareStatement("UPDATE Salarie SET Nom = ?, Prenom = ?, Badge = ?, EstAdmin = ? WHERE Identifiant = ?");         
                pstmt.setInt(5,identifiant);
            }
            
            else
            {
                pstmt = cnx.prepareStatement("UPDATE Salarie SET Nom = ?, Prenom = ?, Badge = ?, EstAdmin = ?,  MotdePasse = ? WHERE Identifiant = ?");
                
                pstmt.setString(5, Salarie.passEncrypt(mdp));
                pstmt.setInt(6,identifiant);
            }
            
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, badge);
            pstmt.setBoolean(4 ,admin);
            
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

                }
            }
        }
    }
    
     public static void deleteSalarie(Connection cnx, int identifiant)
    {
        PreparedStatement pstmt = null;
        
        try 
        {
            
            
            pstmt = cnx.prepareStatement("DELETE FROM Salarie WHERE Identifiant = ?");
            pstmt.setInt(1,identifiant);
                  
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

                }
            }
        }
        
    }
    
     public static String[][] getSalarieAccess(Connection cnx, int id)
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
            
            pstmt = cnx.prepareStatement("SELECT DateAcces, NomSalle, NumeroTerminal, Autorise FROM HistoriqueAcces INNER JOIN Salle ON IdentifiantSalle = Identifiant WHERE IdentifiantSalarie = ?");
            pstmt.setInt(1,id);
                  
            ResultSet rs = pstmt.executeQuery();
            
            access = new String [countAcces][5];
            
            while(rs.next() && i<countAcces)
            {
                
               date = SalleDAO.getDateFromDateTime(String.valueOf(rs.getTimestamp("DateAcces")));
               time = SalleDAO.getTimeFromDateTime(String.valueOf(rs.getTimestamp("DateAcces")));
               date = SalleDAO.changeDateFormat(date, true);
               access[i][0] = rs.getString("NomSalle");
               access[i][1] = rs.getString("NumeroTerminal");
               access[i][2] = date;
               access[i][3] = time;
               access[i][4] = String.valueOf(rs.getBoolean("Autorise"));
             
               
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
           pstmt = cnx.prepareStatement("SELECT COUNT(*) FROM HistoriqueAcces WHERE IdentifiantSalarie =? ;");
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

}
