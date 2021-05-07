
package package1;

import java.util.Scanner;


public class Principal {

    public static int scanInt(){
        int num = 0;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while(flag){
        try {
            num = sc.nextInt();
            flag = false;
        } catch (Exception e) {
            System.out.println("El valor introducido es invalido");
            sc.next();
            continue;
        }
    }
    return num;
    }
    
    
    public  static void administrarLibreria(){
        boolean librosAsignados = false;
        Scanner scan2 = new Scanner(System.in);
        int cantidad = 0;
        System.out.println(Libreria.mostrarLibrerias());
        int libreria = 0;

        System.out.println("A que libreria desea entrar? pulsar un numero negativo para salir\n");

        do{  // Seccion para elegir libreria
            try{
                libreria = scanInt();
                System.out.println("\nModificando libreria: " + Libreria.libreriasCreadas.get(libreria-1).toStringLibreria() + "\n");
                break;
            }
            catch (Exception e) {

                if(libreria < 0){
                    System.out.println("Saliendo de administar librerias...");
                    break;
                }

                System.out.println("No existe tal libreria, porfavor ingrese un numero valido");
                continue;
            }
        }while(libreria > 0);

        if(libreria > 0){

            System.out.println("""
                                Opciones de modificacion de libreria:

                                0. Salir de librerias
                                1. Asignar libros
                                2. Ordenar libros por titulo
                                3. Ordenar libros por autor
                                4. Ordenar libros por genero
                                5. Buscar libro
                                6. Configurar libro""");

            int opciones = -1;

            while(opciones != 0){

                System.out.println("\nEliga una opcion");
                opciones = scanInt();

                switch(opciones){

                    case 0:
                        System.out.println("Saliendo de modificar libreria");
                        break;
                    
                    case 1:

                        while(cantidad < Libreria.libreriasCreadas.get(libreria-1).getCantidadDelibrosMaxima()){
                            String titulo,autor,genero,respuesta;

                            System.out.println("Ingrese titulo");
                            titulo = scan2.next();

                            System.out.println("Ingrese autor");
                            autor = scan2.next();

                            System.out.println("Ingrese genero");
                            genero = scan2.next();

                            Libreria.libreriasCreadas.get(libreria-1).AsignarLibros(titulo, autor, genero);

                            cantidad++;

                            System.out.println("Desea añadir mas libros?\n" + "Y/N"); 

                            respuesta = scan2.next();

                            while(!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N")){
                                System.out.println("Respuesta invalida ponga solo Y o N");
                                respuesta = scan2.next();
                            }

                            if(respuesta.equalsIgnoreCase("N"))
                                 break;
                        }

                        if(cantidad == Libreria.libreriasCreadas.get(libreria-1).getCantidadDelibrosMaxima()){
                            System.out.println("Se alcanzo la cantidad maxima de libros que puede tener la libreria");
                        }

                        librosAsignados = true;
                        
                        break;

                    case 2:

                        if(librosAsignados){
                            Libreria.libreriasCreadas.get(libreria-1).ordenarPorTitulo();
                            System.out.println("Los libros han sido asignados a la libreria");
                            break;
                        }
                        else
                            System.out.println("No se han asignado libros todavia");

                        break;
                        
                    case 3:

                         if(librosAsignados){
                            Libreria.libreriasCreadas.get(libreria-1).ordenarPorAutor();
                            System.out.println("Los libros han sido asignados a la libreria");
                            }
                        else
                           System.out.println("No se han asignado libros todavia");

                        break;
                        
                    case 4:

                         if(librosAsignados){
                            Libreria.libreriasCreadas.get(libreria-1).clasificarPorGenero();
                            System.out.println("Los libros han sido asignados a la libreria");
                            }
                            else
                                System.out.println("No se han asignado libros todavia");

                        break;

                    
                     case 5:
                            System.out.println("Ingrese una palabra clave");
                                String palabraClave = scan2.next();

                           System.out.println(Libreria.libreriasCreadas.get(libreria-1).buscarLibro(palabraClave));
                           break;
                        
                     case 6:

                            if(librosAsignados){
                                System.out.println(Libreria.libreriasCreadas.get(libreria-1).mostrarLibrosAsignados());
                                administarLibro(libreria-1);
                            }
                            break;

                    default:
                            System.out.println("Comando Incorrecto");
                            break;
                            
                                
                
                }
            }
             
        }
        
    }

    public static void administarLibro(int libreria){
        Scanner scan3 = new Scanner(System.in);

        System.out.println("Seleccionar libro");
        int libro = scanInt()-1;

        System.out.println("""
                            
                            ----------------------------------------
                             Opciones de libro:
                             
                             0. Salir del libro 
                             1. Modificar titulo
                             2. Modificar autor
                             3. Modificar generos
                             4. modificar libro
                             -------------------------------------- """);
        int menu = -1;

       while(menu != 0){

        System.out.println("Que desea hacer?");
        menu = scanInt();

        switch(menu){
            case 0:
                System.out.println("Saliendo del libro...");
                break;
            
            case 1:


        }



       }
    }
    
    public static void main(String[] args) {
        
        String nombre;
        int Usuario;
        boolean esAdmin = false;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Seleccione usario\n\n" + "1: Usuario administrador\n\n" + "2: Usuario invitado");
        
        Usuario = scanInt();
        
        while(Usuario >= 3 || Usuario <= 0){
            System.out.println("Valor incorrecto, eliga solo el 1 o el 2");
              
            Usuario = scanInt();
        }
        
        if(Usuario == 1){
            esAdmin = true;
            System.out.println("Ha escogido usuario Administrador");
        }
        else
            System.out.println("Ha escogido usuario invitado");
        
               String opcionesDelPrograma = """
                                            -----------------------------------------------
                                                  Bienvenido al Sistema de BookShelfs
                                            -----------------------------------------------
                                            
                                               Estas son las opciones del programa:
                                            
                                               0. Salir del Programa
                                               1. Crear nueva Libreria
                                               2. Administrar Librerias
                                               3. Ver librerias.
                                            
                                            -----------------------------------------------""";

       System.out.println(opcionesDelPrograma);

       int opcion1 = -1;

       while(opcion1 != 0){

        System.out.println("\nEliga una opcion:"); 
        opcion1 = scanInt();

        switch (opcion1) {

            case 0:  // SALIR DEL SISTEMA ready... duh
                System.out.println("Hasta pronto usuario");
                break;

            case 1: // CREAR LIBRERIA  ready 
                
                if(esAdmin){
                    System.out.println("Pongale nombre a la libreria");
                    
                    nombre = scan.next();
                    Libreria libreria = new Libreria(nombre);  // CREA
                    Libreria.libreriasCreadas.add(libreria);
                    
                    
                    System.out.println("\nCantidad limite de espacio 1" + "Para dejar de crear espacios escriba un numero negativo");
                    
                    int cantidadLimite = scanInt();
                    int i = 1;
                    
                    while(cantidadLimite > 0){
                        i++;
                        libreria.crearEspacioDeLibreria(cantidadLimite);
                        System.out.println("Cantidad limite de espacio " + i);              // BLOQUE ENCARGADO DE AGREGAR ESPACIOS DE LIBRERIA
                        cantidadLimite = scanInt();
                    }
                    System.out.println("Se han dejado de crear espacios"); 
                        
                }
                else
                    System.out.println("No se puede acceder a esta opcion");
                    break;
                     
            case 2: // ADMINISTRAR LIBRERIAS
                
                if(esAdmin) // Solo los administrador pueden entrar a esta opcion, uso otra vez de el try catch para ArrayIndexOutofBounds
                    administrarLibreria();
                else
                    System.out.println("No se puede acceder a esta opcion");
                break;

            case 3: // Ver librerias. ready
                System.out.println("\n"+Libreria.mostrarLibrerias());
                System.out.println("\nSeleccion la libreria que quiere ver, digite un numero negativo para salir");

                    // Try catch para que no salga EL INNOMBRABLE arrayIndexOutOfBounds al escoger un numero de una libreria que no existe.
                    int opcion3 = scanInt();

                    while(opcion3 > 0){
                        opcion3 = scanInt();
                        try{
                            System.out.println(Libreria.libreriasCreadas.get(opcion3-1).mostrarLibreria());
                        }
                        catch(Exception e){

                            if(opcion3 < 0){
                                System.out.println("Saliendo de Ver librerias...");
                                break;
                            }

                            System.out.println("No existe tal libreria, porfavor ingrese un numero valido");
                            continue;
                        }
                   }
                break;
                
            default:
                System.out.println("Comando incorrecto");
                break;

        }


       }

   } 

}

            
        
        
        
        
        
      
 
    
    

