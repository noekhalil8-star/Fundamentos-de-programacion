import java.util.Scanner;
public class SeguroAuto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double valorVehiculo = leerValorVehiculo(sc);
        int edad = leerEdad(sc);
        int accidentes = leerAccidentes(sc);
        boolean tieneSeguridad = leerSeguridad(sc);

        double tarifaBase = calcularTarifaBase(valorVehiculo);
        double recargoEdad = calcularRecargoPorEdad(tarifaBase, edad);
        double recargoAccidentes = calcularRecargoPorAccidentes(tarifaBase, accidentes);
        double subtotal = tarifaBase + recargoEdad + recargoAccidentes;
        double descuento = calcularDescuentoSeguridad(subtotal, tieneSeguridad);
        double costoFinal = calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento);

        mostrarResultado(tarifaBase, recargoEdad, recargoAccidentes, descuento, costoFinal);

        sc.close();
    }

    static double leerValorVehiculo(Scanner sc) {
        double valor;
        do {
            System.out.print("Valor del vehículo: $");
            valor = sc.nextDouble();
            if (valor <= 0) {
                System.out.println("Error: el valor del vehículo debe ser mayor que cero.");
            }
        } while (valor <= 0);
        return valor;
    }

    static int leerEdad(Scanner sc) {
        int edad;
        do {
            System.out.print("Edad del conductor (18-100): ");
            edad = sc.nextInt();
            if (edad < 18 || edad > 100) {
                System.out.println("Error: la edad debe estar entre 18 y 100 años.");
            }
        } while (edad < 18 || edad > 100);
        return edad;
    }

    static int leerAccidentes(Scanner sc) {
        int accidentes;
        do {
            System.out.print("Número de accidentes reportados: ");
            accidentes = sc.nextInt();
            if (accidentes < 0) {
                System.out.println("Error: el número de accidentes no puede ser negativo.");
            }
        } while (accidentes < 0);
        return accidentes;
    }

    static boolean leerSeguridad(Scanner sc) {
        System.out.print("¿Cuenta con sistema de seguridad adicional? (s/n): ");
        String resp = sc.next();
        return resp.equalsIgnoreCase("s");
    }

    static double calcularTarifaBase(double valorVehiculo) {
        return valorVehiculo * 0.04;
    }

    static double calcularRecargoPorEdad(double tarifaBase, int edad) {
        if (edad < 25) {
            return tarifaBase * 0.20;
        } else if (edad <= 60) {
            return 0.0;
        } else {
            return tarifaBase * 0.10;
        }
    }

    static double calcularRecargoPorAccidentes(double tarifaBase, int accidentes) {
        return tarifaBase * 0.08 * accidentes;
    }

    static double calcularDescuentoSeguridad(double subtotal, boolean tieneSeguridad) {
        return tieneSeguridad ? subtotal * 0.05 : 0.0;
    }

    static double calcularCostoFinal(double tarifaBase, double recargoEdad,
                                      double recargoAccidentes, double descuento) {
        double subtotal = tarifaBase + recargoEdad + recargoAccidentes;
        return subtotal - descuento;
    }

    static void mostrarResultado(double tarifaBase, double recargoEdad, double recargoAccidentes,
                                  double descuento, double costoFinal) {
        System.out.println("\n--- Cotización del seguro ---");
        System.out.printf("Tarifa base:            $%.2f%n", tarifaBase);
        System.out.printf("Recargo por edad:       $%.2f%n", recargoEdad);
        System.out.printf("Recargo por accidentes: $%.2f%n", recargoAccidentes);
        System.out.printf("Descuento seguridad:    $%.2f%n", descuento);
        System.out.printf("COSTO FINAL:            $%.2f%n", costoFinal);
    }
}
