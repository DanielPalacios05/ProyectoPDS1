
package package1;

import java.util.ArrayList;
import java.util.Collections;
public class Libreria {
    public static ArrayList<Libreria> libreriasCreadas = new ArrayList<>();
    private static int numLibrerias = 0; 
    
    
    private String nombre;
    private int cantidadDeLibrosMaxima = 0;
    private ArrayList<Libro[]> libreria;
    private ArrayList<Libro> librosAsignados;
    private int cantidadDeEspacios; 
    
    // Methods


    
    public Libreria(String name){
        this.libreria = new ArrayList<>();
        this.librosAsignados = new ArrayList<>();
        this.nombre = name;
        numLibrerias++;
    }

    public int getCantidadDelibrosMaxima(){ //Poner en diagrama de clases
        return this.cantidadDeLibrosMaxima;
    }
    
    public void crearEspacioDeLibreria(int cantidadMaxima){
        this.libreria.add(new Libro[cantidadMaxima]);
        this.cantidadDeLibrosMaxima += cantidadMaxima;
        this.cantidadDeEspacios++;
    }
    
    public void AsignarLibros(String titulo, String autor, String genero){
           this.librosAsignados.add(new Libro(titulo, autor, genero));
    }
    
    public void agregarTolibreria(ArrayList<Libro> libros){
        int j = 0;
        int indice = 0;

        for(int i = 0; i<this.libreria.size(); i++){
            while(indice < this.libreria.get(i).length){
               try{
                   this.libreria.get(i)[indice] = libros.get(j);
                    j++;
                    indice++;
                }catch (Exception e) {
                    break;
                }

                 
            }
            indice = 0;
        }
    }
    
    
    public static String mostrarLibrerias(){
        String librerias = "";
     
        for(int i = 0; i<libreriasCreadas.size();i++)
            librerias += "(" + (i+1) + ")\n" + libreriasCreadas.get(i).toStringLibreria() + "\n";
        
        return librerias;
    }
    
    public String mostrarLibreria(){
        String libreria = this.nombre + ": ";
        
        for(int i = 0; i<this.libreria.size();i++){
            libreria += "\n" + "\nEspacio "+  (i+1) +"\n";
            for(int j = 0;j<this.libreria.get(i).length;j++){
                if(this.libreria.get(i)[j] != null)
                    libreria += "\n" + this.libreria.get(i)[j].toString() + "\n";
            }
        }
        return libreria;
    }
    
    public String mostrarLibrosAsignados(){
        String info = "";

        if(librosAsignados.isEmpty())
            return "No se han asignado libros";


        for(int i = 0; i<librosAsignados.size();i++)
            info += "("+ (i+1) + ")\n" + librosAsignados.get(i).toString() + "\n";
      
        
        return info;
    }
    
    public String toStringLibreria(){
        String info = this.nombre +"\nCantidad de espacios: " + this.cantidadDeEspacios; 
        
        return info;
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
    
    
    
    public void ModificarTitulo(int indiceLibro, String modificar){
        this.librosAsignados.get(indiceLibro).setTitulo(modificar);
    }
    
    public void ModificarAutor(int indiceLibro, String modificar){
        this.librosAsignados.get(indiceLibro).setAutor(modificar);
    }
    
    public void ModificarGenero(int indiceLibro, String modificar){
        this.librosAsignados.get(indiceLibro).setGenero(modificar);
    }
    
    
    
    public String buscarLibro(String buscar){
        String resultado = "";
        String buscado = buscar.toLowerCase();
        
        if(buscar != "")
            for(int i = 0; i < this.libreria.size() ;i++)
                for(int j = 0 ;j < this.libreria.get(i).length ;j++)
                    if(this.libreria.get(i)[j] != null)
                        if(this.libreria.get(i)[j].getTitulo().toLowerCase().contains(buscado))
                            resultado += "\nEspacio:" + (i+1) + "\n\n" + "(" + (j+1) + ")\n" + this.libreria.get(i)[j].toString();  // Se ingresa una palabra clave y va comparando con cada dato de libro
                        else if(this.libreria.get(i)[j].getAutor().toLowerCase().contains(buscado))
                            resultado += "\nEspacio:" + (i+1) + "\n\n" + "(" + (j+1) + ")\n" + this.libreria.get(i)[j].toString();
                        else if(this.libreria.get(i)[j].getGenero().toLowerCase().contains(buscado))
                            resultado += "\nEspacio:" + (i+1) + "\n\n" + "(" + (j+1) + ")\n" + this.libreria.get(i)[j].toString();
        
        if(resultado == "")
            resultado = "No hay coincidecias";
        
        return resultado;                       
    }
    
    public void borrarLibro(int indiceLibro){
        
       this.librosAsignados.remove(indiceLibro);
    }
    public static void borrarLibreria(int indiceLibreria){
        libreriasCreadas.remove(indiceLibreria);
    }
}