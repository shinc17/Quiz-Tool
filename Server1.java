import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server1 {
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        boolean keepServerOpen = true;
        BufferedReader reader = null;
        PrintWriter writer = null;
        ServerSocket serverSocket = new ServerSocket(2222);
        Socket socket = null;
        boolean keepQuizSystemOpen = true;
        boolean loginSuccess = false;
        String globalName = "";

        do {
            socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);

            ClientHandler clientThread   = new ClientHandler(socket);
            Thread thread = new Thread(clientThread);
            thread.start();
            clients.add(clientThread);


        } while (keepServerOpen);

        writer.close();
        reader.close();
    }
}