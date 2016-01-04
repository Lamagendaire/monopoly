package Data;

public class CarreauTirage extends CarreauAction {

    public CarreauTirage(Monopoly _monopoly, String _nomCarreau, int _numero, String _type) {
        super(_monopoly, _nomCarreau, _numero,  _type);
    }

    @Override
    public void action(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}