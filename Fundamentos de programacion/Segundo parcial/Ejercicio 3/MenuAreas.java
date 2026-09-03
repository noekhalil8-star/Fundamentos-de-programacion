import java.util.Scanner;

public class MenuAreas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- MENÚ DE ÁREAS ---");
        System.out.println("1. Cuadrado\n2. Rectángulo\n3. Triángulo\n4. Círculo");
        System.out.print("Elija una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el lado: ");
                double lado = sc.nextDouble();
                System.out.println("Área: " + (lado * lado));
                break;
            case 2:
                System.out.print("Ingrese la base: ");
                double baseR = sc.nextDouble();
                System.out.print("Ingrese la altura: ");
                double altR = sc.nextDouble();
                System.out.println("Área: " + (baseR * altR));
                break;
            case 3:
                System.out.print("Ingrese la base: ");
                double baseT = sc.nextDouble();
                System.out.print("Ingrese la altura: ");
                double altT = sc.nextDouble();
                System.out.println("Área: " + ((baseT * altT) / 2));
                break;
            case 4:
                System.out.print("Ingrese el radio: ");
                double radio = sc.nextDouble();
                System.out.println("Área: " + (Math.PI * Math.pow(radio, 2)));
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
        sc.close();
    }
}
