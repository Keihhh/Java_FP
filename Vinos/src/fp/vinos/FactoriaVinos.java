package fp.vinos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class FactoriaVinos {

	public static Vinos leerVinos(String nomfich){
		
		Vinos res=null;
		
		try {
			List<Vino> lista_vinos = Files.lines(Paths.get(nomfich),StandardCharsets.UTF_8).
				    skip(1).
					map(FactoriaVinos::parseoVino).
				    collect(Collectors.toList());
			res=new Vinos(lista_vinos);
		} catch (IOException e) {
			System.out.println("Fichero no encontrado " + nomfich);
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static Vino parseoVino(String linea) {
		String[] trozos=linea.split(",");
		Checkers.check("la cadena linea debe tener 5 trozos "+linea,  trozos.length==5);
		
		String pais=trozos[0].trim();
		String region=trozos[1].trim();
		Integer puntos=Integer.valueOf(trozos[2].trim());
		Double precio=Double.valueOf(trozos[3].trim());
		String uva=trozos[4].trim();
		
		return new Vino(pais, region, puntos, precio, uva);
	}
	
	
	
	
	
	
	
}
