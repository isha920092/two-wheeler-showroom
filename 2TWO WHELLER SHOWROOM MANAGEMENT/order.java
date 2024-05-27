import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class order extends JFrame implements ActionListener,KeyListener
{
	JLabel message,ono,qno,date,cno,cname,age,add,tno,oveh,color,vprc,eddate,aproof,pmode,cash,cheque,dd;
	JTextField tfono,tfqno,tfdate,tfcno,tfcname,tfage,tfadd,tftno,tfvprc,tfeddate;
	JButton ok,can,up;
	JComboBox jcvname,jccolor,jcadd;
	JRadioButton rbcash,rbcheque;
	ButtonGroup bg = new ButtonGroup();
	
	public order()
	{
	String names[] = {"Pulsar", "CT-100","Discover DTS-i","Wave DTS-i"};
		message = new JLabel("ORDER VEHICLE");
		ono = new JLabel("Order No");
		qno = new JLabel("Quotation No");
		date = new JLabel("Date");
		cno = new JLabel("Customer No");
		cname = new JLabel("Customer Name");
		age = new JLabel("Age");
		add = new JLabel("Adderess");
		tno = new JLabel("Telephone No");
		oveh = new JLabel("Ordered Vehicle");
		color = new JLabel("Color");
		vprc = new JLabel("Vehicle Price");
		aproof = new JLabel("Adderess Proof");
		eddate = new JLabel("Expected del. Date");
		pmode = new JLabel("Payment Mode");
		cash = new JLabel("Cash");
		cheque = new JLabel("Cheque");
		//dd = new JLabel("DD");
		
		tfono = new JTextField(30);
		tfqno = new JTextField(30);
		tfdate = new JTextField(30);
		tfcno = new JTextField(30);
		tfcno.setToolTipText("Please Press Enter Key");
		tfcname = new JTextField(30);
		tfage = new JTextField(30);
		tfadd = new JTextField(30);
		tftno = new JTextField(30);
		tfvprc = new JTextField(30);
		tfeddate = new JTextField(30);
		
		rbcash = new JRadioButton("Cash");
		rbcheque = new JRadioButton("Cheque");
		//rbdd = new JRadioButton();
		
		jcvname = new JComboBox();
		jccolor = new JComboBox();
		jcadd = new JComboBox();
		
		ok = new JButton("ADD");
		can = new JButton("CANCEL"); 
	
		
		can.addActionListener(this);
		can.setActionCommand("can");
		ok.addActionListener(this);
		ok.setActionCommand("Ok");
		
		Container c = getContentPane();
	
		setSize(800,600);
		setTitle("Order");
		c.setLayout(null);
		setVisible(true);
		
		c.add(message);
		c.add(ono);
		c.add(qno);
		c.add(date);
		c.add(cno);
		c.add(cname);
		c.add(age);
		c.add(add);
		c.add(tno);
		c.add(oveh);
		c.add(color);
		c.add(vprc);
		c.add(aproof);
		c.add(eddate);
		c.add(pmode);
		c.add(cash);
		c.add(cheque);
		//c.add(dd);
		
		c.add(tfono);
		c.add(tfqno);
		c.add(tfdate);
		c.add(tfcno);
		c.add(tfcname);
		c.add(tfage);
		c.add(tfadd);
		c.add(tftno);
		c.add(tfvprc);
		c.add(tfeddate);
		
		bg.add(rbcash);
		bg.add(rbcheque);
		c.add(rbcash);
		c.add(rbcheque);
		//c.add(rbdd);
		
		c.add(jcvname);
		c.add(jccolor);
		c.add(jcadd);
		
		c.add(ok);
		c.add(can);
	
		
		message.setBounds(300,30,200,50);
		ono.setBounds(50,100,100,25);
		qno.setBounds(300,100,100,25);
		date.setBounds(550,100,50,25);
		cno.setBounds(50,170,100,25);
		cname.setBounds(280,170,100,25);
		age.setBounds(550,170,50,25);
		add.setBounds(50,220,150,25);
		tno.setBounds(400,220,100,25);
		oveh.setBounds(50,290,100,25);
		color.setBounds(420,290,100,25);
		vprc.setBounds(50,340,100,25);
		aproof.setBounds(390,340,100,25);
		eddate.setBounds(40,390,150,25);
		pmode.setBounds(300,390,100,25);
		cash.setBounds(450,390,50,25);
		cheque.setBounds(560,390,50,25);
		//dd.setBounds(670,390,50,25);
		
		tfono.setBounds(160,100,80,25);
		tfqno.setBounds(400,100,80,25);
		tfdate.setBounds(600,100,120,25);
		tfcno.setBounds(160,170,80,25);
		tfcname.setBounds(400,170,100,25);
		tfage.setBounds(600,170,50,25);
		tfadd.setBounds(160,220,150,25);
		tftno.setBounds(500,220,100,25);
		
		jcvname.setBounds(160,290,150,30);
		jcvname.addItem("-- Select Vehicle -- ");
		jcvname.addItem("Pulsar");
		jcvname.addItem("CT 100");
		jcvname.addItem("Discover DTS-i");
		jcvname.addItem("Wave DTS-i");
		
		jccolor.setBounds(500,290,120,30);
		jccolor.addItem("-- Select Color -- ");
		jccolor.addItem("Black");
		jccolor.addItem("Blue");
		jccolor.addItem("Red");
		jccolor.addItem("Grey");
						
		tfvprc.setBounds(160,340,100,25);
		jcadd.setBounds(500,340,150,25);
		jcadd.addItem("-- Select Add Proof-- ");
		jcadd.addItem("Ration Card");
		jcadd.addItem("Licence");
		tfeddate.setBounds(160,390,120,25);
		
		rbcash.setBounds(420,390,20,25);
		rbcheque.setBounds(530,390,20,25);
		//rbdd.setBounds(640,390,20,25);
		
		ok.setBounds(270,480,85,30);
		can.setBounds(370,480,85,30);
		
		rbcheque.addActionListener(this);
		rbcheque.setActionCommand("che");
		
		tfcno.addKeyListener(this);	
		tfqno.addKeyListener(this);
			
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str =ae.getActionCommand();
		if(str.equals("can"))
		{
			this.dispose();
			new menu();
		}
		if(str.equals("che"))
		{
			new cheque();
		}
		if(str.equals("Ok"))
		{
								
			Connection con = null;
			Statement stat1 = null;
			
			int intinsert=0;
		    Boolean flag = false;
		    if(tfono.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter the order number","Error",JOptionPane.ERROR_MESSAGE);
				
			}
			
			
			try 
			{											
Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");
				Statement stat = con.createStatement();			
				System.out.println ("chk1");
				ResultSet rs = stat.executeQuery("Select * from order1");
				System.out.println ("chk2");
				while(rs.next())
				{	
			    	if(Integer.parseInt(tfono.getText()) == rs.getInt(1))
			    	{
			    		flag = true;
			    	}
					
				}
			  System.out.println ("flag:"+flag);
				
				if(flag == false)
				{
				
					PreparedStatement pstmt = con.prepareStatement("insert into order1 values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				  	pstmt.setInt(1,Integer.parseInt(tfono.getText()));
			    	pstmt.setInt(2,Integer.parseInt(tfqno.getText()));
			    	pstmt.setString(3,tfdate.getText());
			    	pstmt.setInt(4,Integer.parseInt(tfcno.getText()));
			    	pstmt.setString(5,tfcname.getText());
			    	pstmt.setString(7,tfadd.getText());
			    	pstmt.setInt(6,Integer.parseInt(tfage.getText()));
			    	pstmt.setInt(8,Integer.parseInt(tftno.getText()));
			    	pstmt.setString(9,(String)jcvname.getSelectedItem());
			    	pstmt.setString(10,(String)jccolor.getSelectedItem());
			    	pstmt.setInt(11,Integer.parseInt(tfvprc.getText()));
			    	pstmt.setString(12,(String)jcadd.getSelectedItem());
			    	pstmt.setString(13,tfeddate.getText());	    	
			    	if(rbcash.isSelected()==true)
			    	{
			    		pstmt.setString(14,"cash");
			    	}
			    	else
			    	{
			    		pstmt.setString(14,"cheque");
			    	}
			    	intinsert = pstmt.executeUpdate();
			    	pstmt.close();
			    	stat.close();
					con.close();
			    	

				}
				
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null,"Order Record Already Exists","Error",JOptionPane.ERROR_MESSAGE);
					tfono.setText(null);
				}
			}
		    catch (SQLException e4) 
		    {
		    }
		    catch (Exception ex3) 
		    {
		    	
		    }
		    if(intinsert == 1)
		    {
		    	JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
		    	tfono.setText(null);
		    	tfqno.setText(null);
		    	tfdate.setText(null);
		    	tfcno.setText(null);
		    	tfcname.setText(null);
		    	tfadd.setText(null);
		    	tfage.setText(null);
		    	tftno.setText(null);
		    	tfvprc.setText(null);
		    	tfeddate.setText(null);
		    	
		    }
		}		
	}
		
		
	
	
	//FOR FETCHING CUSTOMER RECORD 
	public void keyReleased(KeyEvent ke)
	{
		
	}
	public void keyPressed(KeyEvent ke1)
	{
		int num1,num2;
		int num = ke1.getKeyCode();
		Connection con;
				Connection con1;
		Statement stat;
		Boolean flag1 = false;
		Boolean flag2 = false;
		//System.out.println ("Number:"+num);
		
		if(num==10)
		{
			
			num1=Integer.parseInt(tfcno.getText());
			
			try 
			{
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");				
				stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from cust");
				while(rs.next())
				{
					if(num1 == rs.getInt(1))
					{
						flag1 = true;
						tfcname.setText(rs.getString(2));
						tfage.setText(""+rs.getInt(4));
						tfadd.setText(rs.getString(3));
						tftno.setText(""+rs.getInt(5));
					}
				}
			}
		    catch (Exception ex) 
		    {
		    }
		    if(flag1 == false)
		    {
		    	JOptionPane.showMessageDialog(null,"Customer Not Found","Error",JOptionPane.ERROR_MESSAGE);
		    }
		    num2=Integer.parseInt(tfqno.getText());
				try 
				{
					Class.forName("org.postgresql.Driver");
					con1= DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");					Statement stat1 = con1.createStatement();
					ResultSet rs1 = stat1.executeQuery("select * from quotation");
					while(rs1.next())
					{
						if(num2 == rs1.getInt(1))
						{
							flag2 = true;
							tfvprc.setText(""+rs1.getInt(9));
						}
					}
					stat1.close();
					con1.close();
				}
		    	catch (Exception ex1) 
		    	{
		    	}
		    	if(flag2 == false)
		    	{
			    	JOptionPane.showMessageDialog(null,"Customer Not Found","Error",JOptionPane.ERROR_MESSAGE);
			    }
		    
		}
		
	}
	public void keyTyped(KeyEvent ke2)
	{
		
	}
	
		
	public static void main(String args[])
	{
		new order();
	}
}
