
package udppratice;
import java.net.*;
import java.io.*;
public class UDPclient1 {
    public static int N = 1024;
    
    public static void main(String[] args){
        
        byte[] sendPacket = new byte[N];
        byte[] recievePacket = new byte[N];
        
        try{
            
            DatagramSocket ds = new DatagramSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String s1 = "Hello client";
            sendPacket = s1.getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            System.out.println("Enter port number to begin");
            int portnumb = Integer.parseInt(br.readLine());
            
            DatagramPacket dp1 = new DatagramPacket(sendPacket,sendPacket.length,ip,portnumb);
            ds.send(dp1);
            
            DatagramPacket dp2 = new DatagramPacket(recievePacket, recievePacket.length);
            ds.receive(dp2);
            
            String s2 = new String(dp2.getData());
            System.out.println(s2);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
