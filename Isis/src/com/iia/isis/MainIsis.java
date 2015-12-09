/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.isis;

import com.iia.osiris.database.BDD_Util;
import com.iia.osiris.metier.Salarie;
import com.iia.osiris.metier.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultRowSorter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Darkadok
 */
public class MainIsis extends javax.swing.JFrame {

    private Salarie NomSession;

    public Salarie getNomSession() {
        return NomSession;
    }

    public void setNomSession(Salarie NomSession) {
        this.NomSession = NomSession;
    }

    public MainIsis() {

        this.setLocation(150, 150);

        Connection cnx = null;
        Statement stmt;
        ResultSet ResultSalles = null;
        Salle tmpsalle = null;

        try {
            cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
            stmt = cnx.createStatement();
            ResultSalles = stmt.executeQuery("SELECT *  FROM Salle");
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
        initComponents();
        jSCDatePicker1.setSelectedDate(new Date());
        jSCDatePicker1.updateUI();
        this.jComboBox_Salle.removeAllItems();
        try {
            while (ResultSalles.next()) {//on ajoute les salles dans la combobox
                tmpsalle = new Salle(ResultSalles.getInt("Identifiant"), ResultSalles.getString("NumeroTerminal"), ResultSalles.getString("NomSalle"), null);
                this.jComboBox_Salle.addItem(tmpsalle);
            }
            tmpsalle = null;
            ResultSalles = null;
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }

        this.jComboBox_Salle.updateUI();

        try {
            cnx.close();
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
        jComboBox_Salle.setSelectedIndex(-1);
        cnx = null;
        stmt = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_Salle = new javax.swing.JComboBox();
        jButton_Chercher = new javax.swing.JButton();
        jButton_Supprimer = new javax.swing.JButton();
        jSCDatePicker1 = new com.javaswingcomponents.datepicker.JSCDatePicker();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Isis");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Salles :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Le", "De", "A", "Pour"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel2.setText("Date :");

        jComboBox_Salle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton_Chercher.setLabel("Chercher réservations");
        jButton_Chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChercherActionPerformed(evt);
            }
        });

        jButton_Supprimer.setLabel("Supprimer");
        jButton_Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_Salle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Chercher))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSCDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton_Supprimer)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_Salle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSCDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(jButton_Chercher))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButton_Supprimer)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jButton1.setText("Nouvelle réservation");
        jButton1.setName("NouvelleResajbutton"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(257, 257, 257))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Au click bouton nouvelle reservation
        NouvelleResa fenetre_resa = new NouvelleResa(this.getNomSession(), new javax.swing.JFrame(), true);
        fenetre_resa.setModal(false);
        fenetre_resa.setLocationRelativeTo(null);
        fenetre_resa.setVisible(true);
        jButton_ChercherActionPerformed(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_ChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChercherActionPerformed
        //Au click bouton chercher les reservations
        PreparedStatement stmt;
        ResultSet resultResa;
        Connection cnx;
        DefaultTableModel modelJtable = null;
        String[] data = new String[5];

        if (jComboBox_Salle.getSelectedIndex() > -1 && jSCDatePicker1.getSelectedDate() != null) {

            //On fait notre propre model de Jtable
            data[0] = "Le";
            data[1] = "De";
            data[2] = "A";
            data[3] = "Pour";
            data[4] = "Id";
            modelJtable = new DefaultTableModel(data, 0);
            jTable1.setModel(modelJtable);

            jTable1.removeColumn(jTable1.getColumnModel().getColumn(4));//pour avoir l'id d'accessible mais pas visible
            try {
                cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                stmt = cnx.prepareStatement("SELECT * FROM reservation INNER JOIN salarie ON Salarie.Identifiant = reservation.IdentifiantSalarie WHERE DateRes = ? AND IdentifiantSalle = ? ;");
                stmt.setDate(1, new java.sql.Date(jSCDatePicker1.getSelectedDate().getTime()));
                stmt.setInt(2, ((Salle) jComboBox_Salle.getSelectedItem()).getIdentifiant());
                resultResa = stmt.executeQuery();
                while (resultResa.next()) {
                    data[0] = resultResa.getString("DateRes");
                    data[1] = resultResa.getString("HoraireDeb");
                    data[2] = resultResa.getString("HoraireFin");
                    data[3] = resultResa.getString("Nom") + " " + resultResa.getString("Prenom");
                    data[4] = resultResa.getString("Identifiant");
                    modelJtable.addRow(data);//on ajoute chaque ligne  de Resa de la base dans le Jtable
                }
                jTable1.setAutoCreateRowSorter(true);//On les organise...
                DefaultRowSorter sorter = ((DefaultRowSorter) jTable1.getRowSorter());
                ArrayList list = new ArrayList();
                list.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));//..par la colonne 2
                sorter.setSortKeys(list);
                sorter.sort();
            } catch (Exception ex) {
                Logger.getLogger(MainIsis.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton_ChercherActionPerformed

    private void jButton_SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SupprimerActionPerformed
        //supprimer une reservation si on en est l'auteur
        PreparedStatement stmt;
        Connection cnx;
        if (jTable1.getSelectedRowCount() != 1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne", "Attention !", 2);
        } else {
            if (!((this.getNomSession().getNom() + " " + this.getNomSession().getPrenom()).equals(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3)))) {
                javax.swing.JOptionPane.showMessageDialog(null, "Vous devez être le responsable de la réservation pour pouvoir la supprimer", "Attention !", 2);
            } else {
                try {
                    cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                    stmt = cnx.prepareStatement("DELETE FROM reservation WHERE Identifiant = ?");
                    stmt.setInt(1, Integer.parseInt((String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4)));
                    stmt.executeUpdate();
                    javax.swing.JOptionPane.showMessageDialog(null, "Supprimé avec succès", "Information", 1);
                    stmt = null;
                    cnx.close();
                } catch (Exception ex) {
                    Logger.getLogger(MainIsis.class.getName()).log(Level.SEVERE, null, ex);
                }
                jButton_ChercherActionPerformed(null);//actualisation de la Jtable
            }
        }
    }//GEN-LAST:event_jButton_SupprimerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//fenetre d'authentification à l'ouverture
        Authentification authentification = new Authentification(new javax.swing.JFrame(), true);
        authentification.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        authentification.setModal(true);
        authentification.setLocationRelativeTo(null);
        authentification.setVisible(true);
        this.setNomSession(authentification.getSalarie());
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainIsis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainIsis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Chercher;
    private javax.swing.JButton jButton_Supprimer;
    private javax.swing.JComboBox jComboBox_Salle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private com.javaswingcomponents.datepicker.JSCDatePicker jSCDatePicker1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
