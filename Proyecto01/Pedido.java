package Proyecto01;

import java.util.List;
public class Pedido {
    private int numeroPedido;
    private List<String> platos;
    private static int numeroPedidoCorrelativo = 1;
    private int numerodeMesa;
    private String estado;

    public Pedido(List<String> platos, int numerodeMesa, String estado) {
        this.numeroPedido = numeroPedidoCorrelativo++;
        this.platos = platos;
        this.numerodeMesa= numerodeMesa;
        this.estado=estado;
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

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static int getNumeroPedidoCorrelativo() {
        return numeroPedidoCorrelativo;
    }
    public static void setNumeroPedidoCorrelativo(int numeroPedidoCorrelativo) {
        Pedido.numeroPedidoCorrelativo = numeroPedidoCorrelativo;
    }

    public int getNumerodeMesa() {
        return numerodeMesa;
    }
    public void setNumerodeMesa(int numerodeMesa) {
        this.numerodeMesa = numerodeMesa;
    }

}
