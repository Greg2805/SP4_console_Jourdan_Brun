/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_jourdan_brun;

/**
 *
 * @author grego
 */
public class SP4_console_Jourdan_Brun {
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Joueur J1=new Joueur("greg");
        Joueur J2=new Joueur("quentin");
        Partie Jouons=new Partie(J1, J2);
        
        Jouons.initialiserPartie();
        
        System.out.println("lancement partie");
        
        Jouons.lancerPartie();
        
//        CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];
         
         
    }
    
}
