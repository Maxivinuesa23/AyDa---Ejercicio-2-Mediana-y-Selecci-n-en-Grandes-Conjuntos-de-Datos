package org.example;

import java.util.ArrayList;

public class QuickHoare {

    // Método de partición de Hoare
    private static int hoarePartition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr.get(i) < pivot);

            do {
                j--;
            } while (arr.get(j) > pivot);

            if (i >= j) {
                return j;
            }
            // Intercambiar elementos
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
    }

    // Método principal de QuickSelect para encontrar el k-ésimo elemento
    public static int quickSelect(ArrayList<Integer> arr, int low, int high, int k) {
        if (low == high) {
            return arr.get(low);
        }

        int pivotIndex = hoarePartition(arr, low, high);

        // La partición de Hoare puede no colocar el pivote en su posición final
        // Esto requiere una lógica de ajuste para determinar en qué lado buscar
        if (k <= pivotIndex) {
            return quickSelect(arr, low, pivotIndex, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }
}
