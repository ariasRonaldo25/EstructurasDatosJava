/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto5;

/**
 *
 * @author estudiante
 */
public class Arbol {

    NodoArbol raiz;
    int tamano;

    public Arbol() {

        raiz = null;
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

    //metodo para contar la cantidad de nodos en un nivel n hacia abajo.
    public int NodosNivelDistancia(int nivel) {

        return NodosNivelDistancia(this.raiz, nivel);
    }

    private int NodosNivelDistancia(NodoArbol raiz, int nivel) {

        if (raiz == null) {

            return 0;
        } else {

            int cantidadNodosIzquierdoHaciaAbajo = NodosNivelDistancia(raiz.hijoIzquierdo, nivel - 1);
            int cantidadNodosDerechoHaciaAbajo = NodosNivelDistancia(raiz.hijoDerecho, nivel - 1);

            if (nivel <= 0) {

                return cantidadNodosIzquierdoHaciaAbajo + cantidadNodosDerechoHaciaAbajo + 1;

            }

            return cantidadNodosIzquierdoHaciaAbajo + cantidadNodosDerechoHaciaAbajo;

        }

    }

}
