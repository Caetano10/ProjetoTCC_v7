package projetotcc_v5.modelo;

public class Endereco {
    private Object idEndereco;
    private String unidadeFederal;
    private String cidade;
    private String bairro;
    private String cep;
    private String rua;
    private int logradouroNum;
    private String complemento;
    private Funcionario idFuncionarioFK;
    private Fornecedor idFornecedorFK;

    public Fornecedor getIdFornecedorFK() {
        return idFornecedorFK;
    }

    public void setIdFornecedorFK(Fornecedor idFornecedorFK) {
        this.idFornecedorFK = idFornecedorFK;
    }

    public Funcionario getIdFuncionarioFK() {
        return idFuncionarioFK;
    }

    public void setIdFuncionarioFK(Funcionario idFuncionarioFK) {
        this.idFuncionarioFK = idFuncionarioFK;
    }

    public Object getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Object idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getUnidadeFederal() {
        return unidadeFederal;
    }

    public void setUnidadeFederal(String unidadeFederal) {
        this.unidadeFederal = unidadeFederal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getLogradouroNum() {
        return logradouroNum;
    }

    public void setLogradouroNum(int logradouroNum) {
        this.logradouroNum = logradouroNum;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
