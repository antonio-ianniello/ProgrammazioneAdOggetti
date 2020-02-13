package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_VERDE;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import gen.sim.Ambiente;
import gen.sim.CostantiSimulazione;

public class Verde extends Animale{

	
	static final private Image IMMAGINE_VERDE = leggiImmagineOggetto(RISORSA_IMMAGINE_VERDE);

	static private int progId=0;
	
	public Verde(Ambiente ambiente) {
		super(ambiente, progId++);
		
	}

	@Override
	public Animale creaClone() {
		return new Verde(this.getAmbiente());
	}

	@Override
	protected Animale decidiProssimoObiettivo() {
		// TODO Auto-generated method stub
		List<Animale> all= new ArrayList<Animale>();
		
		//PRIMA DELL' ETA SONO COME I GIALLI
		if(this.getEta()<CostantiSimulazione.MIN_ETA_RIPRODUZIONE) {
			all = this.getAmbiente().getAllSpecieDiversa(Verde.class);
			
		}
		
		//senno' come bianchi
		else {
			all = this.getAmbiente().getAllStessaSpecie(Verde.class);
			
		}
		return all.get(generaNumeroSinoA(all.size()));
	}

	@Override
	public Image getImmagine() {
		
		return IMMAGINE_VERDE;
	}

}
