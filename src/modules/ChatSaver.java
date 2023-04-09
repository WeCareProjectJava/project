/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author eya_o
 */
public class ChatSaver {
/*    private static final String CHAT_FOLDER = "chats/";

    public static void saveChat(Chat chat) throws IOException {
        // create the chat folder if it doesn't exist
        File folder = new File(CHAT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // create the file name using the chat date
        String fileName = CHAT_FOLDER + chat.getDate().getTime() + ".txt";

        // write the chat messages to a file line by line
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Message message : chat.getMessages()) {
            String line = message.getSender()+ ": " + message.getContent();
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
*/
}
