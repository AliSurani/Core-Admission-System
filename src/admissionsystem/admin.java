/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Dell
 */
public class admin {
    RandomAccessFile file = new RandomAccessFile("admin.dat","rw");
    private String username;
    private String password;

   


    public admin() throws FileNotFoundException {
        
    }
    
    public void read() throws IOException {
        file.seek(0);
        char[] temp = new char[15];  // 15 chars for username
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        username = new String(temp).trim();
                
        temp = new char[15];  // 15 chars for pswd
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        password = new String(temp).trim();  // trim function removes empty spaces
    }
 
    public boolean login(String username, String password) throws IOException {
        
        boolean ans = false;
        
            read();
            if(username.equals(this.username) && password.equals(this.password) ) {
                ans = true;
            
            }
            
        return ans;    
    }
    
    public void updatePassword(String password) throws IOException
    {
            file.seek(30);  // 1 char = 2 bytes
            StringBuffer sb;
            
            if (password != null)
                sb = new StringBuffer(password);
            else
                sb = new StringBuffer();
            sb.setLength(15);
            file.writeChars(sb.toString());
        
    }

    public void setId(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int size() {
        return 2*(15 + 15);
    }
}

    

