
package lindaassignment;
import java.util.*;
import java.net.*;
import java.io.*;

public class Client03 {
    
    
    public static void main(String[] args) {
        
        try{
             
             Socket sc = new Socket("localhost", 7645);
             DataInputStream dis = new DataInputStream(sc.getInputStream());
             DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
             
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
             String s1;
             
             s1 = dis.readUTF();
             System.out.println(s1);
             String s2;
             s2 = br.readLine();
             dos.writeUTF(s2);
             
             String s3;
             String s5;
             String s6;
             String s7;
             String s8;
             String s9;
             String s10;
             String s11;
             
             for(int i =0; i< Integer.parseInt(s2); i++){

                 s3 = dis.readUTF();
                 System.out.println("Guess the Region of this state "+ s3);
                 s5 = br.readLine();
                 dos.writeUTF(s5.toUpperCase());

                 s6 = dis.readUTF();
                 System.out.println(s6);
                 
             }
             
             s9 = dis.readUTF();
             s10 = dis.readUTF();
             s11 = dis.readUTF();
             
             System.out.println(s9);
             System.out.println(s10);
             System.out.println(s11);
             
             s7 = dis.readUTF();
             System.out.println(s7);
             
             s8 = dis.readUTF();
             System.out.println(s8);
   
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        
    }
    
}
