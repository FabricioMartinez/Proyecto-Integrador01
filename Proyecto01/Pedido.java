package Proyecto01;


public class Pedido {
    private int numeroPedido;
    private int numMesa;
    private List<String> platos;
    private String estado;

    private static int numeroPedidoCorrelativo = 1;

    public Pedido(int numMesa, List<String> platos) {
        this.numMesa = numMesa;
        this.numeroPedido = numeroPedidoCorrelativo++;
        this.platos = platos;
        this.estado = "espera";
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public List<String> getPlatos() {
        return platos;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public void setPlatos(List<String> platos) {
        this.platos = platos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
