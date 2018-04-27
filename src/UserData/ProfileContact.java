package UserData;

import java.awt.*;
import javax.swing.*;

public class ProfileContact {
    
    public String activeState = Profile.STATE_AVAILABLE;
    public Color activeColor = Profile.COLOR_AVAILABLE;
    
    public String userName;
    public ImageIcon userImage;
    public String lastMessage;
    public JButton buttonImage;
    
    public ProfileContact(String userName, ImageIcon userImage, String lastMessage) {
        this.userName    = userName;
        this.lastMessage = lastMessage;
        this.userImage   = userImage;
        
        final ImageIcon icon = new ImageIcon(this.userImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        this.buttonImage = new JButton(icon);
        this.buttonImage.setBorder(BorderFactory.createLineBorder(activeColor, 2));
    }
    
}
