import java.sql.*;
//import java.util.Scanner;
import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.ArrayList;


public class Programa {
    public static void main(String[] args) throws IOException, SQLException {


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Prode_BD", "root", "Oedsoltero*/40");

        Statement st = connection.createStatement();
        ResultSet Ap = st.executeQuery("SELECT * FROM Apuestas");
        ResultSet Rs = st.executeQuery("SELECT * FROM Resultados");


        ArrayList<Partido> partidos = new ArrayList<Partido>();
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();



        Ronda ronda = new Ronda (1);

        while (Rs.next()) {
            String e1 = Rs.getString("Equipo1");
            int goles1 = Rs.getInt("Goles1");
            String e2 = Rs.getString("Equipo2");
            int goles2 = Rs.getInt("Goles2");


            Equipo equipo1 = new Equipo(Rs.getString("Equipo1"));
            Equipo equipo2 = new Equipo(Rs.getString("Equipo2"));

            Partido partido1 = new Partido(equipo1, equipo2, goles1, goles2);

            partidos.add(partido1);

            ronda.setPartidos(partidos);
        }

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
        Rs.close();
        Ap.close();

        connection.close();


    }


}
