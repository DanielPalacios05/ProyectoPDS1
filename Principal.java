
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

            int opciones = scanInt();

            while(opciones != 0){

                switch(opciones){

                    case 0:
                        System.out.println("Saliendo de modificar libreria");
                        break;
                    
                    case 1:
                                        
                }
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

       int opcion1 = scanInt();

       while(opcion1 != 0){

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

            System.out.println("\nEliga una opcion:"); 
            opcion1 = scanInt();

       }

   } 

}

            
        
        
        
        
        
      
 
    
    

