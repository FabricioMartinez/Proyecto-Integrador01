package Proyecto01;
public class Mesa {
    private int numMesa;
    private int capacidad;
    private String estado;
    private String servicio;
    private int comensales;

    public Mesa(int numMesa, int capacidad){
        this.numMesa= numMesa;
        this.capacidad= capacidad;
        this.estado= "libre";
        this.servicio="ninguno";
        this.comensales=0;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getComensales() {
        return comensales;
    }
    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumMesa() {
        return numMesa;
    }
    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public String getServicio() {
        return servicio;
    }
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    @Override
    public String toString(){
        return "Mesa [numero de mesa"+ numMesa+ ", capacidad "+capacidad+", estado: "+ estado+ ", servicio: "+ servicio+ ", comensales: "+comensales+"]";
    }
}
