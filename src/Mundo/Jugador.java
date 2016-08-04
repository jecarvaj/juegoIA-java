package Mundo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */

import Inteligencia.*;
import Mundo.*;
import Interfaz.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Jugador implements Constantes{
    
    public Laberinto laberinto;
    public int i_jugador,j_jugador;
    int contDerecha=0, contIzquierda=0, contArriba=0, contAbajo=0;
    int comidaCapturada=0;
    public BusquedaJugador busqueda;

    public ArrayList<Adversario> oponentes;
   
    public Jugador(Laberinto l) {
        
        laberinto=l;
        i_jugador=13;
        j_jugador=6;
        laberinto.casillas[i_jugador][j_jugador].tipo='J';
        oponentes=new ArrayList<>();
        //tarea=new BusquedaAnchura(laberinto);
//        tarea.run();
    }
    
    
    public  void mover_arriba(){
        contIzquierda=contDerecha=contAbajo=0;
        contArriba++;
       
        try{
          if(contArriba==3){contArriba=1;}
          
        if(j_jugador >0){
            if(laberinto.casillas[i_jugador][j_jugador-1].tipo!='O' && 
                    laberinto.casillas[i_jugador][j_jugador-1].tipo!='G'
                    && 
                    laberinto.casillas[i_jugador][j_jugador-1].tipo!='A'){
                
                if(laberinto.casillas[i_jugador][j_jugador-1].tipo=='P'){
                    if(j_jugador == 1){
                        laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                        j_jugador-=1;
                        laberinto.casillas[i_jugador][j_jugador].tipo='J';  
                      
                        
                    }else{                    
                    
                        int i=1;  //cuenta cuantos comidas hay en fila
                        while(laberinto.casillas[i_jugador][j_jugador-i].tipo=='P'){
                            i+=1;
                        }
                        if(laberinto.casillas[i_jugador][j_jugador-i].tipo=='C'){
                            laberinto.casillas[i_jugador][j_jugador].tipo='C';
                            laberinto.casillas[i_jugador][j_jugador-i].tipo='P';  
                            j_jugador-=1;
                            laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                             switch(contArriba){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=3;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;}
                                //case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;}                   

                        }else{
                            if(i==2){         //el i vale n+1 donde n es el numero de recompensas en linea, pregunto si solo hay una
                                laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                                j_jugador-=1;
                                laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                                switch(contArriba){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=3;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;}
                               // case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;}
                            }
                        }
                    }
                }else if ( laberinto.casillas[i_jugador][j_jugador-1].tipo=='C' &&
                    (laberinto.jugador.busqueda.objAlcanzado ))
                    {
//                   if(contArriba==1){
////                   //laberinto.casillas[i_jugador][j_jugador].tipo='C';
////               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
////                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
////                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
////                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
////                 laberinto.casillas[i_jugador][j_jugador-1].tipo='P';
//                   
//                   }else{     
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
                
                
                
               j_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador][j_jugador-1].tipo='P';
                   switch(contArriba){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=3;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;
                              //  case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;
                   }
                    }else{  //SI NO HAY NADA Y SE MUEVE LIBRE
                    laberinto.casillas[i_jugador][j_jugador].tipo='C';
                    j_jugador-=1;
                    laberinto.casillas[i_jugador][j_jugador].tipo='J';
                    
                    switch(contArriba){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=3;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;
                                //case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=11;break;
                    }
                }                
                        

            }
             if (laberinto.casillas[i_jugador][j_jugador-1].tipo=='G'
                       && laberinto.casillas[i_jugador][j_jugador+1].tipo=='P') {
                      laberinto.casillas[i_jugador][j_jugador].tipo='J';
                      laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
                      
                    comidaCapturada++;
        
                     System.out.println(Laberinto.alimento);
                if(comidaCapturada==Laberinto.alimento){
                   
                      ImageIcon m=new ImageIcon(getClass().getResource("/botones/jim.png"));
        JOptionPane.showMessageDialog(null, "<html><h2><center>You win!...</center></h2></html>",
                                            "That's all?",
                                            JOptionPane.INFORMATION_MESSAGE,m);
                    laberinto.lienzo.terminar();
                }
            }
            
        }}catch(Exception e){
            System.out.println("ups");}
    }
    
    public  void mover_abajo(){
        contIzquierda=contArriba=contDerecha=0;
        contAbajo++;
        if(contAbajo==3){contAbajo=1;}
        try{
        if(j_jugador <altoGameWorld-2){
            if(laberinto.casillas[i_jugador][j_jugador+1].tipo!='O'
                    && laberinto.casillas[i_jugador][j_jugador+1].tipo!='A'
                     && laberinto.casillas[i_jugador][j_jugador+1].tipo!='G'){
                
                if(laberinto.casillas[i_jugador][j_jugador+1].tipo=='P'){
                    if(j_jugador == altoGameWorld-3){
                        laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                        j_jugador+=1;
                        laberinto.casillas[i_jugador][j_jugador].tipo='J';  
                       switch(contAbajo){
                            case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                            case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=8;break;
                            //case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                       }
                        
                    }else{                    
                    
                        int i=1;  //cuenta cuantos comidas hay en fila
                        while(laberinto.casillas[i_jugador][j_jugador+i].tipo=='P'){
                            i+=1;
                        }
                        if(laberinto.casillas[i_jugador][j_jugador+i].tipo=='C'){
                            laberinto.casillas[i_jugador][j_jugador].tipo='C';
                            laberinto.casillas[i_jugador][j_jugador+i].tipo='P';  
                            j_jugador+=1;
                            laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                             switch(contAbajo){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=8;break;
                                //case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                             }                   

                        }else{
                            if(i==2){         //el i vale n+1 donde n es el numero de recompensas en linea, pregunto si solo hay una
                                laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                                j_jugador+=1;
                                laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                                switch(contAbajo){
                                    case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                                    case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=8;break;
                                    //case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                                }
                            }
                        }
                    }
                }else if ( laberinto.casillas[i_jugador][j_jugador+1].tipo=='C' &&
                    (laberinto.jugador.busqueda.objAlcanzado ))
                    {
//                  if(contAbajo==1){
////                   //laberinto.casillas[i_jugador][j_jugador].tipo='C';
////               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
////                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
////                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
////                //laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
////                 laberinto.casillas[i_jugador][j_jugador+1].tipo='P';
//                   
//                   }else{     
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
                
                  
               j_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador][j_jugador+1].tipo='P';
                  switch(contAbajo){
                      case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                      case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=8;break;
                     // case 3:laberinto.casillas[i_jugador][j_jugador].indexSpri
                  }
                  }else{  //SI NO HAY NADA Y SE MUEVE LIBRE
                    laberinto.casillas[i_jugador][j_jugador].tipo='C';
                    j_jugador+=1;
                    laberinto.casillas[i_jugador][j_jugador].tipo='J';
                    
                    switch(contAbajo){
                      case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                      case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=8;break;
                     // case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=0;break;
                    }
                }                
                        

            }
                    
        }}catch(Exception e){
            System.out.println("ups");}
    }
    
    
    
      public void mover_izquierda(){
          contDerecha=contArriba=contAbajo=0;
        contIzquierda++;
        
        if(contIzquierda==7){contIzquierda=1;}
        try{
        if(i_jugador >0){
            if(laberinto.casillas[i_jugador-1][j_jugador].tipo!='O'
                    && laberinto.casillas[i_jugador-1][j_jugador].tipo!='A'
                     && laberinto.casillas[i_jugador-1][j_jugador].tipo!='G'){
                
                if(laberinto.casillas[i_jugador-1][j_jugador].tipo=='P'){
                    if(i_jugador == 1){
                        laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                        i_jugador-=1;
                        laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                        laberinto.casillas[i_jugador][j_jugador].indexSprite=1;
                    }else{                    
                    
                        int i=1;  //cuenta cuantos comidas hay en fila
                        while(laberinto.casillas[i_jugador-i][j_jugador].tipo=='P'){
                            i+=1;
                        }
                        if(laberinto.casillas[i_jugador-i][j_jugador].tipo=='C'){
                            laberinto.casillas[i_jugador][j_jugador].tipo='C';
                            laberinto.casillas[i_jugador-i][j_jugador].tipo='P';  
                            i_jugador-=1;
                            laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                             switch(contIzquierda){
                                case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=1;break;
                                case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=5;break;
                                case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=9;break;
                                case 4:laberinto.casillas[i_jugador][j_jugador].indexSprite=13;break;  
                                case 5:laberinto.casillas[i_jugador][j_jugador].indexSprite=17;break; 
                                case 6:laberinto.casillas[i_jugador][j_jugador].indexSprite=21;break;
                             }                     

                        }else{
                            if(i==2){         //el i vale n+1 donde n es el numero de recompensas en linea, pregunto si solo hay una
                                laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                                i_jugador-=1;
                                laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                                laberinto.casillas[i_jugador][j_jugador].indexSprite=1;
                            }
                        }
                    }
                }else if ( laberinto.casillas[i_jugador-1][j_jugador].tipo=='C' &&
                    (laberinto.jugador.busqueda.objAlcanzado ))
                    {
//                         if(contIzquierda==1){
////                  // laberinto.casillas[i_jugador][j_jugador].tipo='C';
////                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
////                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
////               // laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
////                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
////                 laberinto.casillas[i_jugador-1][j_jugador].tipo='P';
//                   
//                   }else{     
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
               // laberinto.casillas[i_jugador-1][j_jugador].tipo='K';
                //laberinto.casillas[i_jugador+1][j_jugador].tipo='K';
                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
                 laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                 
                
               i_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador-1][j_jugador].tipo='P';
                           switch(contIzquierda){
                   
                      case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=1;break;
                      case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=5;break;
                      
                      case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=9;break;
                      case 4:laberinto.casillas[i_jugador][j_jugador].indexSprite=13;break;  
                      case 5:laberinto.casillas[i_jugador][j_jugador].indexSprite=17;break; 
                      case 6:laberinto.casillas[i_jugador][j_jugador].indexSprite=21;break;
               }
                         }else{  //SI NO HAY NADA Y SE MUEVE LIBRE
                    laberinto.casillas[i_jugador][j_jugador].tipo='C';
                    i_jugador-=1;
                    laberinto.casillas[i_jugador][j_jugador].tipo='J';
                    
                    switch(contIzquierda){
                   
                      case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=1;break;
                      case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=5;break;
                      
                      case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=9;break;
                      case 4:laberinto.casillas[i_jugador][j_jugador].indexSprite=13;break;  
                      case 5:laberinto.casillas[i_jugador][j_jugador].indexSprite=17;break; 
                      case 6:laberinto.casillas[i_jugador][j_jugador].indexSprite=21;break;
               }
                }                
                        

            }
                  
        }}catch(Exception e){
            System.out.println("ups");}
    }
    
    
 
    public  void mover_derecha(){
        contIzquierda=contArriba=contAbajo=0;
        contDerecha++;
        if(contDerecha==4){contDerecha=1;}
        try{
        if(i_jugador <anchoGameWorld-1){
            if(laberinto.casillas[i_jugador+1][j_jugador].tipo!='O'
                    && laberinto.casillas[i_jugador+1][j_jugador].tipo!='A'
                    && laberinto.casillas[i_jugador+1][j_jugador].tipo!='G'){
                
                if(laberinto.casillas[i_jugador+1][j_jugador].tipo=='P'){
                    if(i_jugador == anchoGameWorld-1){
                        laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                        i_jugador+=1;
                        laberinto.casillas[i_jugador][j_jugador].tipo='J';  
                        switch (contDerecha){
                            case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=2;break;
                            case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=6;break; 
                            case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=10;break;}
                        
                    }else{                    
                    
                        int i=1;  //cuenta cuantos comidas hay en fila
                        while(laberinto.casillas[i_jugador+i][j_jugador].tipo=='P'){
                            i+=1;
                        }
                        if(laberinto.casillas[i_jugador+i][j_jugador].tipo=='C'){
                            laberinto.casillas[i_jugador][j_jugador].tipo='C';
                            laberinto.casillas[i_jugador+i][j_jugador].tipo='P';  
                            i_jugador+=1;
                            laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                             switch (contDerecha){
                            case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=2;break;
                            case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=6;break; 
                            case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=10;break;}                    

                        }else{
                            if(i==2){         //el i vale n+1 donde n es el numero de recompensas en linea, pregunto si solo hay una
                                laberinto.casillas[i_jugador][j_jugador].tipo='P'; 
                                i_jugador+=1;
                                laberinto.casillas[i_jugador][j_jugador].tipo='J';                    
                                switch (contDerecha){
                                    case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=2;break;
                                    case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=6;break; 
                                    case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=10;break;}
                            }
                        }
                    }
                }else if ( laberinto.casillas[i_jugador+1][j_jugador].tipo=='C' &&
                    (laberinto.jugador.busqueda.objAlcanzado ))
                    {
//                         if(contDerecha==1){
////                  // laberinto.casillas[i_jugador][j_jugador].tipo='C';
////                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
////                //laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
////               // laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
////                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
////                 laberinto.casillas[i_jugador+1][j_jugador].tipo='P';
//                   
//                   }else{     
                             laberinto.casillas[i_jugador][j_jugador].tipo='C';
                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
               // laberinto.casillas[i_jugador-1][j_jugador].tipo='K';
                //laberinto.casillas[i_jugador+1][j_jugador].tipo='K';
                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
 
               i_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador+1][j_jugador].tipo='P';
                           switch (contDerecha){
                            case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=2;break;
                            case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=6;break; 
                            case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=10;break;}
                         }else{  //SI NO HAY NADA Y SE MUEVE LIBRE
                    laberinto.casillas[i_jugador][j_jugador].tipo='C';
                    i_jugador+=1;
                    laberinto.casillas[i_jugador][j_jugador].tipo='J';
                    
                    switch (contDerecha){
                            case 1:laberinto.casillas[i_jugador][j_jugador].indexSprite=2;break;
                            case 2: laberinto.casillas[i_jugador][j_jugador].indexSprite=6;break; 
                            case 3:laberinto.casillas[i_jugador][j_jugador].indexSprite=10;break;}
                }                
                        

            }
                   
        }}catch(Exception e){
            System.out.println("ups");}
    
    

    
    
}

}
