/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class student {
    RandomAccessFile file = new RandomAccessFile("student.dat","rw");
    private String name, cnic, username, password;
    private boolean status, profileStatus;
    private String DOB, gender, email, phone, address, school;
    private int subs;
    ArrayList<String> subjects;
    ArrayList<String> grades;
    ArrayList<String> colleges ;
    ArrayList<String> applicationStatus;
    

    public student(String name, String cnic, String username, String password) throws FileNotFoundException {
        this.name = name;
        this.cnic = cnic;
        this.username = username;
        this.password = password;
        status = false;
    }

    student() throws FileNotFoundException {
        subjects = new ArrayList();
        grades = new ArrayList();
        colleges = new ArrayList();
        applicationStatus = new ArrayList();
        
    }
    
    public void signup() throws IOException {
        file.seek(file.length());
        StringBuffer sb;
        
        
      
        sb = new StringBuffer(name);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
       
        sb = new StringBuffer(cnic);    
        sb.setLength(13);
        file.writeChars(sb.toString());

        sb = new StringBuffer(username);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
        
     
        sb = new StringBuffer(password);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
        file.writeBoolean(status);
    }
    
    public boolean checkUsername(String username) throws IOException {
        file.seek(56);
        boolean ans = false;
        int n = (int) (file.length())/size();
        for(int i = 0; i < n; i++) {
            char[] temp = new char[15];
            for (int j = 0; j < temp.length; j++)
                temp[j] = file.readChar();
            String uname = new String(temp);
    
            if(uname.trim().equals(username)) {
                ans = true;
                break;
            }
            file.seek(file.getFilePointer() + 87);
        }
        return ans;
    }
    
    
    public int size() {
        return 2*(15 + 13 + 15 + 15) + 1;
    }
    
    public boolean login(String username, String password) throws IOException {
        int n = (int) (file.length()/size());
        file.seek(0);
        boolean ans = false;
        for(int j = 0; j < n; j++) {
            read();
            if(username.equals(this.username) && password.equals(this.password) ) {
                ans = true;
                break;
            }    
        }
        return ans;    
    }
    
    public void read() throws IOException {
        //System.out.println(teacherFile.getFilePointer());
        char[] temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        name = new String(temp);
        name = name.trim();
        
        temp = new char[13];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        cnic = new String(temp);
        
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        username = new String(temp);
        username = username.trim();
        
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        password = new String(temp);
        password = password.trim();
        
        status = file.readBoolean();
       
    }
    
    public void setStatus(String username) throws IOException {
        int n = (int) (file.length()) / size();
        for(int i =0; i < n; i++){
            read();
            if(this.username.equals(username)) {
                file.seek(file.getFilePointer()-1);
                file.writeBoolean(true);
                break;
            }
        }
    }
    
        public void deleteStudent(String username) throws FileNotFoundException, IOException {
        int n = (int) (file.length()/size());
        for(int i = 0; i < n; i++) {
            read();       
            if(username.equals(this.username)) {
                for(int j = i+1; j < n; j++) {
                    read();               
                    file.seek(file.getFilePointer() - 2*size());
                    write();
                    file.seek(file.getFilePointer() + size());
                }
                break;
            }
              
        }
        file.setLength(file.length() - size());
        
    }
    
    public void write() throws IOException {
        StringBuffer sb;
        
        
      
        sb = new StringBuffer(name);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
       
        sb = new StringBuffer(cnic);    
        sb.setLength(13);
        file.writeChars(sb.toString());

        sb = new StringBuffer(username);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
        
     
        sb = new StringBuffer(password);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
        file.writeBoolean(status);
    }
    

  

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getStatus() {
        return status;
    }

    public RandomAccessFile getFile() {
        return file;
    }

    public boolean isStatus() {
        return status;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getSchool() {
        return school;
    }

    public int getSubs() {
        return subs;
    }

    public void setFile(RandomAccessFile file) {
        this.file = file;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSubs(int subs) {
        this.subs = subs;
    }

    public boolean getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(boolean profileStatus) {
        this.profileStatus = profileStatus;
    }
    
    

}
