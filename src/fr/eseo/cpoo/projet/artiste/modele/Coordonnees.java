package fr.eseo.cpoo.projet.artiste.modele;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Coordonnees {
	
	// Constantes de classe
	// =========================================================================================
	public static final double ABSCISSE_PAR_DEFAUT = 0;
	public static final double ORDONNEE_PAR_DEFAUT = 0;

	// Variables d'instance
	// =========================================================================================
	double abscisse;
	double ordonnee;
	
	// Constructeurs 
	// =========================================================================================
	public Coordonnees() {
		this.deplacerVers(this.ABSCISSE_PAR_DEFAUT, this.ORDONNEE_PAR_DEFAUT);
	}
	
	public Coordonnees(double abcisse, double ordonnee) {
		this.deplacerVers(abcisse, ordonnee);
	}
	
	// Getters / Setters
	// ========================================================================================
	public double getAbscisse() {
		return this.abscisse;
	}
	
	public double getOrdonnee() {
		return this.ordonnee;
	}
	
	public void setAbscisse(double abcisse) {
		this.abscisse = abcisse;
	}
	
	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	
	// Methodes 
	// =========================================================================================
	
	public void deplacerVers(double abs, double ord) {
		this.abscisse = abs;
		this.ordonnee = ord;
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.abscisse += deltaX;
		this.ordonnee += deltaY;
	}
	
	public double distanceVers(Coordonnees autreCoordonnees) {
		
		double deltaAbcisse = this.getAbscisse() - autreCoordonnees.getAbscisse();
		double deltaOrdonnee = this.getOrdonnee() - autreCoordonnees.getOrdonnee();
		
		double distance = Math.sqrt(Math.pow(deltaAbcisse, 2) + Math.pow(deltaOrdonnee, 2));
		return distance;
	}
	
	public double angleVers(Coordonnees autreCoordonnees) {

		return Math.atan2(autreCoordonnees.getOrdonnee() - this.getOrdonnee(), 
				autreCoordonnees.getAbscisse() - this.getAbscisse());
	}
	
	@Override
	public String toString() {
		
	      String pattern = "##0.0#";

	      Locale defLocal = Locale.getDefault();

	      DecimalFormat dc = (DecimalFormat) NumberFormat.getNumberInstance(defLocal);
	      dc.applyPattern(pattern);

	      String abs =  dc.format(this.getAbscisse());
	      String ord =  dc.format(this.getOrdonnee());
	   		
	      return  "(" + abs + " , " + ord + ")";  
	}
	
	@Override
	public boolean equals(Object obj){
		  
		// L'objet est null
		if(obj == null) {
			return false;
		}
  
		// L'objet est lui même
		if(this == obj) {
			return true;
		}
  
		// L'objet à les meme coordonnees
		Coordonnees autreCoord = (Coordonnees) obj;
				
		return this.getAbscisse() == autreCoord.getAbscisse() 
				&& this.getOrdonnee() == autreCoord.getOrdonnee();
	}

}
