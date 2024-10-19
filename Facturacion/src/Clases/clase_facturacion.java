/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static facturacion.FACTURACION.tabla_facturacion;
import static facturacion.buscar_producto.tabla2;
import java.io.File;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author crist
 */
public class clase_facturacion extends clase_cliente{
    private static int numero_factura;
    private static String fecha;
    public clase_facturacion(String nombre, String apellido, String documento, String direccion, String telefono, String ciudad) {
        super(nombre, apellido, documento, direccion, telefono, ciudad);
    }
    

    public static int getNumero_factura() {
        return numero_factura;
    }

    public static void setNumero_factura(int numero_factura) {
        clase_facturacion.numero_factura = numero_factura;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        clase_facturacion.fecha = fecha;
    }
    
    public clase_facturacion() {
    }

    public clase_facturacion(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void clasec (){
        
    }
    
    public void crear_Archivo_inventario() {
	try {
		File objetoArchivo = new File("inventario.txt");
		if(objetoArchivo.createNewFile()) {
			                 System.out.println("Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
		}
		else {
			                 System.out.println("El archivo ya existe");
		}
		
	} catch (Exception e) {
		System.out.println("Ocurrió un error al crear el archivo");
		
	}
        
}
 

    
   
}


