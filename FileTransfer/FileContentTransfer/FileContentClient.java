package FileTransfer;
import java.net.*;
import java.io.*;

public class FileContentClient {
    public static void main(String []args)
    throws Exception
    {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected");
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String userLine = "";
        String serverReply = "";
        System.out.println("***************** Start Chatting ******************");
        while(!userLine.equals("Bye"))
        {
            System.out.print("Client: ");
            userLine = in.readLine();
            dout.writeUTF(userLine);
            dout.flush();
            serverReply = din.readUTF();
            if(userLine.equals("File Content"))
            {
                System.out.println("File Content: " + serverReply);
            }
            System.out.println("Server Reply: " + serverReply);
                

        }
        in.close();
        socket.close();
        din.close();
        dout.close();


    }
}