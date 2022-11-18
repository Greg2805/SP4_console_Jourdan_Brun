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
    String couleur;
    
    
private Jeton(String color){   
      
    couleur = color;
    
}
private String lireCouleur(){
    return couleur;
    
}
@Override
public String toString() { 
String chaine_a_retourner;
if (couleur=="jaune"){
couleur="J";
}
if(couleur=="rouge"){
    couleur="R";   
}
else{
    couleur="erreur";
}
chaine_a_retourner=couleur;
return chaine_a_retourner;

}
}