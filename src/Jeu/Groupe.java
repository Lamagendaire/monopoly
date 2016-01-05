package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public class Groupe {
	private CouleurPropriete _couleur;
	private int _prixAchatMaison;
	private int _prixAchatHotel;
	private HashSet<ProprieteAConstruire> _proprietes = new HashSet<ProprieteAConstruire>();
        
    public Groupe(CouleurPropriete c){
        this.setCouleur(c);
        
    }
        
        
    public void addPropriete(ProprieteAConstruire prop){
        _proprietes.add(prop);
    }

    /**
     * @param _couleur the _couleur to set
     */
    private void setCouleur(CouleurPropriete _couleur) {
        this._couleur = _couleur;
    }

    /**
     * @param _prixAchatMaison the _prixAchatMaison to set
     */
    private void setPrixAchatMaison(int _prixAchatMaison) {
        this._prixAchatMaison = _prixAchatMaison;
    }

    /**
     * @param _prixAchatHotel the _prixAchatHotel to set
     */
    private void setPrixAchatHotel(int _prixAchatHotel) {
        this._prixAchatHotel = _prixAchatHotel;
    }

    /**
     * @param _proprietes the _proprietes to set
     */
    private void setProprietes(HashSet<ProprieteAConstruire> _proprietes) {
        this._proprietes = _proprietes;
    }

    /**
     * @return the _couleur
     */
    public CouleurPropriete getCouleur() {
        return _couleur;
    }

    /**
     * @return the _prixAchatMaison
     */
    public int getPrixAchatMaison() {
        return _prixAchatMaison;
    }

    /**
     * @return the _prixAchatHotel
     */
    public int getPrixAchatHotel() {
        return _prixAchatHotel;
    }

    /**
     * @return the _proprietes
     */
    public HashSet<ProprieteAConstruire> getProprietes() {
        return _proprietes;
    }
        
        
}