import java.util.Scanner;

public class  ColaFIFO{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        while (max <= 0) {
            System.out.print("Tamaño máximo de la cola (MAX): ");
            try {
                max = Integer.parseInt(sc.nextLine());
                if (max <= 0) {
                    System.out.println("Debe ser un número mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Escribe un número entero válido.");
            }
        }

        char[] cola = new char[max];
        int ultimo = -1; // posición del último elemento; -1 → cola vacía
        // El FRENTE siempre es la posición 0 (como en el pizarrón)

        int opcion;
        do {
            System.out.println("\n===== MENÚ COLA (FIFO) =====");
            System.out.println("1. Encolar (meter dato)");
            System.out.println("2. Desencolar (sacar dato del frente)");
            System.out.println("3. Ver el frente");
            System.out.println("4. Mostrar cola");
            System.out.println("5. Sacar dato por posición");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0; // opción inválida
            }

            switch (opcion) {
                case 1: // ENCOLAR
                    if (ultimo == max - 1) {
                        System.out.println("Error: Overflow, la cola está llena (FRENTE = MAX).");
                    } else {
                        System.out.print("Escribe un carácter: ");
                        String texto = sc.nextLine();
                        if (texto.length() != 1) {
                            System.out.println("Debes escribir exactamente un carácter.");
                        } else {
                            ultimo++;
                            cola[ultimo] = texto.charAt(0);
                            System.out.println("Agregado correctamente.");
                        }
                    }
                    break;

                case 2: // DESENCOLAR
                    if (ultimo < 0) {
                        System.out.println("Error: Underflow, la cola está vacía.");
                    } else {
                        char sacado = cola[0];
                        // Recorrer los elementos una posición hacia el frente
                        for (int i = 0; i < ultimo; i++) {
                            cola[i] = cola[i + 1];
                        }
                        ultimo--;
                        System.out.println("Sacaste: " + sacado);
                    }
                    break;

                case 3: // VER EL FRENTE
                    if (ultimo < 0) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Frente: " + cola[0]);
                    }
                    break;

                case 4: // MOSTRAR
                    if (ultimo < 0) {
                        System.out.println("Cola vacía.");
                    } else {
                        for (int i = 0; i <= ultimo; i++) {
                            String linea = "[" + i + "] | " + cola[i] + " |";
                            if (i == 0) linea += "  <- FRENTE";
                            if (i == ultimo) linea += "  <- FINAL";
                            System.out.println(linea);
                        }
                        System.out.println("Elementos: " + (ultimo + 1));
                    }
                    break;

                case 5: // SACAR POR POSICIÓN
                    if (ultimo < 0) {
                        System.out.println("Error: la cola está vacía.");
                    } else {
                        for (int i = 0; i <= ultimo; i++) {
                            System.out.println("[" + i + "] | " + cola[i] + " |");
                        }
                        System.out.print("¿De qué posición quieres sacar el dato?: ");
                        try {
                            int pos = Integer.parseInt(sc.nextLine());
                            if (pos < 0 || pos > ultimo) {
                                System.out.println("Posición inválida. Debe estar entre 0 y " + ultimo);
                            } else {
                                // Salen primero los que están delante (en el camino)
                                for (int i = 0; i < pos; i++) {
                                    System.out.println("Se eliminó '" + cola[i] + "' (estaba en el camino)");
                                }
                                System.out.println("Sacaste: " + cola[pos]);
                                // Recorrer lo que quedó hacia el frente
                                int eliminados = pos + 1;
                                for (int i = 0; i + eliminados <= ultimo; i++) {
                                    cola[i] = cola[i + eliminados];
                                }
                                ultimo -= eliminados;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Escribe un número entero válido.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}