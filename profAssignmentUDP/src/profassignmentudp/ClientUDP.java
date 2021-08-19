
package profassignmentudp;
import java.net.*;
import java.io.*;
import java.util.*;


public class ClientUDP {
    public static int N = 1024;
    
    
    
    public static void main(String[] args) {
        
         byte[] sendPacket = new byte[N];
        byte[] recievePacket = new byte[N];
        
        
        try{
            DatagramSocket ds = new DatagramSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            

            
            System.out.print("Please enter port number to establish connection and run the application:  ");
            int port1 = Integer.parseInt(br.readLine());
            String s1 = " I Client with "+port1+" wants to play a game";
            InetAddress ip = InetAddress.getByName("localhost");

            sendPacket = s1.getBytes();
            DatagramPacket dp1 = new DatagramPacket(sendPacket,sendPacket.length,ip,port1);
            ds.send(dp1);
            
            DatagramPacket dp2 = new DatagramPacket(recievePacket, recievePacket.length);
            ds.receive(dp2);
            String s2 = new String(dp2.getData());
            System.out.println("Response from client: "+s2);
            
            
            String s3 = br.readLine();
            sendPacket = s3.getBytes();
            DatagramPacket dp3 = new DatagramPacket(sendPacket,sendPacket.length,ip,port1);
            ds.send(dp3);
            
            String s4;
            String s5;
            String s6;
            String s7;
            String s8;
            String s9;
            String s10;
            String s11;
            String s12;
            
            for(int i =0; i< Integer.parseInt(s3); i++){
                DatagramPacket dp4 = new DatagramPacket(recievePacket, recievePacket.length);
                ds.receive(dp4);
                s4 = new String(dp4.getData());
                
                DatagramPacket dp5 = new DatagramPacket(recievePacket, recievePacket.length);
                ds.receive(dp5);
                s5 = new String(dp5.getData());
                
                 System.out.println("Guess the colour "+ s4 + s5);
                 s6 = br.readLine().toUpperCase();
                 
                 sendPacket = s6.getBytes();
                 DatagramPacket dp6 = new DatagramPacket(sendPacket,sendPacket.length,ip,port1);
                 ds.send(dp6);
 
                 
                 DatagramPacket dp7 = new DatagramPacket(recievePacket, recievePacket.length);
                 ds.receive(dp7);
                 s7 = new String(dp7.getData());
                 System.out.println(s7);

                 
             }
            
                 DatagramPacket dp8 = new DatagramPacket(recievePacket, recievePacket.length);
                 ds.receive(dp8);
                 s10 = new String(dp8.getData());
                 
                 DatagramPacket dp9 = new DatagramPacket(recievePacket, recievePacket.length);
                 ds.receive(dp9);
                 s11 = new String(dp9.getData());
                 
                 DatagramPacket dp10 = new DatagramPacket(recievePacket, recievePacket.length);
                 ds.receive(dp10);
                 s12 = new String(dp10.getData());
                 
                 System.out.println(s10);
                 System.out.println(s11);
                 System.out.println(s12);
             
             
                 
                 DatagramPacket dp11 = new DatagramPacket(recievePacket, recievePacket.length);
                 ds.receive(dp11);
                 s8 = new String(dp11.getData());
                 System.out.println(s8);
                 
                 DatagramPacket dp12 = new DatagramPacket(recievePacket, recievePacket.length);
                 ds.receive(dp12);
                 s9 = new String(dp12.getData());
                 System.out.println(s9);

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
