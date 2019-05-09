public class Response {
    
    public boolean estado;
    public String mensajeStatus;
    public int ModIndex;
    public String errores[];
    
    public Response(){
        this.estado = false;
        this.mensajeStatus = "";
        this.ModIndex = 0;
    }
    
    public void printMensaje(){
        System.out.println("\n" + this.mensajeStatus + "\n");
    }
    
    public void printErrores(){
        for(int i = 0; i < this.errores.length; i++){
            System.out.println("Error " + i  + " : " + this.errores[i]);
        }
    }
    
}
