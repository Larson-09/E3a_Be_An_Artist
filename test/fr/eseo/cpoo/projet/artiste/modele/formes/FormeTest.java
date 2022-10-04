package fr.eseo.cpoo.projet.artiste.modele.formes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

class FormeTest {
	
	FormeApp forme;

	@BeforeEach
	void setUp() throws Exception {
		forme = new FormeApp();
	}

	@AfterEach
	void tearDown() throws Exception {
		forme = null;
	}
	
	// Tests Constructeurs 
	// ============================================================================
	@Test
	public void testConstructeurPosition() {
		FormeApp forme1 = new FormeApp(new Coordonnees(1, 1));
		
		assertEquals(new Coordonnees(1, 1), forme1.getPosition(), 
				"Test getPosition");
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, forme1.getLargeur(), 
				"Test largeur par defaut");
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, forme1.getHauteur(), 
				"Test hauteur par defaut");
	}
	
	@Test
	public void testConstructeuLargeurHauteur() {
		FormeApp forme1 = new FormeApp(15, 16);
		
		assertEquals(new Coordonnees(), forme1.getPosition(), "Test getPosition");
		assertEquals(15, forme1.getLargeur(), "Test largeur");
		assertEquals(16, forme1.getHauteur(), "Test hauteur");
	}
	
	@Test
	public void testSetGetCouleur() {
		forme.setCouleur(Color.BLUE);
		assertEquals(Color.BLUE, forme.getCouleur());
	}

	// Tests Methodes
	// ============================================================================
	@Test
	void testCadre() {
		assertEquals(forme.getCadreMinY(), 0);
		assertEquals(forme.getCadreMinX(), 0);
		assertEquals(forme.getCadreMaxY(), 150);
		assertEquals(forme.getCadreMaxX(), 100);
	}
	
	@Test
	public void testDeplacerVers() {
		forme.deplacerVers(10, 10);
		assertEquals(10, forme.getPosition().getAbscisse());
		assertEquals(10, forme.getPosition().getOrdonnee());
	}
	
	@Test
	public void testDeplacerDe() {
		forme.deplacerDe(15, 20);
		assertEquals(15, forme.getPosition().getAbscisse());
		assertEquals(20, forme.getPosition().getOrdonnee());
	}
	
	@Test
	public void testToString() {
		
		// Tester la locale francaise
		Locale.setDefault(new Locale("fr", "FR"));
		assertEquals("couleur = R51,V51,B51", forme.toString());
		
		// Tester la locale anglaise
		Locale.setDefault(new Locale("en", "US"));
		assertEquals("couleur = R51,G51,B51", forme.toString());
	}

//	@Test
//	public void testEquals() {
//		FormeApp forme1 = new FormeApp(5, 10);
//		FormeApp forme2 = new FormeApp(5, 10);
//		
//		FormeApp forme3 = new FormeApp(new Coordonnees(15, 20), 15, 20);
//		FormeApp forme4 = new FormeApp(15, 20);
//		
//		assertTrue(forme1.equals(forme1));
//		assertTrue(forme1.equals(forme2));
//		
//		assertFalse(forme1.equals(forme3));
//		assertFalse(forme1.equals(forme4));
//		assertFalse(forme1.equals(null));
//	}
	

}

class FormeApp extends Forme{
	
	public FormeApp() {
		super(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public FormeApp(double largeur, double hauteur) {
		super(largeur, hauteur);
	}

	public FormeApp(Coordonnees position) {
		super(position);
	}

	public FormeApp(Coordonnees position, double largeur, double hauteur) {
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setCouleur(COULEUR_PAR_DEFAUT);
	}

	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		// TODO Auto-generated method stub
		return false;
	} 
	
}