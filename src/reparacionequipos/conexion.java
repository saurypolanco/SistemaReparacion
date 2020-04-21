package reparacionequipos;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.xml.sax.SAXException;

public class conexion {
    private static Connection CONN = null;
    private static ResultSet RS;
    private static Statement ST;
    private static Savepoint SP;
    private static org.jespxml.modelo.Tag server, user, password, database;
    //metodo que crea la conexion
    
    private static void leerXML() throws TagHijoNotFoundException{
        try {
            
            org.jespxml.modelo.Tag raiz = JespXML.leerXML(new File("src/reparacionequipos/connectionData.xml"));
            
           conexion.server = raiz.getTagHijoByName("server");
           conexion.user = raiz.getTagHijoByName("user");
           conexion.password = raiz.getTagHijoByName("password");
           conexion.database = raiz.getTagHijoByName("database");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private static Connection getConnection(){
        try {
            leerXML();
            Class.forName("com.mysql.jdbc.Driver");
            CONN= DriverManager.getConnection("jdbc:mysql://"+server.getContenido().trim()+"/"+database.getContenido().trim(),user.getContenido().trim(),password.getContenido().trim());
            CONN.setAutoCommit(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar con la base de datos "+e.getMessage());
            CONN = null;
        }    
        return CONN;
    }
    
    public void closeConection(){
        try {
            CONN.close();
            CONN = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cerrar la conexion");
        }
    }
    
    //metodo para realizar una consulta
    public static ResultSet query(String table, String values) throws SQLException{
        try {
            getConnection();
            ST = CONN.createStatement();
            //System.out.println("SELECT "+values+" FROM "+table);
            RS = ST.executeQuery("SELECT "+values+" FROM "+table);
            
            return RS;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al procesar la consulta "+e.getMessage());
            RS=null;
            return RS;
        }
        
    }
    
    public static ResultSet query(String query) throws SQLException{
        try {
            getConnection();
            ST = CONN.createStatement();
            //System.out.println(query);
            RS = ST.executeQuery(query);
            
            return RS;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al procesar la consulta "+e.getMessage());
            RS=null;
            return RS;
        }
        
    }
    
    
    
    //metodo para insertar datos
    public static void insert(String table, String values) throws SQLException{
        try {
            getConnection();
            Savepoint SP = CONN.setSavepoint("BeforeQuery");
            ST = CONN.createStatement();
            System.out.println("INSERT INTO "+table+" VALUES("+values+")");
            ST.executeUpdate("INSERT INTO "+table+" VALUES("+values+")");
                CONN.commit();
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al realizar la insercion "+e.getMessage());
               CONN.rollback();
        }finally{
            CONN.close();
        }
    }
    //metodo para insercion masiva de datos
    public static void insert_massive(String table, String values) throws SQLException{
        try {
            getConnection();
            Savepoint SP = CONN.setSavepoint("beforeInsert");
            ST = CONN.createStatement();
            ST.executeUpdate("INSERT INTO "+table+" "+values);
            CONN.commit();
            JOptionPane.showMessageDialog(null, "Se Han Insertado los Datos Correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al hacer la insercion " + e.getMessage());
            CONN.rollback(SP);
        }finally{
            CONN.close();
        }
        
    }
//    metodo para actualizar datos
    public static void update(String table, String values, String where) throws SQLException{      
        try {
            getConnection();
            Savepoint SP = CONN.setSavepoint("beforeUpdate");
            ST = CONN.createStatement();
            ST.executeUpdate("UPDATE "+table+" SET "+values+" WHERE "+where);
            CONN.commit();
            //JOptionPane.showMessageDialog(null, "Se Han Actualizado los Datos Correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar " + e.getMessage());
            CONN.rollback(SP);
        }finally{
            CONN.close();
        }
    
    }
    
    
//    
    public static void executeQuery(String statement) throws SQLException{
        try {
            getConnection();
            Savepoint SP = CONN.setSavepoint("beforeQueryStatement");
            ST = CONN.createStatement();
            ST.executeUpdate(statement);
            CONN.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la consulta "+e.getMessage());
            CONN.rollback();
        }finally{
            CONN.close();
        }
    
    }
    
    
   
}
