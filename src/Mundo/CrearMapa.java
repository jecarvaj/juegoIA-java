package Mundo;


import java.util.ArrayList;
import java.util.Random;
import Inteligencia.*;


/**
 *
 * @author Ian
 */
public class CrearMapa implements Constantes {
    public static ArrayList<Celda> comidas;
    
        public CrearMapa(Celda[][] casillas, int cantidad){
            
            
          ponerObstaculos(casillas);
           ponerComida(casillas, cantidad);
            crearGuarida(casillas);
            
        }
        
        
    static void ponerComida(Celda[][] casillas, int cantidad) {
            int i,j;
         comidas=new ArrayList<>();
         
            for (int n = 0; n< cantidad; n++) {
                i=numeroAleatorio(1,anchoGameWorld-10);
                j=numeroAleatorio(1,altoGameWorld-10);
                
                if(casillas[i][j].tipo=='C' && casillas[i][j].tipo!='G'  ){
                    casillas[i][j].tipo='P';
                    comidas.add(new Celda(i, j, 'P'));
                }else {n=n-1;} //CREAMOS RECOMPENSAS ALEATORIAS
          
         }
    }
    
    
    static void crearGuarida(Celda[][] casillas){
        
        for (int i = 12; i < 15; i++) {  
            
                casillas[i][4]=new Celda(i+(i*sizeCell),
                                    4+(4*sizeCell),'G');
                   
        }
        
    
    }
    static void ponerObstaculos(Celda[][] casillas) {
        
      //public void ponerObstaculos( Celda[][] casillas){
    
        for (int i = 0; i < 19; i++) {  //hierbas y parte de la base
            for (int j = 0; j < 2; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
            }        
        }
        
        for (int i = 10; i < 18; i++) {      //base jugador
            for (int j = 2; j < 4; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
            }        
        }
        
        
            for (int j = 4; j < 8; j++) {  //piedras a la salida de la base
                casillas[11][j]=new Celda(11+(11*sizeCell),
                                    j+(j*sizeCell),'O');
                casillas[15][j]=new Celda(15+(15*sizeCell),
                                    j+(j*sizeCell),'O');
            }        
            
        
            for (int i = 0; i < 7; i++) {   
            for (int j = 9; j < 16; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }        
              } //MONTAÑITA IZQUERDA CON FLORES ENCIMA
            
            for (int i = 1; i < 6; i++) { //arbolito
            
                casillas[i][16]=new Celda(i+(i*sizeCell),
                                    16+(16*sizeCell),'O');
                        
              }
            
            for (int j = 10; j < 15; j++) {
            
                casillas[7][j]=new Celda(7+(7*sizeCell),
                                    j+(j*sizeCell),'O');
                        
              }
            
            for (int i = 4; i < 5; i++) {  //piedra chica
            for (int j = 4; j < 6; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
            }}
            
            for (int i = 28; i <33; i++) {  //montania grande derecha/arriba
                for (int j = 0; j <11; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            casillas[32][10]=new Celda(32+(32*sizeCell),
                                    10+(10*sizeCell),'C');
            
            for (int i = 25; i <29; i++) {  //montania grande derecha/arriba2
                for (int j = 3; j <11; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            
            for (int i = 21; i <22; i++) {  //3 arboles juntos en columna al medio
                for (int j = 6; j <10; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            
//            for (int i = 16; i <20; i++) {  //
//                for (int j = 15; j <19; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
            
            casillas[16][15]=new Celda(16+(16*sizeCell),  //puntas de ese arbol
                                    15+(15*sizeCell),'C');
            casillas[19][15]=new Celda(19+(19*sizeCell),
                                    15+(15*sizeCell),'C');
            
            for (int i = 13; i <15; i++) {  //floress
                for (int j = 21; j <26; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            
            for (int i = 29; i <38; i++) {  //base de malos
                for (int j = 21; j <30; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            
            for (int i = 18; i <25; i++) {  //montanita inferior
                for (int j = 26; j <30; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            casillas[18][26]=new Celda(18+(18*sizeCell),  //esquinas de esa montana
                                    26+(26*sizeCell),'C');
            casillas[24][26]=new Celda(24+(24*sizeCell),
                                    26+(26*sizeCell),'C');
            
            for (int i = 32; i <38; i++) {  //montanita inferior
                for (int j = 12; j <17; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            
            for (int i = 1; i <10; i++) {  //3 arboles juntos izquierda inferior
                for (int j = 19; j <23; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
            
             for (int i = 25; i <28; i++) {  //arbolito
                for (int j = 15; j <18; j++) {
                casillas[i][j]=new Celda(i+(i*sizeCell),
                                    j+(j*sizeCell),'O');
                }
            }
    
    }
    
    
   
     
      static int numeroAleatorio(int minimo, int maximo) {
       Random random = new Random();
       int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
       return numero_aleatorio;
    }

    
}

 
    
    
 

