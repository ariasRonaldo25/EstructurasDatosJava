/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;

/**
 *
 * @author Ronaldo Arias -1151674
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Arbol ab = new Arbol();
        ab.insertaNodo(2);
        ab.insertaNodo(20);
        ab.insertaNodo(26);
        ab.insertaNodo(23);
        ab.insertaNodo(12);
        ab.insertaNodo(32);

        System.out.println("el recorrido en postorden es: \n");
        ab.postOrden(ab.raiz);

        System.out.println("");
        
        System.out.println("demostracion grafica del arbol: \n");
        ab.imprimirArbolGrafico();
        System.out.println("");
        System.out.println("la cantidad de hojas en el arbol es: " + ab.cantidadNodosHojas(ab.raiz));

    }

}
