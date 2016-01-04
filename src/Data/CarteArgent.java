/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

/**
 *
 * @author dubsvi
 */
public class CarteArgent extends Carte {
    
    private int montant;

    public CarteArgent(int num, String txt, int mnt) {
        super(num,txt);
        this.setMontant(mnt);
    }
    
    @Override
    public void action(Joueur J) {
        
        J.addCash(montant);
        
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
