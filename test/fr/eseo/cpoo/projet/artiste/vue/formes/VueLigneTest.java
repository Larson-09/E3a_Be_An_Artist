package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ligne;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	// CONSTRUCTEUR DES TESTS 
	// ========================================================================
    public VueLigneTest() {
    	test();
    }
   
    // TESTS ========================================================================
    private void test() {
    	
    	// Creer des lignes
    	Ligne l1 = new Ligne();
    	l1.setCouleur(Color.RED);
    	
    	Ligne l2 = new Ligne(20, 30);
    	l2.setCouleur(Color.GREEN);
    	
    	Ligne l3 = new Ligne(new Coordonnees(10,10), 30, 30);
    	l3.setCouleur(Color.BLUE);
    	
    	// Creer un panneau dessin et y ajouter les lignes
    	PanneauDessin pd = new PanneauDessin();
    	pd.ajouterVueForme(new VueLigne(l1));
    	pd.ajouterVueForme(new VueLigne(l2));
    	pd.ajouterVueForme(new VueLigne(l3));
    	
    	// Creer une fenetre principale
        JFrame frameTestDefaut = new JFrame("Etre un Artiste");
        
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
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new VueLigneTest();
            }
        });
    }
}
