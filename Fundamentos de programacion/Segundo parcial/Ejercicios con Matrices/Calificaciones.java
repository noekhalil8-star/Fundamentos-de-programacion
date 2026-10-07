import java.util.InputMismatchException;
import java.util.Scanner;

public class Calificaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validaciones para N (estudiantes) y M (exámenes)
        int n;
        do {
            n = leerEntero(scanner, "Ingrese el número de estudiantes (N > 0): ");
            if (n <= 0) {
                System.out.println("Error: El número de estudiantes debe ser mayor a 0.");
            }
        } while (n <= 0);

        int m;
        do {
            m = leerEntero(scanner, "Ingrese el número de exámenes (M > 0): ");
            if (m <= 0) {
                System.out.println("Error: El número de exámenes debe ser mayor a 0.");
            }
        } while (m <= 0);

        // Matriz de calificaciones (N estudiantes x M exámenes)
        double[][] calificaciones = new double[n][m];

        System.out.println("%n--- Registro de Calificaciones ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Estudiante " + (i + 1) + ":");
            for (int j = 0; j < m; j++) {
                double nota;
                do {
                    nota = leerDouble(scanner, "  Examen " + (j + 1) + " (0.0 - 10.0): ");
                    if (nota < 0.0 || nota > 10.0) {
                        System.out.println("  Error: La calificación debe estar entre 0.0 y 10.0.");
                    }
                } while (nota < 0.0 || nota > 10.0);
                calificaciones[i][j] = nota;
            }
        }

        // 1. Promedio de cada estudiante
        double[] promediosEstudiantes = new double[n];
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < m; j++) {
                suma += calificaciones[i][j];
            }
            promediosEstudiantes[i] = suma / m;
        }

        System.out.printf("%n--- Promedio por Estudiante ---%n");
        for (int i = 0; i < n; i++) {
            System.out.printf("Estudiante %d: %.2f%n", (i + 1), promediosEstudiantes[i]);
        }

        // --- ESTUDIANTE(S) CON EL MEJOR PROMEDIO GENERAL ---
        double maxPromedioEstudiante = promediosEstudiantes[0];
        for (int i = 1; i < n; i++) {
            if (promediosEstudiantes[i] > maxPromedioEstudiante) {
                maxPromedioEstudiante = promediosEstudiantes[i];
            }
        }

        System.out.printf("%n--- MEJOR(ES) ESTUDIANTE(S) (Promedio Máximo: %.2f) ---%n", maxPromedioEstudiante);
        boolean primero = true;
        for (int i = 0; i < n; i++) {
            if (Math.abs(promediosEstudiantes[i] - maxPromedioEstudiante) < 0.0001) {
                if (!primero) System.out.print(", ");
                System.out.print("Estudiante " + (i + 1));
                primero = false;
            }
        }
        System.out.println();

        // 2. Nueva matriz con alumnos destacados (promedio entre 9 y 10)
        int contadorExcelentes = 0;
        for (int i = 0; i < n; i++) {
            if (promediosEstudiantes[i] >= 9.0 && promediosEstudiantes[i] <= 10.0) {
                contadorExcelentes++;
            }
        }

        double[][] matrizExcelentes = new double[contadorExcelentes][2]; // [0] = Id Estudiante, [1] = Promedio
        int indexExc = 0;
        for (int i = 0; i < n; i++) {
            if (promediosEstudiantes[i] >= 9.0 && promediosEstudiantes[i] <= 10.0) {
                matrizExcelentes[indexExc][0] = i + 1;
                matrizExcelentes[indexExc][1] = promediosEstudiantes[i];
                indexExc++;
            }
        }

        System.out.printf("%n--- LISTADO DE ESTUDIANTES DESTACADOS (Promedio 9.0 - 10.0) ---%n");
        if (contadorExcelentes == 0) {
            System.out.println("Ningún estudiante obtuvo un promedio entre 9 y 10.");
        } else {
            System.out.println("ID Estudiante\tPromedio");
            for (int i = 0; i < contadorExcelentes; i++) {
                System.out.printf("Estudiante %d\t%.2f%n", (int) matrizExcelentes[i][0], matrizExcelentes[i][1]);
            }
        }

        // 3. Nueva matriz con alumnos con promedio inferior a 7.0
        int contadorBajos = 0;
        for (int i = 0; i < n; i++) {
            if (promediosEstudiantes[i] < 7.0) {
                contadorBajos++;
            }
        }

        double[][] matrizBajos = new double[contadorBajos][2]; // [0] = Id Estudiante, [1] = Promedio
        int indexBaj = 0;
        for (int i = 0; i < n; i++) {
            if (promediosEstudiantes[i] < 7.0) {
                matrizBajos[indexBaj][0] = i + 1;
                matrizBajos[indexBaj][1] = promediosEstudiantes[i];
                indexBaj++;
            }
        }

        System.out.printf("%n--- LISTADO DE ESTUDIANTES CON PROMEDIO INFERIOR A 7.0 ---%n");
        if (contadorBajos == 0) {
            System.out.println("Ningún estudiante obtuvo promedio inferior a 7.0.");
        } else {
            System.out.println("ID Estudiante\tPromedio");
            for (int i = 0; i < contadorBajos; i++) {
                System.out.printf("Estudiante %d\t%.2f%n", (int) matrizBajos[i][0], matrizBajos[i][1]);
            }
        }

        // 4 y 5. Examen con mayor y menor promedio general
        double[] promedioExamenes = new double[m];
        for (int j = 0; j < m; j++) {
            double sumaExamen = 0;
            for (int i = 0; i < n; i++) {
                sumaExamen += calificaciones[i][j];
            }
            promedioExamenes[j] = sumaExamen / n;
        }

        double maxPromExamen = promedioExamenes[0];
        double minPromExamen = promedioExamenes[0];

        for (int j = 1; j < m; j++) {
            if (promedioExamenes[j] > maxPromExamen) {
                maxPromExamen = promedioExamenes[j];
            }
            if (promedioExamenes[j] < minPromExamen) {
                minPromExamen = promedioExamenes[j];
            }
        }

        System.out.printf("%n--- ANÁLISIS DE EXÁMENES ---%n");
        System.out.printf("• Examen(es) con el PROMEDIO MÁS ALTO (Promedio: %.2f): ", maxPromExamen);
        primero = true;
        for (int j = 0; j < m; j++) {
            if (Math.abs(promedioExamenes[j] - maxPromExamen) < 0.0001) {
                if (!primero) System.out.print(", ");
                System.out.print("Examen " + (j + 1));
                primero = false;
            }
        }
        System.out.println();

        System.out.printf("• Examen(es) con el PROMEDIO MÁS BAJO (Promedio: %.2f): ", minPromExamen);
        primero = true;
        for (int j = 0; j < m; j++) {
            if (Math.abs(promedioExamenes[j] - minPromExamen) < 0.0001) {
                if (!primero) System.out.print(", ");
                System.out.print("Examen " + (j + 1));
                primero = false;
            }
        }
        System.out.println();

        scanner.close();
    }

    // Métodos auxiliares de lectura segura de datos
    public static int leerEntero(Scanner scanner, String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("  [ERROR] Debe ingresar un número entero válido.");
                scanner.next();
            }
        }
        return valor;
    }

    public static double leerDouble(Scanner scanner, String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("  [ERROR] Debe ingresar un número decimal válido.");
                scanner.next();
            }
        }
        return valor;
    }
}