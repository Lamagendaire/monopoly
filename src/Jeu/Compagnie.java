package Jeu;

public class Compagnie extends CarreauPropriete {

    public Compagnie(Monopoly _monopoly, String _nomCarreau, int _numero,int _prixCarreau, String _type) {
        super(_monopoly, _nomCarreau,_type, _numero,_prixCarreau);
    }

    @Override
    public int calculLoyer(Joueur jp,Joueur j) {
        int nbComp= jp.getCompagnies().size();
        String nom = jp.getNom();
        int prix=this.montantLoyer(j,nbComp);
        this.getMonopoly().getIhm().messagePayerLoyer(jp,j,prix);
        return prix;
    }
    public int montantLoyer(Joueur j,int aNb) {
                int totalDes=j.getTotaldes();
		if(totalDes==0){
                    int mem=this.getMonopoly().getCompteDoubleDé();
                    totalDes=this.getMonopoly().lancerDes();
                    this.getMonopoly().setCompteDoubleDé(mem);
                }
                int prix=0;
                switch(aNb){
                    case(1): {prix=totalDes*4;}
                    case(2): {prix=totalDes*10;}
                }
                return (prix);
	}

    @Override
    public void addprop(Joueur j) {
        j.addCompagnie(this);
    }

    @Override
    public int calculLoyer(Joueur jp) {
        throw new UnsupportedOperationException("Loyer non prévisible"); 
    }


}