/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionsystem;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class studApp extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String cn;
    boolean complete;
    int c = 1,index;
    int total;
    student s;
    college coll;
    ArrayList<student> stds;
    public studApp() {
        initComponents();
    }

    studApp(student s,college c, ArrayList<student> stds, int index) throws FileNotFoundException, ClassNotFoundException, SQLException {
        initComponents();
        cn = c.getName();
        subs.setValue(9);
        total = 9;
        this.index = index;
        
        for(int i = 0; i < stds.get(index).colleges.size(); i++){
            if(stds.get(index).colleges.get(i).equals(cn)) {
                status.setSelectedItem(stds.get(index).applicationStatus.get(i));
            }
        }
        
        this.coll = new college();
                    this.coll.setName(c.getName());
                    this.coll.setCity(c.getCity());
                    this.coll.setAddress(c.getAddress());                   
                    this.coll.setEmail(c.getEmail()); 
                    this.coll.setPhone(c.getPhone());
                    this.coll.setYear(c.getYear());
                    this.coll.setStrength(c.getStrength());
                    this.coll.setMale(c.getMale());
                    this.coll.setFemale(c.getFemale());
                    this.coll.setFees(c.getFemale());
                    this.coll.setSubs(c.getSubs());
                    for(int i = 0; i < c.subjects.size(); i++) {
                        this.coll.subjects.add(c.subjects.get(i));
                        this.coll.teachers.add(c.teachers.get(i));
                    }
                    
        
        this.s = new student();
                name.setEditable(false);
                CNIC.setEditable(false);
                username.setEditable(false);
                phone.setEditable(false);
                email.setEditable(false);
                address.setEditable(false);
                school.setEditable(false);
                gender.setEnabled(false);
                dd.setEnabled(false);
                mm.setEnabled(false);
                yyyy.setEnabled(false);
                subs.setEnabled(false);
                grade.setEnabled(false);
                subTF.setEditable(false);
        jLabel17.setText("Subject " + this.c);
        jLabel18.setText("Subject " + this.c + " Name :");
        complete = s.getProfileStatus();
            if(s.getProfileStatus()) {
                name.setText(s.getName());
                username.setText(s.getUsername());
                CNIC.setText(s.getCnic());
                email.setText(s.getEmail());
                phone.setText(s.getPhone());
                address.setText(s.getAddress());
                school.setText(s.getSchool());
                gender.setSelectedItem(s.getGender());
                subs.setValue(s.getSubs());
                String[] dob = s.getDOB().split("/");
                dd.setSelectedItem(dob[0]);
                mm.setSelectedItem(dob[1]);
                yyyy.setSelectedItem(dob[2]);
                subTF.setText(s.subjects.get(this.c-1));
                grade.setSelectedItem(s.grades.get(this.c-1));
                
                for(int i = 0; i < s.subjects.size(); i++) {
                    this.s.subjects.add(s.subjects.get(i));
                    this.s.grades.add(s.grades.get(i));
                }
                for(int i = 0; i < s.colleges.size(); i++) {
                    this.s.colleges.add(s.colleges.get(i));
                    this.s.applicationStatus.add(s.applicationStatus.get(i));
                }
                /*this.s.setName(name.getText());
                this.s.setCnic(CNIC.getText());
                this.s.setAddress(address.getText());
                this.s.setEmail(email.getText());
                this.s.setPhone(phone.getText());
                this.s.setGender(gender.getSelectedItem().toString());
                this.s.setSchool(school.getText());
                this.s.setUsername(username.getText());
                this.s.setDOB(dd.getSelectedItem() + "/" + mm.getSelectedItem() + "/" + yyyy.getSelectedItem());
                this.s.setSubs(Integer.parseInt(subs.getValue().toString()));
                this.s.setProfileStatus(s.getProfileStatus());*/
                
                total = s.getSubs();
                
                
                //grade.setEditable(false);
                
              
            }
            this.stds = new ArrayList();
                    for(int a = 0; a < stds.size(); a++) {
                       
                        this.s = new student();
                        this.s.setName(stds.get(a).getName());
                    
                        this.s.setCnic(stds.get(a).getCnic());
                        this.s.setAddress(stds.get(a).getName());
                        this.s.setEmail(stds.get(a).getEmail());
                        this.s.setPhone(stds.get(a).getPhone());
                        this.s.setGender(stds.get(a).getGender());
                        this.s.setSchool(stds.get(a).getSchool());
                        this.s.setUsername(stds.get(a).getUsername());
                        this.s.setDOB(stds.get(a).getDOB());
                        this.s.setSubs(stds.get(a).getSubs());
                        this.s.setProfileStatus(stds.get(a).getProfileStatus());

                        for(int i = 0; i < stds.get(a).subjects.size(); i++) {
                                this.s.subjects.add(stds.get(a).subjects.get(i));
                                this.s.grades.add(stds.get(a).grades.get(i));
                            }
                        for(int i = 0; i < stds.get(a).colleges.size(); i++) {
                                this.s.colleges.add(stds.get(a).colleges.get(i));
                                this.s.applicationStatus.add(stds.get(a).applicationStatus.get(i));
                            }
             
                        this.stds.add(this.s);
                      
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        subs = new javax.swing.JSpinner();
        name = new javax.swing.JTextField();
        CNIC = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        school = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        dd = new javax.swing.JComboBox<>();
        mm = new javax.swing.JComboBox<>();
        yyyy = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        subTF = new javax.swing.JTextField();
        grade = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        status = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Application");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Profile");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(275, 275, 275))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel2.setText("Full Name :");

        jLabel3.setText("CNIC :");

        jLabel4.setText("Username :");

        jLabel5.setText("Date of Birth :");

        jLabel6.setText("Gender :");

        jLabel7.setText("email :");

        jLabel8.setText("Contact Number :");

        jLabel9.setText("Address :");

        jLabel10.setText("School Name :");

        jLabel11.setText("Number of Subjects in O Levels :");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        school.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Close Application");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        mm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        yyyy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010" }));

        jLabel12.setText("dd");

        jLabel14.setText("mm");

        jLabel15.setText("yyyy");

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel16.setText("Subjects Info");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setText("Grade :");

        grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A*", "A", "B", "C", "D", "E", "Results Awaiting" }));

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setText("Next Subject");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel20.setText("Application Status");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "College has not reviewed application yet", "Accept", "Call for Interview", "Reject" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addGap(0, 38, Short.MAX_VALUE))
                                    .addComponent(name)
                                    .addComponent(school)
                                    .addComponent(address, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phone, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CNIC, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(subs, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(subTF)
                                    .addComponent(grade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(154, 154, 154)))))))
                .addGap(196, 196, 196))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(390, 390, 390))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(302, 302, 302))))
            .addGroup(layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(status, 0, 296, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(school, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(subs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(subTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton2)
                .addGap(53, 53, 53))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void schoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schoolActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println(stds.size());
        for(int i = 0; i < stds.get(index).colleges.size(); i++) {
            if(stds.get(index).colleges.get(i).equals(cn)) {
                stds.get(index).applicationStatus.set(i, status.getSelectedItem().toString());
                break;
            }
        }
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://Students.accdb");
            pst = con.prepareStatement("update students set ApplicationStatus=? where Username = ?");
            //pst.setString(1, s.colleges.toString());
            pst.setString(1, stds.get(index).applicationStatus.toString());
            pst.setString(2, stds.get(index).getUsername());
           
            pst.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(studApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {    
            new studProfs(coll,stds).setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(studApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        total = Integer.parseInt(subs.getValue().toString());
        subs.setEnabled(false);
        if(complete) {
            if(c == total) {
                c = 0;
                c++;
                jLabel17.setText("Subject " + c);
                jLabel18.setText("Subject " + c + " Name :");
                subTF.setText(s.subjects.get(c-1));
                grade.setSelectedItem(s.grades.get(c-1));
            }
            else {
                c++;
                jLabel17.setText("Subject " + c);
                jLabel18.setText("Subject " + c + " Name :");
                subTF.setText(s.subjects.get(c-1));
                grade.setSelectedItem(s.grades.get(c-1));
            }
            
        }
        else {
             if(subTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Subject Field cannot be empty.");
            }
             else if(c == total) {
                
               
                s.subjects.add(subTF.getText());
                s.grades.add(grade.getSelectedItem().toString());
                jButton3.setText("Finish");
                jButton3.setVisible(false);
                
            } 
                else {
                    s.subjects.add(subTF.getText());
                    s.grades.add(grade.getSelectedItem().toString());
                    c++;
                    jLabel17.setText("Subject " + c);
                    jLabel18.setText("Subject " + c + " Name :");
                    subTF.setText("");
                    grade.setSelectedIndex(0);
                }
            }
            
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(studApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CNIC;
    private javax.swing.JTextField address;
    private javax.swing.JComboBox<String> dd;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JComboBox<String> grade;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> mm;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField school;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField subTF;
    private javax.swing.JSpinner subs;
    private javax.swing.JTextField username;
    private javax.swing.JComboBox<String> yyyy;
    // End of variables declaration//GEN-END:variables
}
