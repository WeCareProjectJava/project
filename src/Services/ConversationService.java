/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author eya_o
 */


import models.Communication;
import fasterxml.jackson.core.type.TypeReference;
import javaxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConversationService {

    private ObjectMapper objectMapper;

    public ConversationService() {
        objectMapper = new ObjectMapper();
    }

    public List<Communication> loadConversationsFromFile(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            throw new IOException("Invalid file path: " + filePath);
        }

        // Deserialize the JSON data into a list of Communication objects
        List<Communication> conversations = objectMapper.readValue(file, new TypeReference<List<Communication>>() {});

        return conversations; // Return the list of loaded conversations
    }

    public boolean saveConversationsToFile(List<Communication> conversations, String filePath) throws IOException {
        File file = new File(filePath);

        // Serialize the list of Communication objects into a JSON format
        objectMapper.writeValue(file, conversations);

        return true; // Return true if the conversations are saved successfully
    }
}

