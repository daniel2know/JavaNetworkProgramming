
package sample;
import java.net.*;
import java.io.*;

public class SampleServer {
    
     public static void main(String[] args) {
         
         try{
             
             ServerSocket ss = new ServerSocket(4096);
             int i =5;
             while(i>=1){
                 i--;
                 Socket sc = ss.accept();
                 DataInputStream dis = new DataInputStream(sc.getInputStream());
                 DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 
                 System.out.print("Please enter a message to client:   --->   ");
                 String s1 = br.readLine();
                 dos.writeUTF(s1);
                 
                 String s2 = dis.readUTF();
                 System.out.println(s2);
             }
             
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        
    }
    
}
