import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    private int numeroTurno;
    private String nombre;

    public Cliente(int numeroTurno, String nombre) {
        this.numeroTurno = numeroTurno;
        this.nombre = nombre;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Turno: " + numeroTurno + " | Nombre: " + nombre;
    }
}

public class AtencionCliente {

    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Error: El campo no puede estar vacío. Intente de nuevo.");
        }
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                scanner.nextLine(); 
                return numero;
            } else {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                scanner.next();
            }
        }
    }

    public static Cliente buscarPorTurno(Queue<Cliente> cola, int turno) {
        for (Cliente c : cola) {
            if (c.getNumeroTurno() == turno) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Cliente> colaEspera = new LinkedList<>();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE ATENCIÓN DE CLIENTES ---");
            System.out.println("1. Registrar cliente (agregar al final de la cola)");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Mostrar siguiente cliente a atender (sin eliminar)");
            System.out.println("4. Mostrar todos los clientes pendientes");
            System.out.println("5. Consultar cuántos clientes están esperando");
            System.out.println("6. Cancelar un turno específico");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1: {
                    int turno = leerEntero(scanner, "Ingrese número de turno: ");
                    if (turno <= 0) {
                        System.out.println("Error: El número de turno debe ser mayor a 0.");
                        break;
                    }

                    if (buscarPorTurno(colaEspera, turno) != null) {
                        System.out.println("Error: Ya existe un cliente registrado con ese número de turno.");
                    } else {
                        String nombre = leerTextoNoVacio(scanner, "Ingrese nombre del cliente: ");
                        colaEspera.add(new Cliente(turno, nombre));
                        System.out.println("¡Cliente agregado al final de la cola exitosamente!");
                    }
                    break;
                }

                case 2: {
                    if (colaEspera.isEmpty()) {
                        System.out.println("No hay clientes en la cola de espera.");
                    } else {
                        Cliente atendido = colaEspera.poll();
                        System.out.println("¡Atendiendo al cliente: " + atendido + "!");
                    }
                    break;
                }

                case 3: {
                    if (colaEspera.isEmpty()) {
                        System.out.println("No hay clientes en la cola de espera.");
                    } else {
                        Cliente siguiente = colaEspera.peek();
                        System.out.println("Siguiente cliente a ser atendido: " + siguiente);
                    }
                    break;
                }

                case 4: {
                    if (colaEspera.isEmpty()) {
                        System.out.println("No hay clientes pendientes en la cola.");
                    } else {
                        System.out.println("\n--- LISTA DE CLIENTES PENDIENTES ---");
                        int contador = 1;
                        for (Cliente c : colaEspera) {
                            System.out.println(contador + ". " + c);
                            contador++;
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.println("Cantidad de clientes esperando: " + colaEspera.size());
                    break;
                }

                case 6: {
                    if (colaEspera.isEmpty()) {
                        System.out.println("No hay clientes en la cola de espera.");
                    } else {
                        int turnoCancel = leerEntero(scanner, "Ingrese el número de turno que desea cancelar: ");
                        Cliente clienteCancel = buscarPorTurno(colaEspera, turnoCancel);
                        if (clienteCancel != null) {
                            colaEspera.remove(clienteCancel);
                            System.out.println("Turno " + turnoCancel + " cancelado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún cliente con ese número de turno.");
                        }
                    }
                    break;
                }

                case 7: {
                    System.out.println("Saliendo del sistema de atención...");
                    break;
                }

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}