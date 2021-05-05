
package package1;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        


       Libreria libreria = new Libreria("Hola1");     
       Libreria libreria2 = new Libreria("Hola2");
       Libreria libreria3 = new Libreria("Hola3");
       libreria.crearEspacioDeLibreria(10); 
       libreria2.crearEspacioDeLibreria(2);
       libreria3.crearEspacioDeLibreria(31);
       libreria3.crearEspacioDeLibreria(31);
       libreria3.crearEspacioDeLibreria(31);
       
       

       
       libreria.AsignarLibros("g", "b", "c");
       libreria.AsignarLibros("g", "b", "c");
       
       libreria.ModificarTitulo(2, "arroz con queso");
       libreria.ModificarAutor(2,"KANYE WEST");
       libreria.ModificarGenero(2, "cocina");

       libreria.AsignarLibros("dopeboy", "damnbitch", "dfuck");
       
       libreria.AsignarLibros("Daniel", "Ricardo", "Palacios");
       
       libreria.AsignarLibros("La voragine", "Niggapoop", "cocaine");
       
       libreria.AsignarLibros("daniellesabemanitojjaja", "b", "c");
       
       libreria.AsignarLibros("paola", "prato", "apratot");
       
 
      libreria.ordenarPorTitulo();
      
      System.out.println(libreria.buscarLibro(""));
       



       

      
 
    }
    
}
