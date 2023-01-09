/*
 * Clase del paquete Logia que se encarga de establecer la comunicación
 * entre la capa de Presentacion y Datos.
 * Contiene el objeto mensaje.
 */
package Logica;

/**
 * @author yosebeth
 * @author Stephanie
 * @author Ronaldo
 * @author Maikel
 */

public class Mensajes {

    /**
     * Creamos los parámetros con los que se trabajaran. 
     */
    public String msg_De;
    public String msg_Para;
    public String leido;
    public String mensaje;

    /**
     * Creamos el método constructor vacído 
     */
    public Mensajes() {
    }

    /**
     * Creamos el método constructor con los parámetros.
     */
    public Mensajes(String msg_De, String msg_Para, String leido, String mensaje) {
        this.msg_De = msg_De;
        this.msg_Para = msg_Para;
        this.leido = leido;
        this.mensaje = mensaje;
    }

    /**
     * Creamos los métoos get y set de todos los parámatros.  
     */
    public String getMsg_De() {
        return msg_De;
    }

    public void setMsg_De(String msg_De) {
        this.msg_De = msg_De;
    }

    public String getMsg_Para() {
        return msg_Para;
    }

    public void setMsg_Para(String msg_Para) {
        this.msg_Para = msg_Para;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
