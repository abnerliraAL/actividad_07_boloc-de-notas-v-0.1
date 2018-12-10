
package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Modelos;
import Vista.Vistas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Controladores {
    
    Modelos modelocnotas; 
    Vistas vistanotas; 
    
    ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == vistanotas.jb_archivo) { 
                jmi_leer_action_performed();
            }
            else if (e.getSource() == vistanotas.jb_guardar) { 
                jmi_guardar_action_performed();
            }
        }
    };
    
   
    public Controladores(Modelos modelBloc, Vistas viewBloc) {
        this.modelocnotas = modelBloc;
        this.vistanotas = viewBloc;
        
       this.vistanotas.jb_archivo.addActionListener(actionlistener);
        this.vistanotas.jb_guardar.addActionListener(actionlistener);
        initComponents();
    }
    
   
    public void jmi_leer_action_performed() {
        this.readFile(modelocnotas.getPath()); 
    }
    
    
    public void jmi_guardar_action_performed() {
        modelocnotas.setMessage(vistanotas.j_bloc_notas.getText()); 
        this.writeFile(modelocnotas.getPath(), modelocnotas.getMessage()); 
    }
    
    

    public String readFile (String path) {
        try {
            String row; 
            try (FileReader archivo = new FileReader(path)) { 
                BufferedReader bufferedreader = new BufferedReader(archivo); 
                while ((row = bufferedreader.readLine()) != null ) {
                    vistanotas.j_bloc_notas.setText(row);
                }
            }
        }
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
        return null;
    };
    

    public void writeFile (String path, String message) {
        try {
            File archivo = new File(path); 
            FileWriter filewriter = new FileWriter(archivo, false); 
            
            try (PrintWriter printwriter = new PrintWriter(filewriter) ) { 
                printwriter.println(message);
                printwriter.close();
            }
        }
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }
    
    
    public void initComponents() {
        vistanotas.setVisible(true);
    }
    
}