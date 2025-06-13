package GestionCafeteriaUniversitaria;

// Clase Bebida (hereda de Producto)
class Bebida extends Producto implements Descuento {
    private String tamaño;
    private boolean alcoholica;

    public Bebida(String nombre, double precio, String codigo, String tamaño, boolean alcoholica) {
        super(nombre, precio, codigo);
        this.tamaño = tamaño;
        this.alcoholica = alcoholica;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Bebida: " + getNombre() + 
                         "\nPrecio: $" + getPrecio() + 
                         "\nTamaño: " + tamaño + 
                         "\nAlcohólica: " + (alcoholica ? "Sí" : "No"));
    }

    @Override
    public void preparar() {
        System.out.println("Preparando bebida: " + getNombre());
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        double nuevoPrecio = getPrecio() * (1 - porcentaje/100);
        setPrecio(nuevoPrecio);
        System.out.println("Descuento aplicado. Nuevo precio: $" + nuevoPrecio);
    }

    // Getters y setters específicos
    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(boolean alcoholica) {
        this.alcoholica = alcoholica;
    }
}
