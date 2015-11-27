/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles;

import com.iia.gestionSalles.anubis.ServerListener;
import com.iia.gestionsalles.osiris.metier.Salarie;
import com.iia.gestionsalles.osiris.metier.Salle;
import com.iia.gestionsalles.osiris.gui.MainFrame;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author akimar
 */
public class GestionSalles {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Vector<Salle> vectorSalle = null;
        Vector<Salarie> vectorSalarie = new Vector<>();
        vectorSalarie.add(new Salarie(001, "totot", "tata", "012", true));
        vectorSalarie.add(new Salarie(001, "totot", "tata", "0123", true));
        vectorSalarie.add(new Salarie(001, "totot", "tata", "01233", true));
        vectorSalarie.add(new Salarie(001, "totot", "tata", "012333", true));
        vectorSalarie.add(new Salarie(001, "totot", "tata", "01333332", true));

        //ServerListener.initialiserServer();
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame Mf = new MainFrame();
                Mf.setVisible(true);
                Mf.setExtendedState(Mf.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });

    }

}
