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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diegomoramontes
 */
public class Estadisticas extends javax.swing.JFrame {
    
    BDUsuarios bdUsuario = new BDUsuarios();
    BDPartidas bdPartida = new BDPartidas();
    BDZombies bdZombie = new BDZombies();
    BDDefensas bdDefensas = new BDDefensas();
    private String user,psw;
    private Entidad[][] juego;
    
    private Partida partida;
    
    private ArrayList<Entidad> defensas;
    private ArrayList<Entidad> zombies;

    public Estadisticas(String user, String psw, ArrayList<Entidad> zombies, ArrayList<Entidad> defensas) {
        this.defensas = defensas;
        this.zombies = zombies;
        this.user = user;
        this.psw = psw;
        partida = bdUsuario.obtenerPartida(user, psw);
        initComponents();
        cargarEstadisticas();
        
        for(Entidad s:this.zombies){
            if(s!= null)
                System.out.println(s.toString());
       }
        for(Entidad s:this.defensas){
            if(s!= null)
                System.out.println(s.toString());
       }
        
        
    }
    
    
    private void cargarEstadisticas(){
        JTable tabla = new JTable();
        
        pnlPrincipal.add(tabla);
        tabla.setVisible(true);
        DefaultTableModel m = (DefaultTableModel)tblEstadisticas.getModel();
        
        Object rowData[] = new Object[5];
        
        String danoGenerado = "", danoRecibido = "";
        int vida;
        for (int i = 0; i < zombies.size(); i++) {
            danoGenerado = "";
            danoRecibido = "";
            rowData[0] = zombies.get(i).getNombre() + " ("+zombies.get(i).getIdEntidad()+")";
            vida = zombies.get(i).danoRecibido.size()+zombies.get(i).getVida();
            rowData[1] = vida+" / "+zombies.get(i).getVida();
            rowData[2] = zombies.get(i).getFrecuenciaAtaque();
            for(String s:zombies.get(i).danoGenerado){
                danoGenerado += s + "/ ";
            }
            for(String s:zombies.get(i).danoRecibido){
                danoRecibido += s + "/ ";
            }
            rowData[3] = danoGenerado;
            rowData[4] = danoRecibido;
            m.addRow(rowData);
        }

        for (int i = 0; i < defensas.size(); i++) {
            danoGenerado = "";
            danoRecibido = "";
            rowData[0] = defensas.get(i).getNombre()+ "("+defensas.get(i).getIdEntidad()+")";
            vida = defensas.get(i).danoRecibido.size()+defensas.get(i).getVida();
            rowData[1] = vida+" / "+defensas.get(i).getVida();
            rowData[2] = defensas.get(i).getFrecuenciaAtaque();
            
            for(String s:defensas.get(i).danoGenerado){
                danoGenerado += s + "/ ";
            }
            
            for(String s:defensas.get(i).danoRecibido){
                danoRecibido += s + "/ ";
            }
            rowData[3] = danoGenerado;
            rowData[4] = danoRecibido;
            m.addRow(rowData);
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        btnReiniciar = new javax.swing.JButton();
        btnSiguienteNivel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstadisticas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnSiguienteNivel.setText("Siguiente Nivel");
        btnSiguienteNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteNivelActionPerformed(evt);
            }
        });

        tblEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Vida I / F", "Ataques PS", "Daño Realizado", "Daño Recibido"
            }
        ));
        jScrollPane1.setViewportView(tblEstadisticas);
        if (tblEstadisticas.getColumnModel().getColumnCount() > 0) {
            tblEstadisticas.getColumnModel().getColumn(1).setPreferredWidth(6);
            tblEstadisticas.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(439, 439, 439)
                .addComponent(btnReiniciar)
                .addGap(26, 26, 26)
                .addComponent(btnSiguienteNivel)
                .addContainerGap(360, Short.MAX_VALUE))
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReiniciar)
                    .addComponent(btnSiguienteNivel))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        Partida p = new Partida();
        p.setNivel(partida.getNivel());
        bdUsuario.guardarPartida(user, psw, p);
         Juego ventana;
        try {
            ventana = new Juego(user, psw);
             ventana.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnSiguienteNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteNivelActionPerformed
        Partida p = new Partida();
        if(partida.getNivel() != 10){
            p.setNivel(partida.getNivel()+1);
        }
        bdUsuario.guardarPartida(user, psw, p);
        
        Juego ventana;
        try {
            ventana = new Juego(user, psw);
             ventana.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSiguienteNivelActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSiguienteNivel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTable tblEstadisticas;
    // End of variables declaration//GEN-END:variables
}
