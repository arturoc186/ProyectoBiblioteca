import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }

    public static int readInt(int inicio, int fin) {
        while (true) {
            int a = readInt();
            if (a>=inicio && a <=fin)
                return a;
            else
                System.out.println("Entrada no válida. Intenta de nuevo.");
        }
    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("Error de lectura. Intenta de nuevo.");
            }
        }
    }
}
