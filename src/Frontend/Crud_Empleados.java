/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.CEmpleados;
import Backend.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author s2212
 */
public class Crud_Empleados extends javax.swing.JFrame {

    Conexion cx;
    CEmpleados e;
    String user;
    public Crud_Empleados(String nombre) {
        initComponents();
        //El JFrame este centrado
        setLocationRelativeTo(null);
        //El JFrame tenga un tama;o fijo
        this.setSize(910, 650);
        //El usuario no pueda modificar el tama;o del JFrame
        this.setResizable(false);
        this.user=nombre;
        e=new CEmpleados();
        cx = new Conexion("Costco");
    }
    public Crud_Empleados () {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtGmail = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnBorar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtCurp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EMPLEADOS");

        btnSalir.setBackground(new java.awt.Color(51, 51, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/cerrar-sesion.png"))); // NOI18N
        btnSalir.setPreferredSize(new java.awt.Dimension(150, 100));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SALIR");

        btnRegresar.setBackground(new java.awt.Color(51, 51, 51));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/reiniciar.png"))); // NOI18N
        btnRegresar.setPreferredSize(new java.awt.Dimension(150, 100));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("REGRESAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 150));
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 240, 50));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 240, 50));
        jPanel1.add(txtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 240, 50));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 240, 50));
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 240, 50));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 240, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CURP");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USERNAME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PASSWORD");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRE COMPLETO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EMAIL");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PHONE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EDAD");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, -1));

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        jPanel1.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 240, 50));

        btnBuscar.setBackground(new java.awt.Color(255, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Crud/buscar.png"))); // NOI18N
        btnBuscar.setPreferredSize(new java.awt.Dimension(150, 100));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, -1, -1));

        btnBorar.setBackground(new java.awt.Color(255, 0, 0));
        btnBorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Crud/eliminar.png"))); // NOI18N
        btnBorar.setPreferredSize(new java.awt.Dimension(150, 100));
        btnBorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Crud/agregar-usuario (1).png"))); // NOI18N
        btnAgregar.setPreferredSize(new java.awt.Dimension(150, 100));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        btnEditar.setBackground(new java.awt.Color(255, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Crud/editar-informacion.png"))); // NOI18N
        btnEditar.setPreferredSize(new java.awt.Dimension(150, 100));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, -1, -1));
        jPanel1.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 240, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("GENERO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Background.jpg"))); // NOI18N
        lblbackground.setPreferredSize(new java.awt.Dimension(960, 610));
        jPanel1.add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        cx.conectar();
        cx.desconectar();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu menu = new Menu(user);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!"".equalsIgnoreCase(txtNombre.getText())) {
            int g=0;
            String nombre = txtNombre.getText();

            // Llamar al método select para obtener los productos correspondientes
            String[] Empleado = e.select(nombre);

            if (Empleado.length > 0 && Empleado[3] != null) {
                
               txtCurp.setText(Empleado[0]);
                txtUserName.setText(Empleado[1]);
                txtPassword.setText(Empleado[2]);
                txtNombre.setText(Empleado[3]);
                txtGmail.setText(Empleado[4]);
                txtEdad.setText(Empleado[5]);
                txtTel.setText(Empleado[6]);
                String genero = Empleado[7];
               if ("M".equals(genero)) {
                    g=0;
                } else {
                    g=1;
                }
                cmbGenero.setSelectedIndex(g);            
            } else {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
                txtCurp.setText("");
                txtUserName.setText("");
                txtPassword.setText("");
                txtNombre.setText("");
                txtGmail.setText("");
                txtEdad.setText("");
                txtTel.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el Nombre del Empleado.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorarActionPerformed
         if (!txtNombre.getText().isEmpty()) {

            try {
                // Obtener los valores del formulario
                String nombre = txtNombre.getText();
                if (!e.buscar(nombre)) {  
                    JOptionPane.showMessageDialog(null, "El Empleado ya fue eliminado o no existe en la base.");
                    txtCurp.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");
                    txtNombre.setText("");
                    txtGmail.setText("");
                    txtEdad.setText("");
                    txtTel.setText("");
                    return; 
                }
                
                   // Llamar al método delete con los parámetros adecuados
                    e.delete(nombre);
                    txtCurp.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");
                    txtNombre.setText("");
                    txtGmail.setText("");
                    txtEdad.setText("");
                    txtTel.setText("");

                // Notificación de éxito (puedes personalizar el mensaje según sea necesario)
                JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.");
                
            } catch (NumberFormatException e) {
                // Mostrar error si los parametro no son números válidos
                JOptionPane.showMessageDialog(null, "Por favor ingresa parametros válidos.");
            }
        } else {
            // Si alguno de los campos está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.");
        }
    }//GEN-LAST:event_btnBorarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!"".equalsIgnoreCase(txtUserName.getText()) && 
                !"".equalsIgnoreCase(txtCurp.getText()) &&
                    !"".equalsIgnoreCase(txtPassword.getText()) &&
                        !"".equalsIgnoreCase(txtNombre.getText())&&
                            !"".equalsIgnoreCase(txtEdad.getText())) {

                        try {
                // Obtener los valores del formulario
                String curp = txtCurp.getText();
                String user = txtUserName.getText();
                String passwor = txtPassword.getText();
                String nombre = txtNombre.getText();
                String email = txtGmail.getText();
                int age = Integer.parseInt(txtEdad.getText());
                String Tel=txtTel.getText();
                String genero = (String) cmbGenero.getSelectedItem();
                if (e.buscar(nombre)) {  
                    JOptionPane.showMessageDialog(null, "El Empleado ya existe en la base de datos.");
                    return; 
                }
                    if(curp.length() == 18 && (Tel.length() == 10 || Tel.isEmpty())){
                        if(Tel.matches("\\d+")||Tel.isEmpty()){
                            e.add(curp, user, passwor, nombre, email,age,Tel,genero);
                            txtCurp.setText("");
                            txtUserName.setText("");
                            txtPassword.setText("");
                            txtNombre.setText("");
                            txtGmail.setText("");
                            txtEdad.setText("");
                            txtTel.setText("");

                            // Notificación de éxito (puedes personalizar el mensaje según sea necesario)
                            JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente.");
                        }else{
                        JOptionPane.showMessageDialog( null,"Por favor ingrese solo numeros al numero telefonico");
                        }
                    }else{
                        JOptionPane.showMessageDialog( null,"El numero de telefono debe contener 10 Digitos y la curp 18");
                    }
                                
            } catch (NumberFormatException e) {
                // Mostrar error si hay un problema
                JOptionPane.showMessageDialog( null,"Por favor ingrese bien los parametros");
            }
                        
            }else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
    }                                        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Validar que los campos no estén vacíos
        if (!txtNombre.getText().isEmpty() ) {
            try {
                // Obtener los valores del formulario
                String curp = txtCurp.getText();
                String user = txtUserName.getText();
                String passwor = txtPassword.getText();
                String nombre = txtNombre.getText();
                String email = txtGmail.getText();
                int age = Integer.parseInt(txtEdad.getText());
                String Tel=txtTel.getText();
                String genero = (String) cmbGenero.getSelectedItem();; 

                // Verificar si el empleado existe en la base de datos
                if (!e.buscar(nombre)) {  
                    JOptionPane.showMessageDialog(null, "El empleado no existe en la base de datos.");
                    return; 
                }

                // Verificar que el teléfono tenga 10 dígitos o esté vacío
                if (curp.length() == 18 && (Tel.length() == 10 || Tel.isEmpty())) {
                    // Verificar que el teléfono contenga solo números
                    if (Tel.matches("\\d+")||Tel.isEmpty()) {
                        // Llamada al método de actualización de la base de datos
                        e.update(curp, user, passwor, nombre, email,age,Tel,genero);
                    
                        // Limpiar los campos después de la actualización
                        txtCurp.setText("");
                        txtUserName.setText("");
                        txtPassword.setText("");
                        txtNombre.setText("");
                        txtGmail.setText("");
                        txtEdad.setText("");
                        txtTel.setText("");

                        // Notificación de éxito
                        JOptionPane.showMessageDialog(null, "Empleado editado exitosamente.");
                    } else {
                        // Si el teléfono no es numérico
                        JOptionPane.showMessageDialog(null, "Por favor ingrese solo números en el número telefónico.");
                    }
                } else {
                    // Si el teléfono no tiene 10 dígitos
                    JOptionPane.showMessageDialog(null, "El número de teléfono debe contener 10 dígitos y la curp 18.");
                }
            } catch (NumberFormatException e) {
                // Mostrar error  no son valores válidos
                JOptionPane.showMessageDialog(null, "Por favor ingresa valores validos.");
            }
        } else {
            // Si alguno de los campos está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crud_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crud_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crud_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crud_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crud_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}