
package proyecto;

import Base_Datos.Manejador_BD;
import static groovyjarjarantlr.Utils.error;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static org.jfree.util.Log.error;
import java.util.Random;

public class RegistroPaciente extends javax.swing.JFrame {

    Paciente paciente;
     Manejador_BD manejador_BD;
    public RegistroPaciente() {
        initComponents();
        manejador_BD =new Manejador_BD();
        paciente =new Paciente();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtSiguiente = new javax.swing.JButton();
        txtGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 300));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE PACIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NOMBRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("APELLIDOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("EDAD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 150, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 150, -1));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 80, -1));

        txtSiguiente.setText("SIGUIENTE");
        txtSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        txtGuardar.setText("GUARDAR");
        txtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(txtGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSiguienteActionPerformed
        this.setVisible(false);
        Grafico g=new Grafico();
        g.setLocationRelativeTo(null);
        g.setVisible(true);
    }//GEN-LAST:event_txtSiguienteActionPerformed

    private void txtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarActionPerformed
        
         String nombre=this.txtNombre.getText();
         String apellido=this.txtApellido.getText();
         int numeroDeRegistros=0;
         int edad=Integer.parseInt(this.txtEdad.getText());
         Random rand = new Random();
         int maxNumber = 10000;
         int randomID = rand.nextInt(maxNumber) + 1;

       try{
        manejador_BD.conectarseBD();
        
        manejador_BD.insertarDB("Insert into paciente(nombre_paci,apellido_paci,edad_paci) values('"+ nombre +"','"+ apellido +"',"+ edad + ")");
          
        ResultSet registro=manejador_BD.consultarDB("select * from paciente where nombre_paci = '" + nombre +"'and apellido_paci='"+apellido +"'");
        if (registro.next()==true){
           int idPaciente= registro.getInt("id_paciente");
        paciente.setId_paciente(idPaciente);
        paciente.setNombre_paciente(nombre + " " +apellido);
        paciente.setEdad_paciente(edad);
        
        
        }
        manejador_BD.cerrarConexionBD();
        
        JOptionPane.showMessageDialog(null,"se resgistro correctamente");
        this.setVisible(false);
        Grafico grafico=new Grafico();
        grafico.setLocationRelativeTo(null);
        grafico.setVisible(true);
        }catch(Exception error){
            
         System.out.println("error" + error.getMessage());
        }
       
    }//GEN-LAST:event_txtGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JButton txtGuardar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JButton txtSiguiente;
    // End of variables declaration//GEN-END:variables
}
