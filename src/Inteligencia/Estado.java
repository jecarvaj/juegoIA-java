package Inteligencia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ian
 */
public class Estado implements Comparable {
    int x, y;
    char oper;
    Estado predecesor;
    public double f, g, h;
    
    public Estado(int x, int y, char oper, Estado predecesor)
    {
        this.x=x;
        this.y=y;
        this.oper=oper;
        this.predecesor=predecesor;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 67 * hash + this.x;
//        hash = 67 * hash + this.y;
//        return hash;
//    }
    
    @Override
    public boolean equals(Object estado)
    {
        Estado aux=(Estado) estado;
        
        return this.x==aux.x && this.y==aux.y;
    }

    
    @Override
    public int compareTo(Object o) {
        Estado e=(Estado)o;
        if ( this.f == e.f ) return 0;
        else {
            if ( this.f > e.f ) return 1;
            else return -1;
        }
    }

}

