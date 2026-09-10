import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Ingrese un numero para generar su tabla: ");
            int n = scanner.nextInt();

            System.out.println("Tabla del " + n + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " x " + i + " = " + (n * i));
            }

            System.out.println();
            System.out.print("¿Desea consultar otra tabla de multiplicar? (s/n): ");
            opcion = scanner.next();

        } while (!opcion.equalsIgnoreCase("n"));

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
