
package server000;
import java.io.*;
import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;


public class Server000 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        LocalDateTime ldt = LocalDateTime.now();
       
        
        
        try{
            
            ServerSocket ss = new ServerSocket(6999);
            while(true){
            Socket sc = ss.accept();
            
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            // server recieving
            String st1 = dis.readUTF();
            System.out.println("Message from the client " + st1);
            
            //server sending.........
            String st2 = st1.toUpperCase() + '\n';
            dos.writeUTF(st2);
            }
        }catch(IOException ex){
            
        }
    }
    
}
