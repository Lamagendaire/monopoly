package Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Data.Joueur;
import Data.Carreau;
import Ui.IHM;
import java.util.ArrayList;
import java.util.HashMap;

public class Monopoly {
	private int _nbMaisons = 32;
	private int _nbHotels = 12;
	public IHM _ihm;
	private HashMap<Integer,Carreau> _carreaux= new HashMap();
	private ArrayList<Joueur> _joueurs = new ArrayList<Joueur>();
        //coucou tu as gagné
	public void jouerUnCoup(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	private void lancerDésAvancer() {
		throw new UnsupportedOperationException();
	}

	public int lancerDes() {
		throw new UnsupportedOperationException();
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
        
}