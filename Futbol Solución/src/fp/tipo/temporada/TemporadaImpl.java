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
//g.	M�todo que dado un equipo devuelva el n�mero de goles como visitante
//h.	M�todo que dado un valor n devuelva el conjunto de equipos que han obtenido m�s de n victorias como visitante. 
//i.	Haga una segunda versi�n del anterior devolviendo un conjunto ordenado por n�mero de goles de mayor a menor.
//j.	M�todo que dado un mes devuelva el n�mero de goles marcados ese mes.
//k.	M�todo que devuelva el equipo con m�s victorias como visitante.
//l.	M�todo que devuelva el equipo menos goleador en casa.
//m.	M�todo que devuelva el partido con mayor diferencia de goles.
//

