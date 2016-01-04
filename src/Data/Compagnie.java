package Data;

public class Compagnie extends CarreauPropriete {

    public Compagnie(Monopoly _monopoly, String _nomCarreau, int _numero,int _prixCarreau, String _type) {
        super(_monopoly, _nomCarreau,_type, _numero,_prixCarreau);
    }

    @Override
    public int calculLoyer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addprop(Joueur j) {
        j.addCompagnie(this);
    }


}