package Ui;

import Data.Joueur;
import Data.Monopoly;
import java.util.Scanner;

public class IHM {
	public Monopoly _monopoly;

	public void messageJoueurCourant(Joueur aJ, int aTotalDes) {
		throw new UnsupportedOperationException();
	}

	public void messagePrison(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public void messageEtatJoueur(Joueur aJ) {
		throw new UnsupportedOperationException();
	}
        
        
        public int demandeNbJoueurs() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre de joueurs : ");
            return sc.nextInt();
            
        }
        
        public String demandeNomJoueur(int i) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nom joueur n°" + i + " ");
            return sc.nextLine();
        }
        
        public void afficherResDes(Joueur J, int TotDes) {
            System.out.println("Lancé dés de " + J.getNom() + " : " + TotDes );
        }




}