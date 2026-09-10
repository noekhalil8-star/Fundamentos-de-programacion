import java.util.Scanner;

public class Becas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char respuesta;

        do {
            System.out.println("--- 7. ASIGNACIÓN DE BECAS ESTUDIANTILES ---");
            System.out.print("Ingrese la edad del estudiante: ");
            int edad = scanner.nextInt();

            System.out.print("Ingrese el promedio obtenido: ");
            double promedio = scanner.nextDouble();

            if (edad > 18) {
                if (promedio >= 9.0) {
                    System.out.println("Monto de beca asignado: $10,000.00");
                } else if (promedio >= 7.5) {
                    System.out.println("Monto de beca asignado: $8,000.00");
                } else if (promedio >= 6.0) {
                    System.out.println("Monto de beca asignado: $5,000.00");
                } else {
                    System.out.println("Resultado: Se enviará una carta de invitación incitándolo a estudiar más.");
                }
            } else {
                if (promedio >= 9.0) {
                    System.out.println("Monto de beca asignado: $8,000.00");
                } else if (promedio >= 8.0) {
                    System.out.println("Monto de beca asignado: $6,000.00");
                } else if (promedio >= 6.0) {
                    System.out.println("Monto de beca asignado: $4,000.00");
                } else {
                    System.out.println("Resultado: Se enviará una carta de invitación incitándolo a estudiar más.");
                }
            }

            System.out.print("\n¿Desea consultar la beca de otro estudiante? (s/n): ");
            respuesta = scanner.next().toLowerCase().charAt(0);

        } while (respuesta != 'n');

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
