
package tcpassignment;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
       try {
           Socket sc = new Socket("localhost",6055);
           DataInputStream dis = new DataInputStream(sc.getInputStream());
           DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
           
           String msgFromServer1 = dis.readUTF();
           System.out.println(msgFromServer1);
           String msgFromServer2 = dis.readUTF();
           System.out.println(msgFromServer2);
           
           String msgToServer1;
           System.out.println("Enter the times to play in numbers");
           msgToServer1 = scan.next();
           dos.writeUTF(msgToServer1);
           int count = Integer.parseInt(msgToServer1);
           
           while(count != 0){
               String msgFromServer3 = dis.readUTF();
               System.out.println(msgFromServer3);
               String msgToServer2 = scan.next();
               dos.writeUTF(msgToServer2);
               
               String msgFromServer4 = dis.readUTF();
               System.out.println(msgFromServer4);
               
               count --;
           }
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
