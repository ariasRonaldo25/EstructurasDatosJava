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
public class ArbolBin {

    NodoB Padre;
    NodoB Raiz;
    

    int tamanio;

    //Constructor
    public ArbolBin() {
        Raiz = null;
    }

    public int getTamanio() {
        return tamanio;
    }

    //Insercion de un elemento en el arbol
    public void insertaNodo(int Elem) {
        if (Raiz == null) {
            Raiz = new NodoB(Elem);
        } else {
            Raiz.insertar(Elem);
        }
        tamanio++;
    }

    //Preorden Recursivo del arbol
    public void preorden(NodoB Nodo) {
        if (Nodo == null) {
            return;
        } else {
            System.out.print(Nodo.dato + " ");
            preorden(Nodo.hijoIzquierdo);
            preorden(Nodo.hijoDerecho);
        }
    }

    //PostOrden recursivo del arbol
    public void postOrden(NodoB Nodo) {
        if (Nodo == null) {
            return;
        } else {
            postOrden(Nodo.hijoIzquierdo);
            postOrden(Nodo.hijoDerecho);
            System.out.print(Nodo.dato + " ");
        }
    }

    //Inorden Recursivo del arbol
    public void inorden(NodoB Nodo) {
        if (Nodo == null) {
            return;
        } else {
            inorden(Nodo.hijoIzquierdo);
            System.out.print(Nodo.dato + " ");
            inorden(Nodo.hijoDerecho);
        }
    }

//cantidad de niveles q	ue posee el arbol
    public int altura(NodoB Nodo) {
        if (Nodo == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(Nodo.hijoIzquierdo), altura(Nodo.hijoDerecho));
        }
    }
//cantidad de elementos que posee el arbol	

    public int tamaño(NodoB Nodo) {
        if (Nodo == null) {
            return 0;
        } else {
            return 1 + tamaño(Nodo.hijoIzquierdo) + tamaño(Nodo.hijoDerecho);
        }
    }
    //Busca un elemento en el arbol
//public void buscar (int Elem, NodoB A){
//                
//		if(A == null | A.dato == Elem){
//			encontrado = true;
//                        System.out.print(A.dato + " ");
//			return;
//		}
//		else{
//			if(Elem>A.dato)
//				buscar(Elem, A.Hder);
//			else
//				buscar( Elem, A.Hizq);
//                        
//		}
//	}

    public boolean buscar(NodoB A, int Elem) {

        boolean encontrado = false;

        if (A != null) {

            if (A.dato == Elem) {
                encontrado = true;
            }

            boolean ok1 = buscar(A.hijoIzquierdo, Elem);

            boolean ok2 = buscar(A.hijoDerecho, Elem);

            if ((ok1 == true) || (ok2 == true)) {

                encontrado = true;

            }

        }

        return encontrado;

    }
}
