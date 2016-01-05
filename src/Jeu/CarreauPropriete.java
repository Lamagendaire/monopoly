package Jeu;

public abstract class CarreauPropriete extends Carreau {
	private int _prixCarreau;
	private int _loyer;
	private Joueur _proprietaire;

    public CarreauPropriete(Monopoly _monopoly, String _nomCarreau,String _type, int _numero,int _prixCarreau) {
        super(_monopoly, _nomCarreau, _numero,_type);
        _proprietaire=null;
        this._prixCarreau= _prixCarreau;
    }
        @Override
    public void action(Joueur j) {
        
        if(getProprietaire()==null){
            this.acheterProriete(j);
            
        }else{
            if(j!=this.getProprietaire()){
                int loyer=calculLoyer(this.getProprietaire(),j);
                this.getProprietaire().recevoirLoyer(loyer);
                j.payerLoyer(loyer);
            }
        }

    }
    
    public abstract void addprop(Joueur j);
    
    public void acheterProriete(Joueur j){
        int cash=j.getCash();
        if(cash>this.getPrixCarreau()){
            if(this.getMonopoly().getIhm().Achat(this.getNomCarreau(), cash)){
                this.setProprietaire(j);
                String choix=this.getType();
                this.addprop(j);
                j.decrementerCash(this.getPrixCarreau());
                
        }
      }
    }
    
    public abstract int calculLoyer(Joueur jp,Joueur j);

    /**
     * @return the _prixCarreau
     */
    protected int getPrixCarreau() {
        return _prixCarreau;
    }

    /**
     * @param _prixCarreau the _prixCarreau to set
     */
    protected void setPrixCarreau(int _prixCarreau) {
        this._prixCarreau = _prixCarreau;
    }

    /**
     * @return the _loyer
     */
    protected int getLoyer() {
        return _loyer;
    }

    /**
     * @param _loyer the _loyer to set
     */
    protected void setLoyer(int _loyer) {
        this._loyer = _loyer;
    }

    /**
     * @return the _proprietaire
     */
    protected Joueur getProprietaire() {
        return _proprietaire;
    }

    /**
     * @param _proprietaire the _proprietaire to set
     */
    protected void setProprietaire(Joueur _proprietaire) {
        this._proprietaire = _proprietaire;
    }
    
}