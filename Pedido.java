package GestionCafeteriaUniversitaria;

// Clase Pedido (composición con vector de Producto)
class Pedido {
    private Producto[] productos;
    private int contadorProductos;
    private Cliente cliente;
    private String fecha;

    public Pedido(Cliente cliente, String fecha, int capacidad) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.productos = new Producto[capacidad];
        this.contadorProductos = 0;
    }

    public void agregarProducto(Producto producto) {
        if (contadorProductos < productos.length) {
            productos[contadorProductos] = producto;
            contadorProductos++;
            System.out.println("Producto agregado al pedido.");
        } else {
            System.out.println("No se pueden agregar más productos. Pedido lleno.");
        }
    }

    public void eliminarProducto(String codigo) {
        boolean encontrado = false;
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                // Mover todos los elementos una posición hacia atrás
                for (int j = i; j < contadorProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                contadorProductos--;
                encontrado = true;
                System.out.println("Producto eliminado del pedido.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado en el pedido.");
        }
    }

    public void listarProductos() {
        if (contadorProductos == 0) {
            System.out.println("No hay productos en este pedido.");
            return;
        }
        System.out.println("--- Productos en el pedido ---");
        for (int i = 0; i < contadorProductos; i++) {
            productos[i].mostrarDetalles();
            System.out.println("-----------------------------");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < contadorProductos; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }

    // Getters y setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadProductos() {
        return contadorProductos;
    }
}