package car.stats;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Image;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import car.auto.Auto;
import car.auto.Bianca;
import car.sim.Coordinate;
import car.sim.Tragitto;
import car.sim.Zona;

public class StatisticheTest {

	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}
	
	@Test
	public void testTragittoPerAutoVuoto() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		
		assertTrue(this.stats.tragittoPerAuto(Collections.emptyList()).isEmpty());
	}
	
	
	@Test
	public void TestAutoTragitto() {
		Auto bianca = new Bianca(new Zona());
		Tragitto t = new Tragitto(bianca, new Coordinate(0, 0), new Coordinate(3, 2));
		
		assertTrue(this.stats.tragittoPerAuto(Collections.singletonList(t)).size()==1);
		assertTrue(this.stats.tragittoPerAuto(Collections.singletonList(t)).containsKey(bianca));
		
	}

}
