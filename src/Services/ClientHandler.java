/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author eya_o
 */
// ClientHandler.java


// 

import models.Message;
import Services.UserType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Map<String, ClientHandler> clients;
    private String userEmail;
    private UserType userType;

    public ClientHandler(Socket socket, Map<String, ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            // Receive user info
            userEmail = (String) inputStream.readObject();
            userType = (UserType) inputStream.readObject();

            // Receive messages
            while (true) {
                Message message = (Message) inputStream.readObject();
                if (isValidRecipient(message)) {
                    ClientHandler recipientHandler = clients.get(message.getReceiver());
                    if (recipientHandler != null) {
                        recipientHandler.sendMessage(message);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            clients.remove(userEmail);
            closeResources();
        }
    }

    private void sendMessage(Message message) throws IOException {
        if (outputStream != null) {
            outputStream.writeObject(message);
            outputStream.flush();
        }
    }

    private boolean isValidRecipient(Message message) {
        ClientHandler recipientHandler = clients.get(message.getReceiver());
        return recipientHandler != null && recipientHandler.userType != this.userType;
    }

    private void closeResources() {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
