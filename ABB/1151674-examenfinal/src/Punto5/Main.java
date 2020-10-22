/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto5;

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

        Arbol ab = new Arbol();
        ab.insertaNodo(5);
        ab.insertaNodo(50);
        ab.insertaNodo(55);
        ab.insertaNodo(25);
        ab.insertaNodo(35);
        ab.insertaNodo(15);
        ab.insertaNodo(75);

        System.out.println("");
        System.out.println("el recorrido en inorde es: \n");
        ab.recorrerInorden(ab.raiz);
        System.out.println("");

        System.out.println("La distancia de los nodos en el nivel es :" + ab.NodosNivelDistancia(3));

    }

}
