import java.util.Scanner;

public class Banquetes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double costoPlatillo = 95.00;
        Double costoPlatillo200 = 85.00;
        Double costoPlatillo300 = 75.00;
        
        System.out.print("Introduce el numero de personas que tendran platillo: ");
        int personas = sc.nextInt();

        if (personas <200 ) {
            System.out.println("se te cobrara: = " + costoPlatillo);
        } else if (personas >=200 && personas < 300) {
            System.out.println("Se te cobrara: = " + costoPlatillo200);
        } else if (personas >= 300) {
            System.out.println( "Se te cobrara: = " + costoPlatillo300);
        }

        sc.close();
    }
}
