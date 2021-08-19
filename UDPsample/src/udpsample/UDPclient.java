
package udpsample;
import java.net.*;
import java.io.*;

public class UDPclient {
    public static int N = 1024;
    public static void main(String[] args) throws SocketException, IOException{
        
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        
        
        while(true){
            byte[] sendPacket = new byte[N];
            byte[] recievePacket = new byte[N];
            
            System.out.println("Client:  ");
            String s1 = br.readLine();
            sendPacket = s1.getBytes();
            
            DatagramPacket dp1 = new DatagramPacket(sendPacket,sendPacket.length,ip,4566);
            ds.send(dp1);
            
            if(s1.equals("bye")){
                System.out.println("Connection is ended by client");
                break;
            }
            
            DatagramPacket dp2 = new DatagramPacket(recievePacket,recievePacket.length);
            ds.receive(dp2);
            String s2 = new String(dp2.getData());
            System.out.println("message form server:" + s2);
            
        }
        
        
    }
    
}
