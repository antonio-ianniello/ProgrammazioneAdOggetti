package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_GIALLO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;

import java.awt.Image;
import java.util.List;

import gen.sim.Ambiente;

public class Giallo extends Animale{

	static final private Image IMMAGINE_GIALLA = leggiImmagineOggetto(RISORSA_IMMAGINE_GIALLO);

	static private int progId=0;

	
	
	public Giallo(Ambiente ambiente) {
		super(ambiente, progId++);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Animale creaClone() {
		return new Giallo(this.getAmbiente());
	}

	@Override
	protected Animale decidiProssimoObiettivo() {
		List<Animale> all = this.getAmbiente().getAllSpecieDiversa(Giallo.class);
		return all.get(generaNumeroSinoA(all.size()));
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_GIALLA;
	}

}
