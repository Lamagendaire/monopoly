package Data;

public class Gare extends CarreauPropriete {

    public Gare(Monopoly _monopoly, String _nomCarreau, int _numero,String _type) {
        super(_monopoly, _nomCarreau,_type, _numero);
    }

	public void action(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	private int calculLoyer() {
		throw new UnsupportedOperationException();
	}

	private Joueur getProprietaire() {
		throw new UnsupportedOperationException();
	}

	private void acheterPropriete() {
		throw new UnsupportedOperationException();
	}

	private void construire() {
		throw new UnsupportedOperationException();
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
}