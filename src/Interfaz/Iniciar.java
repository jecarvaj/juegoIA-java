package Interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class Iniciar implements ActionListener{
    public Menu menu;
    public JFrame ventana;
    //public IniciarLoading load;
    public VentanaPrincipal juego;
    public LoadingPanel panel;
    public  PanelAbout about;
    public PanelHow how;
    public Iniciar(){
         ventana=new JFrame();
         menu=new Menu();
         about=new PanelAbout(ventana,menu);
         how=new PanelHow(ventana,menu);
         //ventana.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        //ventana.setUndecorated(true);  
       ventana.setSize(1152,864);
        ventana.getContentPane().add(menu);
        ventana.setUndecorated(true);
        ventana.setVisible(true);
        
         menu.playerBoton.addActionListener(this);
         menu.cpuBoton.addActionListener(this);
         menu.salirBoton.addActionListener(this);
         menu.howBoton.addActionListener(this);
         menu.aboutBoton.addActionListener(this);
         menu.musicaBoton.addActionListener(this);
        panel=new LoadingPanel();
       
   
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==menu.playerBoton) {
            //.dispose();
             menu.setVisible(false);
               
              
               ventana.getContentPane().add(panel);
              
                    //panel.setSize(1152, 769);
      
                  
                    panel.setVisible(true);
                    
     
         ImageIcon m=new ImageIcon(getClass().getResource("/botones/jim.png"));
        JOptionPane.showMessageDialog(null, "<html><h2><center>The ceremony is about to begin...</center></h2></html>",
                                            "Is everybody in?",
                                            JOptionPane.INFORMATION_MESSAGE,m);
             
              juego=new VentanaPrincipal(false);
            juego.setSize(1152, 864);
         menu.player.cancion.stop();
            ventana.dispose();
          juego.setVisible(true);
//            

        }
        if (e.getSource()==menu.cpuBoton) {
            
                   menu.setVisible(false);
               
              
               ventana.getContentPane().add(panel);
              
                    //panel.setSize(1152, 769);
      
                  
                    panel.setVisible(true);
                    
     
         ImageIcon m=new ImageIcon(getClass().getResource("/botones/jim.png"));
        JOptionPane.showMessageDialog(null, "<html><h2><center>The ceremony is about to begin...</center></h2></html>",
                                            "Is everybody in?",
                                            JOptionPane.INFORMATION_MESSAGE,m);
             
              juego=new VentanaPrincipal(true);
            juego.setSize(1152, 864);
           menu.player.cancion.stop();
            ventana.dispose();
          juego.setVisible(true);
//            
        }
        if (e.getSource()==menu.howBoton) {
              how.setVisible(true);
             ventana.getContentPane().add(how);
            menu.setVisible(false);
            System.out.println("se apreta boton snido");
        }
        if (e.getSource()==menu.aboutBoton) {
             about.setVisible(true);
             ventana.getContentPane().add(about);
            menu.setVisible(false);
           
            
            System.out.println("se apreta boton terminar");
        }
        if (e.getSource()==menu.salirBoton) {
            System.out.println("se apreta boton salir");
            System.exit(0);
        }
       
        if (e.getSource()==menu.musicaBoton) {
            System.out.println("se apreta boton mute");
        menu.player.cancion.stop();
        }
        if (e.getSource()==menu.howBoton) {
            System.out.println("se apreta boton snido");
        }
    }
}
