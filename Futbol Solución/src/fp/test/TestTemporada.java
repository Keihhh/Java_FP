package fp.test;

import fp.tipo.temporada.FactoriaTemporada;
import fp.tipo.temporada.Temporada;

public class TestTemporada {
	
	public static void main(String[]args) {
		Temporada tmp=FactoriaTemporada.leeTemporada("Temporada-18-19.csv");
		System.out.println("En la temporada "+tmp.getNombre()+" se jugaron "+tmp.getNumPartidosJugados());
	}
}
