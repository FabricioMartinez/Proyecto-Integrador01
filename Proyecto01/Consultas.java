package Proyecto01;
import java.util.Scanner;

public class Consultas {
    static Scanner scanner = new Scanner(System.in);

    static int MesasDisponibles(int numMesa, Mesa[] mesas){           
        int mesasLibres = 0;    
        for (int i = 0; i < numMesa; i++){
            if (mesas[i].getEstado().equals("libre")){
                System.out.println(mesas[i]);
                mesasLibres++;
            }
        }return mesasLibres;
    }
    static int MesasOcupadas(int numMesa, Mesa[] mesas){           
        int mesasOcupadas = 0;    
        for (int i = 0; i < numMesa; i++){
            if (mesas[i].getEstado().equals("ocupada")){
                System.out.println(mesas[i]);
                mesasOcupadas++;
            }
            
        }return mesasOcupadas;
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
                    break;
                }    
                
            }
        }   
    }
}
