
package package1;


public class Libro {
    private String titulo;
    private String autor;
    private String genero;    
    
    public Libro(String titulo, String autor, String genero){ // Clase libro
        this.titulo = titulo;
        this.autor  = autor;
        this.genero = genero;
    }
    public void setTitulo(String s){
        this.titulo = s;
    }
    public void setAutor(String s){
        this.autor = s;
    }
    public void setGenero(String s){
        this.genero = s;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    public String toString(){
        String texto = "Titulo: " + this.titulo + "\n" + "Autor: " + this.autor + "\n" + "Genero: " + this.genero + "\n"; 
        return texto;
    }
}