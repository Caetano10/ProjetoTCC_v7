package projetotcc_v5.modelo;

public class ProdutoEstoque {
    private Object idProdEstoque;
    private String nomeProd;
    private String codBarras;
    private int qtde;
    private String dataEntrada;
    private Object idFornecedorFK;
    private Fornecedor fornecedor;

    public Object getIdProdEstoque() {
        return idProdEstoque;
    }

    public void setIdProdEstoque(Object idProdEstoque) {
        this.idProdEstoque = idProdEstoque;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }


    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }


    public Object getIdFornecedorFK() {
        return idFornecedorFK;
    }

    public void setIdFornecedorFK(Object idFornecedorFK) {
        this.idFornecedorFK = idFornecedorFK;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
