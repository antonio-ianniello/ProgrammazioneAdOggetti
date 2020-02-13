package gen.tipo;


import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;
import static gen.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.List;
import java.util.Set;

import gen.sim.Ambiente;
import gen.sim.Coordinate;
import gen.sim.Direzione;
import gen.sim.Genere;

public class Bianco extends Animale{
	
	
	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);

	static private int progId=0;

	
	
	
	
	public Bianco(Ambiente ambiente) {
		super(ambiente, progId++);
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	public Bianco creaClone() {
		return new Bianco(this.getAmbiente());
	}
	@Override
	protected Animale decidiProssimoObiettivo() {
		/* scegli un obiettivo casualmente */
		// Sugg.: al momento sono tutti della stessa specie, ma dopo DOMANDA 2bcd e' ancora vero? */
		List<Animale> all = this.getAmbiente().getAllStessaSpecie(Bianco.class);
		return all.get(generaNumeroSinoA(all.size()));
	}
	
@Override
	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}

@Override
public String toString() {
	return Bianco.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
}
	

	

}
