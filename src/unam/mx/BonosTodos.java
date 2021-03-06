/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luisj
 */
public class BonosTodos extends javax.swing.JFrame {
    Connection con=app.conex.getConection();    
    /**
     * Creates new form BonosCapturador
     */
    public BonosTodos() throws SQLException {
        initComponents();
        
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
        btnBonoMultas = new javax.swing.JButton();
        txtBono = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBonoMultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/pesos_icon.png"))); // NOI18N
        btnBonoMultas.setText("Bono por Multas");
        btnBonoMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBonoMultasActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/atras_icon.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(txtBono, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnBonoMultas)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBonoMultas)
                    .addComponent(txtBono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btnRegresar)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBonoMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBonoMultasActionPerformed
        PreparedStatement ps;
        ResultSet rs;
        int conteocapturador=0, conteosupervisor=0, conteorecepcion=0;
        float bonoTotal = Float.parseFloat(txtBono.getText());
        float bonocapturador = (float) (bonoTotal*0.35);
        float bonorecepcion =  (float)(bonoTotal*0.35);
        float bonosupervisor = (float) (bonoTotal * 0.30);
        if (!"".equals(txtBono.getText())) {
            try {
                ps = con.prepareStatement("SELECT count(nombre) as conteo FROM capturador WHERE estatus = '1'");
                rs = ps.executeQuery();
                if (rs.next()) {
                    conteocapturador = rs.getInt("conteo");
                }
                rs.close();

                ps = con.prepareStatement("SELECT count(nombre) as conteo FROM recepcion WHERE estatus = '1'");
                rs = ps.executeQuery();
                if (rs.next()) {
                    conteorecepcion = rs.getInt("conteo");
                }
                rs.close();
                ps = con.prepareStatement("SELECT count(nombre) as conteo FROM supervisor");
                rs = ps.executeQuery();
                if (rs.next()) {
                    conteosupervisor = rs.getInt("conteo");
                }
                rs.close();
                ps = con.prepareStatement("UPDATE capturador SET bonos_multas=? ");
                ps.setFloat(1, bonocapturador / conteocapturador);
                ps.execute();
                ps = con.prepareStatement("UPDATE recepcion SET bonos_multas=? ");
                ps.setFloat(1, bonorecepcion / conteorecepcion);
                ps.execute();
                ps = con.prepareStatement("UPDATE supervisor SET bono_multas=?");
                ps.setFloat(1, bonosupervisor / conteosupervisor);
                ps.execute();
                actualizarSueldo();
                JOptionPane.showMessageDialog(null, "Se Actualizaron los Bonos por Multas");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se pudieron actualiar los Bonos");
                Logger.getLogger(BonosTodos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            JOptionPane.showMessageDialog(null, "No Ingresaste Una Cantidad");
        }
        
    }//GEN-LAST:event_btnBonoMultasActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        supervisorframe supee = new supervisorframe();
        supee.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void actualizarSueldo() throws SQLException{
        PreparedStatement ps, ps2;
        ResultSet rs;
        //actualiza sueldo del capturador
        ps = con.prepareStatement("SELECT id_capt, bonos_asistencia, bonos_multas, faltas_descuento,salario,(bonos_asistencia+bonos_multas"
                + "-faltas_descuento+salario) as suma FROM capturador");
        rs = ps.executeQuery();
        while(rs.next()){
            ps2 = con.prepareStatement("UPDATE capturador SET sueldo_total=? WHERE id_capt=?");
            ps2.setFloat(1, rs.getFloat("suma"));
            ps2.setString(2,rs.getString("id_capt"));
            ps2.execute();
            
        }
        rs.close();
        //actualiza sueldo del recepcionista
        ps = con.prepareStatement("SELECT id_recp, bonos_asistencia, bonos_multas, faltas_descuento,salario,(bonos_asistencia+bonos_multas- faltas_descuento"
                + "+salario) as suma FROM recepcion");
        rs = ps.executeQuery();
        while(rs.next()){
            ps2 = con.prepareStatement("UPDATE recepcion SET sueldo_total=? WHERE id_recp=?");
            ps2.setFloat(1, rs.getFloat("suma"));
            ps2.setString(2,rs.getString("id_recp"));
            ps2.execute();
            
        }
        rs.close();
        ps = con.prepareStatement("SELECT id_sup,salario,bono_multas,(bono_multas+salario) as suma FROM supervisor");
        rs = ps.executeQuery();
        while(rs.next()){
            ps2 = con.prepareStatement("UPDATE supervisor SET sueldo=? WHERE id_sup=?");
            ps2.setFloat(1, rs.getFloat("suma"));
            ps2.setString(2,rs.getString("id_sup"));
            ps2.execute();
            
            
        }
        rs.close();
    }
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
            java.util.logging.Logger.getLogger(BonosTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BonosTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BonosTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BonosTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BonosTodos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BonosTodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBonoMultas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBono;
    // End of variables declaration//GEN-END:variables
}
