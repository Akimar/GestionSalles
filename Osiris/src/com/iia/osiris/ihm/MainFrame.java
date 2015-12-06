/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.ihm;
import com.iia.osiris.database.BDD_Util;
import com.iia.osiris.database.SalarieDAO;
import com.iia.osiris.database.SalleDAO;
import com.iia.osiris.metier.Salle;
import com.iia.osiris.metier.Salarie;
import com.iia.osiris.metier.SalarieTableModel;
import com.iia.osiris.metier.SalleTableModel;
import com.iia.osiris.metier.TerminalTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;


/**
 *
 * @author Akimar
 */
public class MainFrame extends javax.swing.JFrame {

    private Vector<Salle>vectorSalle;

   
    private Vector<Salarie> vectorSalarie;
    
    private SalleTableModel salleTableModel;
    private SalarieTableModel salarieTableModel;
    private TerminalTableModel terminalTableModel;
    private int indexTableModel; // permet de savoir quel TableModel est utilisé (getModel renvoie une chaine difficilement exploitable)
    // -1 par défaut, 0 pour SalleTableModel, 1 pour SalarieTableModel, 2 pour TerminalTableModel
    /**
     * Creates new form MainFrame
     */
    public MainFrame() 
    {
        initComponents();
        
        vectorSalle = new Vector<Salle>();
        vectorSalarie = new Vector<Salarie>();
        
        buttonMod.setEnabled(false);
        buttonDel.setEnabled(false);
        listDisponibiliteButton.setEnabled(false);
        listDisponibiliteButton.setVisible(false);
        listeAccesButton.setEnabled(false);
        listReservationButton.setEnabled(false);
        buttonAdd.setEnabled(false);
        myTable.setSelectionMode(SINGLE_SELECTION);
        
 
       
        
        
        
        try
        {
           Connection cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
           
           SalarieDAO.getAllSalarie(cnx, vectorSalarie);
           SalleDAO.getAllSalle(cnx, vectorSalle);
           
           cnx.close();
           
           cnx = null;
        }
       
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
        salleTableModel = new SalleTableModel();
        salleTableModel.fillTable(vectorSalle);
        
        salarieTableModel = new SalarieTableModel();
        salarieTableModel.fillTable(vectorSalarie);
        
        terminalTableModel = new TerminalTableModel();
        terminalTableModel.fillTable(vectorSalle);
        myTable.setModel(terminalTableModel);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButtonTab = new javax.swing.JPanel();
        boutonTerminal = new javax.swing.JButton();
        boutonSalles = new javax.swing.JButton();
        boutonSalarie = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        panelOptions = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        buttonMod = new javax.swing.JButton();
        buttonDel = new javax.swing.JButton();
        panelListe = new javax.swing.JPanel();
        listeAccesButton = new javax.swing.JButton();
        listReservationButton = new javax.swing.JButton();
        listDisponibiliteButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Osiris");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panelButtonTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        boutonTerminal.setText("Terminaux");
        boutonTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonTerminalActionPerformed(evt);
            }
        });

        boutonSalles.setText("Salles");
        boutonSalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSallesActionPerformed(evt);
            }
        });

        boutonSalarie.setText("Salariés");
        boutonSalarie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSalarieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonTabLayout = new javax.swing.GroupLayout(panelButtonTab);
        panelButtonTab.setLayout(panelButtonTabLayout);
        panelButtonTabLayout.setHorizontalGroup(
            panelButtonTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonTabLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelButtonTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonTerminal)
                    .addComponent(boutonSalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonSalarie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelButtonTabLayout.setVerticalGroup(
            panelButtonTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonTabLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(boutonTerminal)
                .addGap(70, 70, 70)
                .addComponent(boutonSalles)
                .addGap(70, 70, 70)
                .addComponent(boutonSalarie)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        boutonTerminal.getAccessibleContext().setAccessibleName("b_salle");

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        myTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                myTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                myTableFocusLost(evt);
            }
        });
        scrollPane.setViewportView(myTable);

        panelOptions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonAdd.setText("Ajouter");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonMod.setText("Modifier");
        buttonMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonModMouseReleased(evt);
            }
        });

        buttonDel.setText("Supprimer");
        buttonDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonDelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelOptionsLayout = new javax.swing.GroupLayout(panelOptions);
        panelOptions.setLayout(panelOptionsLayout);
        panelOptionsLayout.setHorizontalGroup(
            panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelOptionsLayout.setVerticalGroup(
            panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionsLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(buttonAdd)
                .addGap(70, 70, 70)
                .addComponent(buttonMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(buttonDel)
                .addGap(43, 43, 43))
        );

        listeAccesButton.setText("Liste des accès");
        listeAccesButton.setMaximumSize(new java.awt.Dimension(137, 23));
        listeAccesButton.setMinimumSize(new java.awt.Dimension(137, 23));
        listeAccesButton.setPreferredSize(new java.awt.Dimension(137, 23));
        listeAccesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listeAccesButtonMouseReleased(evt);
            }
        });

        listReservationButton.setText("Liste des réservations");

        listDisponibiliteButton.setText("Liste des disponibilités");
        listDisponibiliteButton.setToolTipText("");
        listDisponibiliteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listDisponibiliteButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelListeLayout = new javax.swing.GroupLayout(panelListe);
        panelListe.setLayout(panelListeLayout);
        panelListeLayout.setHorizontalGroup(
            panelListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listDisponibiliteButton)
                .addGap(46, 46, 46)
                .addComponent(listeAccesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(listReservationButton)
                .addContainerGap())
        );
        panelListeLayout.setVerticalGroup(
            panelListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listeAccesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listReservationButton)
                    .addComponent(listDisponibiliteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Fichier");

        jMenuItem2.setText("Quitter");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuQuitterMouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuBar.add(jMenu1);

        jMenu2.setText("Aide");
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelButtonTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelListe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87)
                .addComponent(panelOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelButtonTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelListe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        panelButtonTab.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame Mf = new MainFrame();
                Mf.setLocationRelativeTo(null);
                Mf.setVisible(true);
            }
        });
    }
    private void MenuQuitterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuQuitterMouseReleased
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_MenuQuitterMouseReleased

    private void boutonSalarieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSalarieActionPerformed
        // TODO add your handling code here:
        
        myTable.setModel(salarieTableModel);
        indexTableModel = 1;
        buttonAdd.setEnabled(true);
        
        if(myTable.getColumnCount() == 5)
        {
            myTable.removeColumn(myTable.getColumnModel().getColumn(0));
        }
        
        
       
    }//GEN-LAST:event_boutonSalarieActionPerformed

    private void boutonTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonTerminalActionPerformed
        // TODO add your handling code here:
        
        if(buttonAdd.isEnabled())
        {
            buttonAdd.setEnabled(false);
        }
        
        myTable.setModel(terminalTableModel);
        indexTableModel = 2;
        
        if(myTable.getColumnCount() == 3)
        {
            myTable.removeColumn(myTable.getColumnModel().getColumn(0));
        }
    }//GEN-LAST:event_boutonTerminalActionPerformed

    private void boutonSallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSallesActionPerformed
        // TODO add your handling code here:
        
        if(buttonAdd.isEnabled())
        {
            buttonAdd.setEnabled(false);
        }
        
        myTable.setModel(salleTableModel);
        indexTableModel = 3;
        
        if(myTable.getColumnCount() == 3)
        {
            myTable.removeColumn(myTable.getColumnModel().getColumn(0));
        }
    }//GEN-LAST:event_boutonSallesActionPerformed

    private void myTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_myTableFocusGained
        // TODO add your handling code here:
        
        if(indexTableModel == 1)
        {
            buttonDel.setEnabled(true);
        }
        
          if(indexTableModel == 3)
        {
            listDisponibiliteButton.setVisible(true);
            listDisponibiliteButton.setEnabled(true);
        }
        
        
        buttonMod.setEnabled(true);
        listeAccesButton.setEnabled(true);
        listReservationButton.setEnabled(true);
    }//GEN-LAST:event_myTableFocusGained

    private void myTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_myTableFocusLost
        // TODO add your handling code here:
        
        buttonMod.setEnabled(false);
        buttonDel.setEnabled(false);
        listeAccesButton.setEnabled(false);
        listReservationButton.setEnabled(false);
        
        if(listDisponibiliteButton.isVisible())
        {
           listDisponibiliteButton.setVisible(false);
           listDisponibiliteButton.setEnabled(false); 
        }     
    }//GEN-LAST:event_myTableFocusLost

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
        
        
        if(indexTableModel == 1)
        {
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
            java.util.logging.Logger.getLogger(AjoutSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

          /* Create and display the dialog */

            JDialog ajoutSalarie = new AjoutSalarie(new javax.swing.JFrame(), true, vectorSalarie);
            ajoutSalarie.setModal(true);
            ajoutSalarie.setLocationRelativeTo(null);
            ajoutSalarie.setVisible(true);
            salarieTableModel.fillTable(vectorSalarie);
            myTable.setModel(salarieTableModel);
        }  
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonModMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModMouseReleased
        // TODO add your handling code here:
        
          
          
          if(indexTableModel == 1)
        {
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
            java.util.logging.Logger.getLogger(ModifierSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
            /* Create and display the form */
        
            JDialog modifierSalarie = new ModifierSalarie(new javax.swing.JFrame(), true, vectorSalarie, vectorSalarie.indexOf(vectorSalarie.elementAt(myTable.getSelectedRow())));
            modifierSalarie.setModal(true);
            modifierSalarie.setLocationRelativeTo(null);
            modifierSalarie.setVisible(true);
            salarieTableModel.fillTable(vectorSalarie);
            myTable.setModel(salarieTableModel);
        }  
    }//GEN-LAST:event_buttonModMouseReleased

    private void buttonDelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDelMouseReleased
        // TODO add your handling code here:
        
        Connection cnx=null;
        int reponse = JOptionPane.showConfirmDialog(null, "Attention !\nLa suppression du salarié supprimera également ses réservations et l'historique de ses accès.\nVoulez-vous continuer ?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(reponse == JOptionPane.YES_OPTION)
        {
             try 
                {
                    cnx = BDD_Util.open("root", "formation", "localhost", "GestionSalles");
                    SalarieDAO.deleteSalarie(cnx, vectorSalarie.elementAt(myTable.getSelectedRow()).getIdentifiant());
                    vectorSalarie.removeElementAt(vectorSalarie.indexOf(vectorSalarie.elementAt(myTable.getSelectedRow())));
                    
                    JOptionPane.showMessageDialog(null, "Le salarié a été supprimé.");
                } 
                catch (Exception ex) 
                {
            
                    JOptionPane.showMessageDialog(null, "Une erreur s'est produite, la suppression a échoué.");
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
                    salarieTableModel.fillTable(vectorSalarie);
                    myTable.setModel(salarieTableModel);
                }
        }
    }//GEN-LAST:event_buttonDelMouseReleased

    private void listeAccesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeAccesButtonMouseReleased
        // TODO add your handling code here:
        
        if(indexTableModel == 1)
        {
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
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              AccesFrame accesFrame =  new AccesFrame(indexTableModel, vectorSalarie.elementAt(myTable.getSelectedRow()).getIdentifiant());

              accesFrame.setLocationRelativeTo(null);
              accesFrame.setVisible(true);
            }
          });
        }
        
        else
        {
            
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
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(AccesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              AccesFrame accesFrame =  new AccesFrame(indexTableModel, vectorSalle.elementAt(myTable.getSelectedRow()).getIdentifiant());
              accesFrame.setLocationRelativeTo(null);
              accesFrame.setVisible(true);
            }
          });
        }
         
        
          
    }//GEN-LAST:event_listeAccesButtonMouseReleased

    private void listDisponibiliteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponibiliteButtonMouseReleased
        // TODO add your handling code here:
        
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
            java.util.logging.Logger.getLogger(DisponibiliteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisponibiliteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisponibiliteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisponibiliteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               DisponibiliteFrame disponibiliteSalle =  new DisponibiliteFrame(vectorSalle.elementAt(myTable.getSelectedRow()).getDisponibilite(), vectorSalle.elementAt(myTable.getSelectedRow()).getIdentifiant());
               disponibiliteSalle.setLocationRelativeTo(null);
               disponibiliteSalle.setVisible(true);
            }
        });
        
    }//GEN-LAST:event_listDisponibiliteButtonMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonSalarie;
    private javax.swing.JButton boutonSalles;
    private javax.swing.JButton boutonTerminal;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDel;
    private javax.swing.JButton buttonMod;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton listDisponibiliteButton;
    private javax.swing.JButton listReservationButton;
    private javax.swing.JButton listeAccesButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable myTable;
    private javax.swing.JPanel panelButtonTab;
    private javax.swing.JPanel panelListe;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
