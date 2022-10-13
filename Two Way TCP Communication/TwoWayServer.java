//Two Way TCP Communication -->> Server Side

import java.net.*;
import java.io.*;

public class TwoWayServer
{
    public static void main(String []args)
    throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server started");

			System.out.println("Waiting for a client ...");
        Socket socket = serverSocket.accept();
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String userInput = "";
        String clientReply = "";
        System.out.println("***************** Start Chatting ******************");
        while(!userInput.equals("Bye"))
        {
            clientReply = din.readUTF();
            System.out.println("Client Reply: " + clientReply);
            System.out.print("Server Input: ");
            userInput = in.readLine();
            dout.writeUTF(userInput);
            dout.flush();   

        }

        in.close();
        socket.close();
        din.close();
        dout.close();

        
    }
}