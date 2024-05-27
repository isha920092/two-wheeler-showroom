import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class delEqn extends JFrame implements ActionListener
{	    
        JTextField tfmsg;
		int intdel;
	public delEqn()
	{
		JLabel msg;
	
		JButton ok,can;
		msg = new JLabel("Enter The Enquiry No");
		tfmsg = new JTextField(10);
		ok = new JButton("OK");
		can = new JButton("CANCEL");
			
		Container c = getContentPane();
		
		c.setLayout(null);
		this.setTitle("Search Record");
		this.setSize(300,200);
		this.setVisible(true);
		this.setLocation(200,200);
		
		c.add(msg);
		c.add(tfmsg);
		
		c.add(ok);
		c.add(can);
		
		ok.addActionListener(this);
		ok.setActionCommand("ok");
		can.addActionListener(this);
		can.setActionCommand("can");
		
		msg.setBounds(50,50,150,30);
		tfmsg.setBounds(175,50,50,30);
		ok.setBounds(60,100,70,30);
		can.setBounds(160,100,80,30);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		Connection con = null;
		
		if(str.equals("ok"))
		{
			try 
			{
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");				
				PreparedStatement stmt = con.prepareStatement("delete from enq where enqno = "+Integer.parseInt(tfmsg.getText()));
				 intdel = stmt.executeUpdate();
				
				
		    }
		    catch (Exception ex) 
		    {
		    }
		    if(intdel == 1)
		    {
		    	JOptionPane.showMessageDialog(null,"");
		    }
		}
	}
	
	public static void main(String args[])
	{
		new delEqn();
	}
	
}