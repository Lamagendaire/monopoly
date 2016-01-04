/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.util.HashMap;

/**
 *
 * @author dubsvi
 */
public class CarteAnniversaire extends Carte {
    
    private int montant;

    public CarteAnniversaire(int num, String txt, int mnt) {
        super(num,txt);
        this.setMontant(mnt);
    }
    
    
    @Override
    public void action(Joueur J) {
        
        
       int montantRecu = 0; 
        
       for (int i = 1; i < J.getMonopoly().getJoueurs().size(); i++) {
           
          if (J != J.getMonopoly().getJoueurs().get(i)) {
          montantRecu = montantRecu + montant;     
          J.getMonopoly().getJoueurs().get(i).decrementerCash(montant);
           
          }
          
       }
        
       J.addCash(montantRecu);
       J.getMonopoly().getIhm().messageAnniversaire()
       
    }
    
    
    
    
    
    
    
    
    
    
    
    /* SET & GET : Montant */
    
    
    /**
     * @return the montant
     */
    public int getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    private void setMontant(int montant) {
        this.montant = montant;
    }
    
    
    
}
