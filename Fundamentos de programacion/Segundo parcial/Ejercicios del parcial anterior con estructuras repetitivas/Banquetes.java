import java.util.Scanner;

public class Banquetes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double costoPlatillo = 95.00;
        Double costoPlatillo200 = 85.00;
        Double costoPlatillo300 = 75.00;
        String respuesta;

        System.out.print("¿Desea cotizar un banquete? (S/N): ");
        respuesta = sc.next();

        while (respuesta.equalsIgnoreCase("S")) {
            System.out.print("Introduce el numero de personas que tendran platillo: ");
            int personas = sc.nextInt();

            if (personas < 200) {
                System.out.println("Se te cobrara por platillo: $" + costoPlatillo);
                System.out.println("Costo total: $" + (personas * costoPlatillo));
            } else if (personas >= 200 && personas < 300) {
                System.out.println("Se te cobrara por platillo: $" + costoPlatillo200);
                System.out.println("Costo total: $" + (personas * costoPlatillo200));
            } else if (personas >= 300) {
                System.out.println("Se te cobrara por platillo: $" + costoPlatillo300);
                System.out.println("Costo total: $" + (personas * costoPlatillo300));
            }

            System.out.print("\n¿Desea realizar otra cotización? (S/N): ");
            respuesta = sc.next();
        }

        System.out.println("\n--- Proceso finalizado por el usuario ---");
        sc.close();
    }
}