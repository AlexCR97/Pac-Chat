package MVC_Chat.Panels;

import java.awt.*;
import javax.swing.*;

import UserData.Profile;
import UserData.ProfileContact;

public class PanelConversations extends JPanel{
    
    private final Profile user;
    
    public PanelConversations(final Profile user){
        this.user = user;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        buildPanel();
    }
    
    public void buildPanel(){
        JPanel topPane = new JPanel();
        
        topPane.add(new JLabel("Conversaciones"));
        add(topPane);
        
        JPanel centralPane = new JPanel();
        centralPane.setLayout(new BoxLayout(centralPane, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < user.contacts.size(); i++) {
            PanelConversation temp = new PanelConversation(user.contacts.get(i));
            temp.setAlignmentX(JFrame.LEFT_ALIGNMENT);
            centralPane.add(temp);
        }
        
        this.add(centralPane);
        
        JScrollPane scrollPanel = new JScrollPane(centralPane);
        scrollPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(scrollPanel);
    }
    
}

class PanelConversation extends JPanel{
    
    public JButton userPic;
    private Color activeState;
    public JLabel userName;
    public JLabel lastConversation;
    
    public PanelConversation(ProfileContact user){
        
        userPic = user.buttonImage;
        userName = new JLabel(user.userName);
        lastConversation = new JLabel(user.lastMessage);
        activeState = user.activeColor;
        
        JPanel picPanel = new JPanel(), textPanel = new JPanel();
        
        userPic.setBorder(BorderFactory.createLineBorder(activeState, 2));
        picPanel.add(userPic);
        
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(userName);
        textPanel.add(lastConversation);
        
        add(picPanel, BorderLayout.EAST);
        add(textPanel, BorderLayout.CENTER);
    }
}
