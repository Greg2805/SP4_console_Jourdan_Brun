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
    private int nombreDesintegrateurs;
    
    public void Joueur (){
    
        nom="Matthieuuuuuuuuuuuu";
        couleur="couleur";
    }
    
    public void affecterCouleur(String clr_s){
        couleur=clr_s;
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
    
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs +=1;
    }
    
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs -=1;
    }
}
