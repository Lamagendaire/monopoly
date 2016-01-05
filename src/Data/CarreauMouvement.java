package Data;

public class CarreauMouvement extends CarreauAction {

    public CarreauMouvement(Monopoly _monopoly, String _nomCarreau, int _numero, String _type) {
        super(_monopoly, _nomCarreau, _numero, _type);
    }

 
    @Override
    public void action(Joueur j) {
        for(Carreau pris: this.getMonopoly().getCases().values()){
                    if(pris.getNomCarreau().equals("Simple Visite / En Prison")){j.setPositionCourante(pris);}
                }
    }
}