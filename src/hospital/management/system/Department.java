package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {


     public Department(){


         JPanel panel = new JPanel();
         panel.setBounds(5,5,690,485);
         panel.setLayout(null);
         panel.setBackground(new Color(147,197,66));
         add(panel);

         JTable table = new JTable();
         table.setBounds(0,40,700,350);
         table.setBackground(new Color(147,197,66));
         table.setFont(new Font("Tahoma",Font.BOLD,14));
         panel.add(table);

         try{

             conn c = new conn();
             String q = "select * from department";
             ResultSet resultSet = c.statement.executeQuery(q);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));


         }catch (Exception e)
         {
             e.printStackTrace();
         }

         JLabel label1 = new JLabel("Department");
         label1.setBounds(145,11,105,20);
         label1.setFont(new Font("Tahoma",Font.BOLD,14));
         panel.add(label1);

         JLabel label2 = new JLabel("Phone Number");
         label2.setBounds(431,11,150,20);
         label2.setFont(new Font("Tahoma",Font.BOLD,14));
         panel.add(label2);

         JButton back = new JButton("BACK");
         back.setBounds(400,410,130,30);
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
         setSize(700,494);
         setLayout(null);
         setLocation(290,220);
         setVisible(true);
     }

    public static void main(String[] args) {
          new Department();
    }

}
