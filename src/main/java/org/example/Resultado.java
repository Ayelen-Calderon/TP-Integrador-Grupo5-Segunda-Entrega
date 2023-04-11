package org.example;

import lombok.Data;

@Data
public class Resultado {

    //Atributos

    private int rdo;

    //Metodos

    public ResultadoPartido calcularResultado(int golesEL,int golesEV){
        if(golesEL==golesEV){
            return ResultadoPartido.Empate;
        }else{
            if (golesEL>golesEV){
                return ResultadoPartido.GanaL;
            }else{
                return ResultadoPartido.GanaV;
            }
        }
    }
}
