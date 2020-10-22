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
public class Arbol {

    NodoArbol raiz;
    int tamano;

    //metodo recursivo para insertar un nodo al arbol
    public void insertaNodo(int Elem) {
        if (raiz == null) {
            raiz = new NodoArbol(Elem);
        } else {
            raiz.insertar(Elem);
        }
        tamano++;

    }

// retorna el dato mas grande de un arbol
    public int maxCota() {
        NodoArbol aux = raiz;
        while (aux != null) {
            if (aux.hijoDerecho == null) {
                return aux.dato;
            }
            aux = aux.hijoDerecho;
        }
        return aux.dato;
    }

}
