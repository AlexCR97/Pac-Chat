package MVC_Login;


import java.awt.*;
import javax.swing.*;

public class V_Login extends JFrame {
    
    private final M_Login app;
    
    public final Container container;
    
    // PANELS //////////////////////////////////////////////////////////////////
    
    public static final String PANEL_LOGIN = "Login";
    public static final String PANEL_REGISTER = "Register";
    
    public final CardLayout panels;
    
    // Panel Login
    public JPanel panelLogin;
    
    public JLabel title, usernameLbl, passwordLbl, lbl;
    public JTextField username;
    public JPasswordField password;
    public JButton login, exit, register;
    public JPanel topPane, centerPane, bottomPane, bottomPane2;    
    
    // Panel register
    public JPanel panelRegister;
    public JButton buttonIcon;
    public JTextField textRegisterUserName;
    public JPasswordField passRegisterPassword;
    public JPasswordField passRegisterPasswordC;
    public JButton buttonRegisterCancel;
    public JButton buttonRegisterAccept;
    
    public ImageIcon userImage;
    
    ////////////////////////////////////////////////////////////////////////////
    
    public V_Login(final M_Login app) {
        this.app = app;
        userImage = new ImageIcon("src\\Assets\\debug.png");
        
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.container = this.getContentPane();
        this.panels = new CardLayout();
        this.container.setLayout(panels);
        
        setPanelLogin();
        setPanelRegister();
        
        panels.show(container, PANEL_LOGIN);
        this.setVisible(true);
    }
    
    private void setPanelLogin() {
        panelLogin = new JPanel();
        
        topPane = new JPanel();
        centerPane = new JPanel();
        bottomPane = new JPanel();
        bottomPane2 = new JPanel();
        panelLogin = new JPanel();
        panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));
        
        title = new JLabel("Inicia sesion en Pac-Chat");
        topPane.add(title);
        
        centerPane.setLayout(new FlowLayout());
        
        usernameLbl = new JLabel("Usuario: ");
        username = new JTextField(25);
        centerPane.add(usernameLbl);
        centerPane.add(username);
        
        passwordLbl = new JLabel("Contraseña: ");
        password = new JPasswordField(25);
        centerPane.add(passwordLbl);
        centerPane.add(password);
        
        bottomPane.setLayout(new FlowLayout());
        login = new JButton("Inicia Sesion");
        exit = new JButton("Salir");
        bottomPane.add(login);
        bottomPane.add(exit);
        
        lbl = new JLabel("No tienes una?");
        register = new JButton("Registrate!");
        bottomPane2.setLayout(new FlowLayout());
        bottomPane2.add(lbl);
        bottomPane2.add(register);
        
        panelLogin.add(topPane);
        panelLogin.add(centerPane);
        panelLogin.add(bottomPane);
        panelLogin.add(bottomPane2);
        
        // Add to container
        panels.addLayoutComponent(panelLogin, V_Login.PANEL_LOGIN);
        container.add(panelLogin);
    }
    
    private void setPanelRegister() {
        
        panelRegister = new JPanel();
        panelRegister.setLayout(new BoxLayout(panelRegister, BoxLayout.Y_AXIS));
        
        JPanel panelIcon      = new JPanel();
        JPanel panelUserName  = new JPanel(new FlowLayout());
        JPanel panelPassword  = new JPanel(new FlowLayout());
        JPanel panelPasswordC = new JPanel(new FlowLayout());
        JPanel panelButtons   = new JPanel(new FlowLayout());
        
        ImageIcon icon = new ImageIcon("src\\Assets\\debug.png");
        Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        
        this.buttonIcon = new JButton(icon);
        
        JLabel labelUserName = new JLabel("Escoge un nombre de usuario: ");
        this.textRegisterUserName = new JTextField(20);
        
        JLabel labelPassword = new JLabel("Escoge una contraseña: ");
        this.passRegisterPassword = new JPasswordField(20);
        
        JLabel labelPasswordC = new JLabel("Comprueba tu contraseña: ");
        this.passRegisterPasswordC = new JPasswordField(20);
        
        this.buttonRegisterAccept = new JButton("Aceptar");
        this.buttonRegisterCancel = new JButton("Cancelar");
        
        panelIcon.add(this.buttonIcon);
        
        panelUserName.add(labelUserName);
        panelUserName.add(this.textRegisterUserName);
        
        panelPassword.add(labelPassword);
        panelPassword.add(this.passRegisterPassword);
        
        panelPasswordC.add(labelPasswordC);
        panelPasswordC.add(this.passRegisterPasswordC);
        
        panelButtons.add(this.buttonRegisterAccept);
        panelButtons.add(this.buttonRegisterCancel);
        
        panelRegister.add(panelIcon);
        panelRegister.add(panelUserName);
        panelRegister.add(panelPassword);
        panelRegister.add(panelPasswordC);
        panelRegister.add(panelButtons);
        
        // Add to container
        panels.addLayoutComponent(panelRegister, V_Login.PANEL_REGISTER);
        container.add(panelRegister);
    }
    
}
