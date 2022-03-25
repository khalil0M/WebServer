package v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args){
        ServerSocket serverSocket = null;

        try{

            // v1.server is listening on port 8040
            serverSocket = new ServerSocket(8040);
            serverSocket.setReuseAddress(true);

            while (true){

                Socket socketClient = serverSocket.accept();

                System.out.println("New client connected :" +socketClient.getLocalAddress() +" - "+socketClient.getLocalPort());

                ClientHandler clientHandler = new ClientHandler(socketClient);

                // starting thread
                new Thread(clientHandler).start();
            }

        }catch (Exception e){
            e.getStackTrace();
        }finally {
            try {
                if (null != serverSocket) {
                    serverSocket.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ClientHandler class : Un objet de cette classe agit comme une cible Runnable pour un nouveau thread
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }

        public void run()
        {
            DataOutputStream out = null;
            DataInputStream in = null;
            try {

                // get the outputstream of client
                out = new DataOutputStream(clientSocket.getOutputStream());

                // get the inputstream of client
                in = new DataInputStream(clientSocket.getInputStream());

                String line;
                System.out.println("your message is :  " + in.readUTF());
                    while (null != in.readUTF()) {

                    line = in.readUTF();
                    // writing the received message from
                    // client
                    System.out.printf(" Sent from the client: %s\n", line);

                    out.writeUTF(line);
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (null !=out) {
                        out.close();
                    }
                    if (null!=in) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
