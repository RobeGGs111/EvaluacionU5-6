/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author s2212
 */
public class CMenu {
    
    private boolean caja;
    private Conexion conexion;
    public String n;

    public CMenu() {
        this.conexion = new Conexion("COSTCO");
    }
    
    public String name(String user) {
        String fullName = ""; 

        try (Connection conn = conexion.conectar()) {
            // Consulta que obtiene el nombre completo del empleado
            String consulta = "SELECT fullname FROM Employees WHERE username = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, user);  // Establece el valor del parámetro 'user'

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Aquí debes usar "employeeName" ya que es el nombre correcto de la columna
                        fullName = rs.getString("fullname");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el nombre completo: " + e.getMessage());
        }

        return fullName;
    }
    
}
