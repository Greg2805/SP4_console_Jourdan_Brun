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
    
    public void CelluleDeGrille (){
        
        jetonCourant=null;
        
    }
    
    
    public boolean presenceJeton (){
        
        if (jetonCourant != null){
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
 
    
}


