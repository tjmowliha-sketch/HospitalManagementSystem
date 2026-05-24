import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1;

    Login() {

        setTitle("Hospital Management System - Login");

        l1 = new JLabel("Username:");
        l2 = new JLabel("Password:");

        t1 = new JTextField();
        t2 = new JPasswordField();

        b1 = new JButton("Login");

        l1.setBounds(420, 180, 120, 30);
l2.setBounds(420, 250, 120, 30);

t1.setBounds(560, 180, 180, 30);
t2.setBounds(560, 250, 180, 30);

b1.setBounds(520, 340, 120, 40);

        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(b1);

        b1.addActionListener(this);

        setSize(1300, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String username = t1.getText();
        String password = t2.getText();

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

    JOptionPane.showMessageDialog(this, "Login Successful");

    dispose();

    new Dashboard();

} else {

                JOptionPane.showMessageDialog(this, "Invalid Username or Password");

            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}