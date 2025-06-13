package GestionCafeteriaUniversitaria;

// Clase Cliente
class Cliente {
    private String nombre;
    private String id;
    private String correo;

    public Cliente(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void mostrarInfo() {
        System.out.println("Cliente: " + nombre + "\nID: " + id + "\nCorreo: " + correo);
    }
}