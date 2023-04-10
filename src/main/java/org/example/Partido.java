package org.example;

import lombok.Data;

@Data
public class Partido {

    //Atributos

    private String equipoLocal;
    private String equipoVisitante;
    private int golesEL;
    private int golesEV;
    private int resultado;

    //Constructor

    public Partido(String equipoLocal, String equipoVisitante, int golesEL, int golesEV) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEL = golesEL;
        this.golesEV = golesEV;
        Resultado res=new Resultado();
        res.calcularResultado(golesEL,golesEV);
        this.resultado = res.getRdo();
    }
}
