package Data;

import java.util.ArrayList;
import java.util.HashSet;

public class Joueur {
    private String _nomJoueur;
    private int _cash = 1500;
    private Monopoly _monopoly;
    private ArrayList<Compagnie> _compagnies = new ArrayList<Compagnie>();
    private ArrayList<Gare> _gares = new ArrayList<Gare>();
    private Carreau _positionCourante;
    private ArrayList<ProprieteAConstruire> _proprietesAConstruire = new ArrayList<ProprieteAConstruire>();
        
        public Joueur(String nomJ, Monopoly M) {
           this.setNomJoueur(_nomJoueur);
           this.setMonopoly(M);
           this.setCompagnies(new ArrayList<Compagnie>());
           this.setGares(new ArrayList<Gare>());
           this.setPositionCourante(_monopoly.getCarreaux().get(0));
           this.setProprietesAConstruire(new ArrayList<ProprieteAConstruire>());
        }

    public void payerLoyer(int aL) {
        throw new UnsupportedOperationException();
    }

    public void recevoirLoyer(int aL) {
        throw new UnsupportedOperationException();
    }

    public HashSet<Gare> getLesGares() {
        throw new UnsupportedOperationException();
    }

    public String getNom() {
        throw new UnsupportedOperationException();
    }

    public void cashRestant(int aL) {
        throw new UnsupportedOperationException();
    }

    public int getCash() {
        return this._cash;
    }

    public void decrementerCash(int aPrix) {
        throw new UnsupportedOperationException();
    }

    public int getNbGare() {
        throw new UnsupportedOperationException();
    }

    public void changerPosition(int aTotalDes) {
        throw new UnsupportedOperationException();
    }

    public Carreau getPositionCourante() {
        return this._positionCourante;
    }

    public void nouvellePosition(int aTotalDes, int aNum) {
        throw new UnsupportedOperationException();
    }

    public void setPositionCourante(Carreau aC2) {
        throw new UnsupportedOperationException();
    }

    /**
     * @return the _nomJoueur
     */
    public String getNomJoueur() {
        return _nomJoueur;
    }

    /**
     * @param _nomJoueur the _nomJoueur to set
     */
    public void setNomJoueur(String _nomJoueur) {
        this._nomJoueur = _nomJoueur;
    }

    /**
     * @param _cash the _cash to set
     */
    public void setCash(int _cash) {
        this._cash = _cash;
    }

    /**
     * @return the _monopoly
     */
    public Monopoly getMonopoly() {
        return _monopoly;
    }

    /**
     * @param _monopoly the _monopoly to set
     */
    public void setMonopoly(Monopoly _monopoly) {
        this._monopoly = _monopoly;
    }

    /**
     * @return the _compagnies
     */
    public ArrayList<Compagnie> getCompagnies() {
        return _compagnies;
    }

    /**
     * @param _compagnies the _compagnies to set
     */
    public void setCompagnies(ArrayList<Compagnie> _compagnies) {
        this._compagnies = _compagnies;
    }

    /**
     * @return the _gares
     */
    public ArrayList<Gare> getGares() {
        return _gares;
    }

    /**
     * @param _gares the _gares to set
     */
    public void setGares(ArrayList<Gare> _gares) {
        this._gares = _gares;
    }

    /**
     * @return the _proprietesAConstruire
     */
    public ArrayList<ProprieteAConstruire> getProprietesAConstruire() {
        return _proprietesAConstruire;
    }

    /**
     * @param _proprietesAConstruire the _proprietesAConstruire to set
     */
    public void setProprietesAConstruire(ArrayList<ProprieteAConstruire> _proprietesAConstruire) {
        this._proprietesAConstruire = _proprietesAConstruire;
    }
}
