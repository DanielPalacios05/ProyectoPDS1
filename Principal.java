
package package1;

import java.util.Scanner;

public class Principal {
    
    
    public static void administrarLibreria(int libreria){
        
        
        
        
        
    }
    
    public static void main(String[] args) {
        String nombre;
        short Usuario;
        boolean esAdmin = false;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Seleccione usario\n\n" + "1: Usuario administrador\n\n" + "2: Usuario invitado");
        
        Usuario = scan.nextShort();
        
        while(Usuario >= 3 || Usuario <= 0){
            System.out.println("Valor incorrecto, eliga solo el 1 o el 2");
              
            Usuario = scan.nextShort();
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
                                               2. Administrar Libreria
                                            
                                            -----------------------------------------------""";

       System.out.println(opcionesDelPrograma);

       int opcion1 = scan.nextInt();

       while(opcion1 != 0){

        switch (opcion1) {

            case 0:  // SALIR DEL SISTEMA
                System.out.println("Hasta pronto usuario");
                break;

            case 1: // CREAR LIBRERIA 
                
                if(esAdmin){
                    System.out.println("Pongale nombre a la libreria");
                    
                    nombre = scan.next();
                    Libreria libreria = new Libreria(nombre);  // CREA
                    Libreria.libreriasCreadas.add(libreria);
                    
                    
                    System.out.println("\nCantidad limite de espacio 1" + "Para dejar de crear espacios escriba un numero negativo");
                    
                    int cantidadLimite = scan.nextInt();
                    int i = 1;
                    
                    while(cantidadLimite > 0){
                        i++;
                        libreria.crearEspacioDeLibreria(cantidadLimite);
                        System.out.println("Cantidad limite de espacio " + i);              // BLOQUE ENCARGADO DE AGREGAR ESPACIOS DE LIBRERIA
                        cantidadLimite = scan.nextInt();
                    }
                    System.out.println("Se han dejado de crear espacios"); 
                        
                }
                else
                    System.out.println("No se puede acceder a esta opcion");
                    break;
                     
            case 2: // ADMINISTRAR LIBRERIAS
                System.out.println(Libreria.mostrarLibrerias());
                
                break;

            default:
                System.out.println("Comando incorrecto");
                break;

        }

        System.out.println("Eliga una opcion:"); 
        opcion1=scan.nextInt();

       }

   } 

}

            
        
        
        
        
        
      
 
    
    

