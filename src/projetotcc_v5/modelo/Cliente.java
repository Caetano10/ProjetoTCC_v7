package projetotcc_v5.modelo;

public class Cliente {
    private Object idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String celular;
    private Object dtcadastro;
    private String dataNascimento;

    public Object getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Object idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Object getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Object dtcadastro) {
        this.dtcadastro = dtcadastro;
    }
    
    
}
