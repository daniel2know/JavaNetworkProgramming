
package multipleclientoneserver;
import java.net.*;
import java.io.*;

public class Client2 {
    
     public static void main(String[] args) {
         
         try{
             InetAddress id = InetAddress.getByName("localhost");
             Socket s = new Socket(id,9111);
             
             DataInputStream dis = new DataInputStream(s.getInputStream());
             DataOutputStream dos = new DataOutputStream(s.getOutputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
             String s1 = dis.readUTF();
             System.out.println("Message from server: "+s1);
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        
    }
    
}
