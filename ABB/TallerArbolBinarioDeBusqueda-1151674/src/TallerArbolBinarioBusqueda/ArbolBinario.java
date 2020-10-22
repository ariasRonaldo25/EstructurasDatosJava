/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerArbolBinarioBusqueda;

/**
 *
 * @author Ronaldo Arias
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {

        raiz = null;
    }

    ///Metodo para agregar un nodo al Arbol
    public void agregarNodo(int dato) {

        NodoArbol nuevo = new NodoArbol(dato);

        if (raiz == null) {

            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;

            while (true) {
                padre = auxiliar;
                if (dato < auxiliar.dato) {
                    auxiliar = auxiliar.hijoIzquierdo;
                }
                if (auxiliar == null) {
                    padre.hijoIzquierdo = nuevo;
                    return;
                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {

                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }

        }

    }

    //metodo para saber si el arbol esta vacio
    public boolean estaVacio() {

        return raiz == null;

    }

    //metodo para encontar el nodo con el mayor valor del arbol(ejercicio 1)
    public void nodoMayorValor() {
        if (raiz != null) {
            NodoArbol reco = raiz;
            while (reco.hijoDerecho != null) {
                reco = reco.hijoDerecho;
            }
            System.out.println(" El nodo con el mayor valor del árbol:" + reco.dato);
        }
    }

    //metodo para contar la cantidad de nodos en un nivel del arbol (ejercicio 2)
    public int cantidadDeNodosNivel(int nivel) {

        return cantidadDeNodosNivel(this.raiz, nivel);
    }

    private int cantidadDeNodosNivel(NodoArbol raiz, int nivel) {

        if (raiz == null) {

            return 0;
        } else {

            int cantidadNodosIzquierdo = cantidadDeNodosNivel(raiz.hijoIzquierdo, nivel - 1);
            int cantidadNodosDerecho = cantidadDeNodosNivel(raiz.hijoDerecho, nivel - 1);

            if (nivel == 0) {

                return cantidadNodosIzquierdo + cantidadNodosDerecho + 1;

            }

            return cantidadNodosIzquierdo + cantidadNodosDerecho;

        }

    }

    //metodo para saber si un arbol es completo o no (ejercicio 3).
    public boolean arbolCompleto(NodoArbol raiz, int subIzq, int subDer) {

        if (raiz != null) {

            if (subIzq == subDer) {

                return true;
            }
        } else {

            return false;

        }

        return false;
    }
}
