/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_jourdan_brun;

import java.util.ArrayList;

/**
 *
 * @author grego
 */
public class Joueur {
    
    private String nom;
    private String couleur;
    private ArrayList<Jeton> reserveJetons;
    
    
    public void Joueur (){
    
        nom="nom joueur pas enccore entré";
        couleur="couleur non initialisée";
    }
    
    
    public void affecterCouleur(String clr_s){
        couleur=clr_s;
    }
    
    public String donnerCouleur(){
        return couleur;
    }
    
    
    public int nombreDeJetons(){
        int taille = reserveJetons.size();
        return taille;
    }
    
    
    public void ajouterJeton(Jeton ajout){
        reserveJetons.add(ajout);
    }
    
    
    public Jeton jouerJeton (){
        int a = nombreDeJetons();
        Jeton j = reserveJetons.remove(a);
        return j;
    }
   
    
}

