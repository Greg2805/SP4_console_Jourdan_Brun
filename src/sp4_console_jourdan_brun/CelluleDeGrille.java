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

    if (this.presenceJeton()==false){
        
    

        
        
        if(this.presenceTrouNoir()==true&&this.presenceDesintegrateur()==true){
            return"@";
        }
        
         if(this.presenceTrouNoir()==true){
            return"@";
        }
        
        if(this.presenceDesintegrateur()==true){
            return"D";
        }
        return".";
    }
        
    
    else{
    if(this.LireCouleurDuJeton()=="rouge"){
            return "R";   
        }

        if (this.LireCouleurDuJeton()=="jaune"){
            return"J";
 
        }
    }
    return "!";
}
}




