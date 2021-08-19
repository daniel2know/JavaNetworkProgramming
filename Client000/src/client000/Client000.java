
package client000;
import java.net.*;
import java.io.*;

public class Client000 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            
            while(true){
            Socket sc = new Socket("localhost", 6999);
            //send message to server
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            //client typing message to server
            System.out.println("Message to server: ");
            String st1 = br.readLine() + '\n';
            dos.writeUTF(st1);
            
            
            //client recieving
            String st2 = dis.readUTF();
            System.out.println("Message from server: " + st2);
            }
            
            
            
        }catch(IOException ex){
            
        }
    }
    
}
