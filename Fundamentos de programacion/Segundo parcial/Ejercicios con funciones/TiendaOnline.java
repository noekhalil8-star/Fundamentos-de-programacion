import java.util.Scanner;

public class TiendaOnline {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double precio1 = leerPrecio(sc, "producto 1");
        int cantidad1 = leerCantidad(sc, "producto 1");
        double precio2 = leerPrecio(sc, "producto 2");
        int cantidad2 = leerCantidad(sc, "producto 2");
        double precio3 = leerPrecio(sc, "producto 3");
        int cantidad3 = leerCantidad(sc, "producto 3");

        int tipoCliente = leerTipoCliente(sc);
        String codigoPostal = leerCodigoPostal(sc);

        double sub1 = calcularSubtotalProducto(precio1, cantidad1);
        double sub2 = calcularSubtotalProducto(precio2, cantidad2);
        double sub3 = calcularSubtotalProducto(precio3, cantidad3);

        double subtotalGeneral = calcularSubtotalGeneral(sub1, sub2, sub3);
        double descuento = calcularDescuento(subtotalGeneral, tipoCliente);
        double envio = calcularEnvio(subtotalGeneral, codigoPostal);
        double subtotalConDescuento = subtotalGeneral - descuento;
        double impuesto = calcularImpuesto(subtotalConDescuento);
        double total = calcularTotal(subtotalGeneral, descuento, impuesto, envio);

        mostrarResumen(subtotalGeneral, descuento, impuesto, envio, total);

        sc.close();
    }

    static double leerPrecio(Scanner sc, String etiqueta) {
        double precio;
        do {
            System.out.print("Precio de " + etiqueta + ": $");
            precio = sc.nextDouble();
            if (precio <= 0) {
                System.out.println("Error: el precio debe ser mayor que cero.");
            }
        } while (precio <= 0);
        return precio;
    }

    static int leerCantidad(Scanner sc, String etiqueta) {
        int cantidad;
        do {
            System.out.print("Cantidad de " + etiqueta + ": ");
            cantidad = sc.nextInt();
            if (cantidad <= 0) {
                System.out.println("Error: la cantidad debe ser un entero mayor que cero.");
            }
        } while (cantidad <= 0);
        return cantidad;
    }

    static int leerTipoCliente(Scanner sc) {
        int tipo;
        do {
            System.out.print("Tipo de cliente (1=Regular, 2=Frecuente): ");
            tipo = sc.nextInt();
            if (tipo != 1 && tipo != 2) {
                System.out.println("Error: el tipo de cliente solo puede ser 1 o 2.");
            }
        } while (tipo != 1 && tipo != 2);
        return tipo;
    }

    static String leerCodigoPostal(Scanner sc) {
        String cp;
        do {
            System.out.print("Código postal (5 dígitos): ");
            cp = sc.next();
            if (!cp.matches("\\d{5}")) {
                System.out.println("Error: el código postal debe contener exactamente cinco dígitos.");
            }
        } while (!cp.matches("\\d{5}"));
        return cp;
    }

    static double calcularSubtotalProducto(double precio, int cantidad) {
        return precio * cantidad;
    }

    static double calcularSubtotalGeneral(double subtotal1, double subtotal2, double subtotal3) {
        return subtotal1 + subtotal2 + subtotal3;
    }

    static double calcularDescuento(double subtotal, int tipoCliente) {
        return tipoCliente == 2 ? subtotal * 0.10 : 0.0;
    }

    static double calcularEnvio(double subtotal, String codigoPostal) {
        if (subtotal < 1000) {
            return 150.0;
        } else if (subtotal < 3000) {
            return 80.0;
        } else {
            return 0.0;
        }
    }

    static double calcularImpuesto(double subtotalConDescuento) {
        return subtotalConDescuento * 0.16;
    }

    static double calcularTotal(double subtotal, double descuento, double impuesto, double envio) {
        return subtotal - descuento + impuesto + envio;
    }

    static void mostrarResumen(double subtotal, double descuento, double impuesto, double envio, double total) {
        System.out.println("\n--- Resumen de compra ---");
        System.out.printf("Subtotal:  $%.2f%n", subtotal);
        System.out.printf("Descuento: $%.2f%n", descuento);
        System.out.printf("Impuesto:  $%.2f%n", impuesto);
        System.out.printf("Envío:     $%.2f%n", envio);
        System.out.printf("TOTAL:     $%.2f%n", total);
    }
}
