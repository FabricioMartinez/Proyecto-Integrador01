package Proyecto01;

public class Boleta {
    private int numBoleta;
    private int numPedido;
    private int montoAPagar;

    public Boleta(){

    }
    

    public Boleta(int numBoleta, int numPedido, int montoAPagar) {
        this.numBoleta = numBoleta;
        this.numPedido = numPedido;
        this.montoAPagar = montoAPagar;
    }


    public int getNumBoleta() {
        return numBoleta;
    }

    public void setNumBoleta(int numBoleta) {
        this.numBoleta = numBoleta;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(int montoAPagar) {
        this.montoAPagar = montoAPagar;
    }


    @Override
    public String toString() {
        return "Boleta nro. " + numBoleta + ", pedido nro. " + numPedido + ", monto a pagar: " + montoAPagar ;
    }
    
    
}
