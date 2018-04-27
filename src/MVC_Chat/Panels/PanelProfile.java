package MVC_Chat.Panels;

import java.awt.*;
import javax.swing.*;

import UserData.Profile;

public class PanelProfile extends JPanel {
    
    private final Profile user;
    
    public JButton buttonImage;
    public JButton buttonSettings;
    
    public PanelProfile(final Profile user) {
        this.user = user;
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        setPanelImage();
        setPanelInfo();
        setPanelSettings();
    }
    
    private void setPanelImage() {
        JPanel panelImage = new JPanel();
        
        Image image   = user.userImage.getImage();
        Image resized = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        buttonImage = new JButton(new ImageIcon(resized));
        buttonImage.setBorder(BorderFactory.createLineBorder(user.activeColor, 2));
        
        panelImage.add(buttonImage);
        
        this.add(panelImage);
    }
    
    private void setPanelInfo() {
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        
        JLabel labelName = new JLabel(user.userName);
        JLabel labelState = new JLabel(user.activeState);
        
        panelInfo.add(labelName);
        panelInfo.add(labelState);
        
        this.add(panelInfo);
    }
    
    private void setPanelSettings() {
        JPanel panelSettings = new JPanel();
        
        buttonSettings = new JButton(":v");
        buttonSettings.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        panelSettings.add(buttonSettings);
        
        this.add(panelSettings);
    }
    
}
