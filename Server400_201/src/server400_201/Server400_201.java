
package server400_201;
import java.io.*;
import java.net.*;


public class Server400_201 {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(7500);

        while (true) {

            Socket s;

            try {
                s = ss.accept();
                System.out.println("client participants that connected " + s);

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                DataInputStream dis = new DataInputStream(s.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                Thread t = new Clients(s,dos,dis,br);
                t.start();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}



class Clients extends Thread{
    
Socket s;
DataOutputStream dos;
DataInputStream dis;
BufferedReader br;


public Clients (Socket s, DataOutputStream dos, DataInputStream dis, BufferedReader br){
    this.s = s;
    this.dos = dos;
    this.dis = dis;
    this.br = br;
}


public String perfectNumber(String s){
    int num = Integer.parseInt(s);
    
    int i, p = 0;
    String res = "";
    
    
    for(i = 1; i<num; i++){
        if(num % i == 0){
            System.out.println("see factors of "+num);
            System.out.println(i);
            p = p + i;
            
           
        }
        
        if(p == num){
            res = num + " is a perfect number client you are right because the addition gives us" + p;
        }else{
            res = num + " is not a perfect number  ooo client you because the addition gives us" + p;
        }
        
    }
    
    return res;
}


@Override
public void run(){
    
    try{
        String s1 = dis.readUTF();
        System.out.println("Message from the client :  "+ s1);
        
        System.out.println("message to client :  ");
        String s2 = br.readLine();
        dos.writeUTF(s2);
        
        String s3 = dis.readUTF();
        String s4 = perfectNumber(s3);
        
        System.out.println("message to the client : "+ s4);
        dos.writeUTF(s4);
        
        
    }catch(IOException ex){
        System.out.println(ex.getMessage());
        
    }
    
}

}
