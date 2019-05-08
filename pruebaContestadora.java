/*
 */
package examen;

/**
 *
 * @author alex
 */

/*import java.util.Scanner;

public class pruebaContestadora {
    
    public static void main(String [] args){
        
        Scanner userData = new Scanner(System.in);
        Contestadora app = new Contestadora();
        int respuesta;
        
        //variables de opciones:
        
        int indice, capacidad;
        String mensaje;
        boolean estado;
        
        System.out.println("Bienvenido a la aplicación contestadora \npuede realizar alguna de las siguientes acciones: \n");
        
        String opciones =
                "\n Opciones de la contestadora \n" + 
                "\n   1. Añadir un mensaje \n" + 
                "   2. Borrar un mensaje \n" + 
                "   3. Leer un mensaje en particular \n" + 
                "   4. Mostrar capacidad de almacenamiento de la contestadora \n" +
                "   5. Especificar capacidad de almacenamiento \n" + 
                "   6. Obtener el número de mensajes totales\n" + 
                "   7. Obtener la cantidad de mensajes no escuchados \n" + 
                "   8. Esta llena la contestadora? \n" +
                "   9. Vaciar contestadora \n" + 
                "   10.Leer todos los mensajes no leeidos \n" +
                "   11.Finalizar \n\n" + 
                "       Respuesta: [número] ";
        
        do{
            
            System.out.print(opciones);
            respuesta = Integer.parseInt(userData.nextLine());
            
            switch(respuesta){
                case 1:
                    System.out.print("Introduce tu mensaje: ");
                    mensaje = userData.nextLine();
                    app.agregarMensaje(mensaje);
                    break;
                case 2:
                    System.out.print("Introduce el indice del mensaje que quieres borrar: ");
                    indice = Integer.parseInt(userData.nextLine());
                    app.borrarMensaje(indice);
                    break;
                case 3:
                    System.out.print("Introduce el indice del mensaje que quieres leer: ");
                    indice = Integer.parseInt(userData.nextLine());
                    app.leerMensaje(indice);
                    break;
                case 4: 
                    System.out.println("La contestadora puede almacenar " + app.capacidad() + " mensajes");
                    break;
                case 5:
                    System.out.print("Introduce la capacidad máxima que tendra la contestadora: ");
                    capacidad = Integer.parseInt(userData.nextLine());
                    app = new Contestadora(capacidad);
                    System.out.println("La capacidad de la contestadora ahora es de: " + app.capacidad() + " mensajes");
                    break;
                case 6:
                    System.out.println("Usted cuenta con un total de " +  app.getNumMensajes() + " mensajes");
                    break;
                case 7:
                    System.out.println("Usted cuenta con un total de " +  app.msjNoEscuchados() + " mensajes no escuchados");
                    break;
                case 8:
                    estado = app.estaLlena();
                    mensaje = estado ? "La contestadora esta llena" : "La contestadora no esta llena";
                    System.out.println(mensaje);
                    break;
                case 9:
                    app.limpiar();
                    break;
                case 10:
                    app.leerTodos();
                    break;
                case 11:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
            
        }while(respuesta != 11);
    }
}*/

import java.util.Scanner;

public class pruebaContestadora{

  public static void menu(){
  
     String opciones =
                "\n Opciones de la contestadora \n" + 
                "\n   1. Agregar un nuevo mensaje \n" + 
                "   2. Cantidad de mensajes recibidos \n" + 
                "   3. Borrar un mensajes \n" + 
                "   4. Borrar todos los mensajes \n" +
                "   5. Número de mensajes no-escuchados \n" + 
                "   6. Determinar si la contestadora tiene espacio\n" + 
                "   7. Leer mensaje \n" + 
                "   8. Todos los mensajes no escuchados \n" +
                "   9. Salir \n\n" + 
                "       Escribe una opcion: ";
                
    System.out.print(opciones);
    
  }
  
   public static void main(String [] args){
   
     Contestadora c = new Contestadora();
     Scanner lector = new Scanner(System.in);
     
     int opcion, indice;
     String mensaje;
     boolean estado;
     
    do{
    
      menu(); //Se invoca la impresión del menú
      
      opcion = Integer.parseInt(lector.nextLine());
      
      switch(opcion){
        case 1: //Agregar mensaje
          System.out.print("Escriba su mensaje: ");
          mensaje = lector.nextLine();
          c.agregarMensaje(mensaje);
          break;
        case 2: //Conocer los mensajes recibidos
          System.out.println("Teines " + c.getNumMensajes() + " mensajes");
          break;
        case 3://Borrar mensaje
          System.out.print("Introduce el indice: ");
          indice = Integer.parseInt(lector.nextLine());
          c.borrarMensaje(indice);
          break;
        case 4: //Borrar todos los mensajes
          c.borrarTodosLosMensajes();
          break;
        case 5: //Número de mensajes no-escuchados
          System.out.println("Hay un total de " + c.msjNoEscuchados() + " mensajes no escuchados");
          break;
        case 6: //Saber si la contestadora tiene espacio
          estado = c.hayEspacio();
          mensaje = estado ? "La contestadora esta llena" : "La contestadora no esta llena";
          System.out.println(mensaje);
          break;
        case 7: //Leer mensaje
          System.out.print("Introduce el número de mensaje que deseas leer: ");
          indice = Integer.parseInt(lector.nextLine());
          System.out.println(c.leerMensaje(indice));
          break;
        case 8: //Todos los mensajes no escuchados
          c.mostrarMensajes();
          break;
        case 9: //Salir
          System.out.println("Fin");
          break;
        default:
          System.out.println("La opción elegida no es válida\n");
      }//Fin switch
      
    }while(opcion != 9);
    //Fin main
    }
}