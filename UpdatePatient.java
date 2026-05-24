import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdatePatient extends JFrame implements ActionListener {

    JLabel l1, l2;

    JTextField t1, t2;

    JButton b1;

    UpdatePatient() {

        setTitle("Update Patient Disease");

        l1 = new JLabel("Patient ID");
        l2 = new JLabel("New Disease");

        t1 = new JTextField();
        t2 = new JTextField();

        b1 = new JButton("Update");

        l1.setBounds(50, 50, 120, 30);
        l2.setBounds(50, 100, 120, 30);

        t1.setBounds(180, 50, 150, 30);
        t2.setBounds(180, 100, 150, 30);

        b1.setBounds(120, 170, 120, 40);

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

        int id = Integer.parseInt(t1.getText());

        String disease = t2.getText();

        try {

            Connection con = DBConnection.getConnection();

            String query = "UPDATE patients SET disease=? WHERE patient_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, disease);

            pst.setInt(2, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this, "Patient Updated Successfully");

            } else {

                JOptionPane.showMessageDialog(this, "Patient ID Not Found");

            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}