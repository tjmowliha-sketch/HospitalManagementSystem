import java.awt.event.*;
import javax.swing.*;

public class BillingForm extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;

    JTextField t1, t2, t3;

    JButton b1;

    BillingForm() {

        setTitle("Billing System");

        l1 = new JLabel("Consultation Fee");
        l2 = new JLabel("Medicine Charges");
        l3 = new JLabel("Room Charges");
        l4 = new JLabel("");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        b1 = new JButton("Calculate Bill");

        l1.setBounds(50, 50, 140, 30);
        l2.setBounds(50, 100, 140, 30);
        l3.setBounds(50, 150, 140, 30);

        t1.setBounds(220, 50, 120, 30);
        t2.setBounds(220, 100, 120, 30);
        t3.setBounds(220, 150, 120, 30);

        b1.setBounds(110, 230, 170, 40);

        l4.setBounds(100, 300, 250, 30);

        add(l1);
        add(l2);
        add(l3);
        add(l4);

        add(t1);
        add(t2);
        add(t3);

        add(b1);

        b1.addActionListener(this);

        setSize(450, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int consultation = Integer.parseInt(t1.getText());

        int medicine = Integer.parseInt(t2.getText());

        int room = Integer.parseInt(t3.getText());

        int total = consultation + medicine + room;

        l4.setText("Total Bill Amount = Rs. " + total);
    }
}