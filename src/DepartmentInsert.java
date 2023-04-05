import javax.swing.*;

import com.DataUtil.DataBase;

import java.awt.event.*;
import java.sql.*;
public class DepartmentInsert extends JFrame implements ActionListener, FocusListener{
	JLabel l1,l2;
	JTextField t1,t2;
	
	JButton bt1,bt2;
	
	public DepartmentInsert(){
		setLayout(null);	
		
		l1 = new JLabel("Department Id");
		l1.setBounds(150,100,150,50);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(400,100,200,30);
		add(t1);
		t1.addFocusListener(this);
		l1 = new JLabel("Department Name");
		l1.setBounds(150,200,150,50);
		add(l1);
		
		t2=new JTextField();
		t2.setBounds(400,200,200,30);
		add(t2);
		t2.addFocusListener(this);
		bt1 = new JButton("SAVE");
		bt1.setBounds(500,400,100,40);
		add(bt1);
		bt1.addActionListener(this);
		
		bt2 = new JButton("Cancel");
		bt2.setBounds(700,400,100,40);
		add(bt2);
		bt2.addActionListener(this);
		
		setSize(1350,750);
		setVisible(true);		
		setTitle("Department Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DepartmentInsert();

	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt1) {
			String a=t1.getText();//id
			String b=t2.getText();//manager_id			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="insert into department values(?,?,1)";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					st.setString(2,b);
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Save Successful");
					conn.close();	
					t1.setText("");
					t2.setText("");
				}
					catch(Exception ex) {
						System.out.println(ex);
					}
		}
		if(ae.getSource()==bt2) {
			this.hide();
			
		}		
	}


	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==t1) {
			if(t1.getText().equals("")) {
					JOptionPane.showMessageDialog(this,"Please Enter the Department ID");
					t1.grabFocus();
				}
		}
		if(e.getSource()==t2) {
			if(((t2.getText()!=null))) {
				JOptionPane.showMessageDialog(null,"Please Enter the Department Name ");
				t2.grabFocus();
			}
		}
	}
}