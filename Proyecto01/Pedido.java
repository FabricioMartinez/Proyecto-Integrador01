package Proyecto01;

import java.util.List;

public class Pedido {
    private int numeroPedido;
    private int numMesa;
    private List<String> platos;
    private String estado;


    public Pedido(int numeroPedido, int numMesa, List<String> platos, String estado) {
        this.numeroPedido = numeroPedido;
        this.numMesa = numMesa;
        this.platos = platos;
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



}
