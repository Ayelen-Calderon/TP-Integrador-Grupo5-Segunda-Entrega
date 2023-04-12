package org.example;

import lombok.Data;

@Data
public class Apostador {
    private String nombre;
    private ResultadoPartido apuesta;
    private int puntosParciales=0;
    private int puntosTotales=0;

}
