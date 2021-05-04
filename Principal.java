
package package1;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        


       Libreria libreria = new Libreria("Hola");     

       libreria.crearEspacioDeLibreria(10); 

       libreria.AsignarLibros("h", "b", "c");

       libreria.AsignarLibros("b", "b", "f");

       libreria.AsignarLibros("c", "d", "c");

       libreria.AsignarLibros("d", "s", "c");

       libreria.AsignarLibros("a", "f", "f");

       libreria.AsignarLibros("f", "b", "c");

       libreria.AsignarLibros("g", "h", "c");

       libreria.AsignarLibros("h", "g", "d");
       
       libreria.AsignarLibros("h", "g", "d");
       
       libreria.AsignarLibros("h", "g", "d");


       libreria.ordenarPorTitulo();

       System.out.println(libreria.mostrarLibreria());


        
        
 
    }
    
}
