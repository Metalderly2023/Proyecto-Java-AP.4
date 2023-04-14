public class Pronostico {
    private Partido partido;
    private Persona apostador;

    public Pronostico(Partido partido, Persona apostador) {
        this.partido = partido;

        this.apostador= apostador;
    }

    @Override
    public String toString() {
        return "Pronostico{" +
                "partido=" + partido +
                ", apostador=" + apostador +
                '}';
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Persona getApostador() {
        return apostador;
    }

    public void setApostador(Persona apostador) {
        this.apostador = apostador;
    }
}
