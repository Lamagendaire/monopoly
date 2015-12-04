package Data;

public abstract class CarreauPropriete extends Carreau {
	private int _loyerBase;
	private int _prixAchat;
	private int _prixCarreau;
	private int _loyer;
	private Joueur _proprietaire;

    public CarreauPropriete(Monopoly _monopoly, String _nomCarreau, int _numero) {
        super(_monopoly, _nomCarreau, _numero);
    }
}