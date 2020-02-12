package bici.stats;

import java.util.*;

import bici.sim.Coordinate;
import bici.sim.Percorso;
import bici.sim.Zona;
import bici.tipo.Bici;

public class Statistiche {

	synchronized public void stampaFinale(Zona zona) {
		final Set<Percorso> percorsi = zona.getPercorsi();

		System.out.println(percorsi.size() + " percorsi collezionati." );
		System.out.println(zona.getPercorsi());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Percorsi di ciascuna bicicletta:");
		final Map<Bici,List<Percorso>> bici2percorsi = percorsiPerBici(percorsi);
		stampaPercorsiPerBici(bici2percorsi);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Classifica finale delle posizioni piu' battute:");
		final SortedMap<Coordinate,Integer> pos2utilizzi = utilizzi(bici2percorsi);
		stampaUtilizzi(pos2utilizzi);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param percorsi - insieme dei percorsi collezionati durante la simulazione
	 * @return una mappa che riporti per ogni bici (di qualsiasi tipo)
	 *         la lista dei percorsi coperti
	 */
	public Map<Bici, List<Percorso>> percorsiPerBici(Set<Percorso> percorsi) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Bici, List<Percorso>> percorsiPerBici = new HashMap<Bici, List<Percorso>>();
		
		
		for(Percorso p:percorsi) {
			Bici b = p.getBici();
			
			if(percorsiPerBici.containsKey(b)) {
				percorsiPerBici.get(b).add(p);
			}
			
			
			else {
				List<Percorso> perco= new ArrayList<Percorso>();
				perco.add(p);
				percorsiPerBici.put(b, perco);
			}
		}
		
		return percorsiPerBici;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param bici2percorsi
	 */
	private void stampaPercorsiPerBici(final Map<Bici, List<Percorso>> bici2percorsi) {
		for(Bici bici : bici2percorsi.keySet()) {
			List<Percorso> percorsi = bici2percorsi.get(bici);
			System.out.println("La bicicletta "+bici+" ha coperto "+( percorsi!=null ? percorsi.size() : 0 ) +" corse");
		}
	}
	
	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * 	@param bici2percorsi - insiemi dei percorsi collezionati durante la simulazione
	 *                         e raggruppati per bici
	 * @return una mappa ordinata decrescente in cui figurano come chiavi 
	 *         le posizioni piu' battute come origine o destinazione di un 
	 *         percorso, come valori il numero di tali percorsi
	 */

	public SortedMap<Coordinate,Integer> utilizzi(Map<Bici, List<Percorso>> bici2percorsi) {
	
		
		
		Map<Coordinate,Integer> utilizzi= new HashMap<Coordinate, Integer>();
		
		for(List<Percorso> percorsi : bici2percorsi.values()) {
			
			for(Percorso p: percorsi) {
				conta(utilizzi, p.getOrigine());
				conta(utilizzi,p.getDestinazione());
			}
			
			
		}				
		
		class ComparatoreCoordinate implements Comparator<Coordinate> {

			@Override
			public int compare(Coordinate c1, Coordinate c2) {
			
				int output = utilizzi.get(c2)-utilizzi.get(c1);
				if(output==0)
					return -1;
				
				return output;
			}

		
		}		
		
		SortedMap<Coordinate,Integer> risultato= new TreeMap<>(new ComparatoreCoordinate());
		
		risultato.putAll(utilizzi);
		
		return risultato;
			
	}

	@SuppressWarnings("deprecation")
	private void conta(Map<Coordinate, Integer> utilizzi,Coordinate c) {
		
		if(utilizzi.containsKey(c)) {
			Integer nuovo = utilizzi.get(c)+1;
			utilizzi.put(c, nuovo);
			
		}
		
		else {
			utilizzi.put(c, new Integer(1));
		}
	}
		
		
			/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param classifica delle posizioni piu' usate
	 */
	private void stampaUtilizzi(SortedMap<Coordinate,Integer> classifica) {
		int i = 0;
		for(Map.Entry<Coordinate, Integer> entry : classifica.entrySet()) {
			final Coordinate posizione = entry.getKey();
			final Integer numeri = entry.getValue();
			System.out.println(i+") "+posizione+" con "+numeri+" utilizzi");
			i++;
		}
	}

}
