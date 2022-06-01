package co.edu.unipacifico.controlador;

import co.edu.unipacifico.modelo.*;
import java.io.*;
import java.util.*;

public interface IControladorLinea {
    
    String ARCHIVO_LINEA = "src/recurso/linea.txt";
    String ARCHIVO_BITACORA = "src/recurso/bitacora.txt";
    
    public void registrarLinea(String numeroLinea, Afiliado afiliado) throws IOException;
    
    public void realizarLlamada(String emisor, String receptor, double duracionLlamada) throws IOException;
    
    public void realizarMensaje(String emisor, String receptor, String texto) throws IOException;
    
    public List<LineaTelefonica> listarLineasTelefonicas() throws IOException;
    
    public List<String> consultarBitacoraOperaciones() throws IOException;
    
    public List<String> buscarOperacionesPorNumero(String numeroLinea) throws IOException;
    
}
