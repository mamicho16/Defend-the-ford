/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defendthefort;

import defendthefort.Entidades.Entidad;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author diegomoramontes
 */
public class Partida extends Thread implements Serializable{
    private int nivel;
    private int campos;
    public Entidad[][] juego = new Entidad[25][25];
    public JButton[][] botones = new JButton[25][25];
    private int xCama = 13;
    private int yCama = 13;
    private String estado = "inicio";
    private ArrayList<Integer> idsZombies = new ArrayList<>();

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getxCama() {
        return xCama;
    }

    public void setxCama(int xCama) {
        this.xCama = xCama;
    }

    public int getyCama() {
        return yCama;
    }

    public void setyCama(int yCama) {
        this.yCama = yCama;
    }
    
    public Partida() {
        init();
        this.nivel = 1;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    private void init(){
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                juego[i][j] = null;
            }
        }
    }
    
    
    public int escogerCuadro(int x, int x2){
        if(x < x2){
            x = x+1;
        }else if(x > x2){
            x = x - 1;
        } 
        return x;
    }
    
    public void iniciar(){
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                if(juego[i][j] != null){
                    juego[i][j].start();
                }
            }
        }
        start();
    }
    
    public void imprimirlista(){
        if(idsZombies != null){
            for(Integer i: idsZombies){
                System.out.println(i);
            }
        }
    }
    
    public void imprimirJuego(){
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if(juego[i][j] != null)
                    System.out.println(juego[i][j].getX() +":" + juego[i][j].getY() + " " +juego[i][j].getNombre() + " " + juego[i][j].getVida());
            }
        }
    }
    
    public void mensaje(boolean zombiesVivos){
        if(zombiesVivos){
            JOptionPane.showMessageDialog(null,"PERDISTE");
        } else{
            JOptionPane.showMessageDialog(null,"FELICIDADEZ GANASTE");
        }

    }
    
    
    @Override
    public void run(){
       ArrayList<Integer> zombiesInicializados = new ArrayList<>();
       ArrayList<Integer> defensasInicializadas = new ArrayList<>();
       int objetivoX;
       int objetivoY;
       ImageIcon imageIcon;
       boolean zombiesVivos = true;
            while (juego[xCama][yCama].vivo() && zombiesVivos){
                try {
                sleep(1000);
                idsZombies.clear();
                zombiesVivos = false;
                for(int i = 0; i < 25; i++){
                    for(int j = 0; j < 25; j++){
                        imageIcon = null;
                        if(juego[i][j] != null){
                            juego[i][j].setJuego(juego);
                            if(juego[i][j].esZombie()){
                                if(juego[i][j].vivo() == false){
                                    imageIcon = new ImageIcon("/Users/diegomoramontes/Desktop/tumba.png");
                                    Image image = imageIcon.getImage();
                                    Image newimg = image.getScaledInstance(20, 30,  java.awt.Image.SCALE_SMOOTH);
                                    imageIcon = new ImageIcon(newimg);
                                }
                                if(imageIcon!=null){
                                    botones[i][j].setText("");
                                    botones[i][j].setIcon(imageIcon);
                                }
                                
                                if(juego[i][j].vivo()){
                                    zombiesVivos = true;
                                    objetivoX = juego[i][j].buscarObjetivo(xCama,yCama).getX();
                                    objetivoY = juego[i][j].buscarObjetivo(xCama,yCama).getY();
                                    
                                    juego[i][j].getAlcance();
                                    int distX = juego[i][j].diferenciaNumeros(i,objetivoX);
                                    int distY =juego[i][j].diferenciaNumeros(j,objetivoY);
                                    if(juego[i][j].deDistancia()){
                                    }
                                    if((juego[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)] == null || !juego[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)].vivo()) && !idsZombies.contains(juego[i][j].getIdEntidad()) && juego[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)] != juego[xCama][yCama] && (!juego[i][j].deDistancia() || (!(distX == 0 && distY == juego[i][j].getAlcance()) && !(distY == 0 && distX == juego[i][j].getAlcance()))/*((i !=  objetivoX || j != objetivoY) && (distX > juego[i][j].getAlcance() || distY > juego[i][j].getAlcance())*/)){
                                            idsZombies.add(juego[i][j].getIdEntidad());
                                            juego[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)] = juego[i][j];
                                            juego[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)].setX(escogerCuadro(i, objetivoX));
                                            juego[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)].setY(escogerCuadro(j, objetivoY));
                                            botones[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)].setText("");
                                            botones[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)].setIcon(botones[i][j].getIcon());
                                            juego[i][j].setIsPaused(true);

                                            juego[i][j] = null;
                                            botones[i][j].setIcon(null);
                                            botones[i][j].setText("   ");
                                            
                                    } else if(juego[escogerCuadro(i, objetivoX)][escogerCuadro(j, objetivoY)] != null || ((juego[i][j].deDistancia() && (i ==  objetivoX || j == objetivoY) && distX + distY <= juego[i][j].getAlcance()) && juego[objetivoX][objetivoY].vivo()) && !idsZombies.contains(juego[i][j].getIdEntidad())){
                                        juego[i][j].setJuego(juego);
                                        
                                        if((juego[i][j].vuela() == juego[objetivoX][objetivoY].vuela()) || juego[i][j].vuela()){
                                            juego[i][j].setIsPaused(false);
                                            
                                            if(!zombiesInicializados.contains(juego[i][j].getIdEntidad()) && !juego[i][j].isAlive()){
                                                zombiesInicializados.add(juego[i][j].getIdEntidad());
                                                juego[i][j].start();
                                            }
                                        }
                                    }
                                }
                            }else{
                                
                                if(!juego[i][j].vivo() && juego[i][j] != juego[xCama][yCama]){
                                    imageIcon = new ImageIcon("/Users/diegomoramontes/Desktop/estructuraDestruida.png");
                                    Image image = imageIcon.getImage();
                                    Image newimg = image.getScaledInstance(20, 30,  java.awt.Image.SCALE_SMOOTH);
                                    imageIcon = new ImageIcon(newimg);
                                    juego[i][j].setIsPaused(true);
                                } else if(!juego[i][j].vivo() && juego[i][j] == juego[xCama][yCama]){
                                    imageIcon = new ImageIcon("/Users/diegomoramontes/Desktop/nuke.png"); 
                                    Image image = imageIcon.getImage(); 
                                    Image newimg = image.getScaledInstance(42, 33,  java.awt.Image.SCALE_SMOOTH);
                                    imageIcon = new ImageIcon(newimg);
                                }
                                if(imageIcon!=null){
                                    botones[i][j].setText("");
                                    botones[i][j].setIcon(imageIcon);
                                }
                                juego[i][j].setJuego(juego);
                                juego[i][j].setX(i);
                                juego[i][j].setY(j);   
                                
                                if(!defensasInicializadas.contains(juego[i][j].getIdEntidad()) && !juego[i][j].isAlive()){
                                    defensasInicializadas.add(juego[i][j].getIdEntidad());
                                    juego[i][j].start();
                                }
                            }
                        }
                    }
                }
                } catch (InterruptedException ex) {
                }
            }
            setEstado("final");
            mensaje(zombiesVivos);
            
    }
    
    
    
    
    
    
    
}
