/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author eya_o
 */
// ChatClient.java


// ChatClient.java


import models.Message;
import Services.UserType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatClient {
    private String host;
    private int port;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ChatListener chatListener;

    public ChatClient(String host, int port, ChatListener chatListener) {
        this.host = host;
        this.port = port;
        this.chatListener = chatListener;
    }

    public void connect(String userEmail, UserType userType) throws IOException {
        socket = new Socket(host, port);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());

        // Send user info
        outputStream.writeObject(userEmail);
        outputStream.writeObject(userType);
        outputStream.flush();

        // Start listening for incoming messages
        new Thread(() -> {
            try {
                while (true) {
                    Message message = (Message) inputStream.readObject();
                    if (chatListener != null) {
                        chatListener.onMessageReceived(message);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                closeResources();
            }
        }).start();
    }

    public void sendMessage(Message message) throws IOException {
        if (outputStream != null) {
            outputStream.writeObject(message);
            outputStream.flush();
        }
    }

    public void disconnect() {
        closeResources();
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

