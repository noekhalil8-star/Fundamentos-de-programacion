import java.util.Arrays;
import java.util.Scanner;

public class DepuracionTransacciones {

    // Lee un entero; repite la pregunta si la entrada no es válida
    static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine(); // limpiar el salto de línea pendiente
                return valor;
            }
            System.out.println("  Entrada inválida. Escribe un número entero.");
            sc.nextLine(); // descartar lo que escribió
        }
    }

    // Lee un entero mayor a 0
    static int leerCantidad(Scanner sc, String mensaje) {
        while (true) {
            int valor = leerEntero(sc, mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("  El número debe ser mayor que 0.");
        }
    }

    // Pregunta s/n y repite hasta recibir una respuesta válida
    static boolean leerSiNo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) {
                return true;
            }
            if (respuesta.equals("n") || respuesta.equals("no")) {
                return false;
            }
            System.out.println("  Responde con 's' para sí o 'n' para no.");
        }
    }

    // Indica si el valor ya está en el arreglo
    static boolean contiene(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Captura de datos
        int cantidad = leerCantidad(sc, "¿Cuántos identificadores deseas ingresar? ");

        int[] original = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            original[i] = leerEntero(sc, "Identificador " + (i + 1) + ": ");
        }

        System.out.println("\nArreglo original: " + Arrays.toString(original));

        // 1. Copia ordenada para analizar frecuencias
        int[] copiaOrdenada = Arrays.copyOf(original, original.length);
        Arrays.sort(copiaOrdenada);

        // Identificadores que aparecen más de una vez
        int[] posiblesDuplicados = new int[copiaOrdenada.length];
        int numDuplicadosUnicos = 0;

        for (int i = 0; i < copiaOrdenada.length - 1; i++) {
            if (copiaOrdenada[i] == copiaOrdenada[i + 1]) {
                boolean yaRegistrado = false;
                for (int k = 0; k < numDuplicadosUnicos; k++) {
                    if (posiblesDuplicados[k] == copiaOrdenada[i]) {
                        yaRegistrado = true;
                        break;
                    }
                }
                if (!yaRegistrado) {
                    posiblesDuplicados[numDuplicadosUnicos++] = copiaOrdenada[i];
                }
            }
        }

        int[] identificadoresDuplicados = Arrays.copyOf(posiblesDuplicados, numDuplicadosUnicos);

        // 2. Arreglo sin duplicados, conservando el orden de primera aparición
        int[] tempUnicos = new int[original.length];
        int contadorUnicos = 0;
        int registrosEliminados = 0;

        for (int i = 0; i < original.length; i++) {
            boolean esDuplicadoPrevio = false;
            for (int j = 0; j < contadorUnicos; j++) {
                if (original[i] == tempUnicos[j]) {
                    esDuplicadoPrevio = true;
                    break;
                }
            }
            if (!esDuplicadoPrevio) {
                tempUnicos[contadorUnicos++] = original[i];
            } else {
                registrosEliminados++;
            }
        }

        // 3. Ajustar el tamaño del arreglo depurado
        int[] arregloDepurado = Arrays.copyOf(tempUnicos, contadorUnicos);

        // 4. Duplicados en el orden de primera aparición
        int[] duplicadosEnOrden = new int[identificadoresDuplicados.length];
        int n = 0;
        for (int i = 0; i < arregloDepurado.length; i++) {
            for (int k = 0; k < identificadoresDuplicados.length; k++) {
                if (arregloDepurado[i] == identificadoresDuplicados[k]) {
                    duplicadosEnOrden[n++] = arregloDepurado[i];
                    break;
                }
            }
        }

        // Resultados de la depuración inicial
        System.out.println("Arreglo depurado: " + Arrays.toString(arregloDepurado));

        StringBuilder sbDuplicados = new StringBuilder();
        for (int i = 0; i < duplicadosEnOrden.length; i++) {
            sbDuplicados.append(duplicadosEnOrden[i]);
            if (i < duplicadosEnOrden.length - 1) {
                sbDuplicados.append(", ");
            }
        }
        if (duplicadosEnOrden.length == 0) {
            sbDuplicados.append("ninguno");
        }
        System.out.println("Identificadores duplicados: " + sbDuplicados);
        System.out.println("Registros eliminados: " + registrosEliminados);

        // 5. Agregar más identificadores al arreglo depurado
        int[] rechazados = new int[0]; // intentos duplicados que no se aceptaron
        boolean agregoAlgo = false;

        while (leerSiNo(sc, "\n¿Deseas agregar más identificadores a los ya existentes? (s/n): ")) {
            int id = leerEntero(sc, "Nuevo identificador: ");

            if (contiene(arregloDepurado, id)) {
                System.out.println("  El identificador " + id + " ya existe. No se ingresó.");
                rechazados = Arrays.copyOf(rechazados, rechazados.length + 1);
                rechazados[rechazados.length - 1] = id;
            } else {
                arregloDepurado = Arrays.copyOf(arregloDepurado, arregloDepurado.length + 1);
                arregloDepurado[arregloDepurado.length - 1] = id;
                Arrays.sort(arregloDepurado); // queda en orden ascendente
                agregoAlgo = true;
                System.out.println("  Ingresado. Arreglo actual: " + Arrays.toString(arregloDepurado));
            }
        }

        // Resumen final (solo si hubo intentos de agregar)
        if (agregoAlgo || rechazados.length > 0) {
            System.out.println("\n=== RESULTADO FINAL ===");
            System.out.println("Arreglo final: " + Arrays.toString(arregloDepurado));
            System.out.println("Intentos duplicados rechazados al agregar: " + Arrays.toString(rechazados));
            System.out.println("Total de registros eliminados: " + (registrosEliminados + rechazados.length));
        }

        sc.close();
    }
}