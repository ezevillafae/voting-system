package entidades;

import java.util.HashMap;

public class MesaEnfermedadPreexistente extends Mesa{

	public MesaEnfermedadPreexistente(Votante presidenteMesa) {
		super(presidenteMesa);
	}

	@Override
	public void crearFranjasHorarias() {
		HashMap<Integer, Integer> franjas = getFranjasHorarias();
		for (int i = 8; i < 18; i++) {
			franjas.put(i, Definiciones.cupoXFranjaHorariaEnfPreexistente);
		}
	}	

}
