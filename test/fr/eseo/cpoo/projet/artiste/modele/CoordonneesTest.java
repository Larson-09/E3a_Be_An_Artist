package fr.eseo.cpoo.projet.artiste.modele;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CoordonneesTest {
	Coordonnees coordonnees;
	
	@BeforeEach
	void setUp() throws Exception {
		this.coordonnees = new Coordonnees();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		this.coordonnees = null;
	}

	@Test
	public void testConstructeur() {
		Coordonnees coordonnes = new Coordonnees();
		//Tests
		assertEquals(0, coordonnes.getAbscisse());
		assertEquals(0, coordonnes.getOrdonnee());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/DT_Coord")
	public void testConstructeur2(double a, double b, 
			double abscisseAttendue, double ordonneeAttendue) {
		Coordonnees coordonnes2 = new Coordonnees(a, b);
		assertEquals(abscisseAttendue, coordonnes2.getAbscisse(), "Test de l'abscisse");
		assertEquals(ordonneeAttendue, coordonnes2.getOrdonnee(), "Test de l'ordonnee");
	}
	
	@Test
	public void testSet() {
		coordonnees.setAbscisse(10);
		assertEquals(10, coordonnees.getAbscisse());
		
		coordonnees.setOrdonnee(15);
		assertEquals(15, coordonnees.getOrdonnee());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/DT_deplacerVers")
	public void testDeplacerVers(double a, double b) {
		Coordonnees coordonnes1 = new Coordonnees();
		coordonnes1.deplacerVers(a, b);
		assertEquals(a, coordonnes1.getAbscisse(), "Test de l'abscisse");
		assertEquals(b, coordonnes1.getOrdonnee(), "Test de l'ordonnee");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/DT_deplacerDe")
	public void testDeplacerDe(double a, double b, 
			double abscisseAttendue, double ordonneeAttendue) {
		coordonnees.deplacerDe(a,b);
		assertEquals(abscisseAttendue, coordonnees.getAbscisse(), "Test de l'abscisse");
		assertEquals(ordonneeAttendue, coordonnees.getOrdonnee(), "Test de l'ordonnee");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/DT_distanceVers")
	public void testDistanceVers(double a, double b, double distanceAttendue) {
		Coordonnees coordonnes2 = new Coordonnees(a,b);
		assertEquals(distanceAttendue, coordonnees.distanceVers(coordonnes2), 
				0.5, "Test de la distance");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/DT_angleVers")
	public void testAngleVers(double a, double b, double distanceAttendue) {
		Coordonnees coordonnes2 = new Coordonnees(a,b);
		assertEquals(distanceAttendue, coordonnees.angleVers(coordonnes2), 
					"Test de l'angle");
	}
	
	@Test 
	public void testToString() {
		
		Locale.setDefault(new Locale("fr", "FR"));
		assertEquals(coordonnees.toString(), "(0,0 , 0,0)");
		
		Locale.setDefault(new Locale("en", "EN"));
		assertEquals(coordonnees.toString(), "(0.0 , 0.0)");
	}
	
	@Test
	public void testEquals() {
		Coordonnees c1 = new Coordonnees(5, 10);
		Coordonnees c2 = new Coordonnees(5, 10);
		
		assertTrue(c1.equals(c1));
		assertTrue(c1.equals(c2));
		
		Coordonnees c3 = new Coordonnees(15, 20);
		Coordonnees c4 = new Coordonnees(5, 20);
		Coordonnees c5 = new Coordonnees(15, 5);
		
		assertFalse(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c1.equals(c5));
		assertFalse(c1.equals(null));
	}
}