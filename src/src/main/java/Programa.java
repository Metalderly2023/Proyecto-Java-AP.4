import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws IOException {
        Path archivo1=Paths.get("Resultados.csv");
        Path archivo2=Paths.get("Apuestas.csv");

        Scanner lector1=new Scanner(archivo1);
        Scanner lector2=new Scanner(archivo2);
        lector1.useDelimiter("[;]");
        lector2.useDelimiter("[;]");
        ArrayList<Partido> partidos=new ArrayList<>();
        ArrayList<Pronostico> pronosticos=new ArrayList<>();
        int ron=lector1.nextInt();
        Ronda ronda = new Ronda(ron);


        while (lector1.hasNext()) {

            String e1=lector1.next();
            int goles1= lector1.nextInt();
            String e2=lector1.next();
            int goles2= lector1.nextInt();

            Equipo equipo1 = new Equipo(e1);
            Equipo equipo2 = new Equipo(e2);

            Partido partido1 = new Partido(equipo1, equipo2,goles1,goles2);

            partidos.add(partido1);

           ronda.setPartidos(partidos);

        }

        lector1.close();
        while (lector2.hasNext()) {
            String nom=lector2.next();
            String ape=lector2.next();
            int dni=lector2.nextInt();
            String e1=lector2.next();
            int goles1=lector2.nextInt();
            String e2=lector2.next();
            int goles2=lector2.nextInt();


            Equipo equipo1 = new Equipo(e1);
            Equipo equipo2 = new Equipo(e2);

            Persona apostador = new Persona (nom,ape,dni);

            Partido partido2 = new Partido(equipo1, equipo2, goles1, goles2);

            Pronostico pronostico = new Pronostico(partido2, apostador);

            pronosticos.add(pronostico);

            ronda.setPronosticos(pronosticos);

        }
        lector2.close();

        ronda.aciertoPorRonda();
    }
}
