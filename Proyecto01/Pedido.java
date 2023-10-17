package Proyecto01;

import java.util.List;

public class Pedido {
    private int numeroPedido;
    private int numMesa;
    private List<String> platos;
    private String estado;

    private static int numeroPedidoCorrelativo = 1;
    private int numerodeMesa;

    public Pedido(List<String> platos, int numerodeMesa, String estado) {
        this.numeroPedido = numeroPedidoCorrelativo++;
        this.platos = platos;
        this.numerodeMesa = numerodeMesa;
        this.estado = estado;
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
