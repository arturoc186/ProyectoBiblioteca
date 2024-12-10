public class PrestamosYDevoluciones {

    public static boolean esDisponible(int indiceLibro) {
        return disponibilidad[tituloLibro];
    }

    public static void cambiarDisponibilidad(int indiceLibro, boolean estado) {
        disponibilidad[tituloLibro] = estado;
        estados[tituloLibro] = estado ? "Disponible" : "Prestado";
    }
}

   public static void registrarPrestamo(int tituloLibro) {
        if (tituloLibro >= 0 && tituloLibro < disponibilidad.length) {
            if (disponibilidad[tituloLibro]) {
                disponibilidad[tituloLibro] = false; // Cambia el estado a "prestado"
                estados[tituloLibro] = "Prestado";
                System.out.println("El libro en el título " + tituloLibro + " ha sido prestado.");
            } else {
                System.out.println("El libro en el título " + tituloLibro + " ya está prestado.");
            }
        } else {
            System.out.println("Título de libro inválido.");
        }
    }


    public static void registrarDevolucion(int tituloLibro) {
        if (tituloLibro >= 0 && tituloLibro < disponibilidad.length) {
            if (!disponibilidad[tituloLibro]) {
                disponibilidad[tituloLibro] = true; // Cambia el estado a "disponible"
                estados[tituloLibro] = "Disponible";
                System.out.println("El libro en el título " + tituloLibro + " ha sido devuelto y está disponible.");
            } else {
                System.out.println("El libro en el título " + tituloLibro + " ya está disponible.");
            }
        } else {
            System.out.println("Título de libro inválido.");
        }
    }
