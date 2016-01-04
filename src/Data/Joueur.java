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
           this.setNomJoueur(nomJ);
           this.setMonopoly(M);
           this.setCompagnies(new ArrayList<Compagnie>());
           this.setGares(new ArrayList<Gare>());
           _positionCourante=(_monopoly.getCases().get(1));
           this.setProprietesAConstruire(new ArrayList<ProprieteAConstruire>());
        }

    public void payerLoyer(int aL) {
        this.setCash(this.getCash()-aL);
    }

    public void recevoirLoyer(int aL) {
        this.setCash(this.getCash()+aL);
    }

    public HashSet<Gare> getLesGares() {
        throw new UnsupportedOperationException();
    }

    public String getNom() {
        return _nomJoueur;
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
    public void addCash(int reçu){
        System.out.println(this.getNom()+"à reçu "+reçu);
        this.setCash(this.getCash()+reçu);
    }

    public void changerPosition(int aTotalDes) {
        int num=_positionCourante.getNumero()+aTotalDes;
        if (num>39){num = num-39;this.addCash(200);}
        this.setPositionCourante(_monopoly.getCases().get(num));
    }

    public Carreau getPositionCourante() {
        return this._positionCourante;
    }

    public void nouvellePosition(int aTotalDes, int aNum) {
        throw new UnsupportedOperationException();
    }

    public void setPositionCourante(Carreau aC2) {
        _positionCourante=aC2;
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
