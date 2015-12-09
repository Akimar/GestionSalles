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
            String password = Salarie.passEncrypt(String.valueOf(mdp));
           
            pstmt = cnx.prepareStatement("SELECT Identifiant FROM Salarie WHERE Badge = ? AND MotDePasse = ? AND EstAdmin = 1;");
            pstmt.setString(1, badge);
            pstmt.setString(2, password);
            
       
            ResultSet rs  =  pstmt.executeQuery() ;
            
            if(rs.next())// si un salarié correspondant au mot de passe et au badge est retourné
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
                    ex.printStackTrace();
                }
            }
        }
        
        return false;
    }
}
