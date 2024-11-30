/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author robek
 */
public class CClientes {
    private Conexion cn;
    private String n;
    
    public CClientes() {
        this.cn = new Conexion("COSTCO");
    }
    
    
  public void add(String customerName, String gender, String email, String phone, String address) {
        try (Connection conn = cn.conectar()) {
            if("MASCULINO".equals(gender))
            {
                gender="M";
            }else{
                gender="F";
            }
            
            // Inserción de los datos en las columnas especificadas de la tabla PRODUCTS
            String consulta = "INSERT INTO Customers (customerName, gender, email, phone, address) VALUES (?, ?, ?, ?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer los parámetros de la consulta
                pstmt.setString(1, customerName);  // Nombre del cliente
                pstmt.setString(2, gender);        // Género ('M' o 'F')
                pstmt.setString(3, email);         // Correo electrónico
                pstmt.setString(4, phone);         // Teléfono (se asume que el teléfono es de 10 caracteres)
                pstmt.setString(5, address);
               

                // Ejecutar la consulta de inserción
                pstmt.executeUpdate();

                System.out.println("Cliente agregado exitosamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar agregar el Cliente: " + e.getMessage());
        }
    }
  public void delete(String customerName) {
        try (Connection conn = cn.conectar()) {
            // Consulta para eliminar el cliente por su nobre
            String consulta = "DELETE FROM Customers WHERE customerName = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer el parámetro de la consulta (Nombre del Cliente)
                pstmt.setString(1, customerName);  

                // Ejecutar la consulta de eliminación
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Cliente eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el Cliente para eliminar.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el Cliente: " + e.getMessage());
        }
    }
  public void update(String customerName, String genero, String Email, String Tel, String Direccion) {
    // Convertir el género a 'M' o 'F' según el valor recibido
    if ("MASCULINO".equals(genero)) {
        genero = "M";
    } else {
        genero = "F";
    }

    try (Connection conn = cn.conectar()) {
       

        // Si el cliente existe, procedemos a actualizar los datos
        String consulta = "UPDATE Customers SET gender = ?, email = ?, phone = ?, address = ? WHERE customerName = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
            // Establecer los parámetros de la consulta de actualización
            pstmt.setString(1, genero);     // Género (M o F)
            pstmt.setString(2, Email);      // Correo electrónico
            pstmt.setString(3, Tel);        // Teléfono (debe tener 10 dígitos)
            pstmt.setString(4, Direccion);  // Dirección
            pstmt.setString(5, customerName); // Nombre del cliente (criterio de búsqueda para la actualización)

            // Ejecutar la consulta de actualización
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                // Si se actualizó al menos un registro
                System.out.println("Cliente editado exitosamente.");
            } else {
                // Si no se encontró el cliente
                System.out.println("Error: No se encontró un cliente con el nombre especificado.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al intentar editar el cliente: " + e.getMessage());
    }
}
  public boolean buscar(String customerName) {
    boolean existe = false;
    try (Connection conn = cn.conectar()) {
        String consulta = "SELECT COUNT(*) FROM Customers WHERE customerName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
            pstmt.setString(1, customerName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    existe = true;  // El cliente existe
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al intentar buscar el cliente: " + e.getMessage());
    }
    return existe;  // Retorna true si el cliente existe, false si no
}
   public String[] select(String customerName) {
        // Inicializamos el arreglo que contendrá los detalles del cliente
        String[] Cliente = new String[5];  // 5 posiciones para cada dato

        try (Connection conn = cn.conectar()) {
            String consulta = "SELECT  customerName,gender, email, phone, address FROM Customers WHERE customerName = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                pstmt.setString(1, customerName);  


                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si hay resultados, guardamos cada dato en su posición correspondiente
                    if (rs.next()) {
                        Cliente[0] = rs.getString("customerName");         
                        Cliente[1] = rs.getString("gender");
                        Cliente[2] = rs.getString("email");
                        Cliente[3] = rs.getString("phone");
                        Cliente[4] = rs.getString("address");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el cliente: " + e.getMessage());
        }

        return Cliente;
    }
}