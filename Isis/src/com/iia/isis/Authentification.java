package com.iia.isis;

import com.iia.osiris.database.AuthentificationDAO;
import com.iia.osiris.database.BDD_Util;
import com.iia.osiris.metier.Salarie;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akimar
 */
public class Authentification extends javax.swing.JDialog {

    private Salarie _Salarie;
    /**
     * Creates new form Authentification
     */
    public Authentification(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Salarie getSalarie() {
        return _Salarie;
    }

    public void setSalarie(Salarie Salarie) {
        this._Salarie = Salarie;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titreLabel = new javax.swing.JLabel();
        authPanel = new javax.swing.JPanel();
        badgeLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        badgeField = new javax.swing.JTextField();
        mdpField = new javax.swing.JPasswordField();
        buttonPanel = new javax.swing.JPanel();
        validerButton = new javax.swing.JButton();
        annulerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        titreLabel.setText("Authentification");

        authPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        badgeLabel.setText("Numéro du badge : ");

        passLabel.setText("Mot de passe  : ");

        badgeField.setMaximumSize(new java.awt.Dimension(59, 20));
        badgeField.setMinimumSize(new java.awt.Dimension(59, 20));

        mdpField.setMaximumSize(new java.awt.Dimension(111, 20));
        mdpField.setMinimumSize(new java.awt.Dimension(111, 20));

        javax.swing.GroupLayout authPanelLayout = new javax.swing.GroupLayout(authPanel);
        authPanel.setLayout(authPanelLayout);
        authPanelLayout.setHorizontalGroup(
            authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(badgeLabel)
                    .addComponent(passLabel))
                .addGap(34, 34, 34)
                .addGroup(authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(badgeField, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(mdpField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        authPanelLayout.setVerticalGroup(
            authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(badgeLabel)
                    .addComponent(badgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(authPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(mdpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        validerButton.setText("Connexion");
        validerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerButtonActionPerformed(evt);
            }
        });

        annulerButton.setText("Annuler");
        annulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(validerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(annulerButton)
                .addGap(39, 39, 39))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validerButton)
                    .addComponent(annulerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titreLabel)
                .addGap(228, 228, 228))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreLabel)
                .addGap(18, 18, 18)
                .addComponent(authPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerButtonActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_annulerButtonActionPerformed

    private void validerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerButtonActionPerformed

        if(badgeField.getText().isEmpty() || String.valueOf(mdpField.getPassword()).isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Veuillez saisir votre numéro de badge ainsi que votre mot de passe.");         
        }
        
        else
        {
            Salarie auth = null ;
            Connection cnx = null;
           
            try 
            {
                cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                auth = AuthentificationDAO.authenticator(cnx, badgeField.getText(), String.valueOf(mdpField.getPassword()));
            } 
            
            catch (Exception ex) 
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
                    
                    if(auth != null)
                    {
                        setSalarie(auth);
                        this.setVisible(false);
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Numéro de badge ou mot de passe incorrects.");
                    }
                }
        }
    }//GEN-LAST:event_validerButtonActionPerformed

  
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annulerButton;
    private javax.swing.JPanel authPanel;
    private javax.swing.JTextField badgeField;
    private javax.swing.JLabel badgeLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPasswordField mdpField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel titreLabel;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables
}
