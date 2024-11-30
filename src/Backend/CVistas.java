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
import javax.swing.table.DefaultTableModel;

public class CVistas {
    
    private Conexion conexion;

    public CVistas() {
        this.conexion = new Conexion("COSTCO");
    }
    
    public DefaultTableModel mostrarReporteVentas(int mes) {
        DefaultTableModel modelo = new DefaultTableModel();
        
        // Definir las columnas para el JTable
        modelo.addColumn("FOLIO");
        modelo.addColumn("FECHA");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("EMPLEADO");
        modelo.addColumn("TOTAL");
        modelo.addColumn("CANT_DETALLES");

        // Verifica si el mes es válido
        if (mes == 0 || mes>12) {
            System.out.println("Mes no válido.");
            return modelo; // Regresa un modelo vacío si el mes es inválido
        }

        // Consulta SQL para obtener los registros filtrados por el nombre del mes
        String consulta = "SELECT * FROM ReporteVentasPorMes WHERE MONTh(fecha) =  ?";

        try (Connection conn = conexion.conectar()) {
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, mes); // Establece el nombre del mes en la consulta

                try (ResultSet rs = pstmt.executeQuery()) {
                    // Iterar sobre los resultados y llenar el modelo de tabla
                    while (rs.next()) {
                        Object[] fila = new Object[6];
                        fila[0] = rs.getInt("FOLIO");
                        fila[1] = rs.getDate("FECHA");
                        fila[2] = rs.getString("CLIENTE");
                        fila[3] = rs.getString("EMPLEADO");
                        fila[4] = rs.getBigDecimal("TOTAL");
                        fila[5] = rs.getInt("CANT_DETALLES");

                        modelo.addRow(fila); // Añadir la fila al modelo de tabla
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar la vista ReporteVentasPorMes: " + e.getMessage());
        }
        
        return modelo; // Regresa el modelo con los resultados filtrados
    }
    
    public DefaultTableModel mostrarReporteVentasT(int año) {
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas para el JTable
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("TRIM_1");
        modelo.addColumn("TRIM_2");
        modelo.addColumn("TRIM_3");
        modelo.addColumn("TRIM_4");

        // Verifica si el año es válido
        if (año <= 0) {
            System.out.println("Año no válido.");
            return modelo; // Regresa un modelo vacío si el año es inválido
        }

        // Consulta SQL para obtener los registros filtrados por el año
        String consulta = "call ObtenerReporteVentasPorAño(?);";

        try (Connection conn = conexion.conectar()) {
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, año); // Establece el año en la consulta

                try (ResultSet rs = pstmt.executeQuery()) {
                    // Iterar sobre los resultados y llenar el modelo de tabla
                    while (rs.next()) {
                        Object[] fila = new Object[5];
                        fila[0] = rs.getString("PRODUCTO"); // Producto
                        fila[1] = rs.getInt("TRIM_1");     // Ventas del primer trimestre
                        fila[2] = rs.getInt("TRIM_2");     // Ventas del segundo trimestre
                        fila[3] = rs.getInt("TRIM_3");     // Ventas del tercer trimestre
                        fila[4] = rs.getInt("TRIM_4");     // Ventas del cuarto trimestre

                        modelo.addRow(fila); // Añadir la fila al modelo de tabla
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar la vista ReporteTrimestralVentas: " + e.getMessage());
        }

        return modelo; // Regresa el modelo con los resultados filtrados
    }
    
    public DefaultTableModel mostrarReporteVentasE() {
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas para el JTable
        modelo.addColumn("EMPLEADO");
        modelo.addColumn("TOTAL");
        modelo.addColumn("VENTAS");
        // Consulta SQL para obtener los registros filtrados por el año
        String consulta = "select * from reporte_ventas_por_empleado;";

        try (Connection conn = conexion.conectar()) {
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                try (ResultSet rs = pstmt.executeQuery()) {
                    // Iterar sobre los resultados y llenar el modelo de tabla
                    while (rs.next()) {
                        Object[] fila = new Object[5];
                        fila[0] = rs.getString("EMPLEADO"); // EMPLEADO
                        fila[1] = rs.getDouble("TOTAL");     // TOTAL DE VENTAS
                        fila[2] = rs.getInt("CANT_VENTAS");     // CANTIDA DE VENTAS

                        modelo.addRow(fila); // Añadir la fila al modelo de tabla
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar la vista ReporteTrimestralVentas: " + e.getMessage());
        }

        return modelo; // Regresa el modelo con los resultados filtrados
    }

}
