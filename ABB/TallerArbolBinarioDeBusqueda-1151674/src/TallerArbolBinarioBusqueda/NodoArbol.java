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

    @Override
    public String toString() {
        return "NodoArbol{" + "dato=" + dato + ", hijoDerecho=" + hijoDerecho + ", hijoIzquierdo=" + hijoIzquierdo + '}';
    }

}
