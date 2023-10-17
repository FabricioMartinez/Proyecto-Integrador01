package Proyecto01;

import java.util.List;
public class Pedido {
    private int numeroPedido;
    private int numMesa;
    private List<String> platos;
    private String estado;

    private static int numeroPedidoCorrelativo = 1;

    public Pedido(List<String> platos) {
        this.numeroPedido = numeroPedidoCorrelativo++;
        this.platos = platos;
    }

    
    public int getNumMesa() {
        return numMesa;
    }


    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public int getNumeroPedido() {
        return numeroPedido;
    }


    public List<String> getPlatos() {
        return platos;
    }


    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    

    public void setPlatos(List<String> platos) {
        this.platos = platos;
    }

}
