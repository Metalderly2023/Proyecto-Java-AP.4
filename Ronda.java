import java.util.ArrayList;

public class Ronda {
    private String numero;
    private ArrayList<Partido> partidos = new ArrayList<>();

    public Ronda(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public ArrayList<Partido> getPartidos() {
        return this.partidos;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}
