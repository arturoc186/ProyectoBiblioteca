public class Fase4MenuPrincipal {//6 warnings pero funciona
    // Arrays para almacenar los libros y su disponibilidad
    private static String[] titulos = new String[10];
    private static String[] autores = new String[10];
    private static String[] estados = new String[10];
    private static boolean[] disponibilidad = new boolean[10]; // Para saber si el libro está prestado o disponible
    private static int cantidadLibros = 0;

    // Imprimir el menú
    public static void Imprimirmenu() {
        System.out.println("---Menu principal---");
        System.out.println("1.Añadir libro");
        System.out.println("2.Listar libros");
        System.out.println("3.Buscar libro por titulo");
        System.out.println("4.Buscar libros por autor");
        System.out.println("5.Registrar prestamo");
        System.out.println("6.Registrar devolucion");
        System.out.println("7.Salir");
    }

    // Método estático para añadir un libro
    public static void anadirLibro(String titulo, String autor) {
        if (cantidadLibros < titulos.length) {
            titulos[cantidadLibros] = titulo;
            autores[cantidadLibros] = autor;
            estados[cantidadLibros] = "Disponible";
            disponibilidad[cantidadLibros] = true; // Inicialmente el libro está disponible
            cantidadLibros++;
            System.out.println("Libro añadido: " + titulo + " de " + autor);
        } else {
            System.out.println("No se puede añadir más libros. Inventario lleno.");
        }
    }

    // Método estático para listar los libros
    public static void listarLibros() {
        if (cantidadLibros == 0) {
            System.out.println("No hay libros en el inventario.");
        } else {
            System.out.println("Lista de libros:");
            for (int i = 0; i < cantidadLibros; i++) {
                System.out.println("Índice: " + i + ", Título: " + titulos[i] + ", Autor: " + autores[i] + ", Estado: " + estados[i]);
            }
        }
    }

    // Método estático para registrar un préstamo
    public static void registrarPrestamo(int indiceLibro) {
        if (indiceLibro >= 0 && indiceLibro < disponibilidad.length) {
            if (disponibilidad[indiceLibro]) {
                disponibilidad[indiceLibro] = false; // Cambia el estado a "prestado"
                estados[indiceLibro] = "Prestado";
                System.out.println("El libro en el índice " + indiceLibro + " ha sido prestado.");
            } else {
                System.out.println("El libro en el índice " + indiceLibro + " ya está prestado.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
    }


    public static void registrarDevolucion(int indiceLibro) {
        if (indiceLibro >= 0 && indiceLibro < disponibilidad.length) {
            if (!disponibilidad[indiceLibro]) {
                disponibilidad[indiceLibro] = true; // Cambia el estado a "disponible"
                estados[indiceLibro] = "Disponible";
                System.out.println("El libro en el índice " + indiceLibro + " ha sido devuelto y está disponible.");
            } else {
                System.out.println("El libro en el índice " + indiceLibro + " ya está disponible.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
    }


    public static void buscarPorTitulo(String tituloBuscado) {
        boolean encontrado = false;
        for (int i = 0; i < cantidadLibros; i++) {
            if (titulos[i].equalsIgnoreCase(tituloBuscado)) {  // Comparar de manera insensible a mayúsculas/minúsculas
                System.out.println("Libro encontrado:");
                System.out.println("Índice: " + i + ", Título: " + titulos[i] + ", Autor: " + autores[i] + ", Estado: " + estados[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró el libro con el título: " + tituloBuscado);
        }
    }


    public static void buscarPorAutor(String autorBuscado) {
        boolean encontrado = false;
        for (int i = 0; i < cantidadLibros; i++) {
            if (autores[i].equalsIgnoreCase(autorBuscado)) {
                System.out.println("Libro encontrado:");
                System.out.println("Índice: " + i + ", Título: " + titulos[i] + ", Autor: " + autores[i] + ", Estado: " + estados[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros del autor: " + autorBuscado);
        }
    }

    // Método estático para ejecutar las opciones del menú
    public static boolean ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Introduce el título del libro: ");
                String titulo = ConsoleReader.readString();
                System.out.print("Introduce el autor del libro: ");
                String autor = ConsoleReader.readString();
                anadirLibro(titulo, autor);
                break;

            case 2:
                listarLibros();
                break;

            case 3:
                System.out.print("Introduce el título del libro que deseas buscar: ");
                titulo = ConsoleReader.readString();
                buscarPorTitulo(titulo);
                break;

            case 4:
                System.out.print("Introduce el autor: ");
                autor = ConsoleReader.readString();
                buscarPorAutor(autor);
                break;

            case 5:
                System.out.print("Introduce el índice del libro a prestar: ");
                int indicePrestamo = ConsoleReader.readInt();
                registrarPrestamo(indicePrestamo);
                break;

            case 6:
                System.out.print("Introduce el índice del libro a devolver: ");
                int indiceDevolucion = ConsoleReader.readInt();
                registrarDevolucion(indiceDevolucion);
                break;

            case 7:
                System.out.println("Has salido del programa");
                return false;

            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
                break;
        }
        return true; // Seguir ejecutando menu
    }


    public static void main(String[] args) {

        boolean continuar = true;

        while (continuar) {
            Imprimirmenu();
            System.out.print("Selecciona una opción: ");
            int opcion = ConsoleReader.readInt();
            continuar = ejecutarOpcion(opcion);
        }
    }
}
