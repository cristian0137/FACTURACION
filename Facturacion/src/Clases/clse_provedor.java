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
public class clse_provedor {
    private static int id;
    private static String nombre_comercial;
    private static String nombre_producto;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        clse_provedor.id = id;
    }

    public static String getNombre_comercial() {
        return nombre_comercial;
    }

    public static void setNombre_comercial(String nombre_comercial) {
        clse_provedor.nombre_comercial = nombre_comercial;
    }

    public static String getNombre_producto() {
        return nombre_producto;
    }

    public static void setNombre_producto(String nombre_producto) {
        clse_provedor.nombre_producto = nombre_producto;
    }

    public clse_provedor() {
    }
    public clse_provedor (int id,String nombre_comercial,String nombre_producto) {
      this.id=id;
      this.nombre_comercial=nombre_comercial;
      this.nombre_producto=nombre_producto;
     } 
     public void crear_Archivo_proveedores() {
	try {
		File objetoArchivo = new File("proveedores.txt");
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
     public void ingresar_al_archivo(JTable tabla_proveedores){
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("proveedores.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tabla_proveedores.getColumnCount(); col++) {
			joiner.add(tabla_proveedores.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tabla_proveedores.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tabla_proveedores.getColumnCount(); col++) {
				
				Object obj = tabla_proveedores.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
  }
      public void limpiar_archivo(){
      try {
		PrintWriter writer = new PrintWriter("proveedores.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
  }
      public void Mostrar_proveedores(JTable tabla_proveedores) {
	
	String nombreArchivo = "proveedores.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("Nombre Comercial");
		model.addColumn("Nombre del Producto");
		
		
		tabla_proveedores.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tabla_proveedores.setModel(model);
		}
		
		
	} catch (Exception e) {
		System.out.println("Ocurrio un error o el archivo eta vacio");
		
	}
}
    
    
    
    
}
