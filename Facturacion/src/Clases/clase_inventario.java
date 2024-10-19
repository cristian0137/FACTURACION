/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringJoiner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class clase_inventario {
    private static int n_factura;
    private static int cantidad;
    private static String descripcion;
    private static double costo;
    private static double descuento;
    private static double precio;

    public static int getN_factura() {
        return n_factura;
    }

    public static void setN_factura(int n_factura) {
        clase_inventario.n_factura = n_factura;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        clase_inventario.cantidad = cantidad;
    }

    public static String getDescripcion() {
        return descripcion;
    }

    public static void setDescripcion(String descripcion) {
        clase_inventario.descripcion = descripcion;
    }

    public static double getCosto() {
        return costo;
    }

    public static void setCosto(double costo) {
        clase_inventario.costo = costo;
    }

    public static double getDescuento() {
        return descuento;
    }

    public static void setDescuento(double descuento) {
        clase_inventario.descuento = descuento;
    }

    public static double getPrecio() {
        return precio;
    }

    public static void setPrecio(double precio) {
        clase_inventario.precio = precio;
    }
    
    public clase_inventario (int n_factura,int cantidad,String descripcion,double costo,double descuento,double precio) {
      this.n_factura=n_factura;
      this.cantidad=cantidad;
      this.descripcion=descripcion;
      this.costo=costo;
      this.descuento=descuento;
      this.precio= precio;
              
  } 
  public clase_inventario (){
  }
  
  
  
 
  
  public void Mostrar_inventario(JTable tabla_inventario) {
	
	String nombreArchivo = "inventario.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Codigo");
		model.addColumn("Descripcion");
		model.addColumn("Cantidad");
		model.addColumn("Costo");
		model.addColumn("Descuento");
                model.addColumn("Precio");
		
		tabla_inventario.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tabla_inventario.setModel(model);
		}
		
		
	} catch (Exception e) {
		          System.out.println("Ocurrio un error o el archivo eta vacio");
		
	}
}

    public void ingresar_al_archivo(DefaultTableModel modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  

}
