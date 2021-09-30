
package Model;

public class Vendido {
    
    //Atributos
    
    private int quantVendida;
    private double precoVenda;
    private Estoque produtoEstoque;
    
    //Constructor

    public Vendido() {
    }

    public Vendido(int quantVendida, double precoVenda, Estoque carrinho) {
        this.quantVendida = quantVendida;
        this.precoVenda = precoVenda;
        this.produtoEstoque = carrinho;
    }
    
    //Encapsulamento

    public void setQuantVendida(int quantVendida) {
        this.quantVendida = quantVendida;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantVendida() {
        return quantVendida;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
     
}
