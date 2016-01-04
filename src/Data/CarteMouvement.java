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
public abstract class CarteMouvement extends Carte {
 
    private boolean avancer;

    public CarteMouvement(int num, String txt, boolean avc) {
        super(num,txt);
        this.setAvancer(avc);
    }
    
    @Override
    public abstract void action(Joueur J);
    
   
    
    
    
    
    
    /* SET & GET : avancer */
    
    
    /**
     * @return the avancer
     */
    public boolean isAvancer() {
        return avancer;
    }

    /**
     * @param avancer the avancer to set
     */
    private void setAvancer(boolean avancer) {
        this.avancer = avancer;
    }
    
    
    
}
