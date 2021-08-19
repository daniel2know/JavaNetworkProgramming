
package client000;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client003 {
    public static  Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        try{
            while(true){
            Socket sc = new Socket("localhost", 6992);
            
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String msgFromClient;
            String msgToServer;
            
            System.out.print("Send a number to the server to know if it is an odd or even number:---->   ");
            msgToServer = scan.next();
            
            dos.writeUTF(msgToServer);
            
            msgFromClient = dis.readUTF();
            System.out.println(msgFromClient);
            }
        }catch(IOException err){
            System.out.println(err.getMessage());
        }
        
    }
    
}
