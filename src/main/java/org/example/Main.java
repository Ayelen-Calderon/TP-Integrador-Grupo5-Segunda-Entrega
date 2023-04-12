package org.example;

public class Main {

    public static void main(String[] args){

        String rutaArchivoResultado = args[0];
        Ronda ronda;
        String rutaARchivoPronostico = args[1];
        Pronostico prono;

        try {
            ronda = new Ronda(rutaArchivoResultado);
        }catch (ArchivoException e){}
        catch (Exception f){};

        try {
            prono=new Pronostico(rutaARchivoPronostico);
        }catch (ArchivoException e){}
        catch (Exception f){};



        int puntosTotales=0;

      /*  for (int i=0;i<partido.size();i++){
            for (int j = 0; j < apuesta.length; j++) {
                prono = new  Pronostico(partido.get(i),apuesta[j]);
                puntosTotales = ronda.puntosTotales(prono);
            }
        }*/
       // System.out.println(partido.get(1));
        System.out.println(puntosTotales);
    }
}