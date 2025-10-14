package org.example;

import java.util.ArrayList;

public class QuickLomuto {
    // Método de partición de Lomuto
    private static int lomutoPartition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high); // Elige el último elemento como pivote
        int i = (low - 1); // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr.get(j) <= pivot) {
                i++;
                // Intercambia arr[i] y arr[j]
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Intercambia el pivote con el elemento en la posición i+1
        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1; // Retorna la posición del pivote
    }

    // Método principal de QuickSelect para encontrar el k-ésimo elemento
    public static int quickSelect(ArrayList<Integer> arr, int low, int high, int k) {
        // Llama a la partición y obtiene la posición del pivote
        int pivotIndex = lomutoPartition(arr, low, high);

        // Si la posición del pivote es la que buscamos
        if (pivotIndex == k) {
            return arr.get(pivotIndex);
        }

        // Si el elemento buscado está en la sub-lista izquierda
        if (k < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else { // Si está en la sub-lista derecha
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }
}
