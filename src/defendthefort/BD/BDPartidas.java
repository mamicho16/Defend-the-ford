/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defendthefort.BD;

import defendthefort.Entidades.Entidad;
import defendthefort.Partida;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegomoramontes
 */
public class BDPartidas  implements Serializable{
    
    private String filepath = "partidas.txt";
    private ArrayList<Partida> partidas;
    
    public void guardar(Partida p){
        restaurar();
        if( partidas == null)
            partidas = new ArrayList<Partida>();
        partidas.add(p);
        FileManager.writeObject(partidas, filepath);
    }
    
    public void restaurar(){
        partidas = (ArrayList<Partida>) FileManager.readObject(filepath);
    }
    
    public void editarPartida(int index, Partida p){
        restaurar();
        partidas.set(index, p);
        FileManager.writeObject(partidas, filepath);
    }
    
    public Partida obtenerPartida(int index){
        restaurar();
        return partidas.get(index);
    }
    
}
