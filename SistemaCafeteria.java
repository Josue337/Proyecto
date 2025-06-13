package GestionCafeteriaUniversitaria;

import java.lang.reflect.Array;
import java.util.*;

public class SistemaCafeteria {
    private Cafeteria cafeteria;
    private Cliente[] clientes = new Cliente[10];
    private int contadorClientes = 0;
    private Producto[] productos = new Producto[20];
    private int contadorProductos = 0;

    public void inicializarSistema() {
        cafeteria = new Cafeteria("Cafetería Universitaria", "Edificio MJ", 50);
        clientes[contadorClientes++] = new Cliente("Josue bustamante", "1001", "josue@gmail.com");
        clientes[contadorClientes++] = new Cliente("Juan Pérez", "1002", "juan@email.com");
        clientes[contadorClientes++] = new Cliente("Luis Vanegas", "1003","luis@gmail.com");

        
        productos[contadorProductos++] = new Comida("Sandwich", 5.99, "C001", "Ligera", false);
        productos[contadorProductos++] = new Bebida("Café", 2.50, "B001", "Mediano", false);
    }

    // Métodos de gestión de clientes
    public boolean agregarCliente(String nombre, String id, String correo) {
        if (contadorClientes >= clientes.length) return false;
        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getId().equals(id)) return false;
        }
        clientes[contadorClientes++] = new Cliente(nombre, id, correo);
        return true;
    }

    public Cliente[] listarClientes() {
        return Arrays.copyOf(clientes, contadorClientes);
    }

    public Cliente buscarClientePorId(String id) {
        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getId().equals(id)) return clientes[i];
        }
        return null;
    }

    // Métodos de gestión de productos
    public boolean agregarComida(String nombre, double precio, String codigo, String tipoComida, boolean vegetariana) {
        if (contadorProductos >= productos.length) return false;
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigo().equals(codigo)) return false;
        }
        productos[contadorProductos++] = new Comida(nombre, precio, codigo, tipoComida, vegetariana);
        return true;
    }

    public boolean agregarBebida(String nombre, double precio, String codigo, String tamaño, boolean alcoholica) {
        if (contadorProductos >= productos.length) return false;
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigo().equals(codigo)) return false;
        }
        productos[contadorProductos++] = new Bebida(nombre, precio, codigo, tamaño, alcoholica);
        return true;
    }

    public Producto[] listarProductos() {
        return Arrays.copyOf(productos, contadorProductos);
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigo().equals(codigo)) return productos[i];
        }
        return null;
    }

    public boolean eliminarProducto(String codigo) {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                for (int j = i; j < contadorProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[contadorProductos - 1] = null;
                contadorProductos--;
                return true;
            }
        }
        return false;
    }

    public boolean aplicarDescuentoABebida(String codigo, double descuento) {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigo().equals(codigo) && productos[i] instanceof Bebida) {
                ((Bebida) productos[i]).aplicarDescuento(descuento);
                return true;
            }
        }
        return false;
    }

    // Métodos de gestión de pedidos y consultas
    public Cafeteria getCafeteria() {
        return cafeteria;
    }
    public Cliente[] getClientes() {
        return Arrays.copyOf(clientes, contadorClientes);
    }
    public Producto[] getProductos() {
        return Arrays.copyOf(productos, contadorProductos);
    }
    public int getContadorClientes() {
        return contadorClientes;
    }
    public int getContadorProductos() {
        return contadorProductos;
    }
}
