package Proyecto01;

public class Consultas {
    static void MesasDisponibles(int numMesa, Mesa[] mesas){           
        int mesasLibres = 0;
            for (int i = 0; i < numMesa; i++){
            if (mesas[i].getEstado().equals("libre")){
                mesasLibres++;
            }
            
        }System.out.println("Hay "+ mesasLibres + " mesas disponibles");
    }
}
