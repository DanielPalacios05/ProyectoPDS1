
package package1;

import java.util.ArrayList;
import java.util.Collections;
public class Libreria {
    public static ArrayList<Libreria> libreriasCreadas;
    private static int numLibrerias = 0; 
    
    
    private String nombre;
    private int cantidadDeLibrosMaxima = 0;
    private ArrayList<Libro[]> libreria;
    private ArrayList<Libro> librosAsignados;
    private int cantidadDeEspacios; // MODIFICAR EL DIAGRAMA DE CLASEs CON EL ATRIBUTO CANTIDAD DE ESPACIOS
    
    // Methods
    
    public Libreria(String name){
        this.libreria = new ArrayList<>();
        this.librosAsignados = new ArrayList<>();
        this.nombre = name;
        this.numLibrerias++;
    }
    
    public void crearEspacioDeLibreria(int cantidadMaxima){
        this.libreria.add(new Libro[cantidadMaxima]);
        this.cantidadDeLibrosMaxima += cantidadMaxima;
        this.cantidadDeEspacios++;
    }
    public void AsignarLibros(String titulo, String autor, String genero){
           this.librosAsignados.add(new Libro(titulo, autor, genero));
    }
    
    public String mostrarLibreria(){
        String libreria = this.nombre + ": ";
        
        for(int i = 0; i<this.libreria.size();i++){
            libreria += "\n" + "Espacio "+  i+1 +"\n";
            for(int j = 0;j<this.libreria.get(i).length;j++){
                if(this.libreria.get(i)[j] != null)
                    libreria += "\n" + this.libreria.get(i)[j].toString() + "\n";
            }
        }
        return libreria;
    }
    
    public String mostrarLibrosAsignados(){
        String info = "";
        
        for(int i = 0; i<librosAsignados.size();i++)
            info += "("+ (i+1) + ")\n" + librosAsignados.get(i).toString() + "\n";
      
        
        return info;
    }
    
    public String toStringLibreria(){
        String info = this.nombre +"\nCantidad de espacios: " + this.cantidadDeEspacios; 
        
        return info;
    }
    
    public void agregarTolibreria(ArrayList<Libro> libros){
        for(int i = 0; i<this.libreria.size(); i++)
            for(int j = 0 ;j<libros.size();j++){     // CUANDO HAY MENOS LIBROS QUE LA CANTIDAD MAXIMA DE LIBROS QUE PUEDE HABER EN UN ESPACIO, DA UN ERROR 
                libreria.get(i)[j] = libros.get(j);
            }
    }
    
     //Ordenan los LibrosAsignados y luego los ponen en las librerias.
    
    public void ordenarPorTitulo(){
        ArrayList<String> titulos = new ArrayList<>();
        ArrayList<Libro> librosOrdenados = new ArrayList<>();
         
        for(int i = 0; i<this.librosAsignados.size();i++)
            titulos.add(this.librosAsignados.get(i).getTitulo());
        
        Collections.sort(titulos);
        
        for(int i = 0; i<titulos.size(); i++)
            for(int j = 0; j<titulos.size() ;j++)
                if(titulos.get(i).equals(this.librosAsignados.get(j).getTitulo())){
                    librosOrdenados.add(this.librosAsignados.get(j));
                    break;
                }
        
        this.librosAsignados = librosOrdenados;
        
        agregarTolibreria(librosOrdenados);
    }
    public void ordenarPorAutor(){
        ArrayList<String> autores = new ArrayList<String>();
        ArrayList<Libro> librosOrdenados = new ArrayList<Libro>();
         
        for(int i = 0; i<this.librosAsignados.size();i++)
            autores.add(this.librosAsignados.get(i).getAutor());
        
        Collections.sort(autores);
  
        for(int i = 0; i<autores.size(); i++)
            for(int j = 0; j<autores.size() ;j++)
                if(autores.get(i).equals(this.librosAsignados.get(j).getAutor())){
                    librosOrdenados.add(this.librosAsignados.get(j));
                    break;
                }
        
        this.librosAsignados = librosOrdenados;
        
        agregarTolibreria(this.librosAsignados);
    }
    
    public void clasificarPorGenero(){
        ArrayList<String> generos = new ArrayList<>();
        ArrayList<Libro> librosOrdenados = new ArrayList<>();
         
        for(int i = 0; i<this.librosAsignados.size();i++)
            generos.add(this.librosAsignados.get(i).getGenero());
            
            Collections.sort(generos);
                
           for(int i = 0; i<generos.size(); i++)
            for(int j = 0; j<generos.size() ;j++)
                if(generos.get(i).equals(this.librosAsignados.get(j).getGenero())){
                    librosOrdenados.add(this.librosAsignados.get(j));
                    break;
                }
           this.librosAsignados = librosOrdenados;
        
           agregarTolibreria(this.librosAsignados);
    }
    
    public void borrarLibro(int indiceLibro){
        
       this.librosAsignados.remove(indiceLibro-1);
    }
    
    
    
}