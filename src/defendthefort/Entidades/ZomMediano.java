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
public class ZomMediano extends Entidad  implements Serializable{
    private int alcance;
    
    
    public ZomMediano(int alcance, String nombre, int vida, String img1, String img2, int campos, int nivelAparicion, int frecuenciaAtaque) {
        super(nombre, vida, img1, img2, campos, nivelAparicion, frecuenciaAtaque);
        this.alcance = alcance;
    }        
    @Override
    public void atacar(int x, int y) {
        
    }
    
    @Override
    public boolean esZombie(){
        return true;
    }
    
    @Override
    public boolean deDistancia(){
        return true;
    }

    @Override
    public int getAlcance() {
        return this.alcance; 
    }
    
    
     @Override
    public void run(){
         System.out.println(this.getFrecuenciaAtaque());
        int f = 1000/ this.getFrecuenciaAtaque();
        Entidad objetivo = null;
        Entidad cama = obtenerCama();
        
        while(obtenerCama().vivo() && vivo()){
        objetivo = buscarObjetivo(cama.getX(),cama.getY());
           try {
                sleep(1000);
                while(obtenerCama().vivo() && objetivo.vivo() && vivo()){
                    if(!objetivo.vuela() && ((this.getY() == objetivo.getY() && diferenciaNumeros(this.getX(), objetivo.getX()) <= alcance) || (this.getX()== objetivo.getX() && diferenciaNumeros(this.getY(), objetivo.getY()) <= alcance)|| (diferenciaNumeros(this.getY(), objetivo.getY()) <= 1 && diferenciaNumeros(this.getX(), objetivo.getX()) <= 1))){
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
