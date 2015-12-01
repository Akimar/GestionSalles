package com.iia.gestionsalles.osiris.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.iia.gestionsalles.osiris.metier.Porte;
import com.iia.gestionsalles.osiris.metier.Salarie;
import com.iia.gestionsalles.osiris.metier.Salle;
import com.iia.gestionsalles.osiris.metier.HoraireJour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


/**
 *
 * @author akimar
 */
public abstract class InitProgramme {
    
    public static void initSalle(Vector<Salle> vectorSalle)
    {
       
        Connection cnx = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
    
        try 
        {
            
            cnx =  BDD_Util.open("root", "formation", "127.0.0.1", "GestionSalles");
                 
            
            //il te manque pas un stmt = cnx.createStatement(); ?
            ResultSet rs = stmt.executeQuery("SELECT *  FROM Salle"); 
                 
            while(rs.next()) // pour chaque salle
            {
              int id  =  rs.getInt("identifiant");
              String numero_terminal = rs.getString("numero_terminal");
              String  nom_salle = rs.getString("nom_salle");
              int nb_portes = rs.getInt("nb_portes");
              
              //pour chaque salle on récupère les diponibilités
               
               pstmt = cnx.prepareStatement("SELECT * from Disponibilite INNER JOIN Jour ON Disponibilite.identifiant = Jour.dispo_jour INNER JOIN Schedule ON Jour.identifiant = Schedule.identifiant_jour WHERE Schedule.identifiant_salle = ?");
               pstmt.setInt(1, id);
               ResultSet prs = pstmt.executeQuery();  
               
               HoraireJour[] dispo = new HoraireJour[7];
               int i = 0;
               while(prs.next() && i<7)
               {
                   dispo[i] = new HoraireJour(prs.getTime("horaire_deb_matin"), prs.getTime("horaire_fin_matin"), prs.getTime("horaire_deb_soir"), prs.getTime("horaire_fin_soir"));
                   i++;
               }
               
               i = 0;
               // pour chaque salle on ajoute le nombre de portes nécessaires
               Porte[] acces = new Porte[nb_portes];
               
               while(i < nb_portes)
               {
                   acces[i] = new Porte();
                   i++;
               }
               
               vectorSalle.add(new Salle(id, numero_terminal, nom_salle, dispo, acces));
            }  
        }         
         

        catch (SQLException ex)
        {
        
        } 
        catch (Exception ex) 
        {
             ex.printStackTrace();
        }

        finally
        {
            if(stmt != null)
            {
                try
                {
                    stmt.close();
                }

                catch(SQLException ex)
                {

                }
            }
                
            if(pstmt != null)
            {
                try
                {
                    pstmt.close();
                }

                catch(SQLException ex)
                {

                }
            }
            
            if(cnx != null)
            {
                try 
                {
                    cnx.close();
                } 

                catch (SQLException ex) 
                {

                }
            }
        }
    }
    
    public static void initSalarie(Vector<Salarie> vectorSalarie)
    {
         
        Connection cnx = null;
        Statement stmt = null;
    
        try 
        {
            
            cnx =  BDD_Util.open("root", "formation", "127.0.0.1", "GestionSalles");
                  
            ResultSet rs = stmt.executeQuery("SELECT *  FROM Salle"); 
                 
            while(rs.next()) // pour chaque salle
            {
                vectorSalarie.add(new Salarie(rs.getInt("identifiant"), rs.getString("nom"), rs.getString("prenom"), rs.getString("badge"), rs.getBoolean("est_admin")));
            }
        }
        catch (Exception ex)
        {
        } 
        
        finally
        {
            if(stmt != null)
            {
                try
                {
                    stmt.close();
                }

                catch(SQLException ex)
                {

                }
            }
               
            if(cnx != null)
            {
                try 
                {
                    cnx.close();
                } 

                catch (SQLException ex) 
                {

                }
            }
        }
    }
}
