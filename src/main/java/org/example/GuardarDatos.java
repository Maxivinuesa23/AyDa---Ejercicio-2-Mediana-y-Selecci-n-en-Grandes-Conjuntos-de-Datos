package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GuardarDatos {
    public ArrayList<Integer> guardarDatos() throws IOException{
        FileReader myReader = new FileReader("numerosDesordenados.txt");
        BufferedReader br = new BufferedReader(myReader);

        ArrayList <Integer> numeros = new ArrayList<>();
        String linea;

        while ((linea = br.readLine()) != null) {
            int valorDado = Integer.parseInt(linea);
            numeros.add(valorDado);
        }
        return numeros;
    }
}
