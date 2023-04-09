/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

/**
 *
 * @author eya_o
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatLoader {
   /* private static final String CHAT_FOLDER = "chats/";

    public static List<Message> loadChat(LocalDateTime chatDate) throws IOException {
        List<Message> messages = new ArrayList<>();

        create the file name using the chat date
       String fileName = CHAT_FOLDER + chatDate.getTime() + ".txt";
        File file = new File(fileName);

        // read the messages from the file line by line
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ", 2);
            if (parts.length == 2) {
                String sender = parts[0];
                String content = parts[1];
                Message message = new Message(sender, null, content);
                messages.add(message);
            }
        }
        reader.close();

        return messages;
    }*/
}
