package Proyecto01;

import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Restaurante {
    private List<Mesa> mesas;
    private List<Platos> platos;
    private List<Pedido> pedido;
    private List<Pedido> pedidosEnEspera;
    private List<Pedido> pedidosEnPreparacion;
    private List<Pedido> pedidosServidos;
    private Clientes clientes;
    private int totalEspera;
    private int totalAtendidos;
    private int totalServidos;
    private int numMesa;

    public Restaurante() {
        mesas = new ArrayList<>();
        platos = new ArrayList<>();
        clientes = new Clientes();
        pedido= new LinkedList<>();
        totalEspera = 0; 
        totalAtendidos = 0;  
        totalServidos = 0; 
        pedidosEnEspera = new LinkedList<>();
        pedidosEnPreparacion = new LinkedList<>();
        pedidosServidos = new LinkedList<>();
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);
        boolean elegir = true;
        while (elegir) {
            System.out.println("Menu de opciones");
            System.out.println("1- Iniciar Jornada");
            System.out.println("2- Consultar Mesas disponibles");
            System.out.println("3- Consultar Mesas ocupadas");
            System.out.println("4- Consultar por numero de Mesa");
            System.out.println("5- Consultar clientes");
            System.out.println("6- Alta de pedido");
            System.out.println("7- Entrega de Pedido");
            System.out.println("8- Pago de consumo");
            System.out.println("9- Control de ingresos de la jornada");
            System.out.println("10- Salir del menú");
            System.out.println("Elegir una opción:");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    restaurante.registrodeMesa();
                    break;
                case 2:
                    restaurante.consultarMesaDisponibles();
                    break;
                case 3:
                    restaurante.consultarMesaOcupada();
                    break;
                case 4:
                    restaurante.consultarPorNumerodeMesa();
                    break;
                case 5:
                    restaurante.consultaDeClientes();
                    break;
                case 6:
                    // restaurante.altaDePedido();
                    break;
                case 10:
                    elegir= false;
                    break;
            }
        }
    }

    public void consultarMesaDisponibles() {
        System.out.println("Mesas disponibles:");
    
        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("libre")) {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Capacidad " + mesa.getCapacidad());
            }
        }
    }

    public void consultarMesaOcupada(){
        System.out.println("Mesas ocupadas:");
    
        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("ocupada")) {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Comensales " + mesa.getComensales());
            }
        }
    }

    public void consultarPorNumerodeMesa() {
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
    }
    
    public void consultaDeClientes() {
         System.out.println("Total de clientes en espera: " + clientes.getTotalEspera());
         System.out.println("Total de clientes atendidos: " + clientes.getTotalAtendidos());
         System.out.println("Total de clientes servidos: " + clientes.getTotalServidos());
         System.out.println("Total de clientes en el restaurante: " + consultarTotalClientes());
    }

    public int consultarTotalClientes() {
        return clientes.getTotalEspera() + clientes.getTotalAtendidos() + clientes.getTotalServidos();
    }
    
    public void registrodeMesa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar el número de mesas del restaurante: ");
        numMesa = scanner.nextInt();
        scanner.nextLine();
    
        // Limpiar la lista de mesas existente
        mesas.clear();
    
        for (int i = 0; i < numMesa; i++) {
            if (i < numMesa * 0.3) {
                mesas.add(new Mesa(i + 1, 2));
            } else {
                mesas.add(new Mesa(i + 1, 4));
            }
        }
        for (Mesa mesa : mesas) {
            System.out.println(mesa);
        }
        System.out.println("Ingrese la cantidad de platos disponibles: ");
        int numPlatos = scanner.nextInt();
        platos = new ArrayList<>(); // Inicializar la lista de platos

        for (int i = 0; i < numPlatos; i++) {
            System.out.println("Ingresar nombre del plato: ");
            String name = scanner.next();
            System.out.println("Ingresar precio del plato: ");
            double price = scanner.nextDouble();
            platos.add(new Platos(i + 1, name, price)); // Agregar el plato a la lista
        }
        for (Platos plato : platos) {
            System.out.println(plato);
        }

        System.out.println("Ingrese el número de comensales: ");
        int numComensales = scanner.nextInt();
        System.out.println("Mesa disponible para " + numComensales + " personas:");

        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("libre") && mesa.getCapacidad() >= numComensales) {
                mesa.setEstado("ocupada");
                mesa.setServicio("espera");
                mesa.setComensales(numComensales);
                System.out.println("Mesa " + mesa.getNumMesa() + " ocupada.");
                
                break;
            }
        }
        System.out.println("Ingrese el numero actual de clientes en espera.");
        int totalEspera = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el numero actual de clientes atendidos.");
        int totalAtendidos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el numero actual de clientes servidos.");
        int totalServidos = scanner.nextInt();
        scanner.nextLine();
        clientes.setTotalEspera(totalEspera);
        clientes.setTotalAtendidos(totalAtendidos);
        clientes.setTotalServidos(totalServidos);
        consultarMesaDisponibles();
    }

    public int consultarTotal() {
        return totalEspera + totalAtendidos + totalServidos;
    }

    // public void OcuparMesa(int numMesa, Mesa[] mesas) {
    //     Scanner scanner = new Scanner(System.in);
    //         System.out.println("Ingrese el número de comensales: ");
    //         int numComensales = scanner.nextInt();
    //         scanner.nextLine();
    //         if (Consultas.MesasDisponibles(numMesa, mesas) != 0){
    //             System.out.println("¿Cuál mesa desea ocupar?");
    //             int elegirMesa = scanner.nextInt();
    //             scanner.nextLine();
    //             if (mesas[elegirMesa].getCapacidad() >= numComensales && mesas[elegirMesa].getEstado().equals("libre")){
    //                 mesas[elegirMesa].setEstado("ocupada");
    //                 mesas[elegirMesa].setServicio("espera");
    //                 mesas[elegirMesa].setComensales(numComensales);
    //                 System.out.println("Ahora la mesa "+ mesas[elegirMesa].getNumMesa()+ " esta ocupada y esperando a ser atendida.");
    //             }else{
    //                 System.out.println("Esa mesa no esta disponible.");
    //             }
    //             }else{
    //                 System.out.println("No hay mesas disponibles.");
    //             }
    //         }  
        
    //         static void atencionMesas(int numMesa, Mesa[] mesas){
    //         for (int i=0; i<numMesa; i++){
    //             if (mesas[i].getEstado().equals("espera")){
    //                 /*GestionPedidos.altaPedidos(mesas[i]);
    //                 mesas[i].setEstado("atendida");*/
    //             }
    //         }
    // }
    
    // public void altaDePedido() {
    //         Scanner scanner = new Scanner(System.in);
    //         List<Mesa> mesasOcupadas = new ArrayList<>();
    //         for (Mesa mesa : mesas) {
    //             if (mesa.getEstado().equals("ocupada")) {
    //                 mesasOcupadas.add(mesa);
    //             }
    //         }
        
    //         if (mesasOcupadas.isEmpty()) {
    //             System.out.println("No hay mesas ocupadas para tomar pedidos.");
    //             return;
    //         }
        
    //         // Mostrar el menú de platos
    //         System.out.println("Menú de Platos:");
    //         for (Platos plato : platos) {
    //             System.out.println(plato.getCodigoPlato() + ". " + plato.getDescripcion() + " - Precio: " + plato.getPrecio());
    //         }
        
    //         // Obtener el número de mesa
    //         System.out.println("Ingrese el número de mesa para el pedido:");
    //         int numeroMesa = scanner.nextInt();
    //         scanner.nextLine();
        
    //         // Verificar si el número de mesa es válido
    //         boolean mesaValida = false;
    //         for (Mesa mesa : mesasOcupadas) {
    //             if (mesa.getNumMesa() == numeroMesa) {
    //                 mesaValida = true;
    //                 break;
    //             }
    //         }
        
    //         if (!mesaValida) {
    //             System.out.println("El número de mesa no es válido o no está ocupado.");
    //             return;
    //         }
        
    //         // Crear el pedido
    //         Pedido nuevoPedido = new Pedido(platos, numeroMesa, "libre");
        
    //         // Elegir platos para el pedido
    //         System.out.println("Seleccione hasta 4 platos ingresando sus números (0 para finalizar):");
    //         int platoSeleccionado;
    //         int contadorPlatos = 0;
        
    //         while (contadorPlatos < 4) {
    //             platoSeleccionado = scanner.nextInt();
    //             scanner.nextLine();
    //             if (platoSeleccionado == 0) {
    //                 break;
    //             }
    //         }
    // }

}

