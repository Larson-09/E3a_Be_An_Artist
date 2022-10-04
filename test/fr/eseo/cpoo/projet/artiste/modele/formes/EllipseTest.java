package fr.eseo.cpoo.projet.artiste.modele.formes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class EllipseTest {
	
	private Ellipse ellipse;

	@BeforeEach
	void setUp() throws Exception {
		this.ellipse = new Ellipse();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.ellipse = null;
	}
	
	// Tests Constructeurs 
	// =================================================================================
	
	@Test
	public void testConstructeurVide() {
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), "Test largeur par defaut");
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), "Test hauteur par defaut");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, ellipse.getCouleur(), "Test couleur par defaut");
	}
	
	@Test
	public void testConstructeurLargeurHauteur() {
		Ellipse e = new Ellipse(10.5, 15.5);
		
		assertEquals(10.5, e.getLargeur(), "Test getLargeur");
		assertEquals(15.5, e.getHauteur(), "Test getHauteur");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, ellipse.getCouleur(), "Test couleur par defaut");
	}
	
	@Test
	public void testConstructeurPosition() {
		Ellipse e = new Ellipse(new Coordonnees(5.5, 8.5));
		
		assertEquals(new Coordonnees(5.5, 8.5), e.getPosition(), 
				"Test getPosition");
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), 
				"Test getLargeur");
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), 
				"Test getHauteur");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, ellipse.getCouleur(), 
				"Test couleur par defaut");
	}
	
	@Test
	public void testConstructeurPositionLargeurHauteur() {
		Ellipse e = new Ellipse(new Coordonnees(5.5, 8.5), 10.5, 15.5);
		
		assertEquals(new Coordonnees(5.5, 8.5), e.getPosition(), "Test getPosition");
		assertEquals(10.5, e.getLargeur(), "Test getLargeur");
		assertEquals(15.5, e.getHauteur(), "Test getHauteur");
		assertEquals(Forme.COULEUR_PAR_DEFAUT, ellipse.getCouleur(), 
				"Test couleur par defaut");
	}
	
	// Tests Setters
	// =================================================================================
	
	@Test
	public void testSetLargeurNegatifException() {
	    assertThrows(IllegalArgumentException.class, ()->{
	            ellipse.setHauteur(-1.5);
	    	});
	}
	
	@Test
	public void testSetHauteurNegatifException() {
	    assertThrows(IllegalArgumentException.class, ()->{
	            ellipse.setLargeur(-1.5);
	    	});
	}
	
	// Tests Methodes 
	// =================================================================================
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/ellipse/DT_perimetre")
	public void testPerimetre(double largeur, double hauteur, double perimetreAttendu) {
		
		this.ellipse.setLargeur(largeur);
		this.ellipse.setHauteur(hauteur);
		assertEquals(perimetreAttendu, this.ellipse.perimetre(), 0.1, "Test Perimetre");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/ellipse/DT_aire")
	public void testAire(double largeur, double hauteur, double aireAttendu) {
		
		this.ellipse.setLargeur(largeur);
		this.ellipse.setHauteur(hauteur);		
		assertEquals(aireAttendu, this.ellipse.aire(), 0.1, "Test aire");
	}
	
	@Test
	public void testContient() {
		assertTrue(ellipse.contient(new Coordonnees(80, 80)));
		assertFalse(ellipse.contient(new Coordonnees(1000, 1000)));
	}
	
	@Test
	public void testToString() {
		Ellipse e = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		String pos = e.adapterFormat(10.0);
		String petitRayon = e.adapterFormat(10.5 / 2);
		String grandRayon = e.adapterFormat(15.5 / 2);
		String perimetre = e.adapterFormat(63.82);
		String aire = e.adapterFormat(294.52);
		
		String chaineAttendu = "[Ellipse aucune] : pos (10,0 , 10,0) "
				+ "petit rayon 7,5 grand rayon 12,5 "
				+ "périmètre : 63,82 aire : 294,52 couleur = R51,V51,B51";
		
		assertEquals(chaineAttendu, e.toString());
	}
}
