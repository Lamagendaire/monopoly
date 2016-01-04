package Data;

public class Gare extends CarreauPropriete {

    public Gare(Monopoly _monopoly, String _nomCarreau, int _numero,int _prixCarreau,String _type) {
        super(_monopoly, _nomCarreau,_type, _numero,_prixCarreau);
    }




	public int getLoyer() {
		throw new UnsupportedOperationException();
	}

	public int montantLoyer(int aNb, int aL) {
		throw new UnsupportedOperationException();
	}

	public int getPrix() {
		throw new UnsupportedOperationException();
	}

	public String getNom() {
		throw new UnsupportedOperationException();
	}

	public void setProprietaire(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

    @Override
    public int calculLoyer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addprop(Joueur j) {
        j.addGare(this);
    }

}