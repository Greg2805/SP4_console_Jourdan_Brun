/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_jourdan_brun;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Dell
 */
public class CelluleGraphique extends JButton {
    CelluleDeGrille celluleAssociees;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    
    public CelluleGraphique (CelluleDeGrille uneCellule){
        celluleAssociees=uneCellule;
    }
    
    
    
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        if (celluleAssociees.presenceTrouNoir()== true){
          setIcon(img_trouNoir);  
        }
        else if (celluleAssociees.presenceDesintegrateur()== true){
          setIcon(img_desint);  
        }
        else{
            String couleur_jeton=celluleAssociees.LireCouleurDuJeton();
            switch (couleur_jeton){
                case"vide" :
                    setIcon(img_vide);
                    break;
                case "rouge":
                    setIcon(img_jetonRouge);
                    break;
                case "jaune":
                    setIcon(img_jetonJaune);
                    break;
            }
        }
        
        
    }
}

