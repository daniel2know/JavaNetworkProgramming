
package deengame;
import java.net.*;
import java.io.*;



public class Client {
    
     public static void main(String[] args) {
         
         try{
             Socket s = new Socket("localhost",5678);
             
             DataInputStream dis = new DataInputStream(s.getInputStream());
             DataOutputStream dos = new DataOutputStream(s.getOutputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
             String s1 = dis.readUTF();
             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
             System.out.println(s1);
             System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
             String s2 = dis.readUTF();
             System.out.println(s2);
             String s3 = br.readLine();
             dos.writeUTF(s3);
             String s4;
             String s5;
             String s6;
             
             for(int i =0; i < Integer.parseInt(s3); i++){
                 
                 s4 = dis.readUTF();
                 System.out.println(s4);
                 s5 = br.readLine().toUpperCase();
                 dos.writeUTF(s5);
                 s6 = dis.readUTF();
                 System.out.println(s6);
             }
             
         }catch(IOException ex){
             System.out.println(ex.getMessage());
         }
        
    }
    
}
