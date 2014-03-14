package org.doctorsolutions.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import org.doctorsolutions.io.DatabaseManager;
import org.doctorsolutions.model.patients.PatientInfo;
 
public class DoctorMenu {
	
	public static JTextField txtSearchUser = new JTextField();
	public static JTextField txtPatientName = new JTextField();
	public static JTextField txtPatientNumber = new JTextField();
	public static JTextArea txtPatientAddress = new JTextArea();
	public static JTextField txtPatientEmail = new JTextField();
	public static JTextField txtContactNo = new JTextField();
	public static JTextField textField_2 = new JTextField();
	public static JTextField textField_3 = new JTextField();
	public static JTextField textField_4 = new JTextField();
	public static JTextField textField_5 = new JTextField();
	public static JTextField textField_6 = new JTextField();
	public static JTextField textField_7 = new JTextField();
	public static JTextField txtPatientDOB = new JTextField();  
	public static final JTextField txtPatientGender = new JTextField();
    private static JTabbedPane tabPnl = new JTabbedPane(JTabbedPane.TOP);
    private static ImagePanel panel = new ImagePanel(new ImageIcon("E:/VetMaster2.0/data/DoctorBG.png").getImage());
    private static JFrame frmVetmaster = new JFrame();
    private static final JLayeredPane lPnlMain = new JLayeredPane();
    private static final JLayeredMenuPane lPnlDoctorMenu = new JLayeredMenuPane();
    private static final JLayeredMenuPane lPnlPatientMenu = new JLayeredMenuPane(); 
    private static JButton btnSearchPatient = new JButton(""); 
    private static JButton btnAddPatient = new JButton("");
    private static JButton btnDeletePatient = new JButton("");
    private static JButton btnEditPatient = new JButton("");
    private static JButton btnSearchDoctor = new JButton("");
    private static JButton btnAddDoctor = new JButton("");
    private static JButton btnDeleteDoctor = new JButton("");
    private static JButton btnEditDoctor = new JButton("");
    private static JScrollPane scrollPane = new JScrollPane();
    private static JPanel pnlPatientD = new JPanel();
    private static JLabel lblPatientName = new JLabel("Patient Name:"); 
    private static JLabel lblPatientNumber = new JLabel("Patient Number:");
    private static JLabel lblPatientAddress = new JLabel("Patient Address:");
    private static JLabel lblPatientDob = new JLabel("Patient DOB:");
    private static JLabel lblPatientEmail = new JLabel("Patient Email:");
    private static JLabel lblContactNo = new JLabel("Patient Contact:");
    private static JScrollPane scrlMedical = new JScrollPane();
    private static JPanel pnlMedicalH = new JPanel();
    private static JLabel lblDescription = new JLabel("Description:");
    private static JLabel lblTreatment = new JLabel("Treatment:");
    private static JCheckBox chkPaidMedical1 = new JCheckBox("Paid");
    private static JPanel pnlAppointments = new JPanel();
    private static JLabel lblDoctorAppointed = new JLabel("Doctor:");
    //private static JLabel lblApointmentTime = new JLabel("Appointment Time:");
    private static JLabel lblAppointmentReason = new JLabel("Appointment Reason:");
    private static JLabel lblAppointmentTime = new JLabel("Appointment Time:");
    private static JLabel lblAppointmentDuration = new JLabel("Appointment Duration:");
    private static JLayeredPane lPnlMenu = new JLayeredPane();
    private static JButton btnDoctors = new JButton("");
    private static JButton btnPatients = new JButton("");
    private static JButton btnApointments = new JButton("");
    private static final JLabel lblPatientGender = new JLabel("Patient Gender:");
    private static final JLabel label = new JLabel("01/05/2014");
    private static final JLabel label_1 = new JLabel("Description:");
    private static final JTextField textField = new JTextField();
    private static final JLabel label_2 = new JLabel("Treatment:");
    private static final JTextField textField_1 = new JTextField();
    private static final JCheckBox checkBox = new JCheckBox("Paid");
    private static final JLabel label_3 = new JLabel("01/05/2014");
    private static final JLabel label_4 = new JLabel("Description:");
    private static final JTextField textField_8 = new JTextField();
    private static final JCheckBox checkBox_1 = new JCheckBox("Paid");
  
  public static void main(String[] args) {
    
    try {
		DatabaseManager.connect();
		DatabaseManager.disconnect();
	} catch (ClassNotFoundException e1) { 
		e1.printStackTrace();
	} catch (SQLException e1) { 
		e1.printStackTrace();
	}
    
    drawGUI(); 

  }
  
  public static void drawGUI()
  {
 
	    frmVetmaster.setTitle("VetMaster");
	    frmVetmaster.setExtendedState(Frame.MAXIMIZED_BOTH);  
	    frmVetmaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frmVetmaster.getContentPane().add(panel, BorderLayout.EAST);
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[]{158, 731, 0, 0};
	    gbl_panel.rowHeights = new int[]{266, 428, 137, 0, 0, 0};
	    gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
	    gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
	    panel.setLayout(gbl_panel);
  
	    lPnlMain.setVisible(false);
	    lPnlMain.setDoubleBuffered(true); 
	    lPnlMain.setBackground(new Color(0, 0, 0, 100));
	    GridBagConstraints gbc_lPnlMain = new GridBagConstraints();
	    gbc_lPnlMain.insets = new Insets(0, 0, 5, 5);
	    gbc_lPnlMain.fill = GridBagConstraints.BOTH;
	    gbc_lPnlMain.gridx = 1;
	    gbc_lPnlMain.gridy = 1;
	    panel.add(lPnlMain, gbc_lPnlMain);
	    GridBagLayout gbl_lPnlMain = new GridBagLayout();
	    gbl_lPnlMain.columnWidths = new int[]{96, 186, 409, 0};
	    gbl_lPnlMain.rowHeights = new int[]{30, 20, 340, 0, 0};
	    gbl_lPnlMain.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    gbl_lPnlMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    lPnlMain.setLayout(gbl_lPnlMain);
	     
	    lPnlDoctorMenu.setVisible(false);
	     
	    lPnlPatientMenu.setVisible(false);
	    
	    
	    GridBagConstraints gbc_txtSearchUser = new GridBagConstraints();
	    gbc_txtSearchUser.anchor = GridBagConstraints.NORTH;
	    gbc_txtSearchUser.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtSearchUser.insets = new Insets(0, 0, 5, 5);
	    gbc_txtSearchUser.gridx = 1;
	    gbc_txtSearchUser.gridy = 1;
	    lPnlMain.add(txtSearchUser, gbc_txtSearchUser);
	    txtSearchUser.setColumns(10);
	    GridBagConstraints gbc_lPnlPatientMenu = new GridBagConstraints();
	    gbc_lPnlPatientMenu.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lPnlPatientMenu.insets = new Insets(0, 0, 5, 5);
	    gbc_lPnlPatientMenu.gridx = 0;
	    gbc_lPnlPatientMenu.gridy = 2;
	    lPnlMain.add(lPnlPatientMenu, gbc_lPnlPatientMenu);
	    GridBagLayout gbl_lPnlPatientMenu = new GridBagLayout();
	    gbl_lPnlPatientMenu.columnWidths = new int[]{0, 0, 0, 0};
	    gbl_lPnlPatientMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
	    gbl_lPnlPatientMenu.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
	    gbl_lPnlPatientMenu.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
	    lPnlPatientMenu.setLayout(gbl_lPnlPatientMenu);
	    
	    
	    btnSearchPatient.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\search_male_user.png"));
	    btnSearchPatient.setRolloverEnabled(false);
	    btnSearchPatient.setOpaque(false);
	    btnSearchPatient.setBorder(null);
	    btnSearchPatient.setBackground(new Color(0, 0, 0, 0));
	    GridBagConstraints gbc_btnSearchPatient = new GridBagConstraints();
	    gbc_btnSearchPatient.insets = new Insets(0, 0, 5, 5);
	    gbc_btnSearchPatient.gridx = 1;
	    gbc_btnSearchPatient.gridy = 1;
	    lPnlPatientMenu.add(btnSearchPatient, gbc_btnSearchPatient);
	    
	    
	    btnAddPatient.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\add_male_user.png"));
	    btnAddPatient.setBackground(new Color(0, 0, 0, 0));
	    btnAddPatient.setBorder(null);
	    btnAddPatient.setRolloverEnabled(false);
	    btnAddPatient.setOpaque(false);
	    GridBagConstraints gbc_btnAddPatient = new GridBagConstraints();
	    gbc_btnAddPatient.insets = new Insets(0, 0, 5, 5);
	    gbc_btnAddPatient.gridx = 1;
	    gbc_btnAddPatient.gridy = 2;
	    lPnlPatientMenu.add(btnAddPatient, gbc_btnAddPatient);
	    
	    
	    btnDeletePatient.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\remove_male_user.png"));
	    btnDeletePatient.setRolloverEnabled(false);
	    btnDeletePatient.setOpaque(false);
	    btnDeletePatient.setBorder(null);
	    btnDeletePatient.setBackground(new Color(0, 0, 0, 0));
	    GridBagConstraints gbc_btnDeletePatient = new GridBagConstraints();
	    gbc_btnDeletePatient.insets = new Insets(0, 0, 5, 5);
	    gbc_btnDeletePatient.gridx = 1;
	    gbc_btnDeletePatient.gridy = 3;
	    lPnlPatientMenu.add(btnDeletePatient, gbc_btnDeletePatient);
	    
	    btnEditPatient.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\edit_male_user.png"));
	    btnEditPatient.setRolloverEnabled(false);
	    btnEditPatient.setOpaque(false);
	    btnEditPatient.setBorder(null);
	    btnEditPatient.setBackground(new Color(0, 0, 0, 0));
	    GridBagConstraints gbc_btnEditPatient = new GridBagConstraints();
	    gbc_btnEditPatient.insets = new Insets(0, 0, 5, 5);
	    gbc_btnEditPatient.gridx = 1;
	    gbc_btnEditPatient.gridy = 4;
	    lPnlPatientMenu.add(btnEditPatient, gbc_btnEditPatient);
	    GridBagConstraints gbc_lPnlDoctorMenu = new GridBagConstraints();
	    gbc_lPnlDoctorMenu.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lPnlDoctorMenu.insets = new Insets(0, 0, 5, 5);
	    gbc_lPnlDoctorMenu.gridx = 0;
	    gbc_lPnlDoctorMenu.gridy = 2;
	    lPnlMain.add(lPnlDoctorMenu, gbc_lPnlDoctorMenu);
	    GridBagLayout gbl_lPnlDoctorMenu = new GridBagLayout();
	    gbl_lPnlDoctorMenu.columnWidths = new int[]{0, 0, 0, 0};
	    gbl_lPnlDoctorMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
	    gbl_lPnlDoctorMenu.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
	    gbl_lPnlDoctorMenu.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
	    lPnlDoctorMenu.setLayout(gbl_lPnlDoctorMenu);
	    
	    
	    btnSearchDoctor.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\search_business_user.png"));
	    btnSearchDoctor.setRolloverEnabled(false);
	    btnSearchDoctor.setOpaque(false);
	    btnSearchDoctor.setBorder(null);
	    btnSearchDoctor.setBackground(new Color(0, 0, 0, 0));
	    GridBagConstraints gbc_btnSearchDoctor = new GridBagConstraints();
	    gbc_btnSearchDoctor.insets = new Insets(0, 0, 5, 5);
	    gbc_btnSearchDoctor.gridx = 1;
	    gbc_btnSearchDoctor.gridy = 1;
	    lPnlDoctorMenu.add(btnSearchDoctor, gbc_btnSearchDoctor);
	    
	    btnAddDoctor.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\add_business_user.png"));
	    btnAddDoctor.setRolloverEnabled(false);
	    btnAddDoctor.setOpaque(false);
	    btnAddDoctor.setBorder(null);
	    btnAddDoctor.setBackground(new Color(0, 0, 0, 0));
	    GridBagConstraints gbc_btnAddDoctor = new GridBagConstraints();
	    gbc_btnAddDoctor.insets = new Insets(0, 0, 5, 5);
	    gbc_btnAddDoctor.gridx = 1;
	    gbc_btnAddDoctor.gridy = 2;
	    lPnlDoctorMenu.add(btnAddDoctor, gbc_btnAddDoctor);
	    
	    btnDeleteDoctor.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\remove_business_user.png"));
	    btnDeleteDoctor.setRolloverEnabled(false);
	    btnDeleteDoctor.setOpaque(false);
	    btnDeleteDoctor.setBorder(null);
	    btnDeleteDoctor.setBackground(new Color(0, 0, 0, 0));
	    GridBagConstraints gbc_btnDeleteDoctor = new GridBagConstraints();
	    gbc_btnDeleteDoctor.insets = new Insets(0, 0, 5, 5);
	    gbc_btnDeleteDoctor.gridx = 1;
	    gbc_btnDeleteDoctor.gridy = 3;
	    lPnlDoctorMenu.add(btnDeleteDoctor, gbc_btnDeleteDoctor);
	    
	    btnEditDoctor.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\edit_business_user.png"));
	    btnEditDoctor.setRolloverEnabled(false);
	    btnEditDoctor.setOpaque(false);
	    btnEditDoctor.setBorder(null);
	    btnEditDoctor.setBackground(new Color(0, 0, 0, 0));
	    GridBagConstraints gbc_btnEditDoctor = new GridBagConstraints();
	    gbc_btnEditDoctor.insets = new Insets(0, 0, 5, 5);
	    gbc_btnEditDoctor.gridx = 1;
	    gbc_btnEditDoctor.gridy = 4;
	    lPnlDoctorMenu.add(btnEditDoctor, gbc_btnEditDoctor);
	    
	    GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	    gbc_scrollPane.fill = GridBagConstraints.BOTH;
	    gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
	    gbc_scrollPane.gridx = 1;
	    gbc_scrollPane.gridy = 2;
	    lPnlMain.add(scrollPane, gbc_scrollPane);
	    
	    ListSelectionModel listSelectionModel;
	    JList lstNames = new JList();
	    scrollPane.setViewportView(lstNames);
	    lstNames.setModel(new AbstractListModel() {
	    	String[] values = new String[] {};
	    	public int getSize() {
	    		return PatientInfo.numPatients;
	    	}
	    	public Object getElementAt(int index) {
	    		return PatientInfo.patientName[index];
	    	}
	    });
	    listSelectionModel = lstNames.getSelectionModel();
        listSelectionModel.addListSelectionListener(
                new SharedListSelectionHandler());
	    lstNames.setToolTipText("");
	    

	    GridBagConstraints gbc_tabPnl = new GridBagConstraints();
	    gbc_tabPnl.insets = new Insets(0, 0, 5, 0);
	    gbc_tabPnl.fill = GridBagConstraints.BOTH;
	    gbc_tabPnl.gridx = 2;
	    gbc_tabPnl.gridy = 2;
	    tabPnl.setVisible(false);
	    lPnlMain.add(tabPnl, gbc_tabPnl);
	    
	    tabPnl.addTab("Patient Details", (Icon) null, pnlPatientD, null);
	    GridBagLayout gbl_pnlPatientD = new GridBagLayout();
	    gbl_pnlPatientD.columnWidths = new int[]{0, 0, 0, 0};
	    gbl_pnlPatientD.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	    gbl_pnlPatientD.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
	    gbl_pnlPatientD.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
	    pnlPatientD.setLayout(gbl_pnlPatientD);
	    
	    lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblPatientName = new GridBagConstraints();
	    gbc_lblPatientName.fill = GridBagConstraints.VERTICAL;
	    gbc_lblPatientName.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPatientName.gridx = 0;
	    gbc_lblPatientName.gridy = 1;
	    pnlPatientD.add(lblPatientName, gbc_lblPatientName);
	    
	    txtPatientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtPatientName.setText("No Information Available");
	    txtPatientName.setEditable(false);
	    GridBagConstraints gbc_txtPatientName = new GridBagConstraints();
	    gbc_txtPatientName.insets = new Insets(0, 0, 5, 0);
	    gbc_txtPatientName.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtPatientName.gridx = 2;
	    gbc_txtPatientName.gridy = 1;
	    pnlPatientD.add(txtPatientName, gbc_txtPatientName);
	    txtPatientName.setColumns(10);
	    
	    lblPatientNumber.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	    lblPatientNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblPatientNumber = new GridBagConstraints();
	    gbc_lblPatientNumber.fill = GridBagConstraints.VERTICAL;
	    gbc_lblPatientNumber.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPatientNumber.gridx = 0;
	    gbc_lblPatientNumber.gridy = 2;
	    pnlPatientD.add(lblPatientNumber, gbc_lblPatientNumber);
	    
	    
	    txtPatientNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtPatientNumber.setText("No Information Available");
	    txtPatientNumber.setEditable(false);
	    txtPatientNumber.setColumns(10);
	    GridBagConstraints gbc_txtPatientNumber = new GridBagConstraints();
	    gbc_txtPatientNumber.insets = new Insets(0, 0, 5, 0);
	    gbc_txtPatientNumber.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtPatientNumber.gridx = 2;
	    gbc_txtPatientNumber.gridy = 2;
	    pnlPatientD.add(txtPatientNumber, gbc_txtPatientNumber);
	    
	    lblPatientAddress.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	    lblPatientAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblPatientAddress = new GridBagConstraints();
	    gbc_lblPatientAddress.fill = GridBagConstraints.VERTICAL;
	    gbc_lblPatientAddress.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPatientAddress.gridx = 0;
	    gbc_lblPatientAddress.gridy = 3;
	    pnlPatientD.add(lblPatientAddress, gbc_lblPatientAddress);
	    
	    txtPatientAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtPatientAddress.setText("No Information Available");
	    txtPatientAddress.setEditable(false);
	    txtPatientAddress.setColumns(10);
	    GridBagConstraints gbc_txtPatientAddress = new GridBagConstraints();
	    gbc_txtPatientAddress.gridheight = 2;
	    gbc_txtPatientAddress.insets = new Insets(0, 0, 5, 0);
	    gbc_txtPatientAddress.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtPatientAddress.gridx = 2;
	    gbc_txtPatientAddress.gridy = 3;
	    pnlPatientD.add(txtPatientAddress, gbc_txtPatientAddress);
	    
	    lblPatientDob.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblPatientDob = new GridBagConstraints();
	    gbc_lblPatientDob.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPatientDob.gridx = 0;
	    gbc_lblPatientDob.gridy = 5;
	    pnlPatientD.add(lblPatientDob, gbc_lblPatientDob);
	    
	    txtPatientDOB.setText("No Information Available");
	    txtPatientDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtPatientDOB.setEditable(false);
	    txtPatientDOB.setColumns(10);
	    GridBagConstraints gbc_txtPatientDOB = new GridBagConstraints();
	    gbc_txtPatientDOB.insets = new Insets(0, 0, 5, 0);
	    gbc_txtPatientDOB.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtPatientDOB.gridx = 2;
	    gbc_txtPatientDOB.gridy = 5;
	    pnlPatientD.add(txtPatientDOB, gbc_txtPatientDOB);
	    
	    lblPatientEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblPatientEmail = new GridBagConstraints();
	    gbc_lblPatientEmail.fill = GridBagConstraints.VERTICAL;
	    gbc_lblPatientEmail.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPatientEmail.gridx = 0;
	    gbc_lblPatientEmail.gridy = 6;
	    pnlPatientD.add(lblPatientEmail, gbc_lblPatientEmail);
	    
	    txtPatientEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtPatientEmail.setText("No Information Available");
	    txtPatientEmail.setEditable(false);
	    txtPatientEmail.setColumns(10);
	    GridBagConstraints gbc_txtPatientEmail = new GridBagConstraints();
	    gbc_txtPatientEmail.insets = new Insets(0, 0, 5, 0);
	    gbc_txtPatientEmail.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtPatientEmail.gridx = 2;
	    gbc_txtPatientEmail.gridy = 6;
	    pnlPatientD.add(txtPatientEmail, gbc_txtPatientEmail);
	    
	    lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblContactNo = new GridBagConstraints();
	    gbc_lblContactNo.fill = GridBagConstraints.VERTICAL;
	    gbc_lblContactNo.insets = new Insets(0, 0, 5, 5);
	    gbc_lblContactNo.gridx = 0;
	    gbc_lblContactNo.gridy = 7;
	    pnlPatientD.add(lblContactNo, gbc_lblContactNo);
	    
	    txtContactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtContactNo.setText("No Information Available");
	    txtContactNo.setEditable(false);
	    txtContactNo.setColumns(10);
	    GridBagConstraints gbc_txtContactNo = new GridBagConstraints();
	    gbc_txtContactNo.insets = new Insets(0, 0, 5, 0);
	    gbc_txtContactNo.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtContactNo.gridx = 2;
	    gbc_txtContactNo.gridy = 7;
	    pnlPatientD.add(txtContactNo, gbc_txtContactNo);
	    
	    GridBagConstraints gbc_lblPatientGender = new GridBagConstraints();
	    gbc_lblPatientGender.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPatientGender.gridx = 0;
	    gbc_lblPatientGender.gridy = 8;
	    lblPatientGender.setFont(new Font("Tahoma", Font.BOLD, 14));
	    pnlPatientD.add(lblPatientGender, gbc_lblPatientGender);
	    
	    GridBagConstraints gbc_txtPatientGender = new GridBagConstraints();
	    gbc_txtPatientGender.insets = new Insets(0, 0, 5, 0);
	    gbc_txtPatientGender.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtPatientGender.gridx = 2;
	    gbc_txtPatientGender.gridy = 8;
	    txtPatientGender.setText("No Information Available");
	    txtPatientGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtPatientGender.setEditable(false);
	    txtPatientGender.setColumns(10);
	    pnlPatientD.add(txtPatientGender, gbc_txtPatientGender);
	    
	    tabPnl.addTab("Medical History", null, scrlMedical, null);
	    
	    scrlMedical.setViewportView(pnlMedicalH);
	    GridBagLayout gbl_pnlMedicalH = new GridBagLayout();
	    gbl_pnlMedicalH.columnWidths = new int[]{0, 0, 45, 0, 0, 0};
	    gbl_pnlMedicalH.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	    gbl_pnlMedicalH.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
	    gbl_pnlMedicalH.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    pnlMedicalH.setLayout(gbl_pnlMedicalH);
	    
	    JLabel lblDateMedical1 = new JLabel("01/05/2014");
	    lblDateMedical1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblDateMedical1 = new GridBagConstraints();
	    gbc_lblDateMedical1.gridwidth = 5;
	    gbc_lblDateMedical1.insets = new Insets(0, 0, 5, 0);
	    gbc_lblDateMedical1.gridx = 0;
	    gbc_lblDateMedical1.gridy = 0;
	    pnlMedicalH.add(lblDateMedical1, gbc_lblDateMedical1);
	    
	    lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblDescription = new GridBagConstraints();
	    gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
	    gbc_lblDescription.gridx = 1;
	    gbc_lblDescription.gridy = 1;
	    pnlMedicalH.add(lblDescription, gbc_lblDescription);
	    
	    textField_2.setText("No Information Available");
	    textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_2.setEditable(false);
	    textField_2.setColumns(10);
	    GridBagConstraints gbc_textField_2 = new GridBagConstraints();
	    gbc_textField_2.gridwidth = 2;
	    gbc_textField_2.gridheight = 2;
	    gbc_textField_2.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_2.gridx = 3;
	    gbc_textField_2.gridy = 1;
	    pnlMedicalH.add(textField_2, gbc_textField_2);
	    
	    lblTreatment.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblTreatment = new GridBagConstraints();
	    gbc_lblTreatment.insets = new Insets(0, 0, 5, 5);
	    gbc_lblTreatment.gridx = 1;
	    gbc_lblTreatment.gridy = 3;
	    pnlMedicalH.add(lblTreatment, gbc_lblTreatment);
	    
	    textField_3.setText("No Information Available");
	    textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_3.setEditable(false);
	    textField_3.setColumns(10);
	    GridBagConstraints gbc_textField_3 = new GridBagConstraints();
	    gbc_textField_3.gridwidth = 2;
	    gbc_textField_3.gridheight = 2;
	    gbc_textField_3.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_3.gridx = 3;
	    gbc_textField_3.gridy = 3;
	    
	    chkPaidMedical1.setEnabled(false);
	    GridBagConstraints gbc_chkPaidMedical1 = new GridBagConstraints();
	    gbc_chkPaidMedical1.insets = new Insets(0, 0, 5, 0);
	    gbc_chkPaidMedical1.gridwidth = 5;
	    gbc_chkPaidMedical1.gridx = 0;
	    gbc_chkPaidMedical1.gridy = 5;
	    pnlMedicalH.add(chkPaidMedical1, gbc_chkPaidMedical1);
	    pnlMedicalH.add(textField_3, gbc_textField_3);
	    
	    GridBagConstraints gbc_label = new GridBagConstraints();
	    gbc_label.insets = new Insets(0, 0, 5, 0);
	    gbc_label.gridwidth = 5;
	    gbc_label.gridx = 0;
	    gbc_label.gridy = 7;
	    label.setFont(new Font("Tahoma", Font.BOLD, 14));
	    pnlMedicalH.add(label, gbc_label);
	    
	    GridBagConstraints gbc_label_1 = new GridBagConstraints();
	    gbc_label_1.insets = new Insets(0, 0, 5, 5);
	    gbc_label_1.gridx = 1;
	    gbc_label_1.gridy = 8;
	    label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    pnlMedicalH.add(label_1, gbc_label_1);
	    
	    GridBagConstraints gbc_textField = new GridBagConstraints();
	    gbc_textField.gridwidth = 2;
	    gbc_textField.gridheight = 2;
	    gbc_textField.insets = new Insets(0, 0, 5, 0);
	    gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField.gridx = 3;
	    gbc_textField.gridy = 8;
	    textField.setText("No Information Available");
	    textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField.setEditable(false);
	    textField.setColumns(10);
	    pnlMedicalH.add(textField, gbc_textField);
	    
	    GridBagConstraints gbc_label_2 = new GridBagConstraints();
	    gbc_label_2.insets = new Insets(0, 0, 5, 5);
	    gbc_label_2.gridx = 1;
	    gbc_label_2.gridy = 10;
	    label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	    pnlMedicalH.add(label_2, gbc_label_2);
	    
	    GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	    gbc_textField_1.gridheight = 2;
	    gbc_textField_1.gridwidth = 2;
	    gbc_textField_1.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_1.gridx = 3;
	    gbc_textField_1.gridy = 10;
	    textField_1.setText("No Information Available");
	    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_1.setEditable(false);
	    textField_1.setColumns(10);
	    pnlMedicalH.add(textField_1, gbc_textField_1);
	    
	    GridBagConstraints gbc_checkBox = new GridBagConstraints();
	    gbc_checkBox.gridwidth = 5;
	    gbc_checkBox.insets = new Insets(0, 0, 5, 0);
	    gbc_checkBox.gridx = 0;
	    gbc_checkBox.gridy = 12;
	    checkBox.setEnabled(false);
	    pnlMedicalH.add(checkBox, gbc_checkBox);
	    
	    GridBagConstraints gbc_label_3 = new GridBagConstraints();
	    gbc_label_3.gridwidth = 5;
	    gbc_label_3.insets = new Insets(0, 0, 5, 0);
	    gbc_label_3.gridx = 0;
	    gbc_label_3.gridy = 14;
	    label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	    pnlMedicalH.add(label_3, gbc_label_3);
	    
	    GridBagConstraints gbc_label_4 = new GridBagConstraints();
	    gbc_label_4.insets = new Insets(0, 0, 5, 5);
	    gbc_label_4.gridx = 1;
	    gbc_label_4.gridy = 15;
	    label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
	    pnlMedicalH.add(label_4, gbc_label_4);
	    
	    GridBagConstraints gbc_textField_8 = new GridBagConstraints();
	    gbc_textField_8.gridheight = 2;
	    gbc_textField_8.gridwidth = 2;
	    gbc_textField_8.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_8.gridx = 3;
	    gbc_textField_8.gridy = 15;
	    textField_8.setText("No Information Available");
	    textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_8.setEditable(false);
	    textField_8.setColumns(10);
	    pnlMedicalH.add(textField_8, gbc_textField_8);
	    
	    GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
	    gbc_checkBox_1.insets = new Insets(0, 0, 5, 0);
	    gbc_checkBox_1.gridwidth = 5;
	    gbc_checkBox_1.gridx = 0;
	    gbc_checkBox_1.gridy = 17;
	    checkBox_1.setEnabled(false);
	    pnlMedicalH.add(checkBox_1, gbc_checkBox_1);
	    
	    tabPnl.addTab("Appointments", null, pnlAppointments, null);
	    GridBagLayout gbl_pnlAppointments = new GridBagLayout();
	    gbl_pnlAppointments.columnWidths = new int[]{0, 0, 0, 0};
	    gbl_pnlAppointments.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
	    gbl_pnlAppointments.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
	    gbl_pnlAppointments.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
	    pnlAppointments.setLayout(gbl_pnlAppointments);
	    
	    lblDoctorAppointed.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblDoctorAppointed = new GridBagConstraints();
	    gbc_lblDoctorAppointed.fill = GridBagConstraints.VERTICAL;
	    gbc_lblDoctorAppointed.insets = new Insets(0, 0, 5, 5);
	    gbc_lblDoctorAppointed.gridx = 0;
	    gbc_lblDoctorAppointed.gridy = 1;
	    pnlAppointments.add(lblDoctorAppointed, gbc_lblDoctorAppointed);
	    
	    textField_4.setText("No Information Available");
	    textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_4.setEditable(false);
	    textField_4.setColumns(10);
	    GridBagConstraints gbc_textField_4 = new GridBagConstraints();
	    gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_4.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_4.gridx = 2;
	    gbc_textField_4.gridy = 1;
	    pnlAppointments.add(textField_4, gbc_textField_4);
	    
	    lblAppointmentTime.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblAppointmentTime = new GridBagConstraints();
	    gbc_lblAppointmentTime.fill = GridBagConstraints.VERTICAL;
	    gbc_lblAppointmentTime.insets = new Insets(0, 0, 5, 5);
	    gbc_lblAppointmentTime.gridx = 0;
	    gbc_lblAppointmentTime.gridy = 2;
	    pnlAppointments.add(lblAppointmentTime, gbc_lblAppointmentTime);
	    
	    textField_5.setText("No Information Available");
	    textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_5.setEditable(false);
	    textField_5.setColumns(10);
	    GridBagConstraints gbc_textField_5 = new GridBagConstraints();
	    gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_5.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_5.gridx = 2;
	    gbc_textField_5.gridy = 2;
	    pnlAppointments.add(textField_5, gbc_textField_5);
	    
	    lblAppointmentReason.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblAppointmentReason = new GridBagConstraints();
	    gbc_lblAppointmentReason.fill = GridBagConstraints.VERTICAL;
	    gbc_lblAppointmentReason.insets = new Insets(0, 0, 5, 5);
	    gbc_lblAppointmentReason.gridx = 0;
	    gbc_lblAppointmentReason.gridy = 3;
	    pnlAppointments.add(lblAppointmentReason, gbc_lblAppointmentReason);
	    
	    textField_6.setText("No Information Available");
	    textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_6.setEditable(false);
	    textField_6.setColumns(10);
	    GridBagConstraints gbc_textField_6 = new GridBagConstraints();
	    gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_6.gridheight = 2;
	    gbc_textField_6.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_6.gridx = 2;
	    gbc_textField_6.gridy = 3;
	    pnlAppointments.add(textField_6, gbc_textField_6);
	    
	    lblAppointmentDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
	    GridBagConstraints gbc_lblAppointmentDuration = new GridBagConstraints();
	    gbc_lblAppointmentDuration.fill = GridBagConstraints.VERTICAL;
	    gbc_lblAppointmentDuration.insets = new Insets(0, 0, 5, 5);
	    gbc_lblAppointmentDuration.gridx = 0;
	    gbc_lblAppointmentDuration.gridy = 5;
	    pnlAppointments.add(lblAppointmentDuration, gbc_lblAppointmentDuration);
	    
	    textField_7.setText("No Information Available");
	    textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textField_7.setEditable(false);
	    textField_7.setColumns(10);
	    GridBagConstraints gbc_textField_7 = new GridBagConstraints();
	    gbc_textField_7.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
	    gbc_textField_7.gridx = 2;
	    gbc_textField_7.gridy = 5;
	    pnlAppointments.add(textField_7, gbc_textField_7);
	    
	    lPnlMenu.setDoubleBuffered(true);
	    lPnlMenu.setBackground(new Color(0, 0, 0, 100));
	    GridBagConstraints gbc_lPnlMenu = new GridBagConstraints();
	    gbc_lPnlMenu.insets = new Insets(0, 0, 5, 5);
	    gbc_lPnlMenu.fill = GridBagConstraints.BOTH;
	    gbc_lPnlMenu.gridx = 1;
	    gbc_lPnlMenu.gridy = 3;
	    panel.add(lPnlMenu, gbc_lPnlMenu);
	    lPnlMenu.setLayout(new GridLayout(0, 3, 0, 0));
	    
	    btnDoctors.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(lPnlMain.isVisible() && lPnlDoctorMenu.isVisible())
	    		{
	    			lPnlMain.setVisible(false); 
	    			lPnlDoctorMenu.setVisible(false);
	    		}
	    		else if(lPnlMain.isVisible() && lPnlPatientMenu.isVisible())
	    		{  
	    			lPnlDoctorMenu.setVisible(true);
	    			lPnlPatientMenu.setVisible(false);
	    		}
	    		else
	    		{
	    			lPnlDoctorMenu.setVisible(true);
	    			lPnlMain.setVisible(true);  
	    		}
	    	} 
	    });
	    btnDoctors.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnDoctors.setBorder(null);
	    btnDoctors.setRolloverEnabled(false);
	    btnDoctors.setOpaque(false);   
	    btnDoctors.setContentAreaFilled(false);
	    btnDoctors.setBorderPainted(false);


	    btnDoctors.setIconTextGap(0);
	    btnDoctors.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\128x\\business_users.png"));
	    lPnlMenu.add(btnDoctors);
	    
	    btnPatients.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(lPnlMain.isVisible() && lPnlPatientMenu.isVisible())
	    		{
	    			lPnlMain.setVisible(false); 
	    			lPnlPatientMenu.setVisible(false);
	    		}
	    		else if(lPnlMain.isVisible() && lPnlDoctorMenu.isVisible())
	    		{  
	    			lPnlDoctorMenu.setVisible(false);
	    			lPnlPatientMenu.setVisible(true);
	    		}
	    		else
	    		{
	    			lPnlPatientMenu.setVisible(true);
	    			lPnlMain.setVisible(true); 
	    		}
	    	}
	    });
	    btnPatients.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnPatients.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\128x\\male_users.png"));
	    btnPatients.setRolloverEnabled(false);
	    btnPatients.setOpaque(false);
	    btnPatients.setIconTextGap(0);
	    btnPatients.setContentAreaFilled(false);
	    btnPatients.setBorderPainted(false);
	    btnPatients.setBorder(null);
	    lPnlMenu.add(btnPatients);
	    
	    btnApointments.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnApointments.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\128x\\telephone.png"));
	    btnApointments.setRolloverEnabled(false);
	    btnApointments.setOpaque(false);
	    btnApointments.setIconTextGap(0);
	    btnApointments.setContentAreaFilled(false);
	    btnApointments.setBorderPainted(false);
	    btnApointments.setBorder(null);
	    lPnlMenu.add(btnApointments);
	    frmVetmaster.pack();
	    frmVetmaster.setVisible(true);
  }

  public static void patientInfoVisible(boolean vis)
  {
	  tabPnl.setVisible(vis);
  }
  
  public static void showPatientWindow()
  {
	  tabPnl.setVisible(true);
  }
}

class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
  }
  
}

class JLayeredPane extends JPanel {

    /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 1;
    /** Color of shadow */
    protected Color shadowColor = Color.black;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(20, 20);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 5;
    /** The offset of shadow.  */
    protected int shadowOffset = 4;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 50;

    public JLayeredPane() {
        super();
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(), 
	shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;

        //Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Draws shadow borders if any.
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }

        //Draws the rounded opaque panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap, 
		height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap, 
		height - shadowGap, arcs.width, arcs.height);

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
} 

class JLayeredMenuPane extends JPanel {

    /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 1;
    /** Color of shadow */
    protected Color shadowColor = Color.black;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(0,0);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 5;
    /** The offset of shadow.  */
    protected int shadowOffset = 4;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 50;

    public JLayeredMenuPane() {
        super();
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(), 
	shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;

        //Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Draws shadow borders if any.
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }

        //Draws the rounded opaque panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap, 
		height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap, 
		height - shadowGap, arcs.width, arcs.height);

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
} 

class SharedListSelectionHandler implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) { 
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();

        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean isAdjusting = e.getValueIsAdjusting(); 
        /*output.append("Event for indexes "
                      + firstIndex + " - " + lastIndex
                      + "; isAdjusting is " + isAdjusting
                      + "; selected indexes:");
*/
        if (lsm.isSelectionEmpty()) {
        	DoctorMenu.patientInfoVisible(false);
        } else {
        	DoctorMenu.patientInfoVisible(true);
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i) && i != 0) {
                	DoctorMenu.txtPatientName.setText(PatientInfo.patientName[i]);
                	DoctorMenu.txtPatientNumber.setText(PatientInfo.patientID[i]);
                	DoctorMenu.txtPatientAddress.setText(PatientInfo.patientAddress[i]);
                	DoctorMenu.txtPatientDOB.setText(PatientInfo.patientDOB[i]);
                	DoctorMenu.txtPatientEmail.setText(PatientInfo.patientEmail[i]);
                	DoctorMenu.txtContactNo.setText(PatientInfo.patientContactNo[i]);
                	DoctorMenu.txtPatientGender.setText(PatientInfo.patientGender[i]); 
                }
            }
        }
        //output.append(newline);
        //output.setCaretPosition(output.getDocument().getLength());
    }
} 