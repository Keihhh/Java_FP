package fp.tipo.temporada;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Temporada{
	
	String getNombre();
	Integer getNumPartidosJugados();
//	Integer getGolesMarcadosEquipo(String equipo);
//	Integer getVictoriasVisitantes();
//	Integer getPartidosRemontadaVisitante();
//	Integer getPuntosEquipoHastaFecha(String equipo, LocalDate fecha);
//	String getCampeon();

	//Añadidos posterior:
//	Integer getNumGolesVisitantes(String equipo);
	
	//Conjunto de equipos con mas de "n" victorias
	//Conjunto con equipos ordenado por nº de goles(mayor a menor)
	
//	Integer getNumGolesEnMes(Integer mes);                                 
//	String getEquiposConMasVictVisit();
//	String getEquipoLocalMenosGoleador();
	
	//Partido con mayor diferencia de goles
	



}
