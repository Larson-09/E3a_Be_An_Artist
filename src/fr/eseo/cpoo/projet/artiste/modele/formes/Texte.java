package fr.eseo.cpoo.projet.artiste.modele.formes;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class Texte extends Forme {

	// Variables d'instance
	// =====================================================
	private String texte;
	private int taille;
	
	// Constructeur
	// =====================================================
	public Texte(String txt, int taille, double abs, double ord) {
		this.texte = txt;
		this.taille = taille;
		this.setPosition(new Coordonnees(abs, ord));
	}
	
	// Getters / Setters
	// =====================================================
	public String getTexte() {
		return this.texte;
	}
	
	public void setTexte(String nouveauTexte) {
		this.texte = nouveauTexte;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void getTaille(int nouvelleTaille) {
		this.taille = nouvelleTaille;
	}
	
	// Methodes heritees
	// =====================================================
	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return 0;
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		return false;
	}

}
