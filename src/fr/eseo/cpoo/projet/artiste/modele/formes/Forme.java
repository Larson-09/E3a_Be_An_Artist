package fr.eseo.cpoo.projet.artiste.modele.formes;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.UIManager;

import org.junit.runners.Parameterized.Parameter;

import fr.eseo.cpoo.projet.artiste.modele.Coloriable;
import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable{

	// Constantes de classe
	// ==============================================================================
	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 150;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");

	// Variables d'instance
	// ==============================================================================
	private double largeur;
	private double hauteur;
	private Coordonnees position;
	private Color couleur;

	// Constructeurs
	// ==============================================================================
	/**
	 * @brief	Constructeur vide de forme
	 * 
	 */
	public Forme() {
		this.setPosition(new Coordonnees());
		this.setLargeur(LARGEUR_PAR_DEFAUT);
		this.setHauteur(HAUTEUR_PAR_DEFAUT);
		this.couleur = COULEUR_PAR_DEFAUT;
	
	}

	/**
	 * @brief	Constructeur de forme
	 * 
	 * @param largeur	la largeur du rectangle entourant la forme
	 * @param hauteur	la hauteur du rectangle entourant la forme
	 * 
	 */
	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	/**
	 * @brief	Constructeur de forme
	 * 
	 * @param position	la position du rectangle entourant la forme
	 * 
	 */	
	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	/**
	 * @brief	Constructeur de forme
	 * 
	 * @param largeur	la largeur du rectangle entourant la forme
	 * @param hauteur	la hauteur du rectangle entourant la forme
	 * @param position	la position du rectangle entourant la forme
	 * 
	 */
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.couleur = COULEUR_PAR_DEFAUT;
	}

	// Getters
	// ==============================================================================
	/**
	 * @brief	accesseur de la position
	 * @return	la position du rectangle entourant la forme
	 */
	public Coordonnees getPosition() {
		return this.position;
	}

	/**
	 * @brief	accesseur de la largeur
	 * @return	la largeur du rectangle entourant la forme
	 */
	public double getLargeur() {
		return this.largeur;
	}

	/**
	 * @brief	accesseur de la hauteur
	 * @return	la hauteur du rectangle entourant la forme
	 */
	public double getHauteur() {
		return this.hauteur;
	}

	/**
	 * @brief	accesseur de la couleur
	 * @return	la couleur de la forme
	 */
	public Color getCouleur() {
		return this.couleur;
	}

	// Setters
	// ==============================================================================
	
	/**
	 * @brief mutateur de position
	 * 
	 * @param position	la nouvelle position du rectangle entourant la forme
	 */
	public void setPosition(Coordonnees position) {
		this.position = position;
	}

	/**
	 * @brief mutateur de largeur
	 * 
	 * @param largeur	la nouvelle largeur du rectangle entourant la forme
	 */
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	/**
	 * @brief mutateur de hauteur
	 * 
	 * @param hauteur	la nouvelle hauteur du rectangle entourant la forme
	 */
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * @brief mutateur de couleur
	 * 
	 * @param couleur	la nouvelle couleur de la forme
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	// Methodes
	// ==============================================================================

	public double getCadreMinX() {
		return Math.min(this.getPosition().getAbscisse(), 
				this.getPosition().getAbscisse() + largeur);
	}

	public double getCadreMinY() {
		return Math.min(this.getPosition().getOrdonnee(), 
				this.getPosition().getOrdonnee() + hauteur);
	}

	public double getCadreMaxX() {
		return Math.max(this.getPosition().getAbscisse(), 
				this.getPosition().getAbscisse() + largeur);
	}

	public double getCadreMaxY() {
		return Math.max(this.getPosition().getOrdonnee(), 
				this.getPosition().getOrdonnee() + hauteur);
	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.setPosition(new Coordonnees(nouvelleAbscisse, nouvelleOrdonnee));
	}

	public void deplacerDe(double deltaX, double deltaY) {
		this.setPosition(
				new Coordonnees(this.getPosition().getAbscisse() + deltaX, 
						this.getPosition().getOrdonnee() + deltaY));
	}

	// METHODES ABSTRAITES
	// ==============================================================================

	/**
	 * @brief	permet de connaitre l'aire de la forme
	 * 
	 * @return	l'aire de la forme
	 */
	public abstract double aire();

	/**
	 * @brief	permet de connaitre le perimetre de la forme
	 * 
	 * @return	le perimetre de la forme
	 */
	public abstract double perimetre();

	/**
	 * @brief	permet de savoir si une coordonnee est contenu dans la forme
	 * 
	 * @return	vrai si la coordonnee est contenue, faux sinon
	 */
	public abstract boolean contient(Coordonnees coordonnees);

	// Methodes abstraites
	// ==============================================================================
	
	/**
	 * @brief	adapte les valeurs numeriques a la local de l'ordinateur
	 * 
	 * @param valeur	la valeur a adapter
	 * 
	 * @return	la valeur adaptee
	 */
	protected String adapterFormat(double valeur) {
		String pattern = "##0.0#";
		Locale defLocal = Locale.getDefault();

		DecimalFormat dc = (DecimalFormat) NumberFormat.getNumberInstance(defLocal);
		dc.applyPattern(pattern);

		return dc.format(valeur);
	}

	// Methodes d'objet
	// =======================================================================================

	@Override
	public String toString() {
		Locale defLocal = Locale.getDefault();
		String v = "";

		if (defLocal.getLanguage().equals("fr")) {
			v = "V";
		} else {
			v = "G";
		}

		return "couleur = " + "R" + this.getCouleur().getRed() 
				+ "," + v + this.getCouleur().getGreen() + "," + "B"
				+ this.getCouleur().getBlue();
	}

//	@Override
//	public boolean equals(Object obj) {
//
//		// L'objet est null
//		if (obj == null) {
//			return false;
//		}
//		
//		// L'objet est lui même
//		if (this == obj) {
//			return true;
//		}
//
//		// L'objet à les meme coordonnees
//		Forme autreForme = (Forme) obj;
//
//		if (this.getPosition().equals(autreForme.getPosition()) 
//				&& this.getLargeur() == autreForme.getLargeur()
//				&& this.getHauteur() == autreForme.getHauteur()) {
//
//			return true;
//		} else {
//			return false;
//		}
//	}

}
