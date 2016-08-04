package Mundo;


import Inteligencia.Constantes;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


/**
 *
 * @author ian
 */

public class Celda extends JComponent implements Constantes {
    public int x,y;
    public char tipo;
    public Boolean mover;
    public int indexSprite, indexSpriteMalos;
    public BufferedImage jugador,obstaculo,camino,muerto, adversario, comida,explosion;
    public BufferedImage soldier[],soldierComida[],secuenciaImg, malos[], secuencia2;
    
    public Celda(int x,int y,char tipo) {
        this.x=x; 
        this.y=y;
        this.tipo=tipo;
        indexSprite=0;
        indexSpriteMalos=0;
        
        try {
         
           comida = ImageIO.read(new File("images/comida.png"));
           muerto = ImageIO.read(new File("images/muerto.png"));
           //cargamos imagenes sprites
           secuenciaImg = ImageIO.read(new File("images/soldier3.png")); 
           soldier = new BufferedImage[6 * 4];
         
           for(int i = 0; i < 6; i++) {
              for(int j = 0; j < 4; j++) {
                 soldier[(i * 4) + j] = 
                         secuenciaImg.getSubimage(i * sizeJugador, j * sizeJugador, sizeJugador, sizeJugador);
          
              }
           }
           
           secuenciaImg = ImageIO.read(new File("images/malos3.png"));  
           malos = new BufferedImage[6 * 4];
          for(int i = 0; i < 6; i++) {
              for(int j = 0; j < 4; j++) {
                 malos[(i * 4) + j] = 
                         secuenciaImg.getSubimage(i * sizeJugador, j * sizeJugador, sizeJugador, sizeJugador);
              }
           }
        
        } catch (IOException e) {
           System.out.println(e.toString()); 
        }  
        
    }
    
    @Override
    public void update(Graphics g) {
       switch(tipo) { 
           case 'J': g.drawImage(soldier[indexSprite],x,y, this); break;
           case 'O':  break; //OBSTACULO, NO PUEDE PASAR
           case 'P': g.drawImage(comida,x,y, this); break;
           case 'C': break; //CAMINO
               case 'G': break; //CAMINO
           case 'A': g.drawImage(malos[indexSpriteMalos],x,y, this); break;
           case 'M':  g.drawImage(muerto,x,y, this); break;
       }  
       
    }
    
    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }
    
    
    public boolean dentro_area(int xp,int yp) {
       Rectangle r=new Rectangle(x,y,sizeCell,sizeCell);
       return r.contains(new Point(xp,yp)); 
   }
    

    
    
    
}