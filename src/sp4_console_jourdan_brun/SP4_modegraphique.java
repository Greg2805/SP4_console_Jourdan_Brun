/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sp4_console_jourdan_brun;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class SP4_modegraphique extends javax.swing.JFrame {
private Joueur [] listeJoueurs = new Joueur[2]; 
    private Joueur joueurCourant;
    PlateauDeJeu plateau = new PlateauDeJeu () ;
    
    
    public static void main(String args[]) {
        
        System.out.println("OK");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SP4_modegraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SP4_modegraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SP4_modegraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SP4_modegraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SP4_modegraphique().setVisible(true);
            }
        });
    }

    
    /**
     * Creates new form SP4_modegraphique
     */
    public SP4_modegraphique() {
        initComponents();
        panneau_info_joueur.setVisible(false);
        panneau_info_partie.setVisible(false);
        
        
        for(int i=5;i>=0;i--){
            for(int j=0;j<7;j++){ 
               CelluleGraphique cellGraph = new CelluleGraphique(plateau.grille[i][j]);
               panneaugrille.add(cellGraph);
            }
        }
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
        for(int i=0;i<3;i++){
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
        
        for(int i=0;i<2;i++){
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
        
        for(int i=0;i<3;i++){
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
    
    public void initialiserPartie() {
        
        String nomJoueur1 = nom_joueur1.getText();
        Joueur J1=new Joueur (nomJoueur1);
        String nomJoueur2 = nom_joueur2.getText();
        Joueur J2=new Joueur (nomJoueur2); 
        listeJoueurs[0]=J1;
        listeJoueurs[1]=J2;
        
         lbl_j1_nom.setText(nomJoueur1);
         lbl_j2_nom.setText(nomJoueur2);
         
         lbl_j1_desintegrateur.setText(J1.nombreDesintegrateur()+"");
         lbl_j2_desintegrateur.setText(J2.nombreDesintegrateur()+"");
         
         
         Random r = new Random();
         boolean le_premier = r.nextBoolean();
         if(le_premier){
             joueurCourant = listeJoueurs[0];
         }
         else{
             joueurCourant = listeJoueurs[1];
         }
         lbl_jcourant.setText(joueurCourant.nom);
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs [0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
    
         lbl_j1_couleur.setText(J1.couleur);
         lbl_j2_couleur.setText(J2.couleur);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneaugrille = new javax.swing.JPanel();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur1 = new javax.swing.JTextField();
        nom_joueur2 = new javax.swing.JTextField();
        Btn_start = new javax.swing.JButton();
        panneau_info_joueur = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_j1_desintegrateur = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_j2_desintegrateur = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        Btn_col_0 = new javax.swing.JButton();
        Btn_col_1 = new javax.swing.JButton();
        Btn_col_2 = new javax.swing.JButton();
        Btn_col_3 = new javax.swing.JButton();
        Btn_col_4 = new javax.swing.JButton();
        Btn_col_5 = new javax.swing.JButton();
        Btn_col_6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneaugrille.setBackground(new java.awt.Color(255, 255, 255));
        panneaugrille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneaugrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 56, 672, 576));

        panneau_info_partie.setBackground(new java.awt.Color(102, 255, 102));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Infos jeu : ");
        panneau_info_partie.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setText("joueur courant : ");
        panneau_info_partie.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lbl_jcourant.setText("nomjoueur");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        message.setColumns(20);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        panneau_info_partie.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 270, -1));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 290, 170));

        panneau_creation_partie.setBackground(new java.awt.Color(102, 255, 102));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom joueur 2 :");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel2.setText("Nom joueur 1 :");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
        panneau_creation_partie.add(nom_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 120, -1));
        panneau_creation_partie.add(nom_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 120, -1));

        Btn_start.setText("démarer partie");
        Btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(Btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 120, 30));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 290, 150));

        panneau_info_joueur.setBackground(new java.awt.Color(102, 255, 102));
        panneau_info_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("infos joueurs ");
        panneau_info_joueur.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl_j1_desintegrateur.setText("désintégrateurjoueur1");
        panneau_info_joueur.add(lbl_j1_desintegrateur, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        jLabel5.setText("infos joueur 1 :");
        panneau_info_joueur.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel6.setText("couleur :");
        panneau_info_joueur.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lbl_j1_nom.setText("nomjoueur1");
        panneau_info_joueur.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jLabel8.setText("désintegrateurs :");
        panneau_info_joueur.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbl_j1_couleur.setText("couleurjoueur1");
        panneau_info_joueur.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));
        panneau_info_joueur.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 133, 290, 10));

        lbl_j2_desintegrateur.setText("désintégrateurjoueur2");
        panneau_info_joueur.add(lbl_j2_desintegrateur, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jLabel7.setText("infos joueur 2 :");
        panneau_info_joueur.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel9.setText("couleur :");
        panneau_info_joueur.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lbl_j2_nom.setText("nomjoueur2");
        panneau_info_joueur.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel10.setText("désintegrateurs :");
        panneau_info_joueur.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_j2_couleur.setText("couleurjoueur2");
        panneau_info_joueur.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        getContentPane().add(panneau_info_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 290, 240));

        Btn_col_0.setText("1");
        Btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        Btn_col_1.setText("2");
        Btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 20, -1, -1));

        Btn_col_2.setText("3");
        Btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 20, -1, -1));

        Btn_col_3.setText("4");
        Btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 20, -1, -1));

        Btn_col_4.setText("5");
        Btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 20, -1, -1));

        Btn_col_5.setText("6");
        Btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        Btn_col_6.setText("7");
        Btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 20, -1, -1));

        setBounds(0, 0, 1044, 672);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_startActionPerformed
    panneau_info_joueur.setVisible(true);
    panneau_info_partie.setVisible(true); 
    initialiserPartie();
    plateau.afficherGrilleSurConsole();
    panneaugrille.repaint();
    Btn_start.setEnabled(false);
    }//GEN-LAST:event_Btn_startActionPerformed

    private void Btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_col_0ActionPerformed
        // TODO add your handling code here:
        jouerDansColone(0);
        if(plateau.colonneRemplie(0)==true) Btn_col_0.setEnabled(false);
        joueurSuivant();
    }//GEN-LAST:event_Btn_col_0ActionPerformed

    private void Btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_col_4ActionPerformed
        // TODO add your handling code here:
        jouerDansColone(4);
        if(plateau.colonneRemplie(4)==true) Btn_col_4.setEnabled(false);
        joueurSuivant();
    }//GEN-LAST:event_Btn_col_4ActionPerformed

    private void Btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_col_1ActionPerformed
        // TODO add your handling code here:
        jouerDansColone(1);
        if(plateau.colonneRemplie(1)==true) Btn_col_1.setEnabled(false);
        joueurSuivant();
    }//GEN-LAST:event_Btn_col_1ActionPerformed

    private void Btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_col_2ActionPerformed
        // TODO add your handling code here:
        jouerDansColone(2);
        if(plateau.colonneRemplie(2)==true) Btn_col_2.setEnabled(false);
        joueurSuivant();
    }//GEN-LAST:event_Btn_col_2ActionPerformed

    private void Btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_col_3ActionPerformed
        // TODO add your handling code here:
        jouerDansColone(3);
        if(plateau.colonneRemplie(3)==true) Btn_col_3.setEnabled(false);
        joueurSuivant();
    }//GEN-LAST:event_Btn_col_3ActionPerformed

    private void Btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_col_5ActionPerformed
        // TODO add your handling code here:
        jouerDansColone(5);
        if(plateau.colonneRemplie(5)==true) Btn_col_5.setEnabled(false);
        joueurSuivant();
    }//GEN-LAST:event_Btn_col_5ActionPerformed

    private void Btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_col_6ActionPerformed
        // TODO add your handling code here:
        jouerDansColone(6);
        if(plateau.colonneRemplie(6)==true) Btn_col_6.setEnabled(false);
        joueurSuivant();
    }//GEN-LAST:event_Btn_col_6ActionPerformed

    public void joueurSuivant(){
        if (joueurCourant==listeJoueurs[0] ){
            joueurCourant=listeJoueurs[1];
        }
        else{
          joueurCourant=listeJoueurs[0];
          
        }
        lbl_jcourant.setText(joueurCourant.nom);
    }
    public boolean jouerDansColone(int indice_colone){
        panneaugrille.repaint();
       

        
        if(joueurCourant.nombreDeJetons()>0){//on vérifie que le joueur possede encore des jetons

                
                
                Jeton j_joué=joueurCourant.jouerJeton();//cette ligne crée le jeton qui va être joué et le retire du sac de jeton du joueur
                boolean cr=plateau.colonneRemplie(indice_colone);//on vérifie que la colonne n'est pas remplie
                if(cr==false){//si la colonne n'est pas remplie on place le jeton
                int lig = plateau.ajouterJetonDansColonne(j_joué, indice_colone);

                        boolean a=plateau.presenceTrouNoir(lig,indice_colone);
                        if(a==true&&plateau.presenceDesintegrateur(lig, indice_colone)==true){
                        plateau.supprimerTrouNoir(lig, indice_colone);
                        plateau.supprimerJeton(lig, indice_colone);
                        plateau.supprimerDesintegrateur(lig, indice_colone);
                        joueurCourant.obtenirDesintegrateur();
                        
                    }
                        
                
                        if(plateau.presenceDesintegrateur(lig, indice_colone)==true){
                            plateau.supprimerDesintegrateur(lig, indice_colone);
                            joueurCourant.obtenirDesintegrateur();
                        }
                        if(a==true){
                            plateau.supprimerTrouNoir(lig,indice_colone);
                            plateau.supprimerJeton(lig,indice_colone);
                        }
        lbl_j1_desintegrateur.setText(listeJoueurs[0].nombreDesintegrateur()+"");
        lbl_j2_desintegrateur.setText(listeJoueurs[1].nombreDesintegrateur()+"");  
        
        boolean vict_j1 = plateau.etreGagnantePourCouleur(listeJoueurs[0].donnerCouleur());
        boolean vict_j2 = plateau.etreGagnantePourCouleur(listeJoueurs[1].donnerCouleur());
        
        if (vict_j1 && ! vict_j2 ) message.setText("Victoire de "+listeJoueurs[0].nom);
        if (vict_j2 && ! vict_j1 ) message.setText("Victoire de "+listeJoueurs[1].nom);
        
        if (vict_j1 &&  vict_j2){
           if(joueurCourant==listeJoueurs[0])message.setText("Victoire de "+listeJoueurs[1].nom+"(faute de jeu de l'autre joueur)");
           else message.setText("Victoire de "+listeJoueurs[0].nom+"(faute de jeu de l'autre joueur)");
        }
        
        
                    }   return true;
                }
                else{
                    return true;
                }
        



           

  

          
        
        
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_col_0;
    private javax.swing.JButton Btn_col_1;
    private javax.swing.JButton Btn_col_2;
    private javax.swing.JButton Btn_col_3;
    private javax.swing.JButton Btn_col_4;
    private javax.swing.JButton Btn_col_5;
    private javax.swing.JButton Btn_col_6;
    private javax.swing.JButton Btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_desintegrateur;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_desintegrateur;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JTextArea message;
    private javax.swing.JTextField nom_joueur1;
    private javax.swing.JTextField nom_joueur2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_info_joueur;
    private javax.swing.JPanel panneau_info_partie;
    private javax.swing.JPanel panneaugrille;
    // End of variables declaration//GEN-END:variables
}
