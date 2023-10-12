package Proyecto01;

import java.util.Scanner;


public class RegistrodeMesa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar el numero de mesas del restaurante: ");
        int numMesa= scanner.nextInt();
        scanner.nextLine();
        Mesa[] mesas= new Mesa[numMesa];
        int pedidoActual=1;

        for (int i = 0; i < numMesa; i++) {
            if (i<numMesa * 0.3) {
                mesas[i]= new Mesa(i+1, 2);
            } else {
                mesas[i]=new Mesa(i+1, 4);
            }
        }
        for (Mesa mesa : mesas) {
            System.out.println(mesa);
        }

        System.out.println("Ingrese la cantidad de platos disponibles: ");
        int numPlatos= scanner.nextInt();
        Platos[] platos= new Platos[numPlatos];

        for (int i = 0; i < numPlatos; i++) {
            System.out.println("Ingresar nombre del plato: ");
            String name= scanner.next();
            System.out.println("Ingresar precio del plato: ");
            double price= scanner.nextDouble();
            platos[i]= new Platos(i+1, name  , price);
        }
        for (Platos platos2 : platos) {
            System.out.println(platos2);
        }
    }
}
