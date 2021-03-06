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
public class CarteMouvementDirect extends CarteMouvement {
    
    private int numero;

    public CarteMouvementDirect(int num, String txt, boolean avc, int num2) {
        super(num,txt,avc);
        this.setNumero(num2);
    }
    
    @Override
    public void action(Joueur J) {
        
        
        if (super.isAvancer()) {
            
            if (this.getNumero() > J.getPositionCourante().getNumero()) {
                J.setPositionCourante(J.getMonopoly().getCases().get(numero));
                
            }
            else {
                J.addCash(200);
                J.setPositionCourante(J.getMonopoly().getCases().get(numero));
                
            }
        }
        J.setPositionCourante(J.getMonopoly().getCases().get(numero));
        
        if(J.getPositionCourante().getNomCarreau().equals("Simple Visite / En Prison")){
            
           
            J.setEstPrison(true);
            J.getMonopoly().setDoubleDé(false);
           
            
           
        }
        
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
