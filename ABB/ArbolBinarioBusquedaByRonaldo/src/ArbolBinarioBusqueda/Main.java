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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArbolBinario ab = new ArbolBinario();
        ArbolBinario ab2 = new ArbolBinario();

//        System.out.println("El arbol esta vacio?" + " " + ab.estaVacio());
        //insertamos nodos al arbol
        ab.agregarNodo(5);
        ab.agregarNodo(10);
        ab.agregarNodo(7);
        ab.agregarNodo(50);
        ab.agregarNodo(51);

        // ab2.insertaNodo(1);
        ab2.insertaNodo(10);
        //ab2.insertaNodo(17);
        //ab2.insertaNodo(19);
        ab2.insertaNodo(11);
        //ab2.insertaNodo(18);

        System.out.println("el recorrido en inorden del arbol 2 es: ");
        ab2.recorrerInorden(ab2.raiz);

        System.out.println("");

        System.out.println("la mezcla de los dos arboles es:\n");
        ab.mezclarDosArboles(ab.raiz, ab2.raiz);

        System.out.println("");

        System.out.println("el recorrido en inorden es: ");
        ab.recorrerInorden(ab.raiz);
        System.out.println("");
        System.out.println("el recorrido en preorden es: ");
        ab.recorrerPreorden(ab.raiz);
        System.out.println("");
        System.out.println("el recorrido en postorden es: ");
        ab.recorrerPostorden(ab.raiz);

        System.out.println("");
        System.out.println("la cantidad de niveles del arbol es :" + ab.altura(ab.raiz));
        System.out.println("la cantidad de nodos del arbol es :" + ab.tamaño(ab.raiz));
        System.out.println("el nodo tiene hermano?\n");
        ab.imprimirHermano(50);

        ab.nodoMayorValor();
        ab.NodoMenorValor();

        System.out.println("");
        ab.borrarNodoMayor();
        ab.borrarNodoMenor();
        System.out.println("recorrido en inorden luego de eliminar los nodos con mayor y menor valor del arbol\n");
        ab.recorrerInorden(ab.raiz);
        System.out.println("");

        System.out.println("el nodo ha sido encontrado?\n" + ab.buscarNodo(50));
        System.out.println("el elemento encontrado es: \n");
        ab.buscar(10, ab.raiz);

        System.out.println("");
        System.out.println("La cantidad de nodos en el nivel es:" + ab.cantidadDeNodosNivel(0));

        System.out.println("La cantidad de nodos en el nivel hacia abajo es :" + ab.cantidadDeNodosNivelHaciaAbajo(1));

        System.out.println("La suma de los nodos desde el nivel es:" + ab.sumaNodosNivel(1));

        System.out.println("");

        System.out.println("la cantidad de nodos hoja en el arbol es:" + ab.cantidadNodosHojas(ab.raiz));

        System.out.println("");

        System.out.println("el arbol esta lleno?\n" + ab.arbolLleno(ab.raiz));

        System.out.println("los nodos del arbol y sus respectivos niveles son:\n");
        ab.imprimirConNivel();

        System.out.println("");
        ab.imprimirArbolGrafico();
        System.out.println("");
        System.out.println("el arbol es completo?\n" + ab2.arbolCompleto(ab2.raiz));

        ab.Balance(ab.raiz, true, 1);
        ab.imprimirBalance();

        ab.eliminar(51);
        System.out.println("");
        ab.recorrerInorden(ab.raiz);

    }
}
