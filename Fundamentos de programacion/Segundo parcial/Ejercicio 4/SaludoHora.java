import java.util.Scanner;

public class SaludoHora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la hora (0-23): ");
        int hora = sc.nextInt();

        if (hora >= 0 && hora <= 23) {
            switch (hora) {
                case 6: case 7: case 8: case 9: case 10: case 11: case 12:
                    System.out.println("Buenos días");
                    break;
                case 13: case 14: case 15: case 16: case 17: case 18: case 19: case 20:
                    System.out.println("Buenas tardes");
                    break;
                default:
                    System.out.println("Buenas noches");
                    break;
            }
        } else {
            System.out.println("Hora fuera del rango de 0 a 23.");
        }
        sc.close();
    }
}
