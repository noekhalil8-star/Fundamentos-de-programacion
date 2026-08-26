import java.util.Scanner;

public class Paqueteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el peso del paquete en kg: ");
        double pesoKg = scanner.nextDouble();

        if (pesoKg > 5.0 || pesoKg <= 0) {
            System.out.println("Entrega rechazada: El paquete excede el límite de 5 kg o es un peso inválido.");
        } else {
            System.out.println("Seleccione la zona de destino:");
            System.out.println("1. América del Norte ($11/g)");
            System.out.println("2. América Central ($10/g)");
            System.out.println("3. América del Sur ($12/g)");
            System.out.println("4. Europa ($25/g)");
            System.out.println("5. Asia ($30/g)");
            System.out.print("Opción: ");
            int zona = scanner.nextInt();

            double pesoGramos = pesoKg * 1000;
            double costoGramo = 0;

            switch (zona) {
                case 1: costoGramo = 11; break;
                case 2: costoGramo = 10; break;
                case 3: costoGramo = 12; break;
                case 4: costoGramo = 25; break;
                case 5: costoGramo = 30; break;
                default:
                    System.out.println("Zona no válida.");
                    break;
            }

            if (costoGramo > 0) {
                double totalPagar = pesoGramos * costoGramo;
                System.out.printf("El costo total por el envío es: $%.2f%n", totalPagar);
            }
        }

        scanner.close();
    }
}
