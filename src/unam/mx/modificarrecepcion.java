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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisj
 */
public class modificarrecepcion extends javax.swing.JFrame {
    Connection con=app.conex.getConection();
    int asistencia=0;
    int faltas=0;
    DefaultTableModel modelo = new DefaultTableModel();
    DateFormat dateFromat = new SimpleDateFormat("yyyy/mm/dd");
    Date date = new Date();
    
    /**
     * Creates new form modificartodos
     */
    public modificarrecepcion() {
        initComponents();
        cargarTabla();
        labelHora.setText(dateFromat.format(date));
        grupobotones.add(buttonAsistencia);
        grupobotones.add(buttonFalta);
        
    }
    
public void cargarTabla(){
    try {
            
            jtModificar.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;
            
            String sql_capturador = "SELECT id_recp, nombre, apellido, asistencia, faltas, estatus FROM recepcion";
            ps = con.prepareStatement(sql_capturador);
            rs = ps.executeQuery();
            
            ResultSetMetaData rSMd = rs.getMetaData();
            int cantidadcolumnas = rSMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("ASISTENCIA");
            modelo.addColumn("FALTAS");
            modelo.addColumn("ESTATUS");
            int[] anchos= {50,130,130,130, 100, 80};
            for (int i = 0; i < jtModificar.getColumnCount(); i++) {
                jtModificar.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            while(rs.next()){
                Object[] filas  = new Object[cantidadcolumnas];
                for (int i = 0; i < cantidadcolumnas; i++) {
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
        }            
        }catch (SQLException e) {
            System.out.println("Error: "+e);
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotones = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtModificar = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        buttonAsistencia = new javax.swing.JRadioButton();
        buttonFalta = new javax.swing.JRadioButton();
        labelID = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnRegistrarAsistencia = new javax.swing.JButton();
        labelHora = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtModificar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtModificarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtModificar);

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("Asistencia");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/guardar_icon.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        buttonAsistencia.setText("Asistencia");
        buttonAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAsistenciaActionPerformed(evt);
            }
        });

        buttonFalta.setText("Falta");

        labelID.setText("ID");

        txtid.setEditable(false);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/atras_icon.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnRegistrarAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/comprobado_icon.png"))); // NOI18N
        btnRegistrarAsistencia.setText("Registrar Asistencia");
        btnRegistrarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAsistenciaActionPerformed(evt);
            }
        });

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/borrar_icon.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelHora)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGuardar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRegistrarAsistencia))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(labelID))
                                                .addGap(69, 69, 69)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(buttonFalta, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(buttonAsistencia, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(btnBorrar)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(labelHora))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(buttonAsistencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFalta)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnRegistrarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int Fila = jtModificar.getSelectedRow();

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE recepcion SET nombre=?, apellido=? WHERE id_recp=?");

            ps.setString(1, txtNombre.getText().toUpperCase());
            ps.setString(2, txtApellido.getText().toUpperCase());
            ps.setString(3, txtid.getText());
            

            ps.execute();

            JOptionPane.showMessageDialog(null, "Datos Guardados");
            jtModificar.setValueAt(txtNombre.getText().toUpperCase(), Fila, 1);
            jtModificar.setValueAt(txtApellido.getText().toUpperCase(), Fila, 2);
            txtApellido.setText("");
            txtNombre.setText("");
            txtid.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar");
            System.out.println(ex);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void buttonAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAsistenciaActionPerformed

    private void jtModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtModificarMouseClicked
        
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            int Fila = jtModificar.getSelectedRow();
            String codigo = jtModificar.getValueAt(Fila, 0).toString();

            ps = con.prepareStatement("SELECT id_recp,nombre,apellido, asistencia, faltas, fecha_actualizacion FROM recepcion WHERE id_recp=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                faltas = rs.getInt("faltas");
                asistencia = rs.getInt("asistencia");
                txtApellido.setText(rs.getString("apellido"));
                txtNombre.setText(rs.getString("nombre"));
                txtid.setText(rs.getString("id_recp"));
                
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        int Fila = jtModificar.getSelectedRow();
        jtModificar.setValueAt(asistencia, Fila, 3);
    }//GEN-LAST:event_jtModificarMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       supervisorframe spu = new supervisorframe();
       spu.setVisible(true);
       
       this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAsistenciaActionPerformed
        PreparedStatement ps = null;
                    int Fila = jtModificar.getSelectedRow();
        if(buttonAsistencia.isSelected()){
            try{
                ps = con.prepareStatement("UPDATE recepcion SET asistencia = ? WHERE id_recp=?");
                ps.setInt(1,asistencia+1);
                ps.setString(2, txtid.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Asistencia Actualizada");
                
                jtModificar.setValueAt(asistencia+1, Fila, 3);
                if (asistencia>=5){
                ps = con.prepareStatement("UPDATE recepcion SET bonos_asistencia = ? WHERE id_recp=?");
                ps.setFloat(1,(float) 300.0);
                ps.setString(2, txtid.getText());
                ps.execute();
                }
            }catch(Exception e ){
                    System.out.println("Error: "+e);
            }
        }
        
        if(buttonFalta.isSelected()){
            try{
                ps = con.prepareStatement("UPDATE recepcion SET faltas = ? WHERE id_recp=?");
                ps.setInt(1, faltas+1);
                ps.setString(2, txtid.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Faltas Actualizada");
                if (faltas==2) {
                ps=con.prepareStatement("UPDATE recepcion SET faltas_descuento=? WHERE id_recp=?");
                ps.setFloat(1, 300);
                ps.setString(2,txtid.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null, "El usuario:" + txtNombre.getText() + " " + txtApellido.getName() + ".\n"
                                + "Se le han descontado $300.0por faltas");
                }
                if (faltas >= 3) {
                        ps = con.prepareStatement("UPDATE recepcion SET estatus=? WHERE id_recp=?");
                        ps.setBoolean(1, false);
                        ps.setString(2, txtid.getText());
                        JOptionPane.showMessageDialog(null, "El usuario:" + txtNombre.getText() + " " + txtApellido.getName() + "Se ha dado de baja debido"
                                + "a las faltas");
                        ps.execute();
                }
            }catch(Exception e ){
                System.out.println("Error: "+e);
            }

            jtModificar.setValueAt(faltas+1, Fila, 4);
        }
        
        if (!buttonAsistencia.isSelected() && !buttonFalta.isSelected()){
            JOptionPane.showMessageDialog(null, "No registraste ninguna opcion");
        }   
        
    }//GEN-LAST:event_btnRegistrarAsistenciaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        PreparedStatement ps = null;
       
        int Fila = jtModificar.getSelectedRow();
        String codigo = jtModificar.getValueAt(Fila, 0).toString();
        try{
            ps = con.prepareStatement("DELETE FROM recepcion WHERE id_recp=?");
            ps.setString(1, codigo);
            ps.execute();
            modelo.removeRow(Fila);
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se pudo borrar el elemento ");
        }
        txtNombre.setText("");
        txtApellido.setText("");
        
    }//GEN-LAST:event_btnBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(modificarrecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarrecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarrecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarrecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarrecepcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrarAsistencia;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JRadioButton buttonAsistencia;
    private javax.swing.JRadioButton buttonFalta;
    private javax.swing.ButtonGroup grupobotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jtModificar;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel labelID;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
