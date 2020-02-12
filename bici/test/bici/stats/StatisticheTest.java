package bici.stats;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	public void testPercorsoPerBici() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		Bianca b= new Bianca(new Zona());
		Gialla g= new Gialla(new Zona());
		
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

}
