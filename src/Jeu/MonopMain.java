/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

import java.util.LinkedHashMap;
import java.util.Scanner;

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
        Monopoly monop= new Monopoly("/users/info/etu-s2/defoursr/projet/Monopoly/src/Data/data.txt","/users/info/etu-s2/defoursr/projet/Monopoly/src/Data/data-carte-Chance.txt","/users/info/etu-s2/defoursr/projet/Monopoly/src/Data/data-Carte-Communaute.txt");
        monop.initialiserPartie();
        //______________________________________________________________________
        
        
        //________________________TEST__________________________________________
        /*Joueur j1 = new Joueur("j1", monop);
        Joueur j2 = new Joueur("j2", monop);
        Joueur j3 = new Joueur("j3", monop);
        LinkedHashMap<Integer,Joueur> joueurs = new LinkedHashMap<Integer,Joueur>();
        joueurs.put(1, j1);
        joueurs.put(2, j2);
        joueurs.put(3, j3);
        monop.setJoueurs(joueurs);*/
        
        
        
        
        boolean partie= true;
        if (partie){
        //________________________LA PARTIE COMMENCE____________________________
        
            //temps qu'il reste + d'1 joueur en jeu, les tours s'enchaînent:
	while(monop.getJoueurs().size()>1 && partie){
            //Pour chaque joueur encore en jeu, on joue:
            for(Joueur j: monop.getJoueurs().values()){
                monop.setDoubleDé(true);
                monop.setCompteDoubleDé(0);
                //temps que le joueur fait des doubles sans aller en prison
                while(monop.isDoubleDé()){
                    monop.getIhm().messageEtatJoueur(j);
                    System.out.print("joueur " + j.getNom()+ " : "+j.getPositionCourante().getNumero()+"  "+j.getPositionCourante().getNomCarreau() );
                    monop.jouerUnCoup(j);
                    System.out.println("    => "+j.getPositionCourante().getNumero()+"  "+j.getPositionCourante().getNomCarreau() );
                    
                    
                }
            }
        }
        //______________________________________________________________________
        }
    }
    
}
