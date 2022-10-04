package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.modele.formes.Rectangle;

public class VueRectangle extends VueForme {

	// Constructeurs
	// =========================================================================================
	public VueRectangle(Rectangle rectangle) {
		super(rectangle);
	}
	
	// Methodes
	// =========================================================================================

	@Override
	public void affiche(Graphics2D g2d) {
		
		// Sauvegarder la couleur courante du contexte graphique
		Color couleurCouranteG2d = g2d.getBackground();

		// Transformer la forme en rectangle (polymorphisme)
		Rectangle rectangle = (Rectangle) this.getForme();

		int x = (int) rectangle.getPosition().getAbscisse();
		int y = (int) rectangle.getPosition().getOrdonnee();
		int largeur = (int) rectangle.getLargeur();
		int hauteur = (int) rectangle.getHauteur();
		
		// Dessiner le rectangle
		g2d.setColor(rectangle.getCouleur());
		g2d.drawRect(x, y, largeur, hauteur);
		
		if(rectangle.getRemplissage().getMode().contentEquals("uniforme")) {
			g2d.fillRect(x, y, largeur, hauteur);
		}
		
		// Rendre sa couleur de base au contexte graphique
		g2d.setColor(couleurCouranteG2d);
	}

}
