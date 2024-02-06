package projetotcc_v5.modelo;

public class Saida {
    private int idSaida;
    private Object idEntradaFK;
    private String horarioSaida;

    public int getIdSaida() {
        return idSaida;
    }

    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }

    public Object getIdEntradaFK() {
        return idEntradaFK;
    }

    public void setIdEntradaFK(Object idEntradaFK) {
        this.idEntradaFK = idEntradaFK;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}
