import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewAppointments extends JFrame {

    JTable table;

    DefaultTableModel model;

    ViewAppointments() {

        setTitle("View Appointments");

        model = new DefaultTableModel();

        table = new JTable(model);

        model.addColumn("Appointment ID");
        model.addColumn("Patient Name");
        model.addColumn("Doctor Name");
        model.addColumn("Appointment Date");

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM appointments";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("appointment_id"),
                        rs.getString("patient_name"),
                        rs.getString("doctor_name"),
                        rs.getString("appointment_date")

                });
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        JScrollPane sp = new JScrollPane(table);

        add(sp);

        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}