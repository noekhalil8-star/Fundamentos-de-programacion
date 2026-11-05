import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Estudiante {
    private String matricula;
    private String nombre;
    private double calificacion;

    public Estudiante(String matricula, String nombre, double calificacion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nombre: " + nombre + " | Calificación: " + calificacion;
    }
}

public class AdministracionEstudiantes {

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

    public static Estudiante buscarPorMatricula(ArrayList<Estudiante> lista, String matricula) {
        for (Estudiante e : lista) {
            if (e.getMatricula().equalsIgnoreCase(matricula)) {
                return e;
            }
        }
        return null;
    }

    public static double leerCalificacion(Scanner scanner) {
        double calificacion = -1;
        while (calificacion < 0 || calificacion > 10) {
            System.out.print("Ingrese calificación (0 - 10): ");
            if (scanner.hasNextDouble()) {
                calificacion = scanner.nextDouble();
                if (calificacion < 0 || calificacion > 10) {
                    System.out.println("La calificación debe estar entre 0 y 10.");
                }
            } else {
                System.out.println("Ingrese un valor numérico válido.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return calificacion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE ADMINISTRACIÓN DE ESTUDIANTES ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante por matrícula");
            System.out.println("4. Modificar calificación");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Mostrar promedio general del grupo");
            System.out.println("7. Estudiante(s) con calificación más alta y más baja");
            System.out.println("8. Mostrar estudiantes con calificación mayor a 9");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    String matricula = leerTextoNoVacio(scanner, "Ingrese matrícula: ");

                    if (buscarPorMatricula(listaEstudiantes, matricula) != null) {
                        System.out.println("Error: Ya existe un estudiante registrado con esa matrícula.");
                    } else {
                        String nombre = leerTextoNoVacio(scanner, "Ingrese nombre: ");
                        double calificacion = leerCalificacion(scanner);

                        listaEstudiantes.add(new Estudiante(matricula, nombre, calificacion));
                        System.out.println("¡Estudiante registrado exitosamente!");
                    }
                    break;
                }

                case 2: {
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        Collator collator = Collator.getInstance(Locale.forLanguageTag("es-MX"));
                        collator.setStrength(Collator.PRIMARY);
                        listaEstudiantes.sort((e1, e2) -> collator.compare(e1.getNombre(), e2.getNombre()));

                        System.out.println("\n--- LISTA DE ESTUDIANTES (ORDEN ALFABÉTICO EN ESPAÑOL) ---");
                        for (Estudiante e : listaEstudiantes) {
                            System.out.println(e);
                        }
                    }
                    break;
                }

                case 3: {
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        String matBuscar = leerTextoNoVacio(scanner, "Ingrese la matrícula a buscar: ");
                        Estudiante encontrado = buscarPorMatricula(listaEstudiantes, matBuscar);
                        if (encontrado != null) {
                            System.out.println("Estudiante encontrado: " + encontrado);
                        } else {
                            System.out.println("No se encontró ningún estudiante con esa matrícula.");
                        }
                    }
                    break;
                }

                case 4: {
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        String matMod = leerTextoNoVacio(scanner, "Ingrese la matrícula del estudiante a modificar: ");
                        Estudiante estMod = buscarPorMatricula(listaEstudiantes, matMod);
                        if (estMod != null) {
                            double nuevaCal = leerCalificacion(scanner);
                            estMod.setCalificacion(nuevaCal);
                            System.out.println("Calificación actualizada correctamente.");
                        } else {
                            System.out.println("No se encontró ningún estudiante con esa matrícula.");
                        }
                    }
                    break;
                }

                case 5: {
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        String matDel = leerTextoNoVacio(scanner, "Ingrese la matrícula del estudiante a eliminar: ");
                        Estudiante estDel = buscarPorMatricula(listaEstudiantes, matDel);
                        if (estDel != null) {
                            listaEstudiantes.remove(estDel);
                            System.out.println("Estudiante eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún estudiante con esa matrícula.");
                        }
                    }
                    break;
                }

                case 6: {
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        double suma = 0;
                        for (Estudiante e : listaEstudiantes) {
                            suma += e.getCalificacion();
                        }
                        double promedio = suma / listaEstudiantes.size();
                        System.out.printf("El promedio general del grupo es: %.2f\n", promedio);
                    }
                    break;
                }

                case 7: {
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        double maxCal = listaEstudiantes.get(0).getCalificacion();
                        double minCal = listaEstudiantes.get(0).getCalificacion();

                        for (Estudiante e : listaEstudiantes) {
                            if (e.getCalificacion() > maxCal) {
                                maxCal = e.getCalificacion();
                            }
                            if (e.getCalificacion() < minCal) {
                                minCal = e.getCalificacion();
                            }
                        }

                        System.out.println("\n--- ESTUDIANTE(S) CON CALIFICACIÓN MÁS ALTA (" + maxCal + ") ---");
                        for (Estudiante e : listaEstudiantes) {
                            if (e.getCalificacion() == maxCal) {
                                System.out.println(e);
                            }
                        }

                        System.out.println("\n--- ESTUDIANTE(S) CON CALIFICACIÓN MÁS BAJA (" + minCal + ") ---");
                        for (Estudiante e : listaEstudiantes) {
                            if (e.getCalificacion() == minCal) {
                                System.out.println(e);
                            }
                        }
                    }
                    break;
                }

                case 8: {
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        boolean hayMayores = false;
                        System.out.println("\n--- ESTUDIANTES CON CALIFICACIÓN MAYOR A 9 ---");
                        for (Estudiante e : listaEstudiantes) {
                            if (e.getCalificacion() > 9) {
                                System.out.println(e);
                                hayMayores = true;
                            }
                        }
                        if (!hayMayores) {
                            System.out.println("No hay estudiantes con calificación mayor a 9.");
                        }
                    }
                    break;
                }

                case 9: {
                    System.out.println("Saliendo del sistema...");
                    break;
                }

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}