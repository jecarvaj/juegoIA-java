package Interfaz;


import Inteligencia.Constantes;
import Mundo.Laberinto;
import Mundo.Lienzo;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GraphicsDevice;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ian
 */
public class VentanaPrincipal extends JFrame implements ActionListener, Constantes{
    
     public Lienzo lienzo;
     public Panel panel;
   
    public JButton boton;
    public boolean virtual;
    
    public VentanaPrincipal(boolean virtual){
        this.virtual=virtual;
        lienzo=new Lienzo(virtual);
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        lienzo.setSize(960, 720);
        lienzo.setVisible(true);
       this.setUndecorated(true); 
       
    
        //this.setSize(1210,768 ); //dimension de la foto de fondo mas el panel
        panel=new Panel();
        //abajo=new PanelAbajo();
        //----------cambiamos el cursorr!!------------------------------------------------------------------------------
                Image im; 
            im = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/botones/cursor.png"));
            Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL"); 
            setCursor(cur); 
    //-------------cambiamos el cursorr!!----------------------------------------------------------------------------
     //this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
       //this.setUndecorated(true);  
      this.setSize(1152,864);
      
        System.out.println("the resolution is "+Toolkit.getDefaultToolkit().getScreenSize());
        
        this.getContentPane().setLayout(new BorderLayout());
        
        this.getContentPane().add(lienzo, BorderLayout.WEST);
         this.getContentPane().add(panel, BorderLayout.CENTER);
         //this.getContentPane().add(abajo, BorderLayout.SOUTH);
         
        panel.comenzar.addActionListener(this);
        panel.terminar.addActionListener(this);
        panel.salir.addActionListener(this);
        panel.subirBueno.addActionListener(this);
        panel.bajarBueno.addActionListener(this);
        panel.subirMalo.addActionListener(this);
        panel.bajarMalo.addActionListener(this);
        panel.mute.addActionListener(this);
        panel.sonido.addActionListener(this);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==panel.comenzar) {
            if(virtual){
                
          if((lienzo.nivelBueno==null || lienzo.nivelMalo==null)){
          ImageIcon m=new ImageIcon(getClass().getResource("/botones/jim.png"));
        JOptionPane.showMessageDialog(null, "<html><h3><center>No AI.. No game.. <br>Check it!</center></h3></html>",
                                            "Do you remember?",
                                            JOptionPane.INFORMATION_MESSAGE,m);
        panel.iaBueno.setText("-X-");
         panel.iaMalo.setText("-X-");
            panel.texto.setText("Debes seleccionar\n inteligencia!");
          }else{
              panel.texto.setText("Let's Go!\n");
              panel.texto.append("Jugador "+lienzo.nivelBueno);
               panel.texto.append("\nAdversario "+lienzo.nivelMalo);
             lienzo.ponerTimer();
          }}else{lienzo.ponerTimer();panel.texto.setText("Let's Go!");}
        
            System.out.println("se apreta boton comenzar");
            
        }
        if (e.getSource()==panel.terminar) {
            lienzo.terminar();
            panel.texto.setText("Partida Cancelada");
            System.out.println("se apreta boton terminar");
        }
        if (e.getSource()==panel.salir) {
            System.out.println("se apreta boton salir");
            System.exit(0);
        }
        if (e.getSource()==panel.subirBueno) {
           lienzo.nivelBueno="maximo";
            panel.texto.setText("Jugador al Maximo");
            panel.iaBueno.setText("MAX");
         //JOptionPane.showMessageDialog(null,"nivel bueno es "+panel.laberinto.nivelBueno+" nivel malo es "+panel.laberinto.nivelMalo);
            
        }
        if (e.getSource()==panel.bajarBueno) {
             lienzo.nivelBueno="minimo";
             panel.iaBueno.setText("MIN");
            panel.texto.setText("Jugador al Minimo");
        }
        if (e.getSource()==panel.subirMalo) {
            lienzo.nivelMalo="maximo";
            panel.iaMalo.setText("MAX");
            panel.texto.setText("Adversario al Maximo");;
        }
        if (e.getSource()==panel.bajarMalo) {
            lienzo.nivelMalo="minimo";
            panel.iaMalo.setText("MIN");
            panel.texto.setText("Adversario al Minimo");
        }
        if (e.getSource()==panel.mute) {
            System.out.println("se apreta boton mute");
           panel.player.cancion.stop();
        }
        if (e.getSource()==panel.sonido) {
            System.out.println("se apreta boton snido");
           
            panel.player.cancion.start();
           
        }
    }

   
   
}
