package app.email.gui;

import app.email.connection.EmailSender;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login {

    private ImageIcon icon;
    private final Window window;
    private final JTextField nickName;
    private final JTextField emailAddress;
    private final JTextField smtpAddress;
    private final JTextField smtpPort;
    private final JPasswordField passwordText;
    private final JLabel[] textfieldNames = new JLabel[5];
    private final JButton button;
    private final JMenuBar menuBar;
    private final JMenu helpMenu;
    private final JMenuItem subPortMenu;

    private final int width = 450;
    private final int height = 600;

    {
        icon = new ImageIcon("src/main/resources/icons8_key_64px.png");
        window = new Window();
        nickName = new JTextField();
        emailAddress = new JTextField();
        smtpAddress = new JTextField();
        smtpPort = new JTextField();
        passwordText = new JPasswordField();
        button = new JButton();
        menuBar = new JMenuBar();
        helpMenu = new JMenu("Help");
        subPortMenu = new JMenuItem("PortList");
    }

    public Login() {
        window.createWin("Login Window", width,height);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                window.getFrame().setVisible(true);
            }
        });
        init();
        portListing();
    }

    private void init() {

        //Button
        button.setText("login");
        button.setBounds(200-75/2,90+180+60,75,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EmailSender s = new EmailSender();
                s.loginToAccount(getSmtpaddress(),getSmtpPort(), getEmailaddress(), getPassword());
                s.sendEmail(s.getSession(),getNickname(), getEmailaddress(), getEmailaddress(), "Your new Mail Programm","Welcome to Mail app");

            }
        });

        //Frameicon
        window.getFrame().setIconImage(icon.getImage());

        //Menu System
        window.getFrame().setJMenuBar(menuBar);

        //Declare location&size for Login Textfields
        declareLabels("Nickname",0);
        nickName.setBounds(100, 30, 200, 30);

        declareLabels("Emailaddress",1);
        emailAddress.setBounds(100,90,200,30);

        declareLabels("Password",2);
        passwordText.setBounds(100,90+60,200,30);

        declareLabels("SmptAddress",3);
        smtpAddress.setBounds(100,90+120,200,30);

        declareLabels("SmptPort",4);
        smtpPort.setBounds(100,90+180,200,30);


        //Add all components
        for (JLabel texfieldName : textfieldNames) {
            window.add(texfieldName);
        }
        menuBar.add(helpMenu);
        helpMenu.add(subPortMenu);
        window.add(button);
        window.add(nickName);
        window.add(emailAddress);
        window.add(smtpAddress);
        window.add(smtpPort);
        window.add(passwordText);
    }

    private void declareLabels(String name, int index) {
        if(index != 0) {
            textfieldNames[index] = new JLabel(name);
            textfieldNames[index].setForeground(Color.WHITE);
            textfieldNames[index].setBounds(100, index*(60)+10, 100, 20);
        }else{
            textfieldNames[index] = new JLabel(name);
            textfieldNames[index].setForeground(Color.WHITE);
            textfieldNames[index].setBounds(100, 10, 100, 20);
        }
    }

    private void portListing() {
        subPortMenu.addActionListener(e -> {
            //TODO Help for port list
            System.out.println("Help Menu");
        });
    }

    public String getNickname() {
        return nickName.getText();
    }
    public String getEmailaddress() {
        return emailAddress.getText();
    }
    public String getPassword() {
        return passwordText.getText();
    }
    public String getSmtpaddress() {
        return smtpAddress.getText();
    }
    public String getSmtpPort() {
        return smtpPort.getText();
    }

}
