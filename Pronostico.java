public class Pronostico {
    private Partido partido;
    private Persona apostador;

    public Pronostico(Partido partido, Persona apostador) {
        this.partido = partido;
        this.apostador = apostador;
    }

    public String toString() {
        String var10000 = String.valueOf(this.partido);
        return "Pronostico{partido=" + var10000 + ", apostador=" + String.valueOf(this.apostador) + "}";
    }

    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Persona getApostador() {
        return this.apostador;
    }

    public void setApostador(Persona apostador) {
        this.apostador = apostador;
    }
}
