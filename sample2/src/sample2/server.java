
package sample2;
import java.net.*;
import java.io.*;

public class server {
    
    public static void main(String[] args){
        
         try{
            
            ServerSocket ss = new ServerSocket(4423);
            Socket sc = ss.accept();
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String s1 = "Hello client";
            dos.writeUTF(s1);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
