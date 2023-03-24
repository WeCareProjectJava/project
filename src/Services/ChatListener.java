/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author eya_o
 */
// ChatListener.java


import models.Message;

public interface ChatListener {
    void onMessageReceived(Message message);
}

