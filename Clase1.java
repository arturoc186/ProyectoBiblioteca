public class ListadoLibros {

    private static String[] titulos = new String[10];
    private static String[] autores = new String[10];
    private static String[] estados = new String[10];
    private static int cantidadLibros = 0;

    public static void anadirLibro(String titulo, String autor) {
        if (cantidadLibros < titulos.length) {
            titulos[cantidadLibros] = titulo;
            autores[cantidadLibros] = autor;
            estados[cantidadLibros] = "Disponible";
            cantidadLibros++;
            System.out.println("Libro añadido: " + titulo + " de " + autor);
        } else {
            System.out.println("No se puede añadir más libros. Inventario lleno.");
        }
    }
    
    public static void listarLibros() {
        if (cantidadLibros == 0) {
            System.out.println("No hay libros en el inventario.");
        } else {
            System.out.println("Lista de libros:");
            for (int i = 0; i < cantidadLibros; i++) {
                System.out.println("Título: " + titulos[i] + ", Autor: " + autores[i] + ", Estado: " + estados[i]);
            }
        }
    }
}

