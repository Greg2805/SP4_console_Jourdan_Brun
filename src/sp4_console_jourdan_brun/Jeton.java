package sp4_console_jourdan_brun;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class Jeton {
   private String couleur;
    
    
public Jeton(String color){   
      
    couleur = color;
    
}
public String lireCouleur(){
    return couleur;
    
}
@Override
public String toString() { 
String chaine_a_retourner;
if (couleur=="jaune"){
    couleur="J";
}
else if(couleur=="rouge"){
    couleur="R";   
}
else{
    couleur="erreur";
}
chaine_a_retourner=couleur;
return chaine_a_retourner;

}
}