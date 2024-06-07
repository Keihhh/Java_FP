package fp.tipo.partido;

import java.time.LocalDate;

import fp.util.Checkers;

public class PartidoImpl implements Partido {

	private LocalDate fecha;
	private String equipoLocal;
	private String equipoVisit;
	
	public PartidoImpl(LocalDate fecha, String equipolocal, String equipovisit) {
		
		Checkers.check("Fecha erronea", fecha.compareTo(LocalDate.of(2018, 8, 15))>0 && fecha.compareTo(LocalDate.of(2019,5,120))<0);

		
		this.fecha = fecha;
		this.equipoLocal = equipolocal;
		this.equipoVisit= equipovisit;
	}
	
	
	
	public LocalDate getFecha() {
		return fecha;
	}

	
	public String getEquipoLocal() {
		return equipoLocal;
	}

	
	public String getEquipoVisit() {
		return equipoVisit;
	}


	public void setFecha(LocalDate nuevafecha) {
		Checkers.check("Fecha erronea", fecha.compareTo(LocalDate.of(2018, 8, 15))>0 && fecha.compareTo(LocalDate.of(2019,5,120))<0);
		fecha=nuevafecha;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipoLocal == null) ? 0 : equipoLocal.hashCode());
		result = prime * result + ((equipoVisit == null) ? 0 : equipoVisit.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		PartidoImpl other = (PartidoImpl) obj;
		if (equipoLocal == null) {
			if (other.equipoLocal != null)
				return false;
		} else if (!equipoLocal.equals(other.equipoLocal))
			return false;
		if (equipoVisit == null) {
			if (other.equipoVisit != null)
				return false;
		} else if (!equipoVisit.equals(other.equipoVisit))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PartidoImpl [fecha=" + fecha + ", equipoLocal=" + equipoLocal + ", equipoVisit=" + equipoVisit + "]";
	}

	
	public int compareTo(Partido p) {
		int res=0;
        res=this.getFecha().compareTo(p.getFecha());
            if(res==0) {
                res = this.getEquipoLocal().compareTo(p.getEquipoLocal());
            }
        return res;
    }
}
