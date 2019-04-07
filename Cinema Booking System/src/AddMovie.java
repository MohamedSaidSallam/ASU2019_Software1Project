import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;

public class AddMovie extends JFrame {
	private JTextField plot;
	private JTextField name;
	private JTextField score;
	private JTextField duration;
	private JTextField Trailer;
	private JLabel Label;
	String s;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovie frame = new AddMovie();
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
	public AddMovie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Browse = new JButton("Browse");
		Browse.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
	                JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
	                fileChooser.addChoosableFileFilter(filter);
	                int result = fileChooser.showSaveDialog(null);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File selectedFile = fileChooser.getSelectedFile();
	                    String path = selectedFile.getAbsolutePath();
	                    Label.setIcon(ResizeImage(path));
	                    s = path;
	                } else if (result == JFileChooser.CANCEL_OPTION) {
	                    System.out.println("No Data");
	                }
	            }
	        });
		Browse.setBounds(510, 303, 97, 25);
		contentPane.add(Browse);
		
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showMessageDialog(null, "your movie has been saved");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		Save.setBounds(366, 436, 97, 25);
		contentPane.add(Save);
		
		plot = new JTextField();
		plot.setBounds(12, 281, 340, 123);
		contentPane.add(plot);
		plot.setColumns(10);


		JLabel lblNewLabel_1 = new JLabel("plot");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(47, 252, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trailer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(30, 208, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(30, 43, 56, 16);
		contentPane.add(label);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblScore.setBounds(30, 89, 56, 16);
		contentPane.add(lblScore);
		
		JLabel lblGeners = new JLabel("Geners");
		lblGeners.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGeners.setBounds(30, 127, 56, 16);
		contentPane.add(lblGeners);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDuration.setBounds(30, 161, 73, 16);
		contentPane.add(lblDuration);
		
		name = new JTextField();
		name.setBounds(115, 42, 179, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		score = new JTextField();
		score.setColumns(10);
		score.setBounds(115, 88, 179, 22);
		contentPane.add(score);
		
		duration = new JTextField();
		duration.setColumns(10);
		duration.setBounds(115, 160, 179, 22);
		contentPane.add(duration);
		
		Trailer = new JTextField();
		Trailer.setColumns(10);
		Trailer.setBounds(115, 207, 179, 22);
		contentPane.add(Trailer);
		
		JComboBox generes =new JComboBox(classes.Genre.values());;
		generes.setBounds(115, 126, 179, 22);
		contentPane.add(generes);

		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			private JFrame frame=new JFrame();

			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.dispose();
                    Adminmenu admon = new Adminmenu();
                    admon.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		back.setBounds(152, 436, 97, 25);
		contentPane.add(back);
		
	 Label = new JLabel("");
		Label.setBounds(463, 43, 165, 225);
		contentPane.add(Label);
		Border border = BorderFactory.createLineBorder(Color.BLACK); // add border
        Label.setBorder(border);

	}
	   public ImageIcon ResizeImage(String imgPath) {
	        ImageIcon MyImage = new ImageIcon(imgPath);
	        Image img = MyImage.getImage();
	        Image newImage = img.getScaledInstance(Label.getWidth(), Label.getHeight(), img.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImage);
	        return image;
	    }
}
