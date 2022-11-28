/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_jourdan_brun;

/**
 *
 * @author Dell
 */
public class PlateauDeJeu {
    private CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];
    
public PlateauDeJeu(){
    for (int i=0;i<6;i++){
        for(int j=0;j<7;i++){
            grille[i][j]  = new CelluleDeGrille();
            
        }
    }
}
public int ajouterJetonDansColonne(Jeton n, int j){
    for (int i=0;i<6;i++){
        if(grille[i][j].presenceJeton()==false){
            grille[i][j].affecterJeton(n);
            return i;
        }
    
}
    return -1;
} 

public boolean grilleRemplie(){
    
    for(int j=0;j<7;j++){
        if (grille[5][j].presenceJeton()==false){
            return false;
        }
          
    }
    return true;
            
        }
    


    
        }
