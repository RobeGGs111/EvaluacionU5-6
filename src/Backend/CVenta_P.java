/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class CVenta_P {
     private Conexion conexion;
      public CVenta_P() {
        this.conexion = new Conexion("COSTCO");
    }
      //Metodo para buscar la venta por periodo de la tabla  Sales
    public List<Object[]> buscarVentaPorPeriodo(String FI, String FF) {
        String query = "SELECT saleId, employee_id, customer_id,saleDate, total_amount FROM Sales WHERE saleDate  BETWEEN  ? AND ?";
        List<Object[]> ventas = new ArrayList<>();
        // Establecer la conexión a la base de datos
        try (Connection connection = conexion.conectar();
                //Cremos la consulta
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, FI);  
            stmt.setString(2, FF);  
            ResultSet rs = stmt.executeQuery();
           while (rs.next()) {
               //Obtenemos los datos y los metemos en venta
                Object[] venta = new Object[]{
                    rs.getInt("SaleID"),
                    rs.getInt("employee_id"),
                    rs.getInt("customer_id"),
                    rs.getDate("saleDate"),
                    rs.getDouble("total_amount")
                };
                //Ayadimos el objeto venta al array
                ventas.add(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ventas; 
    }
}
