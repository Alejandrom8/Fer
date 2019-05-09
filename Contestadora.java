import java.util.Calendar;

public class Contestadora{
  
  private final int cantidad;//capacidad de almacenamiento
  private final Mensaje mensajes[]; // contenedor de mensajes
  private int length = 0;

  //Constructor por omisión 
  public Contestadora(){
    this.cantidad = 10 ;
    this.mensajes = new Mensaje [cantidad];
  }
  
  //Constructor que recibe la cantidad máxima de mensajes permitidos 
  public Contestadora(int c){
    this.cantidad = c ;
    this.mensajes = new Mensaje [cantidad];
  }
  
  //Método para conocer el número de mensajes que han ingresado
  public int getNumMensajes(){
      return this.length;
  }
  
  //Método para conocer la capacidad máxima 
  public int getCantidad(){
    return this.cantidad;
  }
  
  //Método para agregar un nuevo mensaje
  public boolean agregarMensaje(String mensaje){
    
    /*
    *   @access public
    *   @param String mensaje, texto que se añadira;
    *   @return true, si el mensaje se añade correctamente, false si:
             -no hay más espacio en la contestadora
             -no se añadio correctamente el mensaje
    */  
    
    String mensajeStatus;
    Response res = new Response();
    
    if(this.hayEspacio()){
        
      int hora, minutos, segundos;  
      String format;
      Calendar calendario = Calendar.getInstance();
      Mensaje nuevoMensaje = new Mensaje(mensaje);
      
      hora      =  calendario.get(Calendar.HOUR_OF_DAY);
      minutos   = calendario.get(Calendar.MINUTE);
      segundos =  calendario.get(Calendar.SECOND);
      format    = hora + ":" + minutos + ":" + segundos;
      
      nuevoMensaje.hora = format;
 
      this.mensajes[length] = nuevoMensaje;
      
      if(this.mensajes[length] != null){
          this.length++;
          res.estado = true;
          mensajeStatus = "Se añadió un nuevo mensaje a las " + format;
      }else{
          mensajeStatus = "No se logro añadir el mensaje";
      }
      
    }else{
        mensajeStatus = "No hay más espacio en la contestadora";
    }
    
    res.mensajeStatus = mensajeStatus;
    res.printMensaje();
    this.printEstadoEspacio();
    
    return res.estado;
  }
  
    //Método para borrar un mensaje en particular
  public boolean borrarMensaje( int index ){
      
      /*
      * @access public
      * @param Int index, indice del mensaje que se borrara;
      * @return boolean true, si el mensaje fue borrado correctamente
      */
      
      String mensajeStatus;
      Response res = new Response();
      
      if(this.length > 0){

        if (index >= 0 && index < this.length){
          if(this.removeIndex(this.mensajes, index)){

              mensajeStatus = "Se borró el mensaje correctamente";
              if(this.length > 0){ this.length--; }
              res.estado = true;

          }else{
              mensajeStatus = "No se borró el mensaje correctamente";
          }   
        }else{
            mensajeStatus = "El indice esta fuera de rango";
        }
      }else{
          mensajeStatus = "No hay mensajes por borrar";
      }
      
      res.mensajeStatus = mensajeStatus;
      res.printMensaje();
      this.printEstadoEspacio();
      
      return res.estado;
  }
  
  //Método para borrar todos los mensajes
  public boolean borrarTodosLosMensajes(){
    
    Response res = new Response();
    String mensajeStatus;
    int errorCont = 0;
    
    if(this.length > 0){
        int menos = 0;
        
        for (int i = 0; i < this.length ; i++){
          if(this.removeIndex(this.mensajes, i)){
              menos++;
          }else{
              res.errores[i] = "mensaje " + i + " no borrado";
              errorCont++;
          }
        }
        
        if(errorCont == 0){
            this.length -= menos;
            res.estado = true;
            mensajeStatus = "se borro un total de " + menos + " mensajes";
        }else{
            res.printErrores();
            mensajeStatus = "No se lograron borrar todos los mensajes";
        }
        
    }else{
        mensajeStatus = "No hay mensajes para borrar";
    }
    
    res.mensajeStatus = mensajeStatus;
    res.printMensaje();
    
    return res.estado;
  }
  
  private boolean removeIndex( Mensaje [] array, int index){
      
    int i = index;
    
    for (; i < array.length-1; i++){
      array[i] = array[i+1];
    }
    
    array[i] = null;
    
    return true;
    
  }
  
  //Método para determinar la cantidad de mensajes "no-escuchados"
  public int msjNoEscuchados(){
    int noEscuchados = 0; 
    boolean estadoMensaje;
    
    if(this.length > 0){
      for (int i = 0; i < this.length; i++){
        estadoMensaje = this.mensajes[i].escuchado;
        if(!estadoMensaje){  
          noEscuchados++;
        }
      }
    }

    return noEscuchados;
  }
  
  //Método para determinar si la contestadora está llena
  public boolean hayEspacio(){
    /*
    *   @return true si hay espacio
    */
    boolean estado = this.length < this.cantidad;    
    return estado;
  }
  
  public void printEstadoEspacio(){
      
    String mensaje;
    boolean estado = this.hayEspacio();
    
    if(this.length == this.cantidad -1){
        mensaje = "La contestadora esta apunto de llenarse";
    }else{
        int espacio = this.cantidad - this.length;
        mensaje = estado ? "Queda un espacio total de " + espacio + " mensajes" : "La contestadora esta llena";
    }
    System.out.println(mensaje);
  }
  
  //Método para leer un mensaje en particular
  public boolean leerMensaje(int index){
    
    String mensajeStatus;
    Response res = new Response();
    
    if(index >= 0 && index < this.length){
        
      if(mensajes[index].getContenido() != null){
        mensajeStatus = "Mensaje " + index + ": " + mensajes[index].getContenido() +  "    - recibido a las " + this.mensajes[index].hora + " -";
        this.mensajes[index].setEscuchado(true);
      }else{
        mensajeStatus = "No hay mensaje para mostrar";
      }
      
    }else{
      mensajeStatus = "No existe el indice " + index + " en la contestadora";
    }
    
    res.mensajeStatus = mensajeStatus;
    res.printMensaje();
    
    return res.estado;
  }
  
  public void printMenuMensajes(){
      String menu = "\n    MENSAJES\n| id |   hora   |\n";
      for(int i = 0; i < this.length; i++){
          menu += "| " + i + "  | " + this.mensajes[i].hora + " | \n";
      }
      System.out.println(menu);
  }
  
  //Método que imprime en pantalla todos los mensajes de la contestadora que no hayan sido 
  //escuchados
  public void mostrarMensajes(){
    
    boolean estadoMensaje;
    int escuchados = 0;
    
      for (int i = 0 ;  i < this.length; i++){
        
        estadoMensaje = this.mensajes[i].escuchado;
        
        if(!estadoMensaje){
          System.out.println("Mensaje " + i + ": " + mensajes[i].getContenido() +  "    - recibido a las " + this.mensajes[i].hora + " -");
          this.mensajes[i].setEscuchado(true);
        }else {
          escuchados++;
        }
      }
      
      if(escuchados == this.length){
        System.out.println("Todos los mensajes fueron escuchados");
      }
  }
 
}