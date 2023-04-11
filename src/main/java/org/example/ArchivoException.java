package org.example;

public class ArchivoException extends Exception {
    public ArchivoException(){
        System.out.println("No se pudo leer el archivo de manera correcta. ");
    }
}
