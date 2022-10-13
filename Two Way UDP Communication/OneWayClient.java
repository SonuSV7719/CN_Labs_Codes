import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner;

public class OneWayClient {
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
  
        //Socket To carry Data
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
  
        while (true) 
        { 
            String inp = sc.nextLine(); 
  
            // input string to byte array conversion 
            buf = inp.getBytes(); 
  
            // send data datagram packet
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, 1234); 
  
            // send function to send data to server
            ds.send(DpSend); 
             
            if (inp.equals("bye")) 
                break; 
        } 
        sc.close();
        ds.close();
    } 
    
}
