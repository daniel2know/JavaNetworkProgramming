
package multipleclientoneserver;
import java.net.*;
import java.io.*;

public class Server1 {
    
     public static void main(String[] args) throws IOException{
         
         ServerSocket ss = new ServerSocket(9111);
         
         while(true){
             
             Socket s;
             
             try{
                 s = ss.accept();
                 System.out.println("Number of participant connected:   -->   "+s);
                 
                 DataInputStream dis = new DataInputStream(s.getInputStream());
                 DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 
                 Thread t = new Clients(s,dis,dos,br);
                 t.start();;
             }catch(Exception ex){
                 System.out.println(ex.getMessage());
             }
             
             
         }
        
    }
    
}


 class Clients extends Thread{
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    BufferedReader br;
    
    
    public Clients(Socket s, DataInputStream dis, DataOutputStream dos, BufferedReader br){
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.br = br;
    }
    
    
    
    
    
    
    
    public void run(){
        try{
            String s1 = "Hello client server talking";
            dos.writeUTF(s1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
}
