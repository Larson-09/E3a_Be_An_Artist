package fr.eseo.cpoo.projet.artiste.controleur.outils;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	
	// Methode copiee sur Thomas LE NINININININININIVEN
	@Override
	protected VueForme creerVueForme() {
		
		
		Ellipse ellipse = new Ellipse(this.getDebut());
	    double hauteur = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
	    double largeur = this.getFin().getAbscisse() - this.getDebut().getAbscisse();
	    Coordonnees newPosition = new Coordonnees();
	    
	    if (hauteur < 0 && largeur < 0) {
	      ellipse.setPosition(this.getFin());
	      hauteur = this.getDebut().getOrdonnee() - this.getFin().getOrdonnee();
	      largeur = this.getDebut().getAbscisse() - this.getFin().getAbscisse();
	      
	    } else if (hauteur < 0) {
	      newPosition.setAbscisse(this.getFin().getAbscisse()-largeur);
	      newPosition.setOrdonnee(this.getFin().getOrdonnee());
	      ellipse.setPosition(newPosition);
	      hauteur = this.getDebut().getOrdonnee() - this.getFin().getOrdonnee();
	      
	    } else if(largeur < 0) {
	      newPosition.setAbscisse(this.getFin().getAbscisse());
	      newPosition.setOrdonnee(this.getFin().getOrdonnee()-hauteur);
	      ellipse.setPosition(newPosition);
	      largeur = this.getDebut().getAbscisse() - this.getFin().getAbscisse();
	    }
	    
	    ellipse.setHauteur(hauteur);
	    ellipse.setLargeur(largeur);
	    ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
	    ellipse.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
	    
	    return new VueEllipse(ellipse);
		
	}

}
