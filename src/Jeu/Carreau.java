package Jeu;

import java.util.HashSet;

public abstract class Carreau {
	private int _numero;
	private String _nomCarreau;
	private Monopoly _monopoly;
        private String _type;
        
        
        
        
        
        public Carreau(Monopoly _monopoly,String _nomCarreau,int _numero,String _type){
            this.setMonopoly(_monopoly);
            this.setNomCarreau(_nomCarreau);
            this.setNumero(_numero);
            this.setType(_type);
        }
        
        protected void construire(Joueur J){
            
            
            int nbMaisonsTotal = this.getMonopoly().getNbMaisons();
            int nbHotelsTotal = this.getMonopoly().getNbHotels();
            boolean achatMaison;
            
            if (nbMaisonsTotal > 0 && nbHotelsTotal > 0 && J.getPositionCourante() != this.getMonopoly().getCases().get(11) ) {
                
                HashSet<ProprieteAConstruire> pConstructibles = new HashSet<>();
                
                pConstructibles = J.propriétéConstructible();
                if (pConstructibles.isEmpty()!=true){
                ProprieteAConstruire pacChoisie = this.getMonopoly().getIhm().choixProprieteAConstruire(pConstructibles);
                if(pacChoisie!=null){
                int prixMaison = pacChoisie.getPrixMaison();
                
                
                int cash = J.getCash();
                
                if (cash >= prixMaison) {
                    
                    int nbMaisons = pacChoisie.getNbMaisons();
                    
                    if (nbMaisons >= 0 && nbMaisons <= 3) {
                        
                        if (nbMaisonsTotal > 0 ) {
                            int prix = pacChoisie.getPrixMaison();
                            achatMaison = this.getMonopoly().getIhm().demandeConstructionMaison(prix);
                            
                            if (achatMaison) {
                                
                                
                                J.decrementerCash(prix);
                                pacChoisie.addMaison();
                                
                                this.getMonopoly().decrementerMaison();
                            }
                         
                            else {
                                this.getMonopoly().getIhm().messageMaison();
                            }
                            
                        }
                        
                        
                        
                        
                        
                    }
                    
                    else {
                        
                        if (nbHotelsTotal > 0 ) {
                            
                            boolean achatHotel;
                            int prix = pacChoisie.getPrixMaison();
                            achatHotel = this.getMonopoly().getIhm().demandeConstructionHotel(prix);
                            
                            if (achatHotel) {
                                
                                J.decrementerCash(prix);
                                pacChoisie.addMaison();
                                this.getMonopoly().decrementerHotel();
                                
                            }
                            else{
                                this.getMonopoly().getIhm().messageHotel();
                            }
                            
                            
                        }
                        
                    }
                    
                    
                    
                }
                }
                }
            }  
            
        }
        

	public int getNumero() {
		return this._numero;
	}

	public String getNomCarreau() {
		return this._nomCarreau;
	}
        
        public abstract void action(Joueur j);
            
        
            
        

    /**
     * @param _numero the _numero to set
     */
    protected void setNumero(int _numero) {
        this._numero = _numero;
    }

    /**
     * @param _nomCarreau the _nomCarreau to set
     */
    protected void setNomCarreau(String _nomCarreau) {
        this._nomCarreau = _nomCarreau;
    }

    /**
     * @param _monopoly the _monopoly to set
     */
    protected void setMonopoly(Monopoly _monopoly) {
        this._monopoly = _monopoly;
    }

    /**
     * @return the _monopoly
     */
    public Monopoly getMonopoly() {
        return _monopoly;
    }

    /**
     * @return the _type
     */
    public String getType() {
        return _type;
    }

    /**
     * @param _type the _type to set
     */
    private void setType(String _type) {
        this._type = _type;
    }
    
    
    
}