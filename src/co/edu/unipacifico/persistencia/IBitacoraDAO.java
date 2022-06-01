package co.edu.unipacifico.persistencia;

import java.io.*;
import java.util.*;

public interface IBitacoraDAO {
    
    public boolean existe(String nombreArchivo);
    
    public void escribirBitacoraMensaje(String nombreArchivo, boolean anexar, String emisor, String receptor, String texto, String fecha, String hora) throws IOException;
    
    public void escribirBitacoraLlamada(String nombreArchivo, boolean anexar, String emisor, String receptor, double duracionLlamada, String fecha, String hora) throws IOException;
    
    public List<String> listarBitacora(String nombreArchivo) throws IOException;
    
}
