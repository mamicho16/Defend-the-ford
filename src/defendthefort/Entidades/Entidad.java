/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defendthefort.Entidades;

import defendthefort.Partida;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegomoramontes
 */
public class Entidad extends Thread implements Serializable {
    private int id;
    private String nombre;
    private int vida;
    private String img1;
    private String img2;
    private int campos;
    private int nivelAparicion;
    private int frecuenciaAtaque;
    boolean isPaused = false;
    public Entidad[][] juego = new Entidad[25][25];
    private int x;
    private int y;
    public ArrayList<String> danoRecibido = new ArrayList<>();
    public ArrayList<String> danoGenerado = new ArrayList<>();


    
    public void atacar(int x, int y){
        
    }

    public Entidad() {
    }
    
    public Entidad(String nombre, int vida, String img1, String img2, int campos, int nivelAparicion, int frecuenciaAtaque) {
        this.nombre = nombre;
        this.vida = vida;
        this.img1 = img1;
        this.img2 = img2;
        this.campos = campos;
        this.nivelAparicion = nivelAparicion;
        this.frecuenciaAtaque = frecuenciaAtaque;
    }

    public boolean isIsPaused() {
        return isPaused;
    }

    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Entidad[][] getJuego() {
        return juego;
    }

    public void setJuego(Entidad[][] juego) {
        this.juego = juego;
    }
    
    public Entidad(String nombre, int vida, String img1) {
        this.nombre = nombre;
        this.vida = vida;
        this.img1 = img1;
    }
    
    public boolean vivo(){
        if(this.vida > 0){
            return true;
        }
        return false;
    }
    
    public int getIdEntidad () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }

    public int getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

    public int getFrecuenciaAtaque() {
        return frecuenciaAtaque;
    }

    public void setFrecuenciaAtaque(int frecuenciaAtaque) {
        this.frecuenciaAtaque = frecuenciaAtaque;
    }

    @Override
    public String toString() {
        return "Entidad{ id ="+id + ", nombre=" + nombre + ", vida=" + vida + ", campos=" + campos + ", nivelAparicion=" + nivelAparicion + ", frecuenciaAtaque=" + frecuenciaAtaque + '}';
    }
    
    public String getCords(){
        return (getX() +":"+ getY());
    }
    
    public boolean esZombie(){
        return false;
    }
    public boolean vuela(){
        return false;
    }
    public boolean deDistancia(){
        return false;
    }
    
    public int getAlcance(){
        return 1;
    }
    
    public Entidad obtenerCama(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if(juego[i][j] != null && juego[i][j].getNombre().equals("cama")){
                    juego[i][j].setX(i);
                    juego[i][j].setY(j);
                    return juego[i][j];
                }
            }
        }
        return null;
    }
    
    public int diferenciaNumeros(int num1, int num2){
        int diferencia = Math.abs(num1 - num2);
        return diferencia;
    }
    
    
    public Entidad buscarObjetivo(int xCama, int yCama){
        int x2 = xCama;
        int y2 = yCama;
        Entidad d = juego[xCama][yCama];
        d.setX(xCama);
        d.setY(yCama);
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                    if(juego[i][j] != null && !juego[i][j].esZombie() && juego[i][j].vivo() && !juego[i][j].vuela()){
                        if(diferenciaNumeros(x2,x) + diferenciaNumeros(y2,y) > diferenciaNumeros(i,x) + diferenciaNumeros(j,y)){
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
        int f = 1000/ frecuenciaAtaque;
        Entidad objetivo = null;
        Entidad cama = obtenerCama();
        
        while(obtenerCama().vivo() && vivo()){
        objetivo = buscarObjetivo(cama.getX(),cama.getY());
                
           try {
                sleep(500);
                while(obtenerCama().vivo() && objetivo.vivo() && vivo()){
                    
                    if(!objetivo.vuela() && diferenciaNumeros(getX(),objetivo.getX()) <= 1 && diferenciaNumeros(getY(),objetivo.getY()) <= 1){
                        if(objetivo.getVida() > 0){
                            objetivo.setVida(objetivo.getVida()-1);
                            danoGenerado.add(objetivo.getNombre() + " +1 (" + objetivo.getIdEntidad() + ")");
                            objetivo.danoRecibido.add(nombre + " -1"+" ("+id+")");
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
