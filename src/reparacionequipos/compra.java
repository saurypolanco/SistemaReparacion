/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static reparacionequipos.order.user;
import reportes.lista_compra;
import reportes.lista_orden;


public class compra extends javax.swing.JFrame {


    public compra() {
        initComponents();
    }
    int total = 0;
    void imprimir_compras() {

        ArrayList lista = new ArrayList();

        for (int i = 0; i < order_detail.getRowCount(); i++) {

             lista_compra mortizar = new lista_compra(Integer.parseInt(order_detail.getValueAt(i,0 ).toString()), order_detail.getValueAt(i,1 ) + "", order_detail.getValueAt(i, 2) + "",order_detail.getValueAt(i, 3) + "",
                    order_detail.getValueAt(i, 4) + "");
            lista.add(mortizar);
        }
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile("imprimir_compras.jasper");

            HashMap parametro = new HashMap();
            parametro.put("empresa", "JsVestiment");
            parametro.put("direccion", "Santiago de los caballeros, Tamboril c/ Real no. 14 ");
            parametro.put("totalf", totalf.getText());
            parametro.put("article", article.getText());
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, new JRBeanCollectionDataSource(lista));
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR\n" + ex.getMessage());
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        customer = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        order_detail = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        thisDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        article = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        precio_compra = new javax.swing.JTextField();
        precio_venta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        add_detail = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        totalf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Proveedor");

        order_detail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        order_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo", "Precio Compra", "Precio Venta", "Cantidad", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        order_detail.setToolTipText("");
        order_detail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        order_detail.setRowHeight(18);
        order_detail.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(order_detail);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");

        thisDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Artículo:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Precio Compra:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Precio Venta:");

        precio_compra.setText("0.00");
        precio_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio_compraActionPerformed(evt);
            }
        });

        precio_venta.setText("0.00");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Descripción:");

        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionActionPerformed(evt);
            }
        });

        add_detail.setBackground(new java.awt.Color(0, 69, 173));
        add_detail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add_detail.setForeground(new java.awt.Color(255, 255, 255));
        add_detail.setText("Agregar");
        add_detail.setBorder(null);
        add_detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_detailMouseClicked(evt);
            }
        });
        add_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_detailActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 201, 87));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Efectuar Compra");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(222, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Limpiar");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 25, 242));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad:");

        cantidad.setName(""); // NOI18N

        totalf.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalf.setText("0.0");
        totalf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalfActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224)
                .addComponent(jLabel2)
                .addGap(76, 76, 76)
                .addComponent(thisDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_detail, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(totalf, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel9)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(thisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void precio_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio_compraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio_compraActionPerformed

    private void add_detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_detailMouseClicked

    }//GEN-LAST:event_add_detailMouseClicked

    private void add_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_detailActionPerformed
        if(article.getText().trim() == "" ){
            JOptionPane.showMessageDialog(null, "Debe digitar un artículo para proceder");
            return;
        }else if(cantidad.getText().trim() == "" ){
            JOptionPane.showMessageDialog(null, "Debe digitar  una cantidad para proceder");
            return;
        }else if(precio_compra.getText().trim()== "" ){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un diagnostico para proceder");
            return;
        }else if(precio_venta.getText().trim()== "" ){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un diagnostico para proceder");
            return;
        }
        else if(description.getText().trim() == "" ){
            JOptionPane.showMessageDialog(null, "Debe escribir una descripcion para proceder");
            return;
        }else{
        total += Integer.parseInt(cantidad.getText().trim()) * Integer.parseInt(precio_compra.getText().trim());
        DefaultTableModel tmodel = (DefaultTableModel)order_detail.getModel();
        tmodel.addRow(new Object[]{article.getText(),precio_compra.getText(),precio_venta.getText(), cantidad.getText(), description.getText()});
        totalf.setText(total+"");
        } 
    }//GEN-LAST:event_add_detailActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
        Object article, precio_compra, precio_venta,cantidad , description;
        conexion con = new conexion();
        String values = "";
        int order=0;
        float total_price = 0;
        ResultSet rs;
        if(order_detail.getRowCount() > 0){
            try{
                values += "'" + customer.getSelectedItem().toString().split("-")[0].trim() + "'";
                values += ",(SELECT ID_PER FROM USUARIO WHERE USER_NAME = '" + user + "')";
                values += ", STR_TO_DATE('"+thisDate.getText().trim()+"','%d/%m/%Y') ";
                values += ",'0.00'";
                con.insert("compra(id_tercero,id_user, fecha, total)", values);
                rs = con.query("compra, usuario WHERE compra.id_user = USUARIO.id_per AND usuario.user_name = '"+user+"'","id_per");
                while(rs.next()){
                    order = rs.getInt(1);
                }

            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al procesar la transacción " + e.getMessage());
                return;
            }finally{
                values = "";
            }
            for(int x = 0; x < dtm.getDataVector().size(); x++){
                article = order_detail.getValueAt(x, 0).toString().toUpperCase();
                precio_compra = order_detail.getValueAt(x, 1).toString().toUpperCase();
                precio_venta = order_detail.getValueAt(x, 2).toString().toUpperCase();
                cantidad = order_detail.getValueAt(x, 3).toString().toUpperCase();
                description = order_detail.getValueAt(x, 4).toString().toUpperCase();
             
                total_price += Float.parseFloat(precio_compra.toString());
                values = order+", '"+article+"', '"+ precio_compra +"', '"+ precio_venta+"', '"+cantidad+"','"+ (Integer.parseInt(precio_compra.toString().trim())*Integer.parseInt(cantidad.toString().trim())) +"','"+description+"'";
                try {
                    con.insert("detalle_compra(num_compra, articulo, precio_compra,precio_venta,cantidad,subtotal,descripcion)",values);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al procesar la transaccion " + e.getMessage());
                }   
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "La compra no cuenta con equipos para reparar");
        }
        imprimir_compras();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
        for(int i = 0 ; i < dtm.getRowCount(); i++){
            total -= Integer.parseInt(dtm.getValueAt(i, 1).toString().trim()) * Integer.parseInt(dtm.getValueAt(i, 3).toString().trim());
            dtm.removeRow(0);
        }       
        totalf.setText(total+"");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dashboard db = new dashboard();
        db.show();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String this_date;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime ldt = LocalDateTime.now();
        this_date = dtf.format(ldt);
        thisDate.setText(this_date);
        conexion con = new conexion();
        
        try{
            user = loginForm.username.toUpperCase();
        }catch(Exception e){
            user = "ADMIN";
        }
       
        try {
            ResultSet rs = con.query("persona","id_per, concat(nombre,' ',apellido) nombre");
            customer.removeAllItems();
            while(rs.next()){
                customer.addItem(rs.getString(1)+" - "+ rs.getString(2));
            }
            
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de recuperar los datos");
        }finally{
            con.closeConection();
        }
    }//GEN-LAST:event_formWindowOpened

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionActionPerformed

    private void totalfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalfActionPerformed

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
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_detail;
    private javax.swing.JTextField article;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> customer;
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable order_detail;
    private javax.swing.JTextField precio_compra;
    private javax.swing.JTextField precio_venta;
    private javax.swing.JFormattedTextField thisDate;
    private javax.swing.JTextField totalf;
    // End of variables declaration//GEN-END:variables
}
