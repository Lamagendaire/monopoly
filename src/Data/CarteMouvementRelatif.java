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
public class CarteMouvementRelatif extends CarteMouvement {
    
    private int nbCases;

    public CarteMouvementRelatif(int num, String txt, boolean avc, int nbc) {
        super(num,txt,avc);
        this.setNbCases(nbCases);
    }
    
    @Override
    public void action(Joueur J) {
        
        // a remplir
        
    }
    
    
    /**
     * @return the nbCases
     */
    public int getNbCases() {
        return nbCases;
    }

    /**
     * @param nbCases the nbCases to set
     */
    private void setNbCases(int nbCases) {
        this.nbCases = nbCases;
    }
    
    
    
}
