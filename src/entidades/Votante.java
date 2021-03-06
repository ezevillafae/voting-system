package entidades;

import estructurasdedatos.Tupla;

public class Votante extends Persona {
	private boolean certificadoTrabajo;
	private boolean presidenteDeMesa;
	private boolean voto;
	private Tupla<Integer, Integer> turno;

	public Votante(String nombre, int dni, int edad, boolean enfermedad, boolean certificadoTrabajo) {
		super(nombre, dni, edad, enfermedad);

		if (edad < 16) {
			throw new RuntimeException("Un votante debe tener > 16 años");
		}

		this.voto = false;
		this.turno = null;
		this.certificadoTrabajo = certificadoTrabajo;
		this.presidenteDeMesa = false;
	}

	public boolean esPresidenteDeMesa() {
		return this.presidenteDeMesa;
	}

	public void asignarComoPresidenteDeMesa() {
		if (!tieneTurno()) {
			this.presidenteDeMesa = true;
		}
	}

	public boolean tieneCertificadoTrabajo() {
		return this.certificadoTrabajo;
	}

	public void confirmarVoto() {
		if (tieneTurno()) {
			this.voto = true;
		}
	}

	public boolean tieneTurno() {
		return turno != null;
	}

	public boolean consultarVoto() {
		return this.voto;
	}

	public Tupla<Integer, Integer> asignarTurno(int codigoMesa, int horario) {
		if (!tieneTurno()) // advertencia pregunta 2 veces (sistema en asignarTurno)
			this.turno = new Tupla<>(codigoMesa, horario);
		return consultarTurno();
	}

	public Tupla<Integer, Integer> consultarTurno() {
		return this.turno;
	}
	
	public Integer consultarHorario() {
		if(!tieneTurno()) 
			return null;
		return consultarTurno().getY();
	}
	
	public boolean estaEnMesa(Integer codigo) {
		if(!tieneTurno()) 
			return false;
		return consultarTurno().getX().equals(codigo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------- votante -----------");
		sb.append(super.toString());
		sb.append("\n");
		sb.append("certificado de trabajo :").append(certificadoTrabajo);
		sb.append("\n");
		sb.append("votó : ").append(this.voto);
		sb.append("\n");
		sb.append("Es presidente de Mesa : ").append(this.presidenteDeMesa);
		sb.append("\n");
		sb.append("Turno mesa-horario : ").append(this.turno);
		sb.append("\n");
		return sb.toString();
	}
	
}
