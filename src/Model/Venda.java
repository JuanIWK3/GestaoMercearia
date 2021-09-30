
package Model;

import java.util.Date;
import java.util.List;

public class Venda {
    
    //Atributos
    
    private int idVenda;
    private List<Vendido> carrinho;
    private Date dataVenda;
    private Cliente cliente;
    private double valorTotal;
    
    //Constructor

    public Venda() {
    }

    public Venda(int idVenda, List<Vendido> carrinho, Date dataVenda, Cliente cliente, double valorTotal) {
        this.idVenda = idVenda;
        this.carrinho = carrinho;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
