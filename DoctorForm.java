import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DoctorForm extends JFrame implements ActionListener {

    JLabel l1, l2;

    JTextField t1, t2;

    JButton b1;

    DoctorForm() {

        setTitle("Add Doctor");

        l1 = new JLabel("Doctor Name");
        l2 = new JLabel("Specialization");

        t1 = new JTextField();
        t2 = new JTextField();

        b1 = new JButton("Save Doctor");

        l1.setBounds(50, 50, 120, 30);
        l2.setBounds(50, 100, 120, 30);

        t1.setBounds(180, 50, 150, 30);
        t2.setBounds(180, 100, 150, 30);

        b1.setBounds(120, 180, 150, 40);

        add(l1);
        add(l2);

        add(t1);
        add(t2);

        add(b1);

        b1.addActionListener(this);

        setSize(420, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = t1.getText();

        String specialization = t2.getText();

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO doctors(name, specialization) VALUES (?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setString(2, specialization);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Doctor Added Successfully");

            t1.setText("");
            t2.setText("");

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}