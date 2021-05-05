
package package1;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        


       Libreria libreria = new Libreria("Hola");     

       libreria.crearEspacioDeLibreria(10); 

       libreria.AsignarLibros("g", "b", "c");

       libreria.AsignarLibros("h", "b", "f");

       libreria.AsignarLibros("b", "d", "c");

       libreria.AsignarLibros("f", "s", "c");

       libreria.AsignarLibros("a", "f", "f");

       libreria.AsignarLibros("n", "b", "x");

       libreria.AsignarLibros("g", "h", "m");

       libreria.AsignarLibros("h", "g", "j");
       
       libreria.AsignarLibros("h", "g", "z");
       
       libreria.AsignarLibros("h", "g", "a");
       
       libreria.AsignarLibros("h", "g", "a");
       
       libreria.borrarLibro(11);


       libreria.ordenarPorTitulo();

       System.out.println(libreria.mostrarLibreria());
       
       System.out.println(libreria.toStringLibreria());


        
        System.out.println(libreria.mostrarLibrosAsignados());
        
        
        
        System.out.println(libreria.mostrarLibrosAsignados());
 
    }
    
}
