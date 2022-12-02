/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_jourdan_brun;

import java.util.Random;

/**
 *
 * @author grego
 */
public class Partie {
    private Joueur [] listeJoueurs = new Joueur[2]; 
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;
    
    public void Partie(Joueur joueur1, Joueur joueur2){
        listeJoueurs [0]=joueur1;
        listeJoueurs [1]=joueur2;
    }
    
    public void attribuerCouleurAuxJoueurs (){
        Random generateurAleat = new Random();
        int n = generateurAleat.nextInt(1);
        int temp;
        
        if (n==1){
            listeJoueurs[0].affecterCouleur("rouge");
            temp =0;
        }
        else{
            listeJoueurs[0].affecterCouleur("jaune");
            temp=1; 
        }
        
        if(temp==0){
            listeJoueurs[1].affecterCouleur("jaune");
        }
        else{
        listeJoueurs[1].affecterCouleur("rouge");
        }
        
    }
    
    public void creerEtAffecterJeton (Joueur j_jeton){
        String clr_j = j_jeton.donnerCouleur();
        
         for (int i =0 ;i<=30;i++){
             
             j_jeton.ajouterJeton(new Jeton(clr_j));
             
         }
    }
    
    public void placerTrousNoirsEtDesintegrateurs() {
        
        Random generateurAleat = new Random();
        for(int i=0;i<=3;i++){{
            int colonne = generateurAleat.nextInt(6); //n nb collone
            colonne+=1;
            int ligne = generateurAleat.nextInt(5); // nb ligne
            ligne+=1;
                if (plateau.presenceTrouNoir(ligne, colonne)==false&&plateau.presenceDesintegrateur(ligne, colonne)==false){
                    plateau.placerTrouNoir(ligne, colonne);
                    plateau.placerDesintegrateur(ligne, colonne);
                }
                else{
                    i-=1;
                }
            }
        }
        for(int i=0;i<=2;i++){{
            int colonne = generateurAleat.nextInt(6); //n nb collone
            colonne+=1;
            int ligne = generateurAleat.nextInt(5); // nb ligne
            ligne+=1;
                if (plateau.presenceTrouNoir(ligne, colonne)==false&&plateau.presenceDesintegrateur(ligne, colonne)==false){
                    plateau.placerTrouNoir(ligne, colonne);
                }
                else{
                    i-=1;
                }
            }
        }
        for(int i=0;i<=3;i++){{
            int colonne = generateurAleat.nextInt(6); //n nb collone
            colonne+=1;
            int ligne = generateurAleat.nextInt(5); // nb ligne
            ligne+=1;
                if (plateau.presenceTrouNoir(ligne, colonne)==false&&plateau.presenceDesintegrateur(ligne, colonne)==false){
                    plateau.placerDesintegrateur(ligne, colonne);
                }
                else{
                    i-=1;
                }
            }
        
        
        }
    }
    
    public void initialiserPartie() {
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs [0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
    }
    
    public void lancerPartie(){
        initialiserPartie();
        
    }
    
}
