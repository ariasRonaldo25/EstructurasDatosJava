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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArbolBinario ab = new ArbolBinario();
        ab.agregarNodo(5);
        ab.agregarNodo(10);
        ab.agregarNodo(7);
        ab.agregarNodo(50);
        ab.agregarNodo(51);
        ab.agregarNodo(1);

        System.out.println("");
        ab.nodoMayorValor();

        System.out.println("");

        System.out.println("La cantidad de nodos en el nivel es:" + ab.cantidadDeNodosNivel(2));

        System.out.println("");

        System.out.println("El arbol es completo?\n" +  ab.arbolCompleto(ab.raiz, 3, 3));

    }

}
