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
            
            model.Usuari usu = new model.Usuari("77128797E", "joana", "villalba");
            gu.afegir(usu);
        break;
    
        case 2:
        //METODO AFEGIR LLISTA
            List<Usuari> lista = new ArrayList<Usuari>();
            model.Usuari usu1 = new model.Usuari("123456789", "pepe", "pepito");
            model.Usuari usu2 = new model.Usuari("12345745E", "mireia", "villalba");
            model.Usuari usu3 = new model.Usuari("741852963", "mati", "astete");
            model.Usuari usu4 = new model.Usuari("54698712P", "rocky", "villalba");
            lista.add(0,usu1);
            lista.add(1,usu2);
            lista.add(2,usu3);
            lista.add(3,usu4);
            
            gu.afegirLlista(lista);
        break;
        
        case 3:
        //METODO ESBORRAR
            String nif = "77128797E";
            gu.eliminar(nif);
            
        break;
        
        case 4:
        //METODO MODIFICAR
            model.Usuari usuM = new model.Usuari("123456789", "pepeModificado", "pepitoModificado");
            gu.modficar(usuM);
        break;
        
        case 5:
        //METODO CERCA PER NIF
            gu.cercarNif("77128797E");
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
