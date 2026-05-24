import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AppointmentForm extends JFrame implements ActionListener {

    JLabel l1, l2, l3;

    JTextField t1, t2, t3;

    JButton b1;

    AppointmentForm() {

        setTitle("Book Appointment");

        l1 = new JLabel("Patient Name");
        l2 = new JLabel("Doctor Name");
        l3 = new JLabel("Appointment Date");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        b1 = new JButton("Book Appointment");

        l1.setBounds(50, 50, 120, 30);
        l2.setBounds(50, 100, 120, 30);
        l3.setBounds(50, 150, 120, 30);

        t1.setBounds(180, 50, 150, 30);
        t2.setBounds(180, 100, 150, 30);
        t3.setBounds(180, 150, 150, 30);

        b1.setBounds(110, 230, 170, 40);

        add(l1);
        add(l2);
        add(l3);

        add(t1);
        add(t2);
        add(t3);

        add(b1);

        b1.addActionListener(this);

        setSize(420, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String patient = t1.getText();

        String doctor = t2.getText();

        String date = t3.getText();

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO appointments(patient_name, doctor_name, appointment_date) VALUES (?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, patient);
            pst.setString(2, doctor);
            pst.setString(3, date);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Appointment Booked Successfully");

            t1.setText("");
            t2.setText("");
            t3.setText("");

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}