import java.util.Scanner;

public class VentasT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables de conteo y montos
        int cantMayor1000 = 0, cantEntre500y1000 = 0, cantMenor500 = 0;
        double mayor1000 = 0.0, entre500y1000 = 0.0, menor500 = 0.0, total = 0.0;
        double venta;
        String respuesta;

        System.out.print("¿Desea registrar una venta? (S/N): ");
        respuesta = scanner.next();

        // Ciclo mientras el usuario desee seguir registrando iteraciones
        while (respuesta.equalsIgnoreCase("S")) {
            System.out.print("Ingrese el monto de la venta: ");
            venta = scanner.nextDouble();

            total = total + venta;

            if (venta > 1000) {
                cantMayor1000++;
                mayor1000 = mayor1000 + venta;
            } else if (venta > 500 && venta <= 1000) {
                cantEntre500y1000++;
                entre500y1000 = entre500y1000 + venta;
            } else if (venta <= 500) {
                cantMenor500++;
                menor500 = menor500 + venta;
            }

            System.out.print("¿Desea registrar otra venta? (S/N): ");
            respuesta = scanner.next();
        }

        // Mensaje cuando el usuario ya no desea realizar más iteraciones
        System.out.println("\n--- Has finalizado el registro de ventas ---");
        System.out.println("Resumen de las operaciones realizadas:\n");

        System.out.println("1.- Ventas mayores a $1000:");
        System.out.println("   - Cantidad: " + cantMayor1000);
        System.out.println("   - Subtotal acumulado: $" + mayor1000);
        
        System.out.println("2.- Ventas de entre $500 y $1000:");
        System.out.println("   - Cantidad: " + cantEntre500y1000);
        System.out.println("   - Subtotal acumulado: $" + entre500y1000);
        
        System.out.println("3.- Ventas menores a $500:");
        System.out.println("   - Cantidad: " + cantMenor500);
        System.out.println("   - Subtotal acumulado: $" + menor500);
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Monto total acumulado: $" + total);

        scanner.close();
    }
}