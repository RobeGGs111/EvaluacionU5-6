/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.mysql.cj.xdevapi.Statement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class CVentas {
    private Conexion conexion;
      public CVentas() {
        this.conexion = new Conexion("COSTCO");
    }
    //Metodo que busca el nombre del usuario ak iniciar la secion, com el parametro user
    public String name(String user) {
        String fullName = ""; 
        //Establecemos la coneccion
        try (Connection conn = conexion.conectar()) {
            //Cremos la consulta
            String consulta = "SELECT fullname FROM Employees WHERE UserName = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                //Asignamos el valor al parametro de la consulta
                pstmt.setString(1, user);
                try (ResultSet rs = pstmt.executeQuery()) {
                    //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
                    if (rs.next()) {
                        fullName = rs.getString("fullname");
                    }
                }
            }
            //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el nombre completo: " + e.getMessage());
        }
        return fullName;
    }
    
    //Metodo que busca el ID de la tabla SALE
    public int id(double total){
        int id = 0; 
        String t= String.valueOf(total);
        //Establecemos la coneccion
        try (Connection conn = conexion.conectar()) {
            //Cremos la consulta
            String consulta="Select SaleID  from sale where Total= ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                //Asignamos el valor al parametro de la consulta
                pstmt.setString(1, t);
                try (ResultSet rs = pstmt.executeQuery()) {
                    //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
                    if (rs.next()) {
                        id = rs.getInt("SaleID");
                    }
                }
            }
            //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el nombre completo: " + e.getMessage());
        }
        return id;
    }
    
    //Metodo para buscar el ID del USUARIO  de la Employees
    public int idUser(String user){
            int id=0; 
            //Establecemos la coneccion
        try (Connection conn = conexion.conectar()) {
            //Cremos la consulta
            String consulta = "SELECT EmployeeID AS IDUser FROM Employees WHERE UserName = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                 //Asignamos el valor al parametro de la consulta
                pstmt.setString(1, user);
                //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getInt("IDUser");
                    }
                }
            }
            //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el ID: " + e.getMessage());
        }
        return id;
    }
    //Metodo para buscar el ID del Producto en la tabla  Products
     public int idProducto(String clave){
            int id=0; 
            //Establecemos la coneccion
        try (Connection conn = conexion.conectar()) {
            //Cremos la consulta
            String consulta = "SELECT productId  FROM Products WHERE productCode = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                //Asignamos el valor al parametro de la consulta
                pstmt.setString(1, clave);
                try (ResultSet rs = pstmt.executeQuery()) {
                    //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
                    if (rs.next()) {
                        id = rs.getInt("productId");
                    }
                }
            }
             //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el ID: " + e.getMessage());
        }
        return id;
    }
    
     //Metodo que busca los productos por codigo
    public Object[] buscarProductoPorCodigo(String codeProduct) {
        //Cremos la consulta
        String query = "SELECT productCode, ProductName, price,Discontinued,stock_quantity  FROM PRODUCTS WHERE productCode = ?";
        //Se hace un arreglo de tipo Objetc
        Object[] producto= null;
        //Establecemos la coneccion
        try (Connection connection = conexion.conectar(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {
           //Asignamos el valor al parametro de la consulta
            stmt.setString(1, codeProduct);  
            ResultSet rs = stmt.executeQuery();
            //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
            if (rs.next()) {
                int descontinuado =rs.getInt("Discontinued");
               //La cual se evalua para saber si el producto esta descontinuado o no
                if(descontinuado==0){
                    return null;
                }else{
                    //Si no lo esta se agregan los datos de la fila en el arreglo Object
                        producto = new Object[]{
                        rs.getString("productCode"),  
                        rs.getString("ProductName"),  
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity") 
                        };
                }
                
            }
            //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
        }

        return producto; 
    }
    
    //Metodo para retornar un ArrayList<String>  que contiene los nombres de clientes de la tabla Customers
    public ArrayList<String> selectNombresClientes() {
    // Crear una lista para almacenar los nombres de los clientes
    ArrayList<String> NombreDeClientes = new ArrayList<>();

    // Establecer la conexión a la base de datos
    try (Connection conn = conexion.conectar()) {
        ///Cremos la consulta
        String consulta = "SELECT customerName FROM Customers;";

        // Preparar la declaración SQL
        try (PreparedStatement pstmt = conn.prepareStatement(consulta);
             ResultSet rs = pstmt.executeQuery()) {

            // Iterar sobre el conjunto de resultados y agregar los nombres a la lista
            while (rs.next()) {
                // Agregar el nombre de cada cliente al ArrayList
                NombreDeClientes.add(rs.getString("customerName"));
            }
        }
        //Si hay error devuelve un mensaje
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al intentar obtener los nombres de los clientes: " + e.getMessage());
    }

    // Retornar la lista con todos los nombres
    return NombreDeClientes;
}
    
    //Metodo para seleccionar el idCliente de la tabla Customers
    public int SelectIDCliente(String nombre){
         int id=0;
         // Establecer la conexión a la base de datos
        try (Connection conn = conexion.conectar()) {
            ///Cremos la consulta
            String consulta = "SELECT customerId FROM Customers WHERE customerName = ?";
            // Preparar la declaración SQL
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
               //Asignamos el valor al parametro de la consulta
                pstmt.setString(1, nombre);
                try (ResultSet rs = pstmt.executeQuery()) {
                    //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
                    if (rs.next()) {
                        id = rs.getInt("customerId");
                    }
                }
            }
            //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el ID: " + e.getMessage());
        }
        return id;
    }
    
    //Metodo para buscar si hay clientes en la base de datos 
    public boolean buscar(String customerName) {
    boolean existe = false;
    // Establecer la conexión a la base de datos
    try (Connection conn = conexion.conectar()) {
        //Cremos la consulta
        String consulta = "SELECT COUNT(*) FROM Customers WHERE customerName = ?";
        // Preparar la declaración SQL
        try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
           //Asignamos el valor al parametro de la consulta
            pstmt.setString(1, customerName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    existe = true;  // El cliente existe
                }
            }
        }
        //Si hay error devuelve un mensaje
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al intentar buscar el cliente: " + e.getMessage());
    }
    return existe;  // Retorna true si el cliente existe, false si no
}
    
    //Metodo para realizar la Transaccion
    public void realizarTransaccion(DefaultTableModel tabla, int empleadoId, int clienteId, String fecha, double total, String user, double iva,String NombreCliente) {
    // Validar si el cliente existe
    if (!buscar(NombreCliente)) {
        JOptionPane.showMessageDialog(null, "El cliente no existe en la base de datos.");
        return; // Detener la transacción si el cliente no existe
    }
    // Continuar con la transacción si el cliente existe
    DefaultTableModel modelo = tabla;
    List<String> queries = new ArrayList<>();
    //Cremos la consulta
    String sale = "INSERT INTO SALES (saleDate,total_amount, customer_id, employee_id) VALUES ('" + fecha + "', '" + total + "', " + clienteId + ", " + empleadoId + ");";
    //La ayadimos a la lista de Strings
    queries.add(sale);
    queries.add("SET @saleId = LAST_INSERT_ID();");
    //Le asignamos variables de tipo Object los lalores que tiene la tabla modelo
    for (int i = 0; i < modelo.getRowCount(); i++) {
        Object IdDelProducto = modelo.getValueAt(i, 0); 
        Object cantidadDelProducto = modelo.getValueAt(i, 3); 
        Object importeDelProducto = modelo.getValueAt(i, 4); 
        Object precioDelProducto = modelo.getValueAt(i, 2);
        //If el id del producto y la cantidad son nulas 
        if (IdDelProducto != null && cantidadDelProducto != null) {
            //Asignamos a las variable las variables OBjects
            int ID = idProducto((String)IdDelProducto);
            int cantidad = (int) cantidadDelProducto;
            double importe = (double) importeDelProducto;
            double precio = (double) precioDelProducto;
            //Evaluamos si la cantidad es mayor que 0
            if (cantidad > 0) {
                //Actualizamos la tabla productos para restar los stocks de los productos por cada venta
                String query = "UPDATE PRODUCTS SET stock_quantity = stock_quantity - " + cantidad + 
                               " WHERE ProductID = " + ID + " AND stock_quantity >= " + cantidad;
                queries.add(query);
                  //Si la cantidad llega a cero la tabla se actializa para que el producto quede descontinuado
                String Descontinuar = "UPDATE PRODUCTS SET Discontinued = 0 WHERE ProductID = " + ID + " AND stock_quantity <= 0";
                queries.add(Descontinuar);
                //He insertamos la venta en la tabla de SaleDetails
                String sale_details = "INSERT INTO SaleDetails (SaleID, product_id, Quantity, unit_price, total_price) " +
                                      "VALUES (@saleId, " + ID + ", " + cantidad + ", " + precio + ", " + importe + ")";
                queries.add(sale_details);
            }
        }
    }
    //LLamamos al metodo par imprimir ticket
    ImprimirTicket(tabla, user, fecha, total, iva,NombreCliente);
    //Hacemos la conexion 
    Conexion conexion = new Conexion("COSTCO");
    //llamaos al metodo para ejecutar la transaccion
    conexion.ejecutarTransaccion(queries.toArray(new String[0]));
}
    //Metodo para imprimit Ticket
        public void ImprimirTicket(DefaultTableModel  tabla,String user, String fecha,double total,double iva,String NombreCliente) {
            //Contamos el numero de tickets que llevamos
            int n=contarTickets();
            //Hacemos el nombre del archivo
            String nombreArchivo = "ticket"+n+".txt";
            //Creamos el archivo
            File Archivo=new File(nombreArchivo);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Archivo))) {
                //Escrinimos el contenido del archivo 
                writer.write("===== Ticket de Venta =====");
                writer.newLine();
                writer.write("Fecha: " + fecha);
                writer.newLine();
                writer.write("Empleado: " + user);
                writer.newLine();
                writer.write("Cliente: " + NombreCliente);
                writer.newLine();
                writer.write("===========================");
                writer.newLine();
                writer.write("Detalles de la Venta:");
                writer.newLine();
                writer.write(String.format("%-30s %-15s %-15s %-15s", "Nombre", "Cantidad", "Precio Unit.", "Total"));
                writer.newLine();
                //Iteramos en las filas de la tabla para extraer los datos
                for (int i = 0; i < tabla.getRowCount(); i++) {
                   String nombre = (String) tabla.getValueAt(i, 1);
                    int cantidad = (int) tabla.getValueAt(i, 3);
                    double precio = (double) tabla.getValueAt(i, 2);
                    double importe = (double) tabla.getValueAt(i, 4);
                     //Se escriben los datos de cada producto 
                    writer.write(String.format("%-30s %-15d %-15.2f %-15.2f", nombre, cantidad, precio, importe));
                    writer.newLine();
           
                }
                //Se escribe los totales y el IVA
                writer.write("===========================");
                writer.newLine();
                writer.write(String.format("IVA 16p:  %.2f",iva));
                writer.newLine();
                writer.write(String.format("Total de la venta: %.2f", total));
                writer.newLine();
                writer.write("===========================");
                writer.newLine();
                writer.write("Gracias por su compra!");
                writer.newLine();
                //Generamos mensaje de exito
                System.out.println("Ticket generado exitosamente en " + nombreArchivo);
            } catch (IOException e) {
                e.printStackTrace();
            }

}
        //Metodo para contar los tickets que tenemos
         private int contarTickets() {
        int n = 1;
        //Creamos su nombre 
        File archivoDelTicket = new File("ticket" + n + ".txt");
        // busca el ticket que hay y obtiene el siguiente
        while (archivoDelTicket.exists()) {
            n++;
            archivoDelTicket = new File("ticket" + n + ".txt");
        }
        
        return n;
    }
}
    
