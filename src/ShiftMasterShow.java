import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ShiftMasterShow extends JFrame {
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextArea jt;
	
	public ShiftMasterShow() {
		setLayout(null);
		
		l=new JLabel("List of Shift Days:");
		l.setBounds(50,50,500,50);
		add(l);	Font fl=new Font("ALGERIAN",Font.BOLD,32);
		l.setFont(fl);
		
		l1=new JLabel("SHIFT_Master ID");
		l1.setBounds(30,100,150,50);
		add(l1); Font fll=new Font("Times New Roman",Font.BOLD,16);
		l1.setFont(fll);
		
		l2=new JLabel("Mon");
		l2.setBounds(220,100,150,50);
		add(l2); 
		l2.setFont(fll);

		l3=new JLabel("Tue");
		l3.setBounds(310,100,150,50);
		add(l3); 
		l3.setFont(fll);
		
		l4=new JLabel("Wed");
		l4.setBounds(390,100,150,50);
		add(l4); 
		l4.setFont(fll);
		
		l5=new JLabel("Thur");
		l5.setBounds(480,100,150,50);
		add(l5); 
		l5.setFont(fll);
	
		l6=new JLabel("Fri");
		l6.setBounds(570,100,150,50);
		add(l6); 
		l6.setFont(fll);
		
		l7=new JLabel("Sat");
		l7.setBounds(660,100,150,50);
		add(l7); 
		l7.setFont(fll);

		l8=new JLabel("Sun");
		l8.setBounds(750,100,150,50);
		add(l8); 
		l8.setFont(fll);
		
		l9=new JLabel("Status");
		l9.setBounds(840,100,150,50);
		add(l9); 
		l8.setFont(fll);

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
			String sql="select * from Shift_master";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) 
			{
					str=str+"      "+rs.getString(1)+"\t\t";
					str=str+rs.getString(2)+"\t";
					str=str+rs.getString(3)+"\t";
					str=str+rs.getString(4)+"\t";
					str=str+rs.getString(5)+"\t";
					str=str+rs.getString(6)+"\t";
					str=str+rs.getString(7)+"\t";
					str=str+rs.getString(8)+"\t";
					str=str+rs.getString(9)+"\n";
					
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
		new ShiftMasterShow();	
	}
}