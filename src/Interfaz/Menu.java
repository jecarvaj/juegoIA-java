package Interfaz;
import Inteligencia.*;


import Interfaz.VentanaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class Menu extends JPanel implements Constantes{
      public HiloMusica player;
       public JButton playerBoton, cpuBoton, salirBoton, howBoton, aboutBoton, musicaBoton;
       public JLabel malo, bueno;
       
    public Menu()
    {
      this.setLayout(null);
   
        malo=new JLabel();
         bueno=new JLabel();
        playerBoton=new JButton();
        cpuBoton=new JButton();
        salirBoton=new JButton();
        howBoton=new JButton();
        aboutBoton=new JButton();
        musicaBoton=new JButton();
        
         ImageIcon mono=new ImageIcon(getClass().getResource("/botones/canibal.gif"));
         ImageIcon cueva=new ImageIcon(getClass().getResource("/botones/cueva.gif"));
        ImageIcon playerIcon=new ImageIcon(getClass().getResource("/botones/player.png"));
         ImageIcon playerIcon2=new ImageIcon(getClass().getResource("/botones/player2.png"));
        ImageIcon cpuIcon=new ImageIcon(getClass().getResource("/botones/cpu.png"));
         ImageIcon cpuIcon2=new ImageIcon(getClass().getResource("/botones/cpu2.png"));
        ImageIcon salirIcon=new ImageIcon(getClass().getResource("/botones/salir.png"));
        ImageIcon salirIcon2=new ImageIcon(getClass().getResource("/botones/salir2.png"));
        ImageIcon howIcon=new ImageIcon(getClass().getResource("/botones/how.png"));
        ImageIcon howIcon2=new ImageIcon(getClass().getResource("/botones/how2.png"));
        ImageIcon aboutIcon=new ImageIcon(getClass().getResource("/botones/about.png"));
        ImageIcon aboutIcon2=new ImageIcon(getClass().getResource("/botones/about2.png"));
        ImageIcon musicaIcon=new ImageIcon(getClass().getResource("/botones/musica.png"));
        ImageIcon musicaIcon2=new ImageIcon(getClass().getResource("/botones/musica2.png"));
         //boton 1 para comenzar partida
        playerBoton.setIcon(playerIcon);
        playerBoton.setBounds(440, 220, 290, 80);
        playerBoton.setBorderPainted(false);
        playerBoton.setRolloverIcon(playerIcon2);
        playerBoton.setBorder(null);
       //boton2 para terminar partida
         cpuBoton.setIcon(cpuIcon);
        cpuBoton.setBounds(440, 320, 290, 80);
        cpuBoton.setRolloverIcon(cpuIcon2);
        cpuBoton.setBorderPainted(false);
        cpuBoton.setBorder(null);
        
         //boton 1 para comenzar partida
        howBoton.setIcon(howIcon);
        howBoton.setBounds(440, 420, 290, 80);
        howBoton.setRolloverIcon(howIcon2);
        howBoton.setBorderPainted(false);
        howBoton.setBorder(null);
       //boton2 para terminar partida
         aboutBoton.setIcon(aboutIcon);
        aboutBoton.setBounds(440, 520, 290, 80);
        aboutBoton.setRolloverIcon(aboutIcon2);
        aboutBoton.setBorderPainted(false);
        aboutBoton.setBorder(null);
         //boton para salir
        musicaBoton.setIcon(musicaIcon);
        musicaBoton.setBounds(860, 647, 72, 59);
        musicaBoton.setRolloverIcon(musicaIcon2);
        musicaBoton.setBorderPainted(false);
        musicaBoton.setBorder(null);
         //boton para salir
        salirBoton.setIcon(salirIcon);
        salirBoton.setBounds(930, 645, 71, 62);
        salirBoton.setRolloverIcon(salirIcon2);
        salirBoton.setBorderPainted(false);
        salirBoton.setBorder(null);
        //gif con un monito
        malo.setIcon(mono);
        malo.setBounds(300, 610, 130,130);
        
        bueno.setIcon(cueva);
        bueno.setBounds(150, 630, 145,90);
        
          //----------cambiamos el cursorr!!------------------------------------------------------------------------------
                Image im; 
            im = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/botones/cursor.png"));
            Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL"); 
            setCursor(cur); 
    //-------------cambiamos el cursorr!!--------------------------------------------------
        
        
        add(malo);
        add(bueno);
        add(playerBoton);
        add(cpuBoton);
        add(salirBoton);
        add(howBoton);
        add(aboutBoton);
       add(musicaBoton);
         
      player=new HiloMusica(ruta+"/music/musica2.wav",10);
        
    player.run();
        
    
    }
    
      @Override
    public void paintComponent(Graphics g){
        Dimension d = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/botones/fondomenu.png"));        
        g.drawImage(fondo.getImage(),0,0,d.width, d.height, null);        
        setOpaque(false);
        
    }

}
