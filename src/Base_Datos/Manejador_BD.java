
package Base_Datos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Manejador_BD {
    //Atributos
    private final String IP = "127.0.0.1";
    private final String PUERTO = "3306";
    private final String NOMBRE_BASE_DATOS = "progra";
    private final String USUARIO_BASE_DATOS = "root";
    private final String password_BASE_DATOS = "";
    
    private Connection conexion;
    
    //constructor
    public Manejador_BD() {
       //Paso 1
       cargarDriver();
        

    }
    
    //Metodos
    //Primer paso Cargar Driver
    public void cargarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception ex) {
           // System.out.println("No se puede cargar el driver de MYSQL");
           // System.out.println("Error : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede cargar el driver de MYSQL debido a este error: " + ex.getMessage(), "Error Driver Mysql", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Paso 2 Conectarse a la base de datos 
    public Connection conectarseBD() {
        try {
            //Conectando a la base de datos
            this.conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + this.IP + ":" + this.PUERTO + "/" + this.NOMBRE_BASE_DATOS, this.USUARIO_BASE_DATOS,this.password_BASE_DATOS);
        } catch (SQLException ex) {
            conexion = null;
            Logger.getLogger(Manejador_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    
    public Connection getConexion() {
        return this.conexion;
    }
    
   public void cerrarConexionBD() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede cerrar la conexion a la base de datos: " + ex.getMessage(), "Error Cerrar Conexion BD", JOptionPane.ERROR_MESSAGE);
        }
        
   }
   
   
   public ResultSet consultarDB(String consultaSQL) {
       ResultSet resultado;
        try {
            Statement comando = conexion.createStatement();
            
           resultado = comando.executeQuery(consultaSQL);
        } catch (SQLException ex) {
            resultado = null;
            JOptionPane.showMessageDialog(null, "No se puede consultar a la base de datos: " + ex.getMessage(), "Error Consulta BD", JOptionPane.ERROR_MESSAGE);
        }
        
        return resultado;
 
   }
   
   public void insertarDB(String insercionSQL) {
        try {
           Statement comando = conexion.createStatement();
           comando.executeUpdate(insercionSQL);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "No se puede insertar el registro a la base de datos: " + ex.getMessage(), "Error Insercion BD", JOptionPane.ERROR_MESSAGE);
        }    
   }
   
   public int borrarRegistro(String borradoSQL) {
       int cantidad = 0;
       try {
           Statement comando = conexion.createStatement();
           //Si el borrado del registro es exitoso cantidad tomara el valor de 1, caso contrario estara en 0;
           cantidad = comando.executeUpdate(borradoSQL);
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el registro a la base de datos: " + ex.getMessage(), "Error Borrado del registro  BD", JOptionPane.ERROR_MESSAGE);
        } 
       
        return cantidad;
   }
}
