/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.Salarie;
import java.sql.Connection;
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
    
    public static void addSalarie(Connection cnx, String nom, String prenom, String badge, boolean admin)
    {
        Statement stmt = null;
        try 
        {
            stmt = cnx.createStatement();       
            stmt.executeQuery("INSERT INTO Salarie VALUES(NULL, "+nom+", "+prenom+", "+badge+", "+admin);                
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
