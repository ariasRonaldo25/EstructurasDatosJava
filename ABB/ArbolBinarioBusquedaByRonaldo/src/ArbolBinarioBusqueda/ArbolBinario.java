/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioBusqueda;

/**
 *
 * @author Ronaldo Arias
 */
public class ArbolBinario {

    NodoArbol raiz;
    int tamano;
    int cantidad;
    private int altura;

    int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public ArbolBinario() {

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

    /// metodo no recursivo para agregar un nodo al Arbol
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

    //cantidad de niveles que posee el arbol
    public int altura(NodoArbol raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(raiz.hijoIzquierdo), altura(raiz.hijoDerecho));
        }
    }

    //cantidad de elementos que posee el arbol	
    public int tamaño(NodoArbol raiz) {
        if (raiz == null) {
            return 0;
        } else {
            return 1 + tamaño(raiz.hijoIzquierdo) + tamaño(raiz.hijoDerecho);
        }
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

    //Busca un elemento en el arbol
    public void buscar(int Elem, NodoArbol raiz) {
        if (raiz == null | raiz.dato == Elem) {
            System.out.print(raiz.dato + " ");
            return;
        } else {
            if (Elem > raiz.dato) {
                buscar(Elem, raiz.hijoDerecho);
            } else {
                buscar(Elem, raiz.hijoIzquierdo);
            }
        }
    }

    // Metodo para buscar un nodo en el arbol
    public boolean buscarNodo(int dato) {
        NodoArbol aux = raiz;
        while (aux != null) {
            if (dato == aux.dato) {
                return true;
            } else if (dato > aux.dato) {
                aux = aux.hijoDerecho;
            } else {
                aux = aux.hijoIzquierdo;
            }
        }
        return false;
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

    //metodo para contar la cantidad de nodos en un nivel n.
    public int cantidadDeNodosNivel(int nivel) {

        return cantidadDeNodosNivel(this.raiz, nivel);
    }

    private int cantidadDeNodosNivel(NodoArbol raiz, int nivel) {

        if (raiz == null) {

            return 0;
        } else {

            int cantidadNodosIzquierdo = cantidadDeNodosNivel(raiz.hijoIzquierdo, nivel - 1);
            int cantidadNodosDerecho = cantidadDeNodosNivel(raiz.hijoDerecho, nivel - 1);

            if (nivel >= 0) {

                return cantidadNodosIzquierdo + cantidadNodosDerecho + 1;

            }

            return cantidadNodosIzquierdo + cantidadNodosDerecho;

        }

    }

    //metodo para contar la cantidad de nodos en un nivel n hacia abajo.
    public int cantidadDeNodosNivelHaciaAbajo(int nivel) {

        return cantidadDeNodosNivelHaciaAbajo(this.raiz, nivel);
    }

    private int cantidadDeNodosNivelHaciaAbajo(NodoArbol raiz, int nivel) {

        if (raiz == null) {

            return 0;
        } else {

            int cantidadNodosIzquierdoHaciaAbajo = cantidadDeNodosNivelHaciaAbajo(raiz.hijoIzquierdo, nivel - 1);
            int cantidadNodosDerechoHaciaAbajo = cantidadDeNodosNivelHaciaAbajo(raiz.hijoDerecho, nivel - 1);

            if (nivel <= 0) {

                return cantidadNodosIzquierdoHaciaAbajo + cantidadNodosDerechoHaciaAbajo + 1;

            }

            return cantidadNodosIzquierdoHaciaAbajo + cantidadNodosDerechoHaciaAbajo;

        }

    }

    //metodo para encontrar el nodo con el menor valor del arbol
    public void NodoMenorValor() {
        if (raiz != null) {
            NodoArbol aux = raiz;
            while (aux.hijoIzquierdo != null) {
                aux = aux.hijoIzquierdo;
            }
            System.out.println(" El nodo con el menor valor del árbol es:" + aux.dato);
        }
    }

    //metodo para calcular la altura de un arbol
    public int calcularAltura(NodoArbol raiz) {
        if (raiz == null) {
            return 0;
        } else {
            int alturaIzquerda = calcularAltura(raiz.hijoIzquierdo);
            int alturaDercha = calcularAltura(raiz.hijoDerecho);
            if (alturaIzquerda > alturaDercha) {
                return (alturaIzquerda + 1);
            } else {
                return (alturaDercha + 1);
            }
        }
    }

    //metodo para eliminar el nodo con menor valor
    public void borrarNodoMenor() {
        if (raiz != null) {
            if (raiz.hijoIzquierdo == null) {
                raiz = raiz.hijoDerecho;
            } else {
                NodoArbol atras = raiz;
                NodoArbol aux = raiz.hijoIzquierdo;
                while (aux.hijoIzquierdo != null) {
                    atras = aux;
                    aux = aux.hijoIzquierdo;
                }
                atras.hijoIzquierdo = aux.hijoDerecho;
            }
        }
    }

    //metodo para eliminar el nodo con mayor valor
    public void borrarNodoMayor() {
        if (raiz != null) {
            if (raiz.hijoDerecho == null) {
                raiz = raiz.hijoIzquierdo;
            } else {
                NodoArbol atras = raiz;
                NodoArbol aux = raiz.hijoDerecho;
                while (aux.hijoDerecho != null) {
                    atras = aux;
                    aux = aux.hijoDerecho;
                }
                atras.hijoDerecho = aux.hijoIzquierdo;
            }
        }
    }

    public void Balance(NodoArbol raiz, boolean lado, int i) {

        int subizq = 0;
        int subder = 0;

        if (raiz != null) {

            if (raiz.hijoDerecho == null && raiz.hijoIzquierdo == null) {
                if (lado) {
                    subder = (i > subder) ? i : subder;
                } else {
                    subizq = (i > subizq) ? i : subizq;
                }
            }

            Balance(raiz.hijoDerecho, lado, i + 1);
            if (i == 0) {
                lado = false;
            }
            Balance(raiz.hijoIzquierdo, lado, i + 1);
        }

    }

    public void imprimirBalance() {
        int subizq = 0;
        int subder = 0;

        Balance(this.raiz, true, 0);
        System.out.println("lado Izquierdo " + subizq + " Lado Derecho " + subder);
        if (subizq - subder == 0) {
            System.out.println("El balance es: 0 ");
        } else if (subizq - subder == -1) {
            System.out.println("El balance es -1, derecha");
        } else if (subizq - subder == 1) {
            System.out.println("El balance 1, izquierda");

        } else {
            System.out.println("No es balanceado.."
                    + "porque es mas grande el lado "
                    + ((subizq > subder) ? "Izquierdo" : "Derecho"));
        }

    }

    //metodo para saber si un arbol es completo 
    public boolean arbolCompleto(NodoArbol raiz) {
        if (raiz == null) {

            return false;
        }

        if (!esHoja(raiz.hijoDerecho) && !esHoja(raiz.hijoIzquierdo)) {
            arbolCompleto(raiz.hijoDerecho);
            arbolCompleto(raiz.hijoIzquierdo);

        } else {

            return true;

        }

        return false;

    }

    //metodo para saber si un arbol esta lleno
    public boolean arbolLleno(NodoArbol r) {
        if (raiz == null || (raiz.hijoIzquierdo != null || raiz.hijoDerecho != null)) {
            return true;
        }
        return (arbolLleno(r.hijoIzquierdo) && arbolLleno(r.hijoDerecho));
    }

    public void imprimirlongitudNivel(NodoArbol r, int elemento) {
        if (r == null) {
            return;
        }
        if (1 == elemento) {
            System.out.println(r.dato);
        }

        imprimirlongitudNivel(r.hijoIzquierdo, elemento - 1);
        imprimirlongitudNivel(r.hijoDerecho, elemento - 1);
    }

    //metodo para imprimir un nodo con su respectivo nivel
    private void imprimirConNivel(NodoArbol aux, int nivel) {
        if (aux != null) {
            imprimirConNivel(aux.hijoIzquierdo, nivel + 1);
            System.out.print(aux.dato + " (" + nivel + ") - ");
            imprimirConNivel(aux.hijoDerecho, nivel + 1);
        }
    }

    public void imprimirConNivel() {
        imprimirConNivel(raiz, 1);
        System.out.println();
    }

    //metodo para sumar los nodos de un ninvel n
    public int sumaNodosNivel(int nivel) {

        return sumaNodosNivel(this.raiz, nivel);
    }

    private int sumaNodosNivel(NodoArbol raiz, int nivel) {

        if (raiz == null) {
            return 0;
        } else {
            int sumaIzquierdo = sumaNodosNivel(raiz.hijoIzquierdo, nivel - 1);
            int sumaDerecho = sumaNodosNivel(raiz.hijoDerecho, nivel - 1);

            if (nivel <= 0) {

                return sumaIzquierdo + sumaDerecho + (Integer) raiz.dato;
            }

            return sumaIzquierdo + sumaDerecho;
        }

    }

    //metodo para saber si un nodo es hoja
    public boolean esHoja(NodoArbol raiz) {
        boolean hoja = false;
        if ((raiz == null) && (raiz == null)) {
            hoja = true;
        }
        return hoja;
    }

    //metodo para saber la cantidad de nodos hoja en el arbol
    private void cantidadNodosHoja(NodoArbol raiz) {
        if (raiz != null) {

            if (raiz.hijoIzquierdo == null && raiz.hijoDerecho == null) {
                cantidad++;
            }
            cantidadNodosHoja(raiz.hijoIzquierdo);
            cantidadNodosHoja(raiz.hijoDerecho);
        }
    }

    public int cantidadNodosHojas(NodoArbol raiz) {
        cantidad = 0;
        cantidadNodosHoja(raiz);
        return cantidad;
    }

    public void imprimirHermano(int elemento) {
        NodoArbol aux = raiz;
        NodoArbol temporal = raiz;
        while (aux.dato != elemento) {
            temporal = aux;
            if (aux.dato > elemento) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
        }
        if (temporal.hijoIzquierdo.dato == elemento) {
            System.out.println((temporal.hijoDerecho == null) ? "No tiene hermano" : temporal.hijoDerecho.dato);
        } else {
            System.out.println((temporal.hijoIzquierdo == null) ? "No tiene hermano" : temporal.hijoIzquierdo.dato);
        }
    }

    //metodo para mezclar dos Arboles        
    public void mezclarDosArboles(NodoArbol a, NodoArbol b) {
        int contador = 0;

        if (a == null) {
            return;
        } else {
            mezclarDosArboles(a.hijoIzquierdo, b);
            b.insertar(a.dato);
            contador++;
            mezclarDosArboles(a.hijoDerecho, b);

        }

        if (contador == (this.tamaño(a))) {

            this.recorrerInorden(b);

        }
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

    // eliminar un elemto de un arbol
    public boolean eliminar(int a) {
        NodoArbol aux = raiz;
        NodoArbol aux1 = raiz;
        boolean esHijoIzq = true;
        while (aux.dato != a) {
            aux1 = aux;
            if (a < aux.dato) {
                esHijoIzq = true;
                aux = aux.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                aux = aux.hijoDerecho;
            }

            if (aux == null) {
                return false;
            }
        }
        if (aux.hijoIzquierdo == null && aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                aux1.hijoIzquierdo = null;
            } else {
                aux1.hijoDerecho = null;
            }
        } else if (aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = aux.hijoIzquierdo;
            } else if (esHijoIzq) {
                aux1.hijoIzquierdo = aux.hijoIzquierdo;
            } else {
                aux1.hijoDerecho = aux.hijoIzquierdo;
            }
        } else if (aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hijoDerecho;
            } else if (esHijoIzq) {
                aux1.hijoIzquierdo = aux.hijoDerecho;
            } else {
                aux1.hijoDerecho = aux.hijoIzquierdo;
            }
        } else {
            NodoArbol reemplazo = obtenerodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                aux1.hijoIzquierdo = reemplazo;
            } else {
                aux1.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }

    public NodoArbol obtenerodoReemplazo(NodoArbol raiz) {
        NodoArbol rp = raiz;
        NodoArbol rem = raiz;
        NodoArbol aux = raiz.hijoDerecho;
        while (aux != null) {
            rp = rem;
            rem = aux;
            aux = aux.hijoIzquierdo;
        }
        if (rem != raiz.hijoDerecho) {
            rp.hijoIzquierdo = rem.hijoDerecho;
            rem.hijoDerecho = raiz.hijoDerecho;

        }
        System.out.println("" + rem);
        return rem;
    }

}
