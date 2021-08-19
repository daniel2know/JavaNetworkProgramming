
package clienttcp01;
import java.io.*;
import java.net.*;
public class ClientTCP01 {

    public static void main(String[] args) {
       
        try{
            Socket sc = new Socket("localhost", 7400);
            
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            DataInputStream dis = new DataInputStream(sc.getInputStream());
           
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Message to sever : ");
            String s1 = br.readLine();
            dos.writeUTF(s1);
            
            String s2;
            
            s2 = dis.readUTF();
            
            System.out.println("Message from server: " + s2);
            
            int N;
            System.out.print("Pls enter game times: ");
            N = Integer.parseInt(br.readLine());
            
            for(int i=0; i<N; i++){
                
            System.out.print("Message to the server of random number:   ");
            String s3 = br.readLine();
            dos.writeUTF(s3);
            
            String s4 = dis.readUTF();
            System.out.println("Output of the game played:  " + s4);
            
            String s5 = dis.readUTF();
            System.out.println("Game statistics "+ s5);
        }
            
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
