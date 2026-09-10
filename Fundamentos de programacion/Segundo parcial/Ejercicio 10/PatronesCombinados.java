import java.util.Scanner;

public class PatronesCombinados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Ingrese el valor de n (lineas de las figuras): ");
            int n = scanner.nextInt();

            for (int i = 1; i <= n; i++) {
                // --- FIGURA 1: Cuadrado ---
                for (int j = 1; j <= n; j++) {
                    System.out.print("* ");
                }

                System.out.print("    "); // Espacio de separación

                // --- FIGURA 2: Pirámide Invertida ---
                int filaInv = n - i + 1;
                for (int j = 1; j <= n - filaInv; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= (2 * filaInv - 1); k++) {
                    System.out.print("*");
                }
                for (int j = 1; j <= n - filaInv; j++) {
                    System.out.print(" ");
                }

                System.out.print("    "); // Espacio de separación

                // --- FIGURA 3: Pirámide Normal ---
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= (2 * i - 1); k++) {
                    System.out.print("*");
                }

                System.out.println();
            }

            System.out.println();
            System.out.print("¿Desea generar otra figura? (s/n): ");
            opcion = scanner.next();

        } while (!opcion.equalsIgnoreCase("n"));

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
