package Proyecto01;

import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.Queue;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Restaurante {


    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar el número de mesas del restaurante: ");
        int numMesa = scanner.nextInt();
        scanner.nextLine();
        Mesa[] mesas = new Mesa[numMesa];
        Queue<Pedido> pedidosEnEspera = new ArrayDeque<>();
        Queue<Pedido> pedidosPreparacion = new ArrayDeque<>();
        Stack<Boleta> pagosRecibidos = new Stack<>();
        for (int i = 0; i < numMesa; i++) {
            if (i < numMesa * 0.3) {
                mesas[i] = new Mesa(i + 1, 2);
            } else {
                mesas[i] = new Mesa(i + 1, 4);
            }
        }
        System.out.println("Ingrese la cantidad de platos disponibles: ");
        int numPlatos = scanner.nextInt();
        Platos[] platos = new Platos[numPlatos];

        for (int i = 0; i < numPlatos; i++) {
            System.out.println("Ingresar nombre del plato: ");
            String name = scanner.next();
            System.out.println("Ingresar precio del plato: ");
            double price = scanner.nextDouble();
            platos[i] = new Platos(i + 1, name, price);
        }
        for (Platos plato : platos) {
            System.out.println(plato);
        }

        System.out.println("Ingrese el numero actual de clientes en espera.");
        int clientesEnEspera = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el numero actual de clientes atendidos.");
        int clientesAtendidos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el numero actual de clientes servidos.");
        int clientesServidos = scanner.nextInt();
        scanner.nextLine();
        Clientes clientes = new Clientes(clientesEnEspera, clientesAtendidos, clientesServidos);
        int pedidoActual = 1;
        boolean elegir = true;
        while (elegir) {
            System.out.println("Menu de opciones");
            System.out.println("1- Consultar Mesas disponibles");
            System.out.println("2- Consultar Mesas ocupadas");
            System.out.println("3- Consultar por numero de Mesa");
            System.out.println("4- Consultar por clientes.");
            System.out.println("5- Ocupar una mesa.");
            System.out.println("6- Atencion de mesas.");
            System.out.println("7- Preparacioin de pedido");
            System.out.println("8- Entrega de pedido");
            System.out.println("9- Pago de consumo");
            System.out.println("10- Control de ingresos de la jornada");
            System.out.println("11- Salir del menú");
            System.out.println("Elegir una opción:");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    restaurante.consultarMesaDisponibles(mesas);
                    break;
                case 2:
                    restaurante.consultarMesaOcupada(mesas);
                    break;
                case 3:
                    restaurante.consultarPorNumerodeMesa(mesas, numMesa);
                    break;
                case 4:
                    restaurante.consultaDeClientes(clientes);
                    break;
                case 5:
                    restaurante.OcuparMesa(numMesa, mesas);
                    break;
                case 6:
                    for (int i=0; i<numMesa; i++){
                        if (mesas[i].getServicio().equals("espera")){
                            restaurante.altaDePedido(mesas, platos, pedidoActual, numMesa, pedidosEnEspera);
                            mesas[i].setServicio("atendida");
                        }
                    }
                    break;
                case 7:
                    restaurante.prepararPedidos(pedidosEnEspera, pedidosPreparacion);
                    break;
                    
                    break;
                case 11:
                    elegir = false;
                    break;
            }
        }
        scanner.close();
    }

    public void consultarMesaDisponibles(Mesa[] mesas) {
        System.out.println("Mesas disponibles:");

        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("libre")) {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Capacidad " + mesa.getCapacidad());
            }
        }
    }

    public void consultarMesaOcupada(Mesa[] mesas) {
        System.out.println("Mesas ocupadas:");

        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("ocupada")) {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Comensales " + mesa.getComensales());
            }
        }
    }

    public void consultarPorNumerodeMesa(Mesa[] mesas, int numMesa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa número de mesa: ");
        int numerodeMesa = scanner.nextInt();
        boolean mesaEncontrada = false;

        for (Mesa mesa : mesas) {
            if (mesa.getNumMesa() == numerodeMesa) {
                System.out.println("Mesa ocupada");
                mesaEncontrada = true;
                break;
            }
        }

        if (!mesaEncontrada) {
            System.out.println("Mesa libre");
        }
        scanner.close();
    }

    public void consultaDeClientes(Clientes clientes) {
        System.out.println("Total de clientes en espera: " + clientes.getTotalEspera());
        System.out.println("Total de clientes atendidos: " + clientes.getTotalAtendidos());
        System.out.println("Total de clientes servidos: " + clientes.getTotalServidos());
        System.out.println("Total de clientes en el restaurante: " + consultarTotalClientes(clientes));
    }

    public int consultarTotalClientes(Clientes clientes) {
        return clientes.getTotalEspera() + clientes.getTotalAtendidos() + clientes.getTotalServidos();
    }

    public void OcuparMesa(int numMesa, Mesa[] mesas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de comensales: ");
        int numComensales = scanner.nextInt();
        scanner.nextLine();
        if (Consultas.MesasDisponibles(numMesa, mesas) != 0) {
            System.out.println("¿Cuál mesa desea ocupar?");
            int elegirMesa = scanner.nextInt();
            scanner.nextLine();
            if (mesas[elegirMesa].getCapacidad() >= numComensales && mesas[elegirMesa].getEstado().equals("libre")) {
                mesas[elegirMesa].setEstado("ocupada");
                mesas[elegirMesa].setServicio("espera");
                mesas[elegirMesa].setComensales(numComensales);
                System.out.println("Ahora la mesa " + mesas[elegirMesa].getNumMesa()
                        + " esta ocupada y esperando a ser atendida.");
            } else {
                System.out.println("Esa mesa no esta disponible.");
            }
        } else {
            System.out.println("No hay mesas disponibles.");
        }
        scanner.close();
    }


    public void altaDePedido(Mesa[] mesas, Platos[] platos, int pedidoActual, int numMesa, Queue<Pedido> pedidosEnEspera) {
        Scanner scanner = new Scanner(System.in);
        List<Mesa> mesasOcupadas = new ArrayList<>();
        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("ocupada")) {
                mesasOcupadas.add(mesa);
            }
        }

        if (mesasOcupadas.isEmpty()) {
            System.out.println("No hay mesas ocupadas para tomar pedidos.");
        }

        // Mostrar el menú de platos
        System.out.println("Menú de Platos:");
        for (Platos plato : platos) {
            System.out.println(plato.getCodigoPlato() + ". " + plato.getDescripcion() + " - Precio: " + plato.getPrecio());
        }

        // Obtener el número de mesa
        System.out.println("Ingrese el número de mesa para el pedido:");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine();

        // Verificar si el número de mesa es válido
        boolean mesaValida = false;
        for (Mesa mesa : mesasOcupadas) {
            if (mesa.getNumMesa() == numeroMesa) {
                mesaValida = true;
                break;
            }
        }

        if (!mesaValida) {
            System.out.println("El número de mesa no es válido o no está ocupado.");
        }

        // Crear la lista de los platos a elegir
        ArrayList<String> ordenDePlatos = new ArrayList<String>();

        // Elegir platos para el pedido
        System.out.println("Seleccione hasta 4 platos ingresando sus números (0 para finalizar):");
        int platoSeleccionado;
        int contadorPlatos = 0;

        while (contadorPlatos < 5) {
            platoSeleccionado = scanner.nextInt();
            scanner.nextLine();
            if (platoSeleccionado == 0) {
                break;
            } else {
                for (Platos plato : platos) {
                    if (plato.getCodigoPlato() == platoSeleccionado) {
                        ordenDePlatos.add(plato.getDescripcion());
                        break;
                    }
                    contadorPlatos++;
                }

            }
        }
        // Crea el pedido
        Pedido nuevoPedido = new Pedido(pedidoActual, numMesa, ordenDePlatos, "espera");
        pedidoActual++;
        pedidosEnEspera.add(nuevoPedido);
        scanner.close();
    }
}


//prepararPedidos
public void prepararPedidos(Queue<Pedido> pedidosEnEspera, Queue<Pedido> pedidosPreparacion) {
    int maxPedidosAProcesar = Math.min(5, pedidosEnEspera.size());

    for (int i = 0; i < maxPedidosAProcesar; i++) {
        Pedido pedido = pedidosEnEspera.poll(); 
        pedido.setEstado("Preparando");
        pedidosPreparacion.offer(pedido); 
    }

    System.out.println("Se han preparado " + maxPedidosAProcesar + " pedidos.");
}

