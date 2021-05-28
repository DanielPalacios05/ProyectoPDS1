
package package1;

import java.util.Scanner;


public class Principal {

   private static boolean librosAsignados = false;
    private static boolean librosPuestos = false;

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
        Scanner scan2 = new Scanner(System.in);
        int cantidad = 0;
        System.out.println("\n" + Libreria.mostrarLibrerias() + "\n");
        int libreria = 0;

        System.out.print("A que libreria desea entrar? pulsar 0 para salir: ");

        do{  // Seccion para elegir libreria
            try{
                libreria = scanInt();
                System.out.println("\nModificando libreria: " + Libreria.libreriasCreadas.get(libreria-1).toStringLibreria() + "\n");
                break;
            }
            catch (Exception e){

                if(libreria == 0){
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

                                0. Salir de librerias.
                                1. Ver libros Asignados
                                2. Asignar libros.
                                3. Ordenar libros por titulo.
                                4. Ordenar libros por autor.
                                5. Ordenar libros por genero.
                                6. Buscar libro.
                                7. Configurar libro.
                                8. Borrar libreria.""");

            int opciones = -1;

            while(opciones != 0){


                System.out.print("\nEliga una opcion de modificacion de libreria: ");
                opciones = scanInt();

                switch(opciones){

                    case 0:
                        System.out.println("Saliendo de modificar libreria");
                        break;
                    
                    case 1:
                        System.out.println(Libreria.libreriasCreadas.get(libreria-1).mostrarLibrosAsignados());
                        break;
                    
                    case 2:

                        while(cantidad < Libreria.libreriasCreadas.get(libreria-1).getCantidadDelibrosMaxima()){
                            String titulo,autor,genero,respuesta;

                            System.out.println("Cantidad de libros restante: " + (Libreria.libreriasCreadas.get(libreria-1).getCantidadDelibrosMaxima() - cantidad) + "\n");

                            System.out.println("Ingrese titulo: ");
                            titulo = scan2.nextLine();

                            System.out.println("Ingrese autor: ");
                            autor = scan2.nextLine();

                            System.out.println("Ingrese genero: ");
                            genero = scan2.nextLine();

                            if(titulo == "" || autor == "" || genero == ""){
                                System.out.println("Datos de libro invalidos, porfavor ingreselos nuevamente");
                                continue;
                            }

                            Libreria.libreriasCreadas.get(libreria-1).AsignarLibros(titulo, autor, genero);

                            cantidad++;

                            System.out.println("Desea añadir mas libros?\n" + "Y/N"); 

                            respuesta = scan2.nextLine();

                            while(!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N")){
                                System.out.println("Respuesta invalida ponga solo Y o N");
                                respuesta = scan2.nextLine();
                                scan2.close();
                            }

                            if(respuesta.equalsIgnoreCase("N"))
                                break;
                        }

                        if(cantidad == Libreria.libreriasCreadas.get(libreria-1).getCantidadDelibrosMaxima()){
                            System.out.println("Se alcanzo la cantidad maxima de libros que puede tener la libreria");
                        }

                        librosAsignados = true;
                        
                        break;

                    case 3:

                        if(librosAsignados){
                            Libreria.libreriasCreadas.get(libreria-1).ordenarPorTitulo();
                            System.out.println("Los libros han sido asignados a la libreria");
                            librosPuestos = true;
                            break;
                        }
                        else
                            System.out.println("No se han asignado libros todavia");

                        break;
                        
                    case 4:

                         if(librosAsignados){
                            Libreria.libreriasCreadas.get(libreria-1).ordenarPorAutor();
                            System.out.println("Los libros han sido asignados a la libreria");
                            librosPuestos = true;
                            }
                        else
                           System.out.println("No se han asignado libros todavia");

                        break;
                        
                    case 5:

                         if(librosAsignados){
                            Libreria.libreriasCreadas.get(libreria-1).clasificarPorGenero();
                            System.out.println("Los libros han sido asignados a la libreria");
                            librosPuestos = true;
                            }
                            else
                                System.out.println("No se han asignado libros todavia");

                        break;

                    
                     case 6:
                            if(!librosPuestos){
                                System.out.println("No se han asignado libros todavia");
                                break;
                            }
                            
                            System.out.println("Ingrese una palabra clave");
                                String palabraClave = scan2.next();

                           System.out.println(Libreria.libreriasCreadas.get(libreria-1).buscarLibro(palabraClave));
                           break;
                        
                     case 7:
                            if(librosAsignados){
                                System.out.println(Libreria.libreriasCreadas.get(libreria-1).mostrarLibrosAsignados());
                                administarLibro(libreria-1);
                            }
                            break;

                    case 8:
                            Libreria.borrarLibreria(libreria-1);
                            System.out.println("Se ha borrado la libreria exitosamente");
                            opciones = 0;
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
                             3. Modificar genero
                             4. Borrar libro
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
                System.out.println("Ingrese el titulo");
                String titulo = scan3.nextLine();

                Libreria.libreriasCreadas.get(libreria).ModificarTitulo(libro, titulo);
                System.out.println("Titulo modificado");
                break;

            case 2:
                System.out.println("Ingrese el autor");
                String autor = scan3.nextLine();

                Libreria.libreriasCreadas.get(libreria).ModificarAutor(libro, autor);
                System.out.println("Autor modificado");
                break;

            case 3:
                System.out.println("Ingrese el genero");
                String genero = scan3.nextLine();

                Libreria.libreriasCreadas.get(libreria).ModificarGenero(libro, genero);
                System.out.println("Genero modificado");
                break;

            case 4:
                Libreria.libreriasCreadas.get(libreria).borrarLibro(libro);
                System.out.println("Libro borrado exitosamente");
                menu = 0;
                break;
                
            default:
                System.out.println("Comando incorrecto, ingrese un numero valido");
                break;
             }

       }
    }
    
    public static void main(String[] args) {
        
        String nombre;
        int Usuario;
        boolean esAdmin = false;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("1: Usuario administrador\n\n" + "2: Usuario invitado\n\n" + "Seleccione usuario: " );
        
        Usuario = scanInt();
        while(Usuario >= 3 || Usuario <= 0){
            System.out.println("Valor incorrecto, eliga solo el 1 o el 2");
              
            Usuario = scanInt();
        }
        
        if(Usuario == 1){
            esAdmin = true;
            System.out.println("\nHa escogido usuario administrador\n");
        }
        else
            System.out.println("\nHa escogido usuario invitado\n");
        
               System.out.println("""
                                            -----------------------------------------------
                                                  Bienvenido al Sistema de BookShelfs
                                            -----------------------------------------------
                                            
                                               Estas son las opciones del programa:
                                            
                                               0. Salir del Programa
                                               1. Crear nueva Libreria
                                               2. Administrar Librerias
                                               3. Ver librerias.
                                            
                                            -----------------------------------------------""");

      

       int opcion1 = -1;

       while(opcion1 != 0){

        System.out.print("\nEliga una opcion: "); 
        opcion1 = scanInt();

        switch (opcion1) {

            case 0:  // SALIR DEL SISTEMA ready... duh
                System.out.println("\n\nHasta pronto usuario");
                break;

            case 1: // CREAR LIBRERIA  ready 
                
                if(esAdmin){
                    System.out.print("\nPongale nombre a la libreria: ");
                    
                    nombre = scan.nextLine();
                    Libreria libreria = new Libreria(nombre);  // CREA
                    Libreria.libreriasCreadas.add(libreria);
                    
                    
                    System.out.print("\nPara dejar de crear espacios escriba un numero negativo" + "\n\nCantidad limite de espacio 1: ");
                    
                    int cantidadLimite = scanInt();
                    int i = 1;
                    
                    while(cantidadLimite > 0){
                        i++;
                        libreria.crearEspacioDeLibreria(cantidadLimite);
                        System.out.print("Cantidad limite de espacio " + i + ": ");              // BLOQUE ENCARGADO DE AGREGAR ESPACIOS DE LIBRERIA
                        cantidadLimite = scanInt();
                    }
                    System.out.println("\n\nSe han dejado de crear espacios\n"); 
                        
                }
                else
                    System.out.println("\n\nNo se puede acceder a esta opcion");
                    break;
                     
            case 2: // ADMINISTRAR LIBRERIAS
                
                if(esAdmin && !Libreria.libreriasCreadas.isEmpty()) // Solo los administrador pueden entrar a esta opcion, uso otra vez de el try catch para ArrayIndexOutofBounds
                    administrarLibreria();
                else if(Libreria.libreriasCreadas.isEmpty() && esAdmin)
                    System.out.println("\nNo existen librerias por administrar. porfavor cree primero algunas");
                else
                    System.out.println("\nNo se puede acceder a esta opcion");

                break;

            case 3:
                
                if(!Libreria.libreriasCreadas.isEmpty()){// Ver librerias. ready
                    // Try catch para que no salga EL INNOMBRABLE al escoger un numero de una libreria que no existe.
                    int opcion3 = -1;

                    while(opcion3 != 0){
                        System.out.println("\n"+Libreria.mostrarLibrerias());
                        System.out.print("\nSeleccion la libreria que quiere ver, digite 0 para salir: ");

                        opcion3 = scanInt();
                        try{
                            System.out.println("\n" + Libreria.libreriasCreadas.get(opcion3-1).mostrarLibreria());
                        }
                        catch(Exception e){                 
                            if(opcion3 == 0){
                                System.out.println("Saliendo de Ver librerias..."); 
                                break;
                            }
                            System.out.println("No existe tal libreria, porfavor ingrese un numero valido");
                            continue;
                        }
                   }
                }
                else
                    System.out.println("\nNo existen librerias para ver");
                break;
                
            default:
                System.out.println("Comando incorrecto");
                break;

        }


       }

   } 

}

            
        
        
        
        
        
      
 
    
    

