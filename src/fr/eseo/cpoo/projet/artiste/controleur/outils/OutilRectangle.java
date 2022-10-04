package fr.eseo.cpoo.projet.artiste.controleur.outils;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueRectangle;

public class OutilRectangle extends OutilForme {
	
	@Override
	protected VueForme creerVueForme() {
		
		// Creer un rectangle
		Rectangle rectangle = new Rectangle(this.getDebut());
		
		// Recuperer les informations du rectangle
	    double hauteur = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
	    double largeur = this.getFin().getAbscisse() - this.getDebut().getAbscisse();
	    Coordonnees newPosition = new Coordonnees();
	    
	    
	    // Adapter la forme
	    if (hauteur < 0 && largeur < 0) {
	    rectangle.setPosition(this.getFin());
	      hauteur = this.getDebut().getOrdonnee() - this.getFin().getOrdonnee();
	      largeur = this.getDebut().getAbscisse() - this.getFin().getAbscisse();
	      
	    } else if (hauteur < 0) {
	      newPosition.setAbscisse(this.getFin().getAbscisse()-largeur);
	      newPosition.setOrdonnee(this.getFin().getOrdonnee());
	      rectangle.setPosition(newPosition);
	      hauteur = this.getDebut().getOrdonnee() - this.getFin().getOrdonnee();
	      
	    } else if(largeur < 0) {
	      newPosition.setAbscisse(this.getFin().getAbscisse());
	      newPosition.setOrdonnee(this.getFin().getOrdonnee()-hauteur);
	      rectangle.setPosition(newPosition);
	      largeur = this.getDebut().getAbscisse() - this.getFin().getAbscisse();
	    }
	    
	    rectangle.setHauteur(hauteur);
	    rectangle.setLargeur(largeur);
	    rectangle.setCouleur(this.getPanneauDessin().getCouleurCourante());
	    rectangle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
	    
	    return new VueRectangle(rectangle);
	    
	}
	
}