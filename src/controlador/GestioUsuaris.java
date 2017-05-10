/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Persistencia.ConfigConnexio;
import Persistencia.persistUsuaris;
import java.sql.Connection;
import java.util.List;
import m03_uf6_1.M03_uf6_1;
import model.Usuari;
import vista.vistaText;

/**
 *
 * @author Daniel
 */
public class GestioUsuaris {

    ConfigConnexio cc = new ConfigConnexio();
    Connection con = cc.getCon();
    persistUsuaris pu = new persistUsuaris(con);
    vistaText vista = new vistaText();
    
    public void afegir(Usuari usu) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    boolean añadir = pu.afegir(usu);
    vista.mostrarAñadir(añadir);
    }

    public void afegirLlista(List<Usuari> lista) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    boolean añadirArr = pu.afegirArray(lista);
    vista.mostrarAñadirArr(añadirArr);
    }

    public void eliminar(String nif) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    boolean eliminar = pu.esborrar(nif);
    vista.mostrarElim(eliminar);
    }

    public void modficar(Usuari u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    boolean modif =pu.modificar(u);
    vista.mostrarModif(modif);
    }

    public void cercarNif(String e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Usuari u = pu.Cercar(e);
    vista.mostrarUsuario(u);
    }

    public void cercaTots() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    List<Usuari> usu = pu.cercarTots();
    vista.mostrarTodos(usu);
    }

    public void salir() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    M03_uf6_1 main = new m03_uf6_1.M03_uf6_1();
    cc.tancarConnexio();
    main.salir = true;
    }
    
}
