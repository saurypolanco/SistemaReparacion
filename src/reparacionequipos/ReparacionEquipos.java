package reparacionequipos;

import java.sql.*;
import javax.swing.JOptionPane;

public class ReparacionEquipos {
    public static conexion conn = new conexion();
    
    public static void main(String[] args) throws SQLException {
        loginForm lf = new loginForm();
        lf.show();
    }
}
