import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CrearCSVPartidos {
    public static void main(String[] args) {

        String equipo1 = "Argentina"; //por ahora usamos dos strings fijos, luego cambiamos a array para aumentar la cantidad de equipos
        String equipo2 = "Brasil";

        int golesEquipo1 = resultadoAleatorio(); //generamos los goles aleatoriamente
        int golesEquipo2 = resultadoAleatorio();

        String nombreArchivo = equipo1 + " vs " + equipo2 + ".csv"; //Crear el nombre del archivo CSV y la estructura del mismo
        String contenidoArchivo = equipo1 + "," + golesEquipo1 + "," + equipo2 + "," + golesEquipo2;

        try {
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.append(contenidoArchivo);
            writer.flush();
            writer.close();

            System.out.println("El archivo " + nombreArchivo + " ha sido creado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int resultadoAleatorio() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(11); //Genera un número aleatorio entre 0 y 10 para la cantidad de goles de cada equipo
    }
}

