package car.auto;

import static car.gui.LettoreImmagini.leggiImmagineVettura;

import java.awt.Image;
import java.util.List;
import java.util.Random;

import car.sim.Coordinate;
import car.sim.CostantiSimulazione;
import car.sim.GeneratoreCasuale;
import car.sim.Zona;

public class Gialla extends Auto{
	
	
	static final private Image IMMAGINE_VETTURA_GIALLA = leggiImmagineVettura(java.awt.Color.YELLOW);

	static private int progId = 0;
	
	static private List<Coordinate> destinazioneGIalle= GeneratoreCasuale.generaNposizioniCasuali(CostantiSimulazione.N_DESTINAZIONI_GIALLE);
	
	private Random random;
	
	public Gialla(Zona zona) {
		super(zona, progId++);
	}
	

	public List<Coordinate> getDestinazioneGIalle() {
		return destinazioneGIalle;
	}




	public static void setDestinazioneGIalle(List<Coordinate> destinazioneGIalle) {
		Gialla.destinazioneGIalle = destinazioneGIalle;
	}




	@Override
	protected Coordinate decidiProssimaDestinazione() {
		random = new Random();
		return this.getDestinazioneGIalle().get(random.nextInt(Gialla.destinazioneGIalle.size()));
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_VETTURA_GIALLA;
	}

}
