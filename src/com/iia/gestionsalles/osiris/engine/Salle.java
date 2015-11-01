/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles.osiris.engine;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author akimar
 */
public class Salle {
    
    private String Nom;
    private HoraireJour[] Disponibilite; 
    private Porte[] Acces;

    public Salle(String Nom, HoraireJour[] Disponibilite, Porte[] Acces) {
        this.Nom = Nom;
        this.Disponibilite = Disponibilite;
        this.Acces = Acces;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public HoraireJour[] getDisponibilite() {
        return Disponibilite;
    }

    public void setDisponibilite(HoraireJour[] Disponibilite) {
        this.Disponibilite = Disponibilite;
    }

    public Porte[] getAcces() {
        return Acces;
    }

    public void setAcces(Porte[] Acces) {
        this.Acces = Acces;
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
        final Salle other = (Salle) obj;
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Arrays.deepEquals(this.Disponibilite, other.Disponibilite)) {
            return false;
        }
        if (!Arrays.deepEquals(this.Acces, other.Acces)) {
            return false;
        }
        return true;
    }
    
    
    
}
