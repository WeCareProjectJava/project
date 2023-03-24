/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author eya_o
 */


/*

import fasterxml.jackson.databind.ObjectMapper;
import fasterxml.jackson.databind.type.CollectionType;
import models.Doctor;
import models.Patient;
import models.User;
import Services.UserType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServices {

    private ObjectMapper objectMapper;
    private File usersFile;

    public UserServices() {
        objectMapper = new ObjectMapper();
        usersFile = new File("users.json");
    }

    public User login(String email, String password, UserType userType) {
        List<User> users = loadUsers();
        Optional<User> user = users.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password) && u.getUserType() == userType)
                .findFirst();

        return user.orElse(null);
    }

    public boolean registerUser(User user) {
        List<User> users = loadUsers();
        users.add(user);
        return saveUsers(users);
    }

    private List<User> loadUsers() {
        if (usersFile.exists()) {
            try {
                CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
                return objectMapper.readValue(usersFile, listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private boolean saveUsers(List<User> users) {
        try {
            objectMapper.writeValue(usersFile, users);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
*/

