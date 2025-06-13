package GestionCafeteriaUniversitaria;

// Clase Comida (hereda de Producto)
class Comida extends Producto {
    private String tipo;
    private boolean vegetariana;

    public Comida(String nombre, double precio, String codigo, String tipo, boolean vegetariana) {
        super(nombre, precio, codigo);
        this.tipo = tipo;
        this.vegetariana = vegetariana;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Comida: " + getNombre() + 
                         "\nPrecio: $" + getPrecio() + 
                         "\nTipo: " + tipo + 
                         "\nVegetariana: " + (vegetariana ? "Sí" : "No"));
    }

    @Override
    public void preparar() {
        System.out.println("Preparando comida: " + getNombre());
    }

    // Getters y setters específicos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isVegetariana() {
        return vegetariana;
    }

    public void setVegetariana(boolean vegetariana) {
        this.vegetariana = vegetariana;
    }
}