package Data;

public abstract class Carreau {
	private int _numero;
	private String _nomCarreau;
	private Monopoly _monopoly;
        
        
        
        
        
        public Carreau(Monopoly _monopoly,String _nomCarreau,int _numero){
            this.setMonopoly(_monopoly);
            this.setNomCarreau(_nomCarreau);
            this.setNumero(_numero);
        }
        

	public int getNumero() {
		return this._numero;
	}

	public String getNomCarreau() {
		return this._nomCarreau;
	}

    /**
     * @param _numero the _numero to set
     */
    private void setNumero(int _numero) {
        this._numero = _numero;
    }

    /**
     * @param _nomCarreau the _nomCarreau to set
     */
    private void setNomCarreau(String _nomCarreau) {
        this._nomCarreau = _nomCarreau;
    }

    /**
     * @param _monopoly the _monopoly to set
     */
    private void setMonopoly(Monopoly _monopoly) {
        this._monopoly = _monopoly;
    }

    /**
     * @return the _monopoly
     */
    public Monopoly getMonopoly() {
        return _monopoly;
    }
}