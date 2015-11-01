/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles;

import com.iia.gestionSalles.anubis.ServerListener;
<<<<<<< HEAD
import com.iia.gestionSalles.anubis.Anubis;
import com.iia.gestionsalles.osiris.engine.Salarie;
import com.iia.gestionsalles.osiris.engine.Terminal;
=======
import com.iia.gestionsalles.osiris.classes.Salarie;
import com.iia.gestionsalles.osiris.classes.Terminal;
>>>>>>> 612588bec17b78bb4d8db7cd2172d87936461958
import java.util.Vector;

/**
 *
 * @author akimar
 */
public class GestionSalles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Vector<Terminal> vectorSalarie = null;
        Vector<Salarie> vectorTerminal = null;
        ServerListener.initialiserServer();
    }
    
}
