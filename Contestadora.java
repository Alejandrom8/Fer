public class Contestadora{
  
  private final int cantidad;				//capacidad de almacenamiento
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
  
  //Método para borrar un mensaje en particular
  public boolean borrarMensaje(int indice){
    
      if (indice >= 0 && indice < this.length){
        this.removeIndex(this.mensajes, indice);
        System.out.println("Se borró el mensaje correctamente");
        if(this.length > 0){ this.length--; }
        return true;
      }
    
      System.out.println("No se borró el mensaje correctamente");
      return false;
  }
  
  //Método para borrar todos los mensajes
  public boolean borrarTodosLosMensajes(){
    int menos = 0;
    
    for (int i = 0; i < this.length ; i++){
      this.removeIndex(this.mensajes, i);
      menos++;
    }
    
    this.length -= menos;
    
    System.out.println("Se han borrado todos los mensajes");
    return true;
  }
  
  private void removeIndex( Mensaje [] array, int index){
    int i = index;
    for (; i < array.length-1; i++){
      array[i] = array[i+1];
    }
    array[i]=null;
  }
 
  //Método para agregar un nuevo mensaje
  public boolean agregarMensaje(String mensaje){
    if(length < cantidad){
      Mensaje nuevoMensaje = new Mensaje(mensaje);
      this.mensajes[length] = nuevoMensaje;
      this.length++;
      
      System.out.println("Se añadió un nuevo mensaje.");
      return true;
    }
    System.out.println("No hay mas espacio en la contestadora");
    return false;
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
    return this.length != this.cantidad;
  }
  
  //Método para leer un mensaje en particular
  public String leerMensaje(int index){
    
    String respuesta;
    
    if(index >= 0 && index < this.length){
      
      if(mensajes[index].getContenido() != null){
        respuesta = mensajes[index].getContenido();
      }else{
        respuesta = "No hay mensaje";
      }
      
    }else{
      respuesta = "No existe el indice del mensaje";
    }
    
    return respuesta;
  }
  
  //Método que imprime en pantalla todos los mensajes de la contestadora que no hayan sido 
  //escuchados
  public void mostrarMensajes(){
    
    boolean estadoMensaje;
    int escuchados = 0;
    
      for (int i = 0 ;  i < this.length; i++){
        
        estadoMensaje = this.mensajes[i].escuchado;
        
        if(!estadoMensaje){
          System.out.println(this.mensajes[i].getContenido());
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