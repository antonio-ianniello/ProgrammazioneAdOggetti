package car.sim;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ZonaTest {
	
	private Zona zona;
	
	
	@Before
	public void setUp() {
		this.zona= new Zona();
	}
	
	
	@Test
	public void testa_getDirezioni_4Possibili() {
		assertEquals(4,this.zona.getPossibiliDirezioni(new Coordinate(2, 2)).size());
	}
	
	
	@Test
	public void testa_getDirezioni_3Possibili() {
		this.zona.addOstacolo(2, 3);
		assertEquals(3,this.zona.getPossibiliDirezioni(new Coordinate(2, 2)).size());
	}
	
	
	@Test
	public void testa_getDirezioni_Zero_Possibili() {
		this.zona.addOstacolo(2, 3);
		this.zona.addOstacolo(2, 1);
		this.zona.addOstacolo(1, 2);
		this.zona.addOstacolo(3, 2);


		assertEquals(0,this.zona.getPossibiliDirezioni(new Coordinate(2, 2)).size());
	}
	
	
	

}
