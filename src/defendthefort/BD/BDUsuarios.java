/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defendthefort.BD;

import defendthefort.Partida;
import defendthefort.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class BDUsuarios implements Serializable{
    private String filepath = "usuarios.txt";
    private ArrayList<Usuario> usuarios;
    BDPartidas partidas = new BDPartidas();

    
    public ArrayList getUsuarios(){
        restaurar();
        return usuarios;
    }
    
    public void BDUsuarios(){
        usuarios = new ArrayList<Usuario>();
        restaurar();
    }
    
    public void guardar(Usuario u){
       restaurar();
        if( usuarios == null){
            usuarios = new ArrayList<Usuario>();
        }
        usuarios.add(u);
        FileManager.writeObject(usuarios, filepath);
    }
    
    public void restaurar(){
        usuarios = (ArrayList<Usuario>) FileManager.readObject(filepath);
    }
       
    public boolean buscarUsuario(String user, String psw){
        restaurar();
        if(usuarios != null){
            for (Usuario usuario : usuarios) {
                if (usuario.getUser().equals(user) && usuario.getPassword().equals(psw))
                    return true;
            }
        }
        return false;
    }
    
    public void imprimirUsuarios(){
        restaurar();
        if( usuarios != null){
            for(Usuario u: usuarios){
                System.out.println(u.toString());
            }
        }
    }
    
    public Partida obtenerPartida(String user, String psw){
        restaurar();
        if(usuarios != null){
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
                if (usuario.getUser().equals(user) && usuario.getPassword().equals(psw)){
                    Partida p = partidas.obtenerPartida(usuarios.indexOf(usuario));
                    return p;
                }
            }
        }
        return null;
    }
    
    public void guardarPartida(String user, String psw, Partida p){
        restaurar();
        if(usuarios != null){
            for (Usuario usuario : usuarios) {
                if (usuario.getUser().equals(user) && usuario.getPassword().equals(psw)){
                    partidas.editarPartida(usuarios.indexOf(usuario), p);
                    System.out.print(usuario.toString() + " : " + usuarios.indexOf(usuario));
                    break;
                }
            }
        }
    }
    
}
