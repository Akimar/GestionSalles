/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles.osiris.engine;

/**
 *
 * @author akimar
 */
public class Porte {
    
    private int numero;
    private boolean verrouille;

    public Porte(int numero, boolean verrouille) {
        this.numero = numero;
        this.verrouille = verrouille;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isVerrouille() {
        return verrouille;
    }

    public void setVerrouille(boolean verrouille) {
        this.verrouille = verrouille;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Porte other = (Porte) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.verrouille != other.verrouille) {
            return false;
        }
        return true;
    }
    
    
    
}
