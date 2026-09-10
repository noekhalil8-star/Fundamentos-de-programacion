import java.util.Scanner;

public class AhorroMes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double deposito;
        double total = 0.0;
        int mes = 1;
        String respuesta;

        System.out.print("¿Desea registrar un depósito de ahorro? (S/N): ");
        respuesta = scanner.next();

        while (respuesta.equalsIgnoreCase("S")) {
            System.out.print("Ingrese la cantidad depositada en el mes " + mes + ": ");
            deposito = scanner.nextDouble();
            
            total = total + deposito;
            
            System.out.println("El ahorro acumulado al final del mes " + mes + " es: $" + total);
            
            mes++;

            System.out.print("\n¿Desea registrar el depósito del siguiente mes? (S/N): ");
            respuesta = scanner.next();
        }
        
        System.out.println("\n--- Has decidido finalizar el registro de ahorros ---");
        System.out.println("Total de meses registrados: " + (mes - 1));
        System.out.println("El ahorro total acumulado es: $" + total);
        
        scanner.close();
    }
}
