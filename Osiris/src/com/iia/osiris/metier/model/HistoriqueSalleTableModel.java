/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier.model;

import com.iia.osiris.database.BDD_Util;

import com.iia.osiris.database.SalleDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akimar
 */
public  class HistoriqueSalleTableModel extends DefaultTableModel {
    
    private String[] columns = new String[] {"Nom", "Prénom", "Badge", "Administrateur",  "Date", "Heure", "Autorisé"};
    private Class[] classs = new Class[] { String.class, String.class, String.class, Boolean.class, String.class, String.class, Boolean.class};
    private boolean[] editables = new boolean[] {false, false, false, false, false, false, false};

    public HistoriqueSalleTableModel() {
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
    
    public void fillTable(int idSalle)// remplit le TableModel avec les accès à la salle
    {
        String [][] acces = null;
        Connection cnx = null;
        try
        {
           cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
           
           acces = SalleDAO.getSalleAccess(cnx, idSalle);// remplit le TableModel avec les accès à la salle
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
            JOptionPane.showMessageDialog(null, "Aucun accès n'est enregistré pour cette salle ou ce terminal.");
        }
        
        else
        {
            for(int i = 0; i< acces.length; i++)
            {
             this.addRow(new Object[] {acces[i][0], acces[i][1], acces[i][2], Boolean.parseBoolean(acces[i][3]),  acces[i][4], acces[i][5], Boolean.parseBoolean(acces[i][6])}); 
            } 
        }
    }
    
    public static String changeDateFormat(String date, boolean mysqlFormat)//change le format de la date de 'YYYY-mm-dd' vers 'dd/mm/yyyy' et vice versa
    {
       
        if(mysqlFormat)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            
            String jour = date.substring(8);
            String mois = date.substring(5, 7);
            String annee = date.substring(0, 4);
            
            date = jour+"/"+mois+"/"+annee;
        }
        
        else
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            String jour = date.substring(0, 2);
            String mois = date.substring(3, 5);
            String annee = date.substring(7);
            
            date = annee+"-"+mois+"-"+jour;
        }
       return date;  
    }
}
