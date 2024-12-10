public class PrestamosYDevoluciones {

    public static void registrarPrestamo(int indiceLibro) {
        if (indiceLibro >= 0 && indiceLibro < ListadoLibros.cantidadLibros) {
            if (ListadoLibros.esDisponible(indiceLibro)) {
                ListadoLibros.cambiarDisponibilidad(indiceLibro, false); // Cambia a "prestado"
                System.out.println("El libro '" + ListadoLibros.titulos[indiceLibro] + "' ha sido prestado.");
            } else {
                System.out.println("El libro '" + ListadoLibros.titulos[indiceLibro] + "' ya está prestado.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
    }

    public static void registrarDevolucion(int indiceLibro) {
        if (indiceLibro >= 0 && indiceLibro < ListadoLibros.cantidadLibros) {
            if (!ListadoLibros.esDisponible(indiceLibro)) {
                ListadoLibros.cambiarDisponibilidad(indiceLibro, true); // Cambia a "disponible"
                System.out.println("El libro '" + ListadoLibros.titulos[indiceLibro] + "' ha sido devuelto y está disponible.");
            } else {
                System.out.println("El libro '" + ListadoLibros.titulos[indiceLibro] + "' ya está disponible.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
    }
}
