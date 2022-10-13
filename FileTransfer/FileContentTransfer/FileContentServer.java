package FileTransfer.FileContentTransfer;
import java.net.*;
import java.io.*;
// Import the File class
import java.util.Scanner;
  
// Import this class for handling errors
import java.io.FileNotFoundException;
// Import the File class
import java.io.File;
  
// Import this class for handling errors
import java.io.FileNotFoundException;

public class FileContentServer {
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
            if(clientReply.equals("File Content"))
            {
                try {
                    File Obj = new File("myfile.txt");
                    Scanner Reader = new Scanner(Obj);
                    while (Reader.hasNextLine()) {
                        String data = Reader.nextLine();
                        // System.out.println(data);
                        // userInput = in.readLine();
                        dout.writeUTF(data);
                        dout.flush();

                    }
                    Reader.close();
                }
                catch (FileNotFoundException e) {
                    System.out.println("An error has occurred.");
                    e.printStackTrace();
                }
        
            }
                
            
            System.out.println("Client Reply: " + clientReply);
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