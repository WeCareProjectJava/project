/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author eya_o
 */
// ChatServer.java


// ChatServer.java


import models.Message;
import Services.UserType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private int port;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private Map<String, Connection> connections;

    public ChatServer(int port) {
        this.port = port;
        this.connections = new HashMap<>();
        this.executorService = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Chat server started on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection from: " + socket.getInetAddress());
            executorService.submit(() -> handleConnection(socket));
        }
    }

    private void handleConnection(Socket socket) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            String userEmail = (String) inputStream.readObject();
            UserType userType = (UserType) inputStream.readObject();

            Connection connection = new Connection(socket, userEmail, userType, outputStream, inputStream);
            connections.put(userEmail, connection);

            while (true) {
                Message message = (Message) inputStream.readObject();
                forwardMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection(socket);
        }
    }

    private void forwardMessage(Message message) throws IOException {
        Connection receiverConnection = connections.get(message.getReceiver());
        if (receiverConnection != null) {
            receiverConnection.outputStream.writeObject(message);
            receiverConnection.outputStream.flush();
        }
    }

    private void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(3000);
        try {
            chatServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Connection {
        private Socket socket;
        private String userEmail;
        private UserType userType;
        private ObjectOutputStream outputStream;
        private ObjectInputStream inputStream;

        public Connection(Socket socket, String userEmail, UserType userType, ObjectOutputStream outputStream, ObjectInputStream inputStream) {
            this.socket = socket;
            this.userEmail = userEmail;
            this.userType = userType;
            this.outputStream = outputStream;
            this.inputStream = inputStream;
        }
    }
}
