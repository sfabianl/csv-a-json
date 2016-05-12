/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexceljson;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @author sergio
 */
public class leer_archivo {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public ArrayList leer_archivo_exel(String archivo) {

        ArrayList lista_libros = new ArrayList();

        CsvReader reader = null;

        try {

            reader = new CsvReader(archivo, ',');

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showInputDialog("en leer archivo");
        }

        try {

            reader.readHeaders();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {

            datosGS libr;

            while (reader.readRecord()) {

                libr = new datosGS();

                libr.setNumero(reader.get("numero"));
                libr.setTotal(reader.get("total"));
                libr.setNombre(reader.get("nombre"));
                libr.setApellido(reader.get("apellido"));
                libr.setRuc(reader.get("ruc"));

                lista_libros.add(libr);

//lista_libros.add(libr); // añadimos el objeto al arrayList
            }

        } catch (IOException ex) {
//ex.printStackTrace();
            System.err.println(" en while readrecord ");

        }

        reader.close();

        return lista_libros; // retorna una objeto de ArrayList

    }

    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //   SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
        return fechaDate;
    }

}
