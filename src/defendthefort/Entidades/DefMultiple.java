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
public class DefMultiple extends Entidad  implements Serializable{
    
    private int disparos;
    private int alcance;
    
    public DefMultiple(int disparos, int alcance, String nombre, int vida, String img1, String img2, int campos, int nivelAparicion, int frecuenciaAtaque) {
        super(nombre, vida, img1, img2, campos, nivelAparicion, frecuenciaAtaque);
        this.disparos = disparos;
        this.alcance = alcance;
    }    
    @Override
    public void atacar(int x, int y) {
        
    }

    public int getDisparos() {
        return disparos;
    }

    public void setDisparos(int disparos) {
        this.disparos = disparos;
    }
    
    @Override
    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }
    
    @Override
    public void run(){
        int f = 1000/ this.getFrecuenciaAtaque();
        Entidad cama = obtenerCama();
        
        while(obtenerCama().vivo() && vivo()){
            try {
                for (int i = 0; i < 25; i++) {
                    for (int j = 0; j < 25; j++) {
                        if(juego[i][j] != null && juego[i][j].esZombie() && juego[i][j].vivo()){
                            if((i <= this.getX() +alcance && i >= this.getX() - alcance) && (j <= this.getY() +alcance && j >= this.getY() - alcance)){
                                if(!juego[i][j].vuela()){
                                    for (int k = 0; k < disparos; k++) {
                                        if(juego[i][j].getVida() > 0){
                                            juego[i][j].setVida(juego[i][j].getVida()-1);
                                            juego[i][j].danoRecibido.add(this.getNombre() + " -1"+" (" +this.getIdEntidad() + ")");
                                            danoGenerado.add(juego[i][j].getNombre() + " +1"+" (" +juego[i][j].getIdEntidad() + ")");
                                        }
                                    }
                                    sleep(f);
                                }   
                            }
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
