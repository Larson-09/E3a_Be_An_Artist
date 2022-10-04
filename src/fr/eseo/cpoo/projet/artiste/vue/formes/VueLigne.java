package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.cpoo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {

	// Constructeurs
	// =========================================================================================
	public VueLigne(Ligne ligne) {
		super(ligne);
	}

	// Methodes
	// =========================================================================================
	@Override
	public void affiche(Graphics2D g2d) {

		// Sauvegarder la couleur courante du contexte graphique
		Color couleurCouranteG2d = g2d.getBackground();

		// Creation de la ligne
		Ligne ligne = (Ligne) super.forme;

		int x1 = (int) Math.round(ligne.getC1().getAbscisse());
		int y1 = (int) Math.round(ligne.getC1().getOrdonnee());

		int x2 = (int) Math.round(ligne.getC2().getAbscisse());
		int y2 = (int) Math.round(ligne.getC2().getOrdonnee());

		// Dessiner la ligne
		g2d.setColor(ligne.getCouleur());
		g2d.drawLine(x1, y1, x2, y2);

		// Rendre sa couleur de base au contexte graphique
		g2d.setColor(couleurCouranteG2d);

	}

}
