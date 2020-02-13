package gen.sim;

import java.util.Set;

import gen.tipo.Animale;

public class Incontro {

	private Set<Animale> animali;

	public Incontro(Set<Animale> animali) {
		if (animali.size()!=2) throw new IllegalArgumentException();
		this.animali = animali;
	}
	
	public Set<Animale> getAnimali() {
		return this.animali;
	}
	
	public Animale figlio() {
		final Animale genitore = this.animali.iterator().next();
		final Animale clone = genitore.creaClone();
		clone.setPosizione(genitore.getPosizione());
		clone.setDirezione(Direzione.casuale());
		return clone;
    }
	
}
