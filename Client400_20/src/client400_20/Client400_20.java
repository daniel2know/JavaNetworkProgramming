
package client400_20;
import java.io.*;
import java.net.*;

public class Client400_20 {

  
    public static void main(String[] args) {
        
        try{
            
            InetAddress id = InetAddress.getByName("localhost");
            Socket s = new Socket(id, 7500);
            
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            
            System.out.print("hello message to server  : ");
            String s1 = br.readLine();
            dos.writeUTF(s1);
            
            String s2 = dis.readUTF();
            System.out.println("Message from the server : "+ s2);
            
            System.out.println("Information needed by the server ");
            String s3 = br.readLine();
            dos.writeUTF(s3);
            
            String s4 = dis.readUTF();
            System.out.println("message from the server : "+ s4);
        }catch(IOException err){
            
        }
       
    }
    
}





