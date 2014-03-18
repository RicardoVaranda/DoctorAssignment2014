package org.doctorsolutions.gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;	
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.doctorsolutions.Surgery;
import org.doctorsolutions.model.doctors.Doctor;
import org.doctorsolutions.model.patients.Patient;
import org.doctorsolutions.model.patients.PatientHistory;

import com.toedter.calendar.JDateChooser;

import javax.swing.JSplitPane;
public class MainGUI extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtSearchUser = new JTextField();
	public static JTextField txtPatientName = new JTextField();
	public static JTextField txtPatientNumber = new JTextField();
	public static JTextArea txtPatientAddress = new JTextArea();
	public static JTextField txtPatientContact = new JTextField();
	public static JTextArea textField_2 = new JTextArea();
	public static JTextField textField_3 = new JTextField();
	public static JTextField textField_4 = new JTextField();
	public static JTextField textField_5 = new JTextField();
	public static JTextField textField_6 = new JTextField();
	public static JTextField textField_7 = new JTextField();
	private static JTabbedPane tabPnl = new JTabbedPane(JTabbedPane.TOP);
	private static ImagePanel panel = new ImagePanel(new ImageIcon("E:/VetMaster2.0/data/DoctorBG.png").getImage());
	private static JFrame frmVetmaster = new JFrame();
	private static final JLayeredPane lPnlMain = new JLayeredPane();
	private static final JLayeredMenuPane lPnlDoctorMenu = new JLayeredMenuPane();
	private static final JLayeredMenuPane lPnlPatientMenu = new JLayeredMenuPane(); 
	private static JButton btnAddPatient = new JButton("");
	static JButton btnEditPatient = new JButton("");
	private static JButton btnAddDoctor = new JButton("");
	private static JButton btnEditDoctor = new JButton("");
	private static JScrollPane sclPat = new JScrollPane();
	static JList<?> lstNames = new JList<Object>();
	private static JList<String> lstPatientNames, lstDoctorNames;
	private static Vector<String> patNames, docNames; 
	private static SimpleDateFormat pre = new SimpleDateFormat ("yyyy-MM-dd");
	private static final JDateChooser dateChooser_1 = new JDateChooser();
	private static final JDateChooser datePatientDOB = new JDateChooser();
	private static final javax.swing.JLayeredPane layeredPane = new javax.swing.JLayeredPane();
	private static final JPanel pnlDoctors = new JPanel();
	private static final JLabel lblDoctorName = new JLabel("Doctor Name:");
	private static final JTextField txtDocName = new JTextField();
	private static final JLabel lblDoctorNumber = new JLabel("Doctor Number:");
	private static final JTextField txtDocNumber = new JTextField();
	private static final JLabel lblDoctorContact = new JLabel("Doctor Contact:");
	private static final JTextField txtDocContact = new JTextField();
	
	private static JPanel pnlPatientD = new JPanel();
	private static JLabel lblPatientName = new JLabel("Patient Name:"); 
	private static JLabel lblPatientNumber = new JLabel("Patient Number:");
	private static JLabel lblPatientAddress = new JLabel("Patient Address:");
	private static JLabel lblPatientDob = new JLabel("Patient DOB:");
	private static JLabel lblContactNo = new JLabel("Patient Contact:");
	private static JScrollPane scrlMedical = new JScrollPane();
	static JPanel pnlMedicalH = new JPanel();
	private static JLabel lblDescription = new JLabel("Description:");
	private static JLabel lblTreatment = new JLabel("Treatment:");
	private static JCheckBox chkPaidMedical1 = new JCheckBox("Paid");
	private static JPanel pnlAppointments = new JPanel(); 
	private static JLabel lblAppointmentReason = new JLabel("Appointment Reason:");
	private static JLabel lblAppointmentTime = new JLabel("Appointment Time:");
	private static JLabel lblAppointmentDuration = new JLabel("Appointment Duration:");
	private static JLayeredPane lPnlMenu = new JLayeredPane();
	private static JButton btnDoctors = new JButton("");
	private static JButton btnPatients = new JButton("");
	private static JButton btnReports = new JButton("");
	private static boolean canEdit = false;
	private static boolean isNew = false;
	public static int selectedIndex;
	
	static int numHist = 0; 
	static int newMedHist = 0; 
	
	static ArrayList<JDateChooser> lblMHDate = new ArrayList<JDateChooser>(); 
	static ArrayList<JLabel> lblMHDesc = new ArrayList<JLabel>();
	static ArrayList<JTextArea> txtMHDesc = new ArrayList<JTextArea>();
	static ArrayList<JLabel> lblMHTreat = new ArrayList<JLabel>();
	static ArrayList<JTextArea> txtMHTreat = new ArrayList<JTextArea>();
	static ArrayList<JLabel> lblMHProc = new ArrayList<JLabel>();
	static ArrayList<JTextArea> txtMHProc = new ArrayList<JTextArea>();
	private static final JButton btnAddMedicalHistory = new JButton("ADD MEDICAL HISTORY"); 
	private static final JSplitPane pnlInfoEdit = new JSplitPane();
	private static final JButton btnSavePatient = new JButton("SAVE PATIENT"); 
	private static final JButton btnSaveDoctor = new JButton("Save Doctor"); 
	
	public MainGUI(){ 
		drawGUI(); 
	}
	
	// DRAWS THE GUI COMPONENTS
 
	public static void drawGUI()
	{

		frmVetmaster.setTitle("VetMaster");
		frmVetmaster.setExtendedState(Frame.MAXIMIZED_BOTH);  
		frmVetmaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setMinimumSize(new Dimension(0, 0));
		frmVetmaster.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		Rectangle r = frmVetmaster.getBounds();
		gbl_panel.columnWidths = new int[]{ (r.width/2) - 365, 731, (r.width/2) - 365};
		gbl_panel.rowHeights = new int[]{266, 432, 137, 140, 105};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0};
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
		gbl_lPnlMain.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_lPnlMain.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		gbl_lPnlPatientMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_lPnlPatientMenu.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_lPnlPatientMenu.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		lPnlPatientMenu.setLayout(gbl_lPnlPatientMenu);
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(canEdit){
					canEdit = false;  
				}
				else
				{
					patientInfoVisible(true);
					clearInfo();
					isNew = true;
					int nextPatientID = patNames.size() + 1;
					txtPatientNumber.setText("" + nextPatientID);
					canEdit = true;  
				}
				canEditData(canEdit);
			}
		}); 
		
		
		patNames = new Vector<String>();
		
		for(int i = 0; i<Surgery.doctorList.get(Surgery.docID).getNumPatients(); i++)
			patNames.addElement(Surgery.doctorList.get(Surgery.docID).patientList.get(i).getpName()); 
		
		docNames = new Vector<String>();
		
		for(int i = 0; i<Surgery.doctorList.size(); i++)
			docNames.addElement(Surgery.doctorList.get(i).getDocName()); 

		btnAddPatient.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\add_male_user.png"));
		btnAddPatient.setBackground(new Color(0, 0, 0, 0));
		btnAddPatient.setBorder(null);
		btnAddPatient.setRolloverEnabled(false);
		btnAddPatient.setOpaque(false);
		GridBagConstraints gbc_btnAddPatient = new GridBagConstraints();
		gbc_btnAddPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddPatient.gridx = 1;
		gbc_btnAddPatient.gridy = 1;
		lPnlPatientMenu.add(btnAddPatient, gbc_btnAddPatient);
		btnEditPatient.setEnabled(false);
		btnEditPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(canEdit){
					canEdit = false;  
				}
				else
				{
					canEdit = true;  
				}

				canEditData(canEdit);
			}
		});

		btnEditPatient.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\edit_male_user.png"));
		btnEditPatient.setRolloverEnabled(false);
		btnEditPatient.setOpaque(false);
		btnEditPatient.setBorder(null);
		btnEditPatient.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_btnEditPatient = new GridBagConstraints();
		gbc_btnEditPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditPatient.gridx = 1;
		gbc_btnEditPatient.gridy = 3;
		lPnlPatientMenu.add(btnEditPatient, gbc_btnEditPatient);
		GridBagConstraints gbc_lPnlDoctorMenu = new GridBagConstraints();
		gbc_lPnlDoctorMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_lPnlDoctorMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lPnlDoctorMenu.gridx = 0;
		gbc_lPnlDoctorMenu.gridy = 2;
		lPnlMain.add(lPnlDoctorMenu, gbc_lPnlDoctorMenu);
		GridBagLayout gbl_lPnlDoctorMenu = new GridBagLayout();
		gbl_lPnlDoctorMenu.columnWidths = new int[]{0, 0, 0, 0};
		gbl_lPnlDoctorMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_lPnlDoctorMenu.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_lPnlDoctorMenu.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		lPnlDoctorMenu.setLayout(gbl_lPnlDoctorMenu);
		btnAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(canEdit){
					canEdit = false;  
				}
				else
				{
					patientInfoVisible(true);
					clearInfo();
					isNew = true;
					int num = Surgery.doctorList.size() + 1;
					txtDocNumber.setText("" + num); 
					canEdit = true;  
				}
				canEditData(canEdit);
				pnlInfoEdit.setVisible(!canEdit);
			}
		});

		btnAddDoctor.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\add_business_user.png"));
		btnAddDoctor.setRolloverEnabled(false);
		btnAddDoctor.setOpaque(false);
		btnAddDoctor.setBorder(null);
		btnAddDoctor.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_btnAddDoctor = new GridBagConstraints();
		gbc_btnAddDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddDoctor.gridx = 1;
		gbc_btnAddDoctor.gridy = 1;
		lPnlDoctorMenu.add(btnAddDoctor, gbc_btnAddDoctor);
		btnEditDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(canEdit){
					canEdit = false;  
				}
				else
				{
					canEdit = true; 
				}
				canEditData(canEdit);

				pnlInfoEdit.setVisible(!canEdit);
			}
		});
		btnEditDoctor.setEnabled(false);

		btnEditDoctor.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\64x\\edit_business_user.png"));
		btnEditDoctor.setRolloverEnabled(false);
		btnEditDoctor.setOpaque(false);
		btnEditDoctor.setBorder(null);
		btnEditDoctor.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_btnEditDoctor = new GridBagConstraints();
		gbc_btnEditDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditDoctor.gridx = 1;
		gbc_btnEditDoctor.gridy = 3;
		lPnlDoctorMenu.add(btnEditDoctor, gbc_btnEditDoctor);
		GridBagConstraints gbc_tabPnl = new GridBagConstraints();
		gbc_tabPnl.insets = new Insets(0, 0, 5, 0);
		gbc_tabPnl.fill = GridBagConstraints.BOTH;
		gbc_tabPnl.gridx = 2;
		gbc_tabPnl.gridy = 2;
		tabPnl.setVisible(false);
		
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.insets = new Insets(0, 0, 5, 5);
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 1;
		gbc_layeredPane.gridy = 2;
		lPnlMain.add(layeredPane, gbc_layeredPane);
		
				lstPatientNames = new JList<String>(patNames);
				lstPatientNames.addListSelectionListener(new ListSelectionListener() { 
                public void valueChanged(ListSelectionEvent e)  
                {   
                	btnEditPatient.setEnabled(true);
        			patientInfoVisible(true); 
        			numHist = 0; 
        			clearInfo();
                        if (e.getValueIsAdjusting()) return;  
                        JList<?> theList = (JList<?>)e.getSource();  
                        if (! theList.isSelectionEmpty())          
                        {                    
                        		newMedHist = 0;
                                selectedIndex = theList.getSelectedIndex();
                                System.out.println("Selected Index Changed to: " + selectedIndex);
                                System.out.println("Medical hist num " + newMedHist);
            					txtPatientName.setText(Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpName());
            					txtPatientNumber.setText(Integer.toString(Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpId()));
            					txtPatientAddress.setText(Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpAddress());
            					datePatientDOB.setDate(Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpDOB()); 
            					txtPatientContact.setText(Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpPhone()); 
            					for(int i = 0; i < Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).myHistory.size(); i++)
            					{
            							addMedicalHistory(Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).myHistory.get(i));
            							numHist++;
            							pnlMedicalH.repaint();
            					}
                        }  
                }  
				});
				
				final JScrollPane sclDoc = new JScrollPane();
				sclDoc.setVisible(false);
				sclDoc.setBounds(0, 0, 198, 342);
				layeredPane.add(sclDoc);
				
				lstDoctorNames = new JList<String>(docNames);
				lstDoctorNames.addListSelectionListener(new ListSelectionListener() { 
	                public void valueChanged(ListSelectionEvent e)  
	                {   
	        			btnEditDoctor.setEnabled(true); 
	        			sclDoc.setVisible(true);
						tabPnl.setVisible(true); 
						tabPnl.remove(pnlPatientD);
						tabPnl.remove(scrlMedical);
	        			clearInfo();
	                        if (e.getValueIsAdjusting()) return;  
	                        JList<?> theList = (JList<?>)e.getSource();  
	                        if (! theList.isSelectionEmpty())          
	                        {                                   
	                              System.out.println("");  Surgery.docID = theList.getSelectedIndex();
	                                System.out.println("Selected Index Changed to: " + selectedIndex);
	            					txtDocName.setText(Surgery.doctorList.get(Surgery.docID).getDocName());
	            					txtDocNumber.setText(Integer.toString(Surgery.doctorList.get(Surgery.docID).getDocID()));
	            					txtDocContact.setText(Surgery.doctorList.get(Surgery.docID).getDocPhone());
	            					patNames = new Vector<String>(); 
	            					for(int i = 0; i<Surgery.doctorList.get(Surgery.docID).getNumPatients(); i++)
	            						patNames.addElement(Surgery.doctorList.get(Surgery.docID).patientList.get(i).getpName());
	            					
	                        }  
	                }  
				});
				
				sclDoc.setViewportView(lstDoctorNames);
				lstPatientNames.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
				sclPat.setVisible(false);
				sclPat.setBounds(0, 0, 198, 342);
				layeredPane.add(sclPat);
				
				sclPat.setViewportView(lstPatientNames);
		lPnlMain.add(tabPnl, gbc_tabPnl);
		pnlDoctors.setVisible(false);
		
		tabPnl.addTab("Doctor Details", null, pnlDoctors, null);
		GridBagLayout gbl_pnlDoctors = new GridBagLayout();
		gbl_pnlDoctors.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlDoctors.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlDoctors.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlDoctors.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlDoctors.setLayout(gbl_pnlDoctors);
		
		GridBagConstraints gbc_lblDoctorName = new GridBagConstraints();
		gbc_lblDoctorName.fill = GridBagConstraints.VERTICAL;
		gbc_lblDoctorName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoctorName.gridx = 0;
		gbc_lblDoctorName.gridy = 1;
		lblDoctorName.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlDoctors.add(lblDoctorName, gbc_lblDoctorName);
		
		GridBagConstraints gbc_txtDocName = new GridBagConstraints();
		gbc_txtDocName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDocName.insets = new Insets(0, 0, 5, 0);
		gbc_txtDocName.gridx = 2;
		gbc_txtDocName.gridy = 1;
		txtDocName.setText("No Information Available");
		txtDocName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocName.setEditable(false);
		txtDocName.setColumns(10);
		pnlDoctors.add(txtDocName, gbc_txtDocName);
		
		GridBagConstraints gbc_lblDoctorNumber = new GridBagConstraints();
		gbc_lblDoctorNumber.fill = GridBagConstraints.VERTICAL;
		gbc_lblDoctorNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoctorNumber.gridx = 0;
		gbc_lblDoctorNumber.gridy = 2;
		lblDoctorNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlDoctors.add(lblDoctorNumber, gbc_lblDoctorNumber);
		
		GridBagConstraints gbc_txtDocNumber = new GridBagConstraints();
		gbc_txtDocNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDocNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtDocNumber.gridx = 2;
		gbc_txtDocNumber.gridy = 2;
		txtDocNumber.setText("No Information Available");
		txtDocNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocNumber.setEditable(false);
		txtDocNumber.setColumns(10);
		pnlDoctors.add(txtDocNumber, gbc_txtDocNumber);
		
		GridBagConstraints gbc_lblDoctorContact = new GridBagConstraints();
		gbc_lblDoctorContact.fill = GridBagConstraints.VERTICAL;
		gbc_lblDoctorContact.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoctorContact.gridx = 0;
		gbc_lblDoctorContact.gridy = 3;
		lblDoctorContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlDoctors.add(lblDoctorContact, gbc_lblDoctorContact);
		
		GridBagConstraints gbc_txtDocContact = new GridBagConstraints();
		gbc_txtDocContact.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDocContact.insets = new Insets(0, 0, 5, 0);
		gbc_txtDocContact.gridx = 2;
		gbc_txtDocContact.gridy = 3;
		txtDocContact.setText("No Information Available");
		txtDocContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocContact.setEditable(false);
		txtDocContact.setColumns(10);
		pnlDoctors.add(txtDocContact, gbc_txtDocContact);
		
		GridBagConstraints gbc_btnSaveDoctor = new GridBagConstraints();
		gbc_btnSaveDoctor.gridx = 2;
		gbc_btnSaveDoctor.gridy = 4;
		btnSaveDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				if(canEdit && isNew){
					//TODO VALIDATE DATA
					canEdit = false;  
					Doctor newDoctor = new Doctor(txtDocName.getText(), txtDocContact.getText());
					newDoctor.setDocID(Integer.parseInt(txtDocNumber.getText()));
					Surgery.addDoctor(newDoctor);
					docNames.addElement(txtDocName.getText()); 
					try {
						Surgery.saveToDB("INSERT INTO Staff " + 
						" VALUES (" + newDoctor.getDocID() + ", '" + txtDocName.getText().toString() + "', '" + txtDocContact.getText().toString() + "', 'Doctor')");
						selectedIndex = Integer.parseInt(txtDocNumber.getText());
					} catch (ClassNotFoundException | SQLException
							| ParseException e1) { 
						e1.printStackTrace();
					}
					
					isNew = false;
				}
				else if(canEdit && !isNew)
				{
					Doctor newDoctor = new Doctor(txtDocName.getText(), txtDocContact.getText());
					newDoctor.setDocID(Integer.parseInt(txtDocNumber.getText())); 
					Surgery.updateDoctor(newDoctor);
					
					try {
						Surgery.saveToDB("UPDATE Staff SET StaffNo =" + newDoctor.getDocID() + ", StaffName = '" + newDoctor.getDocName() + "', StaffContactNum ='" + newDoctor.getDocPhone() + "' WHERE StaffNo =" + newDoctor.getDocID() +";");
						} catch (ClassNotFoundException | SQLException
							| ParseException e1) { 
						e1.printStackTrace();
					}

					canEdit = false;  
				}
				else
				{
					canEdit = true; 
				} 
				canEditData(canEdit);
				}
		});
		pnlDoctors.add(btnSaveDoctor, gbc_btnSaveDoctor);
		pnlPatientD.setVisible(false);

		tabPnl.addTab("Patient Details", (Icon) null, pnlPatientD, null);
		GridBagLayout gbl_pnlPatientD = new GridBagLayout();
		gbl_pnlPatientD.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlPatientD.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlPatientD.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlPatientD.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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
		txtPatientAddress.setEditable(false); 
		txtPatientAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPatientAddress.setText("No Information Available");
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
						
		GridBagConstraints gbc_datePatientDOB = new GridBagConstraints();
		gbc_datePatientDOB.insets = new Insets(0, 0, 5, 0);
		gbc_datePatientDOB.fill = GridBagConstraints.BOTH;
		gbc_datePatientDOB.gridx = 2;
		gbc_datePatientDOB.gridy = 5;
		datePatientDOB.setEnabled(false);
		pnlPatientD.add(datePatientDOB, gbc_datePatientDOB);
				
						
						
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblContactNo = new GridBagConstraints();
						gbc_lblContactNo.fill = GridBagConstraints.VERTICAL;
						gbc_lblContactNo.insets = new Insets(0, 0, 5, 5);
						gbc_lblContactNo.gridx = 0;
						gbc_lblContactNo.gridy = 6;
						pnlPatientD.add(lblContactNo, gbc_lblContactNo);
		
				txtPatientContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtPatientContact.setText("No Information Available");
				txtPatientContact.setEditable(false);
				txtPatientContact.setColumns(10);
				GridBagConstraints gbc_txtPatientContact = new GridBagConstraints();
				gbc_txtPatientContact.insets = new Insets(0, 0, 5, 0);
				gbc_txtPatientContact.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPatientContact.gridx = 2;
				gbc_txtPatientContact.gridy = 6;
				pnlPatientD.add(txtPatientContact, gbc_txtPatientContact);
		scrlMedical.setVisible(false);

		tabPnl.addTab("Medical History", null, scrlMedical, null);

		scrlMedical.setViewportView(pnlMedicalH);
		GridBagLayout gbl_pnlMedicalH = new GridBagLayout();
		gbl_pnlMedicalH.columnWidths = new int[]{0, 0, 45, 0, 0, 0};
		gbl_pnlMedicalH.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlMedicalH.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlMedicalH.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlMedicalH.setLayout(gbl_pnlMedicalH);
		lblDescription.setVisible(false);
		
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 0;
		
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.gridwidth = 2;
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 0;
		dateChooser_1.setVisible(false);
		pnlMedicalH.add(dateChooser_1, gbc_dateChooser_1);
		 

		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 1;
		pnlMedicalH.add(lblDescription, gbc_lblDescription);
		textField_2.setVisible(false);
		textField_2.setOpaque(false);

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
		lblTreatment.setVisible(false);

		lblTreatment.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTreatment = new GridBagConstraints();
		gbc_lblTreatment.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreatment.gridx = 1;
		gbc_lblTreatment.gridy = 3;
		pnlMedicalH.add(lblTreatment, gbc_lblTreatment);
		textField_3.setVisible(false);

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
		pnlMedicalH.add(textField_3, gbc_textField_3);
		chkPaidMedical1.setVisible(false);

		chkPaidMedical1.setEnabled(false);
		GridBagConstraints gbc_chkPaidMedical1 = new GridBagConstraints();
		gbc_chkPaidMedical1.insets = new Insets(0, 0, 5, 0);
		gbc_chkPaidMedical1.gridwidth = 5;
		gbc_chkPaidMedical1.gridx = 0;
		gbc_chkPaidMedical1.gridy = 5;
		pnlMedicalH.add(chkPaidMedical1, gbc_chkPaidMedical1);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
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
		
		GridBagConstraints gbc_pnlInfoEdit = new GridBagConstraints();
		gbc_pnlInfoEdit.fill = GridBagConstraints.BOTH;
		gbc_pnlInfoEdit.gridx = 2;
		gbc_pnlInfoEdit.gridy = 3;
		pnlInfoEdit.setEnabled(false);
		pnlInfoEdit.setVisible(false);
		pnlInfoEdit.setDividerSize(3);
		lPnlMain.add(pnlInfoEdit, gbc_pnlInfoEdit);
		pnlInfoEdit.setRightComponent(btnAddMedicalHistory);
		btnSavePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(canEdit && isNew && checkPatientData()){
					canEdit = false;   
					Patient newPatient = new Patient(txtPatientName.getText(), txtPatientAddress.getText(), txtPatientContact.getText(), datePatientDOB.getDate());
					Surgery.doctorList.get(Surgery.docID).addPatient(newPatient);
					patNames.addElement(txtPatientName.getText()); 
					try {
						Surgery.saveToDB("INSERT INTO Patients " + 
						" VALUES (" + Surgery.nextPatID + ", '" + txtPatientName.getText().toString() + "', '" + txtPatientAddress.getText().toString() + "', '" + txtPatientContact.getText().toString() + "', '" + pre.format(datePatientDOB.getDate()) + "', " + Surgery.docID + ")");
						selectedIndex = Surgery.nextPatID;
						Surgery.nextPatID ++;
					} catch (ClassNotFoundException | SQLException
							| ParseException e1) { 
						e1.printStackTrace();
					}
					
					
					if(newMedHist !=0)
						try {
							saveMedHist();
						} catch (NumberFormatException | ParseException | ClassNotFoundException | SQLException e1) { 
							e1.printStackTrace();
						} 
					newMedHist = 0;
					isNew = false;
				}
				else if(canEdit && !isNew && checkPatientData())
				{
					Patient newPatient = new Patient(txtPatientName.getText(), txtPatientAddress.getText(), txtPatientContact.getText(), datePatientDOB.getDate());
					Surgery.doctorList.get(Surgery.docID).updatePatient(newPatient);
					
					try {
						Surgery.saveToDB("UPDATE Patients SET PatientID =" + Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpId() + ", PatientName = '" + txtPatientName.getText().toString() + "', PatientAddress ='" + txtPatientAddress.getText().toString() + "', PatientContactNo ='" + txtPatientContact.getText().toString() + "', PatientDOB ='" + pre.format(datePatientDOB.getDate()) + "', DoctorID =" + Surgery.docID + " WHERE PatientID =" + Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpId() +";");
						} catch (ClassNotFoundException | SQLException
							| ParseException e1) { 
						e1.printStackTrace();
					}

					if(newMedHist !=0)
						try {
							saveMedHist();
							Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpName();
						} catch (NumberFormatException | ParseException | ClassNotFoundException | SQLException e1) { 
							e1.printStackTrace();
						} 
					newMedHist = 0;
					canEdit = false;  
				}
				else
				{
					canEdit = true; 
				} 
				canEditData(canEdit);
				}
		});
		
		pnlInfoEdit.setLeftComponent(btnSavePatient);
		pnlInfoEdit.setDividerLocation(210);
		btnAddMedicalHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new SimpleDateFormat ("yyyy-mm-dd");  
				 Date d = new Date();
				  
					PatientHistory newHist = null;
					try {
						newHist = new PatientHistory(d, "", "", "");
					} catch (ParseException e1) { 
						e1.printStackTrace();
					}
					addMedicalHistory(newHist);
					numHist++; 
				System.out.println("RANNNN");
				btnAddMedicalHistory.setEnabled(false); 
			}
		});

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
					((JList<String>) lstDoctorNames).clearSelection();
					lPnlMain.setVisible(false); 
					lPnlDoctorMenu.setVisible(false);
					tabPnl.setVisible(false);
					tabPnl.remove(pnlDoctors);
					sclDoc.setVisible(false); 
				}
				else if(lPnlMain.isVisible() && lPnlPatientMenu.isVisible())
				{  
					((JList<String>) lstPatientNames).clearSelection();
					tabPnl.setVisible(false);
					lPnlDoctorMenu.setVisible(true);
					lPnlPatientMenu.setVisible(false);
					sclDoc.setVisible(true);
					tabPnl.add("Doctor Details", pnlDoctors);
					tabPnl.remove(pnlPatientD);
					tabPnl.remove(scrlMedical);
				}
				else
				{
					lPnlDoctorMenu.setVisible(true);
					lPnlMain.setVisible(true);  
					tabPnl.add("Doctor Details", pnlDoctors);
					sclDoc.setVisible(true); 
					tabPnl.remove(pnlPatientD);
					tabPnl.remove (scrlMedical); 
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
					((JList<String>) lstPatientNames).clearSelection();
					lPnlMain.setVisible(false); 
					lPnlPatientMenu.setVisible(false);  
					tabPnl.remove(pnlPatientD);
					tabPnl.remove(scrlMedical);
					sclPat.setVisible(false); 
					tabPnl.setVisible(false); 
				}
				else if(lPnlMain.isVisible() && lPnlDoctorMenu.isVisible())
				{  
					((JList<String>) lstDoctorNames).clearSelection();
					lPnlDoctorMenu.setVisible(false);
					lPnlPatientMenu.setVisible(true); 
					tabPnl.setVisible(false);
					sclDoc.setVisible(false);
					sclPat.setVisible(true);
					tabPnl.add("Patient Details", pnlPatientD);
					tabPnl.add("Medical History", scrlMedical);
					tabPnl.remove(pnlDoctors); 
				}
				else
				{
					lPnlPatientMenu.setVisible(true);
					lPnlMain.setVisible(true); 
					sclPat.setVisible(true); 
					tabPnl.remove(pnlDoctors); 
					tabPnl.add("Patient Details", pnlPatientD);
					tabPnl.add("Medical History", scrlMedical); 
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
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
			}
		});

		btnReports.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReports.setIcon(new ImageIcon("E:\\VetMaster2.0\\data\\icons\\128x\\telephone.png"));
		btnReports.setRolloverEnabled(false);
		btnReports.setOpaque(false);
		btnReports.setIconTextGap(0);
		btnReports.setContentAreaFilled(false);
		btnReports.setBorderPainted(false);
		btnReports.setBorder(null);
		lPnlMenu.add(btnReports);
		frmVetmaster.pack();
		frmVetmaster.setVisible(true);
	}

	// CHECKER WHICH ENABLES AND DISABLES EDITING OF INFORMATION
	
	public static void canEditData(boolean edit)
	{
		txtPatientName.setEditable(edit);  
		txtPatientAddress.setEditable(edit);
		datePatientDOB.setEnabled(edit); 
		txtPatientContact.setEditable(edit); 
		btnAddMedicalHistory.setEnabled(edit); 
		btnSaveDoctor.setEnabled(edit); 
		txtDocName.setEditable(edit); 
		txtDocNumber.setEditable(edit); 
		txtDocContact.setEditable(edit); 
		
		btnDoctors.setEnabled(!edit);
		btnPatients.setEnabled(!edit);
		btnReports.setEnabled(!edit);
		
		btnAddDoctor.setEnabled(!edit); 
		btnEditDoctor.setEnabled(!edit); 
		btnAddPatient.setEnabled(!edit); 
		btnEditPatient.setEnabled(!edit);
		
		lstPatientNames.setEnabled(!edit);
		pnlInfoEdit.setVisible(edit);
		
		for(int i = 0; (lblMHDate.size() != 0) && i < lblMHDate.size(); i++)
		{
			lblMHDate.get(i).setEnabled(edit);
			txtMHDesc.get(i).setEditable(edit);
			txtMHProc.get(i).setEnabled(edit); 
		}
		
	}
	
	// CLEARS ALL THE INFORMATION IN THE INFORMATION PANEL
	 
	public static void clearInfo(){
		txtPatientName.setText("");
		txtPatientNumber.setText("");
		txtPatientAddress.setText("");
		datePatientDOB.setDate(null);
		txtPatientContact.setText(""); 
		txtDocName.setText(""); 
		txtDocNumber.setText(""); 
		txtDocContact.setText(""); 
		
		while(lblMHDate.size() != 0)
		{
			
			pnlMedicalH.remove(lblMHDate.get(0));
			pnlMedicalH.remove(lblMHDesc.get(0));
			pnlMedicalH.remove(lblMHTreat.get(0)); 
			pnlMedicalH.remove(lblMHProc.get(0));
			pnlMedicalH.remove(txtMHDesc.get(0));
			pnlMedicalH.remove(txtMHTreat.get(0));
			pnlMedicalH.remove(txtMHProc.get(0));
			
			lblMHDate.remove(0);
			lblMHDesc.remove(0);
			txtMHDesc.remove(0);
			lblMHTreat.remove(0);
			txtMHTreat.remove(0);
			lblMHProc.remove(0);
			txtMHProc.remove(0);
		}
		pnlMedicalH.repaint();
		numHist = 0;
	}
	
	// ADDS A MEDICAL HISTORY BY DYNAMICALLY CREATING COMPONENTS AND DYNAMICALLING SETTING THEIR POSITION IN THE GRIDBAG

	public static void addMedicalHistory(PatientHistory pHistory)
	{  
		newMedHist++;
		JDateChooser lblDate = new JDateChooser(pHistory.getVisitDate());
		JLabel lblMHDescription = new JLabel("Description:");
		JTextArea txtDescription = new JTextArea(pHistory.getDescription());
		JLabel lblTreatment = new JLabel("Treatment:");
		JTextArea txtTreatment = new JTextArea(pHistory.getMedicine());
		JLabel lblProcedure = new JLabel("Procedure:");
		JTextArea txtProcedure = new JTextArea(pHistory.getProcedure());
		
		lblMHDate.add(lblDate);
		lblMHDesc.add(lblMHDescription);
		txtMHDesc.add(txtDescription);
		lblMHTreat.add(lblTreatment);
		txtMHTreat.add(txtTreatment);
		lblMHProc.add(lblProcedure);
		txtMHProc.add(txtProcedure);

		lblMHDate.get(numHist).setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMHDesc.get(numHist).setFont(new Font("Tahoma", Font.BOLD, 14)); 
		lblMHTreat.get(numHist).setFont(new Font("Tahoma", Font.BOLD, 14)); 
		lblMHProc.get(numHist).setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMHDesc.get(numHist).setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMHTreat.get(numHist).setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMHProc.get(numHist).setFont(new Font("Tahoma", Font.PLAIN, 14));
		 
		lblMHDate.get(numHist).setDateFormatString("yyyy-MM-dd");

		GridBagConstraints constrains = new GridBagConstraints();
		GridBagConstraints constrainBig = new GridBagConstraints();
		
		lblMHDate.get(numHist).setEnabled(canEdit);

		txtMHDesc.get(numHist).setEditable(canEdit);
		txtMHDesc.get(numHist).setColumns(10); 
		
		txtMHProc.get(numHist).setEnabled(canEdit);
		txtMHProc.get(numHist).setColumns(10);
		
		txtMHTreat.get(numHist).setEditable(canEdit);
		txtMHTreat.get(numHist).setColumns(10); 


		constrains.fill = GridBagConstraints.BOTH;
		constrains.gridwidth = 2;
		constrains.insets = new Insets(0, 0, 5, 5);
		constrains.gridx = 2;
		constrains.gridy = numHist * 7;
		pnlMedicalH.add(lblMHDate.get(numHist), constrains);	
 
		constrains.fill = GridBagConstraints.NONE; 

		constrains.gridwidth = 1;
		constrains.insets = new Insets(0, 0, 5, 5);
		constrains.gridx = 1;
		constrains.gridy = (numHist * 7) + 1;
		pnlMedicalH.add(lblMHDesc.get(numHist), constrains);
		
		constrains.insets = new Insets(0, 0, 5, 5);
		constrains.gridx = 1;
		constrains.gridy = (numHist * 7) + 3;
		pnlMedicalH.add(lblMHTreat.get(numHist), constrains);
		
		constrains.insets = new Insets(0, 0, 5, 5);
		constrains.gridx = 1;
		constrains.gridy = (numHist * 7) + 5;
		pnlMedicalH.add(lblMHProc.get(numHist), constrains);

		constrainBig.gridwidth = 2;
		constrainBig.gridheight = 2;
		constrainBig.insets = new Insets(0, 0, 5, 0);
		constrainBig.fill = GridBagConstraints.HORIZONTAL;
		
		constrainBig.gridx = 3;
		constrainBig.gridy = (numHist * 7) + 1;
		pnlMedicalH.add(txtMHDesc.get(numHist), constrainBig);
		

		constrainBig.gridx = 3;
		constrainBig.gridy = (numHist * 7) + 3; 
		pnlMedicalH.add(txtMHTreat.get(numHist), constrainBig);
		
		constrainBig.gridx = 3;
		constrainBig.gridy = (numHist * 7) + 5; 
		pnlMedicalH.add(txtMHProc.get(numHist), constrainBig);
		
		constrainBig.gridheight = 1;
		
		pnlMedicalH.revalidate();
 
	}  
	
	// SAVES THE NEW MEDICAL HISTORY TO THE DATABASE
	
	private static void saveMedHist() throws NumberFormatException, ParseException, ClassNotFoundException, SQLException
	{ 
		Date date = lblMHDate.get(numHist-1).getDate(); 
		PatientHistory pHistory = new PatientHistory(date, txtMHDesc.get(numHist-1).getText(), txtMHTreat.get(numHist-1).getText(), txtMHProc.get(numHist-1).getText());
		pHistory.setHistoryID(Surgery.nextMedID); 
		Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).doctorsVisit(pHistory); 
		Surgery.saveToDB("INSERT INTO MedicalHistory " + 
	           "VALUES (" + Surgery.nextMedID + ", '" + pre.format(date) + "', '" + txtMHDesc.get(numHist-1).getText().toString() + "', '" + txtMHTreat.get(numHist-1).getText().toString() + "', '" + txtMHProc.get(numHist-1).getText().toString() + "', " + Surgery.doctorList.get(Surgery.docID).patientList.get(selectedIndex).getpId() +")");
		Surgery.nextMedID ++;
	}
	
	// CHECKS IF THE PATIENT DATA IS CORRECT BEFORE SUBMITTING IT
	
	private static boolean checkPatientData(){
		
		//TODO FINISH DATA CHECK HERE. 
		  
		if(txtPatientName.getText().equals("") || txtPatientNumber.getText().equals("") || txtPatientAddress.getText().equals("") || datePatientDOB.getDate().equals("") || txtPatientContact.getText().equals("")){
			JOptionPane.showMessageDialog(null,
				    "Please fill in all of the required fields.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		  
		if(!txtPatientName.getText().contains(" "))
			return false;
		
		return true; 
	}
	
	// CHECKER WHICH SETS THE INFOMATION PANEL VISIBLE

	public static void patientInfoVisible(boolean vis)
	{
		tabPnl.setVisible(vis);
	}

	public static void showPatientWindow()
	{
		tabPnl.setVisible(true);
	}
}

// END OF CLASS

/*
 * 
 * ADITIONAL CLASSES FOR THE GUI
 * 
 */

// SETTING THE BACKGROUND IMAGE TO THE PANEL

class ImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

// FANCY DESIGN FOR THE PANEL

class JLayeredPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
 
		if (highQuality) {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
 
		if (shady) {
			graphics.setColor(shadowColorA);
			graphics.fillRoundRect(
					shadowOffset, 
					shadowOffset, 
					width - strokeSize - shadowOffset,  
					height - strokeSize - shadowOffset,  
					arcs.width, arcs.height); 
		} else {
			shadowGap = 1;
		}
 
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width - shadowGap, 
				height - shadowGap, arcs.width, arcs.height);
		graphics.setColor(getForeground());
		graphics.setStroke(new BasicStroke(strokeSize));
		graphics.drawRoundRect(0, 0, width - shadowGap, 
				height - shadowGap, arcs.width, arcs.height);
 
		graphics.setStroke(new BasicStroke());
	}
} 

// FANCY DESIGN FOR THE SIDE MENU

class JLayeredMenuPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
 
		if (highQuality) {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
 
		if (shady) {
			graphics.setColor(shadowColorA);
			graphics.fillRoundRect(
					shadowOffset, 
					shadowOffset, 
					width - strokeSize - shadowOffset,  
					height - strokeSize - shadowOffset,  
					arcs.width, arcs.height); 
		} else {
			shadowGap = 1;
		}
 
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width - shadowGap, 
				height - shadowGap, arcs.width, arcs.height);
		graphics.setColor(getForeground());
		graphics.setStroke(new BasicStroke(strokeSize));
		graphics.drawRoundRect(0, 0, width - shadowGap, 
				height - shadowGap, arcs.width, arcs.height);
 
		graphics.setStroke(new BasicStroke());
	}
} 
  