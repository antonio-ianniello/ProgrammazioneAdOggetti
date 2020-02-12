package bici.tipo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import bici.sim.Coordinate;
import bici.sim.Zona;

public class GiallaTest {
	
	
	private Gialla gialla;
	
	
	@Before
	public void setUp() throws Exception {
		this.gialla = new Gialla(new Zona());
	}
	
	
	@Test
	public void test_Prossima_Destinazione() {
		assertTrue(this.gialla.getDestinazioniGialle().contains(gialla.decidiProssimaDestinazione()));
	}
	
	
	@Test
	public void test_Prossima_Destinazione_Singola_Destinazione() {
		Gialla.setDestinazioniGialle(Collections.singletonList(new Coordinate(0, 0)));
		assertEquals(new Coordinate(0,0),this.gialla.decidiProssimaDestinazione());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private Gialla gialla;
	
	@Before
	public void setUp() {
		this.gialla= new Gialla(new Zona());
		
	}

	
	
	@Test
	public void testDEcidiProssimaDestinazione() {
		assertTrue(this.gialla.getDestinazioniGialle().contains(gialla.decidiProssimaDestinazione()));
	}
	
	
	@Test
	public void testDecidiProssimaDirezioneSingola() {
		Gialla.setDestinazioniGialle(Collections.singletonList(new Coordinate(0, 0)));		
		assertEquals(new Coordinate(0,0),this.gialla.decidiProssimaDestinazione());
	}
	
	
	
	*/
}
