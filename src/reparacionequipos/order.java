package reparacionequipos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reportes.lista_orden;


public class order extends javax.swing.JFrame {
    public static  String user;

    public order() {
        initComponents();
    }
    
       void imprimir_orden() {

        ArrayList lista = new ArrayList();

        for (int i = 0; i < order_detail.getRowCount(); i++) {

            lista_orden mortizar = new lista_orden(order_detail.getValueAt(i,0 ) + "", order_detail.getValueAt(i,1 ) + "", order_detail.getValueAt(i, 2) + "",
                    order_detail.getValueAt(i, 3) + "");
            lista.add(mortizar);
        }
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile("imprimir_orden.jasper");

            HashMap parametro = new HashMap();
            parametro.put("empresa", "JsVestiment");
            parametro.put("direccion", "Santiago de los caballeros, Tamboril c/ Real no. 14 ");
            parametro.put("price", price.getText());
            parametro.put("diagnostic", diagnostic.getSelectedItem().toString());
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

        thisDate = new javax.swing.JFormattedTextField();
        customer = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        order_detail = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        serial_Number = new javax.swing.JTextField();
        add_detail = new javax.swing.JButton();
        add_detail1 = new javax.swing.JButton();
        order_type = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        diagnostic = new javax.swing.JComboBox<>();
        article = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                loadData(evt);
            }
        });

        thisDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");

        order_detail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        order_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo", "Serial", "Diagnóstico", "Descripcion de problema", "Precio"
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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Artículo:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Diagnostico:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Precio:");

        price.setText("0.00");
        price.setNextFocusableComponent(description);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Descripción:");

        description.setNextFocusableComponent(add_detail);

        jButton1.setBackground(new java.awt.Color(51, 201, 87));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Efectuar Orden");
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

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Serial del equipo:");

        serial_Number.setNextFocusableComponent(diagnostic);

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

        add_detail1.setBackground(new java.awt.Color(206, 1, 0));
        add_detail1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add_detail1.setForeground(new java.awt.Color(255, 255, 255));
        add_detail1.setText("Eliminar");
        add_detail1.setBorder(null);
        add_detail1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_detail1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Tipo de orden:");

        diagnostic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diagnosticMouseClicked(evt);
            }
        });
        diagnostic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosticActionPerformed(evt);
            }
        });

        article.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                articleMouseClicked(evt);
            }
        });
        article.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(diagnostic, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(serial_Number)
                                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(add_detail1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(add_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(388, 388, 388))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(order_type, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(thisDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(order_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(diagnostic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(serial_Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                    .addComponent(add_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(add_detail1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadData(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_loadData
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
            
            rs = con.query("tipo WHERE GRPTIPO = 'MANT'","id_tipo, tipo");
            order_type.removeAllItems();
            while(rs.next()){
                order_type.addItem(rs.getString(1)+" - "+ rs.getString(2));
            }
            
            rs = con.query("diagnostico","concat(id_diagnostico,' - ',nombre) nombre" );
            diagnostic.removeAllItems();
            while(rs.next()){
                diagnostic.addItem(rs.getString(1));
            }
            
            rs = con.query("equipo","concat(id_equipo,' - ',nombre) nombre" );
            article.removeAllItems();
            while(rs.next()){
                article.addItem(rs.getString(1));
            }
           // con.query("diagnostico","precio");
           // price.setText(con.query("diagnostico","precio"));
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de recuperar los datos");
        }finally{
            con.closeConection();
        }
    }//GEN-LAST:event_loadData

    private void add_detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_detailMouseClicked

    }//GEN-LAST:event_add_detailMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dashboard db = new dashboard();
        db.show();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void add_detail1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_detail1MouseClicked
        DefaultTableModel model = (DefaultTableModel) order_detail.getModel();
        model.removeRow(this.order_detail.getSelectedRow());
    }//GEN-LAST:event_add_detail1MouseClicked

    private void add_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_detailActionPerformed
                
        if(article.getSelectedItem().toString().trim() == "" ){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un artículo para proceder");
            return;
        }else if(serial_Number.getText().trim() == "" ){
            JOptionPane.showMessageDialog(null, "Debe escribir un serial para proceder");
            return;
        }else if(diagnostic.getSelectedItem()== "" ){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un diagnostico para proceder");
            return;
        }else if(description.getText().trim() == "" ){
            JOptionPane.showMessageDialog(null, "Debe escribir una descripcion para proceder");
            return;
        }
        
        DefaultTableModel tmodel = (DefaultTableModel)order_detail.getModel();
        tmodel.addRow(new Object[]{article.getSelectedItem().toString(),serial_Number.getText(),diagnostic.getSelectedItem().toString(), description.getText(), price.getText()});
        
    }//GEN-LAST:event_add_detailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
        Object article, serial, diagnostic, price, description;
        conexion con = new conexion();
        String values = "";
        int order=0;
        float total_price = 0;
        ResultSet rs;
        if(order_detail.getRowCount() > 0){
            try{
                values += "'" + customer.getSelectedItem().toString().split("-")[0].trim() + "'";
                values += ",(SELECT ID_PER FROM USUARIO WHERE USER_NAME = '" + user + "')";
                values += ",'" + order_type.getSelectedItem().toString().split("-")[0].trim() + "'";
                values += ", STR_TO_DATE('"+thisDate.getText().trim()+"','%d/%m/%Y') ";
                values += ",'0.00'";
                con.insert("orden(id_cliente, id_user, id_tipo, fecha, subtotal)", values);
           
                
                rs = con.query("ORDEN, usuario WHERE ORDEN.id_user = USUARIO.id_per AND usuario.user_name = '"+user+"'","id_orden");
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
                article = order_detail.getValueAt(x, 0).toString().split("-")[0].trim().toUpperCase();
                serial = order_detail.getValueAt(x, 1).toString().toUpperCase();
                diagnostic = order_detail.getValueAt(x, 2).toString().split("-")[0].trim().toUpperCase();
                description = order_detail.getValueAt(x, 3);
                price = order_detail.getValueAt(x, 4).toString().toUpperCase();
                total_price += Float.parseFloat(price.toString());
                values = order+", "+(x+1)+", '"+article+"', '"+ serial +"', '"+ diagnostic +"', '"+description+"'";
                
                try {
                    con.insert("detalle_orden(id_orden, item, id_equipo, serial, diagnostico, descripcion)",values);
            
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al procesar la transaccion " + e.getMessage());
                }
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "La orden no cuenta con equipos para reparar");
        }
           imprimir_orden();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
        for(int i = 0 ; i < dtm.getRowCount(); i++){
            dtm.removeRow(0);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void diagnosticMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diagnosticMouseClicked
       // conexion con = new conexion();
        
        //price.setText(diagnostic.getSelectedItem().toString());
         

      //   rs = con.query(" diagnostico WHERE  );
    }//GEN-LAST:event_diagnosticMouseClicked

    private void diagnosticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosticActionPerformed
        conexion con = new conexion();
        String values ="";
        conexion conn = new conexion();
          values =  diagnostic.getSelectedItem().toString() ;
          
        try {
            ResultSet rs = conn.query("diagnostico  WHERE nombre ='" + values.split("-")[1].trim()+"'" , "precio");
            while(rs.next()){
                    price.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(singUpEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
        // values += ",(SELECT precio FROM diagnostico WHERE nombre = '" + diagnostic.getSelectedItem().toString() + "')";
         
        // price.setText(values);*/
    }//GEN-LAST:event_diagnosticActionPerformed

    private void articleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_articleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_articleMouseClicked

    private void articleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_articleActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_detail;
    private javax.swing.JButton add_detail1;
    private javax.swing.JComboBox<String> article;
    private javax.swing.JComboBox<String> customer;
    private javax.swing.JTextField description;
    private javax.swing.JComboBox<String> diagnostic;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable order_detail;
    private javax.swing.JComboBox<String> order_type;
    private javax.swing.JTextField price;
    private javax.swing.JTextField serial_Number;
    private javax.swing.JFormattedTextField thisDate;
    // End of variables declaration//GEN-END:variables
}
