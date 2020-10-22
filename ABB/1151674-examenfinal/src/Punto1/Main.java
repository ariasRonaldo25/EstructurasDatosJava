/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

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
        ab.insertaNodo(10);
        ab.insertaNodo(20);
        ab.insertaNodo(30);
        ab.insertaNodo(40);
        ab.insertaNodo(50);
        System.out.println("");
          System.out.println("El dato mas grande del arbol es:  " + ab.maxCota());

    }

}
