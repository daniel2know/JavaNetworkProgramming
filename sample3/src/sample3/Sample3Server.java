
package sample3;
import java.io.*;
import java.net.*;

public class Sample3Server {
    
    public static void main(String[] args) throws IOException{
        
        ServerSocket ss = new ServerSocket(5548);
        
        while(true){
            
            Socket s;
            
            try{
                s = ss.accept();
                System.out.println("Client participants that are connected:  "+ s);
                
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                Thread th = new Clients(s,dis,dos,br);
                th.start();
                
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
    
    
    public static String perfectno(String num){
        int numb = Integer.parseInt(num);
        String res;
        int i,p = 0;
        
        for(i =1; i< numb; i++){
            if(numb%i == 0){
                p+=i;
            }
        }
        
        if(numb == p){
            res = "Yes " + numb + " is a perfect number";
        }
        else{
            res = "No " + numb + " is not a perfect number";
        }
        
        return res;
    }
    
    
    public void run(){
        
        try{
           
            while (true){
                
                 String s1 = dis.readUTF();
                 String s2 = perfectno(s1);
                 dos.writeUTF(s2);
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}