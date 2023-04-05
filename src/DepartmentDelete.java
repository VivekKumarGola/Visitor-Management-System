import javax.swing.*;
import com.DataUtil.DataBase;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DepartmentDelete extends JFrame implements ActionListener{
	JLabel l1,l2;
	JTextField t1,t2;
	JComboBox c1;
	JButton bt1,bt2,bt3;
	public DepartmentDelete() {
		setLayout(null);
		l1=new JLabel("Department Id");
		l1.setBounds(250,100,150,40);
		add(l1);
		
		c1 = new JComboBox();
		c1.setBounds(550,100,200,30);
		c1.addItem("Empty");
		add(c1);
		filldata();
		l2=new JLabel("Department Name");
		l2.setBounds(250,200,150,40);
		add(l2);
		
		t2 = new JTextField();
		t2.setBounds(550,200,200,30);
		add(t2);
		
		bt1=new JButton("Find");
		bt1.setBounds(850,100,80,40);
		add(bt1);
		bt2=new JButton("Delete");
		bt2.setBounds(400,300,80,40);
		add(bt2);
		bt3=new JButton("cancle");
		bt3.setBounds(550,300,80,40);
		add(bt3);
		bt1.addActionListener(this);
		bt3.addActionListener(this);
		bt2.addActionListener(this);
	
		setVisible(true);
		setSize(1000,750);
		setTitle("Department delete");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	void filldata() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String sql="select department_id from department";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			c1.addItem(rs.getString(1));
		}
		}
	catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentDelete obj=new DepartmentDelete();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt1) {
			String a=String.valueOf(c1.getSelectedItem());
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select * from department where Department_id=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					
					ResultSet rs=st.executeQuery();
					rs.next();
				
					t2.setText(rs.getString(2));
								conn.close();
					
			}
				catch(Exception ex) {
					System.out.println(ex);
				}
		}
		if(ae.getSource()==bt2) {
			String a=String.valueOf(c1.getSelectedItem());//id
			DataBase obj=new DataBase();
			obj.makeConnection();
			String str=obj.deleteData("department","department_id" , a);
			JOptionPane.showMessageDialog(this,str);
			t2.setText("");
		
		}		 
		if(ae.getSource()==bt3) {
			this.hide();
		}
	}
}