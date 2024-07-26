package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient_Details extends JFrame {

    public Update_Patient_Details(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setLayout(null);
        panel.setBackground(new Color(147,197,66));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name : ");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try{
            conn c= new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number : ");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(248,129,140,20);
        panel.add(textField);

        JLabel label4 = new JLabel("In-Time : ");
        label4.setBounds(25,174,150,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldNTime = new JTextField();
        textFieldNTime.setBounds(248,174,140,20);
        panel.add(textFieldNTime);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("Check");
        check.setBounds(264,378,89,25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try{

                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next())
                    {
                        textField.setText(resultSet.getString("Room_Number"));
                        textFieldNTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposit"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textField.getText()+"'");
                    while (resultSet1.next())
                    {
                        String price = resultSet1.getString("Price");
                        int amountPaid= Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }

                }catch (Exception E ){
                    E.printStackTrace();
                }


            }
        });

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textField.getText();
                    String time = textFieldNTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"',Time = '"+time+"',Deposit = '"+amount+"' where name ='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(160,378,89,25);
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
        setSize(950,500);
        setLocation(200,220);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
