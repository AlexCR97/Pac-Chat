package MVC_Chat;

import javax.swing.*;

import UserData.Profile;
import UserData.ProfileContact;

public class M_Chat {
    
    // Model properties
    public final V_Chat view;
    public final C_Chat controller;
    
    // User
    public final Profile user;
    
    public M_Chat() {
        user = setUser();
        
        view       = new V_Chat(this);
        controller = new C_Chat(this);
        
    }
    
    private Profile setUser() {
        
        Profile user = new Profile(
            "localhost",
            "Alejandro",
            new ImageIcon("src\\Assets\\debug.png"),
            "12345"
        );
        
        for (int i = 0; i < 10; i++)
            user.contacts.add(
                new ProfileContact(
                    "Contact " + i,
                    new ImageIcon("src\\Assets\\debug.png"),
                    "Last message " + i
                )
            );
        
        user.activeChat = user.contacts.get(0);
        
        return user;
    }
    
}
