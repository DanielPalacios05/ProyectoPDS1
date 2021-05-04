
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

       libreria.AsignarLibros("f", "b", "x");

       libreria.AsignarLibros("g", "h", "m");

       libreria.AsignarLibros("h", "g", "j");
       
       libreria.AsignarLibros("h", "g", "z");
       
       libreria.AsignarLibros("h", "g", "a");


       libreria.clasificarPorGenero();

       System.out.println(libreria.mostrarLibreria());


        
        
 
    }
    
}
