package fr.eseo.cpoo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Forme;
import fr.eseo.cpoo.projet.artiste.modele.formes.Texte;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueTexte;

public class OutilTexte extends OutilForme {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Recuperer les coordonnees du click		
		this.setDebut(new Coordonnees(e.getX(), e.getY()));
		this.setFin(new Coordonnees(e.getX() + Forme.LARGEUR_PAR_DEFAUT, 
				e.getY() + Forme.HAUTEUR_PAR_DEFAUT));
		
		// Creer et ajouter la vue forme
		VueForme vf = creerVueForme();
		this.getPanneauDessin().ajouterVueForme(vf);
		
		// Mettre à jour le panneau
		this.getPanneauDessin().repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	protected VueForme creerVueForme() {
		
		// Demander le texte
		String reponse = JOptionPane.showInputDialog("Choisir un texte");
		
		if(!reponse.equals("")) {
			
			// Demander la taille de la police
			String  options[] = new String[40 + 1];
			for (int i = 0; i < options.length ; i++) {
				options[i] = String.valueOf(i + 1);
			}
	
			String tailleString = (String) JOptionPane.showInputDialog(
					null,
					"Taille de la police",
					"Taille Poilice",
					JOptionPane.QUESTION_MESSAGE,
					null, 
					options,
					options[0]);
			
			
			int taille = Integer.valueOf(tailleString);
			
			// Recuperer les coordonner du premier click
			double x = this.getDebut().getAbscisse();
			double y = this.getDebut().getOrdonnee();
			
			// Creer le texte a partir des coordonner
			Texte texte = new Texte(reponse, taille, x, y);
			texte.setCouleur(this.getPanneauDessin().getCouleurCourante());
			return new VueTexte(texte);
		}
		
		return null;
	}

}
