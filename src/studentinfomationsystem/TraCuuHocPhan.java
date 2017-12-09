/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfomationsystem;

/**
 *
 * @author PQD
 */
import Database.DBConnection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class TraCuuHocPhan extends javax.swing.JPanel {

    /**
     * Creates new form Thongtinsinhvien
     */
    public TraCuuHocPhan() {
        initComponents();
    }
    private String text;
    private Object[] loadColumnName(){
        return new Object[]{"Tên môn học", "Số TC", "Học kì", "Ngành"};
    }
    private Object[][] loadRowData(String pos_1,String pos_2,String pos_3, String pos_4){
        return new Object[][]{{pos_1,pos_2,pos_3,pos_4}};
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        hocPhanTextField = new javax.swing.JTextField();
        hocPhanLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        topLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        topLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topLabel.setText("Tra cứu Học phần");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        hocPhanTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hocPhanTextFieldActionPerformed(evt);
            }
        });

        hocPhanLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hocPhanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hocPhanLabel.setText("Mã Học Phần");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Tên môn học", "Số TC", "Học kì", "Ngành"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setAlignmentX(1.0F);
        jTable1.setAlignmentY(1.0F);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTable1.setPreferredSize(new java.awt.Dimension(400, 16));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("jLabel1");

        jLabel2.setText("MSSV:");

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hocPhanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(hocPhanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hocPhanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hocPhanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(topLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void query(){
        text = hocPhanTextField.getText();
       // int ID = Integer.parseInt(text);
        Connection conn = null;
        PreparedStatement ptmt = null;
        DBConnection db = new DBConnection();
        conn = db.ketNoi();
        
        String sql = "select * from monhoc,nganh where idmonhoc = (?) and monhoc.nganh_idnganh = nganh.idnganh";
        
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, text);
            ResultSet rs = ptmt.executeQuery();
            rs.next();
            
            
            String txt1 = rs.getString("tenmh");
            String txt2 = rs.getString("sotc");
            String txt3 = rs.getString("hocki");
            String txt4 = rs.getString("tennganh");
            TableModel dataModel = new DefaultTableModel(loadRowData(txt1, txt2, txt3, txt4), loadColumnName());
            jTable1.setModel(dataModel);
            ptmt.close();
            conn.close();
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
    }
    private void hocPhanTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hocPhanTextFieldActionPerformed
        // TODO add your handling code here:
        query();
    }//GEN-LAST:event_hocPhanTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        query();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void setId(String maID){
        jLabel1.setText(maID);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hocPhanLabel;
    private javax.swing.JTextField hocPhanTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel topLabel;
    // End of variables declaration//GEN-END:variables
}
