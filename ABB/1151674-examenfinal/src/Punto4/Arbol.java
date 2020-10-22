/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;

/**
 *
 * @author estudiante
 */
public class Arbol {

    NodoArbol raiz;
    int tamano;
    int cantidad;

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

    //metodo para recorrer en Preorden  el arbol
    public void preorden(NodoArbol raiz) {
        if (raiz == null) {
            return;
        } else {
            System.out.print(raiz.dato + " ");
            preorden(raiz.hijoIzquierdo);
            preorden(raiz.hijoDerecho);
        }
    }

    //metodo para recorrer en PostOrden el arbol
    public void postOrden(NodoArbol raiz) {
        if (raiz == null) {
            return;
        } else {
            postOrden(raiz.hijoIzquierdo);
            postOrden(raiz.hijoDerecho);
            System.out.print( raiz.dato + " ");
        }
    }

    // metodo para recorrer en  Inorden el arbol
    public void inorden(NodoArbol raiz) {
        if (raiz == null) {
            return;
        } else {
            inorden(raiz.hijoIzquierdo);
            System.out.print(raiz.dato + " ");
            inorden(raiz.hijoDerecho);
        }
    }

    //metodo para saber la cantidad de nodos hoja en el arbol
    private void cantidadHojas(NodoArbol raiz) {
        if (raiz != null) {

            if (raiz.hijoIzquierdo == null && raiz.hijoDerecho == null) {
                cantidad++;
            }
            cantidadHojas(raiz.hijoIzquierdo);
            cantidadHojas(raiz.hijoDerecho);
        }
    }

    public int cantidadNodosHojas(NodoArbol raiz) {
        cantidad = 0;
        cantidadHojas(raiz);
        return cantidad;
    }

    //Imprime un arbol de forma grafica
    public void imprimirArbolGrafico() {
        if (this.raiz == null) {
            System.out.println("n");
            return;
        }
        int alt = calcularAltura();
        Integer[][] arbolM = new Integer[alt][];
        int i = 0;
        for (; i < arbolM.length; i++) {
            int cant = (int) (Math.pow(2, i));
            arbolM[i] = new Integer[cant];
        }
        toMatriz(this.raiz, arbolM, 0);
        do {
            String espacio = "";
            i--;
            int limit = (int) (Math.pow(2, i));
            for (int a = 0; a < limit; a++) {
                espacio += " ";
            }
            for (int a = 0; a < arbolM[alt - i - 1].length; a++) {
                Integer num = arbolM[alt - i - 1][a];
                if ((a + 1) % 2 == 0) {
                    System.out.print(espacio + espacio);
                } else {
                    System.out.print(espacio);
                }
                if (num == Integer.MIN_VALUE) {
                    System.out.print("n");
                } else {
                    System.out.print(num);
                }
            }
            System.out.println("");
        } while (i > 0);
    }

    public int calcularAltura() {
        int alt = 0;
        return sumatoria(this.raiz, alt);
    }

    private int sumatoria(NodoArbol n, int cant) {
        if (n == null) {
            return cant;
        }
        if (n.esHoja()) {
            return cant + 1;
        }
        int aizq, ader;
        cant++;
        aizq = sumatoria(n.getHijoIzquierdo(), cant);
        ader = sumatoria(n.getHijoDerecho(), cant);

        return aizq > ader ? aizq : ader;
    }

    private void toMatriz(NodoArbol n, Integer[][] arbolM, int nivel) {
        if (nivel >= arbolM.length) {
            return;
        }
        for (int i = 0; i < arbolM[nivel].length; i++) {
            if (arbolM[nivel][i] == null) {
                if (n == null) {
                    arbolM[nivel][i] = Integer.MIN_VALUE;
                    toMatriz(null, arbolM, nivel + 1);
                    toMatriz(null, arbolM, nivel + 1);
                    return;
                }
                arbolM[nivel][i] = n.getDato();
                break;
            }
        }
        toMatriz(n.getHijoIzquierdo(), arbolM, nivel + 1);
        toMatriz(n.getHijoDerecho(), arbolM, nivel + 1);
    }
}
