/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

import Data.*;

/**
 *
 * @author defoursr
 */
public class MonopMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //_________________________INITIALISATION_______________________________
        Monopoly monop= new Monopoly("/users/info/etu-s2/defoursr/projet/Monopoly/src/Data/data.txt");
        //______________________________________________________________________
        
        
        
        
        //________________________LA PARTIE COMMENCE____________________________
        
            //temps qu'il reste + d'1 joueur en jeu, les tours s'enchaînent:
	while(monop.getJoueurs().size()<1){
            //Pour chaque joueur encore en jeu, on joue:
            for(Joueur j: monop.getJoueurs().values()){
                //temps que le joueur fait des doubles sans aller en prison
                while(monop.isDoubleDé()){
                    monop.jouerUnCoup(j);
                }
            }
        }
        //______________________________________________________________________
    }
    
}
