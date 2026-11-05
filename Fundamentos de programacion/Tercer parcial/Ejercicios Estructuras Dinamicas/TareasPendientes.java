import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Tarea {
    private String identificador;
    private String descripcion;
    private String prioridad;
    private boolean completada;

    public Tarea(String identificador, String descripcion, String prioridad) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false; 
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        String estado = completada ? "[Completada]" : "[Pendiente]";
        return "ID: " + identificador + " | Descripción: " + descripcion + 
               " | Prioridad: " + prioridad + " | Estado: " + estado;
    }
}

public class TareasPendientes {

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

    public static String leerPrioridad(Scanner scanner) {
        String prioridad;
        while (true) {
            System.out.print("Ingrese prioridad (Alta, Media, Baja): ");
            prioridad = scanner.nextLine().trim();
            if (prioridad.equalsIgnoreCase("Alta") || 
                prioridad.equalsIgnoreCase("Media") || 
                prioridad.equalsIgnoreCase("Baja")) {
                return prioridad.substring(0, 1).toUpperCase() + prioridad.substring(1).toLowerCase();
            }
            System.out.println("Error: Prioridad no válida. Debe escribir exactamente Alta, Media o Baja.");
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

    public static Tarea buscarPorId(LinkedList<Tarea> lista, String id) {
        for (Tarea t : lista) {
            if (t.getIdentificador().equalsIgnoreCase(id)) {
                return t;
            }
        }
        return null;
    }

    public static Tarea crearTarea(Scanner scanner, LinkedList<Tarea> lista) {
        String id;
        while (true) {
            id = leerTextoNoVacio(scanner, "Ingrese identificador único de la tarea: ");
            if (buscarPorId(lista, id) != null) {
                System.out.println("Error: Ya existe una tarea registrada con ese identificador.");
            } else {
                break;
            }
        }
        String descripcion = leerTextoNoVacio(scanner, "Ingrese descripción de la tarea: ");
        String prioridad = leerPrioridad(scanner);
        return new Tarea(id, descripcion, prioridad);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Tarea> listaTareas = new LinkedList<>();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE TAREAS PENDIENTES ---");
            System.out.println("1. Agregar tarea al final");
            System.out.println("2. Agregar tarea al inicio");
            System.out.println("3. Insertar tarea en una posición específica");
            System.out.println("4. Eliminar tarea por identificador");
            System.out.println("5. Buscar tarea por descripción");
            System.out.println("6. Mostrar todas las tareas");
            System.out.println("7. Marcar una tarea como completada");
            System.out.println("8. Mostrar la primera y última tarea registrada");
            System.out.println("9. Recorrer la lista en orden inverso");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.println("\n--- Agregar Tarea al Final ---");
                    Tarea nueva = crearTarea(scanner, listaTareas);
                    listaTareas.addLast(nueva);
                    System.out.println("¡Tarea agregada al final exitosamente!");
                    break;
                }

                case 2: {
                    System.out.println("\n--- Agregar Tarea al Inicio ---");
                    Tarea nueva = crearTarea(scanner, listaTareas);
                    listaTareas.addFirst(nueva);
                    System.out.println("¡Tarea agregada al inicio exitosamente!");
                    break;
                }

                case 3: {
                    System.out.println("\n--- Insertar en Posición Específica ---");
                    if (listaTareas.isEmpty()) {
                        System.out.println("La lista está vacía. Se agregará como la primera tarea.");
                        Tarea nueva = crearTarea(scanner, listaTareas);
                        listaTareas.addFirst(nueva);
                    } else {
                        System.out.println("La lista actual tiene " + listaTareas.size() + " elementos (Posiciones válidas de 0 a " + listaTareas.size() + ").");
                        int pos = leerEntero(scanner, "Ingrese la posición donde desea insertar la tarea: ");
                        
                        if (pos < 0 || pos > listaTareas.size()) {
                            System.out.println("Error: Posición fuera de los límites válidos.");
                        } else {
                            Tarea nueva = crearTarea(scanner, listaTareas);
                            listaTareas.add(pos, nueva);
                            System.out.println("¡Tarea insertada en la posición " + pos + " exitosamente!");
                        }
                    }
                    break;
                }

                case 4: {
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        String idDel = leerTextoNoVacio(scanner, "Ingrese el identificador de la tarea a eliminar: ");
                        Tarea tareaDel = buscarPorId(listaTareas, idDel);
                        if (tareaDel != null) {
                            listaTareas.remove(tareaDel);
                            System.out.println("Tarea eliminada correctamente.");
                        } else {
                            System.out.println("No se encontró ninguna tarea con ese identificador.");
                        }
                    }
                    break;
                }

                case 5: {
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        String busqueda = leerTextoNoVacio(scanner, "Ingrese el texto o palabra a buscar en la descripción: ").toLowerCase();
                        boolean encontrada = false;
                        System.out.println("\n--- RESULTADOS DE BÚSQUEDA ---");
                        for (int i = 0; i < listaTareas.size(); i++) {
                            Tarea t = listaTareas.get(i);
                            if (t.getDescripcion().toLowerCase().contains(busqueda)) {
                                System.out.println("Posición [" + i + "] -> " + t);
                                encontrada = true;
                            }
                        }
                        if (!encontrada) {
                            System.out.println("No se encontraron tareas que coincidan con esa descripción.");
                        }
                    }
                    break;
                }

                case 6: {
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        System.out.println("\n--- LISTA DE TAREAS ---");
                        for (int i = 0; i < listaTareas.size(); i++) {
                            System.out.println(i + ". " + listaTareas.get(i));
                        }
                    }
                    break;
                }

                case 7: {
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        String idComp = leerTextoNoVacio(scanner, "Ingrese el identificador de la tarea a marcar como completada: ");
                        Tarea tareaComp = buscarPorId(listaTareas, idComp);
                        if (tareaComp != null) {
                            tareaComp.setCompletada(true);
                            System.out.println("¡Tarea marcada como completada exitosamente!");
                        } else {
                            System.out.println("No se encontró ninguna tarea con ese identificador.");
                        }
                    }
                    break;
                }

                case 8: {
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        System.out.println("\n--- EXTREMOS DE LA LISTA ---");
                        System.out.println("Primera tarea: " + listaTareas.getFirst());
                        System.out.println("Última tarea:  " + listaTareas.getLast());
                    }
                    break;
                }

                case 9: {
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        System.out.println("\n--- RECORRIDO EN ORDEN INVERSO ---");
                        Iterator<Tarea> inverso = listaTareas.descendingIterator();
                        int contador = listaTareas.size() - 1;
                        while (inverso.hasNext()) {
                            System.out.println("Posición [" + contador + "] -> " + inverso.next());
                            contador--;
                        }
                    }
                    break;
                }

                case 10: {
                    System.out.println("Saliendo del sistema de gestión de tareas...");
                    break;
                }

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 10);

        scanner.close();
    }
}