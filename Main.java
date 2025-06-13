package GestionCafeteriaUniversitaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaCafeteria sistema = new SistemaCafeteria();
        sistema.inicializarSistema();
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Productos");
            System.out.println("3. Gestión de Pedidos");
            System.out.println("4. Informes y Consultas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    menuClientes(scanner, sistema);
                    break;
                case 2:
                    menuProductos(scanner, sistema);
                    break;
                case 3:
                    menuPedidos(scanner, sistema);
                    break;
                case 4:
                    menuInformes(scanner, sistema);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void menuClientes(Scanner scanner, SistemaCafeteria sistema) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por ID");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese ID del cliente: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese correo del cliente: ");
                    String correo = scanner.nextLine();
                    if (sistema.agregarCliente(nombre, id, correo)) {
                        System.out.println("Cliente agregado exitosamente.");
                    } else {
                        System.out.println("No se pudo agregar el cliente (ID duplicado o capacidad llena).");
                    }
                    break;
                case 2:
                    Cliente[] clientes = sistema.listarClientes();
                    if (clientes.length == 0) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        System.out.println("\n=== LISTADO DE CLIENTES ===");
                        for (Cliente c : clientes) {
                            c.mostrarInfo();
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del cliente a buscar: ");
                    String idBuscar = scanner.nextLine();
                    Cliente encontrado = sistema.buscarClientePorId(idBuscar);
                    if (encontrado != null) {
                        System.out.println("\nCliente encontrado:");
                        encontrado.mostrarInfo();
                    } else {
                        System.out.println("No se encontró ningún cliente con ese ID.");
                    }
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void menuProductos(Scanner scanner, SistemaCafeteria sistema) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE PRODUCTOS ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Aplicar descuento a bebida");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("\nTipo de producto:");
                    System.out.println("1. Comida");
                    System.out.println("2. Bebida");
                    System.out.print("Seleccione una opción: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese precio del producto: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese código del producto: ");
                    String codigo = scanner.nextLine();
                    boolean agregado = false;
                    if (tipo == 1) {
                        System.out.print("Ingrese tipo de comida (Ej: Ligera, Rápida, etc.): ");
                        String tipoComida = scanner.nextLine();
                        System.out.print("¿Es vegetariana? (s/n): ");
                        boolean vegetariana = scanner.nextLine().equalsIgnoreCase("s");
                        agregado = sistema.agregarComida(nombre, precio, codigo, tipoComida, vegetariana);
                    } else if (tipo == 2) {
                        System.out.print("Ingrese tamaño de la bebida (Ej: Pequeño, Mediano, Grande): ");
                        String tamaño = scanner.nextLine();
                        System.out.print("¿Es alcohólica? (s/n): ");
                        boolean alcoholica = scanner.nextLine().equalsIgnoreCase("s");
                        agregado = sistema.agregarBebida(nombre, precio, codigo, tamaño, alcoholica);
                    } else {
                        System.out.println("Opción no válida.");
                        break;
                    }
                    if (agregado) {
                        System.out.println("Producto agregado exitosamente.");
                    } else {
                        System.out.println("No se pudo agregar el producto (código duplicado o capacidad llena).");
                    }
                    break;
                case 2:
                    Producto[] productos = sistema.listarProductos();
                    if (productos.length == 0) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        System.out.println("\n=== LISTADO DE PRODUCTOS ===");
                        for (Producto p : productos) {
                            p.mostrarDetalles();
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto a buscar: ");
                    String codigoBuscar = scanner.nextLine();
                    Producto prod = sistema.buscarProductoPorCodigo(codigoBuscar);
                    if (prod != null) {
                        System.out.println("\nProducto encontrado:");
                        prod.mostrarDetalles();
                    } else {
                        System.out.println("No se encontró ningún producto con ese código.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    if (sistema.eliminarProducto(codigoEliminar)) {
                        System.out.println("Producto eliminado exitosamente.");
                    } else {
                        System.out.println("No se encontró ningún producto con ese código.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el código de la bebida: ");
                    String codigoBebida = scanner.nextLine();
                    System.out.print("Ingrese el porcentaje de descuento: ");
                    double descuento = scanner.nextDouble();
                    scanner.nextLine();
                    if (sistema.aplicarDescuentoABebida(codigoBebida, descuento)) {
                        System.out.println("Descuento aplicado exitosamente.");
                    } else {
                        System.out.println("No se encontró una bebida con ese código.");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    // Puedes implementar los menús de pedidos e informes de manera similar,
    // llamando a los métodos públicos de SistemaCafeteria.
    private static void menuPedidos(Scanner scanner, SistemaCafeteria sistema) {
        System.out.println("Funcionalidad de gestión de pedidos no implementada en este ejemplo.");
    }
    private static void menuInformes(Scanner scanner, SistemaCafeteria sistema) {
        System.out.println("Funcionalidad de informes y consultas no implementada en este ejemplo.");
    }
}