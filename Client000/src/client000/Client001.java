
package client000;
import java.net.*;
import java.io.*;

public class Client001 {
    
    
    public static void main(String[] args) {
        
        try{
            Socket sc = new Socket ("localhost", 6998);
            
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Say hello to the server::::---->   ");
            
            String msg1 = br.readLine() + "\n";
            
            dos.writeUTF(msg1);
            
            String msg2 = dis.readUTF();
            System.out.println("Message from server: "+ msg2);
            
        }catch(IOException err){
            System.out.println(err.getMessage());
        }
    }
    
}
