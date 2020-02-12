package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;

import java.awt.Image;
import java.util.List;
import java.util.Random;

import bici.sim.Coordinate;
import bici.sim.CostantiSimulazione;
import bici.sim.GeneratoreCasuale;
import bici.sim.Zona;

public class Gialla extends Bici {
	
	static final private Image IMMAGINE_BICI_GIALLA = leggiImmagineBici(java.awt.Color.YELLOW);
	static private int progID=0;
	static private List<Coordinate> destinazioniGialle=GeneratoreCasuale.generaNposizioniCasuali(CostantiSimulazione.NUMERO_BICI_PER_TIPOLOGIA);
	private Random random;
	
	
	public Gialla(Zona zona) {
		super(zona, progID++);
	}
	
	

	
	public List<Coordinate> getDestinazioniGialle() {
		return destinazioniGialle;
	}
	
	
	

	public static void setDestinazioniGialle(List<Coordinate> destinazioniGialle) {
		Gialla.destinazioniGialle = destinazioniGialle;
	}




	//deve scegliere solo in un elenco ristretto
	@Override
	protected Coordinate decidiProssimaDestinazione() {
		random = new Random();
		return this.getDestinazioniGialle().get(random.nextInt(Gialla.destinazioniGialle.size()));
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_BICI_GIALLA;
	}
	


}
