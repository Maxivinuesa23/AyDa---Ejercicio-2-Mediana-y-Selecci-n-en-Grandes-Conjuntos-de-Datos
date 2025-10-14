package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Scanner scc = new Scanner(System.in);
        int opc = 0;
        long inicio= 0;
        long memoriaAntes = 0;
        long memoriaDespues = 0;
        long fin = 0;
        long memoriaUsada = 0;
        long duracion = 0;


        CrearArchivoRandom crearRandom = new CrearArchivoRandom();
        CrearArchivoRandom1000 crearRandom1000 = new CrearArchivoRandom1000();

        GuardarDatos guardarDatos = new GuardarDatos();
        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();
        QuickLomuto lomuto = new QuickLomuto();
        QuickHoare hoare = new QuickHoare();

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> copiaNumeros = new ArrayList<>();

        int N = 0;
        int k = 0;


        do{
            System.out.println("*************************");
            System.out.println("*  BUSQUEDA DE LA MEDIANA  *");
            System.out.println("* 1. Re/Generar Archivo 10millones *");
            System.out.println("* 2. Re/Generar Archivo 1000 (TESTING)*");
            System.out.println("* 3. MergeSort   *");
            System.out.println("* 4. Lomuto  *");
            System.out.println("* 5. Hoare  *");
            System.out.println("* 6. Secuencial Con BubbleSort *");
            System.out.println("*************************");
            System.out.println("* 0. Salir*");
            opc = scc.nextInt();

            switch(opc){
                case 1:
                    try {
                        crearRandom.crearArchivo();
                        System.out.println("Archivo Creado");
                        numeros = guardarDatos.guardarDatos();

                        N = 10_000_000;
                        k = (N / 2); // Toma el elemento del medio

                        System.out.println("\nPresiona Enter para salir...");
                        System.in.read(); // Espera una tecla antes de terminar el programa
                    } catch (Exception e) {
                        System.out.println("Error al crear el archivo");
                    }
                    break;

                case 2:
                    try {
                        crearRandom1000.crearArchivo1000();
                        System.out.println("Archivo Creado");
                        numeros = guardarDatos.guardarDatos();

                        N = 1000;
                        k = (N / 2); // Toma el elemento del medio

                        System.out.println("\nPresiona Enter para salir...");
                        System.in.read(); // Espera una tecla antes de terminar el programa
                    } catch (Exception e) {
                        System.out.println("Error al crear el archivo");
                    }
                    break;

                case 3:
                    inicio = System.nanoTime();
                    memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

                    copiaNumeros = mergeSort.sort(numeros, 0, numeros.size() -1);
                    copiaNumeros.get(k);
                    System.out.println("La mediana es: " + copiaNumeros.get(k));


                    memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
                    fin = System.nanoTime();
                    memoriaUsada = memoriaDespues - memoriaAntes;
                    duracion = fin - inicio;
                    System.out.println("Tiempo de ejecución para encontrar el camino: " + duracion / 1_000_000 + " ms");
                    System.out.println("Memoria usada aproximada: " + (memoriaUsada / (1024.0 * 1024.0)) + " MB");

                    System.out.println("\nPresiona Enter para salir...");
                    System.in.read(); // Espera una tecla antes de terminar el programa
                    break;

                case 4:
                    inicio = System.nanoTime();
                    memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

                    int mediana = lomuto.quickSelect(numeros, 0, numeros.size() - 1, k);
                    System.out.println("La mediana es: " + mediana);

                    System.out.println("La mediana (el " + (k + 1) + "º elemento) es: " + mediana);

                    memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
                    fin = System.nanoTime();
                    memoriaUsada = memoriaDespues - memoriaAntes;
                    duracion = fin - inicio;
                    System.out.println("Tiempo de ejecución para encontrar el camino: " + duracion / 1_000_000 + " ms");
                    System.out.println("Memoria usada aproximada: " + (memoriaUsada / (1024.0 * 1024.0)) + " MB");

                    System.out.println("\nPresiona Enter para salir...");
                    System.in.read(); // Espera una tecla antes de terminar el programa
                    break;

                case 5:
                    inicio = System.nanoTime();
                    memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

                    int k_act = k;
                    k_act = k - 1 ; // Ajuste para índice basado en 0

                    int medianaHoare = hoare.quickSelect(numeros, 0, numeros.size() - 1, k);

                    System.out.println("La mediana (el " + (k + 1) + "º elemento) es: " + medianaHoare);

                    memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
                    fin = System.nanoTime();
                    memoriaUsada = memoriaDespues - memoriaAntes;
                    duracion = fin - inicio;
                    System.out.println("Tiempo de ejecución para encontrar el camino: " + duracion / 1_000_000 + " ms");
                    System.out.println("Memoria usada aproximada: " + (memoriaUsada / (1024.0 * 1024.0)) + " MB");

                    System.out.println("\nPresiona Enter para salir...");
                    System.in.read(); // Espera una tecla antes de terminar el programa
                    break;

                case 6:
                    inicio = System.nanoTime();
                    memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

                    copiaNumeros = bubbleSort.bubbleSort(numeros);

                    copiaNumeros.get(k);
                    System.out.println("La mediana es: " + copiaNumeros.get(k));

                    memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
                    fin = System.nanoTime();
                    memoriaUsada = memoriaDespues - memoriaAntes;
                    duracion = fin - inicio;
                    System.out.println("Tiempo de ejecución para encontrar el camino: " + duracion / 1_000_000 + " ms");
                    System.out.println("Memoria usada aproximada: " + (memoriaUsada / (1024.0 * 1024.0)) + " MB");

                    System.out.println("\nPresiona Enter para salir...");
                    System.in.read(); // Espera una tecla antes de terminar el programa
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion No Valida.");
                    break;
            }

        }while (opc != 0);

    }
}