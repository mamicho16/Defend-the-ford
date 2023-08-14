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
public class ZomAereo extends Entidad  implements Serializable{
    
    public ZomAereo(String nombre, int vida, String img1, String img2, int campos, int nivelAparicion, int frecuenciaAtaque) {
        super(nombre, vida, img1, img2, campos, nivelAparicion, frecuenciaAtaque);
    }    
    
    @Override
    public void atacar(int x, int y) {
        
    }
    
    
   @Override
   public boolean esZombie(){
        return true;
    }
   
    @Override
    public boolean vuela(){
        return true;
    }
    
    public Entidad buscarObjetivo(int xCama, int yCama){
        int x2 = xCama;
        int y2 = yCama;
        Entidad d = juego[xCama][yCama];
        d.setX(xCama);
        d.setY(yCama);
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                    if(juego[i][j] != null && !juego[i][j].esZombie() && juego[i][j].vivo()){
                        if(diferenciaNumeros(x2,this.getX()) + diferenciaNumeros(y2,this.getY()) > diferenciaNumeros(i,getX()) + diferenciaNumeros(j,this.getY())){
                            x2 = i;
                            y2 = j;
                            d.setX(i);
                            d.setY(j);
                            d = juego[i][j];
                        }
                    }
            }
        }
        return d;
    }
    
    
    @Override
    public void run(){
        int f = 1000/ this.getFrecuenciaAtaque();
        Entidad objetivo = null;
        Entidad cama = obtenerCama();
        
        while(obtenerCama().vivo() && vivo()){
        objetivo = buscarObjetivo(cama.getX(),cama.getY());
           try {
                sleep(1000);
                while(obtenerCama().vivo() && objetivo.vivo() && vivo()){
                    if(diferenciaNumeros(getX(),objetivo.getX()) <= 1 && diferenciaNumeros(getY(),objetivo.getY()) <= 1){
                        if(objetivo.getVida() > 0){
                            objetivo.setVida(objetivo.getVida()-1);
                            danoGenerado.add(objetivo.getNombre() + " +1"+" (" +objetivo.getIdEntidad() + ")");
                            objetivo.danoRecibido.add(this.getNombre() + " -1"+" (" +this.getIdEntidad() + ")");
                        }
                        sleep(f);
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
