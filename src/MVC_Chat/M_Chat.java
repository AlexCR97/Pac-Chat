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
    
    public M_Chat(final Profile user) {
        this.user = user;
        
        view       = new V_Chat(this);
        controller = new C_Chat(this);
        
    }
    
}
