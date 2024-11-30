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
public class CEmpleados {
    private Conexion cn;
    private String n;
    
    public CEmpleados() {
        this.cn = new Conexion("COSTCO");
    }
    
  public void add(String curp, String username, String password, String employeeName, String email,int age,String phone,String gender) {
        try (Connection conn = cn.conectar()) {
            if("MASCULINO".equals(gender))
            {
                gender="M";
            }else{
                gender="F";
            }
            
            // Inserción de los datos en las columnas especificadas de la tabla PRODUCTS
            String consulta = "INSERT INTO Employees (curp, username, password, fullName, email,age,phone,gender) VALUES (?, ?, sha2(?,256), ?, ?,?,?,?);";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer los parámetros de la consulta
                pstmt.setString(1, curp);  // Nombre del cliente
                pstmt.setString(2, username);        // Género ('M' o 'F')
                pstmt.setString(3, password);         // Correo electrónico
                pstmt.setString(4, employeeName);         // Teléfono (se asume que el teléfono es de 10 caracteres)
                pstmt.setString(5, email);
                pstmt.setInt(6, age);
                pstmt.setString(7, phone);
                pstmt.setString(8, gender);
               

                // Ejecutar la consulta de inserción
                pstmt.executeUpdate();

                System.out.println("Empleado agregado exitosamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar agregar el Empleado: " + e.getMessage());
        }
    }
  
  public void delete(String employeeName) {
        try (Connection conn = cn.conectar()) {
            // Consulta para eliminar el cliente por su nobre
            String consulta = "DELETE FROM Employees WHERE fullName = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer el parámetro de la consulta (Nombre del Cliente)
                pstmt.setString(1, employeeName);  

                // Ejecutar la consulta de eliminación
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Empleado eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el Empleado para eliminar.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el Empleado: " + e.getMessage());
        }
    }
  
  public void update(String curp, String username, String password, String employeeName, String email,int age,String phone,String gender) {
    // Convertir el género a 'M' o 'F' según el valor recibido
    if ("MASCULINO".equals(gender)) {
        gender = "M";
    } else {
        gender = "F";
    }

    try (Connection conn = cn.conectar()) {
       

        // Si el Empleado existe, procedemos a actualizar los datos
        String consulta = "UPDATE employees SET  curp=?,username=?, password=sha2(?,256),email=?, age=?, phone=?,gender=? WHERE fullName = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
            // Establecer los parámetros de la consulta de actualización
            pstmt.setString(1, curp);     
            pstmt.setString(2, username);      
            pstmt.setString(3, password);        
            pstmt.setString(4, email);  
            pstmt.setInt(5, age); 
            pstmt.setString(6, phone); 
            pstmt.setString(7, gender); 
            pstmt.setString(8, employeeName);

            // Ejecutar la consulta de actualización
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                // Si se actualizó al menos un registro
                System.out.println("Empleado editado exitosamente.");
            } else {
                // Si no se encontró el empleado
                System.out.println("Error: No se encontró un empleado con el nombre especificado.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al intentar editar el empleado: " + e.getMessage());
    }
}
  public boolean buscar(String employeeName) {
    boolean existe = false;
    try (Connection conn = cn.conectar()) {
        String consulta = "SELECT COUNT(*) FROM Employees WHERE fullName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
            pstmt.setString(1, employeeName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    existe = true;  // El Empleado existe
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al intentar buscar el cliente: " + e.getMessage());
    }
    return existe;  // Retorna true si el cliente existe, false si no
}
   public String[] select(String employeeName) {
        // Inicializamos el arreglo que contendrá los detalles del cliente
        String[] Empleado = new String[8];  // 8 posiciones para cada dato

        try (Connection conn = cn.conectar()) {
            String consulta = "SELECT  curp, username, password, fullName, email,age,phone,gender FROM employees WHERE fullName = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                pstmt.setString(1, employeeName);  


                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si hay resultados, guardamos cada dato en su posición correspondiente
                    if (rs.next()) {
                        Empleado[0] = rs.getString("curp");         
                        Empleado[1] = rs.getString("username");
                        Empleado[2] = rs.getString("password");
                        Empleado[3] = rs.getString("fullName");
                        Empleado[4] = rs.getString("email");
                        Empleado[5] = rs.getString("age");
                        Empleado[6] = rs.getString("phone");
                        Empleado[7] = rs.getString("gender");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el cliente: " + e.getMessage());
        }

        return Empleado;
    }
}