package fr.eseo.cpoo.projet.artiste.modele.formes;

import java.util.Locale;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {

    // Constructeurs 
	// =======================================================================================

	public Cercle(){
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille) {
		this(new Coordonnees(), taille);
	}
	
	public Cercle(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Coordonnees position, double taille) {
		super(position, taille, taille);
	}
	
    // Setters 
	// =====================================================================================

	@Override
	public void setLargeur(double taille) {
		
		if (taille < 0) {
			throw new IllegalArgumentException("setLargeur : "
				+ "la valeur passée en paramètre ne peut pas être négative");
		}
		
		super.setHauteur(taille);
		super.setLargeur(taille);
	}

	@Override
	public void setHauteur(double taille) {
		
		if (taille < 0) {
			throw new IllegalArgumentException("setLargeur : "
				+ "la valeur passée en paramètre ne peut pas être négative");
		}
		
		this.setLargeur(taille);
	}
	
	// METHODES SURCHARGEES 
	//==============================================================================

	@Override
	public double aire() {
		double aire = Math.PI * Math.pow(this.getLargeur() / 2, 2);
		return aire;
	}
	
	@Override
	public double perimetre() {
		double perimetre = 2 * Math.PI * this.getLargeur() /2;
		return perimetre;
	}
	
	// METHODES OJBET 
	// ==============================================================================
	
	@Override
    public String toString() {
		
        // Couleur
		Locale defLocal = Locale.getDefault();
		String v = "";

		if (defLocal.getLanguage().equals("fr")) {
			v = "V";
		} else {
			v = "G";
		}

		String couleur =  "couleur = " + "R" + this.getCouleur().getRed() + "," 
							+ v + this.getCouleur().getGreen() + "," 
							+ "B"
							+ this.getCouleur().getBlue();
		
		
        return "[Cercle " + this.getRemplissage().getMode() + "] : "
        		+ "pos ("
                + this.adapterFormat(this.getPosition().getAbscisse()) + " , "
                + this.adapterFormat(this.getPosition().getOrdonnee()) + ") " 
                + "rayon " + this.adapterFormat(super.getLargeur() / 2) + " " 
                + "périmètre : " + this.adapterFormat(this.perimetre()) 
                + " aire : " + this.adapterFormat(this.aire()) + " "
                + couleur;
    }
    
}
