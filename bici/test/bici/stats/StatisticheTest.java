package bici.stats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;
import bici.stats.Statistiche;
import bici.tipo.Bianca;
import bici.tipo.Bici;
import bici.tipo.Gialla;

public class StatisticheTest {

	
	private Statistiche stats;
	private Set<Percorso>percorsi;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
		this.percorsi= new HashSet<Percorso>();
	}
	
	@Test
	public void testPercorsoPerBiciVuoto() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		
		Map<Bici, List<Percorso>> percorsiPerBici = this.stats.percorsiPerBici(percorsi);
		assertTrue(percorsiPerBici.isEmpty());
		
	}
	
	@Test
	public void testPercorsoPerBiciStessoPercorsoBiciDiversa() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Bici b= new Bianca(new Zona());
		Bici g= new Gialla(new Zona());
		
		Coordinate origine = new Coordinate(0, 0);
		Coordinate destinazione = new Coordinate(3, 0);

		Percorso p1 = new Percorso(b, origine, destinazione);
		Percorso p2 = new Percorso(g, origine, destinazione);
		
		percorsi.add(p1);
		percorsi.add(p2);

		
		
		Map<Bici, List<Percorso>> percorsiPerBici = this.stats.percorsiPerBici(percorsi);
		
		//abbiamo due bici diverse con percorso uguale
		assertTrue(percorsiPerBici.size()==2);
		
	}
	
	
	@Test
	public void testPercorsoPerBiciUnTipo() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Bici b= new Bianca(new Zona());
	
		
		Coordinate origine = new Coordinate(0, 0);
		Coordinate destinazione = new Coordinate(3, 0);

		Percorso p1 = new Percorso(b, origine, destinazione);
		
		
		percorsi.add(p1);
	

		
		
		Map<Bici, List<Percorso>> percorsiPerBici = this.stats.percorsiPerBici(percorsi);
		
		//bici bianca segue il percorso p1
		assertEquals(p1,percorsiPerBici.get(b).get(0));
		
	}
	
	
	@Test
	public void testPercorsoPerBiciVuotov() {
		assertTrue(this.stats.percorsiPerBici(Collections.emptySet()).isEmpty());
	}
	
	@Test
	public void testPercorsoPerBiciNonVuoto() {
		Zona zona = new Zona();
		Bici gialla = new Gialla(zona);
		Percorso single = new Percorso(gialla ,new Coordinate(0,0), new Coordinate(1,1));
		assertFalse(this.stats.percorsiPerBici(Collections.singleton(single)).isEmpty());
	}

}
