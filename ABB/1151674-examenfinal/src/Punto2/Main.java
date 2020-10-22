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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Arbol ab1 = new Arbol();
        ab1.insertaNodo(5);
        ab1.insertaNodo(4);
        ab1.insertaNodo(6);

        Arbol ab2 = new Arbol();
        ab2.insertaNodo(2);
        ab2.insertaNodo(1);
        ab2.insertaNodo(3);

        Arbol a = new Arbol();

        sumaPar(ab1.raiz, ab2.raiz, a);

        System.out.println("arbol original 1");
        ab1.recorrerInorden(ab1.raiz);
        System.out.println("\n" + "arbol  2 ");
        ab2.recorrerInorden(ab2.raiz);
        System.out.println("\n" + "suma par");
        a.recorrerInorden(a.raiz);
    }

    static void sumaPar(NodoArbol A, NodoArbol B, Arbol ab) {

        if (A != null && B != null) {

            if ((A.hijoIzquierdo == null && B.hijoIzquierdo != null) || (A.hijoDerecho == null && B.hijoDerecho != null)) {

                ab.insertaNodo(B.dato);

            } else if ((A.hijoIzquierdo != null && B.hijoIzquierdo == null) || (A.hijoDerecho != null && B.hijoDerecho == null)) {

                ab.insertaNodo(A.dato);

            } else {

                ab.insertaNodo(A.dato + B.dato);
            }

            sumaPar(A.hijoIzquierdo, B.hijoIzquierdo, ab);
            sumaPar(A.hijoDerecho, B.hijoDerecho, ab);

        }

    }

}
