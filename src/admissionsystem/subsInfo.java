/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionsystem;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class subsInfo extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
               ArrayList<String> s ;
           ArrayList<String> t ;
    int n = 1;
    int total;
   
    college c;
    boolean status = false;
    public subsInfo() {
        initComponents();
    }

    subsInfo(college c) {
        initComponents();
        jLabel6.setText("Total Subjects : " + c.getSubs());
        total= c.getSubs();
                    this.c = new college();
                    this.c.setName(c.getName());
                    this.c.setCity(c.getCity());
                    this.c.setAddress(c.getAddress());                   
                    this.c.setEmail(c.getEmail()); 
                    this.c.setPhone(c.getPhone());
                    this.c.setYear(c.getYear());
                    this.c.setStrength(c.getStrength());
                    this.c.setMale(c.getMale());
                    this.c.setFemale(c.getFemale());
                    this.c.setFees(c.getFemale());
                    this.c.setSubs(c.getSubs());
                    for(int i = 0; i < c.subjects.size(); i++) {
                        this.c.subjects.add(c.subjects.get(i));
                        this.c.teachers.add(c.teachers.get(i));
                    }
                    jLabel2.setText("Subject " + n + " Name :");
                    sub.setText(c.subjects.get(n-1));
                    teacher.setText(c.teachers.get(n-1));
           s = new ArrayList();
           t = new ArrayList();
    }

    

  

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sub = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        teacher = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Subjects Info");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Subjects Info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel3.setText("Teacher Name :");

        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
       
       if(sub.getText().isEmpty() || teacher.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field cannot be empty");
        }
        else {
           
           if (n == total) {
               s.add(sub.getText());
            t.add(teacher.getText());
        
               try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://Colleges.accdb");
                pst = con.prepareStatement("update colleges set Subjects = ?, Teachers = ?, NumberOfSubjects = ? where CollegeName = ?");
               
                pst.setString(1, s.toString());
                pst.setString(2, t.toString());
                pst.setString(3, Integer.toString(total));
                pst.setString(4, c.getName());
                pst.executeUpdate();
                c.subjects = new ArrayList();
                    c.teachers = new ArrayList();
                for(int i = 0; i < s.size(); i++) {
                    c.subjects.add(s.get(i));
                    c.teachers.add(t.get(i));
                }
                
                new editCollege(c).setVisible(true);
                this.setVisible(false);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(editCollege.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(editCollege.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           }
           
           
            s.add(sub.getText());
            t.add(teacher.getText());
        
        
        
            if(n == total - 1) {
                n++;
                jButton1.setText("Finish");
                jLabel2.setText("Subject " + total + " Name :");
                 if(n <= c.subjects.size()) {
                    sub.setText(c.subjects.get(n-1));
                    teacher.setText(c.teachers.get(n-1));
                }
                else {
                    sub.setText("");
                    teacher.setText("");
                }
               
            }
            else {
                n++;
                jLabel2.setText("Subject " + n + " Name :");
                if(n <= c.subjects.size()) {
                    sub.setText(c.subjects.get(n-1));
                    teacher.setText(c.teachers.get(n-1));
                }
                else {
                    sub.setText("");
                    teacher.setText("");
                }
            }
        }
           
            
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(subsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new subsInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField sub;
    private javax.swing.JTextField teacher;
    // End of variables declaration//GEN-END:variables
}