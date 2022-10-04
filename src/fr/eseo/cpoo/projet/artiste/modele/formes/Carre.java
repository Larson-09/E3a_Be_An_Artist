package fr.eseo.cpoo.projet.artiste.modele.formes;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class Carre extends Rectangle{

    // Constructeur 
	// =====================================================================================

	public Carre(){
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(double taille) {
		this(new Coordonnees(), taille);
	}
	
	public Carre(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(Coordonnees position, double taille) {
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
	
	// Methodes
	// =====================================================================================
	
	// Methodes
	public String toString() {
		
		String couleur =  "couleur = " + "R" + this.getCouleur().getRed() + "," 
				+ "G" + this.getCouleur().getGreen() + "," 
				+ "B"
				+ this.getCouleur().getBlue();
		
        return "[Carre " + this.getRemplissage().getMode() + "] : "
        		+ "pos ("
                + this.adapterFormat(this.getPosition().getAbscisse()) + " , "
                + this.adapterFormat(this.getPosition().getOrdonnee()) + ") " 
                + "Largeur " + this.adapterFormat(super.getLargeur()) + " " 
                + "périmètre : " + this.adapterFormat(this.perimetre()) 
                + " aire : " + this.adapterFormat(this.aire()) + " "
                + couleur;
	}	
}
