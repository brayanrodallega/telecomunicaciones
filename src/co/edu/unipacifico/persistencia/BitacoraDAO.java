package co.edu.unipacifico.persistencia;

import java.io.*;
import java.util.*;

public class BitacoraDAO implements IBitacoraDAO{
    
    public BitacoraDAO(){
    }

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    @Override
    public void escribirBitacoraMensaje(String nombreArchivo, boolean anexar, String emisor, String receptor, String texto, String fecha, String hora) throws IOException {
        File archivo = new File(nombreArchivo);
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, anexar));
        escritor.write(emisor + ";" + receptor + ";" + texto + ";" + fecha + ";" + hora + ";Mensaje" +"\n");
        escritor.close();
    }

    @Override
    public void escribirBitacoraLlamada(String nombreArchivo, boolean anexar, String emisor, String receptor, double duracionLlamada, String fecha, String hora) throws IOException {
        File archivo = new File(nombreArchivo);
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, anexar));
        escritor.write(emisor + ";" + receptor + ";" + duracionLlamada + ";" + fecha + ";" + hora + ";Llamada" +"\n");
        escritor.close();
    }
    
    public List<String> listarBitacora(String nombreArchivo) throws IOException{
        
        File archivo = new File(nombreArchivo);
        List<String> listaBitacora = new ArrayList<>();
        var lector = new BufferedReader(new FileReader(archivo));
        String linea = null;
        linea = lector.readLine();
        while (linea != null) {
            listaBitacora.add(linea);
            linea = lector.readLine();
        }
        lector.close();

        return listaBitacora;
    }
}
