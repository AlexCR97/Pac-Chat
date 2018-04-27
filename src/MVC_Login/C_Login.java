package MVC_Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import javax.swing.*;

import UserData.Profile;
import java.net.ServerSocket;
import java.util.Arrays;

public class C_Login implements ActionListener {
    
    private final M_Login app;
    
    public C_Login(final M_Login app) {
        this.app = app;
        
        // Listeners
        app.view.exit.addActionListener(this);
        app.view.login.addActionListener(this);
        app.view.register.addActionListener(this);
        app.view.buttonIcon.addActionListener(this);
        app.view.buttonRegisterAccept.addActionListener(this);
        app.view.buttonRegisterCancel.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controlPanelLogin(e);
        controlPanelRegister(e);
    }
    
    private void controlPanelLogin(ActionEvent e) {
        if (e.getSource().equals(app.view.exit))
            app.view.dispose();
        
        if (e.getSource().equals(app.view.login)) {
            
        }
        
        if (e.getSource().equals(app.view.register))
            app.view.panels.show(app.view.container, V_Login.PANEL_REGISTER);
    }
    
    private void controlPanelRegister(ActionEvent e) {
        
        if (e.getSource().equals(app.view.buttonIcon)) {
            JFileChooser chooser = new JFileChooser();
            String path = null;
            int option = chooser.showOpenDialog(chooser);
            
            if (option == JFileChooser.APPROVE_OPTION) {
                path = chooser.getSelectedFile().getAbsolutePath();
            }
            
            if (path != null) {
                ImageIcon icon = new ImageIcon(path);
                app.view.userImage = icon;
                Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);
                app.view.buttonIcon.setIcon(icon);
            }
        }
        
        if (e.getSource().equals(app.view.buttonRegisterAccept))
            registerUser();
        
        if (e.getSource().equals(app.view.buttonRegisterCancel))
            app.view.panels.show(app.view.container, V_Login.PANEL_LOGIN);
        
    }
    
    private void registerUser() {
        
        // Reject registration
        String userName  = app.view.textRegisterUserName.getText();
        String password  = Arrays.toString(app.view.passRegisterPassword.getPassword());
        String passwordC = Arrays.toString(app.view.passRegisterPasswordC.getPassword());
        
        if (userName.equals("") || password.equals("") || passwordC.equals("")) {
            JOptionPane.showMessageDialog(
                    app.view,
                    "Revisa que todos los campos hayan sido llenados.",
                    "LLena todos los campos",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        // User exists. DONT CREATE USER
        if (queryUserExists(userName)) {
            JOptionPane.showMessageDialog(
                    app.view,
                    "Ese nombre de usuario ya esta ocupado. Prueba con otro",
                    "Nombre de usuario no disponible",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        // User does NOT exist. CREATE USER
        
        // Check if password are equal
        if (!password.equals(passwordC)) {
            JOptionPane.showMessageDialog(
                    app.view,
                    "La contraseña no coincide. Intentalo de nuevo",
                    "Contraseña incorrecta",
                    JOptionPane.ERROR_MESSAGE
            );
            app.view.passRegisterPassword.setText("");
            app.view.passRegisterPasswordC.setText("");
            return;
        }
        
        // CREATE THE USER
        final Profile user = new Profile(
                app.IP,
                userName,
                app.view.userImage,
                password
        );
        
        queryRegisterUser(user);
        
        JOptionPane.showMessageDialog(
                app.view,
                "Usuario creado! Ya puedes iniciar sesion :)",
                "Creacion exitosa",
                JOptionPane.PLAIN_MESSAGE
        );
        
    }
    
    private synchronized boolean queryUserExists(String userName) {
        
        try {
            
            // Send message to server
            Socket socket = new Socket(M_Login.SERVER_IP, M_Login.SERVER_PORT);
            
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println(M_Login.QUERY_USER_EXISTS);
            
            // Send query type
            writer.println(M_Login.QUERY_USER_EXISTS.toCharArray());
            
            // Send Login IP
            writer.println(app.IP.toCharArray());
            
            // Send Login PORT
            writer.println(app.PORT);
            
            // Send user name
            writer.println(userName.toCharArray());
            
            // Flush socket
            writer.flush();
            writer.close();
            socket.close();
            
            System.out.println("Query wrote!");
            
            // Recieve message from server
            socket = app.server.accept();
            
            // Read from server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            boolean check = reader.readLine().equals(M_Login.ANSWER_YES);
            
            System.out.println("User existsnace functions returns: " + check);
            
            reader.close();
            socket.close();
            
            return check;
            
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    private synchronized void queryRegisterUser(Profile user) {
        
        System.out.println("Inside registratino method");
        
        try {
            
            // Send socket to server
            Socket socket = new Socket(M_Login.SERVER_IP, M_Login.SERVER_PORT);
            
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            
            // Send query
            writer.println(M_Login.QUERY_REGUSTER_USER);
            System.out.println("Wrote query");
            
            writer.flush();
            writer.close();
            socket.close();
            
            // Send user
            socket = new Socket(M_Login.SERVER_IP, M_Login.SERVER_PORT);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);
            System.out.println("Wrote user");
            
            // Close streams
            oos.flush();
            oos.close();
            socket.close();
            
            System.out.println("Closed socket from register query");
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
