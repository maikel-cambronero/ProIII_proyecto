/*
 * Clase del paquete Datos que se encarga de establecer la conexión y 
 * las consultas en sus respectivos métodos que se le 
 * realizan a la Base de datos.
 */
package Datos;

import Logica.Mensajes;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 * @author yosebeth
 * @author Stephanie
 * @author Ronaldo
 * @author Maikel
 */
public class Conexion extends Thread {

    /**
     * Párametro encargado de la conexion, Lleva el control de acceso a la base
     * de datos.
     */
    public Connection conexion;
    /**
     * Este párametro obtiene la sentencia que lleva el control a las
     * instrucciones a ejecutar.
     */
    public Statement sentencia;
    /**
     * El páramtro instrucciónSQL permite introducir o cambiar los parametros en
     * una instrucción SQL.
     */
    public PreparedStatement instrucciónSQL;
    /**
     * ConexionOK Variable indíca si la conexion con la base de datos fue
     * exitosa.
     */
    public boolean ConexionOK = true;
    /**
     * Parametros que permiten conoecer la información entrante.
     */
    public String mensajePara;
    public String mensajeDe;
    public String mensaje;
    public int ID;
    public String leido;

    /**
     * Se crea el método Get de la Sentencia para obtener la instruccion SQL
     *
     * @return devuelve la instrucción SQL.
     */
    public Statement getSentencia() {
        return sentencia;
    }

    /**
     * Se crea el método Set de la Sentencia para enviar la instruccion SQL
     *
     * @param sentencia párametro de entrada para que el código conozca la
     * instrucción.
     */
    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }

    // Se crea una instancia de la clase mensajes con el objeto de nombre "mensajes"
    Mensajes mensajes = new Mensajes();

    /**
     * Método que establece la conexión a la Base de Datos. Indica la ubicación
     * de la Base de Datos.
     * Si no logra establecer la conexión muestra un mensaje de error.
     */
    public Conexion() {
        String urlConect = "jdbc:ucanaccess://G:\\Mi unidad\\ChatProgra3_Grupo7.accdb";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException err) {
            JOptionPane.showMessageDialog(null, "Error al cargar el controlador" + err.getMessage() + " Causa" + err.getCause());
            ConexionOK = false;
        }

        try {
            if (this.ConexionOK) {
                this.conexion = DriverManager.getConnection(urlConect);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error en la localización de la base de datos" + " Mensaje: " + err.getMessage() + " Causa: " + err.getCause());
            this.ConexionOK = false;

        }

        try {
            if (this.ConexionOK) {
                this.sentencia = this.conexion.createStatement();
            }

        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error al abril la base de datos " + " Mensaje: " + err.getMessage() + " Causa: " + err.getCause());
        }
    }

    /**
     * Método que nos permite cerrar la conexion a la base de datos. Si no se
     * logró cerrar la conexión muestra un mensaje de error.
     */
    public void cerrarConexión() {
        try {
            sentencia.close();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la base de datos");
        }
    }

    /**
     * Método para insertar registros a la base de datos Si no se logró insertar
     * la información muestra un mensaje de error.
     *
     * @param chat es una instancia de la clase Mensajes.
     */
    public void insertarBDclien(Mensajes chat) {
        try {
            String sql = "insert into Mensajes(Msg_de, Msg_para, Leido, Mensaje)" + "values(?,?,?,?)";

            instrucciónSQL = conexion.prepareStatement(sql);
            instrucciónSQL.setString(1, chat.getMsg_De());
            instrucciónSQL.setString(2, chat.getMsg_Para());
            instrucciónSQL.setString(3, chat.getLeido());
            instrucciónSQL.setString(4, chat.getMensaje());
            instrucciónSQL.execute();

        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error al insertar información en la Base de datos\n" + "Mensaje: " + err.getMessage());
        }
    }
    
   /**
    * Método para optener la información de la base de datos.Si no se logró
    * obtener la información muestra un mensaje de error.
    * 
    * @param de párametro de entrada que indica cual mensaje obtener.
    * @return devuelve el mensaje si no hay errores, si los hay devuelve un nulo.
    */
    public String obtenerMensaje(String de) {
        String sql = "SELECT Msg_de, Msg_para, Leido, Mensaje FROM Mensajes WHERE Msg_para = ? AND Leido = 'N';";

        try {
            instrucciónSQL = conexion.prepareStatement(sql);
            instrucciónSQL.setString(1, de);
            ResultSet informacion = null;
            informacion = instrucciónSQL.executeQuery();
            if (informacion.next()) {
                mensajeDe = informacion.getString("Msg_de");
                mensajePara = informacion.getString("Msg_para");
                leido = informacion.getString("Leido");
                mensaje = informacion.getString("Mensaje");

                return mensaje;
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el mensaje de la base de datos.");
        }
        return null;
    }

    /**
     * Método para actualizar el estado del mensaje (Leido = "S" / No leido = "N") 
     * Si no se logró actualizar el estado del mensaje muestra un mensaje de error.
     */
    public void actualizarVisto(String de) {

        try {
            String sql = "UPDATE Mensajes SET Leido = ? WHERE Msg_para = ?";

            instrucciónSQL = conexion.prepareStatement(sql);
            instrucciónSQL.setString(1, "S");
            instrucciónSQL.setString(2, de);
            instrucciónSQL.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado del mensaje. \n" + e.getMessage() + "\n" + e.getCause());
        }
    }
}
