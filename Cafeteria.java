package GestionCafeteriaUniversitaria;

// Clase Cafeteria (implementa Descuento)
class Cafeteria implements Descuento {
    private String nombre;
    private String ubicacion;
    private Pedido[] pedidos;
    private int contadorPedidos;

    public Cafeteria(String nombre, String ubicacion, int capacidadPedidos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.pedidos = new Pedido[capacidadPedidos];
        this.contadorPedidos = 0;
    }

    public void agregarPedido(Pedido pedido) {
        if (contadorPedidos < pedidos.length) {
            pedidos[contadorPedidos] = pedido;
            contadorPedidos++;
            System.out.println("Pedido registrado en la cafetería.");
        } else {
            System.out.println("No se pueden registrar más pedidos. Capacidad llena.");
        }
    }

    public void eliminarPedido(String fecha) {
        boolean encontrado = false;
        for (int i = 0; i < contadorPedidos; i++) {
            if (pedidos[i].getFecha().equals(fecha)) {
                for (int j = i; j < contadorPedidos - 1; j++) {
                    pedidos[j] = pedidos[j + 1];
                }
                contadorPedidos--;
                encontrado = true;
                System.out.println("Pedido eliminado.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Pedido no encontrado.");
        }
    }

    public void listarPedidos() {
        if (contadorPedidos == 0) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        System.out.println("--- Pedidos en la cafetería ---");
        for (int i = 0; i < contadorPedidos; i++) {
            System.out.println("Fecha: " + pedidos[i].getFecha());
            pedidos[i].getCliente().mostrarInfo();
            System.out.println("Total: $" + pedidos[i].calcularTotal());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        System.out.println("Aplicando descuento general del " + porcentaje + "% en la cafetería " + nombre);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidadPedidos() {
        return contadorPedidos;
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }
}
