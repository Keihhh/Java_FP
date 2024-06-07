package fp.tipo.partido;

import java.time.LocalDate;

import fp.util.Checkers;

public class PartidoResultadoImpl extends PartidoImpl implements PartidoResultado {

	private Integer localDesc;
	private Integer localFin;
	private Integer visitDesc;
	private Integer visitFin;
	
	public PartidoResultadoImpl(LocalDate fecha, String equipoLocal, String equipoVisit, Integer localDesc, Integer localFin, Integer visitDesc, Integer visitFin) {
		super (fecha, equipoLocal, equipoVisit);
		
		Checkers.check("Goles local final debe estar entre 0 y 10", localFin>=0 && localFin<=10);
		Checkers.check("Goles visitante final debe estar entre 0 y 10", visitFin>=0 && visitFin<=10);
		Checkers.check("Goles local descanso debe estar entre 0 y 10", localDesc>=0 && localDesc<=10);
		Checkers.check("Goles visitante descanso debe estar entre 0 y 10", visitDesc>=0 && visitDesc<=10);
			
		this.localDesc=localDesc;
		this.localFin=localFin;
		this.visitDesc=visitDesc;
		this.visitFin=visitFin;
	}
	
	
	
	public Integer getLocalDesc() {
		return localDesc;
	}

	
	public Integer getLocalFin() {
		return localFin;
	}


	public Integer getVisitDesc() {
		return visitDesc;
	}

	public Integer getVisitFin() {
		return visitFin;
	}
	
	
	//Propiedad derivada
	public Resultado getResultado() {
		Resultado resDesc = Resultado.EMPATE;
		if(localDesc > visitDesc) {
			resDesc = Resultado.LOCAL;
		}
		else if (localDesc < visitDesc) {
			resDesc = Resultado.VISITANTE;
		}
		return resDesc;
	}
	
	//Propiedad derivada descanso 
	public Resultado getResultadoFin() {
		Resultado resFin = Resultado.EMPATE;
		if(localFin> visitFin) {
			resFin = Resultado.LOCAL;
		}
		else if (localFin < visitFin) {
			resFin = Resultado.VISITANTE;
		}
		return resFin;
	}
}
