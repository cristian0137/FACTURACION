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
import java.util.StringJoiner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LENOVO
 */
public class clase_cliente {

    private static String documento;
    private static String nombre;
    private static String apellido;
    private static String direccion;
    private static String telefono;
    private static String ciudad;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        clase_cliente.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        clase_cliente.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        clase_cliente.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        clase_cliente.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        clase_cliente.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        clase_cliente.ciudad = ciudad;
    }

    public clase_cliente(String nombre, String apellido, String documento, String direccion, String telefono, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;

    }

    public clase_cliente() {

    }

  public void Mostrar_clientes(JTable tabla_cliente) {
	
	String nombreArchivo = "cliente.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("CODIGO");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("DIRECCION");
		model.addColumn("TELEFONO");
                model.addColumn("CIUDAD");
		
		tabla_cliente.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tabla_cliente.setModel(model);
		}
		
		
	} catch (Exception e) {
		System.out.println("Ocurrio un error o el archivo eta vacio");
		
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    

