
package udpserver;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UDPSERVER {
public static int N = 1024;
    
    public static void main(String[] args) {
        // EACH PACKET CAN ONLY BE 4096 BYTE
        //  N IS THE VOLUME OF BYTE
       
        // FIRST SEND AND RECIEVE PACKET
        byte[] sendPacket = new byte[N];
        byte[] recievePacket = new byte[N];
        
        
        //UDP USES DATAGRAM SOCKET
        try{
            
            DatagramSocket ds = new DatagramSocket(9100);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            // recieveing we need two parameter which are recievepacket and length
            DatagramPacket dp1 = new DatagramPacket(recievePacket, recievePacket.length);
            ds.receive(dp1);
            
            InetAddress ip1 = dp1.getAddress();
            int port1 = dp1.getPort();
            System.out.println("Client ip = "+ ip1 + "client port number = "+port1);
            
            String s1 = new String(dp1.getData());
            System.out.println("Message from client : "+ s1);
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd-mm-yyy HH:MM:SS");
            String s2 = dtm.format(ldt);
             
        
            //we use datagram packet to send message
            // for sending we need four parameters: message, message-length, ip-address and port no
            sendPacket = s2.getBytes();
            DatagramPacket dp2 = new DatagramPacket(sendPacket,sendPacket.length,ip1,port1);
            ds.send(dp2);
            System.out.println("Date and time : "+s2);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
