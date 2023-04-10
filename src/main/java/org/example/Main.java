package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String archivoPronostico;
        String archivoResultado;
        String equipoL="";
        String equipoV="";
        int golL=0;
        int golV=0;

        Pronostico prono;
        int []apuesta=new int[8];
        Ronda ronda=new Ronda();
        List<Partido> partido= new ArrayList<>();

        int puntosTotales=0;

        List<String> allLines = Files.readAllLines(Paths.get(args[0]));
        for (int j = 1; j < allLines.size(); j++) {
            archivoResultado = allLines.get(j);
            String[] elementosRes=archivoResultado.split(",");
            for (String elemento : elementosRes) {
                ronda.setNroRonda(Character.getNumericValue(elemento.charAt(0)));
                equipoL=(elementosRes[1]);
                equipoV =(elementosRes[4]);
                golL=Integer.parseInt(elementosRes[2]);
                golV=Integer.parseInt(elementosRes[3]);
            }

            Partido part=new Partido(equipoL,equipoV,golL,golV);
            partido.add(j-1,part);
        }


        ronda.setPartidos(partido);

        List<String> readAllLines = Files.readAllLines(Paths.get(args[1]));
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

        for (int i=0;i<partido.size();i++){
            for (int j = 0; j < apuesta.length; j++) {
                prono = new  Pronostico(partido.get(i),apuesta[j]);
                puntosTotales = ronda.puntosTotales(prono);
            }
        }
       // System.out.println(partido.get(1));
        System.out.println(puntosTotales);
    }
}