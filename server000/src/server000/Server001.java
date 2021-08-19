
package server000;
import java.net.*;
import java.io.*;

public class Server001 {
    
    public static void main(String[] args) {
        
        try{
            
            ServerSocket ss = new ServerSocket(6998);
            Socket sc = ss.accept();
            
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String msg1 = dis.readUTF();
            System.out.println("Message from server:  " + msg1);
            String msg2;
            
            
           
               if(msg1.equals("How are u doing server")){
                   msg2 = "I am fyn client what's up!!!!";
                   dos.writeUTF(msg2);
               }
               else if(msg1.equals("server can you perform any operation yet")){
                   msg2 = "No i cant but will soon be able to, thanks for asking";
                   dos.writeUTF(msg2);
               }
               else{
                   msg2 = "Though i didnt get your question client cos it not part of my decision logic but all the same i am SERVER D by name would like to know you";
                   dos.writeUTF(msg2);
               }
           
            
        }catch(IOException err){
            
            System.out.println(err.getMessage());
        }
    }
    
}
