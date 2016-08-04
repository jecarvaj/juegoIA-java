package Inteligencia;


import Mundo.Adversario;
import Mundo.Laberinto;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.ImageIcon;
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
public class BusquedaAnchura2 extends TimerTask implements Constantes {
    public Laberinto laberinto;
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos,x,y, x_malo, y_malo;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public Adversario oponente;
    public boolean exito;
   public static boolean parar=false,objAlcanzado=false,cazado=false;
   
    public BusquedaAnchura2(Laberinto laberinto, Adversario j)
    {   
        this.oponente=j;
        this.laberinto=laberinto;
        this.colaEstados=new ArrayList<>();
        this.historial=new ArrayList<>();
        this.pasos=new ArrayList<>();

    }
    
    public void buscar(Estado inicial,Estado objetivo) {
        index_pasos=0;
    
        colaEstados.add(inicial);
        historial.add(inicial);
        
        this.objetivo=objetivo;
        exito=false;

        if ( inicial.equals(objetivo)) exito=true;
        
        while ( !colaEstados.isEmpty() && !exito ) {
 
            temp=colaEstados.get(0);
            colaEstados.remove(0);
            moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
        }
        
        if ( exito ) {
     
            this.calcularRuta();
        }else {
 
        }
        
    }
    
    private void moverArriba(Estado e)
    {   
        int contiene=0;
        if(e.y>0){
            if(laberinto.casillas[e.x][e.y-1].tipo!='O'
                    && laberinto.casillas[e.x][e.y-1].tipo!='P'
                    && laberinto.casillas[e.x][e.y-1].tipo!='G'){
                Estado arriba=new Estado(e.x, e.y-1, 'U', e);
                for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==arriba.x
                     && historial.get(i).y==arriba.y){
                        contiene++;
                        break;
                    }
                    
                }
                
                if(contiene==0){
                    colaEstados.add(arriba);
                    historial.add(arriba);
       
                    
                    if(arriba.equals(objetivo)){
                        objetivo=arriba;
                        exito=true;
                    }
                
            }}
                
        }
    }
    
     private void moverAbajo(Estado e)
    {
         int contiene=0;
        if(e.y<altoGameWorld-1){
            if(laberinto.casillas[e.x][e.y+1].tipo!='O'
                    && laberinto.casillas[e.x][e.y+1].tipo!='P'
                    && laberinto.casillas[e.x][e.y+1].tipo!='G'){
                Estado abajo=new Estado(e.x, e.y+1, 'D', e);
                 for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==abajo.x
                     && historial.get(i).y==abajo.y){
                        contiene++;
                         break;
                    }
                    
                }
                 if(contiene==0){
                    colaEstados.add(abajo);
                    historial.add(abajo);
                 
                    if(abajo.equals(objetivo)){
               
                        objetivo=abajo;
                        exito=true;
                    }}
                
            }
                
        }
    }
     
      private void moverIzquierda(Estado e)
    {   
        int contiene=0;
        if(e.x>0){
            if(laberinto.casillas[e.x-1][e.y].tipo!='O'
                    && laberinto.casillas[e.x-1][e.y].tipo!='P'
                    && laberinto.casillas[e.x-1][e.y].tipo!='G'){
                Estado izquierda=new Estado(e.x-1, e.y, 'L', e);
                 for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==izquierda.x
                     && historial.get(i).y==izquierda.y){
                        contiene++;
                         break;
                    }
                    
                }
                 
                 if(contiene==0){
                    colaEstados.add(izquierda);
                    historial.add(izquierda);
                    //laberinto.casillas[e.x-1][e.y].tipo='x';
                    if(izquierda.equals(objetivo)){
                       // laberinto.casillas[e.x-1][e.y].tipo='J';
                        objetivo=izquierda;
                        exito=true;
                    }}
                
            }
                
        }
    }
      
       private void moverDerecha(Estado e)
    {   
        int contiene=0;
        if(e.x<anchoGameWorld-2){
            if(laberinto.casillas[e.x+1][e.y].tipo!='O'
                    &&laberinto.casillas[e.x+1][e.y].tipo!='P'
                     &&laberinto.casillas[e.x+1][e.y].tipo!='G'){
                Estado derecha=new Estado(e.x+1, e.y, 'R', e);
                for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==derecha.x
                     && historial.get(i).y==derecha.y){
                        contiene++;
                         break;
                    }
                    
                }
                
                if(contiene==0){
                    colaEstados.add(derecha);
                    historial.add(derecha);
                    // laberinto.casillas[e.x+1][e.y].tipo='x';
                    if(derecha.equals(objetivo)){
                       // laberinto.casillas[e.x+1][e.y].tipo='J';
                        objetivo=derecha;
                        exito=true;
                    }}
                
            }
                
        }
    }

    public void calcularRuta()
    {
        

        Estado predecesor=objetivo;
        do{
            pasos.add(0,predecesor.oper);
            predecesor=predecesor.predecesor;
        }while(predecesor!=null);
   
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
    
}
