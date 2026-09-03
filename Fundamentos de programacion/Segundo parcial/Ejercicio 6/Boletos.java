import java.util.Scanner;

public class Boletos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de personas: ");
        int personas = sc.nextInt();
        System.out.print("Seleccione día (1:Lunes, 2:Martes, 3:Miércoles, 4:Jueves, 5:Viernes, 6:Sábado, 7:Domingo): ");
        int dia = sc.nextInt();
        System.out.print("¿Tiene membresía? (S/N): ");
        char membresia = sc.next().toUpperCase().charAt(0);

        double total = 0;

        switch (dia) {
            case 3: // Miércoles
                total = personas * 30;
                break;
            case 4: // Jueves
                int parejas = personas / 2;
                int individuales = personas % 2;
                total = (parejas * 75) + (individuales * 50);
                break;
            default: // Resto de días
                total = personas * 50;
                break;
        }

        if (membresia == 'S') {
            total *= 0.90;
        }

        System.out.println("El total a pagar es: $" + total);
        sc.close();
    }
}