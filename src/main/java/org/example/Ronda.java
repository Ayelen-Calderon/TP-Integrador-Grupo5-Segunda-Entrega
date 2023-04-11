package org.example;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Data
public class Ronda{

    //Atributos

    private int nroRonda;
    private Partido partido;
    private List<Partido>partidos;
    private String rutaArchivoResultado;
    private String archivoResultado;

    //Constructor

    public Ronda(String rutaArchivoResultado) throws ArchivoException {
        this.rutaArchivoResultado = rutaArchivoResultado;
    }


    //Metodos
    public void rondaJugada() throws ArchivoException, IOException{
        if(rutaArchivoResultado.equals("")){
            throw new ArchivoException();
        }else {
            List<String> allLines = Files.readAllLines(Paths.get(rutaArchivoResultado));
            for (int j = 1; j < allLines.size(); j++) {
                archivoResultado = allLines.get(j);
                String[] elementosRes=archivoResultado.split(",");
                for (String elemento : elementosRes) {
                    nroRonda=(Character.getNumericValue(elemento.charAt(0)));
                    partido.setEquipoLocal(elementosRes[1]);
                    partido.setEquipoVisitante(elementosRes[4]);
                    partido.setGolesEL(Integer.parseInt(elementosRes[2]));
                    partido.setGolesEV(Integer.parseInt(elementosRes[3]));
                }
                partidos.add(j-1,partido);
            }
        }
    }

  /*  public int puntosTotales(Pronostico pron){
        pron.calcularPuntos();
        return pron.getPuntos();
    }*/
}
