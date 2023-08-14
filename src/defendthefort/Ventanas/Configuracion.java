/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package defendthefort.Ventanas;

import defendthefort.BD.BDDefensas;
import defendthefort.BD.BDZombies;
import defendthefort.Entidades.DefAereo;
import defendthefort.Entidades.DefBloque;
import defendthefort.Entidades.DefContacto;
import defendthefort.Entidades.DefImpacto;
import defendthefort.Entidades.DefMediano;
import defendthefort.Entidades.DefMultiple;
import defendthefort.Entidades.Entidad;
import defendthefort.Entidades.ZomAereo;
import defendthefort.Entidades.ZomChoque;
import defendthefort.Entidades.ZomContacto;
import defendthefort.Entidades.ZomMediano;
import javax.accessibility.Accessible;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

/**
 *
 * @author diegomoramontes
 */
public class Configuracion extends javax.swing.JFrame implements Accessible{
    BDZombies zombies = new BDZombies();
    BDDefensas defensas = new BDDefensas();

    
    public Configuracion() {
        initComponents();
        
        zombies.restaurar();
        defensas.restaurar();
        
        JFileChooser f = new JFileChooser();
        String[] zombies = {"De contacto","Aéreo","Mediano alcance","Choque"};
        String[] defensas = {"De contacto","Mediano alcance","Aéreos","Impacto","Ataque múltiple","Bloques"};

        cbZombies.setModel(new DefaultComboBoxModel(zombies));
        cbDefensas.setModel(new DefaultComboBoxModel(defensas));
        
        txfAlcanceDef.setEnabled(false);
        txfRangoDef.setEnabled(false);
        txfDisparosDef.setEnabled(false); 
        txfAlcanceZom.setEnabled(false);
        txfRangoZom.setEnabled(false);  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbZombies = new javax.swing.JComboBox<>();
        cbDefensas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfNombreDef = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfVidaDef = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txfAtaqueDef = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        txfCamposDef = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txfNivelDef = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txfVidaZom = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        txfAtaqueZom = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        txfCamposZom = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        txfNivelZom = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        txfNombreZom = new javax.swing.JTextField();
        btnCrearDef = new javax.swing.JButton();
        btnCrearZom = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txfRangoDef = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txfRangoZom = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        txfAlcanceDef = new javax.swing.JSpinner();
        txfAlcanceZom = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txfDisparosDef = new javax.swing.JSpinner();
        txfImg1Zom = new javax.swing.JTextField();
        txfImg1Def = new javax.swing.JTextField();
        txfImg2Def = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txfImg2Zom = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbZombies.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbZombies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZombiesActionPerformed(evt);
            }
        });

        cbDefensas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDefensas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDefensasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel1.setText("Nueva Defensa");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel3.setText("Nuevo Zombie");

        jLabel2.setText("Nombre");

        jLabel4.setText("Vida (Cantidad de golpes)");

        jLabel5.setText("Ataque (Golpes por segundo)");

        jLabel6.setText("Campos");

        jLabel7.setText("Nivel de Aparición");

        jLabel8.setText("Vida (Cantidad de golpes)");

        jLabel9.setText("Ataque (Golpes por segundo)");

        jLabel10.setText("Campos");

        jLabel11.setText("Nivel de Aparición");

        btnCrearDef.setText("Crear");
        btnCrearDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDefActionPerformed(evt);
            }
        });

        btnCrearZom.setText("Crear");
        btnCrearZom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearZomActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre");

        jLabel14.setText("Rango de Exploción");

        jLabel15.setText("Rango de Exploción");

        jLabel16.setText("Alcance de Ataque");

        jLabel17.setText("Alcance de Ataque");

        jLabel18.setText("Numero de Disparos");

        jLabel12.setText("Imagen 1");

        jLabel19.setText("jLabel19");

        jLabel20.setText("Imagen 2");

        jLabel21.setText("Imagen 1");

        jLabel22.setText("Imagen 2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnCrearDef)
                        .addGap(371, 371, 371))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txfNombreDef, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfCamposDef, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txfAtaqueDef, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txfVidaDef, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel12)))
                                            .addComponent(txfImg1Def, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(txfRangoDef, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)
                                            .addComponent(txfAlcanceDef, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(txfNivelDef, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18)
                                            .addComponent(txfDisparosDef, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txfImg2Def, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addComponent(jLabel20))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(cbDefensas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(184, 184, 184)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbZombies, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txfAtaqueZom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(25, 25, 25)
                                                    .addComponent(jLabel10))
                                                .addComponent(txfCamposZom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txfImg2Zom, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(77, 77, 77)))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txfNombreZom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txfVidaZom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel17)
                                            .addComponent(txfAlcanceZom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfRangoZom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(txfNivelZom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15)
                                            .addComponent(txfImg1Zom, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(117, 117, 117))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCrearZom)
                        .addGap(172, 172, 172))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel22)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(617, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(92, 92, 92)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(cbZombies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNombreZom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfVidaZom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfAtaqueZom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txfCamposZom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfImg1Zom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNivelZom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfRangoZom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfAlcanceZom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfImg2Zom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCrearZom))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbDefensas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(0, 0, 0)
                                .addComponent(txfNombreDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfVidaDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfAtaqueDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfCamposDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfImg1Def, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfNivelDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfRangoDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfAlcanceDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfDisparosDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfImg2Def, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(btnCrearDef)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel3)
                    .addContainerGap(448, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDefActionPerformed
        Entidad d = null;
        if(cbDefensas.getSelectedItem().equals("Bloques")){
            d = new DefBloque(txfNombreDef.getText() + " - Bloque", (int)txfVidaDef.getValue(),txfImg1Def.getText(),txfImg2Def.getText(),(int)txfCamposDef.getValue(), (int)txfNivelDef.getValue() ,(int)txfAtaqueDef.getValue());
        } else if(cbDefensas.getSelectedItem().equals("De contacto")){
            d = new DefContacto(txfNombreDef.getText() + " - De contacto", (int)txfVidaDef.getValue(),txfImg1Def.getText(),txfImg2Def.getText(),(int)txfCamposDef.getValue(), (int)txfNivelDef.getValue() ,(int)txfAtaqueDef.getValue());
        } else if(cbDefensas.getSelectedItem().equals("Mediano alcance")){
            d = new DefMediano((int)txfAlcanceDef.getValue(), txfNombreDef.getText() + " - Mediano alcance", (int)txfVidaDef.getValue(),txfImg1Def.getText(),txfImg2Def.getText(),(int)txfCamposDef.getValue(), (int)txfNivelDef.getValue() ,(int)txfAtaqueDef.getValue());
        } else if(cbDefensas.getSelectedItem().equals("Aéreos")){
            d = new DefAereo(txfNombreDef.getText() + " - Aéreo", (int)txfVidaDef.getValue(),txfImg1Def.getText(),txfImg2Def.getText(),(int)txfCamposDef.getValue(), (int)txfNivelDef.getValue() ,(int)txfAtaqueDef.getValue());
        } else if(cbDefensas.getSelectedItem().equals("Ataque múltiple")){
            d = new DefMultiple((int)txfDisparosDef.getValue(), (int)txfAlcanceDef.getValue(), txfNombreDef.getText() + " - Ataque múltiple", (int)txfVidaDef.getValue(),txfImg1Def.getText(),txfImg2Def.getText(),(int)txfCamposDef.getValue(), (int)txfNivelDef.getValue() ,(int)txfAtaqueDef.getValue());
        }else if(cbDefensas.getSelectedItem().equals("Impacto")){
            d = new DefImpacto((int)txfRangoDef.getValue(),txfNombreDef.getText() + " - Impacto", (int)txfVidaDef.getValue(),txfImg1Def.getText(),txfImg2Def.getText(),(int)txfCamposDef.getValue(), (int)txfNivelDef.getValue());
        }
        defensas.guardar(d);
        defensas.imprimirDefensas();
    }//GEN-LAST:event_btnCrearDefActionPerformed

    private void btnCrearZomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearZomActionPerformed
        Entidad z = null;
        if(cbZombies.getSelectedItem().equals("De contacto")){
            z = new ZomContacto(txfNombreZom.getText() + " - De contacto", (int)txfVidaZom.getValue(),txfImg1Zom.getText(),txfImg2Zom.getText(),(int)txfCamposZom.getValue(), (int)txfNivelZom.getValue() ,(int)txfAtaqueZom.getValue());
        } else if(cbZombies.getSelectedItem().equals("Mediano alcance")){
            z = new ZomMediano((int)txfAlcanceZom.getValue() , txfNombreZom.getText() + " - Mediano alcance", (int)txfVidaZom.getValue(),txfImg1Zom.getText(),txfImg2Zom.getText(),(int)txfCamposZom.getValue(), (int)txfNivelZom.getValue() ,(int)txfAtaqueZom.getValue());
        } else if(cbZombies.getSelectedItem().equals("Aéreo")){
            z = new ZomAereo(txfNombreZom.getText() + " - Aéreo", (int)txfVidaZom.getValue(),txfImg1Zom.getText(),txfImg2Zom.getText(),(int)txfCamposZom.getValue(), (int)txfNivelZom.getValue() ,(int)txfAtaqueZom.getValue());
        }else if(cbZombies.getSelectedItem().equals("Choque")){
            z = new ZomChoque((int)txfRangoZom.getValue(),txfNombreZom.getText() + " - Impacto", (int)txfVidaZom.getValue(),txfImg1Zom.getText(),txfImg2Zom.getText(),(int)txfCamposZom.getValue(), (int)txfNivelZom.getValue());
        }
        zombies.guardar(z);
        zombies.imprimirZombies();
    }//GEN-LAST:event_btnCrearZomActionPerformed

    private void cbDefensasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDefensasActionPerformed
        if(cbDefensas.getSelectedItem().equals("Bloques")){
            txfAtaqueDef.setEnabled(false);
            txfAlcanceDef.setEnabled(false);
            txfRangoDef.setEnabled(false);
            txfDisparosDef.setEnabled(false);
        } else if(cbDefensas.getSelectedItem().equals("De contacto")){
            txfAtaqueDef.setEnabled(true);
            txfAlcanceDef.setEnabled(false);
            txfRangoDef.setEnabled(false);
            txfDisparosDef.setEnabled(false);        
        } else if(cbDefensas.getSelectedItem().equals("Mediano alcance")){
            txfAtaqueDef.setEnabled(true);
            txfAlcanceDef.setEnabled(true);
            txfRangoDef.setEnabled(false);
            txfDisparosDef.setEnabled(false);    
        } else if(cbDefensas.getSelectedItem().equals("Aéreos")){
            txfAtaqueDef.setEnabled(true);
            txfAlcanceDef.setEnabled(false);
            txfRangoDef.setEnabled(false);
            txfDisparosDef.setEnabled(false);    
        } else if(cbDefensas.getSelectedItem().equals("Ataque múltiple")){
            txfAtaqueDef.setEnabled(true);
            txfAlcanceDef.setEnabled(true);
            txfRangoDef.setEnabled(false);
            txfDisparosDef.setEnabled(true);    
        }else if(cbDefensas.getSelectedItem().equals("Impacto")){
            txfAtaqueDef.setEnabled(false);
            txfAlcanceDef.setEnabled(false);
            txfRangoDef.setEnabled(true);
            txfDisparosDef.setEnabled(false);    
        }
    }//GEN-LAST:event_cbDefensasActionPerformed

    private void cbZombiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZombiesActionPerformed
        if(cbZombies.getSelectedItem().equals("De contacto")){
            txfAlcanceZom.setEnabled(false);
            txfRangoZom.setEnabled(false);
        } else if(cbZombies.getSelectedItem().equals("Aéreo")){
            txfAlcanceZom.setEnabled(false);
            txfRangoZom.setEnabled(false);
        } else if(cbZombies.getSelectedItem().equals("Mediano alcance")){
            txfAlcanceZom.setEnabled(true);
            txfRangoZom.setEnabled(false);
        } else if(cbZombies.getSelectedItem().equals("Choque")){
            txfAlcanceZom.setEnabled(false);
            txfRangoZom.setEnabled(true);
        } 
    }//GEN-LAST:event_cbZombiesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearDef;
    private javax.swing.JButton btnCrearZom;
    private javax.swing.JComboBox<String> cbDefensas;
    private javax.swing.JComboBox<String> cbZombies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner txfAlcanceDef;
    private javax.swing.JSpinner txfAlcanceZom;
    private javax.swing.JSpinner txfAtaqueDef;
    private javax.swing.JSpinner txfAtaqueZom;
    private javax.swing.JSpinner txfCamposDef;
    private javax.swing.JSpinner txfCamposZom;
    private javax.swing.JSpinner txfDisparosDef;
    private javax.swing.JTextField txfImg1Def;
    private javax.swing.JTextField txfImg1Zom;
    private javax.swing.JTextField txfImg2Def;
    private javax.swing.JTextField txfImg2Zom;
    private javax.swing.JSpinner txfNivelDef;
    private javax.swing.JSpinner txfNivelZom;
    private javax.swing.JTextField txfNombreDef;
    private javax.swing.JTextField txfNombreZom;
    private javax.swing.JSpinner txfRangoDef;
    private javax.swing.JSpinner txfRangoZom;
    private javax.swing.JSpinner txfVidaDef;
    private javax.swing.JSpinner txfVidaZom;
    // End of variables declaration//GEN-END:variables
}
