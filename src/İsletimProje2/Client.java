package İsletimProje2;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            new Thread(new IncomingMessageHandler(in)).start();

            String kullanıcıGirişi;
            while ((kullanıcıGirişi = consoleReader.readLine()) != null) {
                out.println(kullanıcıGirişi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class IncomingMessageHandler implements Runnable {
    private BufferedReader in;

    public IncomingMessageHandler(BufferedReader in) {
        this.in = in;
    }

    
    public void run() {
        String BeklenmeyenMesaj;
        try {
            while ((BeklenmeyenMesaj = in.readLine()) != null) {
                System.out.println(BeklenmeyenMesaj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
