package Proyecto01;
public class Platos{
    private int codigoPlato;
    private String descripcion;
    private float precio;

    public Platos(int codigoPlato, String descripcion, float precio){
        this.codigoPlato=codigoPlato;
        this.descripcion=descripcion;
        this.precio=precio;
    }
    public int getCodigoPlato() {
        return codigoPlato;
    }
    public void setCodigoPlato(int codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Plato [codigo="+codigoPlato+",  descripcion="+descripcion+", precio= "+precio+"]";
    }
}
