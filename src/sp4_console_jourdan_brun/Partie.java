/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_jourdan_brun;

import java.util.Random;
import java.util.Scanner;

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
    Scanner saisieUtilisateur = new Scanner(System.in);
//    Random generateurAleat = new Random();
//    int jr = generateurAleat.nextInt(1);
//    if (jr==1){
//        joueurCourant=listeJoueurs [0];
//    }
//    else{
//        joueurCourant=listeJoueurs [1];
//    }
    
    System.out.println("A qui est ce le tour ?\nSi joueur 1 pressez 1 si joueur 2 pressez 2");
    int jr = saisieUtilisateur.nextInt();
    
    if (jr== 1){
        joueurCourant=listeJoueurs [0];
    }
    else{
        joueurCourant=listeJoueurs[1];
    }
    
    System.out.println("Que souhaitez vous faire ?\nPlacer un jeton ? Tapez 1\nRetirer un jeton ? Tapez 2\nUtiliser un desintégrateur ? Tapez 3");
    int choix=saisieUtilisateur.nextInt();
    //1: placer jeton 2:Retirer Jeton 3:desintegrateur"
    if (choix==1){
        
        if(joueurCourant.nombreDeJetons()>0){
            
            System.out.println("Dans quelle colonne voulez vous jouer ?");
            int colonne = saisieUtilisateur.nextInt();
            Jeton j_joué=joueurCourant.jouerJeton();
            boolean cr=plateau.colonneRemplie(colonne);
            if(cr==false){
            plateau.ajouterJetonDansColonne(j_joué, colonne);
            
                for(int i=1;i<=6;i++){
                    boolean a=plateau.presenceTrouNoir(colonne, i);
                    if(a==true){
                        plateau.supprimerTrouNoir(colonne, i);
                        plateau.supprimerJeton(colonne, i);
                    }
                }
            }
            else{
                System.out.println("cette colonne est pleine");
            }
            
            
            
        }
        else{
            System.out.println("Vous n'avez plus de jeton.");
        }
        
        String clr=joueurCourant.donnerCouleur();
        boolean victoire = plateau.etreGagnantePourCouleur(clr);
        if(victoire==true){
            
            System.out.println("victoire pour les "+clr);
        }
        
    }
    
    if (choix==2){
        
        System.out.println("Dans quelle colonne est le jeton que vous voulez retirer ?");
        int colonne_r = saisieUtilisateur.nextInt();
        System.out.println("Dans quelle ligne est le jeton que vous voulez retirer ?");
        int ligne_r = saisieUtilisateur.nextInt();
        boolean presence=plateau.presenceJeton(colonne_r, ligne_r);
        if(presence==true){
        plateau.recupererJeton(colonne_r, ligne_r);
        plateau.tasserColone(colonne_r);
        }
        else{
            System.out.println("il n'y a pas de jeton à retirer");
        }
        
        String clr=joueurCourant.donnerCouleur();
        boolean victoire = plateau.etreGagnantePourCouleur(clr);
        if(victoire==true){
            
            System.out.println("victoire pour les "+clr);
        }
        
    }
    if(choix==3){
        System.out.println("Dans quelle colonne est le jeton que vous voulez desintégrer ?");
        int colonne_r = saisieUtilisateur.nextInt();
        System.out.println("Dans quelle ligne est le jeton que vous voulez desintégrer ?");
        int ligne_r = saisieUtilisateur.nextInt();
        boolean presence=plateau.presenceJeton(colonne_r, ligne_r);
        
        if(presence==true){
        plateau.supprimerJeton(colonne_r, ligne_r);
        plateau.tasserColone(colonne_r);
        }
        else{
            System.out.println("il n'y a pas de jeton à desintégrer");
        }
        joueurCourant.utiliserDesintegrateur();
        
        String clr=joueurCourant.donnerCouleur();
        boolean victoire = plateau.etreGagnantePourCouleur(clr);
        if(victoire==true){
            
            System.out.println("victoire pour les "+clr);
        }
        
    }
    }
    
}
