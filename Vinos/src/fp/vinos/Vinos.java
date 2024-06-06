package fp.vinos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class Vinos {
	
	private Set<Vino> vinos;

	public Vinos() {
		vinos=new HashSet<>();			
	}
	
	public Vinos(List<Vino> lista_vinos) {
		vinos=new HashSet<>(lista_vinos);
		
	}
	
	public Vinos(String nomfich){
		try {
			List<Vino> lista_vinos = Files.lines(Paths.get(nomfich),StandardCharsets.UTF_8).
				    map(x-> new Vino(x)).
				    collect(Collectors.toList());
			vinos=new HashSet<>(lista_vinos);
		} catch (IOException e) {
			System.out.println("Fichero no encontrado " + nomfich);
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vinos == null) ? 0 : vinos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinos other = (Vinos) obj;
		if (vinos == null) {
			if (other.vinos != null)
				return false;
		} else if (!vinos.equals(other.vinos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vinos [vinos=" + vinos + "]";
	}
	
	public void añadirVino(Vino v) {
        vinos.add(v);
    }
	
	public Integer calcularNumeroVinosPais(String pais) {
		Integer cont=0;
		for (Vino v:vinos) {
			if(v.getPais().equals(pais)) {
				cont ++;
				
			}
		}
		return cont;
	}
	
	
	public Vino obtenerVinoMejorPuntuado() {
		return Collections.max(vinos, Comparator.comparing(Vino::getPuntos));
	}
	
	
	
	public Set<String> calcularUvasPorRegion(String region) {
		Set<String> conjUvas=new HashSet<>();
		for(Vino v: vinos) {
			if(v.getRegion().equals(region)) {
				conjUvas.add(v.getUva());
			}
		}
		return conjUvas;
	}
	
	
	public Set<Vino> obtenerVinosRangoPuntos(Integer val_minimo, Integer val_maximo) {
		Checkers.check("valor minimo debe ser menor que valor maximo ", val_minimo<=val_maximo);
		Set<Vino> conjVinos=new HashSet<>();
		for(Vino v:vinos) {
			if(v.getPuntos()>=val_minimo && v.getPuntos()<=val_maximo) {
//				if(v.getPuntos().compareTo(val_minimo)>=0 && v.getPuntos().compareTo(val_maximo<=0)
				conjVinos.add(v);
			}
		}
		return conjVinos;
	
	}
	
	//USO DE MAP
	//Método que devuelva un diccionario con una lista de vinos de cada país
	public Map<String, List<Vino>> getListaVinosXPais(){
        return vinos.stream().collect(Collectors.groupingBy(Vino::getPais));
    }
	
	//Método que devuelve un dicc con claves(países) y valores(conj de uvas de cada país)
	public Map<String, Set<String>> getDiccPaisConjUvasPais(){
		Map<String, Set<String>> res= new HashMap<>();
		for(Vino v:vinos) {
			String clave=v.getPais();
			if(res.containsKey(clave)) {
				res.get(clave).add(v.getUva());
			}
			else {
				Set<String> valor=new HashSet<>();
				valor.add(v.getUva());
				res.put(clave, valor);
			}
		}
		return res;
	}
	
	
	public Long calcularNumeroVinosPais2(String pais){
        return vinos.stream().filter(x->x.getPais().equals(pais)).count();
    }
	
	
	public Vino obtenerVinoMejorPuntuado2() {
        return vinos.stream().max(Comparator.comparing(x->x.getCalidadPrecio())).get();
        //También vale Vino::XXX Sin paréntesis
    }
	
	
	public List<Vino> obtenerVinosRangoPuntos2(Integer rango1, Integer rango2) {
        Predicate<Vino> entrerangos = x->x.getPuntos().compareTo(rango1)>=0 && 
                x.getPuntos().compareTo(rango2)<=0;
        return vinos.stream().filter(entrerangos).collect(Collectors.toList());
    }
	
	
	
}
