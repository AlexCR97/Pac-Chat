package MVC_Chat;

import java.awt.*;
import javax.swing.*;

import MVC_Chat.Panels.PanelChat;
import MVC_Chat.Panels.PanelContacts;
import MVC_Chat.Panels.PanelConversations;
import MVC_Chat.Panels.PanelProfile;

public class V_Chat extends JPanel {
    
    // Panels
    private final JPanel panelGlobal;
    private final PanelContacts panelContacts;
    private final PanelChat panelChat;
    private final PanelConversations panelConversations;
    private final PanelProfile panelProfile;
    
    // Model
    private final M_Chat app;
    
    // Frame
    private final JFrame frame;
    private final Container container;
    
    public V_Chat(final M_Chat app) {
        this.app = app;
        
        // Frame setup
        frame = new JFrame();
        frame.setTitle("Pac-Chat");
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.container = frame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        // Global panel
        this.panelGlobal = new JPanel();
        container.add(panelGlobal);
        
        // Chat panels
        this.panelChat = new PanelChat(app.user);
        this.panelContacts = new PanelContacts(app.user);
        this.panelConversations = new PanelConversations(app.user);
        this.panelProfile = new PanelProfile(app.user);
        
        // Panel setup
        JPanel panelUp = new JPanel();
        JPanel panelDown = new JPanel();
        panelDown.setLayout(new BoxLayout(panelDown, BoxLayout.X_AXIS));
        
        container.add(panelUp, BorderLayout.NORTH);
        container.add(panelDown, BorderLayout.SOUTH);
        
        panelUp.add(this.panelContacts);
        
        JPanel panelDownLeft = new JPanel();
        panelDownLeft.setLayout(new BoxLayout(panelDownLeft, BoxLayout.Y_AXIS));
        
        panelDownLeft.add(this.panelChat);
        panelDownLeft.add(this.panelProfile);
        
        panelDown.add(panelDownLeft);
        
        JPanel panelDownRight = new JPanel();
        
        panelDownRight.add(this.panelConversations);
        
        panelDown.add(panelDownRight);
        
        frame.setVisible(true);
    }
    
}
