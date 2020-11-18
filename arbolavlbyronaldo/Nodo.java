/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavlbyronaldo;

/**
 *
 * @author Ronaldo Arias
 */
public class Nodo {

    Nodo hijoDerecho;
    Nodo hijoIzquierdo;
    int dato;
    int fe;// factor de equilibrio

    public Nodo() {
    }

    public Nodo(int dato) {
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
        this.dato = dato;
        this.fe = 0;
    }

}
