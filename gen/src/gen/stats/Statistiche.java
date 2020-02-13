package gen.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gen.sim.Scontro;
import gen.sim.Simulatore;
import gen.tipo.Animale;
import gen.tipo.Bianco;

public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final Set<Scontro> percorsi = simulatore.getScontri();

		System.out.println(percorsi.size() + " scontri rilevati." );
		System.out.println(simulatore.getScontri());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Scontri di ciascun animale:");
		final Map<Animale,List<Scontro>> animale2scontri = scontriPerAnimale(simulatore.getScontri());
		stampaScontriPerAnimale(animale2scontri);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param scontri - insieme degli scontri collezionati durante la simulazione
	 * @return una mappa che riporti per ogni animale (di qualsiasi tipo)
	 *         la lista degli scontri avuti
	 */
	public Map<Animale, List<Scontro>> scontriPerAnimale(Set<Scontro> scontri) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Animale, List<Scontro>> scontriPerAnimale = new HashMap<Animale, List<Scontro>>();
		
		for(Scontro s:scontri) {
			Animale a = s.getVincente();
			if(scontriPerAnimale.containsKey(a)) {
				scontriPerAnimale.get(a).add(s);
			}
			else {
				List<Scontro> scontricini = new ArrayList<Scontro>();
				scontri.add(s);
				scontriPerAnimale.put(a,scontricini);
			}
		}
		
		
		return scontriPerAnimale;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param animale2scontri
	 */
	private void stampaScontriPerAnimale(final Map<Animale, List<Scontro>> animale2scontri) {
		for(Animale animale : animale2scontri.keySet()) {
			final List<Scontro> scontri = animale2scontri.get(animale);
			System.out.println(animale + " ha superato " + ( scontri!=null ? scontri.size() : 0 ) +" scontri");
		}
	}


}
