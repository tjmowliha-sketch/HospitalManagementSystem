import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5;

    Dashboard() {
JLabel heading = new JLabel("HOSPITAL MANAGEMENT SYSTEM");

heading.setBounds(40, 10, 350, 30);

heading.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

add(heading);
        setTitle("Hospital Management System - Dashboard");
getContentPane().setBackground(java.awt.Color.LIGHT_GRAY);
        b1 = new JButton("Patients");
        b2 = new JButton("Doctors");
       b3 = new JButton("Appointments");
b4 = new JButton("Billing");
b5 = new JButton("Logout");

java.awt.Font btnFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);

b1.setFont(btnFont);
b2.setFont(btnFont);
b3.setFont(btnFont);
b4.setFont(btnFont);
b5.setFont(btnFont);
b1.setBackground(java.awt.Color.WHITE);
b2.setBackground(java.awt.Color.WHITE);
b3.setBackground(java.awt.Color.WHITE);
b4.setBackground(java.awt.Color.WHITE);


     heading.setBounds(320, 20, 500, 40);

b1.setBounds(500, 100, 250, 50);
b2.setBounds(500, 180, 250, 50);
b3.setBounds(500, 260, 250, 50);
b4.setBounds(500, 340, 250, 50);
b5.setBounds(500, 420, 250, 50);

       add(b1);
add(b2);
add(b3);
add(b4);
add(b5);

       b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

       setSize(1300, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

   if (e.getSource() == b1) {

   String[] options = {
    "Add Patient",
    "View Patients",
    "Delete Patient",
    "Update Patient",
    "Search Patient"
};

    int choice = JOptionPane.showOptionDialog(
            this,
            "Choose Option",
            "Patients",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
    );

    if (choice == 0) {

    new PatientForm();

}

else if (choice == 1) {

    new ViewPatients();

}

else if (choice == 2) {

    new DeletePatient();

}

else if (choice == 3) {

    new UpdatePatient();

}

else if (choice == 4) {

    new SearchPatient();

}
}

   else if (e.getSource() == b2) {

   String[] doctorOptions = {
    "Add Doctor",
    "View Doctors",
    "Delete Doctor"
};

    int doctorChoice = JOptionPane.showOptionDialog(
            this,
            "Choose Option",
            "Doctors",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            doctorOptions,
            doctorOptions[0]
    );

    if (doctorChoice == 0) {

        new DoctorForm();

    }

   else if (doctorChoice == 1) {

    new ViewDoctors();

}

else if (doctorChoice == 2) {

    new DeleteDoctor();

}
}

else if (e.getSource() == b4) {

    new BillingForm();

}

else if (e.getSource() == b5) {

    dispose();

    new Login();

}
else if (e.getSource() == b3) {

   String[] appointmentOptions = {
    "Book Appointment",
    "View Appointments",
    "Complete Appointment",
    "Patient History"
};

    int appointmentChoice = JOptionPane.showOptionDialog(
            this,
            "Choose Option",
            "Appointments",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            appointmentOptions,
            appointmentOptions[0]
    );

    if (appointmentChoice == 0) {

        new AppointmentForm();

    }

    else if (appointmentChoice == 1) {

    new ViewAppointments();

}

else if (appointmentChoice == 2) {

    new CompleteAppointment();

}

else if (appointmentChoice == 3) {

    new ViewHistory();

}
}
}
}