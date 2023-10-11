package Proyecto01;

import java.util.Scanner;


public class RegistrodeMesa {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Ingresar el numero de mesas del restaurante: ");
        int numMesa= scanner.nextInt();
        Mesa[] mesas= new Mesa[numMesa];
        int pedidoActual=1;

        for (int i = 0; i < numMesa; i++) {
            if (i<numMesa * 0.3) {
                mesas[i]= new Mesa(i+1, 2);
            } else {
                mesas[i]=new Mesa(i+1, 4);
            }
        }
    }
}
