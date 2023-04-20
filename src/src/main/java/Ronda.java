import java.util.ArrayList;

public class Ronda {
    private int numero;
    private ArrayList<Partido> partidos;
    private ArrayList<Pronostico> pronosticos;

    public Ronda(int numero) {
        partidos=new ArrayList<Partido>();
        pronosticos=new ArrayList<Pronostico>();
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Pronostico> getPronosticos() { return pronosticos; }

    public void setPronosticos(ArrayList<Pronostico> pronosticos) { this.pronosticos = pronosticos; }

    @Override
    public String toString() {
        return "Ronda: " + "numero: " + numero + '\n' + "pronosticos: " + pronosticos;
    }

    public void aciertoPorRonda(){
        int puntaje=0;
        String resultado="";
        String resultadop="";
        String nom="";
        String ape="";
        int dni=0;
        for (Partido p:partidos ) {

            if (p.getGolesEquipo1() == p.getGolesEquipo2()) {
                resultado = "Empate";
                //System.out.println("Partido= " + resultado);
            } else {
                if (p.getGolesEquipo1() < p.getGolesEquipo2()) {
                    resultado = "Gano " + p.getEquipo2();
                    //System.out.println("Partido= " + resultado);
                } else {
                    resultado = "Gano " + p.getEquipo1();
                    //System.out.println("Partido= " + resultado);
                }
            }

        }
        for (Pronostico p:pronosticos ) {
            nom=p.getApostador().getNombre();
            ape=p.getApostador().getApellido();
            dni=p.getApostador().getDni();

            if (p.getPartido().getGolesEquipo1() == p.getPartido().getGolesEquipo2()) {
                resultadop = "Empate";
                //System.out.println("Pronostico= " + resultadop);
            } else {
                if (p.getPartido().getGolesEquipo1() < p.getPartido().getGolesEquipo2()) {
                    resultadop = "Gano " + p.getPartido().getEquipo2();
                    //System.out.println("Pronostico= " + resultadop);
                } else {
                    resultadop = "Gano " + p.getPartido().getEquipo1();
                    //System.out.println("Pronostico= " + resultadop);
                }
            }

        }

        if(resultado.equals(resultadop)){
            puntaje+=1;
        }
        System.out.println("Su Puntaje por Apuesta es de:  " + puntaje);

    }
}
