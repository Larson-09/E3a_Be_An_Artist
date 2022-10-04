package fr.eseo.cpoo.projet.artiste.modele.formes;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {
	
	// Constantes de classe
	// =========================================================================================
	public static final double EPSILON;

	static {
		EPSILON = 0.2;
	}

	// Constructeurs
	// =========================================================================================

	public Ligne() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ligne(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public Ligne(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ligne(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
	}

	// Getters
	// =========================================================================================

	public Coordonnees getC1() {
		return this.getPosition();
	}

	public Coordonnees getC2() {
		return new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur(),
				this.getPosition().getOrdonnee() + this.getHauteur());
	}

	// Setters
	// =========================================================================================

	public void setC1(Coordonnees coordonnees) {

		// Modifier la hauteur et la largeur
		this.setLargeur(this.getPosition().getAbscisse() 
				+ this.getLargeur() 
				+ coordonnees.getAbscisse());
		
		this.setHauteur((this.getPosition().getOrdonnee() 
				+ this.getHauteur() 
				+ coordonnees.getOrdonnee()));

		// Modifier le point d'origine
		this.setPosition(coordonnees);
	}

	public void setC2(Coordonnees coordonnees) {
		this.setLargeur(coordonnees.getAbscisse() - this.getPosition().getAbscisse());
		this.setHauteur(coordonnees.getOrdonnee() - this.getPosition().getOrdonnee());
	}

	// Methodes
	// =========================================================================================

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return this.getC1().distanceVers(this.getC2());
	}

	@Override
	public boolean contient(Coordonnees c) {

		double res = this.getC1().distanceVers(c) + this.getC2().distanceVers(c)
				- this.perimetre();
		
		return res < Ligne.EPSILON;
	}

	// Methodes objet
	// =======================================================================================

	@Override
	public String toString() {
		
		double longueur = this.getC1().distanceVers(this.getC2());

		double angle = (180 / Math.PI) * (this.getC1().angleVers(this.getC2()));
		
		if (angle < 0) {
			angle = 360 + angle;
		}

		return "[" + this.getClass().getSimpleName() + "] " 
				+ "c1 : " + this.getC1().toString() + " " 
				+ "c2 : " + this.getC2().toString() + " " 
				+ "longueur : " 
				+ this.adapterFormat(Math.round(longueur * 100.0) / 100.0) + " " 
				+ "angle : " + this.adapterFormat(angle) + "° "
				+ super.toString();
	}
}
