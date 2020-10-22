/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumaArboles;

/**
 *
 * @author Ronaldo Arias
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArbolBin ab1 = new ArbolBin();
        ab1.insertaNodo(5);
        ab1.insertaNodo(4);
        ab1.insertaNodo(6);

        ArbolBin ab2 = new ArbolBin();
        ab2.insertaNodo(2);
        ab2.insertaNodo(1);
        ab2.insertaNodo(3);

        ArbolBin ab = new ArbolBin();

        sumarArboles(ab1.Raiz, ab2.Raiz, ab);

        System.out.println("arbol original A");
        ab1.inorden(ab1.Raiz);
        System.out.println("\n" + "arbol original B ");
        ab2.inorden(ab2.Raiz);
        System.out.println("\n" + "suma de arboles");
        ab.inorden(ab.Raiz);

//        suma(ab1.Raiz, ab2.Raiz);
    }

    //sumar 2 arboles en uno nuevo
    static void sumarArboles(NodoB A, NodoB B, ArbolBin ab) {

        if (A != null && B != null) {

            if ((A.hijoIzquierdo == null && B.hijoIzquierdo != null) || (A.hijoDerecho == null && B.hijoDerecho != null)) {

                ab.insertaNodo(B.dato);

            } else if ((A.hijoIzquierdo != null && B.hijoIzquierdo == null) || (A.hijoDerecho != null && B.hijoDerecho == null)) {

                ab.insertaNodo(A.dato);

            } else {

                ab.insertaNodo(A.dato + B.dato);
            }

            sumarArboles(A.hijoIzquierdo, B.hijoIzquierdo, ab);
            sumarArboles(A.hijoDerecho, B.hijoDerecho, ab);

        }

    }

}
