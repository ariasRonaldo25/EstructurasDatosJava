/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

/**
 *
 * @author estudiante
 */
public class NodoArbol {

    int dato;
    NodoArbol hijoDerecho;
    NodoArbol hijoIzquierdo;

    public NodoArbol() {
    }

    public NodoArbol(int dato) {
        this.dato = dato;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void insertar(int Elem) {
        if (Elem < dato) {
            if (hijoIzquierdo == null) {
                hijoIzquierdo = new NodoArbol(Elem);
            } else {
                hijoIzquierdo.insertar(Elem);
            }
        } else {
            if (Elem > dato) {
                if (hijoDerecho == null) {
                    hijoDerecho = new NodoArbol(Elem);
                } else {
                    hijoDerecho.insertar(Elem);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "NodoArbol{" + "dato=" + dato + ", hijoDerecho=" + hijoDerecho + ", hijoIzquierdo=" + hijoIzquierdo + '}';
    }

    public boolean esHoja() {
        return hijoIzquierdo == null && hijoDerecho == null;
    }

}
