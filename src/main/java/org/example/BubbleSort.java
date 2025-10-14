package org.example;

import java.util.ArrayList;

public class BubbleSort {

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> numeros){
        for (int i=0; i<numeros.size() -1; i++){
            for(int j=0; j<numeros.size() -1 -i; j++){
                if(numeros.get(j) > numeros.get(j+1)){
                    int temp= numeros.get(j);
                    numeros.set(j, numeros.get(j+1));
                    numeros.set(j+1, temp);
                }
            }
        }
        return numeros;
    }
}
