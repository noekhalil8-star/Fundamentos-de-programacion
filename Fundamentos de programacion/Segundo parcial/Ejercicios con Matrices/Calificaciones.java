import java.util.Scanner;

public class Calificaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de estudiantes (N): ");
        int n = scanner.nextInt();
        System.out.print("Ingrese el número de exámenes (M): ");
        int m = scanner.nextInt();

        // Matriz de calificaciones (N estudiantes x M exámenes)
        double[][] calificaciones = new double[n][m];

        System.out.println("\n--- Registro de Calificaciones ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Estudiante " + (i + 1) + ":");
            for (int j = 0; j < m; j++) {
                System.out.print("  Examen " + (j + 1) + ": ");
                calificaciones[i][j] = scanner.nextDouble();
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

        System.out.println("\n--- Promedio por Estudiante ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Estudiante %d: %.2f\n", (i + 1), promediosEstudiantes[i]);
        }

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

        System.out.println("\n--- LISTADO DE ESTUDIANTES DESTACADOS (Promedio 9.0 - 10.0) ---");
        if (contadorExcelentes == 0) {
            System.out.println("Ningún estudiante obtuvo un promedio entre 9 y 10.");
        } else {
            System.out.println("ID Estudiante\tPromedio");
            for (int i = 0; i < contadorExcelentes; i++) {
                System.out.printf("Estudiante %d\t%.2f\n", (int) matrizExcelentes[i][0], matrizExcelentes[i][1]);
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

        System.out.println("\n--- LISTADO DE ESTUDIANTES CON PROMEDIO INFERIOR A 7.0 ---");
        if (contadorBajos == 0) {
            System.out.println("Ningún estudiante obtuvo promedio inferior a 7.0.");
        } else {
            System.out.println("ID Estudiante\tPromedio");
            for (int i = 0; i < contadorBajos; i++) {
                System.out.printf("Estudiante %d\t%.2f\n", (int) matrizBajos[i][0], matrizBajos[i][1]);
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

        System.out.println("\n--- ANÁLISIS DE EXÁMENES ---");
        System.out.print("• Examen(es) con el PROMEDIO MÁS ALTO (Promedio: " + String.format("%.2f", maxPromExamen) + "): ");
        for (int j = 0; j < m; j++) {
            if (Math.abs(promedioExamenes[j] - maxPromExamen) < 0.0001) {
                System.out.print("Examen " + (j + 1) + " ");
            }
        }
        System.out.println();

        System.out.print("• Examen(es) con el PROMEDIO MÁS BAJO (Promedio: " + String.format("%.2f", minPromExamen) + "): ");
        for (int j = 0; j < m; j++) {
            if (Math.abs(promedioExamenes[j] - minPromExamen) < 0.0001) {
                System.out.print("Examen " + (j + 1) + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}