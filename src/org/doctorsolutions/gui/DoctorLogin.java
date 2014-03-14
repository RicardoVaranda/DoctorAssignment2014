package org.doctorsolutions.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement; 
import javax.swing.SwingConstants;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;

import java.awt.Component;

@SuppressWarnings("serial")
public class DoctorLogin extends JFrame {
	
	//		setBounds(0, 0, 500 ,350); 
	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	public DoctorLogin() {
		setTitle("VetMaster 2.0");
		
		setBounds(0, 0, 318 ,173); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("LOGIN");
		
		JTextArea textArea = new JTextArea();
		
		JTextArea textArea_1 = new JTextArea();
		
		JLabel lblUsername = new JLabel("USERNAME");
		
		JLabel lblPassword = new JLabel("PASSWORD");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(111, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, Alignment.TRAILING)
						.addComponent(textArea_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	}
	
	public static void initLookAndFeel()
	{
		UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
		try
		{
			String key = new String(new byte[] { 
					67, 49, 52, 49, 48, 50, 57, 52, 45, 54, 49, 66, 54, 52, 65, 65,
					67, 45, 52, 66, 55, 68, 51, 48, 51, 57, 45, 56, 51, 52, 65,
					56, 50, 65, 49, 45, 51, 55, 69, 53, 68, 54, 57, 53 
					},
					"UTF-8");
			if(key != null)
			{
				String[] license = { 
						"License=AppWork UG",
						"LicenseRegistrationNumber=289416475",
						"Product=Synthetica",
						"LicenseType=Small Business License",
						"ExpireDate=--.--.----", "MaxVersion=2.999.999" };
				UIManager.put("Synthetica.license.info", license);
				UIManager.put("Synthetica.license.key", key);
			}
			UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
		} 
		catch (UnsupportedLookAndFeelException | ParseException e)
		{
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) 
	   {
		   java.awt.EventQueue.invokeLater(new Runnable() {
	           public void run() {
	               try {
	            	   initLookAndFeel();
	            	   //UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
	                               //  "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	                               //UIManager.getCrossPlatformLookAndFeelClassName());
	               } catch (Exception ex) {
	                   ex.printStackTrace();
	               }
	               new DoctorLogin().setVisible(true);
	           }
	       });
	   }  
}
