package Proyecto01;
public class ocuparMesa {

static void ocuparMesa(int numMesa, Mesa[] mesas) {
    System.out.println("Ingrese el número de comensales: ");
    int numComensales = scanner.nextInt();
    System.out.println("Mesa disponible para " + numComensales + " personas:");

    for (int i = 0; i < numMesa; i++) {
        if (mesas[i].getEstado().equals("libre") && mesas[i].getCapacidad() >= numComensales) {
            mesas[i].setEstado("ocupada");
            mesas[i].setServicio("espera");
            mesas[i].setComensales(numComensales);
            System.out.println("Mesa " + mesas[i].getNumMesa() + " ocupada.");
            break;
        }
    }

    System.out.println("No hay mesas disponibles para " + numComensales + " personas.");
}
}