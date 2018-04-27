package UserData;

import MVC_Login.M_Login;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Profile implements Serializable {
    
    public static final String STATE_AVAILABLE     = "Disponible";
    public static final String STATE_BUSY          = "Ocupado";
    public static final String STATE_NOT_AVAILABLE = "No Disponible";
    public String activeState = STATE_AVAILABLE;
    
    public static final Color COLOR_AVAILABLE     = Color.GREEN;
    public static final Color COLOR_BUSY          = Color.RED;
    public static final Color COLOR_NOT_AVAILABLE = Color.GRAY;
    public Color activeColor = COLOR_AVAILABLE;
    
    public String IP;
    public String userName;
    public ImageIcon userImage;
    public String password;
    
    public ArrayList<ProfileContact> contacts;
    public ProfileContact activeChat;
    
    public Profile(String IP, String userName, ImageIcon userImage, String password) {
        this.IP        = IP;
        this.userName  = userName;
        this.password  = password;
        this.userImage = userImage;
        
        contacts = new ArrayList<>();
    }
    
    public void updateIP() {
        this.IP = M_Login.getComputerIP();
    }
    
    @Override
    public String toString() {
        return  "User name: " + userName + "\n" +
                "Password:  " + password + "\n" +
                "IP:        " + IP       + "\n" +
                "Contacts:  " + contacts.size() + "\n";
    }
    
}
