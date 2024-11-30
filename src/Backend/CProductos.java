/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

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
public class CProductos {
    private Conexion conexion;
    public String n;

    public CProductos() {
        this.conexion = new Conexion("Costco");
    }
    
    public List<String> categorias() {
        List<String> categoriasList = new ArrayList<>();  
    
        try (Connection conn = conexion.conectar()) {
                String consulta = "SELECT CATEGORYNAME FROM CATEGORIES;";
                try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            categoriasList.add(rs.getString("CATEGORYNAME"));  
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al intentar obtener las categorías: " + e.getMessage());
            }

        return categoriasList;  
    }
    
    public void add(int id, String code, String name, String descripcion, double precio, int cantidad) {
        try (Connection conn = conexion.conectar()) {
            // Inserción de los datos en las columnas especificadas de la tabla PRODUCTS
            String consulta = "INSERT INTO PRODUCTS (CategoryID, ProductCode, ProductName, description, Price, stock_quantity,Discontinued) " +
                              "VALUES (?, ?, ?, ?, ?, ?,1);";  

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer los parámetros de la consulta en el orden adecuado
                pstmt.setInt(1, id);                // ID de la categoría
                pstmt.setString(2, code);           // Código del producto
                pstmt.setString(3, name);           // Nombre del producto
                pstmt.setString(4, descripcion);    // Descripción
                pstmt.setDouble(5, precio);         // Precio
                pstmt.setInt(6, cantidad);          // Cantidad del producto

                // Ejecutar la consulta de inserción
                pstmt.executeUpdate();

                System.out.println("Producto agregado exitosamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar agregar el producto: " + e.getMessage());
        }
    }
    
    public void delete(String name) {
        // Verificar si el nombre del producto está vacío antes de intentar eliminarlo
        if (name == null || name.trim().isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío.");
            return; // Salir si el nombre está vacío
        }

        try (Connection conn = conexion.conectar()) {
            // Consulta para eliminar el producto especificado por su nombre
            String consulta = "DELETE FROM Products WHERE ProductName = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer el parámetro de la consulta (nombre del producto a eliminar)
                pstmt.setString(1, name);  

                // Ejecutar la consulta de eliminación
                int rowsAffected = pstmt.executeUpdate();

                // Verificar si el producto fue eliminado
                if (rowsAffected > 0) {
                    System.out.println("Producto eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el producto con el nombre: " + name);
                }
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el producto: " + e.getMessage());
        }
    }
    public void deleteByBarcode(String barcode) {
        // Verificar si el código de barras está vacío antes de intentar eliminar el producto
        if (barcode == null || barcode.trim().isEmpty()) {
            System.out.println("El código de barras no puede estar vacío.");
            return; // Salir si el código de barras está vacío
        }

        try (Connection conn = conexion.conectar()) {
            // Consulta para eliminar el producto especificado por su código de barras
            String consulta = "DELETE FROM Products WHERE ProductCode = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer el parámetro de la consulta (código de barras del producto a eliminar)
                pstmt.setString(1, barcode);  

                // Ejecutar la consulta de eliminación
                int rowsAffected = pstmt.executeUpdate();

                // Verificar si el producto fue eliminado
                if (rowsAffected > 0) {
                    System.out.println("Producto eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el producto con el código de barras: " + barcode);
                }
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el producto: " + e.getMessage());
        }
    }

    
    public void update(String name, String barcode, int id, String descrip, int cantidad, double precio) {
        try (Connection conn = conexion.conectar()) {
            // Verificar si el CategoryID existe
            String verificarCategoria = "SELECT COUNT(*) FROM categories WHERE CategoryID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(verificarCategoria)) {
                checkStmt.setInt(1, id);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) == 0) {
                        System.out.println("Error: El CategoryID especificado no existe.");
                        return;
                    }
                }
            }

            // Preparar la consulta de actualización dependiendo de si el código de barras o el nombre está presente
            String consulta = "UPDATE products SET CategoryID = ?, ProductCode = ?, ProductName = ?, stock_quantity = ?, Price = ?, description = ? WHERE ";

            // Se determina si se actualiza por nombre o código de barras
            if (!barcode.isEmpty()) {
                // Si el código de barras no está vacío, actualizar por código de barras
                consulta += "productCode = ?";
            } else if (!name.isEmpty()) {
                // Si el nombre no está vacío, actualizar por nombre del producto
                consulta += "productName = ?";
            } else {
                // Si ninguno de los dos está presente, no realizar la actualización
                System.out.println("Error: Debes proporcionar un nombre o un código de barras.");
                return;
            }

            // Preparar la declaración con los parámetros correctos
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, id);       // Primer parámetro: ID de la categoría
                pstmt.setString(2, barcode.isEmpty() ? name : barcode);  // Segundo parámetro: Código de barras o nombre del producto
                pstmt.setString(3, name);  // Tercer parámetro: Nombre del producto
                pstmt.setInt(4, cantidad); // Cuarto parámetro: Cantidad del producto
                pstmt.setDouble(5, precio); // Quinto parámetro: Precio del producto
                pstmt.setString(6, descrip); // Sexto parámetro: Descripción del producto

                // Si se actualizará por código de barras
                if (!barcode.isEmpty()) {
                    pstmt.setString(7, barcode);  // Séptimo parámetro: Código de barras (si se usó)
                }

                // Ejecutar la actualización
                int filasActualizadas = pstmt.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Producto editado exitosamente.");
                } else {
                    System.out.println("Error: No se encontró un producto con el nombre o código de barras especificado.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar editar el producto: " + e.getMessage());
        }
    }


    
    public String[] select(String name) {
        // Inicializamos el arreglo que contendrá los detalles del producto.
        String[] productDetails = new String[6];  // 4 posiciones para cada dato

        try (Connection conn = conexion.conectar()) {
            String consulta = "SELECT  CategoryID,productCode,productName, description, price, stock_quantity FROM products WHERE productName = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                pstmt.setString(1, name);  


                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si hay resultados, guardamos cada dato en su posición correspondiente
                    if (rs.next()) {
                        productDetails[0] = String.valueOf(rs.getInt("CategoryID"));
                        productDetails[1] = String.valueOf(rs.getLong("productCode"));
                        productDetails[2] = rs.getString("ProductName");         
                        productDetails[3] = rs.getString("description"); 
                        productDetails[4] = String.valueOf(rs.getDouble("Price"));
                        productDetails[5] = String.valueOf(rs.getInt("stock_quantity"));    
                         
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener los productos: " + e.getMessage());
        }

        // Retornar el arreglo con los detalles del producto
        return productDetails;
    }
    
    public String[] selectCode(String code) {
        // Inicializamos el arreglo que contendrá los detalles del producto.
        String[] productDetails = new String[6];  // 4 posiciones para cada dato

        try (Connection conn = conexion.conectar()) {
            String consulta = "SELECT  CategoryID,productCode,productName, description, price, stock_quantity FROM products WHERE productCode = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                pstmt.setString(1, code);  


                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si hay resultados, guardamos cada dato en su posición correspondiente
                    if (rs.next()) {
                        productDetails[0] = String.valueOf(rs.getInt("CategoryID"));
                        productDetails[1] = String.valueOf(rs.getLong("productCode"));
                        productDetails[2] = rs.getString("ProductName");         
                        productDetails[3] = rs.getString("description"); 
                        productDetails[4] = String.valueOf(rs.getDouble("Price"));
                        productDetails[5] = String.valueOf(rs.getInt("stock_quantity"));    
                         
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener los productos: " + e.getMessage());
        }

        // Retornar el arreglo con los detalles del producto
        return productDetails;
    }
}
