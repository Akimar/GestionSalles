/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.ihm;

import com.iia.osiris.database.BDD_Util;
import com.iia.osiris.database.SalarieDAO;
import com.iia.osiris.metier.Salarie;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Akimar
 */
public class ModifierSalarie extends javax.swing.JDialog {

    private Vector<Salarie> vectorSalarie;
    private int indexSalarie;
    /**
     * Creates new form ModifierSalarie
     */
    public ModifierSalarie(java.awt.Frame parent, boolean modal, Vector<Salarie> vS, int index) {
        super(parent, modal);
       initComponents();
       
       vectorSalarie = vS;
       indexSalarie = index ;
       
        this.nomSalarieField.setText(vectorSalarie.elementAt(indexSalarie).getNom());
        this.prenomSalarieField.setText(vectorSalarie.elementAt(indexSalarie).getPrenom());
        this.badgeSalarieField.setText(vectorSalarie.elementAt(indexSalarie).getBadge());
       
      
        
        
        if(vectorSalarie.elementAt(indexSalarie).isEstAdmin())
        {
            this.estAdminRadio.setSelected(true);
        }
        else
        {
            this.nonAdminRadio.setSelected(true);
        }
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminGroup = new javax.swing.ButtonGroup();
        buttonPanel = new javax.swing.JPanel();
        validerModSalarie = new javax.swing.JButton();
        annulerModSalarie = new javax.swing.JButton();
        ajoutSalariePanel = new javax.swing.JPanel();
        nomSalarieLabel = new javax.swing.JLabel();
        prenomSalarieLabel = new javax.swing.JLabel();
        badgeSalarieLabel = new javax.swing.JLabel();
        adminSalarieLabel = new javax.swing.JLabel();
        estAdminRadio = new javax.swing.JRadioButton();
        nonAdminRadio = new javax.swing.JRadioButton();
        nomSalarieField = new javax.swing.JTextField();
        prenomSalarieField = new javax.swing.JTextField();
        badgeSalarieField = new javax.swing.JTextField();
        mdpLabel = new javax.swing.JLabel();
        cMdpLabel = new javax.swing.JLabel();
        mdpField = new javax.swing.JPasswordField();
        cMdpField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        titreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Osiris");
        setResizable(false);

        validerModSalarie.setText("Modifier");
        validerModSalarie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerModSalarieActionPerformed(evt);
            }
        });

        annulerModSalarie.setText("Annuler");
        annulerModSalarie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerModSalarieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(validerModSalarie)
                .addGap(129, 129, 129)
                .addComponent(annulerModSalarie)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validerModSalarie)
                    .addComponent(annulerModSalarie))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nomSalarieLabel.setText("Nom : ");

        prenomSalarieLabel.setText("Prénom : ");

        badgeSalarieLabel.setText("Badge : ");

        adminSalarieLabel.setText("Administrateur : ");

        adminGroup.add(estAdminRadio);
        estAdminRadio.setText("Oui");

        adminGroup.add(nonAdminRadio);
        nonAdminRadio.setSelected(true);
        nonAdminRadio.setText("Non");

        mdpLabel.setText("Mot de passe : ");

        cMdpLabel.setText("Confirmer mot de passe : ");

        jLabel1.setText("(Si vous ne souhaitez pas modifier le mot de passe, laissez les gens associés vides.)");

        javax.swing.GroupLayout ajoutSalariePanelLayout = new javax.swing.GroupLayout(ajoutSalariePanel);
        ajoutSalariePanel.setLayout(ajoutSalariePanelLayout);
        ajoutSalariePanelLayout.setHorizontalGroup(
            ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajoutSalariePanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ajoutSalariePanelLayout.createSequentialGroup()
                        .addComponent(adminSalarieLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(estAdminRadio)
                        .addGap(64, 64, 64)
                        .addComponent(nonAdminRadio))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ajoutSalariePanelLayout.createSequentialGroup()
                        .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ajoutSalariePanelLayout.createSequentialGroup()
                                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ajoutSalariePanelLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(prenomSalarieLabel)
                                            .addComponent(nomSalarieLabel)))
                                    .addComponent(badgeSalarieLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(badgeSalarieField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prenomSalarieField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomSalarieField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ajoutSalariePanelLayout.createSequentialGroup()
                                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cMdpLabel)
                                    .addComponent(mdpLabel))
                                .addGap(32, 32, 32)
                                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mdpField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cMdpField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ajoutSalariePanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );
        ajoutSalariePanelLayout.setVerticalGroup(
            ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajoutSalariePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomSalarieLabel)
                    .addComponent(nomSalarieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomSalarieLabel)
                    .addComponent(prenomSalarieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(badgeSalarieLabel)
                    .addComponent(badgeSalarieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mdpLabel)
                    .addComponent(cMdpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cMdpLabel)
                    .addComponent(mdpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ajoutSalariePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(ajoutSalariePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estAdminRadio)
                            .addComponent(nonAdminRadio)))
                    .addGroup(ajoutSalariePanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(adminSalarieLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titreLabel.setText("Modifier les informations d'un salarié");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreLabel)
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajoutSalariePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ajoutSalariePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annulerModSalarieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerModSalarieActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_annulerModSalarieActionPerformed

    private void validerModSalarieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerModSalarieActionPerformed
        // TODO add your handling code here:
      
        // vérifie si les champs sont tous remplis
        if(nomSalarieField.getText().isEmpty() || prenomSalarieField.getText().isEmpty() || badgeSalarieField.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "Veuillez compléter tous les champs.");
        }
        
        // si un mot de passe a été entré il doit être confirmé
        else if(((mdpField.getPassword().length == 0) && (cMdpField.getPassword().length != 0)) || ((mdpField.getPassword().length != 0) && (cMdpField.getPassword().length == 0)))
        {
            JOptionPane.showMessageDialog(null, "Les deux champs du mot de passe doivent être renseignés.");
        }
        
        // vérifie que les mots de passe correspondent
         else if(!String.valueOf(mdpField.getPassword()).equals(String.valueOf(cMdpField.getPassword())))
        {
            JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas.");
        }
         
         // contrôle la longueur du mdp
         else if(mdpField.getPassword().length < 6 &&  mdpField.getPassword().length != 0)
        {
            JOptionPane.showMessageDialog(null, "Le mot de passe doit faire au minimum 6 caractères.");  
        }
      
        // contrôle les chaines saisies
        else if(!nomSalarieField.getText().matches("[a-zA-ZÀ-ÿ\\- ]+") || !prenomSalarieField.getText().matches("[a-zA-ZÀ-ÿ\\- ]+") || !badgeSalarieField.getText().matches("[A-Za-z0-9]+"))
        {
           JOptionPane.showMessageDialog(null, "Les informations contiennent des caractères non pris en compte.");
        }
        else
        {
            String ancientBadge = vectorSalarie.elementAt(indexSalarie).getBadge();
            
            
            int i = 0;
            boolean dejaPresent = false;
            
            // on recherche si le badge saisi n'est pas déjà utilisé dans le cas où il est différent de l'ancien badge du salarié
            while(i < vectorSalarie.size() && ! dejaPresent)
            {
                if(vectorSalarie.elementAt(i).badgeExists(badgeSalarieField.getText()))
                {
                    dejaPresent = true;
                }
                
                i++;
            }
            
            // le badge n'est pas utilisé ailleurs ou si il n'a pas été changé
            if(!dejaPresent || badgeSalarieField.getText().equals(ancientBadge))
            {
            
          
                boolean admin = (nonAdminRadio.isSelected()) ? false : true;
                Connection cnx=null;
                

                try 
                {

                    cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                    SalarieDAO.updateSalarie(cnx, vectorSalarie.elementAt(indexSalarie).getIdentifiant(), this.nomSalarieField.getText(), this.prenomSalarieField.getText(), this.badgeSalarieField.getText(), String.valueOf(mdpField.getPassword()), admin);// modification du salarié en base
                    
                    // modification du salarié en mémoire
                    vectorSalarie.elementAt(indexSalarie).setNom(this.nomSalarieField.getText());
                    vectorSalarie.elementAt(indexSalarie).setPrenom(this.prenomSalarieField.getText());
                    vectorSalarie.elementAt(indexSalarie).setBadge(this.badgeSalarieField.getText());
                    vectorSalarie.elementAt(indexSalarie).setEstAdmin(admin);
                    
                    JOptionPane.showMessageDialog(null, "Les informations ont été modifiées avec succès !");
                       
                } 
                catch (Exception ex) 
                {
                   ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Une erreur s'est produite, les modifications ont échoué.");
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
                            ex.printStackTrace();
                        }
                    }
                
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_validerModSalarieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup adminGroup;
    private javax.swing.JLabel adminSalarieLabel;
    private javax.swing.JPanel ajoutSalariePanel;
    private javax.swing.JButton annulerModSalarie;
    private javax.swing.JTextField badgeSalarieField;
    private javax.swing.JLabel badgeSalarieLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPasswordField cMdpField;
    private javax.swing.JLabel cMdpLabel;
    private javax.swing.JRadioButton estAdminRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField mdpField;
    private javax.swing.JLabel mdpLabel;
    private javax.swing.JTextField nomSalarieField;
    private javax.swing.JLabel nomSalarieLabel;
    private javax.swing.JRadioButton nonAdminRadio;
    private javax.swing.JTextField prenomSalarieField;
    private javax.swing.JLabel prenomSalarieLabel;
    private javax.swing.JLabel titreLabel;
    private javax.swing.JButton validerModSalarie;
    // End of variables declaration//GEN-END:variables
}
