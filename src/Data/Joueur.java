package Data;

import java.util.ArrayList;
import java.util.HashSet;

public class Joueur {
	private String _nomJoueur;
	private int _cash = 1500;
	private Monopoly _monopoly;
	private ArrayList<Compagnie> _compagnies = new ArrayList<Compagnie>();
	private ArrayList<Gare> _gares = new ArrayList<Gare>();
	private Carreau _positionCourante;
	private ArrayList<ProprieteAConstruire> _proprietesAConstruire = new ArrayList<ProprieteAConstruire>();

	public void payerLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

	public void recevoirLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

	public HashSet<Gare> getLesGares() {
		throw new UnsupportedOperationException();
	}

	public String getNom() {
		throw new UnsupportedOperationException();
	}

	public void cashRestant(int aL) {
		throw new UnsupportedOperationException();
	}

	public int getCash() {
		return this._cash;
	}

	public void decrementerCash(int aPrix) {
		throw new UnsupportedOperationException();
	}

	public int getNbGare() {
		throw new UnsupportedOperationException();
	}

	public void changerPosition(int aTotalDes) {
		throw new UnsupportedOperationException();
	}

	public Carreau getPositionCourante() {
		return this._positionCourante;
	}

	public void nouvellePosition(int aTotalDes, int aNum) {
		throw new UnsupportedOperationException();
	}

	public void setPositionCourante(Carreau aC2) {
		throw new UnsupportedOperationException();
	}
}