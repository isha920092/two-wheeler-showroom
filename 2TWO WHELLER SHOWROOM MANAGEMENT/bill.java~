import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class bill extends JFrame implements ActionListener
{
	JLabel message,rno,idate,ono,rcd,amt,pmode,mname,lblvname,cname;
	JTextField tfrno,tfidate,tfono,tfrcd,tfamt,tfpmode,tfmname,tfcname;
	JButton ok,can,print;
	JComboBox jcmname,jmode;
	public bill()
	{
		message = new JLabel("INVOICE");
		rno = new JLabel("Invoice No");
		idate = new JLabel("Date");
		ono = new JLabel("Order No");
		rcd = new JLabel("Customer Name");
		amt = new JLabel("Engine No");
		pmode = new JLabel("Payment Mode");
		mname = new JLabel("Amount");
		lblvname =new JLabel("Vehicle Name");
		cname = new JLabel("Chasis No");
		
		tfrno = new JTextField(30);
		tfidate = new JTextField(30);
		tfono = new JTextField(30);
		tfrcd = new JTextField(30);
		tfamt = new JTextField(30);
		tfpmode = new JTextField(30);
		tfmname = new JTextField(30);
		tfcname = new JTextField(30);
		jcmname = new JComboBox();
		jmode = new JComboBox();
		
		ok = new JButton("OK");
		can = new JButton("CANCEL"); 
	
		
		can.addActionListener(this);
		can.setActionCommand("can");
		ok.addActionListener(this);
		ok.setActionCommand("ok");
		
		
		Container c = getContentPane();
	
		setSize(800,600);
		setTitle("INVOICE");
		c.setLayout(null);
		setVisible(true);
		
		c.add(message);
		c.add(rno);
		c.add(idate);
		c.add(ono);
		c.add(rcd);
		c.add(amt);
		c.add(pmode);
		c.add(mname);
		c.add(cname);
		
		c.add(tfrno);
		c.add(tfidate);
		c.add(tfono);
		c.add(tfrcd);
		c.add(tfamt);
		c.add(tfpmode);
		c.add(tfmname);
		c.add(tfcname);
		
		c.add(ok);
		c.add(can);
		c.add(jcmname);
		c.add(jmode);
		c.add(lblvname);
		
		
		
		message.setBounds(250,30,200,50);
		rno.setBounds(50,100,100,30);
		idate.setBounds(530,100,80,30);
		ono.setBounds(300,100,100,30);
		rcd.setBounds(50,150,150,30);
		amt.setBounds(50,300,100,30);
		pmode.setBounds(300,350,100,30);
		mname.setBounds(50,350,100,30);
		cname.setBounds(50,250,150,30);
		
		tfrno.setBounds(150,100,100,30);
		tfidate.setBounds(600,100,120,30);
		tfono.setBounds(380,100,100,30);
		tfrcd.setBounds(150,150,240,30);
		tfamt.setBounds(150,300,100,30);		
		tfmname.setBounds(150,350,100,30);
		tfcname.setBounds(150,250,100,30);
		lblvname.setBounds(50,200,150,30);
		jcmname.setBounds(150,200,100,30);
		
		jcmname.addItem("Pulsar");
		jcmname.addItem("CT 100");
		jcmname.addItem("Discover DTS-i");
		jcmname.addItem("Wave DTS-i");
		jmode.addItem(" -- Select --");
		jmode.addItem("Cash");
		jmode.addItem("Cheque");
		jmode.setBounds(400,350,100,30);
		
		ok.setBounds(200,450,85,30);
		can.setBounds(300,450,85,30);
		
		
	}
	
	
		public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
	    Connection con = null;
	    Statement stat = null;
	    
	    
	    if(str.equals("ok"))
		{
			
			int intinsert=0;
		    Boolean flag = false;
		    if(tfrno.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter the Invoice number","Error",JOptionPane.ERROR_MESSAGE);
				
			}
			try 
			{			
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");
				Statement stat1 = con.createStatement();
				ResultSet rs = stat1.executeQuery("select * from bill");
				while(rs.next())
				{
					if(rs.getInt(1) == Integer.parseInt(tfrno.getText()))
					{
						flag = true;
					}
				}
				if(flag == false)
				{
				/*
create table bill (ino integer primary key,ono integer references order1(odno), date_of_bill varchar ,cname varchar ,vname varchar ,chno varchar ,egno varchar ,amt integer,pmode varchar );*/
					PreparedStatement pstmt = con.prepareStatement("insert into bill values (?,?,?,?,?,?,?,?,?)");
					
					
			    	pstmt.setInt(1,Integer.parseInt(tfrno.getText()));
			    	pstmt.setInt(2,Integer.parseInt(tfono.getText()));
			    	pstmt.setString(3,tfidate.getText());
			    	pstmt.setString(4,tfrcd.getText());
			    	pstmt.setString(5,(String)jcmname.getSelectedItem());
			    	pstmt.setInt(6,Integer.parseInt(tfcname.getText()));
			    	pstmt.setInt(7,Integer.parseInt(tfamt.getText()));
			    	pstmt.setInt(8,Integer.parseInt(tfmname.getText()));
			    	pstmt.setString(9,(String)jmode.getSelectedItem());
			    	
			    	
			    	
			    	intinsert = pstmt.executeUpdate();
			    	
			    	pstmt.close();
			    	con.close();

				}
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null,"Record Already Exists","Error",JOptionPane.ERROR_MESSAGE);
					tfrno.setText(null);
				}
			}
		        catch (SQLException se) 
	 		{
	    			System.out.println ("Ex1:"+se);
	    		}
		    catch (Exception ex3) 
		    {
		    	
		    }
		    if(intinsert == 1)
		    {
		    	JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
		    	
		    	
		    	tfrno.setText(null);
		    	tfmname.setText(null);
		    	tfcname.setText(null);
		    	tfidate.setText(null);
		    	tfono.setText(null);
		    	tfrcd.setText(null);
		    	tfamt.setText(null);
		    	
		    	    	
		    }
		}
	    
	    if(str.equals("print"))
		{
			
		}
	    
	    if(str.equals("can"))
		{
			this.dispose();
			new menu();
		}
	}
   public static void main(String args[])
	{
		new bill();
	}
}

