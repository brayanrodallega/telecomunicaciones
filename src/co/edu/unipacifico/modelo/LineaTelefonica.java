package co.edu.unipacifico.modelo;

public class LineaTelefonica {
    
    private Afiliado afiliado;
    private String numeroLinea;

    public LineaTelefonica() {
        this.afiliado = new Afiliado();
    }
    
    public LineaTelefonica(String numeroLinea) {
        this.numeroLinea = numeroLinea;
        this.afiliado = new Afiliado();
    }

    public LineaTelefonica(Afiliado afiliado, String numeroLinea) {
        this.afiliado = afiliado;
        this.numeroLinea = numeroLinea;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public String getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(String numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public String toString() {
        return this.numeroLinea;
    }
    
}
