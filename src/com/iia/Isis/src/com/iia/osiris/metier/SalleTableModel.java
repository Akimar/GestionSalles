/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import com.iia.osiris.metier.Salle;

/**
 *
 * @author Akimar
 */
public class SalleTableModel extends DefaultTableModel {
    
    private String[] columns = new String[] {"Nom", "Disponibilités", "Réservations"};
    private Class[] classs = new Class[] { String.class, String.class, String.class};
    private boolean[] editables = new boolean[] { false, false, true, false, false };

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
    
    public void fillTable(Vector<Salle> vectorSalle)
    {
        for(Salle salle : vectorSalle)
        {
            this.addRow(new Object[] { salle.getNom(), "Liste des disponibilités", "Liste des réservations"}); 
        }
    }
}
