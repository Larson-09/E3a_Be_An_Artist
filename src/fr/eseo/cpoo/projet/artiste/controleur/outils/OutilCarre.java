package fr.eseo.cpoo.projet.artiste.controleur.outils;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Carre;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme {

	@Override
	protected VueForme creerVueForme() {

		// Creer un carre et recuperer ses informations
		Carre carre = new Carre(this.getDebut());
		double hauteur = Math.abs(this.getFin().getOrdonnee() - this.getDebut().getOrdonnee());
		double largeur = Math.abs(this.getFin().getAbscisse() - this.getDebut().getAbscisse());
		Coordonnees newPosition = new Coordonnees();

		// Determiner la taille
		if (hauteur > largeur) {
			carre.setHauteur(hauteur);
			largeur = hauteur;
		} else if (hauteur < largeur) {
			carre.setLargeur(largeur);
			hauteur = largeur;
		}

		if (this.getDebut().getOrdonnee() > this.getFin().getOrdonnee()
				&& this.getDebut().getAbscisse() > this.getFin().getAbscisse()) {
			newPosition.setOrdonnee(this.getDebut().getOrdonnee() - largeur);
			newPosition.setAbscisse(this.getDebut().getAbscisse() - largeur);
			carre.setPosition(newPosition);
			
		} else if (this.getDebut().getOrdonnee() > this.getFin().getOrdonnee()) {
			newPosition.setOrdonnee(this.getDebut().getOrdonnee() - largeur);
			newPosition.setAbscisse(this.getDebut().getAbscisse());
			carre.setPosition(newPosition);
			
		} else if (this.getDebut().getAbscisse() > this.getFin().getAbscisse()) {
			newPosition.setOrdonnee(this.getDebut().getOrdonnee());
			newPosition.setAbscisse(this.getDebut().getAbscisse() - largeur);
			carre.setPosition(newPosition);
		}

		carre.setCouleur(this.getPanneauDessin().getCouleurCourante());
		carre.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueCarre(carre);
	}

}
