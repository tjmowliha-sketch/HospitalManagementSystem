import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SearchPatient extends JFrame implements ActionListener {

    JLabel l1, l2;

    JTextField t1;

    JTextArea area;

    JButton b1;

    SearchPatient() {

        setTitle("Search Patient");

        l1 = new JLabel("Enter Patient ID");

        t1 = new JTextField();

        b1 = new JButton("Search");

        area = new JTextArea();

        l1.setBounds(50, 30, 120, 30);

        t1.setBounds(180, 30, 150, 30);

        b1.setBounds(120, 90, 120, 40);

        area.setBounds(50, 160, 300, 150);

        add(l1);
        add(t1);
        add(b1);
        add(area);

        b1.addActionListener(this);

        setSize(420, 400);

        setLayout(null);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int id = Integer.parseInt(t1.getText());

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM patients WHERE patient_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String result = "";

                result += "Patient ID : " + rs.getInt("patient_id") + "\n";

                result += "Name : " + rs.getString("name") + "\n";

                result += "Age : " + rs.getInt("age") + "\n";

                result += "Gender : " + rs.getString("gender") + "\n";

                result += "Disease : " + rs.getString("disease");

                area.setText(result);

            } else {

                area.setText("Patient Not Found");

            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}