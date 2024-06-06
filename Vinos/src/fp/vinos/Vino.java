package fp.vinos;

import fp.utiles.Checkers;

public class Vino {

	
	private String pais;
	private String region;
	private Integer puntos;
	private Double precio;
	private String uva;
	
	public Vino(String pais, String region, Integer puntos, Double precio, String uva) {
		
		Checkers.check("puntos debe estar entre 0 y 100", puntos>=0 && puntos<=100);
		Checkers.check("precio debe ser mayor de 0", precio>0);
		
//		if (puntos <0 || puntos >100 || precio <=0) {							//Igual que Checkers (que pertenece a java.util), si no 
//			throw new IllegalArgumentException ("Error en los parámetros");	   // nos dan Checkers usamos el if con IllegalArgumentException
//		}
		
		this.pais = pais;
		this.region = region;
		this.puntos = puntos;
		this.precio = precio;
		this.uva = uva;
	}

	
	public Vino(String linea) {
		String[] trozos=linea.split(",");
		Checkers.check("la cadena linea debe tener 5 trozos "+linea,  trozos.length==5);
		
		pais=trozos[0].trim();
		
		region=trozos[1].trim();
		
		Integer puntos=Integer.valueOf(trozos[2].trim());
		Checkers.check("puntos debe estar entre 0 y 100", puntos>=0 && puntos<=100);
		puntos=puntos;
		
		Double precio=Double.valueOf(trozos[3].trim());
		Checkers.check("precio debe ser mayor de 0", precio>0);
		precio=precio;
		
		uva=trozos[4].trim();
	}
	
	
	
	
	public String getPais() {
		return pais;
	}

	public String getRegion() {
		return region;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getUva() {
		return uva;
	}
	
	
	
	//Propiedad Derivada
	public Double getCalidadPrecio() {
		return puntos/precio;
	}

	
	
	
	@Override
	public String toString() {
		return "Vino [pais=" + pais + ", region=" + region + ", puntos=" + puntos + ", precio=" + precio + ", uva="
				+ uva + "]";
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((puntos == null) ? 0 : puntos.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((uva == null) ? 0 : uva.hashCode());
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
		Vino other = (Vino) obj;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (uva == null) {
			if (other.uva != null)
				return false;
		} else if (!uva.equals(other.uva))
			return false;
		return true;
	}
	
	
	

}

