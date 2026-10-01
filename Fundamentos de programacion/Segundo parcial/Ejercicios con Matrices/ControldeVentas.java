import java.util.Scanner;

public class ControldeVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de vendedores (n): ");
        int n = scanner.nextInt();
        System.out.print("Ingrese la cantidad de zonas (m): ");
        int m = scanner.nextInt();
        System.out.print("Ingrese el precio de cada computadora: ");
        double precioUnidad = scanner.nextDouble();

        // Matriz de n vendedores x m zonas
        int[][] ventas = new int[n][m];

        System.out.println("\n--- Registro de ventas ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Computadoras vendidas por el Vendedor " + (i + 1) + " en la Zona " + (j + 1) + ": ");
                ventas[i][j] = scanner.nextInt();
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
        int indiceZonaMax = 0;
        for (int j = 1; j < m; j++) {
            if (totalPorZona[j] > maxZonaVentas) {
                maxZonaVentas = totalPorZona[j];
                indiceZonaMax = j;
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
        int indiceVendedorMin = 0;
        int maxVendedorVentas = totalPorVendedor[0];
        int indiceVendedorMax = 0;

        for (int i = 1; i < n; i++) {
            if (totalPorVendedor[i] < minVendedorVentas) {
                minVendedorVentas = totalPorVendedor[i];
                indiceVendedorMin = i;
            }
            if (totalPorVendedor[i] > maxVendedorVentas) {
                maxVendedorVentas = totalPorVendedor[i];
                indiceVendedorMax = i;
            }
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("• La zona que más computadoras vendió fue la Zona " + (indiceZonaMax + 1) + " con " + maxZonaVentas + " unidades.");
        System.out.println("• El vendedor que MENOS vendió fue el Vendedor " + (indiceVendedorMin + 1) + ".");
        System.out.println("  - Cantidad: " + minVendedorVentas + " computadoras.");
        System.out.println("  - Venta total: $" + (minVendedorVentas * precioUnidad));

        System.out.println("• El vendedor que MÁS vendió fue el Vendedor " + (indiceVendedorMax + 1) + ".");
        System.out.println("  - Cantidad: " + maxVendedorVentas + " computadoras.");
        System.out.println("  - Venta total: $" + (maxVendedorVentas * precioUnidad));

        System.out.println("• La cantidad total de computadoras vendidas en todas las zonas es: " + totalGeneralComputadoras);

        scanner.close();
    }
}