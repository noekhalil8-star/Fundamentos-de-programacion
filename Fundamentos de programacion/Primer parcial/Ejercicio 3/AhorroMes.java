import java.util.Scanner;

public class AhorroMes{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double deposito;
        double total = 0.0;
        
        
        for (int mes = 1; mes <= 12; mes++) {
            System.out.print("Ingrese la cantidad depositada en el mes " + mes + ": ");
            deposito = scanner.nextDouble();
            
            total = total + deposito;
            
            System.out.println("El ahorro acumulado al final del mes " + mes + " es: $" + total);
            System.out.println(); 
        }
        
        System.out.println("El ahorro total al final del año es: $" + total);
        
        scanner.close();
    }
}
