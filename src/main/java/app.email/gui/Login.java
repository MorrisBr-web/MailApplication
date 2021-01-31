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
        declareLabels("Nickname",0);
        nickName.setBounds(100, 30, 200, 30);

        declareLabels("Emailaddress",1);
        emailAddress.setBounds(100,90,200,30);

        declareLabels("SmptAddress",2);
        smtpAddress.setBounds(100,90+60,200,30);

        declareLabels("SmptPort",3);
        smtpPort.setBounds(100,90+120,200,30);

        declareLabels("Password",4);
        passwordText.setBounds(100,90+180,200,30);

        //Add all components
        for (JLabel texfieldName : texfieldNames) {
            window.add(texfieldName);
        }
        window.add(nickName);
        window.add(emailAddress);
        window.add(smtpAddress);
        window.add(smtpPort);
        window.add(passwordText);
    }

    private void declareLabels(String name, int index) {
        if(index != 0) {
            texfieldNames[index] = new JLabel(name);
            texfieldNames[index].setForeground(Color.WHITE);
            texfieldNames[index].setBounds(100, index*(60)+10, 100, 20);
        }else{
            texfieldNames[index] = new JLabel(name);
            texfieldNames[index].setForeground(Color.WHITE);
            texfieldNames[index].setBounds(100, 10, 100, 20);
        }
    }

    private void portListing() {
        subPortMenu.addActionListener(e -> {
            //TODO Help for port list
        });
    }
}
