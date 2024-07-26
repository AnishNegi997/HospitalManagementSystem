package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    //textField
    JTextField textField;

    //password field
    JPasswordField passwordField;

    JButton b1,b2;

    Login(){

        // User Name
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(namelabel);

        // Password
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        add(password);

        //text Field

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        //password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        passwordField.setBackground(new Color(255,179,0));
        add(passwordField);

        // setPhoto on side

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/loginH.jpg"));//check once again
        Image i1 = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);

        //Login Button
        b1= new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);

        add(b1);

        // cancel button
        b2= new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);



        setUndecorated(true);
        getContentPane().setBackground(new Color(147,197,66));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1)
        {
            try{

                conn c = new conn();

                String user = textField.getText();
                String Pass = passwordField.getText();

                String p = "select * from login where ID = '"+user+"' and pass = '"+Pass+"'"; // query
                ResultSet resultSet = c.statement.executeQuery(p);

                if(resultSet.next())
                {
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }


            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else{

            System.exit(1000);

        }

    }
}
