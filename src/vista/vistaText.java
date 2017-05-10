/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Persistencia.ConfigConnexio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Usuari;

/**
 *
 * @author Daniel
 */
public class vistaText {
     
    public void MostrarMenu() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    ConfigConnexio con = new ConfigConnexio();
    Scanner leer = new Scanner(System.in);
    int opcion;
    System.out.println("Selecciona una opcio!");
    System.out.println("\n 1.-Afegir \n 2.- Afegir llista \n 3.- Esborrar\n 4.- Modificar\n 5.- Cercar per nif \n 6.- Cercar Tots\n 7.- Sortir");
    opcion = leer.nextInt();
    controlador.GestioUsuaris gu = new controlador.GestioUsuaris();
    switch(opcion){
    
         case 1:
        //METODO AFEGIR
            System.out.println("Introduce el dni");
            String dniafegir = leer.next();
            System.out.println("Introduce el nombre");
            String nombre = leer.next();
             System.out.println("Introduce el apellido");
            String apellido = leer.next();
           
            model.Usuari usu = new model.Usuari(dniafegir, nombre, apellido);
            gu.afegir(usu);
        break;
    
        case 2:
        //METODO AFEGIR LLISTA
            List<Usuari> lista = new ArrayList<Usuari>();
            for(int i = 0; i < 5; i++){
            System.out.println("Introduce el dni");
            String dni1 = leer.next();
            System.out.println("Introduce el nombre");
            String nombre1 = leer.next();
            System.out.println("Introduce el apellido");
            String apellido1 = leer.next();
            
            model.Usuari usu1 = new model.Usuari(dni1, nombre1, apellido1);
            lista.add(0,usu1);
            }
            
            gu.afegirLlista(lista);
        break;
        
        case 3:
        //METODO ESBORRAR
            System.out.println("Introduce el dni del usuario que quieres borrar");
            String nif = leer.next();
            gu.eliminar(nif);
            
        break;
        
        case 4:
        //METODO MODIFICAR
            System.out.println("Introduce el dni del usuario que quieres modificar");
            String dni2 = leer.next();
            System.out.println("Introduce el nombre");
            String nombre1 = leer.next();
            System.out.println("Introduce el apellido");
            String apellido1 = leer.next();
           
            model.Usuari usuM = new model.Usuari(dni2, nombre1, apellido1);
            gu.modficar(usuM);
        break;
        
        case 5:
        //METODO CERCA PER NIF
            System.out.println("Introduce el dni del usuario que quieres buscar");
            String dni3 = leer.next();
            gu.cercarNif(dni3);
        break;
        
        case 6:
        //METODO CERCAR TOTS
            gu.cercaTots();
        break;
        
        case 7:
        //METODO SORTIR
            con.tancarConnexio();
            salir();
            break;
       
    }
    
    }

    private void salir() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       controlador.GestioUsuaris gu = new controlador.GestioUsuaris();

        System.out.println("Has salido");
        gu.salir();
    }

    public void mostrarAñadir(boolean añadir) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(añadir == true){
        System.out.println("Se ha añadido con exito");
    }else{
        System.out.println("No se ha podido añadir");
    }
    
    }

    public void mostrarAñadirArr(boolean añadirArr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(añadirArr == true){
        System.out.println("Se han añadido con exito");
    }else{
        System.out.println("No se ha podido añadir");
    }
    }

    public void mostrarElim(boolean eliminar) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     if(eliminar == true){
        System.out.println("Se ha eliminado con exito");
    }else{
        System.out.println("No se ha podido eliminar");
    }
    }

    public void mostrarModif(boolean modif) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     if(modif == true){
        System.out.println("Se ha modificado con exito");
    }else{
        System.out.println("No se ha podido modificar");
    }
    }

    public void mostrarUsuario(Usuari u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(u.toString());
    }

    public void mostrarTodos(List<Usuari> usu) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    for(int i = 0; i < usu.size(); i++){
    usu.get(i).toString();
    }
    
    }
    
}
