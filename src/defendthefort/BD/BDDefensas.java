/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defendthefort.BD;

import defendthefort.Entidades.Entidad;
import defendthefort.Usuario;
import java.util.ArrayList;

/**
 *
 * @author diegomoramontes
 */
public class BDDefensas {
    private String filepath = "defensas.txt";
    private ArrayList<Entidad> defensas;
    
    public void restaurar(){
        defensas = (ArrayList<Entidad>) FileManager.readObject(filepath);
    }
    
    public ArrayList getDefensas(){
        restaurar();
        return defensas;
    }
    
    public void BDDefensas(){
        defensas = new ArrayList<Entidad>();
        restaurar();
    }
    
    public void guardar(Entidad d){
       restaurar();
        if( d != null){
            if( defensas == null){
                defensas = new ArrayList<Entidad>();
            }
            defensas.add(d);
            FileManager.writeObject(defensas, filepath);
        }
    }
    
       
    public Entidad buscarDefensa(String nombre){
        restaurar();
        if(defensas != null){
            for (Entidad d : defensas) {
                if (d.getNombre().equals(nombre))
                    return d;
            }
        }
        return null;
    }
    
    public void imprimirDefensas(){
        restaurar();
        if( defensas != null){
            for(Entidad d: defensas){
                System.out.println(d.toString());
            }
        }
    } 
    
    public ArrayList<Entidad> buscarDefensasNivel(int nivel){
        ArrayList<Entidad> defensasNivel = new ArrayList<Entidad>();
        restaurar();
        if(defensas != null){
            for (Entidad d : defensas) {
                if (d.getNivelAparicion() <= nivel)
                    defensasNivel.add(d);
            }
        }
        return defensasNivel;
    }
}
