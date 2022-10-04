package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {

	// Constructeur
	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}

	// Methodes
	@Override
	public void affiche(Graphics2D g2d) {

		// Sauvegarder la couleur courante du contexte graphique
		Color couleurCouranteG2d = g2d.getBackground();

		// Transformer la forme en ellipse (polymorphisme)
		Ellipse ellipse = (Ellipse) this.getForme();

		int x = (int) ellipse.getPosition().getAbscisse();
		int y = (int) ellipse.getPosition().getOrdonnee();
		int largeur = (int) ellipse.getLargeur();
		int hauteur = (int) ellipse.getHauteur();
		
		// Dessiner l'ellipse
		g2d.setColor(ellipse.getCouleur());
		g2d.drawOval(x, y, largeur, hauteur);		
		
		if(ellipse.getRemplissage().getMode().contentEquals("uniforme")) {
			g2d.fillOval(x, y, largeur, hauteur);
		}
		
		// Rendre sa couleur de base au contexte graphique
		g2d.setColor(couleurCouranteG2d);

	}

}
