import java.util.Scanner;

public class Pastel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Elija el sabor (manzana, fresa, chocolate): ");
        String sabor = sc.next().toLowerCase();

        double total = 0;

        switch (sabor) {
            case "manzana":
                total = 200;
                break;
            case "fresa":
                total = 250;
                break;
            case "chocolate":
                System.out.print("¿Chocolate negro o blanco?: ");
                String tipo = sc.next().toLowerCase();
                if (tipo.equals("negro")) {
                    total = 280;
                } else {
                    total = 300;
                }
                break;
            default:
                System.out.println("Sabor no válido.");
                break;
        }

        if (total > 0) {
            System.out.print("¿Desea añadir snacks? (S/N): ");
            char respSnack = sc.next().toUpperCase().charAt(0);
            if (respSnack == 'S') {
                System.out.print("¿Cuántos snacks desea?: ");
                int cantSnacks = sc.nextInt();
                total += cantSnacks * 25;
            }

            System.out.print("¿Desea personalizar con un nombre? (S/N): ");
            char respNombre = sc.next().toUpperCase().charAt(0);
            if (respNombre == 'S') {
                total += 30;
            }

            System.out.println("El precio total de la tarta es: $" + total);
        }
        sc.close();
    }
}