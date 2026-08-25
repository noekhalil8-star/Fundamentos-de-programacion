import java.util.Scanner;

public class Llamadas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dia, turno;
        double minutos, tarifa = 0.0, costo = 0.0;

        System.out.println("¿Cuál es la duración de la llamada (en minutos)?");
        minutos = scanner.nextDouble();

        if (minutos <= 5) {
            tarifa = minutos * 1;
        } else if (minutos <= 8) {
            tarifa = 5 + (minutos - 5) * 0.8;
        } else if (minutos <= 10) {
            tarifa = 7.4 + (minutos - 8) * 0.7;
        } else {
            tarifa = 8.8 + ((minutos - 10) * 0.5);
        }

        System.out.println("¿En qué día realizó la llamada?");
        System.out.println("Escriba h para día hábil y d para domingo:");
        dia = scanner.next();

        if (dia.equalsIgnoreCase("h")) {
            System.out.println("¿En qué horario se realizó la llamada?");
            System.out.println("Escriba m para matutino y v para vespertino:");
            turno = scanner.next();

            if (turno.equalsIgnoreCase("m")) {
                costo = tarifa + (tarifa * 0.15);
                System.out.println("El costo total es de: " + costo);
            } else if (turno.equalsIgnoreCase("v")) {
                costo = tarifa + (tarifa * 0.10);
                System.out.println("El costo total es de: " + costo);
            } else {
                System.out.println("Opción errónea en turno.");
            }
        } else if (dia.equalsIgnoreCase("d")) {
            costo = tarifa + (tarifa * 0.03);
            System.out.println("El costo total es de: " + costo);
        } else {
            System.out.println("Opción errónea en día.");
        }

        scanner.close();
    }
}
