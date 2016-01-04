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
public class CarteMouvementDirect extends CarteMouvement {
    
    private int numero;

    public CarteMouvementDirect(int num, String txt, boolean avc, int num2) {
        super(num,txt,avc);
        this.setNumero(num2);
    }
    
    @Override
    public void action(Joueur J) {
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    /* SET & GET : numero */
    
    
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    private void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
