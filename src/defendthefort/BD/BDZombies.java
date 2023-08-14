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
public class BDZombies {
    private String filepath = "zombies.txt";
    private ArrayList<Entidad> zombies;
    
    public void restaurar(){
        zombies = (ArrayList<Entidad>) FileManager.readObject(filepath);
    }  
        
    public ArrayList getZombies(){
        restaurar();
        return zombies;
    }
    
    public void BDZombies(){
        zombies = new ArrayList<Entidad>();
        restaurar();
    }
    
    public void guardar(Entidad z){
       restaurar();
       if( z != null){
            if( zombies == null){
                zombies = new ArrayList<Entidad>();
            }
            zombies.add(z);
            FileManager.writeObject(zombies, filepath);
       }
    }
       
    public Entidad buscarZombie(String nombre){
        restaurar();
        if(zombies != null){
            for (Entidad z : zombies) {
                if (z.getNombre().equals(nombre))
                    return z;
            }
        }
        return null;
    }
    
    public void imprimirZombies(){
        restaurar();
        if( zombies != null){
            for(Entidad z: zombies){
                System.out.println(z.toString());
            }
        }
    }   
    
    public ArrayList<Entidad> buscarZombiesNivel(int nivel){
        ArrayList<Entidad> zombiesNivel = new ArrayList<Entidad>();
       restaurar();
        if(zombies != null){
            for (Entidad z : zombies) {
                if (z.getNivelAparicion() <= nivel)
                    zombiesNivel.add(z);
            }
        }
        return zombiesNivel;
    }
}
