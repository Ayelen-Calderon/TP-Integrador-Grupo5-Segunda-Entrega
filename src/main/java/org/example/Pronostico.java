package org.example;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


@Data
public class Pronostico {

    //Atributos

    private Partido partidoApostado;
    private int puntos=0;
    private String rutaARchivoPronostico;
    private String archivoPronostico;
    private String[] nombre;
    private Apostador persona=new Apostador();
    private Resultado res=new Resultado();

    //Constructor
    public Pronostico(String rutaARchivoPronostico) throws ArchivoException {
        this.rutaARchivoPronostico=rutaARchivoPronostico;
    }

    //Metodos
    public void leerPronosticos()throws IOException {
        List<String> readAllLines = Files.readAllLines(Paths.get(rutaARchivoPronostico));
            for (int i = 1; i < readAllLines.size(); i++) {
                archivoPronostico = readAllLines.get(i);
                nombre=archivoPronostico.split(",");
                persona.setNombre(nombre[0]);
                int X=archivoPronostico.indexOf("X");
                if(archivoPronostico.charAt(X-3)==','){
                    persona.setApuesta(ResultadoPartido.GanaV);
                    if(archivoPronostico.charAt(X-2)==','){
                        persona.setApuesta(ResultadoPartido.Empate);
                    }else {
                        persona.setApuesta(ResultadoPartido.GanaL);
                    }
                }
                //Falta guardar las personas
            }
    }
}


/*
Mariana,Argentina,X,,,Arabia Saudita
Mariana,Polonia,,X,,Mexico
Mariana,Argentina,X,,,Mexico
Mariana,Arabia Saudita,,,X,Polonia
Pedro,Argentina,X,,,Arabia Saudita
Pedro,Polonia,,,X,Mexico
Pedro,Argentina,X,,,Mexico
Pedro,Arabia Saudita,,X,,Polonia*/
