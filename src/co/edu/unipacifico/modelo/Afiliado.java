package co.edu.unipacifico.modelo;

public class Afiliado {
    
    private String nombre;
    private String documento;

    public Afiliado() {
    }

    public Afiliado(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Afiliado{" + "nombre=" + nombre + ", documento=" + documento + '}';
    }
    
}
