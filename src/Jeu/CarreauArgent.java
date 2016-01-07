package Jeu;

public class CarreauArgent extends CarreauAction {
    private int _montant;

    public CarreauArgent(Monopoly _monopoly, String _nomCarreau, int _numero, String _type,int _montant) {
        super(_monopoly, _nomCarreau, _numero,  _type);
        this.setMontant(_montant);
    }

    @Override
    public void action(Joueur j) {
        if(_montant!=0){
        j.getMonopoly().getIhm().messageCarreauArgent(_montant);
        
            j.addCash(_montant);
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


