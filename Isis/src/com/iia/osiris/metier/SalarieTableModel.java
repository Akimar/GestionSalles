/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akimar
 */
public class SalarieTableModel extends DefaultTableModel {
    
    private String[] columns = new String[] {"Identifiant", "Nom", "Prénom", "Badge", "Administrateur" };
    private Class[] classs = new Class[] {int.class, String.class, String.class, String.class, Boolean.class};
    private boolean[] editables = new boolean[] {false, false, false, false, false};

    public SalarieTableModel() {
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
    
    public void fillTable(Vector<Salarie> vectorSalarie)
    {
        
        if(this.getRowCount() > 0)
        {
            int rowCount =  this.getRowCount();
            
            for(int i = 0; i < rowCount; i++)
            {
               this.removeRow(0);
            }
         
        }
        for(Salarie salarie : vectorSalarie)
        {
            this.addRow(new Object[] {salarie.getIdentifiant(), salarie.getNom(),salarie.getPrenom(),salarie.getBadge(), salarie.isEstAdmin()}); 
        }
    }
}
