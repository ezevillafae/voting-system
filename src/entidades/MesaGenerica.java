package entidades;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MesaGenerica extends Mesa{

	public MesaGenerica(Votante presidenteMesa){
		super(presidenteMesa);
	}

	@Override
	public void crearFranjasHorarias() {
		HashMap<Integer, Integer> franjas = getFranjasHorarias();
		for (int i = 8; i < 18; i++) {
			franjas.put(i, 0);
		}
	}
	
	public int buscarFranjaHoraria() {
        Iterator<Entry<Integer, Integer>> it = this.getFranjasHorarias().entrySet().iterator();
        int franjaDisponible=-1;
        while (it.hasNext() && franjaDisponible==-1) {
            Entry<Integer, Integer> franja = it.next();
            if (franja.getValue()<30) {
                franjaDisponible= franja.getKey();
            }
        }

        return franjaDisponible;
    }
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
