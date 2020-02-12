package car.stats;

import java.util.*;

import car.auto.Auto;
import car.auto.Bianca;
import car.sim.Coordinate;
import car.sim.Tragitto;
import car.sim.Zona;

public class Statistiche {

	synchronized public void stampaFinale(Zona zona) {
		final List<Tragitto> tragitti = zona.getTragitti();

		System.out.println(tragitti.size() + " tragitti collezionati." );
		System.out.println(zona.getTragitti());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Percorsi di ciascuna vettura:");
		final Map<Auto,Set<Tragitto>> auto2tragitti = tragittoPerAuto(tragitti);
		stampaTragittiPerAuto(auto2tragitti);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Classifica finale delle posizioni piu' battute:");
		final SortedMap<Coordinate,Integer> pos2utilizzi = utilizzi(tragitti);
		stampaUtilizzi(pos2utilizzi);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param tragitti - lista dei tragitti collezionati durante la simulazione
	 * @return una mappa che riporti per ogni auto (di qls tipo)
	 *         l'insieme dei tragitti che ha percorso
	 */
	public Map<Auto, Set<Tragitto>> tragittoPerAuto(List<Tragitto> tragitti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		 Map<Auto, Set<Tragitto>> tragittoPerAuto = new HashMap<Auto, Set<Tragitto>>();
		 
		 
		 for(Tragitto t : tragitti) {
			 
			 Auto a=t.getAuto();
			 if(tragittoPerAuto.containsKey(a)) {
				 tragittoPerAuto.get(a).add(t);
			 }
			 else {
				 Set<Tragitto>insieme = new HashSet<Tragitto>();
				 insieme.add(t);
				 tragittoPerAuto.put(a,insieme);
			 }
			 
		 }
		 
		 
		 
		 return tragittoPerAuto;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param auto2tragitti
	 */
	private void stampaTragittiPerAuto(final Map<Auto, Set<Tragitto>> auto2tragitti) {
		for(Auto auto : auto2tragitti.keySet()) {
			Set<Tragitto> tragitti = auto2tragitti.get(auto);
			System.out.println("L'auto "+auto+" ha fatto "+( tragitti!=null ? tragitti.size() : 0 ) +" corse");
		}
	}
	
	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * 	@param tragitti - lista dei tragitti collezionati durante la simulazione
	 * @return una mappa ordinata decrescente in cui figurano come chiavi 
	 *         le posizioni piu'battute come origine o destinazione di un 
	 *         tragitto, come valori il numero di tali tragitti
	 */
	public SortedMap<Coordinate,Integer> utilizzi(List<Tragitto> tragitti) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		Map<Coordinate,Integer> utili = new HashMap<Coordinate, Integer>();
		
		for(Tragitto t:tragitti) {
			conta(utili, t.getOrigine());
			conta(utili,t.getDestinazione());
		}
		
		
		class ComparatoreCoordinate implements Comparator<Coordinate> {

			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				
				int output= utili.get(c2)-utili.get(c1);
				
				if(output==0)
					return -1;
				
				return output;
			}
			
		}
		
		
		SortedMap<Coordinate,Integer> utilizzi = new TreeMap<>(new ComparatoreCoordinate());
		
		utilizzi.putAll(utili);
		
		return utilizzi;
	}

	@SuppressWarnings("deprecation")
	private void conta(Map<Coordinate, Integer> utili, Coordinate c) {
		
		
		if(utili.containsKey(c)) {
			Integer valore = utili.get(c)+1;
			utili.put(c, valore);
			
		}
		else {
			utili.put(c, new Integer(1));
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
