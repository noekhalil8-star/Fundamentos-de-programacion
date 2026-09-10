import java.util.Scanner;

public class Uvas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char respuesta;

        do {
            System.out.println("--- VENTA DE UVA ---");
            System.out.print("Ingrese el precio inicial por kilo ($): ");
            double precioInicial = scanner.nextDouble();

            System.out.print("Ingrese la cantidad de kilos: ");
            double kilos = scanner.nextDouble();

            System.out.print("Ingrese el tipo de uva (A o B): ");
            char tipo = scanner.next().toUpperCase().charAt(0);

            System.out.print("Ingrese el tamaño de uva (1 o 2): ");
            int tamano = scanner.nextInt();

            double precioFinal = precioInicial;

            if (tipo == 'A') {
                if (tamano == 1) {
                    precioFinal += 0.20;
                } else if (tamano == 2) {
                    precioFinal += 0.30;
                }
            } else if (tipo == 'B') {
                if (tamano == 1) {
                    precioFinal -= 0.30;
                } else if (tamano == 2) {
                    precioFinal -= 0.50;
                }
            }

            double ganancia = kilos * precioFinal;

            System.out.printf("El precio final por kilo es: $%.2f%n", precioFinal);
            System.out.printf("La ganancia total del embarque es: $%.2f%n", ganancia);

            System.out.print("¿Desea realizar otro cálculo? (s/n): ");
            respuesta = scanner.next().toLowerCase().charAt(0);

        } while (respuesta != 'n');

        System.out.println("Proceso finalizado.");
        scanner.close();
    }
}
