package co.edu.unipacifico.controlador;

import co.edu.unipacifico.modelo.*;
import co.edu.unipacifico.persistencia.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class ControladorLinea implements IControladorLinea {
    
    private DateFormat dateFormatFecha;
    private DateFormat dateFormatHora;
    private Date date;
    private final ILineaDAO lineaDAO;
    private final IBitacoraDAO bitacoraDAO;

    public ControladorLinea() {
        lineaDAO = new LineaDAO();
        bitacoraDAO = new BitacoraDAO();
        dateFormatFecha = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatHora = new SimpleDateFormat("HH:mm:ss");
    }
    
    @Override
    public void registrarLinea(String numeroLinea, Afiliado afiliado) throws IOException {
        LineaTelefonica linea = new LineaTelefonica(afiliado, numeroLinea);
        boolean anexar = false;
        anexar = lineaDAO.existe(ARCHIVO_LINEA);
        lineaDAO.escribirLinea(linea, ARCHIVO_LINEA, anexar);
    }
    
    @Override
    public void realizarLlamada(String emisor, String receptor, double duracionLlamada) throws IOException {
        boolean anexar = false;
        date = new Date();
        anexar = bitacoraDAO.existe(ARCHIVO_BITACORA);
        bitacoraDAO.escribirBitacoraLlamada(ARCHIVO_BITACORA, anexar, emisor, receptor, duracionLlamada, dateFormatFecha.format(date), dateFormatHora.format(date));
    }
    
    @Override
    public void realizarMensaje(String emisor, String receptor, String texto) throws IOException {
        boolean anexar = false;
        date = new Date();
        anexar = bitacoraDAO.existe(ARCHIVO_BITACORA);
        bitacoraDAO.escribirBitacoraMensaje(ARCHIVO_BITACORA, anexar, emisor, receptor, texto, dateFormatFecha.format(date), dateFormatHora.format(date));
    }

    @Override
    public List<LineaTelefonica> listarLineasTelefonicas() throws IOException{
        return lineaDAO.listarLineas(ARCHIVO_LINEA);
    }

    @Override
    public List<String> consultarBitacoraOperaciones() throws IOException {
        List<String> listaBitacora = bitacoraDAO.listarBitacora(ARCHIVO_BITACORA);
        return listaBitacora;
    }
    
    @Override
    public List<String> buscarOperacionesPorNumero(String numeroLinea) throws IOException {
        List<String> listaBitacora = bitacoraDAO.listarBitacora(ARCHIVO_BITACORA);
        List<String> nuevaListaBitacora = new ArrayList<>();
        for (String linea : listaBitacora){
            String dato[] = linea.split(";");
            if (numeroLinea.equals(dato[0])){
                nuevaListaBitacora.add(linea);
            }
        }
        return nuevaListaBitacora;
    }
}
