/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 *
 * @author estudiante
 */
public class Arbol {

    NodoArbol raiz;
    int tamano;

    public Arbol() {
    }

    public Arbol(NodoArbol raiz) {
        this.raiz = null;
    }

    //metodo para saber si el arbol esta vacio
    public boolean estaVacio() {

        return raiz == null;

    }

    //metodo recursivo para insertar un nodo al arbol
    public void insertaNodo(int Elem) {
        if (raiz == null) {
            raiz = new NodoArbol(Elem);
        } else {
            raiz.insertar(Elem);
        }
        tamano++;

    }

    //metodo para recorrer un arbol en inorden
    public void recorrerInorden(NodoArbol raiz) {
        if (raiz == null) {
            return;

        } else {
            recorrerInorden(raiz.hijoIzquierdo);
            System.out.print(raiz.dato + " ");
            recorrerInorden(raiz.hijoDerecho);
        }

    }

    //metodo para recorrer un arbol en preorden
    public void recorrerPreorden(NodoArbol raiz) {
        if (raiz == null) {
            return;
        } else {
            System.out.print(raiz.dato + " ");
            recorrerPreorden(raiz.hijoIzquierdo);
            recorrerPreorden(raiz.hijoDerecho);
        }

    }

    //metodo para recorrer un arbol en postorden
    public void recorrerPostorden(NodoArbol raiz) {
        if (raiz == null) {
            return;
        } else {
            recorrerPostorden(raiz.hijoIzquierdo);
            recorrerPostorden(raiz.hijoDerecho);
            System.out.print(raiz.dato + " ");
        }

    }

}
