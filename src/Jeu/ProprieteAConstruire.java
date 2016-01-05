package Jeu;

public class ProprieteAConstruire extends CarreauPropriete {
	private int _nbMaisons = 0;
	private int _nbHotels = 0;
        private int _prixMaison=0;
        private int _prixHotel=0;
	private int [] _tabLoyers= new int [5];
	private Groupe _groupePropriete;

    public ProprieteAConstruire(Monopoly _monopoly, String _nomCarreau, int _numero,int _prixCarreau,String _type,Groupe groupe) {
        super(_monopoly, _nomCarreau,_type, _numero,_prixCarreau );
        this.setGroupePropriete(groupe);
        
    }
    void addMaison() { _nbMaisons = _nbMaisons + 1; }

    /**
     * @return the _nbMaisons
     */
    public int getNbMaisons() {
        return _nbMaisons;
    }

    /**
     * @return the _nbHotels
     */
    public int getNbHotels() {
        return _nbHotels;
    }


    /**
     * @return the _groupePropriete
     */
    public Groupe getGroupePropriete() {
        return _groupePropriete;
    }

    /**
     * @param _nbMaisons the _nbMaisons to set
     */
    private void setNbMaisons(int _nbMaisons) {
        this._nbMaisons = _nbMaisons;
    }

    /**
     * @param _nbHotels the _nbHotels to set
     */
    private void setNbHotels(int _nbHotels) {
        this._nbHotels = _nbHotels;
    }


    /**
     * @param _groupePropriete the _groupePropriete to set
     */
    private void setGroupePropriete(Groupe _groupePropriete) {
        this._groupePropriete = _groupePropriete;
    }

    @Override
    public int calculLoyer(Joueur jp,Joueur j) {
        int prix,nbProp=0;
        for(ProprieteAConstruire prop: jp.getProprietesAConstruire()){
            if (prop.getGroupePropriete().equals(this.getGroupePropriete())){nbProp++;}
        }
        if(_nbMaisons==0 && this.getGroupePropriete().getProprietes().size()==nbProp){
            prix= 2*_tabLoyers[0];
        }else if(_nbHotels==1){
            prix= _tabLoyers[5];
        }
        else{
            prix= _tabLoyers[_nbMaisons];
        }
        this.getMonopoly().getIhm().messagePayerLoyer(jp, j,prix);
        return prix;
        
        
        
    }

    @Override
    public void addprop(Joueur j) {
        j.addProprietesAConstruire(this);
    }

    /**
     * @return the _tabLoyers
     */
    public int[] getTabLoyers() {
        return _tabLoyers;
    }

    /**
     * @param _tabLoyers the _tabLoyers to set
     */
    public void setTabLoyers(int[] _tabLoyers) {
        this._tabLoyers = _tabLoyers;
    }

    /**
     * @return the _prixMaison
     */
    public int getPrixMaison() {
        return _prixMaison;
    }

    /**
     * @param _prixMaison the _prixMaison to set
     */
    public void setPrixMaison(int _prixMaison) {
        this._prixMaison = _prixMaison;
    }

    /**
     * @return the _prixHotel
     */
    public int getPrixHotel() {
        return _prixHotel;
    }

    /**
     * @param _prixHotel the _prixHotel to set
     */
    public void setPrixHotel(int _prixHotel) {
        this._prixHotel = _prixHotel;
    }


}