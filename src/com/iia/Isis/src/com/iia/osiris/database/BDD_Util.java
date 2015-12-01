/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author akimar
 */
public class BDD_Util {
    
    public static Connection open(String user, String password, String server, String database) throws Exception
    {
       
        Connection  cnx = null;
        String url;
        
        url = "jdbc:mysql://"+server+"/"+database;
   
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          
          cnx = DriverManager.getConnection(url, user, password);
          
        }
        
        catch(SQLException ex)
        {
             ex.printStackTrace();
        }
        
        return cnx;
    }
    
    
    public static void close(Connection cnx)
    {
        if(cnx != null)
        {
            try
           {
                cnx.close();
            }
                
            catch(SQLException ex)
            {
                            
            }
        }
    }
    
    
}
