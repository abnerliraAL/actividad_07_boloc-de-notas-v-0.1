
package main;

import Controlador.Controladores;
import Modelo.Modelos;
import Vista.Vistas;


public class Main {

    
    public static void main(String[] args) {
        
        Modelos modelblocnotas = new Modelos();
        Vistas viewblocnotas = new Vistas();
        Controladores controllerblocnotas = new Controladores(modelblocnotas, viewblocnotas); // Integra los componentes del modelo MVC.
        
    }
    
}
