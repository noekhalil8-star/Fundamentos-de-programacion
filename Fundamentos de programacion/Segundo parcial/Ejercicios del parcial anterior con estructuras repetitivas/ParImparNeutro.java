import java.util.Scanner;

public class ParImparNeutro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char respuesta;

        do {
            System.out.println("--- 3. NÚMERO PAR, IMPAR O NEUTRO ---");
            System.out.print("Ingrese un número entero: ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                System.out.println("El número es Neutro (0).");
            } else if (numero % 2 == 0) {
                System.out.println("El número es Par.");
            } else {
                System.out.println("El número es Impar.");
            }

            System.out.print("\n¿Desea evaluar otro número? (s/n): ");
            respuesta = scanner.next().toLowerCase().charAt(0);

        } while (respuesta != 'n');

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
