package Ui;

import Jeu.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class IHM {
    
    
        public IHM(){}
        
	public void messagePrison3doubles() {
        
        System.out.println("Vous avez fait trois doubles d'affilé. Vous êtes envoyé en prison.");
        }

        public void egalité() {
        
        System.out.println("Egalité !!!");
        
        }
    

	public void messageJoueurCourant(Joueur aJ, int aTotalDes) {
            
            System.out.println("Vous avancez de " + aTotalDes + " cases.");
            
	}
        public void messageDepart(){
            System.out.println(CouleurPropriete.vert.toString("Case départ: recevez 200$"));
        }
        
        public void messageMaison(){
            System.out.println("Il n'y a pas de maisons disponibles.");
        }
        
        public void messageHotel(){
            System.out.println("Il n'y a pas d'Hotêls disponibles.");
        }
        
        public void positionnement(Carreau carreau){
            System.out.println("n°"+carreau.getNumero()+" "+carreau.getNomCarreau());
        }
        
        public void messageCarteCommunauté(Carte c) {
        
        System.out.println("Vous piochez une carte communauté : " + c.getTexte());
        
        }

        public void messageCarteChance(Carte c) {
        
        System.out.println("Vous piochez une carte chance : " + c.getTexte());
        
        }

	public void messagePrison(Joueur aJ) {
            System.out.println("Le joueur " + aJ.getNom() + " est en prison. Faites un double ou payez 50$ au bout de 3 tours.");
            
	}
        public void WINNER(Joueur j){
            System.out.println(CouleurPropriete.rouge.toString("LE GAGNANT EST "+ j.getNom()+"!!!"));
        }
                
                
        public void messagePayerPrison(){
            System.out.println("Vous payez 50$ et sortez de prison.");
        }
        
        public void messageConfirmationLancerDes(){
            
             Scanner sc = new Scanner(System.in);
             System.out.print("Lancer Dés ");
             String rep = sc.nextLine();
             
        }
        
        public void messageLancerDes(int des1, int des2){
            System.out.println("lancé: "+des1 +"+"+ des2 + " = "+ (des1+des2));
        }

	public void messageEtatJoueur(Joueur aJ) {
            System.out.println("");
            System.out.println(CouleurPropriete.gris.toString("_______________________________________"));
            System.out.println(CouleurPropriete.gris.toString("Infos sur " + aJ.getNom() + " : \t\t\t"));
            
            System.out.println(CouleurPropriete.vert.toString("Cash : " + aJ.getCash()+"\t\t\t\t"));
            System.out.println(CouleurPropriete.gris.toString("---------------------------------------"));
            System.out.println(CouleurPropriete.gris.toString("Propriétés possédées : \t\t"));
            for (ProprieteAConstruire pac : aJ.getProprietesAConstruire()) {
                
                System.out.print(pac.getGroupePropriete().getCouleur().toString(pac.getNomCarreau()));
                if (pac.getNbMaisons() < 5) {
                System.out.println(pac.getGroupePropriete().getCouleur().toString("|maison:" + pac.getNbMaisons()+"| "+pac.calculLoyer(aJ)+"$\t"));
                }
                else {
                System.out.println(pac.getGroupePropriete().getCouleur().toString("| un Hôtel | "+pac.calculLoyer(aJ)+"$\t"));
                }
                System.out.println(CouleurPropriete.gris.toString("******************\t\t\t"));
                
            }
            System.out.println(CouleurPropriete.gris.toString("---------------------------------------"));
            System.out.println(CouleurPropriete.gris.toString("Compagnies possédées : \t\t"));
            for (Compagnie c : aJ.getCompagnies()) {
                
                System.out.println(CouleurPropriete.gris.toString(c.getNomCarreau()));
                System.out.println(CouleurPropriete.gris.toString("---------------------------------------"));
            }
            System.out.println(CouleurPropriete.gris.toString("Gares possédées : \t\t\t"));
            for (Gare g : aJ.getGares()) {
                
                System.out.println(CouleurPropriete.gris.toString(g.getNomCarreau()+"\t\t\t\t"));
                System.out.println(CouleurPropriete.gris.toString("---------------------------------------"));
            }
            if (aJ.getCartesPrison()>0) {
                
                System.out.println(CouleurPropriete.gris.toString("Carte prison possédées : " + aJ.getCartesPrison()));
            }
            System.out.println(CouleurPropriete.gris.toString("_______________________________________"));
           
            
           
            
	}
        public void messagePayerLoyer(Joueur proprio,Joueur payeur, int montant) {
		
            System.out.println(CouleurPropriete.rouge.toString(payeur.getNom() + " paye un montant de " + montant + " à " + proprio.getNom() + " pour être passé sur " + payeur.getPositionCourante().getNomCarreau() ));
            
            
	}
        public void messagePayerCompagnie(Joueur proprio,Joueur payeur, int montant,int des) {
            
            System.out.println(payeur.getNom() + " paye un montant de " + montant + " à " + proprio.getNom() + "pour être passé sur " + payeur.getPositionCourante().getNomCarreau() + "en faisant un total de " + des + " au dés" );
            
	}
        
        public boolean Achat(String nomCarreau, int prix) {
            
            Scanner sc = new Scanner(System.in);
            boolean ok = false;
            boolean rep2 = false;
        
            while (ok == false) {
            System.out.println("Voulez-vous acheter "+ nomCarreau +" pour "+prix+"$ ? y/n");
            String rep = sc.nextLine();
            
            
 
             if ("y".equals(rep)) {
            
            ok = true;
            rep2 = true;
            
            }
            else if ("n".equals(rep)) {
            
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
        
        
        
        
        public boolean demandeConstructionMaison(int prix) {
        
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        boolean rep2 = false;
        
        while (ok == false) {
        
        System.out.println("Voulez-vous construire une maison sur cette propriété ? y/n ");
        String rep = sc.nextLine();
        
        if ("y".equals(rep)) {
            
            ok = true;
            rep2 = true;
            
        }
        else if ("n".equals(rep)) {
            
            ok = true;
            rep2 = false;
            
        }
        else {
            
            System.out.println("Réponse incorrecte");
            
        }
        
        }
            
        return rep2;
        
            
    }

    public boolean demandeConstructionHotel(int prix) {
       Scanner sc = new Scanner(System.in);
        boolean ok = false;
        boolean rep2 = false;
        
        while (ok == false) {
        
        System.out.println("Voulez-vous construire un hôtel sur cette propriété ? y/n ");
        String rep = sc.nextLine();
        
        if ("y".equals(rep)) {
            
            ok = true;
            rep2 = true;
            
        }
        else if ("n".equals(rep)) {
            
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
            
            ProprieteAConstruire pCons [] = new ProprieteAConstruire[33];
            int i = 0;
            
            for (ProprieteAConstruire pac : pConstructibles) {
                 pCons[i] = pac;
                 i++;
            }
            
            System.out.println("Propriété où construire : ");
             System.out.println(CouleurPropriete.gris.toString(" 0.Tour suivant"));
            
            for (int j = 0; j<= pConstructibles.size()-1; j++) {
                System.out.println(pCons[j].getGroupePropriete().getCouleur().toString((j+1) + ". " + pCons[j].getNomCarreau()+"  Prix Maison/Hôtel "+pCons[j].getPrixMaison()+"$"));
            }
            
            while (ok == false) {
            
            System.out.println("Propriété choisie : ");
            int rep = sc.nextInt();
            
            if(rep==0){ok=true;}else
            if (rep > pCons.length || rep < 1 ) {
                System.out.println("Saisie incorrecte.");
            }
            else {
                pChoisie = pCons[rep-1];
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
   
    public void messageFailliteProp(Joueur J) {
        
        System.out.println("Le joueur " + J.getNom() + " a fait faillite, toutes ses propriétés sont remises en jeu.");
        
    }
    
    public boolean proposerCartePrison() {
        boolean rep2 = false;
        boolean ok = false;
        
        Scanner sc = new Scanner(System.in);
        
        while(ok== false) {
        System.out.println("Voulez-vous utiliser une carte de sortie de prison ? y/n");
        String rep = sc.nextLine();
        
        if (rep.equals("y")) {
            
            ok = true;
            rep2 = true;
            
            System.out.println("Carte de sortie de prison utilisée");
            
        }
        else if (rep.equals("n")) {
            
            ok = true;
            rep2 = false;
        }
        else {
            System.out.println("Saisie incorrecte");
        }
        
        }
        
        return rep2;
        
        
    }
    
    public void afficherTotalReparation(int total) {
        
        System.out.println("Le total des réparations s'éléve à : "+ total+"$");
        
    }
    
    
    
    
    
    
    
    


}