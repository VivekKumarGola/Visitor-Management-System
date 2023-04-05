import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DepartmentShow extends JFrame {
	JLabel l,l1,l2,l3;
	JTextArea jt;
	
	public DepartmentShow() {
		setLayout(null);
		
		l=new JLabel("List of Department :");
		l.setBounds(50,50,500,50);
		add(l);	Font fl=new Font("ALGERIAN",Font.BOLD,32);
		l.setFont(fl);
		
		l1=new JLabel("DEPARTMENT ID");
		l1.setBounds(40,100,150,50);
		add(l1); Font fll=new Font("Times New Roman",Font.BOLD,16);
		l1.setFont(fll);
		
		l2=new JLabel("DEPARTMENT_NAME");
		l2.setBounds(300,100,300,50);
		add(l2); 
		l2.setFont(fll);

		l3=new JLabel("STATUS");
		l3.setBounds(650,100,150,50);
		add(l3); 
		l3.setFont(fll);

		jt=new JTextArea();
		jt.setBounds(50,150,900,500);
		add(jt); 
		jt.setEditable(false);
		refresh();
		
		setSize(1250,750);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		}
		void refresh() {
		String str="";
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select * from DEPARTMENT";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) 
			{
					str=str+"      "+rs.getString(1)+"\t\t\t";
					str=str+rs.getString(2)+"\t\t\t\t";
					str=str+rs.getString(3)+"";
					str=str+"\n";
			}
				jt.setText(str);
				con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}


	
	public static void main(String[] e) {
	// TODO Auto-generated method stub
		new DepartmentShow();	
	}
}