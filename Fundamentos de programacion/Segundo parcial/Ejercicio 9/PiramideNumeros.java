import java.util.Scanner;

public class PiramideNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Ingrese el valor de n (lineas de la piramide): ");
            int n = scanner.nextInt();

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }

            System.out.println();
            System.out.print("¿Desea generar otra piramide numerica? (s/n): ");
            opcion = scanner.next();

        } while (!opcion.equalsIgnoreCase("n"));

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
