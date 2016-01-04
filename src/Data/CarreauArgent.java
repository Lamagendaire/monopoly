package Data;

public class CarreauArgent extends CarreauAction {
    private int _montant;

    public CarreauArgent(Monopoly _monopoly, String _nomCarreau, int _numero, String _type) {
        super(_monopoly, _nomCarreau, _numero,  _type);
    }

    @Override
    public void action(Joueur j) {
        j.getMonopoly().getIhm().messageCarreauArgent(_montant);
        
        if (_montant>0) {
            j.addCash(_montant);
        }
        
        else if (_montant<0) {
            j.decrementerCash(_montant);
        }
    }

    /**
     * @return the _montant
     */
    public int getMontant() {
        return _montant;
    }

    /**
     * @param _montant the _montant to set
     */
    public void setMontant(int _montant) {
        this._montant = _montant;
    }
}


