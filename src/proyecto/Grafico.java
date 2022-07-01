
package proyecto;

import com.panamahitek.ArduinoException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


public class Grafico extends javax.swing.JFrame {

    PanamaHitek_Arduino ino;
    public static int[] valores;
    private int indice;
    
    public Grafico() {
        initComponents();
        ino=new PanamaHitek_Arduino();
        valores=new int[10];//para cambiar o agregar mas valores
        indice =0;
        try {
            //en esta linea se hace la comunicacion con el arduino
            ino.arduinoRX("COM3",9600,listener);
        } catch (ArduinoException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    SerialPortEventListener listener=new SerialPortEventListener(){
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if(ino.isMessageAvailable()==true){
                   try{
                       //se agrega 
                       int bpm=Integer.parseInt(ino.printMessage());
                       System.out.println("BPM : "+bpm);
                       //System.out.println("valor actual : "+valores[indice]);
                       if(indice<10){
                       valores[indice]=bpm;
                       indice++;
                       }
                   }catch(Exception ex){
                   System.out.println("salto un error debido a: "+ ex.getMessage());
                   }
                    System.out.println("valores : " +Arrays.toString(valores));
                   // txtDato1.setText(ino.printMessage());
                    
                    
                }
                    txtDato1.setText(valores[0]+"");
                    txtDato2.setText(valores[1]+"");
                    txtDato3.setText(valores[2]+"");
                    txtDato4.setText(valores[3]+"");
                    txtDato5.setText(valores[4]+"");
                    txtDato6.setText(valores[5]+"");
                    txtDato7.setText(valores[6]+"");
                    txtDato8.setText(valores[7]+"");
                    txtDato9.setText(valores[8]+"");
                    txtDato10.setText(valores[9]+"");
                      
                    
            } catch (SerialPortException ex) {
                Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    };

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDato1 = new javax.swing.JTextField();
        txtDato2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGrafico = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDato3 = new javax.swing.JTextField();
        txtDato4 = new javax.swing.JTextField();
        txtDato5 = new javax.swing.JTextField();
        btncalcular = new javax.swing.JButton();
        txtDato6 = new javax.swing.JTextField();
        txtDato7 = new javax.swing.JTextField();
        txtDato8 = new javax.swing.JTextField();
        txtDato9 = new javax.swing.JTextField();
        txtDato10 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnGrafico = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtDato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));
        jPanel1.add(txtDato2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 60, -1));

        jLabel1.setText("DATO 1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setText("DATO 2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        btnGrafico.setText("Generar Grafico");
        btnGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel3.setText("DATO 3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        jLabel4.setText("DATO 4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel5.setText("DATO 5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));
        jPanel1.add(txtDato3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 60, -1));
        jPanel1.add(txtDato4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 50, -1));
        jPanel1.add(txtDato5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 60, -1));

        btncalcular.setText("SIGUIENTE");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        jPanel1.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 110, -1));
        jPanel1.add(txtDato6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, -1));

        txtDato7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDato7ActionPerformed(evt);
            }
        });
        jPanel1.add(txtDato7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 60, -1));
        jPanel1.add(txtDato8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 60, -1));
        jPanel1.add(txtDato9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 60, -1));
        jPanel1.add(txtDato10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 60, -1));

        jLabel6.setText("DATO 6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel7.setText("DATO 7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jLabel8.setText("DATO 8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jLabel9.setText("DATO 9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jLabel10.setText("DATO 10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        javax.swing.GroupLayout pnGraficoLayout = new javax.swing.GroupLayout(pnGrafico);
        pnGrafico.setLayout(pnGraficoLayout);
        pnGraficoLayout.setHorizontalGroup(
            pnGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );
        pnGraficoLayout.setVerticalGroup(
            pnGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficoActionPerformed
        XYSeries oSeries =new XYSeries("ritmo cardiaco");
         int dato1= Integer.parseInt(txtDato1.getText());
         int dato2= Integer.parseInt(txtDato2.getText());
         int dato3= Integer.parseInt(txtDato3.getText());
         int dato4= Integer.parseInt(txtDato4.getText());
         int dato5= Integer.parseInt(txtDato5.getText());
         int dato6= Integer.parseInt(txtDato6.getText());
         int dato7= Integer.parseInt(txtDato7.getText());
         int dato8= Integer.parseInt(txtDato8.getText());
         int dato9= Integer.parseInt(txtDato9.getText());
         int dato10= Integer.parseInt(txtDato10.getText());
                  
         oSeries.add(1,dato1);
         oSeries.add(2,dato2);
         oSeries.add(3,dato3);
         oSeries.add(4,dato4);
         oSeries.add(5,dato5);
         oSeries.add(6,dato6);
         oSeries.add(7,dato7);
         oSeries.add(8,dato8);
         oSeries.add(9,dato9);
         oSeries.add(10,dato10);
         
         
         XYSeriesCollection oDataset=new XYSeriesCollection();
         oDataset.addSeries(oSeries);
         
         JFreeChart oChart= ChartFactory.createXYLineChart("GRAFICA DE RITMO CARDIACO", "minutos","pulsos", oDataset);
         
         ChartPanel oPanel=new ChartPanel(oChart);
         pnGrafico.setLayout(new java.awt.BorderLayout());
         pnGrafico.add(oPanel);
         pnGrafico.validate();
         
        
        
    }//GEN-LAST:event_btnGraficoActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        this.setVisible(false);
        Calculando c =new Calculando();
        c.setLocationRelativeTo(null);
        c.setVisible(true);
    }//GEN-LAST:event_btncalcularActionPerformed

    private void txtDato7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDato7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDato7ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrafico;
    private javax.swing.JButton btncalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel pnGrafico;
    private javax.swing.JTextField txtDato1;
    private javax.swing.JTextField txtDato10;
    private javax.swing.JTextField txtDato2;
    private javax.swing.JTextField txtDato3;
    private javax.swing.JTextField txtDato4;
    private javax.swing.JTextField txtDato5;
    private javax.swing.JTextField txtDato6;
    private javax.swing.JTextField txtDato7;
    private javax.swing.JTextField txtDato8;
    private javax.swing.JTextField txtDato9;
    // End of variables declaration//GEN-END:variables
}
