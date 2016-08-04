package Interfaz;

import Mundo.*;
import Inteligencia.*;
import java.awt.Color;
import java.awt.Component;



import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 *
 * @author ian
 */

public class Panel extends JPanel implements  Constantes {
    public JButton comenzar, terminar, salir, subirBueno, bajarBueno, 
            subirMalo, bajarMalo, mute, sonido;
    public JLabel gifMono, iaMalo,iaBueno;
    public static JLabel comida1, comida2, comida3;//, musica;
    public JTextArea texto;
    public Laberinto laberinto;
   
    public HiloMusica player;
    
    public Panel(){   
         
        this.setLayout(null);
        
        
        comenzar=new JButton();
        terminar=new JButton();
        salir=new JButton();
        subirBueno=new JButton();
        bajarBueno=new JButton();
        subirMalo=new JButton();
        bajarMalo=new JButton();
        mute=new JButton();
        sonido=new JButton();
        comida1=new JLabel();
        comida2=new JLabel();
        comida3=new JLabel();
        gifMono=new JLabel();
        iaMalo=new JLabel();
        iaBueno=new JLabel();
        texto=new JTextArea();
        
         ImageIcon salir2=new ImageIcon(getClass().getResource("/botones/salir21.png"));
        ImageIcon terminar2=new ImageIcon(getClass().getResource("/botones/terminar2.png"));
        ImageIcon comenzar2=new ImageIcon(getClass().getResource("/botones/comenzar2.png"));
         ImageIcon bajar2=new ImageIcon(getClass().getResource("/botones/bajar2.png"));
        ImageIcon subir2=new ImageIcon(getClass().getResource("/botones/subir2.png"));
        ImageIcon prueba=new ImageIcon(getClass().getResource("/botones/canibal.gif"));
        ImageIcon icono=new ImageIcon(getClass().getResource("/botones/comenzar1.png"));
        ImageIcon icono2=new ImageIcon(getClass().getResource("/botones/terminar1.png"));
        ImageIcon salir1=new ImageIcon(getClass().getResource("/botones/salir1.png"));
        ImageIcon subir1=new ImageIcon(getClass().getResource("/botones/subir1.png"));
        ImageIcon bajar1=new ImageIcon(getClass().getResource("/botones/bajar1.png"));
        ImageIcon mute1=new ImageIcon(getClass().getResource("/botones/mute.png"));
        ImageIcon sonido1=new ImageIcon(getClass().getResource("/botones/sonido.png"));
         ImageIcon mute2=new ImageIcon(getClass().getResource("/botones/mute2.png"));
        ImageIcon sonido2=new ImageIcon(getClass().getResource("/botones/sonido2.png"));
         ImageIcon comida=new ImageIcon(getClass().getResource("/botones/comida.png"));
        //boton 1 para comenzar partida
        comenzar.setIcon(icono);
        comenzar.setBounds(8, 145, 179, 50);
        comenzar.setRolloverIcon(comenzar2);
        comenzar.setBorderPainted(false);
        comenzar.setBorder(null);
       //boton2 para terminar partida
         terminar.setIcon(icono2);
        terminar.setBounds(8, 200, 179, 50);
        terminar.setRolloverIcon(terminar2);
        terminar.setBorderPainted(false);
        terminar.setBorder(null);
         //boton para salir
        salir.setIcon(salir1);
        salir.setBounds(120, 770, 69, 69);
        salir.setRolloverIcon(salir2);
        salir.setBorderPainted(false);
        salir.setBorder(null);
        //boton para subir inteligencia del jugador nuestro
        subirBueno.setIcon(subir1);
        subirBueno.setBounds(56, 320, 30, 30);
        subirBueno.setRolloverIcon(subir2);
        subirBueno.setBorderPainted(false);
        subirBueno.setBorder(null);
        //boton para bajar unteligencia jugador bueno
        bajarBueno.setIcon(bajar1);
        bajarBueno.setBounds(56, 352, 30, 30);
        bajarBueno.setRolloverIcon(bajar2);
        bajarBueno.setBorderPainted(false);
        bajarBueno.setBorder(null);
        //boton para subir inteligencia oponente
        subirMalo.setIcon(subir1);
        subirMalo.setBounds(104, 320, 30, 30);
        subirMalo.setRolloverIcon(subir2);
        subirMalo.setBorderPainted(false);
        subirMalo.setBorder(null);
        //boton para subir inteligencia oponente
        bajarMalo.setIcon(bajar1);
        bajarMalo.setBounds(104, 352, 30, 30);
        bajarMalo.setRolloverIcon(bajar2);
        bajarMalo.setBorderPainted(false);
        bajarMalo.setBorder(null);
        //boton para encender el sonido
        sonido.setIcon(sonido1);
        sonido.setBounds(21, 489, 47, 47);
        sonido.setRolloverIcon(sonido2);
        sonido.setBorderPainted(false);
        sonido.setBorder(null);
         //boton para apagar el sonido
        mute.setIcon(mute1);
        mute.setBounds(129, 490, 47, 47);
        mute.setRolloverIcon(mute2);
        mute.setBorderPainted(false);
        mute.setBorder(null);
        //AGREGARE LOS LABELS
        gifMono.setBounds(0, 740, 90, 130);
        gifMono.setText("holaaaa");
        gifMono.setIcon(prueba);
        gifMono.setVisible(true);
        //
        iaBueno.setBounds(12, 340, 90, 130);
        //iaBueno.setText("MAX");
        iaBueno.setFont(new java.awt.Font("JFRockSolid", Font.BOLD, 16));
        iaBueno.setForeground(Color.ORANGE);
        iaBueno.setVisible(true);
        
        iaMalo.setBounds(130, 340, 90, 130);
       // iaMalo.setText("MIN");
        iaMalo.setFont(new java.awt.Font("JFRockSolid",0, 16));
        iaMalo.setForeground(Color.ORANGE);
        iaMalo.setVisible(true);
        
        
        comida1.setBounds(0, 663, 55, 75);
        comida1.setText("holaaaa");
        //comida1.setIcon(comida);
        comida1.setVisible(true);
        
        
    
                 texto.setBounds(16,580, 166, 140);
                //label.setText("holaaaAAAA");
               texto.setFont(new java.awt.Font("Andy", 0, 16));
               texto.setBorder(BorderFactory.createEmptyBorder()); 
               texto.setOpaque(false);
                //texto.setBackground(new Color(0, 0, 0, 0));
                  texto.setForeground(Color.BLACK);
                  texto.setEditable(false);
                  texto.setLineWrap (true);
                texto.setVisible(true);
               
                
        player=new HiloMusica(ruta+"/music/tribal.wav",10);
        
       player.run();
       
        
         add(comenzar);
         add(terminar);
         add(salir);
         add(subirBueno);
         add(bajarBueno);
         add(subirMalo);
         add(bajarMalo);
         add(mute);
         add(sonido);
         add(texto);
          add(gifMono);
          add(iaBueno);
          add(iaMalo);
    }
    
    

        
   @Override
    public void paintComponent(Graphics g){
        Dimension d = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/botones/menu3.png"));        
        g.drawImage(fondo.getImage(),0,0,d.width, d.height, null);        
        setOpaque(false);
        
    }
    
     void  agregarComida(){
      add(comida1);
    }
    
    
   
}