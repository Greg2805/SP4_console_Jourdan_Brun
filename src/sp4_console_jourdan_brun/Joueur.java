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
    
    public String nom;
    public String couleur;
    private ArrayList<Jeton> reserveJetons;
    private int nombreDesintegrateurs;
    
    
    
    public Joueur (String n_j){
    
        nom=n_j;
        couleur="couleur non initialisée";
        reserveJetons=new ArrayList();
    }
    
    public void donnerNom(String n_j){
        nom=n_j;
    }
    
    public String retournerNom(){
        return nom;
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
        
        Jeton j = reserveJetons.remove(0);
        return j;
    }


    
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs +=1;
    }
    public int nombreDesintegrateur(){
        return nombreDesintegrateurs;
    }
    
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs -=1;
        
    }

   
    


}

