package fr.eseo.cpoo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends AbstractAction {

	// Constantes de classe
	// ==========================================================
	public static final String NOM_ACTION = "Choisir Couleur";

	// Variables d'instance
	// ==========================================================
	private PanneauDessin panneauDessin;

	// Constructeur
	// ==========================================================
	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}

	// Methodes
	// ==========================================================
	@Override
	public void actionPerformed(ActionEvent e) {
		Color rep = JColorChooser.showDialog(this.panneauDessin, 
				NOM_ACTION, this.panneauDessin.getCouleurCourante());
		this.panneauDessin.setCouleurCourante(rep);
	}

}
