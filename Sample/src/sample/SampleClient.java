
package sample;
import java.net.*;
import java.io.*;

public class SampleClient {
    
     public static void main(String[] args) {
        
         try{
             int i =5;
             while(i>=1){
                 i--;
                 Socket sc = new Socket("localhost",4096);
                 DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
                 DataInputStream dis = new DataInputStream(sc.getInputStream());
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 
                 String s1 = dis.readUTF();
                 System.out.println(s1);
                 
                 String s2 = "messaged recieved";
                 dos.writeUTF("Message from server:  "+s2);
                 
             }
             
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
         
    }
    
}
