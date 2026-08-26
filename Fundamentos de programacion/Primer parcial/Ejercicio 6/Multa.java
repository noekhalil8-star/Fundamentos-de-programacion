import java.util.Scanner;

public class Multa {
    public static int evaluarVelocidad(int velocidad, boolean esCumpleanos) {
        int limite1 = esCumpleanos ? 65 : 60;
        int limite2 = esCumpleanos ? 85 : 80;

        if (velocidad <= limite1) {
            return 0;
        } else if (velocidad <= limite2) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la velocidad: ");
        int velocidad = scanner.nextInt();

        System.out.print("¿Es tu cumpleaños? (true/false): ");
        boolean esCumpleanos = scanner.nextBoolean();

        int resultado = evaluarVelocidad(velocidad, esCumpleanos);
        System.out.println("Resultado de la multa: " + resultado);

        scanner.close();
    }
}