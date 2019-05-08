public class Mensaje{
    private String contenido;
    public boolean escuchado;

    public Mensaje(String cont){
        contenido = cont;
        escuchado = false;
    }
    public void setEscuchado(boolean estado){
        this.escuchado = estado;
    }
    public String getContenido(){
        return contenido;
    }
    public void setContenido(String cont){
        contenido = cont;
    }
    public String toString(){
        return "Tu mensaje es: " + contenido;
    }
}
