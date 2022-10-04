package fr.eseo.cpoo.projet.artiste.controleur.outils;

import fr.eseo.cpoo.projet.artiste.modele.formes.Ligne;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		Ligne l = new Ligne();
		l.setC1(this.getDebut());
		l.setC2(this.getFin());
		l.setCouleur(this.getPanneauDessin().getCouleurCourante());
		return new VueLigne(l);
	}

	
}
