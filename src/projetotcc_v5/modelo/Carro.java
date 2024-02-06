package projetotcc_v5.modelo;


public class Carro {
    private Object idCarro;
    private String nomeVeiculo;
    private String placaVeiculo;
    private String corVeiculo;
    private String observacoes;
    private String detalhesLavagem;
    private Object idClienteFK;
    
    public Object getIdCarro() {
        return idCarro;
    }
    
    public void setIdCarro(Object idCarro) {
        this.idCarro = idCarro;
    }
    
    public String getNomeVeiculo() {
        return nomeVeiculo;
    }
    
    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }
    
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }
    
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    
    public String getCorVeiculo(){
        return corVeiculo;
    }
    
    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }
    
    public String getObservacoes(){
        return observacoes;
    }
    
    public void setObservacoes(String observacoes){
        this.observacoes = observacoes;
    }
    
    public String getDetalhesLavagem(){
        return detalhesLavagem;
    }
    
    public void setDetalhesLavagem(String detalhesLavagem){
        this.detalhesLavagem = detalhesLavagem;
    }
    
    public Object getIdClienteFK(){
        return idClienteFK;
    }
    
    public void setIdClienteFK(Object idClienteFK){
        this.idClienteFK = idClienteFK;
    }
}
