/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles.osiris.database;

import com.iia.gestionsalles.osiris.engine.Terminal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author akimar
 */
public abstract class InitProgramme {
    
    public static void initTerminal(Vector<Terminal> vectorTerminal)
    {
        
        Statement stmt = null;
    
        try 
        {
            ResultSet rs = stmt.executeQuery("SELECT *  FROM Terminal"); 
                 
            while(rs.next())
            {
               
            }  
        } 

        catch (SQLException ex)
        {
            ex.printStackTrace();
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
