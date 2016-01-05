/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

/**
 *
 * @author dubsvi
 */
public class CarteReparation extends Carte {
    
    private int montantMaison;
    private int montantHotel;
    
    public CarteReparation(int num, String txt, int mMaison, int mHotel) {
        super(num,txt);
        this.setMontantMaison(mMaison);
        this.setMontantHotel(mHotel);
    }

    
 @Override public void action(Joueur J) {
     for (ProprieteAConstruire PC : J.getProprietesAConstruire()) {
         if (PC.getNbMaisons() < 4) {
             J.addCash(montantMaison*PC.getNbMaisons()); }
         else { J.addCash(montantHotel); 
         } 
     } 
 }
    
    
    
    
    
    
    
    
    
    
    /* SET & GET : montantMaison */
    
    
    /**
     * @return the montantMaison
     */
    public int getMontantMaison() {
        return montantMaison;
    }

    /**
     * @param montantMaison the montantMaison to set
     */
    private void setMontantMaison(int montantMaison) {
        this.montantMaison = montantMaison;
    }

    
    
    
    /* SET & GET : montantHotel */
    
    
    /**
     * @return the montantHotel
     */
    public int getMontantHotel() {
        return montantHotel;
    }

    /**
     * @param montantHotel the montantHotel to set
     */
    private void setMontantHotel(int montantHotel) {
        this.montantHotel = montantHotel;
    }
    
}
