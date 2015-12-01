/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

/**
 *
 * @author akimar
 */
public class Porte {
    
    private static int numero = 1;
    private boolean verrouille;

    public Porte() {
        Porte.numero = Porte.numero++;
        this.verrouille = false;
    }

    public int getNumero() {
        return numero;
    }

   

    public boolean isVerrouille() {
        return verrouille;
    }

    public void setVerrouille(boolean verrouille) {
        this.verrouille = verrouille;
    }       
}
