package reparacionequipos;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import reportes.lista_factura;
import reportes.lista_orden;


public class bill extends javax.swing.JFrame {
    int v_subtotal = 0; 
    int total =0;
    public bill() {
        initComponents();
    }
    
    
    void imprimir_factura() {

        ArrayList lista = new ArrayList();

        for (int i = 0; i < order_detail.getRowCount(); i++) {

            lista_factura mortizar = new lista_factura(order_detail.getValueAt(i,0 ) + "", order_detail.getValueAt(i,1 ) + "", order_detail.getValueAt(i, 2) + "",order_detail.getValueAt(i, 3) + "",order_detail.getValueAt(i, 4) + "",
                    order_detail.getValueAt(i, 5) + "");
            lista.add(mortizar);
        }
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile("imprimir_factura.jasper");

            HashMap parametro = new HashMap();
            parametro.put("empresa", "JsVestiment");
            parametro.put("direccion", "Santiago de los caballeros, Tamboril c/ Real no. 14 ");
            parametro.put("total_ammount", total_ammount.getText());
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
        jLabel2 = new javax.swing.JLabel();
        orders = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        order_date = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        order_detail = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        total_ammount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        order_type = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        itbis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        discount = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        payFact = new javax.swing.JButton();
        payment_way = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        devolution = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pay_amount = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                fill(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Cliente:");

        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Orden:");

        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Fecha:");

        order_date.setFocusable(false);

        order_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Equipo", "Serial", "Diagnóstico", "Descripcion", "Monto"
            }
        ));
        jScrollPane2.setViewportView(order_detail);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Total:");

        total_ammount.setFocusable(false);
        total_ammount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_ammountActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Tipo de Orden:");

        order_type.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("SubTotal:");

        subtotal.setFocusable(false);

        itbis.setText("8");
        itbis.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("ITBIS:");

        discount.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        discount.setText("Aplicar Descuento");
        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 25, 242));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.setBorder(null);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        payFact.setBackground(new java.awt.Color(51, 201, 87));
        payFact.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        payFact.setForeground(new java.awt.Color(255, 255, 255));
        payFact.setText("Aplicar Pago");
        payFact.setBorder(null);
        payFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payFactActionPerformed(evt);
            }
        });

        payment_way.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Forma de Pago:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Monto Pagado:");

        devolution.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Devolución:");

        pay_amount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        pay_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_amountActionPerformed(evt);
            }
        });
        pay_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pay_amountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(orders, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(order_type, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(itbis, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(44, 44, 44)
                                .addComponent(total_ammount, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(discount)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(devolution)
                            .addComponent(payment_way, 0, 191, Short.MAX_VALUE)
                            .addComponent(pay_amount))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payFact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(orders, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(order_type, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(payment_way, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(itbis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(discount))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total_ammount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(pay_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(devolution, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(payFact, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        dashboard dash = new dashboard();
        dash.show();
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void fill(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fill
       fill();
    }//GEN-LAST:event_fill
    private void fill(){
        try {
            conexion conn = new conexion();
            ResultSet rs = conn.query("orden o, persona p where o.id_cliente = p.id_per and o.status = 0","distinct p.id_per, concat(p.nombre,' ',p.apellido) nombre");
            System.out.println("1");
                customer.removeAllItems();
                customer.addItem("Seleccione una opción");
                while(rs.next()){
                    customer.addItem(rs.getString(1)+" - "+rs.getString(2));
                }
                System.out.println("2");
                rs = conn.query("SELECT concat(id_tipo,' - ',tipo) from tipo where grptipo = 'FPAGO'");
                orders.removeAllItems();
                System.out.println("3");
            payment_way.removeAllItems();
            DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
            System.out.println("4");
            for (int i = 0; i < dtm.getRowCount(); i++) {
                dtm.removeRow(0);
            }
            
            System.out.println("5");
            while(rs.next()){
                payment_way.addItem(rs.getString(1));
            }
            subtotal.setText("0");
            total_ammount.setText("0");
                System.out.println("6");
                
                
                
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "error aqui " + e.getMessage());
                
            }
    }
    
    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
        try {
            if(customer.getSelectedIndex()==0){
                return;
            }
            DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                dtm.removeRow(0);
            }
            
            conexion conn = new conexion();
            ResultSet rs = conn.query("orden where status = 0 and id_cliente = "+customer.getSelectedItem().toString().split("-")[0].trim(),"id_orden");
            orders.addItem("Seleccione una opción");
            while(rs.next()){
                orders.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause());
        }
    }//GEN-LAST:event_customerActionPerformed

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        order_date.setText("");
        order_type.setText("");
        if(orders.getSelectedIndex()==0 || orders.getSelectedItem() == null){
                return;
        }
        
        try{
            conexion conn = new conexion();
            ResultSet rs = conn.query("select o.fecha, t.tipo from orden o, tipo t where o.id_tipo = t.id_tipo and id_orden = "+orders.getSelectedItem());
            DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                dtm.removeRow(0);
            }
            while(rs.next()){
                order_date.setText(rs.getString(1));
                order_type.setText(rs.getString(2));
            }
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getCause());
        }
        
        
        //section to get The order data
        try {
                       
            conexion conn = new conexion();
            ResultSet rs = conn.query("detalle_orden det, equipo e, diagnostico d WHERE det.id_equipo = e.id_equipo AND det.diagnostico = d.id_diagnostico and id_orden = "+orders.getSelectedItem().toString().split("-")[0],"det.item, concat(det.id_equipo,' - ',e.nombre) equipo, det.serial, d.nombre, det.descripcion, d.precio");
            DefaultTableModel dtm = (DefaultTableModel) order_detail.getModel();
            
            for(int i=0; i<order_detail.getRowCount();i++){
                dtm.removeRow(0);
            
            }
            v_subtotal = 0;
            while(rs.next()){
             
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
                v_subtotal += Float.parseFloat(rs.getString(6));
            }
            subtotal.setText(v_subtotal+"");
            float v_itbis = Integer.parseInt(itbis.getText());
            v_itbis /= 100;
            v_itbis += 1;
            total_ammount.setText(Math.round((v_subtotal*v_itbis))+"");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
    }//GEN-LAST:event_ordersActionPerformed

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        if(subtotal.getText()!= "0.0"){
            if(discount.isSelected()){
                itbis.setText("6");
            }else{
                itbis.setText("8");
            }
            float v_itbis = Integer.parseInt(itbis.getText());
            v_itbis /= 100;
            v_itbis += 1;
            total_ammount.setText(Math.round((v_subtotal*v_itbis))+"");
        }
    }//GEN-LAST:event_discountActionPerformed

    private void payFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payFactActionPerformed
        if(Float.parseFloat(devolution.getText()) >= 0){
            try {
                ResultSet rs;
                int bill_number;
                conexion conn = new conexion();
                conn.insert("factura(usuario, forma_pago, monto, itbis, status)","'"+loginForm.username+"', "+ payment_way.getSelectedItem().toString().split("-")[0].trim() +", "+subtotal.getText() +" ,"+itbis.getText()+",b'1'");
                rs = conn.query("SELECT MAX(num_factura) FROM factura WHERE status = 1");
                rs.next();
                bill_number = Integer.parseInt(rs.getString(1));
                conn.insert("detalle_factura(num_factura, num_detalle, id_orden)",bill_number+", 1, "+orders.getSelectedItem().toString().split(" - ")[0].trim());
                conn.update("orden","status = 1, num_factura = "+bill_number,"id_orden = "+orders.getSelectedItem().toString().split("-")[0].trim());
                /*fill();*/
                
                 
                
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
      
        }else{
            JOptionPane.showMessageDialog(this, "La factura no está Completamente saldada");
        }
         imprimir_factura();
    }//GEN-LAST:event_payFactActionPerformed

    private void pay_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_amountActionPerformed

    private void pay_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pay_amountKeyReleased

        try{
            String pay = ((!pay_amount.getText().isEmpty())? pay_amount.getText() : "0");
        int payment = Integer.parseInt(pay);
        float total = Float.parseFloat(total_ammount.getText());
        devolution.setText((payment - total)+"");
        }catch(Exception e){}

    }//GEN-LAST:event_pay_amountKeyReleased

    private void total_ammountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_ammountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_ammountActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
                
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customer;
    private javax.swing.JTextField devolution;
    private javax.swing.JCheckBox discount;
    private javax.swing.JTextField itbis;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField order_date;
    private javax.swing.JTable order_detail;
    private javax.swing.JTextField order_type;
    private javax.swing.JComboBox<String> orders;
    private javax.swing.JButton payFact;
    private javax.swing.JFormattedTextField pay_amount;
    private javax.swing.JComboBox<String> payment_way;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTextField total_ammount;
    // End of variables declaration//GEN-END:variables
}
