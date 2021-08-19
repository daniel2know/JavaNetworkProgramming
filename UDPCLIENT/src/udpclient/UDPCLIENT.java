
package udpclient;

import java.io.*;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPCLIENT {
public static int N = 1024;
  
    public static void main(String[] args) {
        
        byte[] sendPacket = new byte[N];
        byte[] recievePacket = new byte[N];
        
        
        try{
            DatagramSocket ds = new DatagramSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            
            System.out.println("message to server : ");
            String s1 = br.readLine();
            
            System.out.print("Please enter port number");
            int port1 = Integer.parseInt(br.readLine());
            InetAddress ip = InetAddress.getByName("localhost");
            
            //we use datagram packet to send message
            // for sending we need four parameters: message, message-length, ip-address and port no
            sendPacket = s1.getBytes();
            DatagramPacket dp1 = new DatagramPacket(sendPacket,sendPacket.length,ip,port1);
            ds.send(dp1);
            
            
            DatagramPacket dp2 = new DatagramPacket(recievePacket, recievePacket.length);
            ds.receive(dp2);

            String s2 = new String(dp2.getData());
            System.out.println("Message from client : "+ s2);
        }catch(IOException ex){
            
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    
}
