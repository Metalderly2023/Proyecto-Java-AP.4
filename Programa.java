import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws IOException  {

        Path archivo1= Paths.get("Argentina vs Brasil.csv");
        Scanner lector=new Scanner(archivo1);
        while (hasnext()) {
            String e1=lector.next();
            int n1=lector.nextint();
            String e2=lector.next();
            int n2=lector.nextint();
            Equipo equipo1 = new Equipo(e1);
            Equipo equipo2 = new Equipo(e2);

            Partido partido1 = new Partido(equipo1, equipo2, n1, n2);
        }
        Ronda ronda=new Ronda("1");

        ArrayList<Partido> partidos=new ArrayList<>();
        partidos.add(partido1);

        ronda.setPartidos(partidos);

        Persona apostador=new Persona("Martin","Saez");

        Partido partido2=new Partido(equipo1,equipo2,2,2);

        Pronostico pronostico=new Pronostico(partido2,apostador);

        String resultado;String resultadop;

        if (partido1.getGolesEquipo1()==partido1.getGolesEquipo2()){
            resultado= "Empate";
            System.out.println("Partido= " +resultado);
        }else {
            if(partido1.getGolesEquipo1()<partido1.getGolesEquipo2()){
                resultado="Gano "+equipo2;
                System.out.println("Partido= " +resultado);
            }else {
                resultado="Gano "+equipo1;
                System.out.println("Partido= " +resultado);
            }
        }
        if (pronostico.getPartido().getGolesEquipo1()==pronostico.getPartido().getGolesEquipo2()){
            resultadop= "Empate";
            System.out.println("Pronostico= "+resultadop);
        }else {
            if(pronostico.getPartido().getGolesEquipo1()<pronostico.getPartido().getGolesEquipo2()){
                resultadop="Gano "+equipo2;
                System.out.println("Pronostico= "+resultadop);
            }else {
                resultadop="Gano "+equipo1;
                System.out.println("Pronostico= "+resultadop);
            }
        }
        int puntaje=0;
        if (resultado.equals(resultadop)){
             puntaje =+1;
        }
        System.out.println("Puntaje= " +puntaje);
    }
}
