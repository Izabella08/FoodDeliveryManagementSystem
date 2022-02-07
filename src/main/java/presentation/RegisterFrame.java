package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterFrame extends JFrame{

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/";
    private final static String DB_NAME = "food_delivery";
    private final static String USER = "root";
    private final static String PASSWORD = "Izabella.08";

    JLabel username;
    JTextField usernameText;
    JLabel password;
    JPasswordField passwordText;
    JButton backButton;
    JButton readyButton;

    public RegisterFrame() {
        this.setSize(700, 500);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(2, 200, 220));

        JLabel title = new JLabel("CREATE AN ACCOUNT:");
        title.setBounds(100, 5, 500, 100);
        title.setForeground(new Color(0, 0, 0));
        title.setBackground(new Color(2, 200, 220));
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setVisible(true);
        this.add(title);

        username=new JLabel("USERNAME:");
        username.setBounds(230,120,200,40);
        username.setFont(new Font("Aerial",Font.BOLD,30));
        username.setForeground(Color.BLACK);
        this.add(username);
        usernameText=new JTextField();
        usernameText.setBounds(230,160,180,30);
        this.add(usernameText);

        password=new JLabel("PASSWORD:");
        password.setBounds(230,200,200,40);
        password.setFont(new Font("Aerial",Font.BOLD,30));
        password.setForeground(Color.BLACK);
        this.add(password);
        passwordText = new JPasswordField();
        passwordText.setBounds(230,240,180,30);
        this.add(passwordText);

        backButton=new JButton("Back");
        backButton.setBounds(470,400,150,30);
        backButton.setBackground(new Color(0, 0,0));
        backButton.setFont(new Font("Aerial", Font.BOLD,20));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==backButton)
                {
                    dispose();
                    MainFrame v=new MainFrame();
                }
            }
        });
        this.add(backButton);

        readyButton=new JButton("READY!");
        readyButton.setBounds(240,300,150,30);
        readyButton.setBackground(new Color(0, 0,0));
        readyButton.setFont(new Font("Aerial", Font.BOLD,20));
        readyButton.setForeground(Color.WHITE);
        readyButton.setFocusable(false);
        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==readyButton)
                {
                    //dispose();
                    //View v1=new View();
                    String query="{call client_nou(?, ?)}";
                    ResultSet resultSet;
                    try(Connection c= DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
                        CallableStatement statement = (CallableStatement) c.prepareCall(query);)
                    {
                        String usernamee;
                        String passwordd;
                        usernamee =usernameText.getText().toString();
                        passwordd =passwordText.getText().toString();
                        statement.setString(1, usernamee);
                        statement.setString(2, passwordd);
                        resultSet=statement.executeQuery();
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Your account was created succesfully!");
                        dispose();
                        MainFrame v1=new MainFrame();
                    }
                    catch (SQLException e1)
                    {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }
            }
        });
        this.add(readyButton);

        this.setVisible(true);
    }
}
