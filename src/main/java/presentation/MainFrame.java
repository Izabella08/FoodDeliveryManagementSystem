package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;

public class MainFrame {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/";
    private final static String DB_NAME = "food_delivery";
    private final static String USER = "root";
    private final static String PASSWORD = "Izabella.08";

    JFrame frame;
    JPanel panel;
    JButton administrator;
    JButton client;
    JButton employee;
    JLabel username;
    JTextField usernameText;
    JLabel password;
    JPasswordField passwordText;
    JButton register;

    public MainFrame() {

        frame=new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(2, 200, 220));

        JLabel title = new JLabel("WELCOME!");
        title.setBounds(250, 10, 300, 70);
        title.setForeground(new Color(0, 0, 0));
        title.setBackground(new Color(2, 200, 220));
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setVisible(true);
        frame.add(title);

        panel = new JPanel();
        panel.setSize(900,300);
        panel.setBounds(0,0,800,500);
        panel.setBackground(new Color(2, 200, 220));
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);

        username=new JLabel("USERNAME:");
        username.setBounds(10,120,200,40);
        username.setFont(new Font("Aerial",Font.BOLD,30));
        username.setForeground(Color.BLACK);
        panel.add(username);
        usernameText=new JTextField();
        usernameText.setBounds(50,160,180,30);
        panel.add(usernameText);

        password=new JLabel("PASSWORD:");
        password.setBounds(10,200,200,40);
        password.setFont(new Font("Aerial",Font.BOLD,30));
        password.setForeground(Color.BLACK);
        panel.add(password);
        passwordText = new JPasswordField();
        passwordText.setBounds(50,240,180,30);
        panel.add(passwordText);

        administrator = new JButton("ADMINISTRATOR");
        administrator.setBounds(420,100,300,70);
        administrator.setBackground(new Color(0, 0, 0));
        administrator.setFont(new Font("Arial",Font.BOLD,30));
        administrator.setForeground(Color.WHITE);
        administrator.setFocusable(false);
        administrator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==administrator)
                {
                    //frame.dispose();
                    //AdministratorView adminV = new AdministratorView();
                    try {
                        Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
                        String u = usernameText.getText();
                        String pass = passwordText.getText();
                        //Statement s = c.createStatement();
                        String sql = "Select * from administrator Where username='" + u + "' and password='" + pass + "'";
                        PreparedStatement pst = c.prepareStatement(sql);
                        ResultSet rs = pst.executeQuery(sql);
                        if (u != null && pass != null) {
                            if (rs.next()) {
                                frame.dispose();
                                AdministratorView adminFrame = new AdministratorView();
                            } else {
                                JOptionPane.showMessageDialog(null, "LOGIN FAILED");
                                frame.dispose();
                            }
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }
            }
        });
        panel.add(administrator);

        client=new JButton("CLIENT");
        client.setBounds(420,210,300,70);
        client.setBackground(new Color(0, 0, 0));
        client.setFont(new Font("Arial",Font.BOLD,30));
        client.setForeground(Color.WHITE);
        client.setFocusable(false);
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==client)
                {
                    //frame.dispose();
                    //ClientView clientV = new ClientView();
                    try {
                        Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
                        String u = usernameText.getText();
                        String pass = passwordText.getText();
                        //Statement s = c.createStatement();
                        String sql = "Select * from client Where username='" + u + "' and password='" + pass + "'";
                        PreparedStatement pst = c.prepareStatement(sql);
                        ResultSet rs = pst.executeQuery(sql);
                        if (u != null && pass != null) {
                            if (rs.next()) {
                                frame.dispose();
                                ClientView clientV = new ClientView();
                            } else {
                                JOptionPane.showMessageDialog(null, "LOGIN FAILED");
                                frame.dispose();
                            }
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }
            }
        });
        panel.add(client);

        employee = new JButton("EMPLOYEE");
        employee.setBounds(420,320,300,70);
        employee.setBackground(new Color(0, 0, 0));
        employee.setFont(new Font("Arial",Font.BOLD,30));
        employee.setForeground(Color.WHITE);
        employee.setFocusable(false);
        employee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==employee)
                {
                    //frame.dispose();
                    //EmployeeView employeeV = new EmployeeView();
                    try {
                        Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
                        String u = usernameText.getText();
                        String pass = passwordText.getText();
                        //Statement s = c.createStatement();
                        String sql = "Select * from employee Where username='" + u + "' and password='" + pass + "'";
                        PreparedStatement pst = c.prepareStatement(sql);
                        ResultSet rs = pst.executeQuery(sql);
                        if (u != null && pass != null) {
                            if (rs.next()) {
                                frame.dispose();
                               // EmployeeView employeeV = new EmployeeView();
                            } else {
                                JOptionPane.showMessageDialog(null, "LOGIN FAILED");
                                frame.dispose();
                            }
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }
            }
        });
        panel.add(employee);

        register = new JButton("REGISTER");
        register.setBounds(10,320,300,70);
        register.setBackground(new Color(0, 0, 0));
        register.setFont(new Font("Arial",Font.BOLD,30));
        register.setForeground(Color.WHITE);
        register.setFocusable(false);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==register)
                {
                    frame.dispose();
                    RegisterFrame registerFrame = new RegisterFrame();
                }
            }
        });
        panel.add(register);

        frame.setVisible(true);
    }
}
