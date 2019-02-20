import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class Form {
	
	 public Connection getConnection1() 
{
  Connection con = null;
  try 
  {
  Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection
  ("jdbc:mysql://localhost:3306/form","root","1234");
  } 
  catch (Exception e) 
  {
  System.out.println("Error in connection" + e);
  }
  return con;
	}
	private JFrame mainFrame;
	private JLabel IName;
	private JLabel IBatch;
	private JLabel IRollNo;
	private JLabel IGender;
	private JLabel IMobileNo;
	private JLabel IEmail;
	private JTextField tfName;
	private JTextField tfRollNo;
	private JTextField tfMobileNo;
	private JTextField tfEmail;
	private JComboBox<String> cbBatch;
	private ButtonGroup bgGender;
	private JRadioButton male;
	private JRadioButton female;
	private JButton btSubmit;
	private JButton btReset;

	
	private void InitializeComponents() {
		mainFrame = new JFrame("Student Form");
		mainFrame.setSize(300, 600);
		IName = new JLabel("Username");
		IMobileNo = new JLabel("Mobile No");
		IBatch = new JLabel("Batch");
		IRollNo = new JLabel("Roll No");
		IGender = new JLabel("Gender");
		IEmail = new JLabel("Email");
		tfName = new JTextField();
		tfRollNo = new JTextField();
		tfMobileNo = new JTextField();
		tfEmail = new JTextField();
		cbBatch = new JComboBox<String>();
		cbBatch.addItem("2011");
		cbBatch.addItem("2012");
		cbBatch.addItem("2013");
		cbBatch.addItem("2014");
		cbBatch.addItem("2015");
		cbBatch.addItem("2016");
		cbBatch.addItem("2017");
		male = new JRadioButton("Male", true);
		female = new JRadioButton("Female");
		bgGender = new ButtonGroup();
		bgGender.add(male);
		bgGender.add(female);
		btSubmit = new JButton("Submit");
		btReset = new JButton("Reset");
	}

	private void AddComponents() {
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GridLayout gl = new GridLayout(15, 1, 20, 5);
		mainFrame.setLayout(gl);
		mainFrame.add(IName);
		mainFrame.add(tfName);
		mainFrame.add(IBatch);
		mainFrame.add(cbBatch);
		mainFrame.add(IGender);
		mainFrame.add(male);
		mainFrame.add(female);
		mainFrame.add(IRollNo);
		mainFrame.add(tfRollNo);
		mainFrame.add(IMobileNo);
		mainFrame.add(tfMobileNo);
		mainFrame.add(IEmail);
		mainFrame.add(tfEmail);
		mainFrame.add(btSubmit);
		mainFrame.add(btReset);
	}

	private void setUpEvents() {
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFormValid()) {
					JOptionPane.showMessageDialog(null, "Form Submitted");
				
		String n=tfName.getText();
	String r = tfRollNo.getText();
	String p = tfMobileNo.getText();
		String em=tfEmail.getText();	
			
			
			
			
			try {
  Connection con = getConnection1();
  Statement st = con.createStatement();
  
  String sq="INSERT INTO `form`.`form` (`rollno`, `name`, `phoneno`, `email`) VALUES (''21','hashim','6512458795','taqcsd@sada.com')";
  st.executeUpdate(sq);
ResultSet res = st.executeQuery("SELECT * FROM form");
  while (res.next()) 
  {
    System.out.print(res.getString(1));
	System.out.print("\t");
    System.out.print(res.getString(2));
	System.out.print("\t");
    System.out.print(res.getString(3));
	System.out.print("\t");
    System.out.println(res.getString(4));
  }
  res.close();
  con.close();
  } 
  catch (Exception ex) 
  {
  System.out.println("Error in fetching data" + ex);
  }
			} 
		else {
					JOptionPane.showMessageDialog(null, "Form InValid");
				}	
			}
		});
		btReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		tfName.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				
			}		

			@Override
			public void focusLost(FocusEvent arg0) {
				if(!validateName(tfName.getText()))
				{
					JOptionPane.showMessageDialog(null, "Username Invalid");
				}
				
			}
			
		});
		tfRollNo.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				
			}		

			@Override
			public void focusLost(FocusEvent arg0) {
				if(!validateRollNo(tfRollNo.getText()))
				{
					JOptionPane.showMessageDialog(null, "Roll No Invalid");
				}	
			}
		});
		tfEmail.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				
			}		

			@Override
			public void focusLost(FocusEvent arg0) {
				if(!validateEmail(tfEmail.getText()))
				{
					JOptionPane.showMessageDialog(null, "Email Invalid");
				}
				
			}
		});
		tfMobileNo.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				
			}		

			@Override
			public void focusLost(FocusEvent arg0) {
				if(!validateMobileNo(tfMobileNo.getText()))
				{
					JOptionPane.showMessageDialog(null, "Mobile No Invalid");
				}
				
			}
		});
		}

	public void resetForm() {
		tfName.setText("");
		tfRollNo.setText("");
		tfMobileNo.setText("");
		tfEmail.setText("");
	}

	private boolean isFormValid() {
		boolean nameValid, rollNoValid, mobileNoValid, emailValid;
		nameValid = rollNoValid = mobileNoValid = emailValid = false;
		String name = tfName.getText();
		nameValid = validateName(name);
		String rollNo = tfRollNo.getText();
		rollNoValid = validateRollNo(rollNo);
		String mobileNo = tfMobileNo.getText();
		mobileNoValid = validateMobileNo(mobileNo);
		String email = tfEmail.getText();
		emailValid = validateEmail(email);
		if (nameValid && rollNoValid && mobileNoValid && emailValid)
			return true;
		return false;
	}

	private boolean validateEmail(String email) {
		if (email.isEmpty() || !email.matches("^\\S+@\\S+\\..+$"))
			return false;
		return true;
	}

	private boolean validateMobileNo(String mobileNo) {
		if (mobileNo.isEmpty() || !mobileNo.matches("[0-9]{10}"))
			return false;
		return true;
	}

	private boolean validateName(String name) {
		if (name.isEmpty() || name.matches("^[0-9].*"))
			return false;
		return true;
	}

	private boolean validateRollNo(String rollNo) {
		if (rollNo.isEmpty() || !rollNo.matches("^[0-9]+"))
			return false;
		return true;
	}
	
	public void RunApp() {
		mainFrame.setVisible(true);
	}
	
	
	
	Form()
	{
	
	
	
		InitializeComponents();
		AddComponents();
		setUpEvents();
	

	

	
	}
	public static void main(String[] args) {
		new Form().getConnection1();
		new Form().RunApp();
	
	}}