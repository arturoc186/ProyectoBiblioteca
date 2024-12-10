

public class Fase4MenuPrincipal {
    public static void Imprimirmenu(){
        System.out.println("---Menu principal---");
        System.out.println("1.Añadir libro");
        System.out.println("2.Listar libros");
        System.out.println("3.Buscar libro por titulo");
        System.out.println("4.Buscar libros por autor");
        System.out.println("5.Registrar prestamo");
        System.out.println("6.Registrar devolucion");
        System.out.println("7.Salir");

    }
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

                System.out.print("Introduce el título del libro a prestar: ");
                titulo = ConsoleReader.readString();
                registrarPrestamo(titulo);
                break;

            case 6:

                System.out.print("Introduce el título del libro a devolver: ");
                titulo = ConsoleReader.readString();
                registrarDevolucion(titulo);
                break;

            case 7:
                // Salir del programa
                System.out.println("Has salido del programa");
                return false;
            default:

                System.out.println("Opción no válida. Intenta de nuevo.");
                break;
        }
        return true; // Continuar ejecutando el menú
    }
    public static void main(String[] args) {
        Imprimirmenu();
        boolean continuar=true;

        while (continuar) {

            Imprimirmenu();


            System.out.print("Selecciona una opción: ");
            int opcion = ConsoleReader.readInt();


            continuar = ejecutarOpcion(opcion);
        }


    }
}