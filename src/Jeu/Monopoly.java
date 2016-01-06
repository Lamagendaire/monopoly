package Jeu;
import Jeu.Carreau;
import Jeu.Joueur;
import Ui.IHM;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Monopoly {
	private int _nbMaisons = 32;
	private int _nbHotels = 12;
        private boolean _doubleDé=true;
        private int _compteDoubleDé=0;
	public IHM _ihm= new IHM();
	private HashMap<Integer,Carreau> _carreaux= new HashMap();
	private LinkedHashMap<Integer,Joueur> _joueurs = new LinkedHashMap<Integer,Joueur>();
        private LinkedList<Carte> _cartesChance = new LinkedList<Carte>();
        private LinkedList<Carte> _cartesCommunaute = new LinkedList<Carte>();
        
	public void jouerUnCoup(Joueur aJ) {
                this.getIhm().positionnement(aJ.getPositionCourante());
                lancerDésAvancer(aJ);
                this.getIhm().positionnement(aJ.getPositionCourante());
                aJ.getPositionCourante().action(aJ);
                    
                
	}

	private void lancerDésAvancer(Joueur j) {
            int totalDés = lancerDes();
            j.setTotaldes(totalDés);
            if (this.getCompteDoubleDé()<3){
                _ihm.messageJoueurCourant(j, totalDés);
                j.changerPosition(totalDés);
            }else{
                this.tripleDouble(j);
            }	
	}

	public int lancerDes() {
		int de1= (int)( Math.random()*( 6 - 1+1 ) ) + 1;
                int de2= (int)( Math.random()*( 6 - 1+1 ) ) + 1;
                if (de1==de2){this.setCompteDoubleDé(this.getCompteDoubleDé()+1);}else{this.setDoubleDé(false);}
                return de1+de2;
                
	}

	public Carreau chercherCarreau(int aNumFinal) {
		return _carreaux.get(aNumFinal);
	}

	public void tripleDouble(Joueur j) {
                for(Carreau pris: _carreaux.values()){
                    if(pris.getNomCarreau().equals("Simple Visite / En Prison")){j.setPositionCourante(pris);}
                }
		
	}
        
public void tirerCarte(Joueur j) {
            
            // On peut aussi utiliser le numéro du carreau pour identifier la position du joueur.
            
            if(j.getPositionCourante().getNomCarreau()=="Caisse de communauté") {
                
                _cartesCommunaute.element().action(j);
                _cartesCommunaute.offerLast(_cartesCommunaute.element());
                
            }
            
            else if (j.getPositionCourante().getNomCarreau()=="Chance") {
                
                _cartesChance.element().action(j);
                _cartesChance.offerLast(_cartesChance.element());
                
            }
            
        }

	public Monopoly(String dataFilename, String dataChance,String dataComm){
		buildGamePlateau(dataFilename);
                this.buildGameCardsChance(dataChance);
                this.buildGameCardsComm(dataComm);
	}
        
        
        private void buildGameCardsChance(String dataFilename) {
          try{  
              ArrayList<String[]> data = readDataFile(dataFilename, ",");
              for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
                                if(caseType.compareTo("CSP") == 0){
                                    CarteSortiePrison newCard= new CarteSortiePrison(Integer.parseInt(data.get(i)[1]),data.get(i)[2]);
                                    _cartesChance.add(newCard);
                                }else if(caseType.compareTo("CMR") == 0){
                                    CarteMouvementRelatif newCard= new CarteMouvementRelatif(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Boolean.parseBoolean(data.get(i)[4]),Integer.parseInt(data.get(i)[3]));
                                    _cartesChance.add(newCard);
                                }else if(caseType.compareTo("CMD") == 0){
                                    CarteMouvementDirect newCard= new CarteMouvementDirect(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Boolean.parseBoolean(data.get(i)[4]),Integer.parseInt(data.get(i)[3]));
                                    _cartesChance.add(newCard);
                                }
                                else if(caseType.compareTo("CR") == 0){
                                    CarteReparation newCard= new CarteReparation(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]),Integer.parseInt(data.get(i)[4]));
                                    _cartesChance.add(newCard);}
                                else if(caseType.compareTo("CA") == 0){
                                    CarteArgent newCard= new CarteArgent(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]));
                                    _cartesChance.add(newCard);}
                                else{
				    System.err.println("[buildGamePleateau()] : Type de donnée invalide");}
              }

             Collections.shuffle(_cartesChance); 
              
          }
            catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : Fichier non trouvé!");
		}
            catch(NullPointerException e){
			System.err.println("[buildGamePlateau()] : Couleur du carreau non trouvé!");
                }
            catch(IOException e){
			System.err.println("[buildGamePlateau()] : Erreur de lecture du fichier!");
		}
          
        }
        private void buildGameCardsComm(String dataFilename){
                      try{  
              ArrayList<String[]> data = readDataFile(dataFilename, ",");
              for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
                                if(caseType.compareTo("CSP") == 0){
                                    CarteSortiePrison newCard= new CarteSortiePrison(Integer.parseInt(data.get(i)[1]),data.get(i)[2]);
                                    _cartesCommunaute.add(newCard);
                                }else if(caseType.compareTo("CA") == 0){
                                    CarteArgent newCard= new CarteArgent(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]));
                                    _cartesCommunaute.add(newCard);
                                }else if(caseType.compareTo("CMD") == 0){
                                    CarteMouvementDirect newCard= new CarteMouvementDirect(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Boolean.parseBoolean(data.get(i)[4]),Integer.parseInt(data.get(i)[3]));
                                    _cartesCommunaute.add(newCard);
                                }
                                else if(caseType.compareTo("CAN") == 0){
                                    CarteAnniversaire newCard= new CarteAnniversaire(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]));
                                    _cartesCommunaute.add(newCard);}
                                else{
                                    System.err.println("[buildGamePleateau()] : Type de donnée invalide");}
              }
              
    
          }
            catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : Fichier non trouvé!");
		}
            catch(NullPointerException e){
			System.err.println("[buildGamePlateau()] : Couleur du carreau non trouvé!");
                }
            catch(IOException e){
			System.err.println("[buildGamePlateau()] : Erreur de lecture du fichier!");
		}
                      
        Collections.shuffle(_cartesCommunaute); 
        }
        
        
	
	private void buildGamePlateau(String dataFilename){
            
            ArrayList<Groupe> groupes = new ArrayList<Groupe>();
            for(CouleurPropriete coul: CouleurPropriete.values()){
                groupes.add(new Groupe(coul));
                System.out.println(coul.toString("* groupe créé *"));
                System.out.println("");
            }
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t\t" + data.get(i)[2] + "\t* case " + data.get(i)[1]);
                                        Groupe groupeChoisie=null;
                                        //Recherche de groupe
                                        for(Groupe group: groupes){
                                            if(data.get(i)[3].equals(group.getCouleur().toString())){groupeChoisie=group;}
                                        }
                                        
                                        ProprieteAConstruire newcarreau = new ProprieteAConstruire(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]),Integer.parseInt(data.get(i)[4]),"P",groupeChoisie);
                                        int tab[]= new int[5];
                                        for (int z=5;z<10;z++){
                                            tab[z-5]=Integer.parseInt(data.get(i)[z]);
                                        }
                                        newcarreau.setPrixMaison(Integer.parseInt(data.get(i)[11]));
                                        newcarreau.setPrixHotel(Integer.parseInt(data.get(i)[12]));
                                        newcarreau.setTabLoyers(tab);
                                        groupeChoisie.addPropriete(newcarreau);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t\t\t" + data.get(i)[2] + "\t* case " + data.get(i)[1]);
                                        Gare newcarreau = new Gare(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]),Integer.parseInt(data.get(i)[3]),"G");
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t\t" + data.get(i)[2] + "\t* case " + data.get(i)[1]);
                                        Compagnie newcarreau = new Compagnie(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]),Integer.parseInt(data.get(i)[3]),"C");
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t\t" + data.get(i)[2] + "\t* case " + data.get(i)[1]);
                                        CarreauTirage newcarreau = new CarreauTirage(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]),"T");
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("CA") == 0){
                                        
					System.out.println("Case Argent :\t\t" + data.get(i)[2] + "\t* case " + data.get(i)[1]);
                                        CarreauArgent newcarreau = new CarreauArgent(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]),"CA");
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("CM") == 0){
                                        System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t* case " + data.get(i)[1]);
                                        CarreauMouvement newcarreau = new CarreauMouvement(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]),"CM");
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
                                    }
                                else{
					System.err.println("[buildGamePleateau()] : Type de donnée invalide");}
                               
                                
			}
			
		} 
                
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : Fichier non trouvé!");
		}
                catch(NullPointerException e){
			System.err.println("[buildGamePlateau()] : Couleur du carreau non trouvé!");
                }
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Erreur de lecture du fichier!");
		}
                
	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		//
		return data;
	}


	public LinkedHashMap<Integer,Joueur> getJoueurs() {
		return this._joueurs;
	}

    /**
     * @return the _doubleDé
     */
    public boolean isDoubleDé() {
        return _doubleDé;
    }

    /**
     * @param _doubleDé the _doubleDé to set
     */
    public void setDoubleDé(boolean _doubleDé) {
        this._doubleDé = _doubleDé;
    }

    /**
     * @return the _compteDoubleDé
     */
    public int getCompteDoubleDé() {
        return _compteDoubleDé;
    }

    /**
     * @param _compteDoubleDé the _compteDoubleDé to set
     */
    public void setCompteDoubleDé(int _compteDoubleDé) {
        this._compteDoubleDé = _compteDoubleDé;
    }
        


    public void initialiserPartie() {
        
           
            
           int nbjoueurs = getIhm().demandeNbJoueurs();
           LinkedList<String> listNoms = new LinkedList<String>();
           
           int tabScores [];
           tabScores = new int [nbjoueurs];
            
            for (int i = 0; i < nbjoueurs; i++) {
                String nomJoueur = getIhm().demandeNomJoueur(i+1);
                listNoms.add(nomJoueur);
                
                int totDes = (int)( Math.random()*( 12 - 2 + 1 ) ) + 2;
                getIhm().afficherResDes(nomJoueur, totDes);
                
                tabScores[i] = totDes;
            }
            
            int max = 0;
            int jmax = 0;
            for (int j = 0; j < tabScores.length; j++) {
                
                if (tabScores[j] > max) {   // égalité peut etre changée
                    max = tabScores[j];
                    jmax = j;
                }
                
            }
            
            LinkedList<String> listNomsfinal = new LinkedList<String>();
            //listNomsfinal.add(listNoms.get(jmax));
            
            for (int k = jmax; k < listNoms.size(); k++) {
                listNomsfinal.add(listNoms.get(k));
            }
            
            if (jmax != 0) {
                for (int l = 0; l < jmax; l++) {
                    listNomsfinal.add(listNoms.get(l));
                }  
            }
            
            for (int m = 0; m < listNomsfinal.size(); m++) {
                _joueurs.put(m+1, new Joueur(listNomsfinal.get(m), this));
                
            }
            
            
            
            
        }


    /**
     * @return the _nbMaisons
     */
    public int getNbMaisons() {
        return _nbMaisons;
    }

    /**
     * @param _nbMaisons the _nbMaisons to set
     */
    public void setNbMaisons(int _nbMaisons) {
        this._nbMaisons = _nbMaisons;
    }

    /**
     * @return the _nbHotels
     */
    public int getNbHotels() {
        return _nbHotels;
    }

    /**
     * @param _nbHotels the _nbHotels to set
     */
    public void setNbHotels(int _nbHotels) {
        this._nbHotels = _nbHotels;
    }

    /**
     * @return the _ihm
     */
    public IHM getIhm() {
        return _ihm;
    }

    /**
     * @param _ihm the _ihm to set
     */
    public void setIhm(IHM _ihm) {
        this._ihm = _ihm;
    }

    /**
     * @return the _carreaux
     */
    public HashMap<Integer,Carreau> getCases() {
        return _carreaux;
    }

    /**
     * @param _carreaux the _carreaux to set
     */
    public void setCarreaux(HashMap<Integer,Carreau> _carreaux) {
        this._carreaux = _carreaux;
    }

    /**
     * @param _joueurs the _joueurs to set
     */
    public void setJoueurs(LinkedHashMap<Integer,Joueur> _joueurs) {
        this._joueurs = _joueurs;
    }
    void decrementerMaison() {
        _nbMaisons = _nbMaisons - 1;
    }

    void decrementerHotel() {
        _nbHotels = _nbHotels - 1;
    }
        
}

