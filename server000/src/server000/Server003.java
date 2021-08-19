/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server000;
import java.net.*;
import java.io.*;


/**
 *
 * @author Tunwashe Daniel
 */
public class Server003 {
    
    public static void main(String[] args) {
        
        try{
            ServerSocket ss = new ServerSocket(6992);
            
            while(true){
            Socket sc = ss.accept();
            
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            
            String msgToClient = "";
            int msgFromClient = Integer.parseInt(dis.readUTF());
            System.out.println("Message from client " + msgFromClient);
            
            
            if(msgFromClient % 2 == 0){
                msgToClient = msgFromClient +" is an even number";
                dos.writeUTF(msgToClient);
            }
            else{
                msgToClient = msgFromClient+" is an odd number";
                dos.writeUTF(msgToClient);
            }
            }
        }catch(IOException err){
            System.out.println(err.getMessage());
        }
        
    }
    
}
