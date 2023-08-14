/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defendthefort.Entidades;

import java.io.Serializable;

/**
 *
 * @author diegomoramontes
 */
public class ZomContacto extends Entidad  implements Serializable{
    
    
    public ZomContacto(String nombre, int vida, String img1, String img2, int campos, int nivelAparicion, int frecuenciaAtaque) {
        super(nombre, vida, img1, img2, campos, nivelAparicion, frecuenciaAtaque);
    }
    
    @Override
    public void atacar(int x, int y) {
        
    }
    
    @Override
    public boolean esZombie(){
        return true;
    }
}
