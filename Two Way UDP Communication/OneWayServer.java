// Java program to illustrate Server side 
// Implementation using DatagramSocket 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
  
public class OneWayServer {
    public static void main(String[] args) throws IOException 
    { 
        // Socket + Port
        DatagramSocket ds = new DatagramSocket(1234); 
        byte[] receive = new byte[65535]; 
  
        DatagramPacket DpReceive = null; 
        while (true) 
        { 
  
            //Datagram to recieve Data
            DpReceive = new DatagramPacket(receive, receive.length); 
  
            // Receive data in byte buffer
            ds.receive(DpReceive); 
  
            System.out.println("Client:-" + data(receive)); 
  
            //Bye to Exit
            if (data(receive).toString().equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
  
            // Clear buffer  
            receive = new byte[65535]; 
        } 
        ds.close();
    } 
  
    //Data function
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
}
