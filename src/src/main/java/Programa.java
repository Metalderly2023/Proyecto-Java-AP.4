import java.sql.*;
//import java.util.Scanner;
import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.ArrayList;


public class Programa {
    public static void main(String[] args) throws IOException, SQLException {
        /*
        Path archivo1=Paths.get("Resultados.csv");
        Path archivo2=Paths.get("Apuestas.csv");

        Scanner lector1 = new Scanner(archivo1);
        Scanner lector2 = new Scanner(archivo2);
        lector1.useDelimiter("[;]");
        lector2.useDelimiter("[;]");
        */

        Connection connection = DriverManager.getConnection("jdbc:mysql-server://localhost/Prode_BD", "deo", "29419977");

        Statement st = connection.createStatement();
        ResultSet Ap = st.executeQuery("SELECT * FROM Apuestas");
        ResultSet Rs = st.executeQuery("SELECT * FROM Resultados");


        ArrayList<Partido> partidos = new ArrayList<Partido>();
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();


        while (Rs.next()) {
            String e1 = Rs.getString("Equipo1");
            int goles1 = Rs.getInt("Goles");
            String e2 = Rs.getString("Equipo2");
            int goles2 = Rs.getInt("Goles2");

        ResultSet ron = st.executeQuery("SELECT * FROM Resultados");
        Ronda ronda = new Ronda(ron);
        /*

        while (lector1.hasNext()) {

            String e1=lector1.next();
            int goles1= lector1.nextInt();
            String e2=lector1.next();
            int goles2= lector1.nextInt();
        */
            Equipo equipo1 = new Equipo(Rs.getString("Equiupo1"));
            Equipo equipo2 = new Equipo(Rs.getString("Equipo2"));

            Partido partido1 = new Partido(equipo1, equipo2, goles1, goles2);

            partidos.add(partido1);

            ronda.setPartidos(partidos);
        }

        Rs.close();
        /*
        lector1.close();
        while (lector2.hasNext()) {
            String nom=lector2.next();
            String ape=lector2.next();
            int dni=lector2.nextInt();
            String e1=lector2.next();
            int goles1=lector2.nextInt();
            String e2=lector2.next();
            int goles2=lector2.nextInt();
        */
        while (Ap.next()) {
            String nom = Ap.getString("Nombre");
            String ape = Ap.getString("Apellido");
            int dni = Ap.getInt("Dni");
            String e1 = Ap.getString("Equipo1");
            int goles1 = Ap.getInt("Goles");
            String e2 = Ap.getString("Equipo2");
            int goles2 = Ap.getInt("Goles2");

            Equipo equipo1 = new Equipo(e1);
            Equipo equipo2 = new Equipo(e2);

            Persona apostador = new Persona(nom, ape, dni);

            Partido partido2 = new Partido(equipo1, equipo2, goles1, goles2);

            Pronostico pronostico = new Pronostico(partido2, apostador);

            pronosticos.add(pronostico);

            ronda.setPronosticos(pronosticos);
        }
        Ap.close();

        connection.close();


        /*ector2.close();

        ronda.aciertoPorRonda();
    }

         */
}
