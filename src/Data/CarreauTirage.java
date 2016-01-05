package Data;

public class CarreauTirage extends CarreauAction {

    public CarreauTirage(Monopoly _monopoly, String _nomCarreau, int _numero, String _type) {
        super(_monopoly, _nomCarreau, _numero,  _type);
    }

    @Override
    public void action(Joueur j) {
        j.getMonopoly().tirerCarte(j);
    }
}

