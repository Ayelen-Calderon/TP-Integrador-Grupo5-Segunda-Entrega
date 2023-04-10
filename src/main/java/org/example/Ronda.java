package org.example;

import lombok.Data;

import java.util.List;

@Data
public class Ronda {

    //Atributos

    private int nroRonda;
    private List<Partido>partidos;

    //Metodos

    public int puntosTotales(Pronostico pron){
        pron.calcularPuntos();
        return pron.getPuntos();
    }
}
