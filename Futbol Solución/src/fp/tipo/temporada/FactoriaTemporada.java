package fp.tipo.temporada;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import fp.tipo.partido.PartidoResultado;
import fp.tipo.partido.PartidoResultadoImpl;
import fp.util.Checkers;

public class FactoriaTemporada {
	public static Temporada leeTemporada(String nomfich) {
        Temporada res = null;
        String [] trozo = nomfich.split("\\.");
        String nombre  = trozo[0];
        try {
            List<PartidoResultado> l_partidos = Files.lines(Paths.get(nomfich),StandardCharsets.UTF_8).
                    skip(1).
                    map(FactoriaTemporada::parseoPartido).
                    collect(Collectors.toList());
            res = new TemporadaImpl(nombre, l_partidos);
        } catch (IOException e) {
            System.out.println("Fichero no encontrado " + nomfich);
            e.printStackTrace();
        }
        return res;
    }

    public static PartidoResultado parseoPartido(String linea) {
        String[] trozos = linea.split(";");
        Checkers.check("La cadena linea debe tener 7 trozos: " + linea, trozos.length==7);
        String[] trozosfecha = trozos[0].trim().split(";");
        LocalDate fecha = LocalDate.of(Integer.valueOf(trozosfecha[2].trim()), Integer.valueOf(trozosfecha[1].trim()),Integer.valueOf(trozosfecha[0].trim()));
        String equipLocal = trozos[1].trim();
        String equipVisit = trozos[2].trim();
        Integer localFin = Integer.valueOf(trozos[3].trim());
        Integer visitFin = Integer.valueOf(trozos[4].trim());
        Integer localDesc = Integer.valueOf(trozos[5].trim());
        Integer visitDesc = Integer.valueOf(trozos[6].trim());

        return new PartidoResultadoImpl(fecha,equipLocal,equipVisit,localFin,visitFin,localDesc,visitDesc);

    }
}
