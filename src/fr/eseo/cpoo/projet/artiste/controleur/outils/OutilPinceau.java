package fr.eseo.cpoo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.Remplissage;
import fr.eseo.cpoo.projet.artiste.modele.formes.Carre;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueRectangle;

public class OutilPinceau extends OutilForme {
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		this.setDebut(new Coordonnees(e.getX(), e.getY()));
		this.setFin(new Coordonnees(e.getX() + 5, e.getY() + 5));
		
		// Creer et ajouter la vue forme
		this.getPanneauDessin().ajouterVueForme(creerVueForme());
		
		// Mettre à jour le panneau
		this.getPanneauDessin().repaint();
	}
		
	@Override
	protected VueForme creerVueForme() {					
		// Creer un rectangle
		Carre carre = new Carre(this.getDebut());
		
		carre.setLargeur(5);
		carre.setCouleur(this.getPanneauDessin().getCouleurCourante());
		carre.setRemplissage(Remplissage.UNIFORME);
	    
	    return new VueRectangle(carre);
	}

}
