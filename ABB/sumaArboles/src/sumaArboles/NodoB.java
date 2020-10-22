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
public class NodoB{
	int dato;
	NodoB hijoIzquierdo, hijoDerecho;
	//Constructores
	NodoB (int Elem){
		dato = Elem;
		NodoB hijoIzquierdo, hijoDerecho = null;
	}
	NodoB (){
		NodoB Hizq, Hder = null;
	}
public void insertar(int Elem){
		if(Elem < dato){
			if (hijoIzquierdo == null)
				hijoIzquierdo = new NodoB(Elem);
			else
				hijoIzquierdo.insertar(Elem);
		}
		else{
			if (Elem > dato){
				if (hijoDerecho == null)
					hijoDerecho = new NodoB(Elem);
				else
					hijoDerecho.insertar(Elem);
			}
		}
	}

    public void setDato(int dato) {
        this.dato = dato;
    }

}
