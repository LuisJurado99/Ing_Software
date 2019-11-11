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
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author luisj
 */
public class modificarcapturador extends javax.swing.JFrame {
    Connection con=app.conex.getConection();    
    int asistencias =10;
    int faltas=5;
    DefaultTableModel modelo = new DefaultTableModel();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    Date dateVieja = new Date();
    /**
     * Creates new form modificartodos
     */
    public modificarcapturador() {
        initComponents();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jtModificar.setModel(modelo);
            PreparedStatement ps;
            ResultSet rs;
            
            String sql_capturador = "SELECT id_capt, nombre, apellido, asistencia, estatus FROM capturador";
            ps = con.prepareStatement(sql_capturador);
            rs = ps.executeQuery();
            ResultSetMetaData rSMd = rs.getMetaData();
            int cantidadcolumnas = rSMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("ASIS");
            modelo.addColumn("ESTATUS");
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
        labelHora.setText(dateFormat.format(date));
        grupobotones.add(btnAsistencia);
        grupobotones.add(btnFalta);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtModificar = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JRadioButton();
        btnFalta = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnRegistrarAsistenia = new javax.swing.JButton();
        labelHora = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();

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

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/guardar_icon.png"))); // NOI18N
        btnModificar.setText("Guardar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAsistencia.setText("Asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        btnFalta.setText("Falta");

        jLabel4.setText("ID");

        txtid.setEditable(false);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/atras_icon.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnRegistrarAsistenia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unam/imagenes/comprobado_icon.png"))); // NOI18N
        btnRegistrarAsistenia.setText("Registrar Asistencia");
        btnRegistrarAsistenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAsisteniaActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel2)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)))
                                        .addGap(77, 77, 77))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAsistencia)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnFalta))
                                        .addGap(0, 89, Short.MAX_VALUE))
                                    .addComponent(btnRegistrarAsistenia, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(btnBorrar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHora)
                            .addComponent(btnRegresar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(labelHora))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnAsistencia))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFalta))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModificar)
                                    .addComponent(btnRegistrarAsistenia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        PreparedStatement ps = null;
        ResultSet rs = null;
        int Fila = jtModificar.getSelectedRow();
        try{
                ps = con.prepareStatement("UPDATE capturador SET nombre=?, apellido=? WHERE id_capt=?");
                ps.setString(1, txtNombre.getText().toUpperCase());
                ps.setString(2, txtApellido.getText().toUpperCase());
                ps.setString(3, txtid.getText());
                ps.execute();

                JOptionPane.showMessageDialog(null, "Producto Modificado");
                jtModificar.setValueAt(txtNombre.getText().toUpperCase(), Fila, 1);
                jtModificar.setValueAt(txtApellido.getText().toUpperCase(), Fila, 2);
            
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
            System.out.println(ex);
            }
         

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void jtModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtModificarMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            
            int Fila = jtModificar.getSelectedRow();
            String codigo = jtModificar.getValueAt(Fila, 0).toString();

            ps = con.prepareStatement("SELECT id_capt,nombre,apellido, asistencia, faltas, fecha_actualizacion FROM capturador WHERE id_capt=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                asistencias = rs.getInt("asistencia");
                faltas = rs.getInt("faltas");
                txtApellido.setText(rs.getString("apellido"));
                txtNombre.setText(rs.getString("nombre"));
                txtid.setText(rs.getString("id_capt"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtModificarMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        supervisorframe spu = new supervisorframe();
        spu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarAsisteniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAsisteniaActionPerformed
        PreparedStatement ps = null;
        java.sql.Date datetemp = new java.sql.Date(date.getTime());
        if (asistencias ==3){
            try {
                ps = con.prepareStatement("UPDATE capturador SET bonos_asistencia= ? WHERE id_capt=?");
                ps.setFloat(1, (float)300.0);
                ps.setString(2, txtid.getText());
                ps.execute();
                
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }
        }
        if(btnAsistencia.isSelected()){
            try {

                ps = con.prepareStatement("UPDATE capturador SET asistencia = ?, fecha_actualizacion=? WHERE id_capt=?");
                ps.setInt(1,asistencias+1);
                ps.setDate(2, datetemp);
                ps.setString(3, txtid.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Asistencia Actualizada");
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }
        }
        if (btnFalta.isSelected()){
            try {
                ps = con.prepareStatement("UPDATE capturador SET faltas = ? WHERE id_capt=?");
                ps.setInt(1,faltas+1);
                ps.setString(2, txtid.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Faltas Actualizada");
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }

        }
        
        
        if (faltas==2){
            try {
                ps = con.prepareStatement("UPDATE capturador SET descuentos_faltas= ? WHERE id_capt=?");
                ps.setFloat(1, (float)350.0);
                ps.setString(2, txtid.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null,"El usuario:"+txtNombre.getText()+" "+txtApellido.getName()+".\n"
                            + "Se le han descontado $300.0por faltas");
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }
        }else if (faltas>=3) {
            try {
                ps = con.prepareStatement("UPDATE capturador SET estatus=? WHERE id_capt=?");
                ps.setBoolean(1, false);
                ps.setString(2, txtid.getText());
                JOptionPane.showMessageDialog(null,"El usuario:"+txtNombre.getText()+" "+txtApellido.getName()+"Se ha dado de baja debido"+
                        "a las faltas");
                ps.execute();

            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }
        }

        if (!btnAsistencia.isSelected() && !btnFalta.isSelected()){
            JOptionPane.showMessageDialog(null, "No registraste ninguna opcion");
        }
    }//GEN-LAST:event_btnRegistrarAsisteniaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        PreparedStatement ps = null;
       
        int Fila = jtModificar.getSelectedRow();
        String codigo = jtModificar.getValueAt(Fila, 0).toString();
        try{
            ps = con.prepareStatement("DELETE FROM capturador WHERE id_capt=?");
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
            java.util.logging.Logger.getLogger(modificarcapturador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarcapturador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarcapturador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarcapturador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarcapturador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAsistencia;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JRadioButton btnFalta;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrarAsistenia;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup grupobotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtModificar;
    private javax.swing.JLabel labelHora;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
