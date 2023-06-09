import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ManagerUpdate  extends JFrame  implements ActionListener,ItemListener  {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t2,t3,t4,t5,t6,t7,t9;
	JComboBox c1,c2,td;
	JButton b1,b2;
	JTextArea ta1;
	public ManagerUpdate() {
		setLayout(null);
		setVisible(true);
		setSize(1350,750);
		setTitle("Manager Details");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		l11=new JLabel("Manager Details");
		l11.setBounds(700, 30, 250, 40); add(l11);
		l1=new JLabel("Manager ID:");
		l1.setBounds(70, 90, 150, 40);
		Font lf11= new Font("Times New Roman",Font.CENTER_BASELINE,26);
		l11.setFont(lf11);
		add(l1); Font lf1= new Font("Times New Roman",Font.BOLD,20);
		l1.setFont(lf1);
		c1=new JComboBox();
		c1.addItem("Empty");
		filldata();
		c1.setBounds(250,100,300,30);
		add(c1);
		c1.addItemListener(this);
		
		l2=new JLabel("Manager Name:");
		l2.setBounds(70, 160, 150, 40);
		add(l2); Font lf2= new Font("Times New Roman",Font.BOLD,20);
		l2.setFont(lf2);
		t2=new JTextField();
		t2.setBounds(250,170,300,30);
		add(t2);
		
		l3=new JLabel("Manager E-mail:");
		l3.setBounds(70, 230, 150, 40);
		add(l3); Font lf3= new Font("Times New Roman",Font.BOLD,20);
		l3.setFont(lf3);
		t3=new JTextField();
		t3.setBounds(250,240,300,30);
		add(t3);
		
		l4=new JLabel("Manager Phone No.:"); 
		l4.setBounds(70, 300, 200, 30);
		add(l4); Font lf4= new Font("Times New Roman",Font.BOLD,20);
		l4.setFont(lf4);
		t4=new JTextField();
		t4.setBounds(250,310,300,30);
		add(t4);
		
		l5=new JLabel("Date Of Joining:");
		l5.setBounds(70, 370, 150, 30);
		add(l5); Font lf5= new Font("Times New Roman",Font.BOLD,20);
		l5.setFont(lf2);
		t5=new JTextField();
		t5.setBounds(250,380,300,30);
		add(t5);

		l9 = new JLabel("Department Id:");
		l9.setBounds(70, 480, 150, 30);
		add(l9);
		l9.setFont(lf2);

		td=new JComboBox();
		td.setBounds(250,480,300,30);
		add(td);
		td.addItem("Empty");
		td.addItemListener(this);
		filldata3();

		l10=new JLabel("Department Name:");
		l10.setBounds(70, 570, 200, 30);
		add(l10);
		l10.setFont(lf2);

		t9=new JTextField();
		t9.setBounds(250,570,300,30);
		t9.setEditable(false);
		add(t9);
		
		l6=new JLabel("Manager ID Type:");
		l6.setBounds(750, 120, 250, 30);
		add(l6); Font lf6= new Font("Times New Roman",Font.BOLD,20);
		l6.setFont(lf2);
		t6=new JTextField();
		t6.setBounds(1000,135,300,30);
		add(t6);
		
		l7=new JLabel("Manager ID Details:");
		l7.setBounds(750, 190, 250, 30);
		add(l7); Font lf7= new Font("Times New Roman",Font.BOLD,20);
		l7.setFont(lf2);
		t7=new JTextField();
		t7.setBounds(1000,195,300,30);
		add(t7);
		
		l8=new JLabel("Manager Shift time-ID: ");
		l8.setBounds(750, 270, 250, 30);
		add(l8); Font lf8= new Font("Times New Roman",Font.BOLD,20);
		l8.setFont(lf2);
		c2=new JComboBox();
		c2.addItem("Empty");
		filldata2();
		c2.setBounds(1000,275,300,30);
		add(c2);
		c2.addItemListener(this);
		
		ta1=new JTextArea();
		ta1.setBounds(750,330,500,200);
		add(ta1);
		
		b1=new JButton("Update");   
		b1.setBounds(800,600,150,60); add(b1);
		b1.addActionListener(this);
		b2=new JButton("Close");   
		b2.setBounds(1000,600,150,60); add(b2);
		b2.addActionListener(this);
	}
	void filldata2()
	{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select shifttime_id from shift_time";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				c2.addItem(String.valueOf(rs.getString(1)));
			}
		}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
	}	
	void filldata3()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select DEPARTMENT_ID from Department";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				td.addItem(String.valueOf(rs.getString(1)));
			}
		}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}

	void filldata() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String sql="select Manager_Id from Manager";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			c1.addItem(rs.getString(1));
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}


	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException  {
		// TODO Auto-generated method stub
		new ManagerUpdate();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String a=String.valueOf(c1.getSelectedItem());//id
			String b=t2.getText();//name
			String c=t3.getText();//email
			String d=t4.getText();//doj  phone
			String e=t5.getText();//id_type  doj
			String f=t6.getText();//id
			String g=t7.getText();//phone_no
			String h=String.valueOf(c2.getSelectedItem());//shift_id	
			String i=String.valueOf(td.getSelectedItem());//shift_id	
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql=" update manager set MNAME=?,Department_id=?,MEMAIL=?,MDOJ=?,MID_TYPE=?,MID_DETAILS=?,MPHONE=?,SHIFTTIME_ID=?,STATUS=1 where MANAGER_ID=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,b);
					st.setString(2,i);
					st.setString(3,c);
					st.setString(4,e);
					st.setString(5,f);
					st.setString(6,g);
					st.setString(7,d);
					st.setString(8,h);
					st.setString(9,a);					
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Updated");
					conn.close();
					c1.setSelectedItem("Empty");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					c2.setSelectedItem("Empty");
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
	
		}		 
        if(ae.getSource()==b2) {
        	this.hide();
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==c2) {
			String z=String.valueOf(c2.getSelectedItem());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select SHIFT_TIME.SHIFTMASTER_ID, SHIFT_MASTER.MON,SHIFT_MASTER.TUE,SHIFT_MASTER.WED,SHIFT_MASTER.THU,SHIFT_MASTER.FRI,SHIFT_MASTER.SAT,SHIFT_MASTER.SUN,SHIFT_TIME.SHIFTTFROM,SHIFT_TIME.SHIFTTTO from shift_time,shift_master where shift_time.shiftmaster_id=shift_master.SHIFTMASTER_ID and shift_time.shifttime_id=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,z);
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
				ta1.setText("SHIFT TIME AND SHIFT DAY"+"\n"+"Shif_id:-"+rs.getString(1)+"\n"+"Monday:-"+rs.getString(2)+"\n"+"Tuesday:-"+rs.getString(3)+"\n"+"Wednesday:-"+rs.getString(4)+"\n"+"Thrusday:-"+rs.getString(5)+"\n"+"Friday:-"+rs.getString(6)+"\n"+"Saturday:-"+rs.getString(7)+"\n"+"Sunday:-"+rs.getString(8)+"\n"+"Shift From :-"+rs.getString(9)+"\n"+"Shift To:-"+rs.getString(10));
				}
				conn.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			if(c2.getSelectedItem()=="Empty")
				ta1.setText("");
		}
		if(e.getSource()==td) {
			String a=String.valueOf(td.getSelectedItem());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select DEPARTMENT_NAME from Department where DEPARTMENT_ID=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				rs.next();
				t9.setText(rs.getString(1));
				conn.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			if(td.getSelectedItem()=="Empty")
				t9.setText("");
		}
	
		if(e.getSource()==c1) {
			String a=String.valueOf(c1.getSelectedItem());//id
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from manager where manager_id=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				//c1.setText("");
				rs.next();
				t2.setText(rs.getString(2));
				td.setSelectedItem(rs.getString(3));
				t3.setText(rs.getString(4));
				t4.setText(rs.getString(8));
				t5.setText(rs.getString(5));
				t6.setText(rs.getString(6));
				t7.setText(rs.getString(7));
				c2.setSelectedItem(rs.getString(9));
				conn.close();
				
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			if(c1.getSelectedItem()=="Empty") {
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t9.setText("");
				td.setSelectedItem("Empty");
				c2.setSelectedItem("Empty");
			}

		}
		
	}
}