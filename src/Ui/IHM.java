package Ui;

import Jeu.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class IHM {
    
    
        public IHM(){}
	
    

	public void messageJoueurCourant(Joueur aJ, int aTotalDes) {
            
            System.out.println("Vous avancez de " + aTotalDes + " cases.");
            
	}

	public void messagePrison(Joueur aJ) {
            
            
	}

	public void messageEtatJoueur(Joueur aJ) {
            
            System.out.println("Infos sur " + aJ.getNom() + " : ");
            System.out.println("---------------------------------");
            System.out.println("Cash : " + aJ.getCash());
            System.out.println("Propriétés possédées : ");
            for (ProprieteAConstruire pac : aJ.getProprietesAConstruire()) {
                
                System.out.println(pac.getNomCarreau());
                System.out.println("Groupe : " + pac.getGroupePropriete().toString());
                if (pac.getNbMaisons() < 5) {
                System.out.println("Nombre de maisons : " + pac.getNbMaisons());
                }
                else {
                System.out.println("Un hôtel");
                }
                System.out.println("--------------------------------------");
                
            }
            System.out.println("Compagnies possédées : ");
            for (Compagnie c : aJ.getCompagnies()) {
                
                System.out.println(c.getNomCarreau());
                System.out.println("-------------------------------------------");
            }
            System.out.println("Gares possédées : ");
            for (Gare g : aJ.getGares()) {
                
                System.out.println(g.getNomCarreau());
                System.out.println("-------------------------------------------");
            }
            
            System.out.println("Position actuelle : " + aJ.getPositionCourante().getNomCarreau() + " : Case n°" + aJ.getPositionCourante().getNumero());
            if (aJ.getCartesPrison()>0) {
                
                System.out.println("Carte prison possédées : " + aJ.getCartesPrison());
            }
           
            
           
            
	}
        public void messagePayerLoyer(Joueur proprio,Joueur payeur, int montant) {
		
            System.out.println(payeur.getNom() + " paye un montant de " + montant + " à " + proprio.getNom() + "pour être passé sur " + payeur.getPositionCourante().getNomCarreau() );
            
            
	}
        public void messagePayerCompagnie(Joueur proprio,Joueur payeur, int montant,int des) {
            
            System.out.println(payeur.getNom() + " paye un montant de " + montant + " à " + proprio.getNom() + "pour être passé sur " + payeur.getPositionCourante().getNomCarreau() + "en faisant un total de " + des + " au dés" );
            
	}
        
        public boolean Achat(String nomCarreau, int prix) {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez-vous acheter "+ nomCarreau + " ? y/n");
            String rep = sc.nextLine();
            
            boolean ok = false;
            boolean rep2 = false;
        
            while (ok == false) {
 
             if (rep=="y") {
            
            ok = true;
            rep2 = true;
            
            }
            else if (rep == "n") {
            
            ok = true;
            rep2 = false;
            
            }
            else {
            
            System.out.println("Réponse incorrecte");
            
            }
        
            }
            
        return rep2;
            
            
            
	}
        
        public void messageCarreauArgent (int montant) {
            
            
            if (montant > 0) {
                
            System.out.println("Vous recevez un montant de "+ montant);
                    
            }
            else {
                
            System.out.println("Vous payez un montant de " + montant);
                
            }
            
        }
        
        
        
        
        public boolean demandeConstructionMaison() {
        
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        boolean rep2 = false;
        
        while (ok == false) {
        
        System.out.println("Voulez-vous construire une maison sur cette propriété ? y/n ");
        String rep = sc.nextLine();
        
        if (rep=="y") {
            
            ok = true;
            rep2 = true;
            
        }
        else if (rep == "n") {
            
            ok = true;
            rep2 = false;
            
        }
        else {
            
            System.out.println("Réponse incorrecte");
            
        }
        
        }
            
        return rep2;
        
            
    }

    public boolean demandeConstructionHotel() {
       Scanner sc = new Scanner(System.in);
        boolean ok = false;
        boolean rep2 = false;
        
        while (ok == false) {
        
        System.out.println("Voulez-vous construire un hôtel sur cette propriété ? y/n ");
        String rep = sc.nextLine();
        
        if (rep=="y") {
            
            ok = true;
            rep2 = true;
            
        }
        else if (rep == "n") {
            
            ok = true;
            rep2 = false;
            
        }
        else {
            
            System.out.println("Réponse incorrecte");
            
        }
        
        }
            
        return rep2;
    }
        
        
        public int demandeNbJoueurs() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre de joueurs : ");
            return sc.nextInt();
            
        }
        
        public ProprieteAConstruire choixProprieteAConstruire(HashSet<ProprieteAConstruire> pConstructibles) { 
            Scanner sc = new Scanner(System.in);
            boolean ok = false;
            ProprieteAConstruire pChoisie = null;
            
            ProprieteAConstruire pCons [] = null;
            int i = 1;
            for (ProprieteAConstruire pac : pConstructibles) {
                 pCons[i] = pac;
                 i++;
            }
            
            System.out.println("Propriété où construire : ");
            
            for (int j = 1; j< pCons.length; j++) {
                System.out.println(j + ". " + pCons[j].getNomCarreau() );
            }
            
            while (ok == false) {
            
            System.out.println("Propriété choisie : (chiffre correspondant) ");
            int rep = sc.nextInt();
            
            if (rep > pCons.length || rep < 1) {
                System.out.println("Saisie incorrecte.");
            }
            else {
                pChoisie = pCons[rep];
                ok = true;
            }
         
            
            }
            
            return pChoisie;
            
        } 
        
        public String demandeNomJoueur(int i) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nom joueur n°" + i + " ");
            return sc.nextLine();
        }
        
        public void afficherResDes(String nomJ, int TotDes) {
            System.out.println("Lancé dés de " + nomJ + " : " + TotDes );
        }

    public void messageAnniversaire(int montantTot) {
        
        System.out.println("Vous recevez un total de " + montantTot);
        
    }

}