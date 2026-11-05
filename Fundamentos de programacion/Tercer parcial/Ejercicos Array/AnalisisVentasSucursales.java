import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class AnalisisVentasSucursales {

    // Lee un entero mayor a 0; repite la pregunta si la entrada no es válida
    static int leerEnteroPositivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine(); // limpiar el salto de línea pendiente
                if (valor > 0) {
                    return valor;
                }
                System.out.println("  El número debe ser mayor que 0.");
            } else {
                System.out.println("  Entrada inválida. Escribe un número entero.");
                sc.nextLine(); // descartar lo que escribió
            }
        }
    }

    // Lee un decimal mayor o igual a 0; repite la pregunta si la entrada no es válida
    static double leerVenta(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                sc.nextLine();
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("  La venta no puede ser negativa.");
            } else {
                System.out.println("  Entrada inválida. Escribe un número, por ejemplo 15000.50");
                sc.nextLine();
            }
        }
    }

    // Lee un texto que no esté vacío
    static String leerNombre(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("  El nombre no puede estar vacío.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // los decimales se escriben con punto: 15000.50

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                          "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        // Captura de datos
        int numSucursales = leerEnteroPositivo(sc, "¿Cuántas sucursales deseas registrar? ");

        String[] nombresSucursales = new String[numSucursales];
        double[][] ventasSucursales = new double[numSucursales][meses.length];

        for (int i = 0; i < numSucursales; i++) {
            nombresSucursales[i] = leerNombre(sc, "\nNombre de la sucursal " + (i + 1) + ": ");

            for (int j = 0; j < meses.length; j++) {
                ventasSucursales[i][j] = leerVenta(sc, "  Ventas de " + meses[j] + ": $");
            }
        }

        // Estadísticas por sucursal
        double[] ventasAnuales = new double[numSucursales];
        double[] promedioMensual = new double[numSucursales];
        int[] mejorMes = new int[numSucursales];
        double sumaGlobal = 0;

        for (int i = 0; i < numSucursales; i++) {
            double total = 0;
            int mesMax = 0;
            int numMeses = ventasSucursales[i].length;

            for (int j = 0; j < numMeses; j++) {
                total += ventasSucursales[i][j];
                if (ventasSucursales[i][j] > ventasSucursales[i][mesMax]) {
                    mesMax = j;
                }
            }

            ventasAnuales[i] = total;
            promedioMensual[i] = total / numMeses;
            mejorMes[i] = mesMax;
            sumaGlobal += total;
        }

        double promedioGlobal = sumaGlobal / numSucursales;

        System.out.println("\n=== REPORTE ESTADÍSTICO DE VENTAS POR SUCURSAL ===");
        for (int i = 0; i < numSucursales; i++) {
            System.out.println("\n" + nombresSucursales[i] + ":");
            System.out.println("  - Ventas mensuales: " + Arrays.toString(ventasSucursales[i]));
            System.out.println("  - Total anual: $" + String.format("%.2f", ventasAnuales[i]));
            System.out.println("  - Promedio mensual: $" + String.format("%.2f", promedioMensual[i]));
            System.out.println("  - Mejor mes: " + meses[mejorMes[i]]
                    + " ($" + String.format("%.2f", ventasSucursales[i][mejorMes[i]]) + ")");
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("Promedio global de ventas anuales: $" + String.format("%.2f", promedioGlobal));
        System.out.println("Sucursales con ventas anuales superiores al promedio global:");
        boolean hayAlguna = false;
        for (int i = 0; i < numSucursales; i++) {
            if (ventasAnuales[i] > promedioGlobal) {
                System.out.println("  * " + nombresSucursales[i] + " ($" + String.format("%.2f", ventasAnuales[i]) + ")");
                hayAlguna = true;
            }
        }
        if (!hayAlguna) {
            System.out.println("  (ninguna)");
        }

        double[] ventasOrdenadas = Arrays.copyOf(ventasAnuales, ventasAnuales.length);
        Arrays.sort(ventasOrdenadas); // de menor a mayor

        System.out.println("\n--- RANKING DE SUCURSALES (Por Ventas Anuales) ---");
        boolean[] yaImpresa = new boolean[numSucursales];

        for (int r = 0; r < numSucursales; r++) {
            double ventaBuscada = ventasOrdenadas[numSucursales - 1 - r]; // de mayor a menor

            for (int i = 0; i < numSucursales; i++) {
                if (ventasAnuales[i] == ventaBuscada && !yaImpresa[i]) {
                    System.out.println((r + 1) + ". " + nombresSucursales[i]
                            + " - Total: $" + String.format("%.2f", ventasAnuales[i]));
                    yaImpresa[i] = true;
                    break;
                }
            }
        }

        sc.close();
    }
}