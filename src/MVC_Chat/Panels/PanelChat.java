package MVC_Chat.Panels;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import UserData.Profile;
import UserData.ProfileContact;

public class PanelChat extends JPanel {
    
    private final Profile user;
    
    public JButton buttonSend;
    
    public PanelChat(final Profile user) {
        this.user = user;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        setPanelContact();
        setPanelChat();
        setPanelMessage();
    }
    
    private void setPanelContact() {
        
        JPanel panelContact = new JPanel();
        panelContact.setLayout(new BoxLayout(panelContact, BoxLayout.X_AXIS));
        
        // Info
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        
        JLabel labelName = new JLabel(user.activeChat.userName);
        JLabel labelState = new JLabel(user.activeChat.activeState);
        
        panelInfo.add(labelName);
        panelInfo.add(labelState);
        
        panelContact.add(panelInfo);
        
        // Image
        JPanel panelImage = new JPanel();
        panelImage.add(user.activeChat.buttonImage);
        
        panelContact.add(panelImage);
        
        this.add(panelContact);
    }
    
    private void setPanelChat() {
        
        JPanel panelChat = new JPanel();
        panelChat.setLayout(new BoxLayout(panelChat, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < 50; i++) {
            JLabel message = new JLabel("Mensaje " + (i + 1));
            
            message.setAlignmentX((i % 2 == 0)? JFrame.LEFT_ALIGNMENT : JFrame.RIGHT_ALIGNMENT);
            
            panelChat.add(message);
        }
        
        JScrollPane scroll = new JScrollPane(panelChat);
        
        this.add(scroll);
    }
    
    private void setPanelMessage() {
        
        JPanel panelMessage = new JPanel();
        panelMessage.setLayout(new BoxLayout(panelMessage, BoxLayout.X_AXIS));
        
        JTextField textMessage = new JTextField(30);
        buttonSend = new JButton("Send");
        
        panelMessage.add(textMessage);
        panelMessage.add(buttonSend);
        
        this.add(panelMessage);
        
    }
    
}
