/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

import com.iia.osiris.database.BDD_Util;
import com.iia.osiris.database.SalarieDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akimar
 */
public class HistoriqueSalarieTableModel extends DefaultTableModel {
    
    private String[] columns = new String[] {"Salle", "Terminal", "Date", "Heure"};
    private Class[] classs = new Class[] { String.class, String.class, String.class, String.class};
    private boolean[] editables = new boolean[] {false, false, false, false};

    public HistoriqueSalarieTableModel() {
        super(0, 0);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editables[column];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classs[columnIndex];
    } 
     
    public void fillTable(int idSalarie)
    {
        String [][] acces = null;
        Connection cnx = null;
        try
        {
           cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
           
           acces = SalarieDAO.getSalarieAccess(cnx, idSalarie);
        }
       
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        finally
        {
            if(cnx != null)
            {
                try
                {
                    cnx.close();
                    cnx = null;
                }

                catch(SQLException ex)
                {

                }
            }
        }
        
        if(acces == null)
        {
            JOptionPane.showMessageDialog(null, "Aucun accès n'est enregistré pour ce salarié.");
        }
        
        else
        {
            for(int i = 0; i< acces.length; i++)
            {
             this.addRow(new Object[] {acces[i][0], acces[i][1], acces[i][2], acces[i][3]}); 
            } 
        }
    }
    
}
