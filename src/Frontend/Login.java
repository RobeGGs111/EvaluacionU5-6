
package Frontend;

import Backend.CLogin;
import Backend.Conexion;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    Conexion cx;
    
    public Login() {
        initComponents();
        //El JFrame este centrado
        setLocationRelativeTo(null);
        //El JFrame tenga un tama;o fijo
        this.setSize(900, 600);
        //El usuario no pueda modificar el tama;o del JFrame
        this.setResizable(false);
        
        cx = new Conexion("Costco");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN - COSTCO");
        setForeground(java.awt.Color.white);
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Login/Logo (1).png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Contraseña:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, 50));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 180, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 120, 40));
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 180, 50));

        btnLogin.setBackground(new java.awt.Color(255, 51, 51));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Iniciar Sesion");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 130, 50));

        btnSalir.setBackground(new java.awt.Color(0, 102, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("CLICK");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 490, 100, 60));

        btnSalir1.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir1.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir1.setText("CLOSE");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 100, 60));

        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Img-Login/cuadro.png"))); // NOI18N
        jPanel1.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 620, 400));

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Background.jpg"))); // NOI18N
        lblbackground.setText("jLabel1");
        lblbackground.setPreferredSize(new java.awt.Dimension(950, 600));
        jPanel1.add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = txtUser.getText();
         String pas=new String(jPassword.getPassword());
         CLogin log = new CLogin();
         if(user.isEmpty()|| pas.isEmpty()){
             
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!");
            
         }
         else{
            if( log.login(user, pas) ){
                
                JOptionPane.showMessageDialog(this,"Inicio de sesion exitoso!");
                Menu menu = new Menu(txtUser.getText());
                menu.setVisible(true);
                this.setVisible(false);
            }
            else{
                
                JOptionPane.showMessageDialog(this,"El usuario y/o contraseña son incorrectos!");
                             
            }
         }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        JOptionPane.showMessageDialog(this,"BASES DE DATOS ASI DE GRANDES GERMAN!!");
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        cx.conectar();
        cx.desconectar();
        System.exit(0);
    }//GEN-LAST:event_btnSalir1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
