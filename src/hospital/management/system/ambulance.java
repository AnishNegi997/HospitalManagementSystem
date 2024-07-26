package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ambulance extends JFrame {

    public ambulance(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,500);
        panel.setLayout(null);
        panel.setBackground(new Color(147,197,66));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,300);
        table.setBackground(new Color(147,197,66));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try{

            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Driver");
        label1.setBounds(90,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(284,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Vehicle");
        label3.setBounds(486,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setBounds(670,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(850,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JButton back = new JButton("BACK");
        back.setBounds(400,400,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(1000,510);
        setLocation(230,220);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ambulance();
    }
}
