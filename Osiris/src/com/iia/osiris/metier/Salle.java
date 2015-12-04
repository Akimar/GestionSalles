/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author akimar
 */
public class Salle {
    
    private int Identifiant;
    private String NumeroTerminal;
    private String Nom;
    private HoraireJour[] Disponibilite; 


    public Salle(int Identifiant, String NumeroTerminal, String Nom, HoraireJour[] Disponibilite) {
        this.Identifiant = Identifiant;
        this.NumeroTerminal = NumeroTerminal;
        this.Nom = Nom;
        this.Disponibilite = Disponibilite;
    }

    public int getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(int Identifiant) {
        this.Identifiant = Identifiant;
    }

    public String getNumeroTerminal() {
        return NumeroTerminal;
    }

    public void setNumeroTerminal(String NumeroTerminal) {
        this.NumeroTerminal = NumeroTerminal;
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


    @Override
    public int hashCode() {
        int hash = 5;
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
        if (this.Identifiant != other.Identifiant) {
            return false;
        }
        if (!Objects.equals(this.NumeroTerminal, other.NumeroTerminal)) {
            return false;
        }
       
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Arrays.deepEquals(this.Disponibilite, other.Disponibilite)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Salle{" + "Identifiant=" + Identifiant + ", NumeroTerminal=" + NumeroTerminal + ", Nom=" + Nom + ", Disponibilite=" + Disponibilite + '}';
    }

   

 
    
    
    
}
