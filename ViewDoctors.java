import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewDoctors extends JFrame {

    JTable table;

    DefaultTableModel model;

    ViewDoctors() {

        setTitle("View Doctors");

        model = new DefaultTableModel();

        table = new JTable(model);

        model.addColumn("Doctor ID");
        model.addColumn("Doctor Name");
        model.addColumn("Specialization");

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM doctors";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("doctor_id"),
                        rs.getString("name"),
                        rs.getString("specialization")

                });
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        JScrollPane sp = new JScrollPane(table);

        add(sp);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}