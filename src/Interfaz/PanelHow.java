package Interfaz;

import Interfaz.Menu;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class PanelHow extends JPanel implements ActionListener {
    public JButton salirBoton;
    private final JFrame principal;
    private Menu menu;
  public ImageIcon salirIcon, salirIcon2;
        public PanelHow(JFrame principal,Menu menu){
            this.menu=menu;
            salirBoton=new JButton();
            this.setVisible(true);
            
            this.principal=principal;
            this.setLayout(null);
        salirIcon=new ImageIcon(getClass().getResource("/botones/salir.png"));
        salirIcon2=new ImageIcon(getClass().getResource("/botones/salir2.png"));
              
       
        salirBoton.setBounds(930, 645, 71, 62);
        salirBoton.setIcon(salirIcon);
        salirBoton.setRolloverIcon(salirIcon2);
        salirBoton.setBorderPainted(false);
        salirBoton.setBorder(null);
        salirBoton.addActionListener(this);
        add(salirBoton);
      //----------cambiamos el cursorr!!------------------------------------------------------------------------------
                Image im; 
            im = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/botones/cursor.png"));
            Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL"); 
            setCursor(cur); 
    //-------------cambiamos el cursorr!!----------------------------------------------------------------------------
    
    }
    
      @Override
    public void paintComponent(Graphics g){
        Dimension d = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/botones/fondohowto.png"));        
        g.drawImage(fondo.getImage(),0,0,d.width, d.height, null);        
        setOpaque(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==salirBoton){
            this.setVisible(false);
            principal.setVisible(true);
            menu.setVisible(true);
            principal.getContentPane().add(menu);
            
            System.out.println("se apreta salirrrr");
           
        
        }
    }
    
}


