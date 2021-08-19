
package tcpassignment;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Server {
    static Scanner scan = new Scanner(System.in);
    
    
    public static void main(String[] args) {
       
        try{
            ServerSocket ss = new ServerSocket(6055);
            Socket sc = ss.accept();
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            
            String msgToClient1 = "Let's play a color guessing game i have four colours with me you will tell me the colour i am holding presently among the colours with me\nEnter 1: for colour Red\nEnter 2: for colour Green\nEnter 3: for colour Blue\nEnter 4: for colour Yellow";
            dos.writeUTF(msgToClient1);
            String msgToClient2 = "How many times would you like to play! i guess i can beat you in n number of times";
            dos.writeUTF(msgToClient2);
            
            String msgFromClient1 = dis.readUTF();
            String msgToClient4;
            int count = Integer.parseInt(msgFromClient1);
            String colour;
            
            while(count != 0){
                String msgToClient3 = "Guess what am holding now....";
                dos.writeUTF(msgToClient3);
                String msgFromClient2 = dis.readUTF();
                
                int myNumber;
                Random x = new Random();
                myNumber = x.nextInt(4);
                System.out.println(myNumber);
                
                if(myNumber == Integer.parseInt(msgFromClient2)){
                  msgToClient4   = " Yea you won i am holding the colour with colour code "+ myNumber;
                  dos.writeUTF(msgToClient4);
                }
                else{
                    msgToClient4 = "OOPS i won you did not get it right the colour i am holding is with colour code "+ myNumber;
                    dos.writeUTF(msgToClient4);
                }
                
                count--;
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
