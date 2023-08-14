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
public class DefImpacto extends Entidad  implements Serializable{
    private int rango;
    
    @Override
    public void atacar(int x, int y) {
        
    }
    
    public DefImpacto(int rango, String nombre, int vida, String img1, String img2, int campos, int nivelAparicion) {
        super(nombre, vida, img1, img2, campos, nivelAparicion, -1);
        this.rango = rango;
    }
     public void run(){
        System.out.println(this.getX() +":"+ this.getY());
        boolean exploto = false;
        Entidad objetivo = null;
        Entidad cama = obtenerCama();
        while(obtenerCama().vivo() && vivo()){
        objetivo = buscarObjetivo(cama.getX(),cama.getY());
           try {
                sleep(1000);
                while(obtenerCama().vivo() && objetivo.vivo() && vivo()){
                    while(!exploto){
                        for (int i = 0; i < 25; i++) {
                            for (int j = 0; j < 25; j++) {
                                if(juego[i][j] != null && juego[i][j].esZombie() && juego[i][j].vivo() && (i <= this.getX() +1 && i >= this.getX() - 1) && (j <= this.getY() +1 && j >= this.getY() - 1)){
                                    if(!juego[i][j].vuela()){
                                        exploto = true;
                                    }   
                                }
                            }
                        }
                    }
                    for (int i = 0; i < 25; i++) {
                        for (int j = 0; j < 25; j++) {
                           if(juego[i][j] != null && juego[i][j].esZombie() && juego[i][j].vivo() && (i <= this.getX() +rango && i >= this.getX() - rango) && (j <= this.getY() +rango && j >= this.getY() - rango)){
                                if(!juego[i][j].vuela() && juego[i][j].getVida() > 0){
                                    danoGenerado.add(juego[i][j].getNombre() + " +" + juego[i][j].getVida() +" (" +this.getIdEntidad() + ")");
                                    juego[i][j].danoRecibido.add(this.getNombre() + " -" + juego[i][j].getVida()+" (" +juego[i][j].getIdEntidad() + ")");
                                    juego[i][j].setVida(0);
                                    exploto = true;
                                }   
                            }
                        }
                    }
                    danoRecibido.add(this.getNombre() + " -" + this.getVida()+ " (" + this.getIdEntidad() + ")");
                    this.setVida(0);
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