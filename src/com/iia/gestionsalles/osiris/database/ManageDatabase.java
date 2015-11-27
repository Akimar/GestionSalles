/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles.osiris.database;

import com.iia.gestionsalles.osiris.metier.Salarie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Akimar
 */
public abstract class ManageDatabase {
    
    public static void manageSalarie(Salarie s, boolean is_update,String user, String password, String server, String database)
    {
        Connection cnx = null;
        PreparedStatement pstmt = null;
    
        try 
        {
            
            cnx =  BDD_Util.open(user, password, server, database);
         
            if(is_update)
            {
                pstmt = cnx.prepareStatement("UPDATE Salarie SET( nom = ?, prenom = ?, badge = ?, est_admin = ?) WHERE identifiant = ?");
                pstmt.setString(1, s.getNom());
                pstmt.setString(2, s.getPrenom());
                pstmt.setString(3, s.getBadge());
                pstmt.setBoolean(4, s.isEstAdmin());
                pstmt.setInt(5, s.getIdentifiant());
            }
            else
            {
                pstmt = cnx.prepareStatement("DELETE FROM Salarie WHERE identifiant = ?");
                pstmt.setInt(1, s.getIdentifiant());
            }
           
            pstmt.setInt(1, s.getIdentifiant());
            pstmt.executeUpdate();  
        }
        
        catch(Exception e)
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
            
            if(cnx != null)
            {
                try 
                {
                    cnx.close();
                } 

                catch (SQLException ex) 
                {

                }
            }
        }
    }
    
     public static void manageSalle(Salarie s, boolean is_update,String user, String password, String server, String database)
    {
        Connection cnx = null;
        PreparedStatement pstmt = null;
    
        try 
        {
            
            cnx =  BDD_Util.open(user, password, server, database);
         
            if(is_update)
            {
                pstmt = cnx.prepareStatement("UPDATE Salle SET( numero_terminal = ?, nom_salle = ?, badge = ?, est_admin = ?) WHERE identifiant = ?");
                pstmt.setString(1, s.getNom());
                pstmt.setString(2, s.getPrenom());
                pstmt.setString(3, s.getBadge());
                pstmt.setBoolean(4, s.isEstAdmin());
                pstmt.setInt(5, s.getIdentifiant());
            }
            else
            {
                pstmt = cnx.prepareStatement("DELETE FROM Salarie WHERE identifiant = ?");
                pstmt.setInt(1, s.getIdentifiant());
            }
           
            pstmt.setInt(1, s.getIdentifiant());
            pstmt.executeUpdate();  
        }
        
        catch(Exception e)
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
            
            if(cnx != null)
            {
                try 
                {
                    cnx.close();
                } 

                catch (SQLException ex) 
                {

                }
            }
        }
    }
}    

