import java.util.Scanner;

public class Multas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char respuesta;

        do {
            System.out.println("--- MULTA DE VELOCIDAD ---");
            System.out.print("Ingrese la velocidad: ");
            int velocidad = scanner.nextInt();

            System.out.print("¿Es tu cumpleaños? (true/false): ");
            boolean esCumpleanos = scanner.nextBoolean();

            int limite1 = esCumpleanos ? 65 : 60;
            int limite2 = esCumpleanos ? 85 : 80;

            int resultado;
            if (velocidad <= limite1) {
                resultado = 0;
            } else if (velocidad <= limite2) {
                resultado = 1;
            } else {
                resultado = 2;
            }

            System.out.println("Resultado de la multa: " + resultado);

            System.out.print("¿Desea evaluar otra velocidad? (s/n): ");
            respuesta = scanner.next().toLowerCase().charAt(0);

        } while (respuesta != 'n');

        System.out.println("Proceso finalizado.");
        scanner.close();
    }
}