package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public class Joueur {
    private String _nomJoueur;
    private int _cash = 1500;
    private Monopoly _monopoly;
    private ArrayList<Compagnie> _compagnies = new ArrayList<Compagnie>();
    private ArrayList<Gare> _gares = new ArrayList<Gare>();
    private Carreau _positionCourante;
    private int cartesPrison=0;
    private int _totaldes= 0;
    private int _nbTourPrison=1;
    private boolean estPrison;
    private ArrayList<ProprieteAConstruire> _proprietesAConstruire = new ArrayList<ProprieteAConstruire>();
        
        public Joueur(String nomJ, Monopoly M) {
           this.setNomJoueur(nomJ);
           this.setMonopoly(M);
           this.setCompagnies(new ArrayList<Compagnie>());
           this.setGares(new ArrayList<Gare>());
           _positionCourante=(_monopoly.getCases().get(1));
           this.setProprietesAConstruire(new ArrayList<ProprieteAConstruire>());
        }
    
    public void addCompagnie(Compagnie compagnie){
        _compagnies.add(compagnie);
    } 
    
    public void addGare(Gare gare){
        _gares.add(gare);
    }
    
    public void addProprietesAConstruire(ProprieteAConstruire prop){
        _proprietesAConstruire.add(prop);
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
        this.setCash(_cash-aPrix);
    }

    public int getNbGare() {
        throw new UnsupportedOperationException();
    }
    public void addCash(int reçu){
        this.setCash(this.getCash()+reçu);
    }

    public void changerPosition(int aTotalDes) {
        int num=_positionCourante.getNumero()+aTotalDes;
        if (num>39){num = num-39;this.addCash(200);
        this.getMonopoly().getIhm().messageDepart();}
        this.setPositionCourante(_monopoly.getCases().get(num));
    }

    public Carreau getPositionCourante() {
        return this._positionCourante;
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

    /**
     * @return the _totaldes
     */
    public int getTotaldes() {
        return _totaldes;
    }

    /**
     * @param _totaldes the _totaldes to set
     */
    public void setTotaldes(int _totaldes) {
        this._totaldes = _totaldes;
    }
    public HashSet<ProprieteAConstruire> propriétéConstructible() {
        
        ArrayList<ProprieteAConstruire> propriétés= this.getProprietesAConstruire();
        HashSet<ProprieteAConstruire> propriétésConstructibles = new HashSet<>();
        
        
        ArrayList<Groupe> lesGroupes = new ArrayList<>();
        for (ProprieteAConstruire p : propriétés) {
            
            lesGroupes.add(p.getGroupePropriete());
            
        }
        
        for (Groupe g : lesGroupes) {
            
            HashSet<ProprieteAConstruire> propriGroupe = new HashSet<>();
            propriGroupe = g.getProprietes();
            
            boolean estFullProprietaire = true;
            
            for (ProprieteAConstruire pac : propriGroupe) {
                
                Joueur proprio = pac.getProprietaire();
                
                if (proprio != this) {
                    
                    estFullProprietaire = false;
                    
                }
                
            }
            
            if (estFullProprietaire) {
                
                int nbmin = 5;
                for (ProprieteAConstruire pac2 : propriGroupe) {
                    
                    if (pac2.getNbMaisons() <= nbmin) {
                        nbmin = pac2.getNbMaisons();
                    }
                    
                }
                
                
                for (ProprieteAConstruire pac3 : propriGroupe) {
                    
                    if (pac3.getNbMaisons() == nbmin && nbmin != 5) {
                        
                        propriétésConstructibles.add(pac3);
                        
                    }
                    
                }
                
                
            }
            
            
        }
        
        return propriétésConstructibles;
        
    }

    /**
     * @return the cartesPrison
     */
    public int getCartesPrison() {
        return cartesPrison;
    }

    /**
     * @param cartesPrison the cartesPrison to set
     */
    public void setCartesPrison(int cartesPrison) {
        this.cartesPrison = cartesPrison;
    }
    
    public  void addCartesPrison(){
        cartesPrison++;
    }

    /**
     * @return the estPrison
     */
    public boolean isEstPrison() {
        return estPrison;
    }

    /**
     * @param estPrison the estPrison to set
     */
    public void setEstPrison(boolean estPrison) {
        this.estPrison = estPrison;
    }

    /**
     * @return the _nbTourPrison
     */
    public int getNbTourPrison() {
        return _nbTourPrison;
    }

    /**
     * @param _nbTourPrison the _nbTourPrison to set
     */
    public void setNbTourPrison(int _nbTourPrison) {
        this._nbTourPrison = _nbTourPrison;
    }
}
