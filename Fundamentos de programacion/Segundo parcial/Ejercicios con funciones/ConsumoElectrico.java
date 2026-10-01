import java.util.Scanner;

public class ConsumoElectrico {

    static final double CARGO_FIJO = 95.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double lecturaAnterior = leerLecturaAnterior(sc);
        double lecturaActual = leerLecturaActual(sc, lecturaAnterior);
        boolean tieneApoyo = leerApoyo(sc);

        double consumo = calcularConsumo(lecturaAnterior, lecturaActual);
        double costoConsumo = calcularCostoConsumo(consumo);
        double costoAntesImpuesto = costoConsumo + CARGO_FIJO;
        double descuento = calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo);
        
        // Se calcula el impuesto sobre la base imponible real (después del descuento)
        double baseImponible = costoAntesImpuesto - descuento;
        double impuesto = calcularImpuesto(baseImponible);
        
        double total = calcularTotal(costoConsumo, CARGO_FIJO, descuento, impuesto);

        mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total);

        sc.close();
    }

    static double leerLecturaAnterior(Scanner sc) {
        double lectura;
        do {
            System.out.print("Lectura anterior (kWh): ");
            lectura = sc.nextDouble();
            if (lectura < 0) {
                System.out.println("Error: la lectura no puede ser negativa.");
            }
        } while (lectura < 0);
        return lectura;
    }

    static double leerLecturaActual(Scanner sc, double lecturaAnterior) {
        double lectura;
        do {
            System.out.print("Lectura actual (kWh): ");
            lectura = sc.nextDouble();
            if (lectura < 0) {
                System.out.println("Error: la lectura no puede ser negativa.");
            } else if (lectura < lecturaAnterior) {
                System.out.println("Error: la lectura actual debe ser mayor o igual que la anterior.");
            } else if (lectura - lecturaAnterior > 10000) {
                System.out.println("Error: el consumo máximo permitido es de 10,000 kWh.");
            }
        } while (lectura < 0 || lectura < lecturaAnterior || lectura - lecturaAnterior > 10000);
        return lectura;
    }

    static boolean leerApoyo(Scanner sc) {
        System.out.print("¿La vivienda pertenece al programa de apoyo? (s/n): ");
        String resp = sc.next().trim().toLowerCase();
        // Acepta 's', 'si' y 'sí'
        return resp.equals("s") || resp.equals("si") || resp.equals("sí");
    }

    static double calcularConsumo(double lecturaAnterior, double lecturaActual) {
        return lecturaActual - lecturaAnterior;
    }

    static double calcularCostoConsumo(double consumo) {
        double costo;
        if (consumo <= 150) {
            costo = consumo * 1.20;
        } else if (consumo <= 400) {
            costo = 150 * 1.20 + (consumo - 150) * 1.80;
        } else {
            costo = 150 * 1.20 + 250 * 1.80 + (consumo - 400) * 2.75;
        }
        return costo;
    }

    static double calcularDescuentoApoyo(double consumo, double costoAntesImpuesto, boolean tieneApoyo) {
        if (tieneApoyo && consumo <= 250) {
            return costoAntesImpuesto * 0.30;
        }
        return 0.0;
    }

    static double calcularImpuesto(double baseImponible) {
        return baseImponible * 0.16;
    }

    static double calcularTotal(double costoConsumo, double cargoFijo, double descuento, double impuesto) {
        double costoAntesImpuesto = costoConsumo + cargoFijo;
        return costoAntesImpuesto - descuento + impuesto;
    }

    static void mostrarRecibo(double consumo, double costoConsumo, double descuento, double impuesto, double total) {
        System.out.println("\n--- Recibo de electricidad ---");
        System.out.printf("Consumo:         %.2f kWh%n", consumo);
        System.out.printf("Costo consumo:   $%.2f%n", costoConsumo);
        System.out.printf("Cargo fijo:      $%.2f%n", CARGO_FIJO);
        System.out.printf("Descuento apoyo: $%.2f%n", descuento);
        System.out.printf("Impuesto (16%%):  $%.2f%n", impuesto);
        System.out.printf("TOTAL A PAGAR:   $%.2f%n", total);
    }
}