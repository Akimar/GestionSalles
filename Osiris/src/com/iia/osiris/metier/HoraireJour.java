/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author akimar
 */
public class HoraireJour {
   
   int Identifiant;
   private String Jour;
   private Time HeureDebMatin;
   private Time HeureFinMatin;
   private Time HeureDebSoir;
   private Time HeureFinSoir;

    public HoraireJour(int Identifiant, String Jour, Time HeureDebMatin, Time HeureFinMatin, Time HeureDebSoir, Time HeureFinSoir) {
        this.Identifiant = Identifiant;
        this.Jour = Jour;
        this.HeureDebMatin = HeureDebMatin;
        this.HeureFinMatin = HeureFinMatin;
        this.HeureDebSoir = HeureDebSoir;
        this.HeureFinSoir = HeureFinSoir;
    }

    public int getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(int Identifiant) {
        this.Identifiant = Identifiant;
    }

    public String getJour() {
        return Jour;
    }

    public void setJour(String Jour) {
        this.Jour = Jour;
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

  

    
}
