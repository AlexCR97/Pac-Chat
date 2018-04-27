package MVC_Chat.Panels;

import java.awt.*;
import javax.swing.*;

import UserData.Profile;
import UserData.ProfileContact;

public class PanelContacts extends JPanel {
    
    private final Profile user;
    
    public JButton buttonAdd;
    
    public PanelContacts(final Profile user) {
        this.user = user;
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        setPanelContacts();
        setPanelAdd();
    }
    
    private void setPanelContacts() {
        
        JPanel panelContacts = new JPanel();
        panelContacts.setLayout(new BoxLayout(panelContacts, BoxLayout.X_AXIS));
        JScrollPane scroll = new JScrollPane(panelContacts);
        
        if (user.contacts.isEmpty()) {
            System.out.println("Empty");
            
        } else {
            System.out.println("Size: " + user.contacts.size());
            for (ProfileContact contact: user.contacts) {
                JPanel panelFriend = new JPanel();
                panelFriend.setLayout(new BoxLayout(panelFriend, BoxLayout.Y_AXIS));
                
                final JButton button = contact.buttonImage;
                final String name    = contact.userName;
                final String state   = contact.activeState;
                
                panelFriend.add(button);
                panelFriend.add(new JLabel(name));
                panelFriend.add(new JLabel(state));
                
                panelContacts.add(panelFriend);
                panelContacts.add(Box.createHorizontalStrut(10));
            }
        }
        
        this.add(scroll);
    }
    
    private void setPanelAdd() {
        JPanel panelAdd = new JPanel();
        
        buttonAdd = new JButton("Add");
        
        panelAdd.add(buttonAdd);
        
        this.add(panelAdd);
    }
    
}
