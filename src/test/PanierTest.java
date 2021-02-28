package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fruit.Banane;
import fruit.Fruit;
import fruit.Orange;
import fruit.Panier;

public class PanierTest {
	
	private Panier plein, vide ;
	private Fruit a,b,c,d,e,f,g;
	private int nombreDePaniers;
	
	@BeforeEach
	public void initialiser() throws Exception {
		
		/* Pour remettre la variable statique nombreDeOaniers de Panier à 0 */
		java.lang.reflect.Field champ = Panier.class.getDeclaredField("nombreDePaniers");
		champ.setAccessible(true);
		champ.set(null, 0);
		
		/* Création de 7 fruits */
		a = new Orange("France", 80);
		b = new Orange("Espagne", 90);
		c = new Orange("Espagne", 80);
		d = new Orange("Maroc",90,8);
		e = new Banane("Espagne");
		f = new Banane("Espagne");
		g = new Banane("France");
		
		/* Création de 2 paniers */
		vide = new Panier();
		plein = new Panier();
		plein.add( a); 
		plein.add(b); 
		plein.add(d); 
		plein.add( a); 
		plein.add(b); 
		plein.add(c);
		plein.add(e);
		plein.add(f);
		plein.add(g);
		nombreDePaniers = 2;
	}
	
	@Test
	public void testToString() throws Exception {
		int numero = 2;
		assertEquals( "Panier " + numero + " [\nOrange France 0.8€\nOrange Espagne 0.9€\n"
				+ "Orange Maroc 0.5€\nOrange France 0.8€\nOrange Espagne 0.9€\n"
				+ "Orange Espagne 0.8€\nBanane Espagne 0.2€\nBanane Espagne 0.2€\n"
				+ "Banane France 0.2€\n]\n", plein.toString());
		assertEquals( "Panier " + (numero-1) + " [\n]\n", vide.toString());
	}

	@Test
	public void testGetValeur() throws Exception {
		assertEquals( 0.0, vide.getValeur(), 0.01);
		assertEquals( 0.8*3+0.9*2+0.5+0.2*3, plein.getValeur(), 0.01);
	}
	
	@Test
	public void testFiltreOrigine() throws Exception {
		String attendue = plein.toString();
		plein.filtreOrigine( "Italie");
		assertEquals( attendue, plein.toString());
		plein.filtreOrigine( "Espagne");
		assertEquals( "Panier " + (nombreDePaniers) + " [\nOrange France 0.8€\n"
				+ "Orange Maroc 0.5€\nOrange France 0.8€\n"
				+ "Banane France 0.2€\n]\n", plein.toString());
		plein.filtreOrigine( "France");
		assertEquals( "Panier " + (nombreDePaniers) + " [\nOrange Maroc 0.5€\n]\n", plein.toString());
		plein.filtreOrigine( "Maroc");
		assertEquals( "Panier " + (nombreDePaniers) + " [\n]\n", plein.toString());
		
		vide.filtreOrigine( "Maroc");
		assertEquals( "Panier " + (nombreDePaniers-1) + " [\n]\n", vide.toString());	
	}
}
