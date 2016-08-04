package Inteligencia;
import Interfaz.Panel;
import Mundo.*;
import Interfaz.*;
import Inteligencia.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BusquedaJugador extends TimerTask implements Constantes{
    
    public Laberinto laberinto;
   // public Jugador jugador;
    public Queue<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos, cont_comida;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp, inteligente, tonto, estadoH;
    public boolean exito;
    public static boolean parar=false, cazado=false, objAlcanzado=false,
            recompensa=false, guarida=true;
    public Panel panel;
    public BusquedaJugador(Laberinto l) {

        this.laberinto=l;

        this.colaEstados=new PriorityQueue<>();
        this.historial=new ArrayList<>();
        this.pasos=new ArrayList<>();
        cont_comida=0;
        this.inicial=new Estado(laberinto.jugador.i_jugador,laberinto.jugador.j_jugador,'N',null);

    } 

   
    public void buscar(Estado inicial,Estado objetivo) {
        distanciaG(inicial,objetivo);
        distanciaH(inicial,darOponenteMasCercano(inicial));
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
                     && laberinto.casillas[e.x][e.y-1].tipo != 'A') { 
                 Estado arriba=new Estado(e.x,e.y-1,'U',e);
                 distanciaG(arriba,objetivo);
                 distanciaH(arriba,darOponenteMasCercano(inicial));
                 
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
  
        if ( e.y<altoGameWorld-2 ) {
            if ( laberinto.casillas[e.x][e.y+1].tipo != 'O'
                    && laberinto.casillas[e.x][e.y+1].tipo != 'G'
                    && laberinto.casillas[e.x][e.y+1].tipo != 'A') {
                
                 Estado abajo=new Estado(e.x,e.y+1,'D',e);   
                 distanciaG(abajo,objetivo);
                 distanciaH(abajo,darOponenteMasCercano(inicial));
                 
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
                    && laberinto.casillas[e.x-1][e.y].tipo != 'A') {
                
                Estado izquierda=new Estado(e.x-1,e.y,'L',e);
                distanciaG(izquierda,objetivo);
                distanciaH(izquierda,darOponenteMasCercano(inicial));
                 
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
                     && laberinto.casillas[e.x+1][e.y].tipo != 'A') {
               
               Estado derecha=new Estado(e.x+1,e.y,'R',e); 
               distanciaG(derecha,objetivo);
               distanciaH(derecha,darOponenteMasCercano(inicial));
                 
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
    
    //distancia actual al final  ...si cambi el h anda mas miedoso
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
   // a.f=(a.h-50*a.g);
         a.f=(a.g-(a.h));
      //  a.f=(a.g-(5*a.h)); //jugador tonto
         
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
    
    public Estado darOponenteMasCercano(Estado a) {
        
        Adversario aux=laberinto.jugador.oponentes.get(0);
        double distanciaAux=distancia(a.x,aux.i_jugador,a.y,aux.j_jugador);
        
        for ( int i=1 ; i < laberinto.jugador.oponentes.size() ; i++ ) {
            double distanciaAux2=distancia(a.x,laberinto.jugador.oponentes.get(i).i_jugador,
                                           a.y,laberinto.jugador.oponentes.get(i).j_jugador);
            if (  distanciaAux2 < distanciaAux){
                aux=laberinto.jugador.oponentes.get(i);
                distanciaAux=distanciaAux2;
            }
        }
        
        return new Estado(aux.i_jugador,aux.j_jugador,'N',null);
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
         
          //aqui dependera de lo que ande buscando..recompensa=true, quiere decir
          //que ya tiene la comida y se devuelve a la guarida
          if(recompensa){ 
              this.buscar(new Estado(laberinto.jugador.i_jugador,laberinto.jugador.j_jugador,'N',null),
                      new Estado(14,5,'N',null)); //posicion de guarida
            
          }//si no, quiere decir que guarida=true, ya estuvo ahi y ahora busca siguiente recomepnsa
          else if(guarida){
             this.buscar(new Estado(laberinto.jugador.i_jugador,laberinto.jugador.j_jugador,'N',null),
                      new Estado(laberinto.crear.comidas.get(cont_comida).x,
                              laberinto.crear.comidas.get(cont_comida).y,'N',null));
            } 
          
         
          if ( pasos.size() > 1 ) {
             switch(pasos.get(1)) { //se movera segun el primer paso, ya que va a ir cambiando
                case 'D': laberinto.jugador.mover_abajo();break;
                case 'U': laberinto.jugador.mover_arriba(); break;
                case 'R': laberinto.jugador.mover_derecha();break;
                case 'L': laberinto.jugador.mover_izquierda();break;
             }
          
          //verificamos que no nos haya encontrado
             for ( int i=0 ; i < laberinto.jugador.oponentes.size() ; i++ ) {
                if ( laberinto.jugador.i_jugador == laberinto.jugador.oponentes.get(i).i_jugador &&
                     laberinto.jugador.j_jugador == laberinto.jugador.oponentes.get(i).j_jugador) {
                    ImageIcon m=new ImageIcon(getClass().getResource("/botones/jim.png"));
        JOptionPane.showMessageDialog(null, "<html><h2><center>No! You are dead...</center></h2></html>",
                                            "Are you ok?",
                                            JOptionPane.INFORMATION_MESSAGE,m);
                     parar=true;
                     cazado=true;
                     this.cancel();
                     pararOponentes();
                    
                }else {
                     laberinto.lienzo.repaint();  
                }
             }
       }else{
              
   
           if(guarida){//si es que ya esta en guarida
           recompensa=true;//decimos que ahora buscamos recompensas
            objAlcanzado=true;
                cont_comida++;//aumentamos contador de comida
                     guarida=false;
                        }
           else if(recompensa){ //lo mismo 
               objAlcanzado=false;
             
               //calculo lo restando, aunque por ahora no lo ocupare... 
               //depende si es que me queda tiempo 
               int restante=laberinto.alimento-cont_comida;
               
               //eliminamos la recompensa que dejamos en guarda
                for (int i = 12; i < 16; i++) { //limpio la guarida
                laberinto.casillas[i][4]=new Celda(i+(i*sizeCell),
                                    4+(4*sizeCell),'C');}
              
                //algunas veces el jugador quita los obstaculos (bug sin tiempo de corregir)
                //aqui lo ponemos de nuevo
                            for (int j = 4; j < 8; j++) {  //piedras a la salida de la base
                laberinto.casillas[11][j].tipo='O';
                laberinto.casillas[15][j].tipo='O';
            }  

                if(cont_comida==laberinto.alimento){
                    //si es que esta toda la comida recolectada ganamos
    ImageIcon m=new ImageIcon(getClass().getResource("/botones/jim.png"));
        JOptionPane.showMessageDialog(null, "<html><h2><center>You win!...</center></h2></html>",
                                            "That's all?",
                                            JOptionPane.INFORMATION_MESSAGE,m);
                         parar=true;
                        laberinto.casillas[13][6].tipo='J';
                        laberinto.lienzo.terminar();

                }
               guarida=true;
               recompensa=false;
           } 

           
       }
      }
       
    }   
    
    private void pararOponentes() {
        for(int i=0; i < laberinto.jugador.oponentes.size();i++)
            laberinto.jugador.oponentes.get(i).buscamalo.parar=true;
    }
    
}

