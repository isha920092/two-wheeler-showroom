import java.sql.*;
import java.io.*;
public class temp
{
	BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
	
	public temp() 
	{
		try 
		{
			System.out.println ("Enter the order Number:");
			int ono = Integer.parseInt(b.readLine());
			Connection con=null;
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");				
			System.out.println ("Got Connection :"+con);
			Statement stat = con.createStatement();			
			System.out.println ("chk1");
			ResultSet rs = stat.executeQuery("Select * from order1");
			System.out.println ("chk2");
			while(rs.next())
			{	
			    System.out.println ("Order No:"+rs.getInt(1));
			    System.out.println ("Customer Name:"+rs.getString(5));
				if(rs.getInt(1) == ono)
				{
					System.out.println ("Order No:"+rs.getInt(1));
				
				}
			}
			
		stat.close();
		con.close();
	    }
	    catch (Exception ex) 
	    {
	    }		
	}
	
	public static void main(String args[]) throws Exception
	{
		new temp();
	}
}