package fp.tipo.temporada;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.tipo.partido.PartidoResultado;
import fp.tipo.partido.PartidoResultadoImpl;
import fp.tipo.partido.Resultado;

public class TemporadaImpl implements Temporada{ 
	private String nombre;
	private SortedSet<PartidoResultado> partidos;
	
	public TemporadaImpl(String nombre, List<PartidoResultado> lp) {
		this.nombre=nombre;
		partidos=new TreeSet<>(lp);
		
		//Otra forma:
		//partidos = new TreeSet<>();      //Al no poner Comparator es el orden natural
		//partidos.addAll(lp);
	}
	
	public String getNombre() {
		return nombre; 
	}
	
	public Integer getNumPartidosJugados() {
		return partidos.size();
	} 

	
//	public int compareTo(Temporada tmp) {
//		return this.getNombre().compareTo(tmp.getNombre());
//	}
	
//	public Map<String, Integer> getMapNumVictoriasVisitantesXEquipo(){
//		Map<String, Integer> res=new HashMap<>();
//		
//		for (PartidoResultado p:partidos) {
//			String clave=p.getEquipoVisit();
//			if (p.getResultadoFin().equals(Resultado.VISITANTE)) {
//				if(res.containsKey(clave)) {
//					res.put(clave,  res.get(clave+1));
//				}
//				else {
//					Integer valor=p.getNumGolesVisitantes();
//					res.put(clave, valor);
//				}
//			}
//		}
//		return res;
//	}
//	
	
	
}



//Nuevos ejercicios
//
//
//g.	Método que dado un equipo devuelva el número de goles como visitante
//h.	Método que dado un valor n devuelva el conjunto de equipos que han obtenido más de n victorias como visitante. 
//i.	Haga una segunda versión del anterior devolviendo un conjunto ordenado por número de goles de mayor a menor.
//j.	Método que dado un mes devuelva el número de goles marcados ese mes.
//k.	Método que devuelva el equipo con más victorias como visitante.
//l.	Método que devuelva el equipo menos goleador en casa.
//m.	Método que devuelva el partido con mayor diferencia de goles.
//

