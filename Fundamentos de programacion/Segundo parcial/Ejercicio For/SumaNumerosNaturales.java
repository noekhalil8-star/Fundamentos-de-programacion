import java.util.Scanner;

public class SumaNumerosNaturales {
    public static void main(String[] args) {
        int N, i, suma;
         Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese un numero N para sumar los primeros numeros naturales:");
    N = scanner.nextInt();

    suma = 0;

    for (i = 1; i <= N; i++) {
        suma = suma + i;
    }

    System.out.println("La suma de los primeros " + N + " numeros naturales es: " + suma);
    scanner.close();
    }
}