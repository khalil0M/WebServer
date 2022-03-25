package v1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args){
        try{
            Socket socket = new Socket("127.0.0.1",8040);
            System.out.println("Send your message :");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.next();

            // Send the data to v1.server
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(line);

            //retrieve the answer of v1.server

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String answer = dataInputStream.readUTF();

            // display the response of v1.server
            System.out.println(answer);

            //closing the scanner object
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
