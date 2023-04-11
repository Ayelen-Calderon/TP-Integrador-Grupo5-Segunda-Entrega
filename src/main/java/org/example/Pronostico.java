package org.example;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Data
public class Pronostico {

    //Atributos

    private Partido partidoApostado;
    private int puntos=0;
    private String rutaARchivoPronostico;
    private String archivoPronostico;
    private int[] apuesta = new int[8];

    //Constructor
    public Pronostico(String rutaARchivoPronostico) throws ArchivoException {
        this.rutaARchivoPronostico=rutaARchivoPronostico;
    }

    //Metodos
    public void leerPronosticos()throws IOException {
        List<String> readAllLines = Files.readAllLines(Paths.get(rutaARchivoPronostico));
            for (int i = 1; i < readAllLines.size(); i++) {
                archivoPronostico = readAllLines.get(i);
                int X=archivoPronostico.indexOf("X");
                if(archivoPronostico.charAt(X-3)==','){
                    apuesta[i-1]=3;
                }else {
                    if(archivoPronostico.charAt(X-2)==','){
                        apuesta[i-1]=2;
                    }else {
                        apuesta[i-1]=1;
                    }
                }
            }
        }
   /* public void calcularPuntos(){
        if(partidoApostado.getResultado()==apuesta){
            puntos++;
        }
    }*/
}
