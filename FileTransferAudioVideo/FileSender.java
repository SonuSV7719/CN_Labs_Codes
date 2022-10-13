package FileTransferAudioVideo;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileSender {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public static void main(String[] args) {
        try(
            Socket socket = new Socket("localhost",5000)) {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());


            Scanner input = new Scanner(System.in);
            System.out.println("Enter File Name with extension: ");
            String filename = input.nextLine();
            sendFile(filename, socket);
            sendFile(filename, socket);
            
            dataInputStream.close();
            dataInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void sendFile(String path, Socket s) throws Exception{
        int bytes = 0;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        
        // send file size
        dataOutputStream.writeLong(file.length());  
        // break file into chunks
        // int written = 0;
        byte[] buffer = new byte[4*1024];
        while ((bytes=fileInputStream.read(buffer))!=-1){
            dataOutputStream.write(buffer,0,bytes);
            dataOutputStream.flush();
            // written += bytes;
            //  System.out.println((double)written/file.length());
        }


        
        fileInputStream.close();
    }
}