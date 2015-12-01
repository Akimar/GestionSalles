/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.gestionsalles.osiris.metier;

import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author akimar
 */
public class HoraireJour {
    
   private Time HeureDebMatin;
   private Time HeureFinMatin;
   private Time HeureDebSoir;
   private Time HeureFinSoir;

    public HoraireJour(Time HeureDebMatin, Time HeureFinMatin, Time HeureDebSoir, Time HeureFinSoir) {
        this.HeureDebMatin = HeureDebMatin;
        this.HeureFinMatin = HeureFinMatin;
        this.HeureDebSoir = HeureDebSoir;
        this.HeureFinSoir = HeureFinSoir;
    }

    public Time getHeureDebMatin() {
        return HeureDebMatin;
    }

    public void setHeureDebMatin(Time HeureDebMatin) {
        this.HeureDebMatin = HeureDebMatin;
    }

    public Time getHeureFinMatin() {
        return HeureFinMatin;
    }

    public void setHeureFinMatin(Time HeureFinMatin) {
        this.HeureFinMatin = HeureFinMatin;
    }

    public Time getHeureDebSoir() {
        return HeureDebSoir;
    }

    public void setHeureDebSoir(Time HeureDebSoir) {
        this.HeureDebSoir = HeureDebSoir;
    }

    public Time getHeureFinSoir() {
        return HeureFinSoir;
    }

    public void setHeureFinSoir(Time HeureFinSoir) {
        this.HeureFinSoir = HeureFinSoir;
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
        final HoraireJour other = (HoraireJour) obj;
        if (!Objects.equals(this.HeureDebMatin, other.HeureDebMatin)) {
            return false;
        }
        if (!Objects.equals(this.HeureFinMatin, other.HeureFinMatin)) {
            return false;
        }
        if (!Objects.equals(this.HeureDebSoir, other.HeureDebSoir)) {
            return false;
        }
        if (!Objects.equals(this.HeureFinSoir, other.HeureFinSoir)) {
            return false;
        }
        return true;
    }
   
    
}
