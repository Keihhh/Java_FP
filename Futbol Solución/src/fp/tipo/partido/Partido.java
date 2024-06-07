package fp.tipo.partido;

import java.time.LocalDate;

public interface Partido extends Comparable<Partido> {
	LocalDate getFecha();
	String getEquipoLocal();
	String getEquipoVisit();
	void setFecha (LocalDate nuevafecha);
	
	
	
}
