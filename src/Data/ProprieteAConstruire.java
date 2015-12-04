package Data;

public class ProprieteAConstruire extends CarreauPropriete {
	private int _nbMaisons = 0;
	private int _nbHotels = 0;
	private java.util.ArrayList<Integer> _loyerMaison;
	private Object _nbMaison;
	private Object _prixMaison;
	private int _tabLoyers;
	private Groupe _groupePropriete;

    public ProprieteAConstruire(Monopoly _monopoly, String _nomCarreau, int _numero) {
        super(_monopoly, _nomCarreau, _numero);
    }
}