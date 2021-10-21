package entidades;

import java.util.HashMap;

public class MesaMayores extends Mesa{

	public MesaMayores(Votante presidenteMesa) {
		super(presidenteMesa);
		
	}

	@Override
	public void crearFranjasHorarias() {
		HashMap<Integer, Integer> franjas = getFranjasHorarias();
		for (int i = 8; i < 18; i++) {
			franjas.put(i, Definiciones.cupoXFranjaHorariaEnMayores);
		}
	}
	
	

}
