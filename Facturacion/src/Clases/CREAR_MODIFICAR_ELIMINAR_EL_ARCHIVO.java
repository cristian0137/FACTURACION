/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/**
 *
 * @author crist
 */
public class CREAR_MODIFICAR_ELIMINAR_EL_ARCHIVO {
   public void crear_Archivo(String nombre_archivo) {
	try {
		File objetoArchivo = new File(nombre_archivo);
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
   
   
   public void ingresar_al_archivo(JTable tabla,String nombre_archivo){
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(nombre_archivo)))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tabla.getColumnCount(); col++) {
			joiner.add(tabla.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tabla.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tabla.getColumnCount(); col++) {
				
				Object obj = tabla.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			
		}

		
	} catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "ocurrio un error");
	}
	
  }
    public void limpiar_archivo(String nombre_archivo){
      try {
		PrintWriter writer = new PrintWriter(nombre_archivo);
		writer.print("");
		writer.close();
	} catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "ocurrio un error");
	}
  }
     



}
