import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ShiftTimeShow extends JFrame {
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextArea jt;
	
	public ShiftTimeShow() {
		setLayout(null);
		
		l=new JLabel("List of Shift Time:");
		l.setBounds(50,50,500,50);
		add(l);	Font fl=new Font("ALGERIAN",Font.BOLD,32);
		l.setFont(fl);
		
		l1=new JLabel("SHIFT TIME ID");
		l1.setBounds(30,100,150,50);
		add(l1); Font fll=new Font("Times New Roman",Font.BOLD,16);
		l1.setFont(fll);
		
		l2=new JLabel("SHIFT MASTER ID");
		l2.setBounds(170,100,150,50);
		add(l2); 
		l2.setFont(fll);

		l3=new JLabel("SHIFT TIME TO");
		l3.setBounds(350,100,150,50);
		add(l3); 
		l3.setFont(fll);
		
		l4=new JLabel("SHIFT TIME FROM");
		l4.setBounds(520,100,150,50);
		add(l4); 
		l4.setFont(fll);
		
		l5=new JLabel("STATUS");
		l5.setBounds(740,100,150,50);
		add(l5); 
		l5.setFont(fll);		

		jt=new JTextArea();
		jt.setBounds(50,150,800,500);
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
			String sql="select * from Shift_Time";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) 
			{
					str=str+"      "+rs.getString(1)+"\t\t";
					str=str+rs.getString(2)+"\t\t";
					str=str+rs.getString(3)+"\t\t";
					str=str+rs.getString(4)+"\t\t";
					str=str+rs.getString(5)+"\n";
					
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
		new ShiftTimeShow();	
	}
}