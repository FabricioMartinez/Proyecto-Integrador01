package Proyecto01;

import java.util.Scanner;

public class ServicioMesas {
    static Scanner scanner = new Scanner(System.in);
    static void OcuparMesa(int numMesa, Mesa[] mesas) {
        System.out.println("Ingrese el número de comensales: ");
        int numComensales = scanner.nextInt();
        scanner.nextLine();
        if (Consultas.MesasDisponibles(numMesa, mesas) != 0){
            System.out.println("¿Cuál mesa desea ocupar?");
            int elegirMesa = scanner.nextInt();
            scanner.nextLine();
            if (mesas[elegirMesa].getCapacidad() >= numComensales && mesas[elegirMesa].getEstado().equals("libre")){
                mesas[elegirMesa].setEstado("ocupada");
                mesas[elegirMesa].setServicio("espera");
                mesas[elegirMesa].setComensales(numComensales);
                System.out.println("Ahora la mesa "+ mesas[elegirMesa].getNumMesa()+ " esta ocupada y esperando a ser atendida.");
            }else{
                System.out.println("Esa mesa no esta disponible.");
            }
            }else{
                System.out.println("No hay mesas disponibles.");
            }
        }
    }

    