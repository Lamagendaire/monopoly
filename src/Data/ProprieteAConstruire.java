package Data;

public class ProprieteAConstruire extends CarreauPropriete {
	private int _nbMaisons = 0;
	private int _nbHotels = 0;
	private java.util.ArrayList<Integer> _loyerMaison;
	private Object _nbMaison;
	private Object _prixMaison;
	private int _tabLoyers;
	private Groupe _groupePropriete;

    public ProprieteAConstruire(Monopoly _monopoly, String _nomCarreau, int _numero,Groupe groupe) {
        super(_monopoly, _nomCarreau, _numero);
        this.setGroupePropriete(groupe);
        
    }

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
     * @return the _loyerMaison
     */
    public java.util.ArrayList<Integer> getLoyerMaison() {
        return _loyerMaison;
    }

    /**
     * @return the _nbMaison
     */
    public Object getNbMaison() {
        return _nbMaison;
    }

    /**
     * @return the _prixMaison
     */
    public Object getPrixMaison() {
        return _prixMaison;
    }

    /**
     * @return the _tabLoyers
     */
    public int getTabLoyers() {
        return _tabLoyers;
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
     * @param _loyerMaison the _loyerMaison to set
     */
    private void setLoyerMaison(java.util.ArrayList<Integer> _loyerMaison) {
        this._loyerMaison = _loyerMaison;
    }

    /**
     * @param _nbMaison the _nbMaison to set
     */
    private void setNbMaison(Object _nbMaison) {
        this._nbMaison = _nbMaison;
    }

    /**
     * @param _prixMaison the _prixMaison to set
     */
    private void setPrixMaison(Object _prixMaison) {
        this._prixMaison = _prixMaison;
    }

    /**
     * @param _tabLoyers the _tabLoyers to set
     */
    private void setTabLoyers(int _tabLoyers) {
        this._tabLoyers = _tabLoyers;
    }

    /**
     * @param _groupePropriete the _groupePropriete to set
     */
    private void setGroupePropriete(Groupe _groupePropriete) {
        this._groupePropriete = _groupePropriete;
    }
}