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

    public void agregarPartido(Partido unPartido){partidos.add(unPartido);}
    public void agregarPronostico(Pronostico unPronostico){pronosticos.add(unPronostico);}

    @Override
    public String toString() {
        return "Ronda: " + numero ;
    }

    public void aciertoPorRonda(){
        int puntaje=0;


        for (Pronostico p : pronosticos) {
            System.out.println("Apuesta  = "+p.getPartido());
            for (Partido pa:partidos ) {
                if(p.getPartido().getNumero()==pa.getNumero()){
                    System.out.println("Resultado= "+pa);
                    if(p.getPartido().getGanador().equals(pa.getGanador())){
                        puntaje=puntaje+1;
                    }

                }


            }
            System.out.println("su puntaje es= "+puntaje);

        }






    }

}
