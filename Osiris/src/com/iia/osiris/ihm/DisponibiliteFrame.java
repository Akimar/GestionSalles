/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.ihm;

import com.iia.osiris.database.BDD_Util;
import com.iia.osiris.database.SalleDAO;
import com.iia.osiris.metier.HoraireJour;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Akimar
 */
public class DisponibiliteFrame extends javax.swing.JDialog {

    private HoraireJour[] Disponibilite;
    private int Identfiant;
    /**
     * Creates new form DisponibiliteFrame
     */
    public DisponibiliteFrame(java.awt.Frame parent, boolean modal, HoraireJour[] dispo, int idSalle) {
        super(parent, modal);
        initComponents();
        
        Disponibilite = dispo;
        Identfiant = idSalle;
        
        changeTime(); // met à jour l'affiche avec les dipos de la salle présentes dans le vector
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
        joursComboBox = new javax.swing.JComboBox();
        dispoPanel = new javax.swing.JPanel();
        matinLabel = new javax.swing.JLabel();
        soirLabel = new javax.swing.JLabel();
        Date dateMatDeb = new Date();
        SpinnerDateModel smMatDeb =
        new SpinnerDateModel(dateMatDeb, null, null, Calendar.HOUR_OF_DAY);
        horaireMatDebSpinner = new javax.swing.JSpinner(smMatDeb);
        Date dateSoirDeb = new Date();
        SpinnerDateModel smSoirDeb =
        new SpinnerDateModel(dateSoirDeb, null, null, Calendar.HOUR_OF_DAY);
        horaireSoirDebSpinner = new javax.swing.JSpinner(smSoirDeb);
        Date dateMatFin = new Date();
        SpinnerDateModel smMatFin =
        new SpinnerDateModel(dateMatFin, null, null, Calendar.HOUR_OF_DAY);
        horaireMatFinSpinner = new javax.swing.JSpinner(smMatFin);
        Date dateSoirFin = new Date();
        SpinnerDateModel smSoirFin =
        new SpinnerDateModel(dateSoirFin, null, null, Calendar.HOUR_OF_DAY);
        horaireSoirFinSpinner = new javax.swing.JSpinner(smSoirFin);
        textLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titreLabel.setText("Disponibilités");
        titreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        joursComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche" }));
        joursComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joursComboBoxActionPerformed(evt);
            }
        });

        matinLabel.setText("Matin : ");

        soirLabel.setText("Après-midi : ");

        JSpinner.DateEditor deMatDeb = new JSpinner.DateEditor(horaireMatDebSpinner, "HH:mm:ss");
        horaireMatDebSpinner.setEditor(deMatDeb);

        JSpinner.DateEditor deSoirDeb = new JSpinner.DateEditor(horaireSoirDebSpinner, "HH:mm:ss");
        horaireSoirDebSpinner.setEditor(deSoirDeb);

        JSpinner.DateEditor deMatFin = new JSpinner.DateEditor(horaireMatFinSpinner, "HH:mm:ss");
        horaireMatFinSpinner.setEditor(deMatFin);

        JSpinner.DateEditor deSoirFin = new JSpinner.DateEditor(horaireSoirFinSpinner, "HH:mm:ss");
        horaireSoirFinSpinner.setEditor(deSoirFin);

        javax.swing.GroupLayout dispoPanelLayout = new javax.swing.GroupLayout(dispoPanel);
        dispoPanel.setLayout(dispoPanelLayout);
        dispoPanelLayout.setHorizontalGroup(
            dispoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispoPanelLayout.createSequentialGroup()
                .addGroup(dispoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dispoPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(matinLabel)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dispoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(soirLabel)
                        .addGap(18, 18, 18)))
                .addGroup(dispoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(horaireMatDebSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(horaireSoirDebSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(dispoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(horaireMatFinSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(horaireSoirFinSpinner))
                .addGap(43, 43, 43))
        );
        dispoPanelLayout.setVerticalGroup(
            dispoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dispoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matinLabel)
                    .addComponent(horaireMatDebSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horaireMatFinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(dispoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soirLabel)
                    .addComponent(horaireSoirDebSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horaireSoirFinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        textLabel.setText("Une salle est indisponible pour la journée si tous ses horaires sont à 00:00:00.");

        saveButton.setText("Sauvegarder");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Annuler");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton))
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(titreLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(joursComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dispoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textLabel)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreLabel)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joursComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dispoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textLabel)
                .addGap(41, 41, 41)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void joursComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joursComboBoxActionPerformed
        // TODO add your handling code here:
        
        changeTime(); // met à jour l'affiche avec les dipos de la salle présentes dans le vector
    }//GEN-LAST:event_joursComboBoxActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
 

        Connection cnx =null;
        int reponse = JOptionPane.showConfirmDialog(null, "Attention !\nLa modification des horaires supprimera les réservations dont les horaires ne correspondent plus.\nVoulez-vous continuer ?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(reponse == JOptionPane.YES_OPTION)
        { 

            // on recherche avec l'heure dans ce qui est retourné par getValue()
            Pattern p = Pattern.compile("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]");
            Matcher matcherDebMat = p.matcher(horaireMatDebSpinner.getValue().toString());
            Matcher matcherFinMat = p.matcher(horaireMatFinSpinner.getValue().toString());
            Matcher matcherDebSoir = p.matcher(horaireSoirDebSpinner.getValue().toString());
            Matcher matcherFinSoir = p.matcher(horaireSoirFinSpinner.getValue().toString());

            if (matcherDebMat.find() && matcherDebSoir.find() && matcherFinMat.find() && matcherFinSoir.find()) // extraction de l'heure via la regex
            {
                try 
                {
                    int i = 0;
                    boolean trouve = false;
                    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                
                    Time horaireMatDeb =new Time((formatter.parse(matcherDebMat.group()).getTime()));// get de l'heure afin de d'instancier des java.sql.Time
                    Time horaireMatFin = new Time((formatter.parse(matcherFinMat.group()).getTime())); 
                    Time horaireSoirDeb = new Time((formatter.parse(matcherDebSoir.group()).getTime())); 
                    Time horaireSoirFin = new Time((formatter.parse(matcherFinSoir.group()).getTime())); 
                  

                    cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                    SalleDAO.updateDispo(cnx, joursComboBox.getSelectedItem().toString(), horaireMatDeb, horaireMatFin, horaireSoirDeb, horaireSoirFin);
                    
                   while(i < Disponibilite.length && !trouve)// on parcourt les disponibilités en mémoire correspondant à la salle
                   {
                       if(Disponibilite[i].getJour().equals(joursComboBox.getSelectedItem().toString()))// quand le bpn jour est trouvé, mise à jour des créneaux en mémoire
                       {
                           Disponibilite[i].setHeureDebMatin(horaireMatDeb);
                           Disponibilite[i].setHeureDebSoir(horaireSoirDeb);
                           Disponibilite[i].setHeureFinMatin(horaireMatFin);
                           Disponibilite[i].setHeureFinSoir(horaireSoirFin);
                           
                           trouve = true;
                       }
                       
                       i++;
                   }
                   

                    JOptionPane.showMessageDialog(null, "Les modifications ont été enregistrées.");

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
                }
            }
        }   
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    
    public void changeTime()// met à jour l'affichage avec les infos contenus dans les dispos d'une salle
    {
        int i = 0;
        boolean ok = false;
        
    
        while(i < Disponibilite.length && !ok)
        {
            if(joursComboBox.getSelectedItem().toString().equals(Disponibilite[i].getJour()))
            {
                ok = true;
                
                horaireMatDebSpinner.setValue(Disponibilite[i].getHeureDebMatin());
                horaireMatFinSpinner.setValue(Disponibilite[i].getHeureFinMatin());
                horaireSoirDebSpinner.setValue(Disponibilite[i].getHeureDebSoir());
                horaireSoirFinSpinner.setValue(Disponibilite[i].getHeureFinSoir());
            }
            
            i++;
        }
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel dispoPanel;
    private javax.swing.JSpinner horaireMatDebSpinner;
    private javax.swing.JSpinner horaireMatFinSpinner;
    private javax.swing.JSpinner horaireSoirDebSpinner;
    private javax.swing.JSpinner horaireSoirFinSpinner;
    private javax.swing.JComboBox joursComboBox;
    private javax.swing.JLabel matinLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel soirLabel;
    private javax.swing.JLabel textLabel;
    private javax.swing.JLabel titreLabel;
    // End of variables declaration//GEN-END:variables
}
