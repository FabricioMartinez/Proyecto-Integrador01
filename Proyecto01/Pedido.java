package Proyecto01;

import java.util.List;
public class Pedido {
    private int numeroPedido;
    private List<String> platos;

    private static int numeroPedidoCorrelativo = 1;

    public Pedido(List<String> platos) {
        this.numeroPedido = numeroPedidoCorrelativo++;
        this.platos = platos;
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
