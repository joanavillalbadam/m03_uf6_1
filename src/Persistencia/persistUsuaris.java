/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuari;

/**
 *
 * @author Daniel
 */
public class persistUsuaris {

    Connection con;

    public persistUsuaris(Connection con) {
        this.con = con;
    }

    public boolean afegir(Usuari u) {
        boolean x = true;
        try {
            Statement s = con.createStatement();
            String sentencia = "INSERT INTO usuaris(nif, nom, cognom) values "
                    + "('" + u.getNif() + "','" + u.getNom() + "','" + u.getCognom() + "')";
            System.out.println("UPDATE: " + s.executeUpdate(sentencia));
//            s.execute(sentencia);
            s.close();//tanca el recurs 
            x = true;
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            x = false;
        }
        return x;
    }

    public boolean afegirArray(List<Usuari> llista) {
        boolean x = true;
        try {
            for(int i = 0; i < llista.size(); i++){
            Statement s = con.createStatement();
            String sentencia = "INSERT INTO usuaris(nif, nom, cognom) values "
                    + "('" + llista.get(i).getNif() + "','" + llista.get(i).getNom() + "','" + llista.get(i).getCognom() + "')";
            System.out.println("UPDATE: " + s.executeUpdate(sentencia));
//            s.execute(sentencia);
            s.close();//tanca el recurs 
            x = true;
            }
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            x = false;
        }
        return x;
    }

    public boolean esborrar(String nif) {
 boolean eliminat = false;

        try {
            Statement s = con.createStatement();
            //Executar una sentència SQL 
            s.executeUpdate("DELETE FROM usuaris WHERE nif='" + nif+"'");
            eliminat = true;
            s.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return eliminat;
    }

    public boolean modificar(Usuari u) {
    boolean modificat = false;
        PreparedStatement ps;

        try {
            String sentencia = "UPDATE usuaris SET nom=? WHERE nif=?";
            ps = con.prepareStatement(sentencia);
            ps.setString(2, u.getNif());
            ps.setString(1, u.getNom());
            ps.executeUpdate();
            modificat = true;
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modificat;
    }

    public Usuari Cercar(String nif) {

         Usuari u = null;
        try {
            Statement s = con.createStatement();
            ResultSet rs;

            //Executar una sentència SQL per recuperar un departament
            rs = s.executeQuery("SELECT * FROM usuaris WHERE nif='" + nif + "'");

            if (rs.next()) {
                u = new Usuari(rs.getString(1), rs.getString(2), rs.getString(3));
                System.out.println(u.getNom()+" "+u.getCognom());
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    public List<Usuari> cercarTots() {

      ArrayList<Usuari> llista = new ArrayList();

        try {
            Statement s = con.createStatement();
            ResultSet rs;

            rs = s.executeQuery("SELECT * FROM usuaris");
            ResultSetMetaData rsMeta = rs.getMetaData();
           int i =0;
            while (rs.next()) {
                llista.add(new Usuari(rs.getString(1), rs.getString(2), rs.getString(3)));
                //for(int i = 0; i < llista.size() ; i++){ 
               
                System.out.println(llista.get(i).getNom());
                i++;
//}
                }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return llista;
    }
}
