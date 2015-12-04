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

/**
 *
 * @author Akimar
 */
public abstract class SalarieDAO {
    
    public static void getAllSalarie(Connection cnx, Vector<Salarie> vectorSalarie)
    {
        Statement stmt = null;
        try 
        {
            stmt = cnx.createStatement();       
            ResultSet rs = stmt.executeQuery("SELECT *  FROM Salarie"); 
                 
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
    
    public static int addSalarie(Connection cnx, String nom, String prenom, String badge, boolean admin)
    {

        PreparedStatement pstmt = null;
        int id = -1;
        try 
        {
            /*stmt = cnx.createStatement();       
            stmt.executeUpdate("INSERT INTO Salarie (Identifiant, Nom, Prenom, Badge, EstAdmin)  VALUES(NULL, "+nom+", "+prenom+", "+badge+", "+admin+");");  */
    
            
            pstmt = cnx.prepareStatement("INSERT INTO Salarie(Nom, Prenom, Badge, EstAdmin) VALUES(?, ?, ?, ?); ", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, badge);
            pstmt.setBoolean(4, admin);
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);    
        }
        catch (Exception ex)
        {
            System.out.println(ex.getStackTrace());
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
    
    public static void updateSalarie(Connection cnx, int identifiant, String nom, String prenom, String badge, boolean admin)
    {
        try 
        {
            PreparedStatement pstmt = null;
            
            pstmt = cnx.prepareStatement("UPDATE Salarie SET Nom = ?, Prenom = ?, Badge = ?, EstAdmin = ? where Identifiant = ?");
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, badge);
            pstmt.setBoolean(4 ,admin);
            pstmt.setInt(5,identifiant);
                  
            pstmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
     public static void deleteSalarie(Connection cnx, int identifiant)
    {
        try 
        {
            PreparedStatement pstmt = null;
            
            pstmt = cnx.prepareStatement("DELETE FROM Salarie WHERE Identifiant = ?");
            pstmt.setInt(1,identifiant);
                  
            pstmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    
}
