import java.util.Scanner;

public class ControldeVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validaciones de entrada iniciales
        int n;
        do {
            System.out.print("Ingrese la cantidad de vendedores (n > 0): ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Error: Debe ingresar un valor mayor a cero.");
            }
        } while (n <= 0);

        int m;
        do {
            System.out.print("Ingrese la cantidad de zonas (m > 0): ");
            m = scanner.nextInt();
            if (m <= 0) {
                System.out.println("Error: Debe ingresar un valor mayor a cero.");
            }
        } while (m <= 0);

        double precioUnidad;
        do {
            System.out.print("Ingrese el precio de cada computadora (precio >= 0): ");
            precioUnidad = scanner.nextDouble();
            if (precioUnidad < 0) {
                System.out.println("Error: El precio no puede ser negativo.");
            }
        } while (precioUnidad < 0);

        // Matriz de n vendedores x m zonas
        int[][] ventas = new int[n][m];

        System.out.println("\n--- Registro de ventas ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cantidad;
                do {
                    System.out.print("Computadoras vendidas por el Vendedor " + (i + 1) + " en la Zona " + (j + 1) + ": ");
                    cantidad = scanner.nextInt();
                    if (cantidad < 0) {
                        System.out.println("Error: La cantidad de ventas no puede ser negativa.");
                    }
                } while (cantidad < 0);
                ventas[i][j] = cantidad;
            }
        }

        // 1. Zona que más computadoras vendió
        int[] totalPorZona = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                totalPorZona[j] += ventas[i][j];
            }
        }

        int maxZonaVentas = totalPorZona[0];
        for (int j = 1; j < m; j++) {
            if (totalPorZona[j] > maxZonaVentas) {
                maxZonaVentas = totalPorZona[j];
            }
        }

        // 2 y 3. Vendedor que menos y más vendió
        int[] totalPorVendedor = new int[n];
        int totalGeneralComputadoras = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalPorVendedor[i] += ventas[i][j];
            }
            totalGeneralComputadoras += totalPorVendedor[i];
        }

        int minVendedorVentas = totalPorVendedor[0];
        int maxVendedorVentas = totalPorVendedor[0];

        for (int i = 1; i < n; i++) {
            if (totalPorVendedor[i] < minVendedorVentas) {
                minVendedorVentas = totalPorVendedor[i];
            }
            if (totalPorVendedor[i] > maxVendedorVentas) {
                maxVendedorVentas = totalPorVendedor[i];
            }
        }

        // --- IMPRESIÓN DE RESULTADOS ---
        System.out.println("\n--- RESULTADOS ---");

        // Zona(s) con más ventas (maneja empates imprimiendo todas las zonas con el máximo)
        System.out.print("• Zona(s) que más computadoras vendió/vendieron (" + maxZonaVentas + " unidades): ");
        boolean primerElemento = true;
        for (int j = 0; j < m; j++) {
            if (totalPorZona[j] == maxZonaVentas) {
                if (!primerElemento) System.out.print(", ");
                System.out.print("Zona " + (j + 1));
                primerElemento = false;
            }
        }
        System.out.println();

        // Vendedor(es) que MENOS vendió (maneja empates)
        System.out.print("• Vendedor(es) que MENOS vendió/vendieron: ");
        primerElemento = true;
        for (int i = 0; i < n; i++) {
            if (totalPorVendedor[i] == minVendedorVentas) {
                if (!primerElemento) System.out.print(", ");
                System.out.print("Vendedor " + (i + 1));
                primerElemento = false;
            }
        }
        System.out.println();
        System.out.println("  - Cantidad: " + minVendedorVentas + " computadoras.");
        System.out.printf("  - Venta total: $%.2f%n", (minVendedorVentas * precioUnidad));

        // Vendedor(es) que MÁS vendió (maneja empates)
        System.out.print("• Vendedor(es) que MÁS vendió/vendieron: ");
        primerElemento = true;
        for (int i = 0; i < n; i++) {
            if (totalPorVendedor[i] == maxVendedorVentas) {
                if (!primerElemento) System.out.print(", ");
                System.out.print("Vendedor " + (i + 1));
                primerElemento = false;
            }
        }
        System.out.println();
        System.out.println("  - Cantidad: " + maxVendedorVentas + " computadoras.");
        System.out.printf("  - Venta total: $%.2f%n", (maxVendedorVentas * precioUnidad));

        System.out.println("• La cantidad total de computadoras vendidas en todas las zonas es: " + totalGeneralComputadoras);

        scanner.close();
    }
}