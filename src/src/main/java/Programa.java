import java.sql.*;
//import java.util.Scanner;
import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.ArrayList;


public class Programa {
    public static void main(String[] args) throws IOException, SQLException {


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Torneo", "root", "abrilyrocio123456");

        Statement st = connection.createStatement();
        Statement st1 = connection.createStatement();
        Statement st2 = connection.createStatement();

        ResultSet Rr = st.executeQuery("SELECT * FROM Resultados");
        ResultSet Rs = st1.executeQuery("SELECT * FROM Resultados");
        ResultSet Ap = st2.executeQuery("SELECT * FROM Apuestas");


        ArrayList<Partido> partidos = new ArrayList<Partido>();
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();


        Rr.next();
        int ron = Rr.getInt("Ronda");
        Ronda ronda = new Ronda (ron);

        while (Rs.next()) {
            String e1 = Rs.getString("Equipo1");
            int goles1 = Rs.getInt("Goles1");
            String e2 = Rs.getString("Equipo2");
            int goles2 = Rs.getInt("Goles2");



            Equipo equipo1 = new Equipo(e1);
            Equipo equipo2 = new Equipo(e2);

            Partido partido1 = new Partido(equipo1, equipo2, goles1, goles2);

            partidos.add(partido1);

            ronda.setPartidos(partidos);

        }

        while (Ap.next()) {
            String nom = Ap.getString("Nombre");
            String ape = Ap.getString("Apellido");
            int dni = Ap.getInt("Dni");
            String e1 = Ap.getString("Equipo1");
            int goles1 = Ap.getInt("Goles1");
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
        ronda.aciertoPorRonda();

        Rr.close();
        Rs.close();
        Ap.close();

        connection.close();


    }


}
