package Proyecto01;
import java.util.Scanner;

public class Consultas {
    static Scanner scanner = new Scanner(System.in);

    static void MesasDisponibles(int numMesa, Mesa[] mesas){           
        int mesasLibres = 0;
            for (int i = 0; i < numMesa; i++){
            if (mesas[i].getEstado().equals("libre")){
                mesasLibres++;
            }
            
        }System.out.println("Hay "+ mesasLibres + " mesas disponibles");
    }
    static void MesasOcupadas(int numMesa, Mesa[] mesas){           
        int mesasOcupadas = 0;
            for (int i = 0; i < numMesa; i++){
            if (mesas[i].getEstado().equals("ocupada")){
                mesasOcupadas++;
            }
            
        }System.out.println("Hay "+ mesasOcupadas + " mesas disponibles");
    }
    static void buscarMesa(int numMesa, Mesa[] mesas){
        int mesaABuscar = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numMesa; i++){
            if (mesas[i].getNumMesa() == mesaABuscar){
                if (mesas[i].getEstado().equals("ocupada")){
                    System.out.println("Capacidad: "+ mesas[i].getCapacidad()+ ", estado: "+ mesas[i].getEstado()+ ", servicio: "+ mesas[i].getServicio()+", comensales: "+mesas[i].getComensales()) ;
                    break;
                }else{
                    System.out.println("Capacidad: "+ mesas[i].getCapacidad()+ ", estado: "+ mesas[i].getEstado());
                }    
                
            }
        }   
    }
    static void consultaDeClientes(Clientes clientes){
        System.out.println(clientes);
        clientes.CantidadTotal();
    }
}
