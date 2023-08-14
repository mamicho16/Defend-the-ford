/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package defendthefort.Ventanas;

import defendthefort.BD.BDDefensas;
import defendthefort.BD.BDPartidas;
import defendthefort.BD.BDUsuarios;
import defendthefort.BD.BDZombies;
import defendthefort.Entidades.Entidad;
import defendthefort.Partida;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author diegomoramontes
 */
public class Juego extends javax.swing.JFrame {
    BDUsuarios bdUsuario = new BDUsuarios();
    BDPartidas bdPartida = new BDPartidas();
    BDZombies bdZombie = new BDZombies();
    BDDefensas bdDefensas = new BDDefensas();

    private int ancho = 100;
    private int alto = 100;
    Entidad entidadSeleccionada = null;
    private int xSelec;
    private int ySelec;
    private String user;
    private String psw;
    private Random r = new Random();
    
    private int camposZom;
    private int camposDef;
    
    public ArrayList<JButton> btnsDefensas = new ArrayList<>();

    
    private int contDef = 0;
    
    private Entidad cama = new Entidad("cama",1,"/Users/diegomoramontes/Documents/TEC/2do_Semestre/POO/Semana13/DefendTheFort/img/cama.png");
    
    
    private ArrayList<Entidad> defensas;
    private ArrayList<Entidad> defensasCreadas = new ArrayList();

    private ArrayList<Entidad> zombies;
    private ArrayList<Entidad> zombiesCreados= new ArrayList();


    private Partida partida;
    
    public Juego(String user, String psw) throws IOException {
        this.user = user;
        this.psw = psw;
        initComponents();
        partida = bdUsuario.obtenerPartida(user, psw);
        
        partida.setCampos(15 + 5*partida.getNivel());
        this.camposZom = partida.getCampos();
        this.camposDef = partida.getCampos();
        
        generateTextFields();
        cargarDefensasNivel();
        
        pnlPrincipal.setLayout(new GridLayout(25,25));
        Color c = new Color(103,255,89);
        pnlPrincipal.setBackground(c);
        getContentPane().setLayout(null);
        setVisible(true);
        
        this.setTitle("Nivel "+partida.getNivel());


        actualizarBotones();
        calcularCamposUsados();
        deshabilitarDefensas();
    }
    
    
    private void generateTextFields() throws IOException{
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                JButton btnNuevo = new JButton("   ");

                btnNuevo.setSize(alto, ancho);
                btnNuevo.setToolTipText(Integer.toString(i) + "," + Integer.toString(j));
                partida.botones[i][j] = btnNuevo;   
                if((j + i) % 2 == 0){
                    Color c = new Color(25,176,5);
                    btnNuevo.setForeground(c);
                    btnNuevo.setBackground(c);
                }else{
                    Color c = new Color(103,255,89);
                    btnNuevo.setForeground(c);
                    btnNuevo.setBackground(c);
                }
                
                if(i < 3 || i >21 || j < 3 || j >21){
                    btnNuevo.setEnabled(false);
                }
                
                int x = i;
                int y = j;
                
                partida.botones[i][j].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) { 
                        try{
                            Click(btnNuevo,x,y);
                        }catch (IOException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                pnlPrincipal.add(partida.botones[i][j]);
                RedibujarTablero();
            }
        }
        actualizarBotones();
        
    }

    private void cargarDefensasNivel() throws IOException{
        int porcentaje, aumentoDef, aumentoAtaque;
        defensas  = bdDefensas.buscarDefensasNivel(partida.getNivel());
        int x = 0;
        for(Entidad d: defensas){
            porcentaje = r.nextInt(20-5) + 5;
            aumentoDef = (d.getVida()* porcentaje/100 )* (partida.getNivel()-1);
            
            porcentaje = r.nextInt(20-5) + 5;
            aumentoAtaque = (d.getFrecuenciaAtaque()* porcentaje/100 )* (partida.getNivel()-1);
            
            System.out.println(x + " " + d.toString());
            JLabel nombre = new JLabel(d.getNombre());
            pnlDefensas.add(nombre);
            nombre.setSize(150, 30);
            nombre.setLocation(ancho-90, x*45 +4);
            
            JButton defensa = new JButton();
            pnlDefensas.add(defensa);
            ImageIcon imageIcon = new ImageIcon(d.getImg1());
            Image image = imageIcon.getImage(); 
            BufferedImage bimg = ImageIO.read(new File(d.getImg1()));
            
            int imgX = bimg.getHeight() * 30 / bimg.getWidth();
            Image newimg = image.getScaledInstance(imgX, 30,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);  
            defensa.setSize(45, 35);
            defensa.setIcon(imageIcon);
            defensa.setLocation(ancho + 80, 45*x);
            x++;
            
            d.setVida(aumentoDef+d.getVida());
            d.setFrecuenciaAtaque(d.getFrecuenciaAtaque()+aumentoAtaque);

            btnsDefensas.add(defensa);

            defensa.addActionListener(new ActionListener() 
            {
                    @Override
                    public void actionPerformed(ActionEvent e) { 
                        lblNombre.setText(d.getNombre());
                        lblVida.setText(" Golpes de vida: " +d.getVida() );
                        lblCampos.setText(" Campos ocupados: "+ d.getCampos());
                        lblAtaque.setText(" Ataques por segundo: " + d.getFrecuenciaAtaque());
                         if("inicio".equals(partida.getEstado())){
                            Entidad def = bdDefensas.buscarDefensa(d.getNombre());
                            def.setVida(d.getVida());
                            def.setFrecuenciaAtaque(d.getFrecuenciaAtaque());
                            def.setId(contDef);
                            entidadSeleccionada = def;
                            contDef++;
                         }
                    }
            });
        }
    }
    
    private Entidad mejorarEstadisticas(Entidad e){
        //mejora las estadisticas del 
        return e;
    }
    
    
    private void deshabilitarDefensas(){
        camposDef = partida.getCampos() - calcularCamposUsados();
        for(Entidad d: defensas){
            JButton j = btnsDefensas.get(defensas.indexOf(d));
            if(d.getCampos() > camposDef){
                j.setEnabled(false);
            } else{
                j.setEnabled(true);
            }
        }
        lblCamposDisponibles.setText("Campos Disponibles: " + camposDef);
    }
    
    
    private int calcularCamposUsados(){
        int suma = 0;
        contDef = 0;
        if(defensasCreadas!= null){
            defensasCreadas.clear();
        }
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if(partida.juego[i][j] != null && !partida.juego[i][j].esZombie()){
                    suma += partida.juego[i][j].getCampos();
                    defensasCreadas.add(partida.juego[i][j]);
                    contDef++;
                }
            }
        }
        contDef--;
        return suma;
    }
    
    
    
    private void deshabilitarZombies(){
        for(Entidad e: zombies){
            if(e.getCampos() > camposZom){
                if(zombies.size() == 1){
                    zombies = null;
                } else{
                    zombies.remove(zombies.indexOf(e));
                }
            }
        }
    }
    
    
    private void cargarZombiesNivel() throws IOException{
        int porcentaje, aumentoDef, aumentoAtaque;
        zombies  = bdZombie.buscarZombiesNivel(partida.getNivel());
        int i, j;
        deshabilitarZombies();
        int k = 0;
        int z;
        
        while(zombies != null && camposZom > 0){
                z = r.nextInt(zombies.size());
                Entidad zombie =bdZombie.buscarZombie(zombies.get(z).getNombre());
                

                porcentaje = r.nextInt(20-5) + 5;
                aumentoDef = (zombie.getVida()* porcentaje/100 )* (partida.getNivel()-1);
            
                porcentaje = r.nextInt(20-5) + 5;
                aumentoAtaque = (zombie.getFrecuenciaAtaque()* porcentaje/100 )* (partida.getNivel()-1);
                
                zombie.setVida(aumentoDef+zombie.getVida());
                zombie.setFrecuenciaAtaque(zombie.getFrecuenciaAtaque()+aumentoAtaque);
                
                do{
                i = r.nextInt(49);
                int b = i-24;
                if(b < 0){
                    i = r.nextInt(2);
                    if(i == 1){
                        i = 24;
                    }
                } else{
                    i = i-24;
                }
                
                if( i == 0 || i == 24){
                   j = r.nextInt(25);
                } else{
                    j = r.nextInt(2);
                    if(j == 1){
                        j = 24;
                    }
                }

                } while(partida.juego[i][j] != null);
                zombiesCreados.add(zombie);
                partida.juego[i][j] = new Entidad();
                partida.juego[i][j] = zombie;
                partida.juego[i][j].setId(k);
                partida.juego[i][j].setX(i);
                partida.juego[i][j].setY(j);
                k++;
                camposZom -= zombie.getCampos();
                deshabilitarZombies();
                actualizarBotones();
        }
        calcularCamposUsados();
        partida.start();
    }
    
    private void Click(JButton btn,int x, int y) throws IOException{
            if(partida.juego[x][y] != null && "final".equals(partida.getEstado()) || "medio".equals(partida.getEstado())){
                String m = "Vida de ("+partida.juego[x][y].getIdEntidad() +") "+partida.juego[x][y].getNombre()+ " ("+partida.juego[x][y].getVida()+")\n Daño Recibido \n";
                for(String s: partida.juego[x][y].danoRecibido){
                    m+= s + "\n"; 
                }
                m+= "Daño Generado \n";
                for(String s: partida.juego[x][y].danoGenerado){
                    m+= s + "\n"; 
                }
                JOptionPane.showMessageDialog(null, m);
            } else if("inicio".equals(partida.getEstado())){
                if(partida.botones[x][y].getIcon() != null && partida.juego[x][y].vivo()){
                    if(x == partida.getxCama() && y == partida.getyCama()){
                        entidadSeleccionada = cama;
                    }else{
                        entidadSeleccionada = partida.juego[x][y];
                    }
                    xSelec = x;
                    ySelec = y;
                } else {
                    if(xSelec == partida.getxCama() && ySelec == partida.getyCama()){
                        partida.setxCama(x);
                        partida.setyCama(y);
                    }
                    if(entidadSeleccionada != null){
                        partida.juego[x][y] = entidadSeleccionada;

                        btn.setText("   ");
                        btn.setIcon(null);
                        partida.juego[xSelec][ySelec] = null;

                        partida.juego[x][y].setJuego(partida.juego);
                        partida.juego[x][y].setX(x);
                        partida.juego[x][y].setY(y); 

                    }
                    entidadSeleccionada = null;
                    xSelec = 0;
                    ySelec = 0;
                }
            }
        deshabilitarDefensas();
        actualizarBotones();
    }
    
    
    
    private void actualizarBotones() throws IOException{
        System.out.println(partida.getxCama() +":" + partida.getyCama());
        int imgX;
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                if(partida.juego[i][j] != null && !partida.juego[i][j].getNombre().equals("cama")){
                    ImageIcon imageIcon = null;
                    if(partida.juego[i][j].vivo() || partida.juego[i][j].esZombie()){
                        if(partida.juego[i][j].vivo()){
                            BufferedImage bimg = ImageIO.read(new File(partida.juego[i][j].getImg1()));
                            imgX = bimg.getHeight() * 30 / bimg.getWidth();
                            imageIcon = new ImageIcon(partida.juego[i][j].getImg1());
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(imgX, 30,  java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);
                        } else{
                            imageIcon = new ImageIcon("/Users/diegomoramontes/Desktop/tumba.png");
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(20, 30,  java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);
                        }
                        
                    } else if(!partida.juego[i][j].vivo() && i != partida.getxCama() && j != partida.getyCama()){
                        BufferedImage bimg = ImageIO.read(new File("/Users/diegomoramontes/Desktop/estructuraDestruida.png"));
                        imgX = bimg.getHeight() * 30 / bimg.getWidth();
                        imageIcon = new ImageIcon("/Users/diegomoramontes/Desktop/estructuraDestruida.png");
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(imgX, 30,  java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);
                    }
                    partida.botones[i][j].setText("");
                    partida.botones[i][j].setIcon(imageIcon);
                    partida.juego[i][j].setX(i);
                    partida.juego[i][j].setY(j);

                } else if(i == partida.getxCama() && j == partida.getyCama()){
                    ImageIcon imageIcon;
                    if(partida.juego[partida.getxCama()][partida.getyCama()] != null && partida.juego[partida.getxCama()][partida.getyCama()].vivo() == true){
                        imageIcon = new ImageIcon(cama.getImg1()); 
                        Image image = imageIcon.getImage(); 
                        Image newimg = image.getScaledInstance(32, 36,  java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);  
                    } else{
                        imageIcon = new ImageIcon("/Users/diegomoramontes/Desktop/nuke.png"); 
                        Image image = imageIcon.getImage(); 
                        Image newimg = image.getScaledInstance(42, 33,  java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);  
                    }
                    partida.botones[i][j].setIcon(imageIcon);        
                    partida.botones[i][j].setText("");
                    partida.juego[i][j] = cama;

                } else{
                    partida.botones[i][j].setText("   ");
                    partida.botones[i][j].setIcon(null);
                    
                    partida.juego[i][j] = null;
                }
            }
        }
    }
    
    
    
    private void RedibujarTablero(){
        pnlPrincipal.validate();
        pnlPrincipal.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        pnlDefensas = new javax.swing.JPanel();
        pnlInfo = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();
        lblCampos = new javax.swing.JLabel();
        lblAtaque = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnStats = new javax.swing.JButton();
        lblCamposDisponibles = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(51, 255, 0));
        pnlPrincipal.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDefensasLayout = new javax.swing.GroupLayout(pnlDefensas);
        pnlDefensas.setLayout(pnlDefensasLayout);
        pnlDefensasLayout.setHorizontalGroup(
            pnlDefensasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        pnlDefensasLayout.setVerticalGroup(
            pnlDefensasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        pnlInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");

        lblVida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVida.setText("Vida");

        lblCampos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCampos.setText("Campos");

        lblAtaque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtaque.setText("Frecuencia Ataque");

        jLabel1.setText("Información de Defensa");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnStats.setText("Estadisticas");
        btnStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsActionPerformed(evt);
            }
        });

        lblCamposDisponibles.setText("Campos Disponibles");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43))
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAtaque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                        .addComponent(btnIniciar)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                        .addComponent(btnStats)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCamposDisponibles)
                            .addComponent(btnGuardar))
                        .addGap(56, 56, 56))))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCampos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCamposDisponibles)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDefensas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDefensas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10072, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        bdUsuario.guardarPartida(user, psw, partida);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(partida.juego[xSelec][ySelec] != null && partida.juego[xSelec][ySelec] != cama){
            partida.juego[xSelec][ySelec] = null;
            partida.botones[xSelec][ySelec].setIcon(null);
            partida.botones[xSelec][ySelec].setText("   ");
            entidadSeleccionada = null;
            deshabilitarDefensas();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try {
            partida.setEstado("medio");
            btnIniciar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnGuardar.setEnabled(false);
            cargarZombiesNivel();
        } catch (IOException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsActionPerformed
        if(partida.getEstado().equals("final")){
            Estadisticas ventana;
            ventana = new Estadisticas(user, psw, zombiesCreados, defensasCreadas);
            ventana.setVisible(true);
         } else{
            JOptionPane.showMessageDialog(null,"Las estadisticas solo se pueden ver al finalizar la partida");
        }
    }//GEN-LAST:event_btnStatsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAtaque;
    private javax.swing.JLabel lblCampos;
    private javax.swing.JLabel lblCamposDisponibles;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblVida;
    private javax.swing.JPanel pnlDefensas;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
