import java.util.Scanner;

public class NumeroPIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        if (numero == 0) {
            System.out.println("El número es Neutro (0).");
        } else if (numero % 2 == 0) {
            System.out.println("El número es Par.");
        } else {
            System.out.println("El número es Impar.");
        }

        scanner.close();
    }
}