package fr.eseo.cpoo.projet.artiste.vue.formes;

import fr.eseo.cpoo.projet.artiste.modele.formes.Forme;

public abstract class VueForme {

	// Constantes de classe
	// ================================================
	protected final Forme forme;

	// Constructeurs
	// ================================================
	public VueForme(Forme forme) {
		this.forme = forme;
	}

	// Getters
	// ================================================
	public Forme getForme() {
		return this.forme;
	}

	// Methodes
	// ================================================
	public abstract void affiche(java.awt.Graphics2D g2d);

}
