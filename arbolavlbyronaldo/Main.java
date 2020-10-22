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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolAVL avl = new ArbolAVL();
        avl.insertar(6);
        avl.insertar(16);
        avl.insertar(26);
        avl.insertar(36);
        avl.insertar(46);
        avl.insertar(50);
        avl.insertar(21);
        System.out.println("el recorrido en preorden es: ");
        avl.recorrerPreorden(avl.obtenerRaiz());
        System.out.println("");
        System.out.println("el recorrido en postorden es: ");
        avl.recorrerPostorden(avl.obtenerRaiz());
        System.out.println("");
        System.out.println("el recorrido en inorden es: ");
        avl.recorrerInorden(avl.obtenerRaiz());
    }
    
}
