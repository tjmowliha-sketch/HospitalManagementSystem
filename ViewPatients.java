import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewPatients extends JFrame {

    JTable table;
    DefaultTableModel model;

    ViewPatients() {

        setTitle("View Patients");

        model = new DefaultTableModel();

        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("Disease");

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM patients";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                model.addRow(new Object[] {
                    rs.getInt("patient_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("disease")
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