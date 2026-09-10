import java.util.Scanner;

public class Estacionamiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char respuesta;

        do {
            System.out.println("--- 6. COBRO DE ESTACIONAMIENTO ---");
            System.out.print("Ingrese la cantidad de horas de estacionamiento: ");
            int horas = scanner.nextInt();

            if (horas <= 0) {
                System.out.println("Cantidad de horas no válida.");
            } else {
                double totalPagar;

                if (horas > 10) {
                    totalPagar = 380.00;
                } else if (horas <= 2) {
                    totalPagar = horas * 30.00;
                } else if (horas <= 5) {
                    totalPagar = (2 * 30.00) + ((horas - 2) * 25.00);
                } else {
                    totalPagar = (2 * 30.00) + (3 * 25.00) + ((horas - 5) * 20.00);
                }

                System.out.printf("El total a cobrar por %d horas es: $%.2f%n", horas, totalPagar);
            }

            System.out.print("\n¿Desea calcular otro cobro? (s/n): ");
            respuesta = scanner.next().toLowerCase().charAt(0);

        } while (respuesta != 'n');

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
