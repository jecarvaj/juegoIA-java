package Interfaz;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
public class LoadingPanel extends JPanel {
    public LoadingPanel(){

    
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
        ImageIcon fondo = new ImageIcon(getClass().getResource("/botones/loading.png"));        
        g.drawImage(fondo.getImage(),0,0,d.width, d.height, null);        
        setOpaque(false);
        
    }
    
}
