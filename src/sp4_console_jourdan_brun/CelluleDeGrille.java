package sp4_console_jourdan_brun;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author grego
 */
public class CelluleDeGrille {
    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;
    
    public void CelluleDeGrille (){
        
        jetonCourant=null;
        
    }
    
    
    public boolean presenceJeton (){
        
        if (jetonCourant == null){
            return(false);
        }
        else{
            return(true);
        }
        
    }
    
    
    public void affecterJeton(Jeton jeton_j){
        
            jetonCourant=jeton_j;
       
    }
    
    
    public String LireCouleurDuJeton (){
        
        if (jetonCourant != null){
            
            String var;
            var=jetonCourant.lireCouleur();
            
            if(var=="rouge"){
                return ("rouge");               
            }
            
            else{
                return("jaune");
            }
        
        }
        
        else{
            return("vide");
        }
    
    
    }
    
    public Jeton recupererJeton(){
        
            Jeton temp =jetonCourant;
            jetonCourant=null;
            return(temp);
            
    }
        

    
public void placerTrouNoir(){
   avoirTrouNoir=true; 
}
public void supprimerTrouNoir(){
    avoirTrouNoir=false;
}
public boolean presenceTrouNoir(){
    if (avoirTrouNoir == false){
            return(false);
        }
        else{
            return(true);
        }
    
}

public void supprimerJeton(){
    jetonCourant= null;
    
}

public boolean presenceDesintegrateur(){
    if (avoirDesintegrateur == false){
            return(false);
        }
        else{
            return(true);
        }
    
}
public void placerDesintegrateur(){
    avoirDesintegrateur=true;
}
public void supprimerDesintegrateur (){
    avoirDesintegrateur=false;
}
public void activerTrouNoir(){
    this.supprimerJeton();
    this.supprimerTrouNoir();
}

    @Override
public String toString() { 

    String clr=LireCouleurDuJeton();
    String chaine_a_retourner;

    chaine_a_retourner="erreur";

    if (jetonCourant==null){
        chaine_a_retourner=".";
    

        if(clr=="rouge"){
            chaine_a_retourner="R";   
        }

        if (clr=="jaune"){
            chaine_a_retourner="J";
        }
        if(avoirDesintegrateur==true){
            chaine_a_retourner="D";
        }
        if(avoirTrouNoir==true){
            chaine_a_retourner="@";
        }
            
    }
    return chaine_a_retourner;

    }

}


