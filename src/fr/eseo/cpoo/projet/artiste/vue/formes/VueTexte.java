package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.modele.formes.Texte;

public class VueTexte extends VueForme {

	// Constructeurs
	// =========================================================================================
	public VueTexte(Texte texte) {
		super(texte);
		// TODO Auto-generated constructor stub
	}

	// Methodes
	// =========================================================================================
	@Override
	public void affiche(Graphics2D g2d) {
		
		// Sauvegarder la couleur courante du contexte graphique
		Color couleurCouranteG2d = g2d.getBackground();

		// Transformer la forme en texte (polymorphisme)
		Texte texte = (Texte) this.getForme();

		// Dessiner le texte
		int x = (int) texte.getPosition().getAbscisse();
		int y = (int) texte.getPosition().getOrdonnee();
		
		Font texteFont = new Font("SansSerif", Font.PLAIN, texte.getTaille());
		g2d.setFont(texteFont);
		g2d.setColor(texte.getCouleur());		
		g2d.drawString(texte.getTexte(), x, y);

	}

}
