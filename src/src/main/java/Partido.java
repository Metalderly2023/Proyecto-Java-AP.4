public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;

    private int golesEquipo1;
    private int golesEquipo2;

    private String ganador;

    private int numero;

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, String ganador, int numero) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.ganador = ganador;
        this.numero = numero;
    }
    public String toString() {

        return "" + equipo1 +" "+  golesEquipo1 + " vs " + equipo2 +" "+  golesEquipo2 +" "+ganador ;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }


}
