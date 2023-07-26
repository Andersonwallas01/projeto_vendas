package entities;

public class OrdemItem {

    private Integer quantidade;
    private Double preco;
    private Produto product;

    public OrdemItem(){
    }

    public OrdemItem(Integer quantidade, Double preco, Produto product) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.product = product;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProduct() {
        return product;
    }

    public void setProduct(Produto product) {
        this.product = product;
    }

    public double SubTotal(){
        return quantidade * preco;
    }
    @Override
    public String toString() {
        return getProduct().getNome()
                + ", $"
                + String.format("%.3f", preco)
                + ", Quantidade: "
                + quantidade
                + ", Subtotal: $"
                + String.format("%.3f",  SubTotal());
    }
}
