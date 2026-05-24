import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class PatientForm extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;

    JTextField t1, t2, t3, t4;

    JButton b1;

    PatientForm() {

        setTitle("Add Patient");

        l1 = new JLabel("Patient Name");
        l2 = new JLabel("Age");
        l3 = new JLabel("Gender");
        l4 = new JLabel("Disease");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        b1 = new JButton("Save Patient");

        l1.setBounds(50, 50, 100, 30);
        l2.setBounds(50, 100, 100, 30);
        l3.setBounds(50, 150, 100, 30);
        l4.setBounds(50, 200, 100, 30);

        t1.setBounds(180, 50, 150, 30);
        t2.setBounds(180, 100, 150, 30);
        t3.setBounds(180, 150, 150, 30);
        t4.setBounds(180, 200, 150, 30);

        b1.setBounds(120, 270, 150, 40);

        add(l1);
        add(l2);
        add(l3);
        add(l4);

        add(t1);
        add(t2);
        add(t3);
        add(t4);

        add(b1);

        b1.addActionListener(this);

        setSize(450, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = t1.getText();
        String age = t2.getText();
        String gender = t3.getText();
        String disease = t4.getText();

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO patients(name, age, gender, disease) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, Integer.parseInt(age));
            pst.setString(3, gender);
            pst.setString(4, disease);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Patient Added Successfully");

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}