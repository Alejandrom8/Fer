import java.util.Scanner;

public class PruebaContestadora{
  
   public static void main(String [] args){
   
     Contestadora c = new Contestadora();
     Scanner lector = new Scanner(System.in);
     
     int opcion, indice, capacidad;
     String mensaje;
     boolean estado;
     
     do{ 

        menu(); //Se invoca la impresión del menú

        opcion = Integer.parseInt(lector.nextLine());

        switch(opcion){
          case 1:
            System.out.print("Introduce la capacidad máxima que tendra la contestadora: ");
            capacidad = Integer.parseInt(lector.nextLine());
            c = new Contestadora(capacidad);
            System.out.println("La capacidad de la contestadora ahora es de: " + c.getCantidad() + " mensajes");
            break;
          case 2: //Agregar mensaje
            System.out.print("Escriba su mensaje: ");
            mensaje = lector.nextLine();
            c.agregarMensaje(mensaje);
            break;
          case 3: //Conocer los mensajes recibidos
            System.out.println("Teines " + c.getNumMensajes() + " mensajes");
            break;
          case 4://Borrar mensaje
            System.out.print("Introduce el indice: ");
            indice = Integer.parseInt(lector.nextLine());
            c.borrarMensaje(indice);
            break;
          case 5: //Borrar todos los mensajes
            c.borrarTodosLosMensajes();
            break;
          case 6: //Número de mensajes no-escuchados
            System.out.println("Hay un total de " + c.msjNoEscuchados() + " mensajes no escuchados");
            break;
          case 7: //Saber si la contestadora tiene espacio
            estado = c.hayEspacio();
            mensaje = estado ? "La contestadora esta llena" : "La contestadora no esta llena";
            System.out.println(mensaje);
            break;
          case 8: //Leer mensaje
            System.out.print("Introduce el número de mensaje que deseas leer: ");
            indice = Integer.parseInt(lector.nextLine());
            System.out.println(c.leerMensaje(indice));
            break;
          case 9: //Todos los mensajes no escuchados
            c.mostrarMensajes();
            break;
          case 10: //Salir
            System.out.println("Fin");
            break;
          default:
            System.out.println("La opción elegida no es válida\n");
            break;
        }//Fin switch
      }while(opcion != 10);
      //Fin main
  	}
  
    public static void menu(){

       String opciones =
                  "\n Opciones de la contestadora \n" + 
                  "\n   1. Especificar capacidad de almacenamiento \n" + 
                  "   2. Agregar un nuevo mensaje \n" + 
                  "   3. Cantidad de mensajes recibidos \n" + 
                  "   4. Borrar un mensajes \n" + 
                  "   5. Borrar todos los mensajes \n" +
                  "   6. Número de mensajes no-escuchados \n" + 
                  "   7. Determinar si la contestadora tiene espacio\n" + 
                  "   8. Leer mensaje \n" + 
                  "   9. Todos los mensajes no escuchados \n" +
                  "   10. Salir \n\n" + 
                  "       Escribe una opcion: ";

      System.out.print(opciones);

    }
}