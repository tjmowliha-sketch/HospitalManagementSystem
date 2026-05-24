import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CompleteAppointment extends JFrame implements ActionListener {

    JLabel l1, l2;

    JTextField t1, t2;

    JButton b1;

    CompleteAppointment() {

        setTitle("Complete Appointment");

        l1 = new JLabel("Appointment ID");
        l2 = new JLabel("Disease");

        t1 = new JTextField();
        t2 = new JTextField();

        b1 = new JButton("Complete");

        l1.setBounds(50, 50, 120, 30);
        l2.setBounds(50, 100, 120, 30);

        t1.setBounds(180, 50, 150, 30);
        t2.setBounds(180, 100, 150, 30);

        b1.setBounds(120, 180, 120, 40);

        add(l1);
        add(l2);

        add(t1);
        add(t2);

        add(b1);

        b1.addActionListener(this);

        setSize(420, 320);

        setLayout(null);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int appointmentId = Integer.parseInt(t1.getText());

        String disease = t2.getText();

        try {

            Connection con = DBConnection.getConnection();

            String fetchQuery =
                    "SELECT * FROM appointments WHERE appointment_id=?";

            PreparedStatement pst1 =
                    con.prepareStatement(fetchQuery);

            pst1.setInt(1, appointmentId);

            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {

                String patient =
                        rs.getString("patient_name");

                String doctor =
                        rs.getString("doctor_name");

                String date =
                        rs.getString("appointment_date");

                String insertQuery =
                        "INSERT INTO patient_history(patient_name, doctor_name, appointment_date, disease) VALUES (?, ?, ?, ?)";

                PreparedStatement pst2 =
                        con.prepareStatement(insertQuery);

                pst2.setString(1, patient);

                pst2.setString(2, doctor);

                pst2.setString(3, date);

                pst2.setString(4, disease);

                pst2.executeUpdate();

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment Completed & History Stored"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment ID Not Found"
                );
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}