package bici.tipo;

import static bici.gui.LettoreImmagini.leggiImmagineBici;
import static bici.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;

import bici.sim.Coordinate;
import bici.sim.Zona;

/**
 * Modella le fasi del ciclo di vista di una bicicletta {@link Bianca}.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Bianca extends Bici{
	static final private Image IMMAGINE_BICI_BIANCA = leggiImmagineBici(java.awt.Color.WHITE);
	static private int progID;
	
	//costruttore
	public Bianca(Zona zona) {
		super(zona, progID++);
	}


	@Override
	protected Coordinate decidiProssimaDestinazione() {
		return posizioneCasuale();
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_BICI_BIANCA;
	}

	
	

}
