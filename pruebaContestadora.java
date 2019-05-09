import java.util.Scanner;

public class PruebaContestadora{

   public static int lengthOpciones;
   
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
            mensaje = "Teines " + c.getNumMensajes() + " mensaje";
            if(c.getNumMensajes() == 1){ mensaje += "s"; }
            System.out.println(mensaje);
            break;
          case 4://Borrar mensaje
            c.printMenuMensajes();
            System.out.print("Introduce el indice: ");
            indice = Integer.parseInt(lector.nextLine());
            c.borrarMensaje(indice);
            break;
          case 5: //Borrar todos los mensajes
            c.borrarTodosLosMensajes();
            break;
          case 6: //Número de mensajes no-escuchados
            mensaje = "Hay un total de " + c.msjNoEscuchados();
            mensaje += c.msjNoEscuchados() == 1 ? " mensajes no escuchados" : " mensaje no escuchado";
            System.out.println(mensaje);
            break;
          case 7: //Saber si la contestadora tiene espacio
            c.printEstadoEspacio();
            break;
          case 8: //Leer mensaje
            c.printMenuMensajes();
            System.out.print("Introduce el número de mensaje que deseas leer: ");
            indice = Integer.parseInt(lector.nextLine());
            c.leerMensaje(indice);
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
        
        if(opcion != lengthOpciones){
            pressToContinue();
        }
       
      }while(opcion != lengthOpciones);
      //Fin main
 }
  
    public static void menu(){

       String opciones[] = {
           "Especificar capacidad de almacenamiento",
           "Agregar un nuevo mensaje",
           "Cantidad de mensajes recibidos",
           "Borrar un mensaje",
           "Borrar todos los mensajes",
           "Cantidad de mensajes no escuchados",
           "Determinar si la contestadora tiene espacio",
           "Leer mensaje",
           "Leer todos los mensajes no escuchados"
       };
       
       lengthOpciones = opciones.length + 1;
       
       String print = "\n Menú \n\n";
       
       for(int i = 1; i <= opciones.length; i++){
           print += "   " + i + ". " + opciones[i-1] + " \n";
       }
       
       print += "   " + (opciones.length + 1) + ". Salir \n\n";
       print += "Escriba una opcion: ";

      System.out.print(print);

    }
    
    private static void pressToContinue(){ 
        System.out.print("\n    Oprime ENTER para continuar...  ");
        try{
            System.in.read();
        }catch(Exception e){
        
        }  
    }
}