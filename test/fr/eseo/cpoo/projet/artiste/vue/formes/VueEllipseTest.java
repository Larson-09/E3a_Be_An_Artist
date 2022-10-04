package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {

	// CONSTRUCTEUR DES TESTS
	// ========================================================================
	public VueEllipseTest() {
		test();
	}

	// TESTS
	// ========================================================================
	private void test() {

		// Creer des ellipses
		Ellipse e1 = new Ellipse();
		e1.setCouleur(Color.RED);

		Ellipse e2 = new Ellipse(20, 30);
		e2.setCouleur(Color.GREEN);

		Ellipse e3 = new Ellipse(new Coordonnees(10, 10), 30, 30);
		e3.setCouleur(Color.BLUE);

		// Creer un panneau dessin et y ajouter les ellipses
		PanneauDessin pd = new PanneauDessin();
		pd.ajouterVueForme(new VueEllipse(e1));
		pd.ajouterVueForme(new VueEllipse(e2));
		pd.ajouterVueForme(new VueEllipse(e3));

		// Creer une fenetre principale
		JFrame frameTestDefaut = new JFrame("Vue ELlipse Test");

		// Ajouter un panneau dessin
		frameTestDefaut.setContentPane(pd);

		// Pack les modifications
		frameTestDefaut.pack();

		// Placer la fenetre principale au centre de l'ecran
		frameTestDefaut.setLocationRelativeTo(null);

		// Rendre la fenetre visible
		frameTestDefaut.setVisible(true);
	}

	// MAIN ========================================================================
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});
	}
}
