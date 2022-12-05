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
        Scanner saisieUtilisateur = new Scanner(System.in);
        
         System.out.println("Quel est le nom du joueur 1");//On demande le nom du j1
        String n_j1=saisieUtilisateur.nextLine();
        Joueur J1=new Joueur (n_j1); 
        listeJoueurs[0]=J1;
       
       

         System.out.println("Quel est le nom du joueur 2");//On demande le nom du j1
        String n_j2=saisieUtilisateur.nextLine();
        Joueur J2=new Joueur (n_j2); 
        listeJoueurs[1]=J2;
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs [0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
    }
    
    public void lancerPartie(){
        Scanner saisieUtilisateur = new Scanner(System.in);

       


        Random generateurAleat = new Random();
        int jr = generateurAleat.nextInt(1);//on tire au sort quel joueur commence

        
        boolean victoire=false;

        while (victoire!=true){//tant que personne n'a gagné on continu de jouer

            if (jr== 1){
                joueurCourant=listeJoueurs [0];//si le tirage au sort tombe sur 1 cest le joueur dans la casse 0 qui commence
                jr=0;//on change la variable jr pour qu'à la prochaine itération ce soit au tour du joueur dans la case 1
            }
            else{
                joueurCourant=listeJoueurs[1]; //idem que si jr==1 avec jr==0
                jr=1;
            }

            System.out.println("Que souhaitez vous faire ?\nPlacer un jeton ? Tapez 1\nRetirer un jeton ? Tapez 2\nUtiliser un desintégrateur ? Tapez 3");
            int choix=saisieUtilisateur.nextInt();
            //1: placer jeton 2:Retirer Jeton 3:desintegrateur"
            
        if (choix==1){

            if(joueurCourant.nombreDeJetons()>0){//on vérifie que le joueur possede encore des jetons

                System.out.println("Dans quelle colonne voulez vous jouer ?");
                int colonne = saisieUtilisateur.nextInt();
                Jeton j_joué=joueurCourant.jouerJeton();//cette ligne crée le jeton qui va être joué et le retire du sac de jeton du joueur
                boolean cr=plateau.colonneRemplie(colonne);//on vérifie que la colonne n'est pas remplie
                if(cr==false){//si la colonne n'est pas remplie on place le jeton
                plateau.ajouterJetonDansColonne(j_joué, colonne);

                    for(int i=1;i<=6;i++){//on verifie qu'il n'y a pas de jeton dans la colonne ou on a joué sinon on retire le jeotn et le trou noir
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

            String clr=joueurCourant.donnerCouleur();//on recupere la couleur de=u joueur courant
            victoire = plateau.etreGagnantePourCouleur(clr);//on regarde si ce dernier à gagné


        }

        if (choix==2){//si le joueur tape 2 il veut retirer un jeton

            System.out.println("Dans quelle colonne est le jeton que vous voulez retirer ?");
            int colonne_r = saisieUtilisateur.nextInt();                      //on demande la ligne et colonne du jeton 
            System.out.println("Dans quelle ligne est le jeton que vous voulez retirer ?");
            int ligne_r = saisieUtilisateur.nextInt();
            boolean presence=plateau.presenceJeton(colonne_r, ligne_r);//on vérifie qu'il y a bien un jeton à retirer
            String clr_j=joueurCourant.donnerCouleur();
            String clr_jt=plateau.lireCouleurDuJeton(colonne_r, ligne_r);
            if(presence==true & clr_j==clr_jt){//on vérifie s'il y en a un et s'il est de la couleur du joueur courant
                plateau.recupererJeton(colonne_r, ligne_r);
                plateau.tasserColone(colonne_r);
            }
            else{
                System.out.println("il n'y a pas de jeton à retirer ou ce jeton ne vous appartient pas");
            }

            String clr=joueurCourant.donnerCouleur();
            victoire = plateau.etreGagnantePourCouleur(clr);

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
            victoire = plateau.etreGagnantePourCouleur(clr);

            }

        }
        String nomGagnant=joueurCourant.retournerNom();
        System.out.println(nomGagnant+"a gagné");
    }
    
}

