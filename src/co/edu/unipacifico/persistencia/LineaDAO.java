package co.edu.unipacifico.persistencia;

import co.edu.unipacifico.modelo.*;
import java.io.*;
import java.util.*;

public class LineaDAO implements ILineaDAO {

    public LineaDAO() {
    }
    
    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    @Override
    public void escribirLinea(LineaTelefonica lineaTelefonica, String nombreArchivo, boolean anexar) throws IOException {
        File archivo = new File(nombreArchivo);
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, anexar));
        escritor.write(lineaTelefonica.getNumeroLinea() + ";" + lineaTelefonica.getAfiliado().getNombre()
                + ";" + lineaTelefonica.getAfiliado().getDocumento() + "\n");
        escritor.close();
    }

    @Override
    public List<LineaTelefonica> listarLineas(String nombreArchivo) throws IOException {

        File archivo = new File(nombreArchivo);
        List<LineaTelefonica> listaLineasTelefonicas = new ArrayList<>();
        var lector = new BufferedReader(new FileReader(archivo));
        String linea = null;
        linea = lector.readLine();
        while (linea != null) {
            String dato[]= linea.split(";");
            LineaTelefonica lineaTelefonica = new LineaTelefonica();
            lineaTelefonica.setNumeroLinea(dato[0]);
            lineaTelefonica.getAfiliado().setNombre(dato[1]);
            lineaTelefonica.getAfiliado().setDocumento(dato[2]);
            listaLineasTelefonicas.add(lineaTelefonica);
            linea = lector.readLine();
        }
        lector.close();
        return listaLineasTelefonicas;
    }

}
