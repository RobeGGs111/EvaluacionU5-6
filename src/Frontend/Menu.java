/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.CMenu;
import Backend.Conexion;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author s2212
 */
public class Menu extends javax.swing.JFrame {

    Conexion cx;
    private String user;
    
    public Menu(String user) {
        initComponents();
        //El JFrame este centrado
        setLocationRelativeTo(null);
        //El JFrame tenga un tama;o fijo
        this.setSize(910, 600);
        //El usuario no pueda modificar el tama;o del JFrame
        this.setResizable(false);
        
        cx = new Conexion("Costco");
        this.user=user;
        
        CMenu menu = new CMenu();
        txtNameCajero.setText(menu.name(user));
    }
    
    public Menu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        txtSaldo = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo1 = new javax.swing.JTextField();
        lblSaldo1 = new javax.swing.JLabel();
        txtNameCajero = new javax.swing.JTextField();
        lblSaldo2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblSaldo3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        lblSaldo4 = new javax.swing.JLabel();
        lblSaldo5 = new javax.swing.JLabel();
        lblSaldo7 = new javax.swing.JLabel();
        lblSaldo6 = new javax.swing.JLabel();
        lblSaldo8 = new javax.swing.JLabel();
        lblSaldo9 = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU - COSTCO");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 52)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");

        btnCerrar.setBackground(new java.awt.Color(51, 51, 51));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/close.png"))); // NOI18N
        btnCerrar.setPreferredSize(new java.awt.Dimension(150, 100));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 51, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/cerrar-sesion.png"))); // NOI18N
        btnSalir.setPreferredSize(new java.awt.Dimension(150, 100));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAbrir.setBackground(new java.awt.Color(51, 51, 51));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/open.png"))); // NOI18N
        btnAbrir.setPreferredSize(new java.awt.Dimension(150, 100));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABRIR TURNO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CERRAR TURNO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SALIR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel3)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 150));

        btnProductos.setBackground(new java.awt.Color(255, 0, 0));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/agregar-producto.png"))); // NOI18N
        btnProductos.setPreferredSize(new java.awt.Dimension(150, 100));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        btnEmpleados.setBackground(new java.awt.Color(255, 0, 0));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/empleado-de-oficina.png"))); // NOI18N
        btnEmpleados.setPreferredSize(new java.awt.Dimension(150, 100));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        btnVentas.setBackground(new java.awt.Color(255, 0, 0));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/bienes.png"))); // NOI18N
        btnVentas.setPreferredSize(new java.awt.Dimension(150, 100));
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        btnClientes.setBackground(new java.awt.Color(255, 0, 0));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/cliente.png"))); // NOI18N
        btnClientes.setPreferredSize(new java.awt.Dimension(150, 100));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        txtSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSaldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 180, 60));

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo.setText("REPORTES");
        jPanel1.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, -1, -1));

        txtSaldo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSaldo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldo1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtSaldo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 180, 60));

        lblSaldo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo1.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo1.setText("TURNO");
        jPanel1.add(lblSaldo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, -1, -1));

        txtNameCajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameCajero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameCajeroActionPerformed(evt);
            }
        });
        jPanel1.add(txtNameCajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 180, 60));

        lblSaldo2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo2.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo2.setText("SALDO FINAL");
        jPanel1.add(lblSaldo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 200, 60));

        lblSaldo3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo3.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo3.setText("EMPLEADO");
        jPanel1.add(lblSaldo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/reiniciar.png"))); // NOI18N
        btnRegresar.setPreferredSize(new java.awt.Dimension(150, 100));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, -1));

        btnReportes.setBackground(new java.awt.Color(255, 0, 0));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Menu/informe.png"))); // NOI18N
        btnReportes.setPreferredSize(new java.awt.Dimension(150, 100));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, -1, -1));

        lblSaldo4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo4.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo4.setText("SALDO INICIAL");
        jPanel1.add(lblSaldo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        lblSaldo5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo5.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo5.setText("CLIENTES");
        jPanel1.add(lblSaldo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        lblSaldo7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo7.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo7.setText("VENTAS");
        jPanel1.add(lblSaldo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, -1, -1));

        lblSaldo6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo6.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo6.setText("EMPLEADOS");
        jPanel1.add(lblSaldo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, -1));

        lblSaldo8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo8.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo8.setText("PRODUCTOS");
        jPanel1.add(lblSaldo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 80, -1));

        lblSaldo9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSaldo9.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo9.setText("REGRESAR");
        jPanel1.add(lblSaldo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, -1, -1));

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Background.jpg"))); // NOI18N
        lblbackground.setPreferredSize(new java.awt.Dimension(960, 610));
        jPanel1.add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        cx.conectar();
        cx.desconectar();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        int saldo = Integer.parseInt(txtSaldo.getText());
        if (!"".equalsIgnoreCase(txtSaldo.getText())) { // Asegurarse de que el campo no esté vacío
            if (saldo >= 500) { // Verificar si el saldo es mayor o igual a 500
                txtSaldo.setText(""); // Limpiar el campo de texto
                JOptionPane.showMessageDialog(this, "SE ABRIO TURNO EXITOSAMENTE"); // Mostrar mensaje de éxito
            } else {
                JOptionPane.showMessageDialog(this, "ES MENOR O MAYOR A LO ESPERADO | HABLA CON EL ENCARGADO"); // Mostrar mensaje de error
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void txtSaldo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldo1ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        int saldo = Integer.parseInt(txtSaldo1.getText());
        
        if(!"".equalsIgnoreCase(txtSaldo.getText())){
            if(saldo == 500){
                txtSaldo.setText("");
                JOptionPane.showMessageDialog(this,"SE CERRO TURNO EXITOSAMENTE");
            }else{
                JOptionPane.showMessageDialog(this,"DEJA SOLO 500 PESOS EN LA CAJA");
            }
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtNameCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameCajeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameCajeroActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        Crud_Clientes c = new Crud_Clientes(user);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        Crud_Empleados c = new Crud_Empleados(user);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        Crud_Productos c = new Crud_Productos(user);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        Crud_Ventas c = new Crud_Ventas(user);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Login c = new Login();
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        Reportes c = new Reportes(user);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReportesActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldo1;
    private javax.swing.JLabel lblSaldo2;
    private javax.swing.JLabel lblSaldo3;
    private javax.swing.JLabel lblSaldo4;
    private javax.swing.JLabel lblSaldo5;
    private javax.swing.JLabel lblSaldo6;
    private javax.swing.JLabel lblSaldo7;
    private javax.swing.JLabel lblSaldo8;
    private javax.swing.JLabel lblSaldo9;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JTextField txtNameCajero;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtSaldo1;
    // End of variables declaration//GEN-END:variables
}
