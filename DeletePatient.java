import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DeletePatient extends JFrame implements ActionListener {

    JLabel l1;

    JTextField t1;

    JButton b1;

    DeletePatient() {

        setTitle("Delete Patient");

        l1 = new JLabel("Enter Patient ID");

        t1 = new JTextField();

        b1 = new JButton("Delete");

        l1.setBounds(50, 50, 120, 30);

        t1.setBounds(180, 50, 150, 30);

        b1.setBounds(120, 120, 120, 40);

        add(l1);
        add(t1);
        add(b1);

        b1.addActionListener(this);

        setSize(400, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int id = Integer.parseInt(t1.getText());

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM patients WHERE patient_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this, "Patient Deleted Successfully");

            } else {

                JOptionPane.showMessageDialog(this, "Patient ID Not Found");

            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}