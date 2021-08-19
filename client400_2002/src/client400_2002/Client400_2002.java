package client400_2002;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



public class Client400_2002 {

  
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









