package fr.eseo.cpoo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.cpoo.projet.artiste.modele.Remplissage;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirModeRemplissage extends AbstractAction {

	
	// Variables d'instance
	// ====================================================================
	private PanneauDessin panneauDessin;

	// Constructeur
	// ====================================================================
	public ActionChoisirModeRemplissage(PanneauDessin panneauDessin, Remplissage remplissage) {
		super(remplissage.getMode());
		this.panneauDessin = panneauDessin;
	}

	// Methodes
	// ====================================================================
	@Override
	public void actionPerformed(ActionEvent e) {

		String modeRemplissage = e.getActionCommand();

		if (modeRemplissage.equals("aucune")) {
			this.panneauDessin.setModeRemplissageCourant(Remplissage.AUCUNE);

		}else if (modeRemplissage.equals("uniforme")) {
			this.panneauDessin.setModeRemplissageCourant(Remplissage.UNIFORME);

		}else {
			System.out.println("ERROR");
		}
	}

}
