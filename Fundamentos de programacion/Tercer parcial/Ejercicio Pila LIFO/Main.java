import java.util.Scanner;

class PilaLIFO {
    private final char[] elementos;
    private int tope = -1; // TOPE < 0 → pila vacía

    public PilaLIFO(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        this.elementos = new char[capacidad];
    }

    public boolean estaVacia() {
        return tope < 0;
    }

    public boolean estaLlena() {
        return tope == elementos.length - 1;
    }

    public int size() {
        return tope + 1;
    }

    public void push(char dato) {
        if (estaLlena()) {
            throw new IllegalStateException("Overflow: la pila está llena");
        }
        elementos[++tope] = dato;
    }

    public char pop() {
        if (estaVacia()) {
            throw new IllegalStateException("Underflow: la pila está vacía");
        }
        return elementos[tope--];
    }

    public char peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos[tope];
    }

    // Saca (con pop) todos los elementos desde el TOPE hasta la posición pedida.
    // Devuelve los datos en el orden en que salieron: el último es el de la posición.
    public char[] sacarEnPosicion(int posicion) {
        if (estaVacia()) {
            throw new IllegalStateException("Underflow: la pila está vacía");
        }
        if (posicion < 0 || posicion > tope) {
            throw new IllegalArgumentException("Posición inválida. Debe estar entre 0 y " + tope);
        }
        int cantidad = tope - posicion + 1;
        char[] sacados = new char[cantidad];
        for (int i = 0; i < cantidad; i++) {
            sacados[i] = pop();
        }
        return sacados;
    }

    @Override
    public String toString() {
        if (estaVacia()) return "Pila vacía";
        StringBuilder sb = new StringBuilder();
        for (int i = tope; i >= 0; i--) {
            sb.append(" | ").append(elementos[i]).append(" |  <- [").append(i).append("]\n");
        }
        return sb.append("TOPE = ").append(tope).toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacidad = 0;
        while (capacidad <= 0) {
            System.out.print("Tamaño máximo de la pila: ");
            try {
                capacidad = Integer.parseInt(sc.nextLine());
                if (capacidad <= 0) {
                    System.out.println("Debe ser un número mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Escribe un número entero válido.");
            }
        }

        PilaLIFO pila = new PilaLIFO(capacidad);

        int opcion;
        do {
            System.out.println("\n===== MENÚ PILA =====");
            System.out.println("1. Push (meter dato)");
            System.out.println("2. Pop (sacar dato del tope)");
            System.out.println("3. Peek (ver el tope)");
            System.out.println("4. Mostrar pila");
            System.out.println("5. Sacar dato por posición");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0; // opción inválida
            }

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Escribe un carácter: ");
                        String texto = sc.nextLine();
                        if (texto.length() != 1) {
                            System.out.println("Debes escribir exactamente un carácter.");
                        } else {
                            pila.push(texto.charAt(0));
                            System.out.println("Agregado correctamente.");
                        }
                        break;
                    case 2:
                        System.out.println("Sacaste: " + pila.pop());
                        break;
                    case 3:
                        System.out.println("Tope: " + pila.peek());
                        break;
                    case 4:
                        System.out.println(pila);
                        break;
                    case 5:
                        if (pila.estaVacia()) {
                            System.out.println("Error: la pila está vacía");
                        } else {
                            System.out.println(pila);
                            System.out.print("¿De qué posición quieres sacar el dato?: ");
                            try {
                                int pos = Integer.parseInt(sc.nextLine());
                                char[] sacados = pila.sacarEnPosicion(pos);
                                for (int i = 0; i < sacados.length - 1; i++) {
                                    System.out.println("Se eliminó '" + sacados[i] + "' (estaba en el camino)");
                                }
                                System.out.println("Sacaste: " + sacados[sacados.length - 1]);
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
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);

        sc.close();
    }
}