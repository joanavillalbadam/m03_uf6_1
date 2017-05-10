/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03_uf6_1;

import Persistencia.ConfigConnexio;
import java.util.Scanner;
import vista.vistaText;

/**
 *
 * @author Daniel
 */
public class M03_uf6_1 {

    
    /**
     * @param args the command line arguments
     */
     public static boolean salir;
    public static void main(String[] args) {
        // TODO code application logic here
    salir = false;

        ConfigConnexio con = new ConfigConnexio();
        con.connectar();

    //MOSTRAR MENU
    while(salir == false){
    vistaText vista = new vistaText();
    vista.MostrarMenu();
    }
    }
   


    
}
