package gen.stats;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import gen.sim.Ambiente;
import gen.sim.Scontro;
import gen.stats.Statistiche;
import gen.tipo.Animale;
import gen.tipo.Bianco;
import gen.tipo.Giallo;

public class StatisticheTest {

	
	private Statistiche stats;

	@Before
	public void setUp() {
		this.stats = new Statistiche();
	}
	
	@Test
	public void testScontriPerAnimaleSetVuoto() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		assertTrue(this.stats.scontriPerAnimale(Collections.emptySet()).size()==0);
	}
	
	
	
	@Test
	public void testScontriPerAnimale() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		
		Animale a1 = new Bianco(new Ambiente());
			Set<Animale>animali= new HashSet<Animale>();
			animali.add(a1);
			
			Scontro s1 = new Scontro(animali);
			
			
			Set<Scontro> scontri = new HashSet<Scontro>();
			scontri.add(s1);
		
		assertTrue(this.stats.scontriPerAnimale(scontri).size()==1);
		
	}
	
	
	@Test
	public void testScontriPerAnimale3() {
		// DA COMPLETARE ( VEDI DOMANDA 3 )
		
		Animale a1 = new Bianco(new Ambiente());
		Animale g1 = new Giallo(new Ambiente());
			Set<Animale>animali= new HashSet<Animale>();
			animali.add(a1);
			animali.add(g1);
			Scontro s1 = new Scontro(animali);
			
			
			Set<Scontro> scontri = new HashSet<Scontro>();
			scontri.add(s1);
		
		assertTrue(this.stats.scontriPerAnimale(scontri).size()==1);
		
	}
	

}
