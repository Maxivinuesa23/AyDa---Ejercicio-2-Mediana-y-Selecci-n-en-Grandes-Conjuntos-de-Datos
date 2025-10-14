package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class CrearArchivoRandom {
    int max = 10000000;

    public void crearArchivo() throws IOException {
        FileWriter myWriter = new FileWriter("numerosDesordenados.txt");

        for(int i=0; i < max ; i++){
            int valorDado = (int)Math.floor(Math.random()*max+1);
            myWriter.write(valorDado + "\n");
        }
        myWriter.close();
    }

}
