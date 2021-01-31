package app.email.gui;

import javax.swing.*;
import java.awt.Color;


public class Login {

    private final JLabel[] texfieldNames = new JLabel[5];
    private final JTextField nickName;
    private final JTextField emailAddress;
    private final JTextField smtpAddress;
    private final JTextField smtpPort;
    private final JPasswordField passwordText;
    private final JMenuBar menuBar;
    private final JMenu helpMenu;
    private final JMenuItem subPortMenu;
    private final Window window;

    private final int width = 450;
    private final int height = 600;


    {
        window = new Window();
        nickName = new JTextField();
        emailAddress = new JTextField();
        smtpAddress = new JTextField();
        smtpPort = new JTextField();
        passwordText = new JPasswordField();
        menuBar = new JMenuBar();
        helpMenu = new JMenu("Help");
        subPortMenu = new JMenuItem("PortList");
    }

    public Login() {
        window.createWin("Login Window", width,height);
        init();
    }

    private void init() {
        //Menu System
        window.getFrame().setJMenuBar(menuBar);
        menuBar.add(helpMenu);
        helpMenu.add(subPortMenu);

        //Declare location&size for Login Textfields
        texfieldNames[0] = new JLabel("Nickname");
        texfieldNames[0].setForeground(Color.WHITE);
        texfieldNames[0].setBounds(100,10,100,20);

        nickName.setBounds(100, 40, 200, 30);
        /*
        emailAddress.setBounds();
        smtpAddress.setBounds();
        smtpPort.setBounds();
        passwordText.setBounds();
        */

        //Add all components
        for (int i = 0; i < texfieldNames.length; i++) {
            if(i==1) break;
            window.add(texfieldNames[i]);
        }
        window.add(nickName);
        window.add(emailAddress);
        window.add(smtpAddress);
        window.add(smtpPort);
        window.add(passwordText);
    }

    private void portListing() {
        subPortMenu.addActionListener(e -> {
            //TODO Help for port list
        });
    }
}
