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
public abstract class Carte {
    
    private int id;
    private String texte;
    
    public Carte(int num, String txt) {
        this.setId(num);
        this.setTexte(txt);
    }

    
    public abstract void action(Joueur J);
    
    
    
    
    
    /*  SET & GET : ID */
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    private void setId(int id) {
        this.id = id;
    }

    
    /*  SET * GET : TEXTE */
    
    
    /**
     * @return the texte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * @param texte the texte to set
     */
    private void setTexte(String texte) {
        this.texte = texte;
    }
    
}
