import java.util.Scanner;

public class ConsultorioMedico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de cita: ");
        int numeroCita = scanner.nextInt();

        if (numeroCita <= 0) {
            System.out.println("Número de cita no válido.");
        } else {
            double costoCita;
            double montoTotal;

            // Determinar costo de la cita actual
            if (numeroCita <= 3) {
                costoCita = 900.00;
            } else if (numeroCita <= 5) {
                costoCita = 800.00;
            } else if (numeroCita <= 8) {
                costoCita = 600.00;
            } else {
                costoCita = 500.00;
            }

            // Calcular el acumulado gastado en el tratamiento
            if (numeroCita <= 3) {
                montoTotal = numeroCita * 900.00;
            } else if (numeroCita <= 5) {
                montoTotal = (3 * 900.00) + ((numeroCita - 3) * 800.00);
            } else if (numeroCita <= 8) {
                montoTotal = (3 * 900.00) + (2 * 800.00) + ((numeroCita - 5) * 600.00);
            } else {
                montoTotal = (3 * 900.00) + (2 * 800.00) + (3 * 600.00) + ((numeroCita - 8) * 500.00);
            }

            System.out.printf("El cliente pagará por la cita #%d: $%.2f%n", numeroCita, costoCita);
            System.out.printf("El monto total pagado por el tratamiento es: $%.2f%n", montoTotal);
        }

        scanner.close();
    }
}