/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;


import static com.iia.osiris.ihm.Authentification.passEncrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *      
 * @author Akimar
 */
public abstract class AuthentificationDAO {
    
    public static boolean authenticator(Connection cnx, String badge, String mdp)
    {
        PreparedStatement pstmt = null;
        try 
        {
            String password = passEncrypt(String.valueOf(mdp));
           
            pstmt = cnx.prepareStatement("SELECT Nom, Prenom FROM Salarie WHERE Badge = ? AND MotDePasse = ?;");
            pstmt.setString(1, badge);
            pstmt.setString(2, mdp);
            
       
            ResultSet rs  =  pstmt.executeQuery() ;
            
            if(rs.next())
            {
              return true;  
            }
           
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
        
        return false;
    }
}
