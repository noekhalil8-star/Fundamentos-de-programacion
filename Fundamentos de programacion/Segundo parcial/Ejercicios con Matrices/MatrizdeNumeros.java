import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrizdeNumeros {

    // Constante para el tamaño de la matriz
    private static final int TAM = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[TAM][TAM];
        boolean llena = false;
        int opcion = 0;

        do {
            System.out.println("\n================ MENÚ DE OPCIONES ================");
            System.out.println("1. Rellenar TODA la matriz (sin números repetidos)");
            System.out.println("2. Suma de cada una de las filas y columnas");
            System.out.println("3. Suma de una fila específica");
            System.out.println("4. Suma de una columna específica");
            System.out.println("5. Indicar número mayor y menor con sus posiciones");
            System.out.println("6. Contar números pares");
            System.out.println("7. Contar números impares");
            System.out.println("8. Generar matriz con el cuadrado de cada valor");
            System.out.println("9. Sumar diagonal principal");
            System.out.println("10. Sumar diagonal inversa");
            System.out.println("11. Media de todos los valores de la matriz");
            System.out.println("12. Salir");

            opcion = leerEntero(scanner, "Elija una opción: ");

            if (opcion >= 2 && opcion <= 11 && !llena) {
                System.out.println("\n[ERROR] Debe rellenar la matriz primero eligiendo la opción 1.");
                continue;
            }

            if (llena && opcion >= 2 && opcion <= 11) {
                System.out.println("\n--- Matriz Actual ---");
                mostrarMatriz(matriz);
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Ingrese " + (TAM * TAM) + " valores no repetidos ---");
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            int valor;
                            boolean repetido;
                            do {
                                valor = leerEntero(scanner, "Posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                                repetido = existeEnMatriz(matriz, i, j, valor);
                                if (repetido) {
                                    System.out.println("¡El número ya existe en la matriz! Ingrese otro.");
                                }
                            } while (repetido);
                            matriz[i][j] = valor;
                        }
                    }
                    llena = true;
                    System.out.println("¡Matriz rellenada con éxito!");
                    break;

                case 2:
                    System.out.println("\n--- Suma de Filas ---");
                    for (int i = 0; i < matriz.length; i++) {
                        int sumaFila = 0;
                        for (int j = 0; j < matriz[i].length; j++) {
                            sumaFila += matriz[i][j];
                        }
                        System.out.println("Fila " + (i + 1) + ": " + sumaFila);
                    }

                    System.out.println("--- Suma de Columnas ---");
                    for (int j = 0; j < matriz[0].length; j++) {
                        int sumaCol = 0;
                        for (int i = 0; i < matriz.length; i++) {
                            sumaCol += matriz[i][j];
                        }
                        System.out.println("Columna " + (j + 1) + ": " + sumaCol);
                    }
                    break;

                case 3:
                    int filaUser;
                    do {
                        filaUser = leerEntero(scanner, "Ingrese el número de la fila (1 a " + TAM + "): ");
                        if (filaUser < 1 || filaUser > TAM) {
                            System.out.println("Fila inválida. Intente de nuevo.");
                        }
                    } while (filaUser < 1 || filaUser > TAM);

                    int fila = filaUser - 1; // Conversión a índice basado en 0
                    int sumaFilaUser = 0;
                    for (int j = 0; j < matriz[fila].length; j++) {
                        sumaFilaUser += matriz[fila][j];
                    }
                    System.out.println("La suma de la fila " + filaUser + " es: " + sumaFilaUser);
                    break;

                case 4:
                    int colUser;
                    do {
                        colUser = leerEntero(scanner, "Ingrese el número de la columna (1 a " + TAM + "): ");
                        if (colUser < 1 || colUser > TAM) {
                            System.out.println("Columna inválida. Intente de nuevo.");
                        }
                    } while (colUser < 1 || colUser > TAM);

                    int col = colUser - 1; // Conversión a índice basado en 0
                    int sumaColUser = 0;
                    for (int i = 0; i < matriz.length; i++) {
                        sumaColUser += matriz[i][col];
                    }
                    System.out.println("La suma de la columna " + colUser + " es: " + sumaColUser);
                    break;

                case 5:
                    int mayor = matriz[0][0], menor = matriz[0][0];
                    int posMayorFila = 0, posMayorCol = 0;
                    int posMenorFila = 0, posMenorCol = 0;

                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            if (matriz[i][j] > mayor) {
                                mayor = matriz[i][j];
                                posMayorFila = i;
                                posMayorCol = j;
                            }
                            if (matriz[i][j] < menor) {
                                menor = matriz[i][j];
                                posMenorFila = i;
                                posMenorCol = j;
                            }
                        }
                    }
                    System.out.println("El número mayor es " + mayor + " en la posición [" + (posMayorFila + 1) + "][" + (posMayorCol + 1) + "]");
                    System.out.println("El número menor es " + menor + " en la posición [" + (posMenorFila + 1) + "][" + (posMenorCol + 1) + "]");
                    break;

                case 6:
                    int pares = 0;
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            if (matriz[i][j] % 2 == 0) pares++;
                        }
                    }
                    System.out.println("Cantidad de números pares: " + pares);
                    break;

                case 7:
                    int impares = 0;
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            if (matriz[i][j] % 2 != 0) impares++;
                        }
                    }
                    System.out.println("Cantidad de números impares: " + impares);
                    break;

                case 8:
                    int[][] matrizCuadrados = new int[matriz.length][matriz[0].length];
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            matrizCuadrados[i][j] = matriz[i][j] * matriz[i][j];
                        }
                    }
                    System.out.println("--- Matriz de Cuadrados ---");
                    mostrarMatriz(matrizCuadrados);
                    break;

                case 9:
                    int sumaDiagPrincipal = 0;
                    for (int i = 0; i < matriz.length; i++) {
                        sumaDiagPrincipal += matriz[i][i];
                    }
                    System.out.println("La suma de la diagonal principal es: " + sumaDiagPrincipal);
                    break;

                case 10:
                    int sumaDiagInversa = 0;
                    for (int i = 0; i < matriz.length; i++) {
                        sumaDiagInversa += matriz[i][matriz.length - 1 - i];
                    }
                    System.out.println("La suma de la diagonal inversa es: " + sumaDiagInversa);
                    break;

                case 11:
                    double sumaTotal = 0;
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            sumaTotal += matriz[i][j];
                        }
                    }
                    double media = sumaTotal / (matriz.length * matriz[0].length);
                    System.out.printf("La media de los valores es: %.2f%n", media);
                    break;

                case 12:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 12);

        scanner.close();
    }

    // Método auxiliar para leer números enteros controlando excepciones si el usuario escribe texto
    public static int leerEntero(Scanner scanner, String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Debe ingresar un número entero válido.");
                scanner.next(); // Limpiar el buffer de la entrada no numérica
            }
        }
        return valor;
    }

    // Comprueba si un valor ya existe en las posiciones procesadas hasta el momento
    public static boolean existeEnMatriz(int[][] matriz, int filaActual, int colActual, int valor) {
        for (int i = 0; i <= filaActual; i++) {
            int limiteCol = (i == filaActual) ? colActual : matriz[i].length;
            for (int j = 0; j < limiteCol; j++) {
                if (matriz[i][j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void mostrarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}