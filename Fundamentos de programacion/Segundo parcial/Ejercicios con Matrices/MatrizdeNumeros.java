import java.util.Scanner;

public class MatrizdeNumeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        boolean llena = false;
        int opcion;

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
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

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
                    System.out.println("\n--- Ingrese 16 valores no repetidos ---");
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            int valor;
                            boolean repetido;
                            do {
                                System.out.print("Posición [" + i + "][" + j + "]: ");
                                valor = scanner.nextInt();
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
                    for (int i = 0; i < 4; i++) {
                        int sumaFila = 0;
                        for (int j = 0; j < 4; j++) {
                            sumaFila += matriz[i][j];
                        }
                        System.out.println("Fila " + i + ": " + sumaFila);
                    }

                    System.out.println("--- Suma de Columnas ---");
                    for (int j = 0; j < 4; j++) {
                        int sumaCol = 0;
                        for (int i = 0; i < 4; i++) {
                            sumaCol += matriz[i][j];
                        }
                        System.out.println("Columna " + j + ": " + sumaCol);
                    }
                    break;

                case 3:
                    int fila;
                    do {
                        System.out.print("Ingrese el índice de la fila (0 a 3): ");
                        fila = scanner.nextInt();
                        if (fila < 0 || fila > 3) {
                            System.out.println("Fila inválida. Intente de nuevo.");
                        }
                    } while (fila < 0 || fila > 3);

                    int sumaFilaUser = 0;
                    for (int j = 0; j < 4; j++) {
                        sumaFilaUser += matriz[fila][j];
                    }
                    System.out.println("La suma de la fila " + fila + " es: " + sumaFilaUser);
                    break;

                case 4:
                    int col;
                    do {
                        System.out.print("Ingrese el índice de la columna (0 a 3): ");
                        col = scanner.nextInt();
                        if (col < 0 || col > 3) {
                            System.out.println("Columna inválida. Intente de nuevo.");
                        }
                    } while (col < 0 || col > 3);

                    int sumaColUser = 0;
                    for (int i = 0; i < 4; i++) {
                        sumaColUser += matriz[i][col];
                    }
                    System.out.println("La suma de la columna " + col + " es: " + sumaColUser);
                    break;

                case 5:
                    int mayor = matriz[0][0], menor = matriz[0][0];
                    int posMayorFila = 0, posMayorCol = 0;
                    int posMenorFila = 0, posMenorCol = 0;

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
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
                    System.out.println("El número mayor es " + mayor + " en la posición [" + posMayorFila + "][" + posMayorCol + "]");
                    System.out.println("El número menor es " + menor + " en la posición [" + posMenorFila + "][" + posMenorCol + "]");
                    break;

                case 6:
                    int pares = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (matriz[i][j] % 2 == 0) pares++;
                        }
                    }
                    System.out.println("Cantidad de números pares: " + pares);
                    break;

                case 7:
                    int impares = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (matriz[i][j] % 2 != 0) impares++;
                        }
                    }
                    System.out.println("Cantidad de números impares: " + impares);
                    break;

                case 8:
                    int[][] matrizCuadrados = new int[4][4];
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            matrizCuadrados[i][j] = matriz[i][j] * matriz[i][j];
                        }
                    }
                    System.out.println("--- Matriz de Cuadrados ---");
                    mostrarMatriz(matrizCuadrados);
                    break;

                case 9:
                    int sumaDiagPrincipal = 0;
                    for (int i = 0; i < 4; i++) {
                        sumaDiagPrincipal += matriz[i][i];
                    }
                    System.out.println("La suma de la diagonal principal es: " + sumaDiagPrincipal);
                    break;

                case 10:
                    int sumaDiagInversa = 0;
                    for (int i = 0; i < 4; i++) {
                        sumaDiagInversa += matriz[i][3 - i];
                    }
                    System.out.println("La suma de la diagonal inversa es: " + sumaDiagInversa);
                    break;

                case 11:
                    double sumaTotal = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            sumaTotal += matriz[i][j];
                        }
                    }
                    System.out.println("La media de los valores es: " + (sumaTotal / 16.0));
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

    // Comprueba si un valor ya existe en las posiciones procesadas hasta el momento
    public static boolean existeEnMatriz(int[][] matriz, int filaActual, int colActual, int valor) {
        for (int i = 0; i <= filaActual; i++) {
            int limiteCol = (i == filaActual) ? colActual : 4;
            for (int j = 0; j < limiteCol; j++) {
                if (matriz[i][j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void mostrarMatriz(int[][] m) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}