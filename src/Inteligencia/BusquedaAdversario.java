package Inteligencia;

import Mundo.*;
import static Inteligencia.Constantes.altoGameWorld;
import static Inteligencia.Constantes.anchoGameWorld;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BusquedaAdversario extends TimerTask implements Constantes{
    
    public Laberinto laberinto;
   public Adversario oponente;
    public Queue<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos, cont_comida;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp, tonto, inteligente, estadoH;
    public boolean exito;
    public static boolean parar=false, cazado=false, objAlcanzado=false,
            recompensa=false, guarida=true;
    
    public BusquedaAdversario(Laberinto l, Adversario j, String nivel) {
        
        this.laberinto=l;
       this.oponente=j;
        this.colaEstados=new PriorityQueue<>();
        this.historial=new ArrayList<>();
        this.pasos=new ArrayList<>();
        cont_comida=0;
        this.inteligente=new Estado(oponente.i_jugador, oponente.j_jugador, 'N', null);
        this.tonto=new Estado(13,6,'N', null);
       
        if(nivel.equals("maximo")){
         this.estadoH=inteligente;
        }else{
           this.estadoH=tonto; }
    } 

   
    public void buscar(Estado inicial,Estado objetivo) {
     distanciaG(inicial,objetivo);
        distanciaH(inicial,estadoH);
        index_pasos=0;
    
        colaEstados.add(inicial);
        historial.add(inicial);
        
        this.objetivo=objetivo;
        exito=false;
        
        if ( inicial.equals(objetivo)) exito=true;
        
        while ( !colaEstados.isEmpty() && !exito ) {
            temp=colaEstados.poll();
            moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
        }
        
        if ( exito ) {
            System.out.println("Ruta calculada");
            this.calcularRuta();
        }else {
            System.out.println("La ruta no pudo calcularse");
        }
        
    }
    
    private void moverArriba(Estado e) {
        
        if ( e.y > 1 ) {
            if (laberinto.casillas[e.x][e.y-1].tipo != 'O' 
                    && laberinto.casillas[e.x][e.y-1].tipo != 'G'
                     && laberinto.casillas[e.x][e.y-1].tipo != 'P'
                     && laberinto.casillas[e.x][e.y-1].tipo != 'A') { 
                 Estado arriba=new Estado(e.x,e.y-1,'U',e);
                 distanciaG(arriba, objetivo);
                 distanciaH(arriba,estadoH);
                 
                 if ( !historial.contains(arriba)) {
        
                    colaEstados.add(arriba); 
                    historial.add(arriba);
                    
                    if ( arriba.equals(objetivo)) {
                        
                        objetivo=arriba;
                        exito=true;
                    }
                    
                 }
            }     
        }
    }
    
    private void moverAbajo(Estado e) {
        //System.out.println(e.toString());
        if ( e.y<altoGameWorld-2 ) {
            if ( laberinto.casillas[e.x][e.y+1].tipo != 'O'
                    && laberinto.casillas[e.x][e.y+1].tipo != 'G'
                    && laberinto.casillas[e.x][e.y+1].tipo != 'P'
                     && laberinto.casillas[e.x][e.y+1].tipo != 'A') {
                
                 Estado abajo=new Estado(e.x,e.y+1,'D',e);   
                 distanciaG(abajo,objetivo);
                 distanciaH(abajo,estadoH);
                 
                 if ( !historial.contains(abajo)) {
                    
                    colaEstados.add(abajo);  
                    historial.add(abajo);
                    
                    if ( abajo.equals(objetivo)) {
                        
                        objetivo=abajo;
                        exito=true;
                    }
                 }   
            }     
        }
    }    
    
    private void moverIzquierda(Estado e) {
        
        if ( e.x > 1 ) {
            if ( laberinto.casillas[e.x-1][e.y].tipo != 'O'
                    && laberinto.casillas[e.x-1][e.y].tipo != 'G'
                    && laberinto.casillas[e.x-1][e.y].tipo != 'P'
                     && laberinto.casillas[e.x-1][e.y].tipo != 'A') {
                
                Estado izquierda=new Estado(e.x-1,e.y,'L',e);
                distanciaG(izquierda,objetivo);
                distanciaH(izquierda,estadoH);
                 
                if ( !historial.contains(izquierda)) {
                   
                   colaEstados.add(izquierda);  
                   historial.add(izquierda);
                   
                   if ( izquierda.equals(objetivo)) {
                       
                       objetivo=izquierda;
                       exito=true;
                   }
                }   
            }    
        }
    }    
    
    private void moverDerecha(Estado e) {
        
        if ( e.x < anchoGameWorld-2 ) {
            if ( laberinto.casillas[e.x+1][e.y].tipo != 'O' 
                    && laberinto.casillas[e.x+1][e.y].tipo != 'G'
                     && laberinto.casillas[e.x+1][e.y].tipo != 'P'
                     && laberinto.casillas[e.x+1][e.y].tipo != 'A') {
               
               Estado derecha=new Estado(e.x+1,e.y,'R',e); 
               distanciaG(derecha,objetivo);
               distanciaH(derecha,estadoH);
                 
               if ( !historial.contains(derecha)){
                 
                 colaEstados.add(derecha); 
                 historial.add(derecha);
                 
                 if ( derecha.equals(objetivo)) {
                     
                     objetivo=derecha;
                     exito=true;
                 }
               }  
            }     
        }
    }    
    
//    distancia actual al final
    public void distanciaG(Estado a, Estado b) {
        double valor;
        double parte1=Math.pow(Math.abs(a.x-b.x),2);
        double parte2=Math.pow(Math.abs(a.y-b.y),2);
        parte1+=parte2;
        valor=Math.sqrt(parte1);
        a.g=valor;
    }
    
    //distancia actual a obstaculo
    public void distanciaH(Estado a, Estado b) {
//        double valor;
//        double parte1=Math.pow(Math.abs(a.x-b.x),2);
//        double parte2=Math.pow(Math.abs(a.y-b.y),2);
//        parte1+=parte2;
//        valor=Math.sqrt(parte1);
//        a.h=valor;
//        a.f=(a.g-(3*a.h)); ///toy modficando esto   a.f=(a.g-(3*a.h))
        
         double valor;
        double parte1=Math.pow(Math.abs(a.x-b.x),2);
        double parte2=Math.pow(Math.abs(a.y-b.y),2);
        parte1+=parte2;
        valor=Math.sqrt(parte1);
       
        a.h=valor;
        a.f=(a.g-(4*a.h));
        // a.f=(a.h-50*a.g);
       // a.f=(a.g-(5*a.h)); //jugador tonto
         
    }
    
    public double distancia(int x1,int y1, int x2, int y2) { //distanca manhatan
//        double valor;
//        double parte1=Math.pow(Math.abs(x1-x2),2);
//        double parte2=Math.pow(Math.abs(y1-y2),2);
//        parte1+=parte2;
//        valor=Math.sqrt(parte1);
//        return valor;
        
         double valor;
        double parte1=Math.pow(Math.abs(x1-x2),2);
        double parte2=Math.pow(Math.abs(y1-y2),2);
        parte1+=parte2;
        valor=Math.sqrt(parte1);
        return valor;
    }
    

    
    public void calcularRuta() {
        Estado predecesor=objetivo;
        do{
            pasos.add(0,predecesor.oper); //le cambie el 0
            predecesor=predecesor.predecesor;
        }while ( predecesor != null);
    }

     
    @Override
    public synchronized void run() {

        
       if ( ! parar ) {
       
          colaEstados.clear();
          historial.clear();
          pasos.clear(); 
      
          
          this.buscar(new Estado(oponente.i_jugador,oponente.j_jugador,'N',null),
                      new Estado(laberinto.jugador.i_jugador,
                                 laberinto.jugador.j_jugador,'N',null));
          
          
       
          if ( pasos.size() > 1 ) {
              System.out.println("pasos seze "+pasos.size());
             switch(pasos.get(1)) {
                case 'D': oponente.mover_abajo();break;
                case 'U': oponente.mover_arriba(); break;
                case 'R': oponente.mover_derecha();break;
                case 'L': oponente.mover_izquierda();break;
             }
          
         //si es que se encuentran
             if ( laberinto.jugador.i_jugador == oponente.i_jugador &&
                 laberinto.jugador.j_jugador == oponente.j_jugador) {
                 
         ImageIcon m=new ImageIcon(getClass().getResource("/botones/jim.png"));
        JOptionPane.showMessageDialog(null, "<html><h2><center>No! You are dead...</center></h2></html>",
                                            "Are you ok?",
                                            JOptionPane.INFORMATION_MESSAGE,m);
                 parar=true;
                 cazado=true;
                 laberinto.jugador.busqueda.cazado=true;
                 laberinto.jugador.busqueda.parar=true;
                
                 this.cancel();
                 
             }else {
                laberinto.lienzo.repaint();  
             }
     }

      }
       
    }   
    
    private void pararOponentes() {
        for(int i=0; i < laberinto.jugador.oponentes.size();i++)
            laberinto.jugador.oponentes.get(i).buscamalo.parar=true;
    }
    
}

