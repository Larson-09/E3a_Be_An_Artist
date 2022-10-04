package fr.eseo.cpoo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {

	// CONSTANTES DE CLASSE
	// =============================================================
	public static final int LARGEUR_PAR_DEFAUT = Integer.parseInt("640");
	public static final int HAUTEUR_PAR_DEFAUT = 480;
	public static final String TITRE_PAR_DEFAUT = "Etre un Artiste";

	// CONSTRUCTEURS
	// ===================================================================

	private EtreUnArtiste(String titre, int largeur, int hauteur) {

		// Instancier une frame par defaut
		JFrame frame = new JFrame(titre);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instancier les panneaux
		PanneauDessin pd = new PanneauDessin();
		PanneauBarreEtat pbe = new PanneauBarreEtat(pd);
		PanneauBarreOutils pbo = new PanneauBarreOutils(pd);

		// Ajouter les panneaux à la frame
		frame.add(pd);
		frame.add(pbe, BorderLayout.SOUTH);
		frame.add(pbo, BorderLayout.EAST);

		// Redimenssionner et afficher la frame
		frame.setSize(new Dimension(largeur, hauteur));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// APPLICATION
	// ===================================================================

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				int largeur;
				int hauteur;
				String titre;

				// Cas par defaut
				if (args.length == 0) {
					titre = TITRE_PAR_DEFAUT;
					largeur = LARGEUR_PAR_DEFAUT;
					hauteur = HAUTEUR_PAR_DEFAUT;
				} else { // Mode personnalisé

					// Recuperer le premier argument pour le titre
					titre = args[0];

					// Recuperer le deuxieme argument pour la largeur
					try {
						largeur = Integer.parseInt(args[1]);
					} catch (NumberFormatException e) {
						// Si une exception est levee,
						// appeler la largeur par defaut
						largeur = LARGEUR_PAR_DEFAUT;
					}

					// Recuperer le troisieme argument pour la hauteur
					try {
						hauteur = Integer.parseInt(args[2]);
					} catch (NumberFormatException e) {
						// Si une exception est levee,
						// appeler la hauteur par defaut
						hauteur = HAUTEUR_PAR_DEFAUT;
					}

				}

				// Instancier la classe
				new EtreUnArtiste(titre, largeur, hauteur);
			}
		});
	}
}