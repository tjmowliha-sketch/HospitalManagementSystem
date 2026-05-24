import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewHistory extends JFrame {

    JTable table;

    DefaultTableModel model;

    ViewHistory() {

        setTitle("Patient History");

        model = new DefaultTableModel();

        table = new JTable(model);

        model.addColumn("History ID");
        model.addColumn("Patient");
        model.addColumn("Doctor");
        model.addColumn("Date");
        model.addColumn("Disease");

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM patient_history";

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while (rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("history_id"),

                        rs.getString("patient_name"),

                        rs.getString("doctor_name"),

                        rs.getString("appointment_date"),

                        rs.getString("disease")
                });
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        JScrollPane sp =
                new JScrollPane(table);

        add(sp);

        setSize(700, 400);

        setLocationRelativeTo(null);

        setVisible(true);
    }
}