import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.DataUtil.*;

public class ManagerDelete  extends JFrame  implements ActionListener,ItemListener  {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t2,t3,t4,t5,t6,t7,t8,t9,t10,t12;
	JComboBox c1;
	JButton b1,b2;
	public ManagerDelete() {
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
		t2.setEditable(false);
		
		l3=new JLabel("Manager E-mail:");
		l3.setBounds(70, 230, 150, 40);
		add(l3); Font lf3= new Font("Times New Roman",Font.BOLD,20);
		l3.setFont(lf3);
		t3=new JTextField();
		t3.setBounds(250,240,300,30);
		add(t3);
		t3.setEditable(false);
		
		l4=new JLabel("Manager Phone No.:"); 
		l4.setBounds(70, 300, 200, 30);
		add(l4); Font lf4= new Font("Times New Roman",Font.BOLD,20);
		l4.setFont(lf4);
		t4=new JTextField();
		t4.setBounds(250,310,300,30);
		add(t4);
		t4.setEditable(false);

		l5=new JLabel("Date Of Joining:");
		l5.setBounds(70, 370, 150, 30);
		add(l5); Font lf5= new Font("Times New Roman",Font.BOLD,20);
		l5.setFont(lf2);
		t5=new JTextField();
		t5.setBounds(250,380,300,30);
		add(t5);
		t5.setEditable(false);

		l12=new JLabel("Department_id :");
		l12.setBounds(70, 450, 150, 30);
		add(l12);
		l12.setFont(lf2);
		t12=new JTextField();
		t12.setBounds(250,450,300,30);
		add(t12);
		t12.setEditable(false);

		l6=new JLabel("Manager ID Type:");
		l6.setBounds(750, 120, 250, 30);
		add(l6); Font lf6= new Font("Times New Roman",Font.BOLD,20);
		l6.setFont(lf2);
		t6=new JTextField();
		t6.setBounds(1000,135,300,30);
		add(t6);
		t6.setEditable(false);

		l7=new JLabel("Manager ID Details:");
		l7.setBounds(750, 190, 250, 30);
		add(l7); Font lf7= new Font("Times New Roman",Font.BOLD,20);
		l7.setFont(lf2);
		t7=new JTextField();
		t7.setBounds(1000,195,300,30);
		add(t7);
		t7.setEditable(false);

		l8=new JLabel("Manager Shift time-ID: ");
		l8.setBounds(750, 270, 250, 30);
		add(l8); Font lf8= new Font("Times New Roman",Font.BOLD,20);
		l8.setFont(lf2);
		t8=new JTextField();
		t8.setBounds(1000,275,300,30);
		add(t8);
		t8.setEditable(false);

 
		b1=new JButton("Delete");   
		b1.setBounds(800,600,150,60); add(b1);
		b1.addActionListener(this);
		b2=new JButton("Close");   
		b2.setBounds(1000,600,150,60); add(b2);
		b2.addActionListener(this);
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
		new ManagerDelete();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String a=String.valueOf(c1.getSelectedItem());//id
			DataBase obj=new DataBase();
			obj.makeConnection();
			String str=obj.deleteData("manager","manager_id" , a);
			JOptionPane.showMessageDialog(this,str);
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
		}		 
        if(ae.getSource()==b2) {
        	this.hide();	
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
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
				t12.setText(rs.getString(3));
				t3.setText(rs.getString(4));
				t4.setText(rs.getString(8));
				t5.setText(rs.getString(5));
				t6.setText(rs.getString(6));
				t7.setText(rs.getString(7));
				t8.setText(rs.getString(9));
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
				t8.setText("");
				t9.setText("");
			}
		}
	}
}