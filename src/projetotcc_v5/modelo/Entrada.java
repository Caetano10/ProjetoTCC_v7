package projetotcc_v5.modelo;


public class Entrada {
    private int idEntrada;
    private String placaVeiculo;
    private String nomeCliente;
    private String dataEntrada;
    private Object idClienteFK;

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Object getIdClienteFK() {
        return idClienteFK;
    }

    public void setIdClienteFK(Object idClienteFK) {
        this.idClienteFK = idClienteFK;
    }
}
