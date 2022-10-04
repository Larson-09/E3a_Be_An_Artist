package fr.eseo.cpoo.projet.artiste.modele.formes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	Ligne ligne;

	@BeforeEach
	void setUp() throws Exception {
		this.ligne = new Ligne();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Tests Constructeurs
	// ============================================================================
	@Test
	public void testConstructeurVide() {
		assertEquals(new Coordonnees(), this.ligne.getPosition(), 
				"Test coordonnees par defaut");
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), 
				"Test largeur par defaut");
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), 
				"Test hauteur par defaut");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, ligne.getCouleur(), 
				"Test couleur par defaut");
	}

	@Test
	public void testConstructeurLargeurHauteur() {

		Ligne l = new Ligne(15.0, 18.0);

		assertEquals(new Coordonnees(), l.getPosition(), "Test coordonnees par defaut");
		assertEquals(15.0, l.getLargeur(), "Test largeur");
		assertEquals(18.0, l.getHauteur(), "Test hauteur");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, ligne.getCouleur(), "Test couleur par defaut");
	}

	@Test
	public void testConstructeurPosition() {

		Coordonnees coord = new Coordonnees(15, 15);
		Ligne l = new Ligne(coord);

		assertEquals(coord, l.getPosition(), "Test coordonnees");
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, l.getLargeur(), "Test largeur par defaut");
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, l.getHauteur(), "Test hauteur par defaut");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, l.getCouleur(), "Test couleur par defaut");
	}

	@Test
	public void testConstructeurPositionLargeurHauteur() {

		Coordonnees coord = new Coordonnees(15, 15);
		Ligne l = new Ligne(coord, 12, 18);

		assertEquals(coord, l.getPosition(), "Test coordonnees");
		assertEquals(12, l.getLargeur(), "Test largeur");
		assertEquals(18, l.getHauteur(), "Test hauteur");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, l.getCouleur(), "Test couleur par defaut");
	}

	// Tests Methodes
	// ============================================================================
	@Test
	public void testGetSetC1C2() {

		// Test C1
		ligne.setC1(new Coordonnees(12, 14));
		assertEquals(new Coordonnees(12, 14), ligne.getC1(), "Test setC1");

		// Test C2
		ligne.setC2(new Coordonnees(20, 25));
		assertEquals(new Coordonnees(20, 25), ligne.getC2(), "Test getC2");

	}

	@Test
	public void testAir() {
		assertEquals(0, ligne.aire(), "Test air");
	}

	@Test
	public void testPerimetre() {
		assertEquals(180, ligne.perimetre(), 1, "Test erimetre");
	}

	@Test
	public void testContient() {
		assertEquals(false, ligne.contient(new Coordonnees(50, 50)));
		assertEquals(true, ligne.contient(new Coordonnees(42.43, 62.64)));
	}

	@Test
	public void testToString1() {

		ligne.setC1(new Coordonnees(2, 2));
		ligne.setC2(new Coordonnees(4, 4));

		assertEquals(
				"[Ligne] c1 : (2,0 , 2,0) c2 : (4,0 , 4,0) " 
		+ "longueur : 2,83 angle : 45,0° couleur = R51,V51,B51",
				ligne.toString());

		ligne.setC1(new Coordonnees(2, 2));
		ligne.setC2(new Coordonnees(5, 0));

		assertEquals(
				"[Ligne] c1 : (2,0 , 2,0) c2 : (5,0 , 0,0) " 
		+ "longueur : 3,61 angle : 326,31° couleur = R51,V51,B51",
				ligne.toString());
	}
}
