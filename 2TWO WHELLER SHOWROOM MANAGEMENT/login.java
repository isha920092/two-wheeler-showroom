import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener 
{
	JLabel user,pass,lbl,lbl1;
	JTextField tfuname;
	JPasswordField tfpass;
	JButton ok,can;
	ImageIcon img,img1;
	
	 
	public login()
	{
		img = new ImageIcon("password.jpg");
		lbl = new JLabel(img);
		lbl.setBounds(-120,40,400,400);
		add(lbl);
		img1 = new ImageIcon("user.jpg");
		lbl1 = new JLabel(img1);
		lbl1.setBounds(-120,-50,400,400);
		add(lbl1);
		user = new JLabel("Administrator");
		pass = new JLabel("Password");
		
		tfuname= new JTextField(30);
		tfpass = new JPasswordField(30);
		
		ok = new JButton("OK");
		can = new JButton("CANCEL");
		
		Container container = getContentPane();
		
		setSize(400,400);
		setTitle("Login");
		container.setLayout(null);
		this.setLocation(200,200);
		this.setResizable(false);
		setVisible(true);
		
		
		container.add(user);
		container.add(pass);
		container.add(tfuname);
		container.add(tfpass);
		container.add(ok);
		container.add(can);
		

		user.setBounds(120,140,80,25);
		pass.setBounds(120,230,80,25);
		tfuname.setBounds(220,140,150,25);
		tfpass.setBounds(220,230,150,25);
		ok.setBounds(100,300,80,30);
		can.setBounds(210,300,80,30);
			
		ok.addActionListener(this);
		ok.setActionCommand("Ok");
		can.addActionListener(this);
	}
	
	public static void main(String args[])
	{
		new login();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		JButton b1 = (JButton)ae.getSource();
		
		if(b1==can)
		{
			System.exit(0);
		}
			
			
		if(str.equals("Ok"))
		{
			Connection con = null;
			Statement stat = null;
			Boolean flag = false;
			try 
			{
				/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("Jdbc:Odbc:showroom");
				stat = con.createStatement();
			    ResultSet rs = stat.executeQuery("select * from userinfo");
				*/
				
			
			Class.forName("org.postgresql.Driver");
			con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from admin");
				
			while(rs.next())
				{
					if(tfuname.getText().equals(rs.getString(1)) && tfpass.getText().equals(rs.getString(2)))
					{
						flag = true;
						this.dispose();
						new menu();
					}
				}	
				
		    }
		    catch(SQLException sql)
		    {
		    	System.out.println ("Exeception Generated:"+sql);
		    }
		    catch(Exception ex) 
		    {
		    	System.out.println ("Exception Generated1:"+ex);
		    }
		    if(flag == false)
		    {
		    	JOptionPane.showMessageDialog(null,"User Does not Exists.","Error",JOptionPane.ERROR_MESSAGE);
		    }
		}
				
	}
	
}