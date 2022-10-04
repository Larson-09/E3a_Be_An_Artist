package fr.eseo.cpoo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.cpoo.projet.artiste.modele.Remplissage;

public class PanneauBarreOutils extends JPanel {

	// Variables d'instance
	// ============================================================================
	private PanneauDessin panneauDessin;

	// Constructeurs
	// ============================================================================
	public PanneauBarreOutils(PanneauDessin panneauDessin) {

		// Associer le panneau dessin
		this.panneauDessin = panneauDessin;

		// Associer un layout
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);

		// Initialiser les compsants de la barre outil
		this.initComponents();
	}
	
	// Methodes
	// ============================================================================

	private void initComponents() {

		// Ajouter un bouton EFFACER
		JButton boutonEffacer = new JButton(new ActionEffacer(this.panneauDessin));
		boutonEffacer.setName(ActionEffacer.NOM_ACTION);
		this.add(ActionEffacer.NOM_ACTION, boutonEffacer);

		ButtonGroup groupeBouton = new ButtonGroup();

		// Ajouter un bouton choisir LIGNE
		JToggleButton choisirLigne = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_LIGNE));
		choisirLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		groupeBouton.add(choisirLigne);
		this.add(choisirLigne);

		// Ajouter un bouton choisir ELLIPSE
		JToggleButton choisirEllipse = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_ELLIPSE));
		choisirEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		groupeBouton.add(choisirEllipse);
		this.add(choisirEllipse);

		// Ajouter un bouton choisir CERCLE
		JToggleButton choisirCercle = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_CERCLE));
		
		choisirCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		groupeBouton.add(choisirCercle);
		this.add(choisirCercle);
		
		// Ajouter un bouton choisir RECTANGLE
		JToggleButton choisirRectangle = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_RECTANGLE));
		choisirRectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
		groupeBouton.add(choisirRectangle);
		this.add(choisirRectangle);
		
		// Ajouter un bouton choisir CARRE
		JToggleButton choisirCarre = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_CARRE));
		choisirCarre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
		groupeBouton.add(choisirCarre);
		this.add(choisirCarre);
		
		// Ajouter un bouton TEXTE
		JToggleButton choisirTexte = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_TEXTE));
		choisirTexte.setName(ActionChoisirForme.NOM_ACTION_TEXTE);
		groupeBouton.add(choisirTexte);
		this.add(choisirTexte);
		
		// Ajouter un bouton PINCEAU
		JToggleButton choisirPinceau = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_PINCEAU));
		choisirPinceau.setName(ActionChoisirForme.NOM_ACTION_PINCEAU);
		groupeBouton.add(choisirPinceau);
		this.add(choisirPinceau);
		
		// Ajouter un bouton GOMME
		JToggleButton choisirGomme = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, 
						ActionChoisirForme.NOM_ACTION_GOMME));
		choisirGomme.setName(ActionChoisirForme.NOM_ACTION_GOMME);
		groupeBouton.add(choisirGomme);
		this.add(choisirGomme);

		// Ajouter un bouton SELECTIONNER
		JToggleButton selectionner = new JToggleButton(
				new ActionSelectionner(this.panneauDessin));
		selectionner.setName(ActionSelectionner.NOM_ACTION);
		groupeBouton.add(selectionner);
		this.add(selectionner);

		// Ajouter un bouton pour choisir la COULEUR
		JButton boutonChoisirCouleur = new JButton(
				new ActionChoisirCouleur(this.panneauDessin));
		boutonChoisirCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		boutonChoisirCouleur.setText(ActionChoisirCouleur.NOM_ACTION);
		this.add(ActionChoisirCouleur.NOM_ACTION, boutonChoisirCouleur);

		// Ajouter les bouton pour choisir le REMPLISSGE
		ButtonGroup grpChoisirModeRemplissage = new ButtonGroup();

		JToggleButton btRemplissageAucun = new JToggleButton(
				new ActionChoisirModeRemplissage(this.panneauDessin, 
						Remplissage.AUCUNE));
		btRemplissageAucun.setName(Remplissage.AUCUNE.getMode());
		btRemplissageAucun.setSelected(true);
		grpChoisirModeRemplissage.add(btRemplissageAucun);
		this.add(btRemplissageAucun);

		JToggleButton btRemplissageUniforme = new JToggleButton(
				new ActionChoisirModeRemplissage(this.panneauDessin, 
						Remplissage.UNIFORME));

		btRemplissageUniforme.setName(Remplissage.UNIFORME.getMode());
		grpChoisirModeRemplissage.add(btRemplissageUniforme);
		this.add(btRemplissageUniforme);
	}

}
