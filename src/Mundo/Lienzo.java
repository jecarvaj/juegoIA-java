package Mundo;
import Inteligencia.*;
import Mundo.*;
import Interfaz.*;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author ian
 */


public class Lienzo extends Canvas implements Constantes{
    
    public Laberinto laberinto;
   // public Adversario adversario,adversario2;
    public Timer lanzadorTareas;
    public Image imagenAuxiliar;
    public Graphics graficoAuxiliar;
    public Image fondo;
   public boolean virtual;
   public static String nivelBueno, nivelMalo;
     //BusquedaAnchura buscar;
    //public Adversario adversario1;
    
    public Lienzo(boolean virtual){
     this.virtual=virtual;
        laberinto=new Laberinto(this);
        //adversario=new Adversario(laberinto);
        //adversario2=new Adversario(laberinto);
        //buscar=new BusquedaAnchura(laberinto);
         lanzadorTareas=new Timer();
        
        try {
           fondo = ImageIO.read(new File("images/map2.png"));
        } catch (IOException e) {
           System.out.println(e.toString()); 
        } 
        this.setSize(laberinto.ancho, laberinto.largo);
//      
//        System.out.println("empieza a buscar bucscar");
//         laberinto.jugador.tarea.buscar();
//         System.out.println("termina de buscarbuscar");
//        System.out.println("aqui empieza a calcular ruta");
//        laberinto.jugador.tarea.calcularRuta();
        //laberinto.jugador.tarea.run();
        //eventos de teclado
//        laberinto.adversario1.buscamalo.buscar();
  //      laberinto.adversario1.buscamalo.calcularRuta();
        
//        for (int i=0;i< anchoGameWorld; i++){
//            for (int j=0;j<altoGameWorld; j++){
//                if(laberinto.casillas[i][j].tipo=='x')laberinto.casillas[i][j].tipo='C';
//            }  
//        }
        
        addKeyListener(new java.awt.event.KeyAdapter() {
           @Override
           public void keyReleased(KeyEvent e) {
           //public void keyPressed(KeyEvent e) {
              laberinto.chequearTecla(e);
              repaint();
           }
        });
        
       //adversario1 = new Adversario(laberinto);
      //laberinto.jugador.tarea.buscar();
      //laberinto.jugador.tarea.calcularRuta();
       
//        lanzadorTareas=new Timer();
//        lanzadorTareas.scheduleAtFixedRate(adversario,0,500);
//        lanzadorTareas.scheduleAtFixedRate(adversario2,0,500);
//        lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscamalo,0,350);
//        lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscatonto,0,250);
//       lanzadorTareas.scheduleAtFixedRate(laberinto.adversario2.buscatonto,0,250);
//        lanzadorTareas.scheduleAtFixedRate(laberinto.adversario3.buscamalo,0,900);
//        lanzadorTareas.scheduleAtFixedRate(laberinto.adversario4.buscamalo,0,900);
//       
//      
//            if(virtual){
//        lanzadorTareas.scheduleAtFixedRate(laberinto.jugador.inteligencia,0,250);
//            }
       
    }
    
    public void terminar(){
        if(virtual){
                if(nivelBueno.equals("maximo") && nivelMalo.equals("minimo")){
                     laberinto.jugador.busqueda.cancel();
                     laberinto.adversario1.buscatonto.cancel();
                     laberinto.adversario2.buscatonto.cancel();
                     
                }
                else if(nivelBueno.equals("minimo") && nivelMalo.equals("maximo")){
                     laberinto.jugador.busqueda.cancel();//=new BusquedaJugador(laberinto);
                     laberinto.adversario1.buscatonto.cancel();//=new BusquedaAdversario(laberinto, laberinto.adversario1, "maximo");
                     laberinto.adversario2.buscatonto.cancel();//=new BusquedaAdversario(laberinto, laberinto.adversario2, "maximo");
                   
                }else{
                  laberinto.jugador.busqueda.cancel();//=new BusquedaJugador(laberinto);
                     laberinto.adversario1.buscatonto.cancel();//=new BusquedaAdversario(laberinto, laberinto.adversario1, "minimo");
                     laberinto.adversario2.buscatonto.cancel();//=new BusquedaAdversario(laberinto, laberinto.adversario2, "maximo");
                   
                }
       
            }else{
          
                laberinto.jugador.busqueda.cancel();//=new BusquedaJugador(laberinto);
                     laberinto.adversario1.buscamalo.cancel();//=new BusquedaAnchura2(laberinto, laberinto.adversario1);
                     laberinto.adversario2.buscamalo.cancel();//=new BusquedaAnchura2(laberinto, laberinto.adversario2);
//                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscamalo,0,350);
//                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario2.buscamalo,0,350);
            }
       
    
    }
    
    
        
    public void ponerTimer(){
        
       laberinto.ponerJugadores();
        //lanzadorTareas.scheduleAtFixedRate(adversario,0,500);
        //lanzadorTareas.scheduleAtFixedRate(adversario2,0,500);
        //lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscamalo,0,350);
        
        //lanzadorTareas.scheduleAtFixedRate(laberinto.adversario3.buscamalo,0,900);
       // lanzadorTareas.scheduleAtFixedRate(laberinto.adversario4.buscamalo,0,900);
       
      
            if(virtual){
                if(nivelBueno.equals("maximo") && nivelMalo.equals("minimo")){
                     laberinto.jugador.busqueda=new BusquedaJugador(laberinto);
                     laberinto.adversario1.buscatonto=new BusquedaAdversario(laberinto, laberinto.adversario1, "minimo");
                     laberinto.adversario2.buscatonto=new BusquedaAdversario(laberinto, laberinto.adversario2, "minimo");
                     lanzadorTareas.scheduleAtFixedRate(laberinto.jugador.busqueda,0,350);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscatonto,0,350);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario2.buscatonto,0,350);
                }
                else if(nivelBueno.equals("minimo") && nivelMalo.equals("maximo")){
                     laberinto.jugador.busqueda=new BusquedaJugador(laberinto);
                     laberinto.adversario1.buscamalo=new BusquedaAnchura2(laberinto, laberinto.adversario1);
                     laberinto.adversario2.buscamalo=new BusquedaAnchura2(laberinto, laberinto.adversario2);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.jugador.busqueda,0,350);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscamalo,0,350);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario2.buscamalo,0,350);
                }else{
                  laberinto.jugador.busqueda=new BusquedaJugador(laberinto);
                     laberinto.adversario1.buscatonto=new BusquedaAdversario(laberinto, laberinto.adversario1, "minimo");
                     laberinto.adversario2.buscatonto=new BusquedaAdversario(laberinto, laberinto.adversario2, "maximo");
                     lanzadorTareas.scheduleAtFixedRate(laberinto.jugador.busqueda,0,350);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscatonto,0,350);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario2.buscatonto,0,350);
                }
       
            }else{
               
                laberinto.jugador.busqueda=new BusquedaJugador(laberinto);
                     laberinto.adversario1.buscamalo=new BusquedaAnchura2(laberinto, laberinto.adversario1);
                     laberinto.adversario2.buscamalo=new BusquedaAnchura2(laberinto, laberinto.adversario2);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscamalo,0,350);
                     lanzadorTareas.scheduleAtFixedRate(laberinto.adversario2.buscamalo,0,350);
            }
       
    
    }
    
    
    //pintamos y evitamos el parpadeo
    @Override
    public void update(Graphics g) {
         if(graficoAuxiliar==null){
          imagenAuxiliar=createImage(this.getWidth(),this.getHeight());
          graficoAuxiliar=imagenAuxiliar.getGraphics();
       }
       graficoAuxiliar.setColor(getBackground());
       graficoAuxiliar.fillRect(0,0,this.getWidth(),this.getHeight());
       
       graficoAuxiliar.drawImage(fondo, 0, 0, null); 
       laberinto.update(graficoAuxiliar);      
       
       g.drawImage(imagenAuxiliar, 0, 0, null);  
       laberinto.update(g);
        
       
    }
    @Override
    public void paint(Graphics g) {
       
        update(g);
       
    }
    
  
  
}
