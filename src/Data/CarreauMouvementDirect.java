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
public class CarreauMouvementDirect extends CarreauMouvement {
    
    private int numero;
    
    public CarreauMouvementDirect (Monopoly _monopoly, String _nomCarreau, int _numero, String _type) {
        super(_monopoly, _nomCarreau, _numero, _type);
    }
    
    @Override
    
    public void action(Joueur j) {
        for(Carreau c: j.getMonopoly().getCases().values()){
                    if(c.getNumero()==getNumero()){j.setPositionCourante(c);}
                }
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
