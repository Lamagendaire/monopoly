package Data;
import Data.Carreau;
import Data.Joueur;
import Ui.IHM;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Monopoly {
	private int _nbMaisons = 32;
	private int _nbHotels = 12;
        private boolean _doubleDé=true;
        private int _compteDoubleDé=0;
	public IHM _ihm;
	private HashMap<Integer,Carreau> _carreaux= new HashMap();
	private LinkedHashMap<String,Joueur> _joueurs = new LinkedHashMap<String,Joueur>();
        //coucou tu as gagné
	public void jouerUnCoup(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	private void lancerDésAvancer(Joueur j) {
            int totalDés = lancerDes();
		
	}

	public int lancerDes() {
		int de1= (int)( Math.random()*( 6 - 1+1 ) ) + 1;
                int de2= (int)( Math.random()*( 6 - 1+1 ) ) + 1;
                if (de1==de2){this.setCompteDoubleDé(this.getCompteDoubleDé()+1);}else{this.setDoubleDé(false);}
                return de1+de2;
                
	}

	public Carreau chercherCarreau(int aNumFinal) {
		throw new UnsupportedOperationException();
	}

	public void tripleDouble() {
		throw new UnsupportedOperationException();
	}

        


	public Monopoly(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        ProprieteAConstruire newcarreau = new ProprieteAConstruire(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]));
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        Gare newcarreau = new Gare(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]));
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        Compagnie newcarreau = new Compagnie(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]));
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        CarreauTirage newcarreau = new CarreauTirage(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]));
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("CA") == 0){
                                        
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        CarreauArgent newcarreau = new CarreauArgent(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]));
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        CarreauMouvement newcarreau = new CarreauMouvement(this,data.get(i)[2],Integer.parseInt(data.get(i)[1]));
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]), newcarreau);
				}
				else
					System.err.println("[buildGamePleateau()] : Type de donnée invalide");
                                //_carreaux.put(data.get(i)[1], new Carreau(this,data.get(i)[2],data.get(i)[1]));
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : Fichier non trouvé!");
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
		
		return data;
	}


	public HashMap<Integer,Joueur> getJoueurs() {
		throw new UnsupportedOperationException();
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
            
            for (int i = 1; i <= nbjoueurs; i++) {
                String nomJoueur = getIhm().demandeNomJoueur(i);
                _joueurs.put(nomJoueur, new Joueur(nomJoueur, this));
            }
            
            int max = 0;
            String joueurMax = null;
            for (Joueur J : _joueurs.values()) {
                int totDes = (int)( Math.random()*( 12 - 2 + 1 ) ) + 2;
                        
                getIhm().afficherResDes(J, totDes);
                if (totDes >= max) {
                    joueurMax = J.getNom();
                    max = totDes;
                }
            }
            
            LinkedHashMap<String,Joueur> temp = new LinkedHashMap<String,Joueur>();
            temp.put(joueurMax, _joueurs.get(joueurMax));
            for (Joueur j1 : _joueurs.values()) {
                if (j1.getNomJoueur()!= joueurMax) {
                    temp.put(j1.getNomJoueur(), j1);  // Ordre mal rangé (à revoir)
                }
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
    public HashMap<Integer,Carreau> getCarreaux() {
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
    public void setJoueurs(LinkedHashMap<String,Joueur> _joueurs) {
        this._joueurs = _joueurs;
    }
        
}

