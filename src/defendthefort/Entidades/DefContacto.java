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
public class DefContacto extends Entidad  implements Serializable{

    @Override
    public void atacar(int x, int y) {
        
    }
    
    public DefContacto(String nombre, int vida, String img1, String img2, int campos, int nivelAparicion, int frecuenciaAtaque) {
        super(nombre, vida, img1, img2, campos, nivelAparicion, frecuenciaAtaque);
    }
    
    @Override
    public void run(){
        int f = 1000/ this.getFrecuenciaAtaque();
        Entidad cama = obtenerCama();
        
        while(obtenerCama().vivo() && vivo()){
            try {
                for (int i = 0; i < 25; i++) {
                    for (int j = 0; j < 25; j++) {
                        if(juego[i][j] != null && !juego[i][j].vuela() && juego[i][j].esZombie() && juego[i][j].vivo() && (i <= this.getX() +1 && i >= this.getX() - 1) && (j <= this.getY() +1 && j >= this.getY() - 1)){
                             if(juego[i][j].getVida() > 0){
                                juego[i][j].setVida(juego[i][j].getVida()-1);
                                juego[i][j].danoRecibido.add(this.getNombre() + " -1"+" (" +this.getIdEntidad() + ")");
                                danoGenerado.add( juego[i][j].getNombre() + " +1"+" (" +juego[i][j].getIdEntidad() + ")");
                            }
                            sleep(f);
                        }
                    }
                }
            } catch (InterruptedException ex) {
            }
            while (isPaused) {                
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
