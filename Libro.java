
package package1;


public class Libro {
    private String titulo;
    private String autor;
    private String genero;    
    
    public Libro(String titulo, String autor, String genero){
        this.titulo = titulo;
        this.autor  = autor;
        this.genero = genero;
    }
    public void setTitulo(String s){
    }
    public void setAutor(String s){
    }
    public void setGenero(String s){
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
        String texto = this.titulo+" "+this.autor+" "+this.genero;
        return texto;
    }
}