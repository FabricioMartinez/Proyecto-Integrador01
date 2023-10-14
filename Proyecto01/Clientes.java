package Proyecto01;

public class Clientes {
    private int totalEspera;
    private int totalAtendidos;
    private int totalServidos;
    
    
    public Clientes(int totalEspera, int totalAtendidos, int totalSevidos) {
        this.totalEspera = totalEspera;
        this.totalAtendidos = totalAtendidos;
        this.totalServidos = totalSevidos;
    }
    public Clientes(){

    }

    public int getTotalEspera() {
        return totalEspera;
    }


    public void setTotalEspera(int totalEspera) {
        this.totalEspera = totalEspera;
    }


    public int getTotalAtendidos() {
        return totalAtendidos;
    }


    public void setTotalAtendidos(int totalAtendidos) {
        this.totalAtendidos = totalAtendidos;
    }


    public int getTotalServidos() {
        return totalServidos;
    }


    public void setTotalServidos(int totalSevidos) {
        this.totalServidos = totalSevidos;
    }

    @Override
    public String toString() {
        return "Clientes en espera: " + totalEspera + ", atendidos: " + totalAtendidos + ", servidos: "+ totalServidos;
    }

    public void CantidadTotal() {
        int total = totalAtendidos + totalEspera + totalServidos;
        System.out.println("Hay "+ total + " clientes actualmente en el restaurante.");
    }
}
