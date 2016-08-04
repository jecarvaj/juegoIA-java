package Mundo;

import Inteligencia.BusquedaAnchura2;
import Inteligencia.Constantes;
import Inteligencia.BusquedaAdversario;
import Mundo.Laberinto;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.JOptionPane;


/**
 *
 * @author ian
 */

public class Adversario   implements Constantes{
    
    public Laberinto laberinto;
    public int i_jugador,j_jugador;
    //contadores para ver que sprite se le asigna
     int contDerecha=0, contIzquierda=0, contArriba=0, contAbajo=0; 
     public   BusquedaAnchura2 buscamalo;
     public BusquedaAdversario buscatonto;
    public char tipo;
    public Adversario(Laberinto l, int x, int y, char t) {
        
         this.i_jugador=x;
       this.j_jugador=y; 
        this.laberinto=l;
        //elegimos punto de patida
        this.tipo=t;
        laberinto.casillas[i_jugador][j_jugador].tipo='A';
        
        //buscamalo = new BusquedaAnchura2(l);
    
    }
    
    public synchronized void mover_arriba(){
        contIzquierda=contDerecha=contAbajo=0;
        contArriba++;
          if(contArriba==4){contArriba=1;}
          
        if (j_jugador > 0 ) {
//            if ( laberinto.casillas[i_jugador][j_jugador-1].tipo!='O'
//                    && laberinto.casillas[i_jugador][j_jugador-1].tipo!='A'
//                    && laberinto.casillas[i_jugador][j_jugador-1].tipo!='P') {
                
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
                j_jugador-=1;
               
                if(laberinto.casillas[i_jugador][j_jugador].tipo=='J')
                {
                    laberinto.casillas[i_jugador][j_jugador-1].tipo='A';
                    laberinto.casillas[i_jugador][j_jugador].tipo='M';
                }else{
                     laberinto.casillas[i_jugador][j_jugador].tipo='A';
                 switch(contArriba){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=3;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=7;break;
                                case 3:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=11;break;}}
               
//            }
            System.out.println("choca con algo");
        }
        System.out.println("imposible arriba");
    }
    
    public synchronized void mover_abajo(){
        contIzquierda=contArriba=contDerecha=0;
        contAbajo++;
        if(contAbajo==4){contAbajo=1;}
        
        if (j_jugador < altoGameWorld-1 ) {
//            if ( laberinto.casillas[i_jugador][j_jugador+1].tipo!='O'
//                    && laberinto.casillas[i_jugador][j_jugador+1].tipo!='A'
//                     && laberinto.casillas[i_jugador][j_jugador+1].tipo!='P') {
                
               laberinto.casillas[i_jugador][j_jugador].tipo='C';
               
               j_jugador+=1;
               
               if(laberinto.casillas[i_jugador][j_jugador].tipo=='J')
                {
                    laberinto.casillas[i_jugador][j_jugador].tipo='M';
                    laberinto.casillas[i_jugador][j_jugador-1].tipo='A';
                }else{
                     laberinto.casillas[i_jugador][j_jugador].tipo='A';
                switch(contAbajo){
                            case 1:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=0;break;
                            case 2: laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=4;break;
                            case 3:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=8;break;}}
                     
//            }
        }
        System.out.println("imposible abajo");
    }
    
    public synchronized void mover_izquierda(){
        contDerecha=contArriba=contAbajo=0;
        contIzquierda++;
        if(contIzquierda==4){contIzquierda=1;}
        
        if (i_jugador > 0 ) {
//            if ( laberinto.casillas[i_jugador-1][j_jugador].tipo!='O'
//                    && laberinto.casillas[i_jugador-1][j_jugador].tipo!='A'
//                     && laberinto.casillas[i_jugador-1][j_jugador].tipo!='P') {
                
               laberinto.casillas[i_jugador][j_jugador].tipo='C';
               i_jugador-=1;
                
                if(laberinto.casillas[i_jugador][j_jugador].tipo=='J')
                {
                    laberinto.casillas[i_jugador][j_jugador].tipo='M';
                    laberinto.casillas[i_jugador+1][j_jugador].tipo='A';
                }else{
                     laberinto.casillas[i_jugador][j_jugador].tipo='A';
                  switch(contIzquierda){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=1;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=5;break;
                                case 3:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=9;break;
                               
                             } }
               
                
//            }
            
        }
        System.out.println("imposible izquierda");
    }
    
    public synchronized void mover_derecha(){
        contIzquierda=contArriba=contAbajo=0;
        contDerecha++;
        if(contDerecha==4){contDerecha=1;}
        
        if (i_jugador < anchoGameWorld-2 ) {
//            if ( laberinto.casillas[i_jugador+1][j_jugador].tipo!='O'
//                    && laberinto.casillas[i_jugador+1][j_jugador].tipo!='A'
//                     && laberinto.casillas[i_jugador+1][j_jugador].tipo!='P') {
                
               laberinto.casillas[i_jugador][j_jugador].tipo='C';
               i_jugador+=1;
               
               
                 if(laberinto.casillas[i_jugador][j_jugador].tipo=='J')
                {
                    laberinto.casillas[i_jugador][j_jugador].tipo='M';
                    laberinto.casillas[i_jugador-1][j_jugador].tipo='A';
                }else{
                     laberinto.casillas[i_jugador][j_jugador].tipo='A';
                 switch (contDerecha){
                            case 1:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=2;break;
                            case 2: laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=6;break; 
                            case 3:laberinto.casillas[i_jugador][j_jugador].indexSpriteMalos=10;break;}}
               
//            }
        }
        System.out.println("imposible derecha");
    }
    
 
     
//    @Override
//    public synchronized void run() {
//     // mover_izquierda();
//       
//      
//      
//      laberinto.lienzo.repaint();
//    }    
    
    
    public int numeroAleatorio(int minimo, int maximo) {
       Random random = new Random();
       int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
       return numero_aleatorio;
    }

   
    
}
