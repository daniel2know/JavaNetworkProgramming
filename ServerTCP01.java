
package servertcp01;


import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class ServerTCP01 {
    
    
     private static int serverWin, clientWin , draw;
    
    public static int randa (){
        
        int d;
        Random x = new Random();
        
        d = x.nextInt(10);
        
        return d;
    }
    
    
    public static String whoWin(int sNo, String ClNo){
        
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd-mm-yyy HH:MM:SS");
        String tt = dtm.format(ldt);
        System.out.println("date and time" + tt);
        String res;
        
        res = " server random number" + sNo + " client random number" + ClNo;
        
        int clientNo = Integer.parseInt(ClNo);
        
        if(sNo > clientNo){
            serverWin+=1;
            res+= " Server has won " + tt;
        }
        else if(sNo < clientNo){
            clientWin+=1;
            res+= " Client has won " + tt;
        }
        else{
            draw+=1;
             res+= "  The game is draw" + tt;
        }
        
        return res;
    }
    
    
    //preform statistics
    private static String gamestat(){
        String res;
        res = " Server won "+ serverWin+ " Client won "+ clientWin + " game draw " + draw;
        return res;
    }
    
    
   

    public static void main(String[] args) {
       try{
           ServerSocket ss = new ServerSocket(7400);
           Socket sc = ss.accept();
           
           DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
           DataInputStream dis = new DataInputStream(sc.getInputStream());
           
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
           String s1 = dis.readUTF();
           System.out.println("Message from the client : " + s1);
           
           System.out.println("Message to the client: " );
           String s2 = br.readLine();
           
           dos.writeUTF(s2);
           
           while(true){
           String s3 = dis.readUTF();
           System.out.println("Random number from the client  :" + s3);
           
           int serverNo = randa();
           
           String s4 = whoWin(serverNo, s3);
           dos.writeUTF(s4);
           System.out.println("Output of the game played:  " + s4);
           
           
           String s5 = gamestat();
           dos.writeUTF(s5);
           System.out.println("Game statistics "+ s5);
        }
           
           
          
       }catch(IOException ex){
           
       }
    }
    
}
