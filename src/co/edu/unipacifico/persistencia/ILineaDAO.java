package co.edu.unipacifico.persistencia;

import co.edu.unipacifico.modelo.LineaTelefonica;
import java.io.IOException;
import java.util.List;

public interface ILineaDAO {
    
    public boolean existe(String nombreArchivo);
    
    public List<LineaTelefonica> listarLineas(String nombreArchivo) throws IOException;
    
    public void escribirLinea(LineaTelefonica lineaTelefonica, String nombreArchivo, boolean anexar) throws IOException;
    
}
