package MVC_Login;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class M_Login {
    
    // Model
    public V_Login view;
    public C_Login controller;
    
    // Info for server
    public String IP;
    public int PORT = 7785;
    
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT  = 7895;
    
    public ServerSocket server;
    
    // Queries
    public static final String QUERY_REGUSTER_USER = "Register";
    public static final String QUERY_USER_EXISTS   = "User existance";
    public static final String QUERY_LOGIN         = "Login";
    
    public static final String ANSWER_YES = "Yes";
    public static final String ANSWER_NO  = "No";
    
    public M_Login() {
        try {
            IP = getComputerIP();
            server = new ServerSocket(PORT);
            
            System.out.println("Login IP: " + IP);
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        view = new V_Login(this);
        controller = new C_Login(this);
        
    }
    
    public static String getComputerIP() {
        
        try {
            return InetAddress.getLocalHost().toString().split("/")[1];
        } catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
