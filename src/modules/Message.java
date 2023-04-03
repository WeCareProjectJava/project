/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

/**
 *
 * @author eya_o
 */
import modules.UserType;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime timestamp;
    private UserType userType;

  public Message(String sender, String receiver, String content) {
    this.sender = sender;
    this.receiver = receiver;
    this.content = content;
    this.timestamp= LocalDateTime.now();
}

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}