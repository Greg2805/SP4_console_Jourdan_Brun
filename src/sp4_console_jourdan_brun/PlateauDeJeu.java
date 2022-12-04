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
    int test=0;
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
public void afficherGrilleSurConsole(){
    for (int i=5;i>0;i--){
        for (int j=6;i>0;i--){
            grille[i][j].toString();
            
            
        }
    }
}

public boolean presenceJeton(int x, int y){
    boolean a=grille[x][y].presenceJeton();
    return a;
}

public String  lireCouleurDuJeton(int x, int y){
    String a = grille[x][y].LireCouleurDuJeton();
    return a;
}


public boolean ligneGagnantePourCouleur(String C){
    for (int i=5;i>0;i--){
        for (int j=3;j>0;i--){
            if (C==grille[i][j].LireCouleurDuJeton()& C==grille[i][j+1].LireCouleurDuJeton()& C==grille[i][j+2].LireCouleurDuJeton() & C==grille[i][j+3].LireCouleurDuJeton()){
                return true;
            }
        }
    }
return false;  
}

public boolean colonneGagnantePourCouleur(String C){
    for (int i=2;i>0;i--){
        for (int j=6;j>0;i--){
            if (C==grille[i][j].LireCouleurDuJeton()& C==grille[i+1][j].LireCouleurDuJeton()& C==grille[i+2][j].LireCouleurDuJeton() & C==grille[i+3][j].LireCouleurDuJeton()){
                return true;
        }
        }
    }
    return false;
}

public boolean diagonaleMontanteGagnantePourCouleur(String C){
    for (int i=2;i>0;i--){
        for (int j=3;j>0;i--){
            if (C==grille[i][j].LireCouleurDuJeton()& C==grille[i+1][j+1].LireCouleurDuJeton()& C==grille[i+2][j+2].LireCouleurDuJeton() & C==grille[i+3][j+3].LireCouleurDuJeton()){
                return true;
        }
        }
    }
    return false;
}

public boolean diagonaleDesencanteGagnantePourCouleur(String C){
    for (int i=5;i>3;i--){
        for (int j=3;j>0;i--){
            if (C==grille[i][j].LireCouleurDuJeton()& C==grille[i-1][j+1].LireCouleurDuJeton()& C==grille[i-2][j+2].LireCouleurDuJeton() & C==grille[i-3][j+3].LireCouleurDuJeton()){
                return true;
        }
        }
    }
    return false;
}


public boolean etreGagnantePourCouleur(String c){
    boolean b = ligneGagnantePourCouleur(c);
    boolean b1 = colonneGagnantePourCouleur(c);
    boolean b2 = diagonaleMontanteGagnantePourCouleur(c);
    boolean b3 = diagonaleDesencanteGagnantePourCouleur(c);
    
if (b==true||b1==true||b2==true||b3==true){
    return true;
}
return false;
}

public boolean colonneRemplie(int y){
    if(grille[5][y].presenceJeton()==false){
        return false;
    }
    return true;
}


public void tasserColone(int y){
    for (int x=0;x<5;x++){
        if( grille[x][y].presenceJeton()==false ){
        if( grille[x+1][y].presenceJeton()==true ){
           
            Jeton j = grille[x+1][y].recupererJeton();
            grille[x][y].affecterJeton(j);
        }
    }
    
}
    
}
public void placerTrouNoir(int x, int y){
    grille[x][y].placerTrouNoir();
}

public void supprimerTrouNoir(int x, int y){
    grille[x][y].supprimerTrouNoir();
}

public void placerDesintegrateur(int x,int y){
    grille[x][y].presenceDesintegrateur();
}
public void supprimerDesintegrateur(int x, int y){
    grille[x][y].supprimerDesintegrateur();
}

public void supprimerJeton(int x, int y){
    grille[x][y].supprimerJeton();
}

public void recupererJeton(int x, int y){
    grille[x][y].recupererJeton();
}
public boolean presenceTrouNoir(int x, int y){
    
    boolean a = grille[x][y].presenceTrouNoir();
    return a;
}
public boolean presenceDesintegrateur(int x, int y){
    boolean a = grille[x][y].presenceDesintegrateur();
    return a;
}

}
