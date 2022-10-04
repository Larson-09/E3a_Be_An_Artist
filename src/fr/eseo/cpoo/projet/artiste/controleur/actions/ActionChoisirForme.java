package fr.eseo.cpoo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilGomme;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilTexte;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilPinceau;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction {
	
	// Constantes de classe 
	// ====================================================================
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_RECTANGLE = "Rectangle";
	public static final String NOM_ACTION_CARRE = "Carre";
	public static final String NOM_ACTION_TEXTE = "Texte";
	public static final String NOM_ACTION_PINCEAU = "Pinceau";
	public static final String NOM_ACTION_GOMME = "Gomme";
	
	// Variables d'instance
	// ====================================================================
	private PanneauDessin panneauDessin;
	private String choix;
	
	// Constructeur
	// ====================================================================
	public ActionChoisirForme(PanneauDessin panneauDessin, String choix) {
		super(choix);
		this.panneauDessin = panneauDessin;
		this.choix = choix;
	}
	
	// Methodes
	// ====================================================================

	@Override
	public void actionPerformed(ActionEvent e) {
				
		switch(e.getActionCommand()){
		
		case NOM_ACTION_LIGNE:
			this.panneauDessin.associerOutil(new OutilLigne());
			break;
			
		case NOM_ACTION_ELLIPSE:
			this.panneauDessin.associerOutil(new OutilEllipse());
			break;
			
		case NOM_ACTION_CERCLE:
			this.panneauDessin.associerOutil(new OutilCercle());
			break;
			
		case NOM_ACTION_RECTANGLE:
			this.panneauDessin.associerOutil(new OutilRectangle());
			break;
			
		case NOM_ACTION_CARRE:
			this.panneauDessin.associerOutil(new OutilCarre());
			break;
			
		case NOM_ACTION_TEXTE:
			this.panneauDessin.associerOutil(new OutilTexte());
			break;
			
		case NOM_ACTION_PINCEAU:
			this.panneauDessin.associerOutil(new OutilPinceau());
			break;
			
		case NOM_ACTION_GOMME:
			this.panneauDessin.associerOutil(new OutilGomme());
			break;
			
		default:
			break;
		}
		
	}

}
