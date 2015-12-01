/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles.osiris.metier;

import java.util.Objects;

/**
 *
 * @author akimar
 */
public class Salarie {
    
    private int Identifiant;
    private String Nom;
    private String Prenom;
    private String Badge;
    private boolean EstAdmin;

    public Salarie(int Identifiant, String Nom, String Prenom, String Badge, boolean EstAdmin) {
        this.Identifiant = Identifiant;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Badge = Badge;
        this.EstAdmin = EstAdmin;
    }

    public int getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(int Identifiant) {
        this.Identifiant = Identifiant;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getBadge() {
        return Badge;
    }

    public void setBadge(String Badge) {
        this.Badge = Badge;
    }

    public boolean isEstAdmin() {
        return EstAdmin;
    }

    public void setEstAdmin(boolean EstAdmin) {
        this.EstAdmin = EstAdmin;
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
        final Salarie other = (Salarie) obj;
        if (this.Identifiant != other.Identifiant) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Prenom, other.Prenom)) {
            return false;
        }
        if (!Objects.equals(this.Badge, other.Badge)) {
            return false;
        }
        if (this.EstAdmin != other.EstAdmin) {
            return false;
        }
        return true;
    }
    
    
    
}
