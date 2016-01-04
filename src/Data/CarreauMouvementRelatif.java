/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

/**
 *
 * @author lyonsl
 */
public class CarreauMouvementRelatif extends CarreauMouvement {
    
    private int nbcases;
    
    public CarreauMouvementRelatif (Monopoly _monopoly, String _nomCarreau, int _numero, String _type) {
        super(_monopoly, _nomCarreau, _numero, _type);
    }
    
    @Override
    
    public void action(Joueur j) {
        j.changerPosition(getNbcases());
    }

    /**
     * @return the nbcases
     */
    public int getNbcases() {
        return nbcases;
    }

    /**
     * @param nbcases the nbcases to set
     */
    public void setNbcases(int nbcases) {
        this.nbcases = nbcases;
    }
    
}



