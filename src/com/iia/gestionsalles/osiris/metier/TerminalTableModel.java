/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles.osiris.metier;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akimar
 */
public class TerminalTableModel extends DefaultTableModel {
    
    private String[] columns = new String[] { "Nom", "Prenom", "Age", "Admin", "" };
    private Class[] classs = new Class[] { String.class, String.class, Integer.class, Boolean.class, String.class };
    private boolean[] editables = new boolean[] { true, true, true, false, false };

    public TerminalTableModel() {
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
    
}
