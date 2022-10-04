package fr.eseo.cpoo.projet.artiste.modele.formes;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.Remplissable;
import fr.eseo.cpoo.projet.artiste.modele.Remplissage;

public class Ellipse extends Forme implements Remplissable {

	// Variables d'instance
	private Remplissage modeRemplissage;

	// Constructeurs
	// =========================================================================================

	public Ellipse() {
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}

	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public Ellipse(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setRemplissage(Remplissage.AUCUNE);
	}

	// Getters / Setters
	// =======================================================================================

	@Override
	public void setLargeur(double largeur) throws IllegalArgumentException {

		if (largeur < 0) {
			throw new IllegalArgumentException("setLargeur : " 
				+ "la valeur passée en paramètre ne peut pas être négative");
		}

		super.setLargeur(largeur);
	}

	@Override
	public void setHauteur(double hauteur) {

		if (hauteur < 0) {
			throw new IllegalArgumentException("setHauteur : " 
				+ "la valeur passée en paramètre ne peut pas être négative");
		}

		super.setHauteur(hauteur);
	}

	@Override
	public Remplissage getRemplissage() {
		return modeRemplissage;
	}

	@Override
	public void setRemplissage(Remplissage nouveauModeRemplissage) {
		this.modeRemplissage = nouveauModeRemplissage;

	}

	// METHODES SURCHARGES
	// =======================================================================================

	@Override
	public double perimetre() {

		// Determiner le petit et le grand rayon
		double a = Math.min(this.getHauteur(), this.getLargeur()) / 2;
		double b = Math.max(this.getHauteur(), this.getLargeur()) / 2;
		double h = Math.pow((a - b) / (a + b), 2);

		double perimetre;

		perimetre = Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));

		return perimetre;
	}

	@Override
	public double aire() {
		double aire = Math.PI * (this.getHauteur() / 2) * (this.getLargeur() / 2);
		return aire;
	}

	//Fonction developpee avec Thomas LENINIVEN
    @Override
    public boolean contient(Coordonnees coordonnees) {
    	
        
    	// Recuperer les coordonner du centre de l'ellipse            
        double absCentre = (this.getCadreMinX() + this.getCadreMaxX()) / 2;
        double ordCentre = (this.getCadreMinY() + this.getCadreMaxY()) / 2;
        
        // Recuperer les coordonnees du point a tester
        double absCoord = coordonnees.getAbscisse();
        double ordCoord = coordonnees.getOrdonnee();
        
        // Determiner a et b
	    double a = Math.abs(getCadreMaxX() - getCadreMinX()) / 2;
	    double b = Math.abs(getCadreMaxY() - getCadreMinY()) / 2;
        
	    // Determiner le resultat
        double res = (Math.pow(((absCoord - absCentre) / a), 2) 
        		+ (Math.pow(((ordCoord - ordCentre) / b), 2)));
        return res <= 1;
    }
    

	// Methodes
	// =======================================================================================
	@Override
	public String toString() {

		// Couleur
		String couleur = super.toString();

		// Rayons
		double a = Math.min(this.getHauteur(), this.getLargeur()) / 2;
		double b = Math.max(this.getHauteur(), this.getLargeur()) / 2;

		return "[Ellipse " + this.getRemplissage().getMode() + "] : " 
		+ "pos ("
		+ this.adapterFormat(this.getPosition().getAbscisse()) + " , "
		+ this.adapterFormat(this.getPosition().getOrdonnee()) + ") " 
		+ "petit rayon " + this.adapterFormat(a)
		+ " " + "grand rayon " + this.adapterFormat(b) + " " 
		+ "périmètre : " + this.adapterFormat(this.perimetre()) + " " 
		+ "aire : " + this.adapterFormat(this.aire()) + " "
		+ couleur;
	}

}
