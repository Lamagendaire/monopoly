package Jeu;

public class Gare extends CarreauPropriete {

    public Gare(Monopoly _monopoly, String _nomCarreau, int _numero,int _prixCarreau,String _type) {
        super(_monopoly, _nomCarreau,_type, _numero,_prixCarreau);
    }

	public int montantLoyer(int aNb) {
		return(25*aNb);
	}


    @Override
    public int calculLoyer(Joueur jp,Joueur j) {
        int nbGare= jp.getGares().size();
        String nom = jp.getNom();
        int prix=this.montantLoyer(nbGare);
        this.getMonopoly().getIhm().messagePayerLoyer(jp,j,prix);
        return prix;
    }

    @Override
    public void addprop(Joueur j) {
        j.addGare(this);
    }

    @Override
    public int calculLoyer(Joueur jp) {
        int nbGare= jp.getGares().size();
        String nom = jp.getNom();
        int prix=this.montantLoyer(nbGare);
        return prix;
    }

}