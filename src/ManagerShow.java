import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ManagerShow extends JFrame {
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
	JTextArea jt;
	
	public ManagerShow() {
		setLayout(null);
		
		l=new JLabel("List of Manager Id :");
		l.setBounds(50,50,500,50);
		add(l);	Font fl=new Font("ALGERIAN",Font.BOLD,32);
		l.setFont(fl);
		
		l1=new JLabel("MANAGER ID");
		l1.setBounds(30,100,150,50);
		add(l1); Font fll=new Font("Times New Roman",Font.BOLD,16);
		l1.setFont(fll);
		
		l2=new JLabel("MANAGER NAME");
		l2.setBounds(170,100,150,50);
		add(l2); 
		l2.setFont(fll);

		l3=new JLabel("EMAIL");
		l3.setBounds(400,100,150,50);
		add(l3); 
		l3.setFont(fll);
		
		l4=new JLabel("DateofJoining");
		l4.setBounds(650,100,150,50);
		add(l4); 
		l4.setFont(fll);
		
		l5=new JLabel("PHONE No");
		l5.setBounds(850,100,150,50);
		add(l5); 
		l5.setFont(fll);
		
		l6=new JLabel("SHIFT_TIME ID");
		l6.setBounds(1060,100,200,50);
		add(l6); 
		l6.setFont(fll);

		l7=new JLabel("STATUS");
		l7.setBounds(1260,100,150,50);
		add(l7); 
		l7.setFont(fll);

		jt=new JTextArea();
		jt.setBounds(50,150,1650,800);
		add(jt); 
		jt.setEditable(false);
		refresh();
		
		setSize(1750,950);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		}
		void refresh() {
		String str="";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select * from manager";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) 
			{
					str=str+"      "+rs.getString(1)+"\t\t";
					str=str+rs.getString(2)+"\t\t";
					str=str+rs.getString(4)+"\t\t";
					str=str+rs.getString(5)+"\t\t";
					str=str+rs.getString(8)+"\t\t";
					str=str+rs.getString(9)+"\t\t";
					str=str+rs.getString(10)+"\t\t";
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
		new ManagerShow();	
	}
}