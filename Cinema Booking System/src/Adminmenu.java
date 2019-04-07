import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JSlider;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.ScrollPane;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;

public class Adminmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminmenu frame = new Adminmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adminmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Browse Movies");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(47, 151, 156, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Movies");
		btnNewButton_1.addActionListener(new ActionListener() {
			private JFrame frame=new JFrame();

			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
                    AddMovie admon = new AddMovie();
                    admon.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(47, 66, 156, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\owner\\eclipse-workspace\\Cinema Booking System\\images\\3.png"));
		lblNewLabel.setBounds(12, 0, 228, 240);
		contentPane.add(lblNewLabel);
	}
}
