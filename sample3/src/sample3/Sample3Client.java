
package sample3;
import java.net.*;
import java.io.*;
import java.util.*;

public class Sample3Client {
    
    public static void main(String[] args){
        
        try{
            InetAddress id = InetAddress.getByName("localhost");
            Socket s = new Socket(id,5548);
            
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int i,N;
            System.out.println("Enter how many times u want to find a perfect number...");
            N = Integer.parseInt(br.readLine());
            
            for(i=0; i<N; i++){
                System.out.print("Enter the number: ");
                String s1 = br.readLine();
                dos.writeUTF(s1);
                String s2 = dis.readUTF();
                System.out.println("Message form server:  "+s2);
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
