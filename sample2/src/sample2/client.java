
package sample2;
import java.net.*;
import java.io.*;

public class client {
    
    public static void main(String[] args){
        
        try{
            
            Socket sc = new Socket("localhost",4423);
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String s1 = dis.readUTF();
            System.out.println(s1);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
