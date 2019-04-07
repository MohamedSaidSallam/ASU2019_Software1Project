import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

    private JFrame frame;
    private JTextField Password;
    private JTextField Name;

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 499, 441);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nam = Name.getText();
                String pass = Password.getText();
                try {
                    if ((nam.equals("admin")) && (pass.equals("admin"))) {
                        frame.dispose();
                        Adminmenu admon = new Adminmenu();
                        admon.setVisible(true);

                    } else {
                        frame.dispose();
                        UserMenu user = new UserMenu();
                        user.setVisible(true);
                    }

                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }
        });


        btnLogin.setBounds(222, 313, 97, 25);
        frame.getContentPane().add(btnLogin);

        Password = new JTextField();
        Password.setBounds(189, 242, 189, 25);
        frame.getContentPane().add(Password);
        Password.setColumns(10);

        JLabel lblS = new JLabel("Password");
        lblS.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblS.setForeground(UIManager.getColor("Button.darkShadow"));
        lblS.setBounds(87, 246, 74, 21);
        frame.getContentPane().add(lblS);

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(UIManager.getColor("Button.darkShadow"));
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblName.setBounds(105, 198, 56, 16);
        frame.getContentPane().add(lblName);

        Name = new JTextField();
        Name.setBounds(189, 196, 189, 25);
        frame.getContentPane().add(Name);
        Name.setColumns(10);

        JLabel lblNewLabel = new JLabel("Cinema Booking Robot");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblNewLabel.setBounds(141, 103, 243, 47);
        frame.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\owner\\eclipse-workspace\\Cinema Booking System\\images\\th9Q45DFDI.jpg"));
        label.setBounds(0, 0, 486, 394);
        frame.getContentPane().add(label);
    }
}
