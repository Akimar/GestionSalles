/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier.model;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import com.iia.osiris.metier.Salle;


/**
 *
 * @author Akimar
 */
public class SalleTableModel extends DefaultTableModel {
    
    private String[] columns = new String[] {"Nom", "Numéro du terminal"};
    private Class[] classs = new Class[] { String.class, String.class};
    private boolean[] editables = new boolean[] { false, false };

    public SalleTableModel() {
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
    
    public void fillTable(Vector<Salle> vectorSalle)// remplit le TableModel avec le contenu du vector
    {
        if(this.getRowCount() > 0)// si le TableModel contient déjà de la donnée, on efface tout pour réinsérer les données à jour du vector
        {
            int rowCount =  this.getRowCount();
            
            for(int i = 0; i < rowCount; i++)
            {
               this.removeRow(0);
            }
         
        }
         
        for(Salle salle : vectorSalle)
        {
            this.addRow(new Object[] { salle.getNom(), salle.getNumeroTerminal()}); 
        }
    }
}
