/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavlbyronaldo;

/**
 *
 * @author Ronaldo Arias
 */
public class ArbolAVL {

    private Nodo raiz;

    public ArbolAVL() {
    }

    public Nodo obtenerRaiz() {
        return raiz;
    }

    public ArbolAVL(Nodo raiz) {
        this.raiz = null;
    }

    //metodo para buscar un nodo en el arbol
    public Nodo buscar(int dato, Nodo raiz) {

        if (raiz == null) {
            return null;
        } else if (raiz.dato == dato) {
            return raiz;
        } else if (raiz.dato < dato) {
            return buscar(dato, raiz.hijoDerecho);
        } else {
            return buscar(dato, raiz.hijoIzquierdo);
        }
    }

    //metodo para obtener el factor de equilibrio
    public int obtenerFE(Nodo x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;
        }
    }

    //metodo de rotacion simple a la izquierda
    public Nodo rotacionSimpleIzquierda(Nodo r) {
        Nodo aux = r.hijoIzquierdo;
        r.hijoIzquierdo = aux.hijoDerecho;
        aux.hijoDerecho = r;

        r.fe = Math.max(obtenerFE(r.hijoIzquierdo), obtenerFE(r.hijoDerecho)) + 1;
        aux.fe = Math.max(obtenerFE(aux.hijoIzquierdo), obtenerFE(aux.hijoDerecho)) + 1;
        return aux;

    }

    //metodo de rotacion simple a la derecha
    public Nodo rotacionSimpleDerecha(Nodo r) {
        Nodo aux = r.hijoDerecho;
        r.hijoDerecho = aux.hijoIzquierdo;
        aux.hijoIzquierdo = r;

        r.fe = Math.max(obtenerFE(r.hijoIzquierdo), obtenerFE(r.hijoDerecho)) + 1;
        aux.fe = Math.max(obtenerFE(aux.hijoIzquierdo), obtenerFE(aux.hijoDerecho)) + 1;
        return aux;

    }

    //metodo de rotacion doble a la izquierda
    public Nodo rotacionDobleIzquierda(Nodo r) {
        Nodo aux;
        r.hijoIzquierdo = rotacionSimpleDerecha(r.hijoIzquierdo);
        aux = rotacionSimpleIzquierda(r);
        return aux;
    }

    //metodo de rotacion doble a la derecha 
    public Nodo rotacionDobleDerecha(Nodo r) {
        Nodo aux;
        r.hijoDerecho = rotacionSimpleIzquierda(r.hijoDerecho);
        aux = rotacionSimpleDerecha(r);
        return aux;
    }

    //metodo para insertar un nodo en el arbol avl
    public Nodo insertarAVL(Nodo nuevo, Nodo subArbol) {
        Nodo nuevoPadre = subArbol;
        if (nuevo.dato < subArbol.dato) {
            if (subArbol.hijoIzquierdo == null) {
                subArbol.hijoIzquierdo = nuevo;
            } else {
                subArbol.hijoIzquierdo = insertarAVL(nuevo, subArbol.hijoIzquierdo);
                if (obtenerFE(subArbol.hijoIzquierdo) - obtenerFE(subArbol.hijoDerecho) == 2) {
                    if (nuevo.dato < subArbol.hijoIzquierdo.dato) {
                        nuevoPadre = rotacionSimpleIzquierda(subArbol);
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subArbol);
                    }
                }
            }
        } else if (nuevo.dato > subArbol.dato) {
            if (subArbol.hijoDerecho == null) {
                subArbol.hijoDerecho = nuevo;
            } else {
                subArbol.hijoDerecho = insertarAVL(nuevo, subArbol.hijoDerecho);
                if (obtenerFE(subArbol.hijoDerecho) - obtenerFE(subArbol.hijoIzquierdo) == 2) {
                    if (nuevo.dato > subArbol.hijoDerecho.dato) {
                        nuevoPadre = rotacionSimpleDerecha(subArbol);
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subArbol);
                    }
                }
            }
        } else {
            System.out.println("Nodo duplicado");
        }
        // actualizando el fe
        if ((subArbol.hijoIzquierdo == null) && (subArbol.hijoDerecho != null)) {
            subArbol.fe = subArbol.hijoDerecho.fe + 1;
        } else if ((subArbol.hijoDerecho == null) && (subArbol.hijoIzquierdo != null)) {
            subArbol.fe = subArbol.hijoIzquierdo.fe + 1;
        } else {
            subArbol.fe = Math.max(obtenerFE(subArbol.hijoIzquierdo), obtenerFE(subArbol.hijoDerecho) + 1);
        }
        return nuevoPadre;
    }

    //metodo para insertar
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }

    //metodo para recorrer un arbol en inorden
    public void recorrerInorden(Nodo raiz) {
        if (raiz == null) {
            return;

        } else {
            recorrerInorden(raiz.hijoIzquierdo);
            System.out.print(raiz.dato + " ");
            recorrerInorden(raiz.hijoDerecho);
        }

    }

    //metodo para recorrer un arbol en preorden
    public void recorrerPreorden(Nodo raiz) {
        if (raiz == null) {
            return;
        } else {
            System.out.print(raiz.dato + " ");
            recorrerPreorden(raiz.hijoIzquierdo);
            recorrerPreorden(raiz.hijoDerecho);
        }

    }

    //metodo para recorrer un arbol en postorden
    public void recorrerPostorden(Nodo raiz) {
        if (raiz == null) {
            return;
        } else {
            recorrerPostorden(raiz.hijoIzquierdo);
            recorrerPostorden(raiz.hijoDerecho);
            System.out.print(raiz.dato + " ");
        }

    }

}
