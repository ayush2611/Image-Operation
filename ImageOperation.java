package ImageOperation_Project;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ImageOperation {
	
	public static void Operate(int key) {
		JFileChooser filechooser= new JFileChooser();
		filechooser.showOpenDialog(null);
		File file=filechooser.getSelectedFile();
		
		
		//file input stream
		try {
			FileInputStream fis= new FileInputStream(file);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			int i=0;
			
			for (byte b : data) {
				System.out.println(b);
				data[i]=(byte)(b^key);
				i++;
			}
			FileOutputStream fos= new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null,"Done");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Image Operation");
		f.setSize(400,400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setting up font
		Font font = new Font("Roboto",Font.BOLD,25);
		
		
		
		
		//creating button
		JButton button = new JButton();
		button.setText("Open Image");
		button.setFont(font);
		
		
		
		
		//creating text field
		JTextField textfield = new JTextField(10);
		textfield.setFont(font);
		
		
		//adding a listener
		button.addActionListener(e->{
			System.out.println("Button clicked");
			String text=textfield.getText();
			int temp = Integer.parseInt(text);
			Operate(temp);
			
		});
		
		//setting layout
		f.setLayout(new FlowLayout());
		
		
		f.add(button);
		f.add(textfield);
		
		f.setVisible(true);
		
		
	}
	

}
