package Mundo;
import Inteligencia.*;
import Mundo.*;
import Interfaz.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;



/**
 *
 * @author ian
 */


public  class Laberinto extends JComponent implements Constantes {
    
    public int ancho,largo;//laberinto dimensiones
    public Celda[][] casillas;//matriz de casillas 
    public Jugador jugador; //instancia de un jugador
    public Adversario adversario1, adversario2, adversario3, adversario4;
    public Lienzo lienzo; //lienzo donde se dibujaran componentes
    public CrearMapa crear;         //funcion para crear componentes del mapa
    public static int alimento=3;   //cantidad de alimento que aparecera

    
    public Laberinto(Lienzo l) {
       lienzo=l;
       
       casillas=new Celda[anchoGameWorld][altoGameWorld];
       
       for(int i=0; i < anchoGameWorld ; i++) {
            for ( int j=0 ; j < altoGameWorld; j++) {
               
               casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'C');
               
               
            }
       }
       crear= new CrearMapa(casillas, alimento); 
       
//       casillas[5][17]=new Celda(5+(5*sizeCell),
//                                    17+(17*sizeCell),'P');
        
        System.out.println("LAS COMIDAS SONNNNN"+crear.comidas.size()+" y"
                + "LO QUE HAY EN EL X ES "+crear.comidas.get(0).x);
       //crear.comidas.get(1).
       //inicio jugador
       
       
      
      
      // adversario2=new Adversario(this);
       //this.ancho=widthGameWorld*sizeCell;   //lo ajusto a la imagen de fondo
       //this.largo=heightGameWorld*sizeCell;
       this.ancho=720;
       this.largo=960;
       this.setSize(ancho,largo);
     
      //ponerJugadores();
//           
//      jugador=new Jugador(this);
//      adversario1= new Adversario(this,29,29,'m');
//      adversario2=new Adversario(this,20,22,'m');
//      //adversario3=new Adversario(this,28,15);
//     // adversario4=new Adversario(this,15,18);
//      
//      jugador.oponentes.add(adversario1);
//      jugador.oponentes.add(adversario2);
//      
//     // jugador.busqueda=new BusquedaJugador(this);
//      jugador.inteligencia=new InteligenteJugador(this, jugador);
//       //adversario1.buscamalo=new BusquedaAnchura2(this, adversario1);
//       adversario1.buscatonto=new TontoAdversario(this, adversario1, "minimo");
//       adversario2.buscatonto=new TontoAdversario(this, adversario2, "minimo");
//       
//      ArrayList<TontoAdversario> oponentes=new ArrayList<>(2);
      
       
     
      
       //adversario3.buscamalo=new BusquedaAnchura2(this, adversario3);
       //adversario4.buscamalo=new BusquedaAnchura2(this, adversario4);
    }
     public   void ponerJugadores(){
        System.out.println("se llama A JUGADORES");
        this.jugador=new Jugador(this);
      this.adversario1= new Adversario(this,29,29,'m');
      this.adversario2=new Adversario(this,20,22,'m');
      //adversario3=new Adversario(this,28,15);
     // adversario4=new Adversario(this,15,18);
      
      this.jugador.oponentes.add(adversario1);
      this.jugador.oponentes.add(adversario2);
      
    
       
     // ArrayList<TontoAdversario> oponentes=new ArrayList<>(2);
    
    
    }
    @Override
    public void update(Graphics g) {
       for(int i=0; i < anchoGameWorld  ; i++) 
          for ( int j=0 ; j < altoGameWorld; j++)        
             casillas[i][j].update(g);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }
    
    //metodo para ver que tecla se apreta
    public void chequearTecla( KeyEvent evento ) {
        if ( evento.getKeyCode() == 38 ) {
            System.out.println("arribaa");
            jugador.mover_arriba();
        }
        if ( evento.getKeyCode() == 40 ) {
            System.out.println("abajoo");
            jugador.mover_abajo();
        }
        if ( evento.getKeyCode() == 37 ) {
            System.out.println("izuiqerdaa");
            jugador.mover_izquierda();
        }
        if ( evento.getKeyCode() == 39 ) {
            System.out.println("derecha");
            jugador.mover_derecha();
        }
    }
    
    
    
    
    
    
}
