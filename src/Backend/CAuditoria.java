/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.mysql.cj.xdevapi.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s2212
 */
public class CAuditoria {
    private Conexion conexion;

    public CAuditoria() {
        this.conexion = new Conexion("Costco");
    }
    
    public List<String> obtenerAuditorias() {
        List<String> auditoriasList = new ArrayList<>();
        
        // Consulta SQL para obtener todos los registros de la tabla AuditoriaVentas
        String consulta = "SELECT id, accion, saleId, cambio, realizado_por, fecha FROM AuditoriaVentas";
        
        try (Connection conn = conexion.conectar()) {  // Se asume que conexion.conectar() es el método para conectar a la base de datos
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Recorrer los resultados y agregar cada auditoría como un String a la lista
                    while (rs.next()) {
                        // Crear una cadena con los detalles de la auditoría
                        String auditoria = "ID: " + rs.getInt("id") + ", "
                                          + "Acción: " + rs.getString("accion") + ", "
                                          + "Sale ID: " + rs.getInt("saleId") + ", "
                                          + "Cambio: " + rs.getString("cambio") + ", "
                                          + "Realizado por: " + rs.getString("realizado_por") + ", "
                                          + "Fecha: " + rs.getTimestamp("fecha");
                        auditoriasList.add(auditoria);  // Añadir la auditoría a la lista
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener las auditorías: " + e.getMessage());
        }
        System.out.println("Exitoso");
        return auditoriasList;  // Regresar la lista con todas las auditorías
    }
    
    
}
