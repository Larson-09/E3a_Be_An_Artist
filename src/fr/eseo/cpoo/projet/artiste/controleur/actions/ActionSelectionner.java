package fr.eseo.cpoo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionner extends AbstractAction {
	
	// Constantes de classe
	// ====================================================================
	public static final String NOM_ACTION = "Selectionner";
	
	// Variables d'instance
	// ====================================================================
	private PanneauDessin panneauDessin;
		
	// Constructeur
	// ====================================================================
	public ActionSelectionner(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	// Methodes
	// ====================================================================
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.panneauDessin.associerOutil(new OutilSelectionner());
	}
}
