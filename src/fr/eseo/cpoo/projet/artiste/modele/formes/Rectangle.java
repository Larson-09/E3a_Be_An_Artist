package fr.eseo.cpoo.projet.artiste.modele.formes;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.Remplissable;
import fr.eseo.cpoo.projet.artiste.modele.Remplissage;

public class Rectangle extends Forme implements Remplissable {
	
	
	// Varaibles d'instance
	// =======================================================================================
	private Remplissage modeRemplissage;
	
	// Constructeurs 
	// =======================================================================================

	public Rectangle(){
		this (new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Rectangle(Coordonnees position, double largeur, double hauteur){
		super(position, largeur, hauteur);
	}
	
	public Rectangle(double largeur, double hauteur){
		this(new Coordonnees(),largeur, hauteur);
	}
	
	public Rectangle(Coordonnees position){
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	// Getters / Setters
	// =======================================================================================
	
	@Override
	public Remplissage getRemplissage() {
		return this.modeRemplissage;
	}

	@Override
	public void setRemplissage(Remplissage nouveauModeRemplissage) {
		this.modeRemplissage = nouveauModeRemplissage;
		
	}
	
	// Methodes 
	// =======================================================================================
	
	@Override
	public double perimetre() {
		return this.getHauteur() * this.getLargeur();
	}
	
	@Override
	public double aire() {
		return this.getHauteur() * 2 + this.getLargeur() * 2;
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		
		double absCoord = coordonnees.getAbscisse();
		double ordCoord = coordonnees.getOrdonnee();
		
		return absCoord < this.getCadreMaxX() 
				&& absCoord > this.getCadreMinX()
				&& ordCoord < this.getCadreMaxY()
				&& ordCoord > this.getCadreMinY();
	}
	
	@Override
	public String toString() {

		// Couleur
		String couleur = super.toString();

		return "[Rectangle " + this.getRemplissage().getMode() + "] : " 
		+ "pos ("
		+ this.adapterFormat(this.getPosition().getAbscisse()) + " , "
		+ this.adapterFormat(this.getPosition().getOrdonnee()) + ") " 
		+ "largeur " + this.adapterFormat(this.getLargeur()) + " "
		+ "hauteur " + this.adapterFormat(this.getHauteur()) + " " 
		+ "périmètre : " + this.adapterFormat(this.perimetre()) + " " 
		+ "aire : " + this.adapterFormat(this.aire()) + " "
		+ couleur;
	}


	
}
