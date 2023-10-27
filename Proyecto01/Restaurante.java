package Proyecto01;

import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Restaurante {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------Iniciando programa--------");
        System.out.println("Ingresar el número de mesas del restaurante: ");
        int numMesa = scanner.nextInt();
        scanner.nextLine();
        Mesa[] mesas = new Mesa[numMesa];
        restaurante.registrarYMostrarMesas(numMesa, mesas);
        Queue<Pedido> pedidosEnEspera = new ArrayDeque<>();
        Queue<Pedido> pedidosPreparacion = new ArrayDeque<>();
        Stack<Boleta> pagosRecibidos = new Stack<>();
        ArrayList<Pedido> pedidosPendientesPago = new ArrayList<>();
        System.out.println("Ingrese la cantidad de platos disponibles: ");
        int numPlatos = scanner.nextInt();
        Platos[] platos = new Platos[numPlatos];
        restaurante.registrarYMostrarPlatos(numPlatos, platos);
        Clientes clientes = new Clientes();
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
            System.out.println("7- Preparacion de pedido");
            System.out.println("8- Entrega de pedido");
            System.out.println("9- Pago de consumo");
            System.out.println("10- Control de ingresos de la jornada");
            System.out.println("11- Actualizar clientes.");
            System.out.println("12- Salir del menú");
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
                case 8:
                    restaurante.entregarPedidos(mesas, pedidosPreparacion, pedidosPendientesPago);
                    break;
                case 9:
                    restaurante.pagoDeConsumo(mesas, pagosRecibidos, pedidosPendientesPago, platos);
                    break;
                case 10:
                    restaurante.controlIngresos(pagosRecibidos);
                    break;
                case 11:
                    restaurante.actualizarClientes(clientes);
                    break;
                case 12:
                    elegir = false;
                    break;
            }
        }
        scanner.close();
    }

    public void registrarYMostrarMesas(int numMesa, Mesa[] mesas){
        for (int i = 0; i < numMesa; i++) {
            if (i < numMesa * 0.3) {
                mesas[i] = new Mesa(i + 1, 2);
            } else {
                mesas[i] = new Mesa(i + 1, 4);
            }
        }
        for (Mesa mesa : mesas){
            System.out.println(mesa);
        }
    }

    public void registrarYMostrarPlatos(int numPlatos, Platos[] platos){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numPlatos; i++) {
            System.out.println("Ingresar nombre del plato: ");
            String name = scanner.nextLine();
            System.out.println("Ingresar precio del plato: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            platos[i] = new Platos(i + 1, name, price);
        }
        for (Platos plato : platos) {
            System.out.println(plato);
        }
    }

    public void consultarMesaDisponibles(Mesa[] mesas) {
        System.out.println("----Mesas disponibles----");

        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("libre")) {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Capacidad " + mesa.getCapacidad());
            }
        }
    }

    public void consultarMesaOcupada(Mesa[] mesas) {
        System.out.println("----Mesas ocupadas----");

        for (Mesa mesa : mesas) {
            if (mesa.getEstado().equals("ocupada")) {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Comensales " + mesa.getComensales() + "Servicio: " + mesa.getServicio());
            }
        }
    }

    public void consultarPorNumerodeMesa(Mesa[] mesas, int numMesa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa número de mesa: ");
        int numerodeMesa = scanner.nextInt();
        scanner.nextLine();
        while (numerodeMesa > numMesa || numerodeMesa <= 0) {
            System.out.println("El numero de mesa que ingreso no es valido o no existe, por favor ingrese un numero valido.");
            System.out.println("Ingresa número de mesa: ");
            numerodeMesa = scanner.nextInt();
            scanner.nextLine();
        }
        for (int i = 0; i < numMesa; i++) {
        if (mesas[i].getNumMesa() == numerodeMesa){
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

    public void consultaDeClientes(Clientes clientes) {
        Scanner scanner = new Scanner(System.in);
        if (clientes.getTotalAtendidos() == 0 && clientes.getTotalEspera() == 0 && clientes.getTotalServidos() == 0){
            System.out.println("Actualmente no se registraron clientes. Si acaba de empezar la jornada, por favor registre la cantidad actual de clientes.");
            System.out.println("Ingrese el numero actual de clientes en espera.");
            int clientesEnEspera = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el numero actual de clientes atendidos.");
            int clientesAtendidos = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el numero actual de clientes servidos.");
            int clientesServidos = scanner.nextInt();
            scanner.nextLine();
            clientes.setTotalEspera(clientesEnEspera);
            clientes.setTotalAtendidos(clientesAtendidos);
            clientes.setTotalServidos(clientesServidos);
        }else{
            System.out.println("Total de clientes en espera: " + clientes.getTotalEspera());
            System.out.println("Total de clientes atendidos: " + clientes.getTotalAtendidos());
            System.out.println("Total de clientes servidos: " + clientes.getTotalServidos());
            System.out.println("Total de clientes en el restaurante: " + consultarTotalClientes(clientes));
        }
        
    }

    public int consultarTotalClientes(Clientes clientes) {
        return clientes.getTotalEspera() + clientes.getTotalAtendidos() + clientes.getTotalServidos();
    }
    public void actualizarClientes(Clientes clientes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero actual de clientes en espera.");
        int clientesEnEspera = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el numero actual de clientes atendidos.");
        int clientesAtendidos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el numero actual de clientes servidos.");
        int clientesServidos = scanner.nextInt();
        scanner.nextLine();
        clientes.setTotalEspera(clientesEnEspera);
        clientes.setTotalAtendidos(clientesAtendidos);
        clientes.setTotalServidos(clientesServidos);
        System.out.println("La cantidad de clientes ha sido actualizada.");
        
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
            if (mesas[elegirMesa - 1].getCapacidad() >= numComensales && mesas[elegirMesa - 1].getEstado().equals("libre")) {
                mesas[elegirMesa - 1].setEstado("ocupada");
                mesas[elegirMesa - 1].setServicio("espera");
                mesas[elegirMesa - 1].setComensales(numComensales);
                System.out.println("Ahora la mesa " + mesas[elegirMesa - 1].getNumMesa()+ " esta ocupada y esperando a ser atendida.");
            } else {
                System.out.println("Esa mesa no esta disponible.");
            }
        } else {
            System.out.println("No hay mesas disponibles.");
        }
        
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

        System.out.println("Menú de Platos:");
        for (Platos plato : platos) {
            System.out.println(plato.getCodigoPlato() + ". " + plato.getDescripcion() + " - Precio: " + plato.getPrecio());
        }

        System.out.println("Ingrese el número de mesa para el pedido:");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> ordenDePlatos = new ArrayList<String>();

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
        Pedido nuevoPedido = new Pedido(pedidoActual, numeroMesa, ordenDePlatos, "espera");
        pedidoActual++;
        pedidosEnEspera.add(nuevoPedido);
        System.out.println("El pedido para la mesa "+ numeroMesa + " ha sido creado.");
    }
    
    public void prepararPedidos(Queue<Pedido> pedidosEnEspera, Queue<Pedido> pedidosPreparacion) {
        int maxPedidosAProcesar = Math.min(5, pedidosEnEspera.size());

        for (int i = 0; i < maxPedidosAProcesar; i++) {
            Pedido pedido = pedidosEnEspera.poll(); 
            pedido.setEstado("Preparando");
            pedidosPreparacion.offer(pedido); 
        }

        System.out.println("Se han preparado " + maxPedidosAProcesar + " pedidos.");
    }
    public void entregarPedidos(Mesa[] mesas, Queue<Pedido> pedidosPreparacion, ArrayList<Pedido> pedidosPendientesPagos){
        Pedido pedido = pedidosPreparacion.poll();
        pedido.setEstado("servido");
        mesas[pedido.getNumMesa() - 1].setServicio("servida");
        pedidosPendientesPagos.add(pedido);
        System.out.println("Se ha entregado el pedido de la mesa "+ pedido.getNumMesa());
    }


    public void pagoDeConsumo(Mesa[] mesas, Stack<Boleta> pagosRecibidos, ArrayList<Pedido> pedidosPendientesPagos, Platos[] platos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mesas para realizar el pago:");

        for (Mesa mesa : mesas) {
            if (mesa.getServicio().equals("servida")) {
                System.out.println("Mesa "+ mesa.getNumMesa());
            }
        }

        System.out.println("Ingrese el número de mesa para realizar el pago:");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine();
        boolean mesaEncontrada = false;

        for (Pedido pedido : pedidosPendientesPagos) {
            if (pedido.getNumMesa() == numeroMesa) {
                mesaEncontrada = true;
                double montoAPagar = calcularMontoAPagar(pedido.getPlatos(), platos);
                Boleta boleta = new Boleta(pedido.getNumeroPedido(), numeroMesa, montoAPagar);
                pagosRecibidos.push(boleta);
                System.out.println("Monto a pagar por la mesa " + numeroMesa + ": $" + montoAPagar);
                System.out.println("Ingrese el monto recibido: $");
                double montoRecibido = scanner.nextDouble();
                scanner.nextLine();
                if (montoRecibido >= montoAPagar) {
                    System.out.println("Cambio a devolver: $" + (montoRecibido - montoAPagar));
                    mesas[pedido.getNumMesa()].setEstado("libre");
                    mesas[pedido.getNumMesa()].setServicio("ninguno");
                    pedidosPendientesPagos.remove(pedido);
                } else {
                    System.out.println("Monto insuficiente. El pago no se realizó.");
                }
                break;
            }
        }

        if (!mesaEncontrada) {
            System.out.println("Mesa no encontrada o no tiene servicio 'servida'.");
        }
    }

    private double calcularMontoAPagar(List<String> platosPedido, Platos[] platos) {
        double montoAPagar = 0;
        for (String platoPedido : platosPedido) {
            for (Platos plato : platos) {
                if (plato.getDescripcion().equals(platoPedido)) {
                    montoAPagar += plato.getPrecio();
                }
            }
        }
        return montoAPagar;
    }

    public void controlIngresos(Stack<Boleta> pagosRecibidos){
        int gananciaTotal = 0;
        for (int i= 0; i < pagosRecibidos.size(); i++){
            Boleta boleta = pagosRecibidos.pop();
            gananciaTotal += boleta.getMontoAPagar();
        }
        System.out.println("Total de ganancias del dia: $"+ gananciaTotal);
    }
}