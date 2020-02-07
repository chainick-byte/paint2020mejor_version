package codigo;

import codigo.formas.Circulo;
import codigo.formas.Cuadrado;
import codigo.formas.Estrella;
import codigo.formas.Forma;
import codigo.formas.Linea;
import codigo.formas.Pentagono;
import codigo.formas.Texto;
import codigo.formas.Trazo;
import codigo.formas.Triangulo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rocio Soriano/ Alejandro Serrano/ Igor Repyakh
 */
public class VentanaPaint extends javax.swing.JFrame {

    /**
     * un buffer acelera, guarda una memoria intermedia que acelera la lectura
     * del disco a la memoria. Servirá para que podamos dibujar en el jpanel,
     * que lo hace la tarjeta de memoria
     */
    BufferedImage buffer0, buffer1, buffer2, buffer3, buffer4, buffer5 = null;
    BufferedImage[] buffers = {buffer0, buffer1, buffer2, buffer3, buffer4, buffer5};

    Graphics2D bufferGraphics0 //este es el lienzo
            , bufferGraphics1, bufferGraphics2, bufferGraphics3, bufferGraphics4, bufferGraphics5, jpanelGraphics = null;
    Graphics2D[] buffersG = {bufferGraphics0, bufferGraphics1, bufferGraphics2, bufferGraphics3, bufferGraphics4, bufferGraphics5};

    int bufferActual = 0;
    int bufferProvisional = 5;
    
    int numDeshacer=0;
    Circulo miCirculo = null;
    //para que la forma no de error
    Forma miForma = new Forma(-1, -1, 1, Color.white, false);
    // final static int SPRAY = 2;
    
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean bPainting = false;
    private Graphics g;
    Texto texto = new Texto("quick", -1, -1, Color.black);
    BasicStroke trazo1 = new BasicStroke(15);
    BasicStroke trazo2 = new BasicStroke(15,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f,
            new float[]{10.0f},
            0.0f);

    public VentanaPaint() {
        initComponents();
        inicializaBuffers();
       
        jDialog1.setSize(700, 600);
        ImageIcon miImagen
                = new ImageIcon(
                        new ImageIcon(getClass().getResource("/codigo/iconosPaint/paleta.png"))
                                .getImage()
                                .getScaledInstance(jButton1.getWidth(), jButton1.getHeight(),
                                        Image.SCALE_DEFAULT));

        jButton1.setIcon(miImagen);
        
    }

    private void inicializaBuffers() {
        //queremos enlazar bufferGraphics (dibuja), jpanelGraphics.

        //se crea una imagen de igual ancho y alto q el JPanel1
        //Buffer almacena
        for (int i = 0; i < 6; i++) {
            buffers[i] = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        }

        //creo una imagen modificable
        for (int j = 0; j < 6; j++) {
            buffersG[j] = buffers[j].createGraphics();
        }

        for (int k = 0; k < 6; k++) {
            buffersG[k].setColor(Color.WHITE);
        }
        // inicializo el buffer para que se pinte de blanco entero 

        //mismo ancho y alto que nuestro jpanel
        for (int l = 0; l < 6; l++) {
            buffersG[l].fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        }

        //enlazamos el jPanel1 con el JPanelGraphics, de esa forma lo q 
        //dibujemos dentro del JpanelGraphics irá al Jpanel1
        jpanelGraphics = (Graphics2D) jPanel1.getGraphics();

    }

    /**
     * Enlazamos el jPanel con la zona que dibujamos sobreescribiendo un metodo:
     *
     * @Override
     */
    @Override
    public void paint(Graphics g) {
        //llamamos al jframe para el metodo paint que ya existia ignorando el codigo preexistente
        super.paint(g);

        // pinto el buffer sobre el jPanel, 
        jpanelGraphics.drawImage(buffers[bufferActual], 0, 0, null);
    }
    public void buffersDIferentes(){
         bufferActual++;
        if(bufferActual ==5){
            bufferActual=0;
        }
        String sBufferActual=String.valueOf(bufferActual);
        jLabel1.setText("Buffer " + sBufferActual);
        // he cargado ctrl+z por algun momento de abajo he copiado esta aqui y puedo dibujar en bauffer dado sin que aparezca 
        // figuras previas
         jpanelGraphics.drawImage(buffers[bufferActual], 0, 0, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog4 = new javax.swing.JDialog();
        jFileChooser4 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        colores1 = new codigo.PanelColores();
        herramientas1 = new codigo.Herramientas();
        jButton1 = new javax.swing.JButton();
        jFileChooser2 = new javax.swing.JFileChooser();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jButton2.setText("MSI CANCELADO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Quiero este!!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(81, 81, 81))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)))
        );

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        jFileChooser4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
            .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jFileChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
            .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jFileChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        herramientas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                herramientas1MouseClicked(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(50);
        jSlider1.setValue(0);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });

        jLabel1.setText("Buffer 0");

        jMenu1.setText("Archivo");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Undo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Redo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Guardar");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Guardar como...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Cargar ");

        jMenuItem2.setText("Abrir Archivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ayudita bro");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(herramientas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                            .addComponent(colores1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(colores1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        buffersG[bufferActual].drawImage(buffers[bufferProvisional], 0, 0, null);

        if (herramientas1.formaElegida == 1) {
            miCirculo.dibujate(buffersG[bufferActual], evt.getX(), new Trazo(jSlider1.getValue()));
            buffersG[bufferActual].drawImage(buffers[bufferProvisional], 0, 0, null);
        }
        if (herramientas1.formaElegida != 11) {

            switch (herramientas1.formaElegida) {
                //herramienta de Trazo recto
                case -1:

                    x2 = evt.getX();
                    y2 = evt.getY();
                    if (x1 != x2 || y1 != y2) {
                        buffersG[bufferProvisional].setColor(Color.WHITE);
                        buffersG[bufferProvisional].setStroke(new Trazo(30));
                        buffersG[bufferProvisional].drawLine(x1, y1, x2, y2);
                        x1 = x2;
                        y1 = y2;
                    }
                    break;
                case 0:

                    x2 = evt.getX();
                    y2 = evt.getY();
                    if (x1 != x2 || y1 != y2) {
                        buffersG[bufferProvisional].setColor(colores1.colorSeleccionado);
                        buffersG[bufferProvisional].setStroke(new Trazo(jSlider1.getValue()));
                        buffersG[bufferProvisional].drawLine(x1, y1, x2, y2);
                        x1 = x2;
                        y1 = y2;
                    }
                    break;

                case 8:
                    int nMouseX = evt.getX();
                    int nMouseY = evt.getY();
                    if (bPainting) {
                        for (int nPaint = 0; nPaint < 25; nPaint++) {
                            //generate a random distance from 0 to 19
                            int nRand = (int) (Math.random() * 20);
                            //generate a random angle from 0 to 2 pi
                            double dTheta = Math.random() * 628 / 100.0;
                            //find x and y of random dot
                            int nX = (int) (nMouseX + nRand * Math.cos(dTheta));
                            int nY = (int) (nMouseY + nRand * Math.sin(dTheta));

                            buffersG[bufferProvisional].setColor(colores1.colorSeleccionado);
                            buffersG[bufferProvisional].drawOval(nX, nY, 1, 1);

                        }

                    }
                    break;
                case 1:
                    miCirculo.dibujate(buffersG[bufferActual], evt.getX(), new Trazo(jSlider1.getValue()));
                    break;

                default:
                    if (herramientas1.discontinuo == true) {
                        miForma.dibujate(buffersG[bufferActual], evt.getY(), evt.getX(), new Trazo(jSlider1.getValue(), true));
                    } else {
                        miForma.dibujate(buffersG[bufferActual], evt.getY(), evt.getX(), new Trazo(jSlider1.getValue()));
                    }
                    break;
            }
            repaint(0, 0, 1, 1);
        }
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        buffersDIferentes();
        if (herramientas1.formaElegida != 11) {

            System.out.println("quick");

            switch (herramientas1.formaElegida) {

                //goma de borrar
                case -1:
                    x1 = evt.getX();
                    y1 = evt.getY();
                case 0:
                    //trazo recto
                    x1 = evt.getX();
                    y1 = evt.getY();
                    break;

                case 1:
                    miCirculo = new Circulo(evt.getX(), evt.getY(), 1, colores1.colorSeleccionado, herramientas1.relleno);

                    break;

                case 2:
                    //linea recta
                    miForma = new Linea(evt.getX(), evt.getY(), 2, colores1.colorSeleccionado, herramientas1.relleno);

                    break;

                case 3:
                    miForma = new Triangulo(evt.getX(), evt.getY(), 3, colores1.colorSeleccionado, herramientas1.relleno);

                    break;

                case 4:
                    miForma = new Cuadrado(evt.getX(), evt.getY(), 4, colores1.colorSeleccionado, herramientas1.relleno);

                    break;
                case 5:
                    miForma = new Pentagono(evt.getX(), evt.getY(), 5, colores1.colorSeleccionado, herramientas1.relleno);

                    break;
                case 8:
                    bPainting = true;
                    break;

                case 256:
                    miForma = new Estrella(evt.getX(), evt.getY(), 256, colores1.colorSeleccionado, herramientas1.relleno);
                    break;
            }
        }
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        //saco el texto fuera del switch si no me dibuja la forma correspondiente
        if (herramientas1.formaElegida == 11) {
            texto = new Texto(herramientas1.textoDibujado, evt.getX(), evt.getY(), Color.BLACK);
            buffersG[bufferProvisional].drawString(herramientas1.textoDibujado, evt.getX(), evt.getY());
            //buffersG[bufferProvisional].drawImage(buffers[bufferProvisional], 0, 0, null);
            buffersG[bufferActual].drawImage(buffers[bufferProvisional], 0, 0, null);
            repaint(0, 0, 1, 1);
        } else {
            //si es el circulo lo dibuja sobre el buffer2
            switch (herramientas1.formaElegida) {

                case 0:
                    buffersG[bufferProvisional].drawImage(buffers[bufferActual], 0, 0, null);
                    repaint(0, 0, 1, 1);
                    break;
                case 8:
                    buffersG[bufferProvisional].drawImage(buffers[bufferProvisional], 0, 0, null);
                    repaint(0, 0, 1, 1);
                    break;

                //herramienta pipeta que captura el color del pixel
                case 13:
                    Color c = new Color(buffers[bufferActual].getRGB(evt.getX(), evt.getY()));
                    colores1.colorSeleccionado = c;
                    colores1.jLabel34.setBackground(c);
                    break;
                case 1:
                   // buffersG[bufferProvisional].drawImage(buffers[bufferActual], 0, 0, null);

                    repaint(0, 0, 1, 1);
                    break;

                default:
                    if (herramientas1.discontinuo == true && herramientas1.formaElegida != 11) {
                        miForma.dibujate(buffersG[bufferActual], evt.getY(), evt.getX(), new Trazo(jSlider1.getValue(), true));
                    } else {
                        miForma.dibujate(buffersG[bufferActual], evt.getY(), evt.getX(), new Trazo(jSlider1.getValue()));
                    }
                    //buffersG[bufferActual].drawImage(buffers[bufferProvisional], 0, 0, null);
                    buffersG[bufferProvisional].drawImage(buffers[bufferActual], 0, 0, null);
                    //buffersG[bufferActual].drawImage(buffers[bufferProvisional], 0, 0, null);
                    //buffersG[bufferProvisional].drawImage(buffers[bufferProvisional], 0, 0, null);
                    repaint(0, 0, 1, 1);
                    break;

            }
        }
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog1.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialog1.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialog1.setVisible(false);
        colores1.colorSeleccionado = jColorChooser1.getColor();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //queremos que se muestre aqui
        int seleccion = jFileChooser1.showSaveDialog(this);
        if (seleccion == jFileChooser1.APPROVE_OPTION) {
            //si estra aqui es xk el usuario ha pulsado en "guardar"
            File fichero = jFileChooser1.getSelectedFile();
            String nombre = fichero.getName();
            String extension = nombre.substring(nombre.lastIndexOf('.') + 1, nombre.length());
            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {

                try {
                    buffersG[bufferActual].drawImage(ImageIO.read(fichero), 0, 0, null);
                    buffersG[bufferProvisional].drawImage(ImageIO.read(fichero), 0, 0, null);
                } catch (IOException e) {

                }
            }
        } else {

            //mensaje de extensión no valido
        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("arhivos de imagen jpg", "jpg"));
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("arhivos de imagen png", "png"));
        int seleccion = jFileChooser1.showOpenDialog(this);

        if (seleccion == jFileChooser4.APPROVE_OPTION) {
            File fichero = jFileChooser1.getSelectedFile();
            String nombre = fichero.getName();
            String extension = nombre.substring(nombre.lastIndexOf('.') + 1, nombre.length());

            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
                try {
                    buffers[bufferActual] = ImageIO.read(fichero);
                    repaint(0, 0, 1, 1);
                } catch (IOException ex) {
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jFileChooser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser4ActionPerformed
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
    }//GEN-LAST:event_jFileChooser4ActionPerformed

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
        jSlider1.getValue();
    }//GEN-LAST:event_jSlider1MouseDragged

    private void herramientas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_herramientas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_herramientas1MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
     int bufferPrevio = 0;
        if (numDeshacer <= 4 && numDeshacer>0) {
          bufferPrevio = bufferActual--;
           if(bufferPrevio == 1){
             bufferActual =4;
           }           
            jpanelGraphics.drawImage(buffers[bufferPrevio], 0, 0, null);
            repaint(0,0,1,1); 
            String sBufferPrevio = String.valueOf(bufferPrevio);
           jLabel1.setText("Buffer " + sBufferPrevio); 
            jpanelGraphics.drawImage(buffers[bufferActual], 0, 0, null);
            repaint(0, 0, 1, 1);
            numDeshacer++;
        }
    
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         if(numDeshacer > 0){
            int bufferSiguiente = bufferActual++;
            jpanelGraphics.drawImage(buffers[bufferSiguiente], 0, 0, null);
            String sBufferSiguiente = String.valueOf(bufferSiguiente);
            jLabel1.setText("Buffer " + sBufferSiguiente);
            repaint(0, 0, 1, 1);
            numDeshacer--;
           if(numDeshacer==1){
               numDeshacer=4;
           }
            
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPaint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public codigo.PanelColores colores1;
    private codigo.Herramientas herramientas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JFileChooser jFileChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
