

//import the packages for using the classes in them into the program

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class print_order extends JInternalFrame implements Printable {
	/***************************************************************************
	 ***      declaration of the private variables used in the program       ***
	 ***************************************************************************/

	//for setting the connection and statement
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	private String URL = "jdbc:odbc:showroom";

	//for creating the text area
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea1 = new JTextArea();
	
	//for creating the vector to use it in the print
	private Vector lines;
	public static final int TAB_SIZE = 10;

	//constructor of JLibrary
	public print_order(String query) {
		super("Printing Order", false, true, false, true);
		//for getting the graphical user interface components display area
		Container cp = getContentPane();
		//for setting the font
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		//for adding the textarea to the container
		cp.add(textArea);
		cp.add(textArea1);
		try {
				Class.forName("org.postgresql.Driver");
			
		}
		catch (ClassNotFoundException ea) {
			System.out.println(ea.toString());
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		/***************************************************************
		 * for making the connection,creating the statement and update *
		 * the table in the database. After that,closing the statmenet *
		 * and connection. There is catch block SQLException for error *
		 ***************************************************************/
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/raj","postgres","password");	
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			textArea.append(" \t\t\t\tBajaj Auto Ltd.\n");
			textArea.append(" \t14/2/2 Malegaon\n");
			
			 
			textArea.append("\t*************** Order Information ***************\n");
			textArea.append(" ---------------------------------------------------------------------------------------\n");
			textArea.append("Order no      Quot no      Date      Cust no    Order veh    Price		Add Proof "  );
			textArea.append(" ---------------------------------------------------------------------------------------\n");
			while (resultset.next()) {
				textArea.append("" + resultset.getInt(1) + 
				        "      " + resultset.getInt(2) + 
				        "          " + resultset.getString(3) + 
				        "         " + resultset.getInt(4) +
				        "          " + resultset.getString(9)+ 
				        "          " + resultset.getInt(11)+ 
				        "           " + resultset.getString(12)+"\n");
			}
			textArea.append("=====================================================");
			resultset.close();
			statement.close();
			connection.close();
		}
		catch (SQLException SQLe) {
			System.out.println(SQLe.toString());
		}
		//for setting the visible to true
		setVisible(true);
		//to show the frame
		pack();
	}

	public int print(Graphics pg, PageFormat pageFormat, int pageIndex) throws PrinterException {
		pg.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
		int wPage = (int) pageFormat.getImageableWidth();
		int hPage = (int) pageFormat.getImageableHeight();
		pg.setClip(0, 0, wPage, hPage);

		pg.setColor(textArea.getBackground());
		pg.fillRect(0, 0, wPage, hPage);
		pg.setColor(textArea.getForeground());

		Font font = textArea.getFont();
		pg.setFont(font);
		FontMetrics fm = pg.getFontMetrics();
		int hLine = fm.getHeight();

		if (lines == null)
			lines = getLines(fm, wPage);

		int numLines = lines.size();
		int linesPerPage = Math.max(hPage / hLine, 1);
		int numPages = (int) Math.ceil((double) numLines / (double) linesPerPage);
		if (pageIndex >= numPages) {
			lines = null;
			return NO_SUCH_PAGE;
		}
		int x = 0;
		int y = fm.getAscent();
		int lineIndex = linesPerPage * pageIndex;
		while (lineIndex < lines.size() && y < hPage) {
			String str = (String) lines.get(lineIndex);
			pg.drawString(str, x, y);
			y += hLine;
			lineIndex++;
		}
		return PAGE_EXISTS;
	}

	protected Vector getLines(FontMetrics fm, int wPage) {
		Vector v = new Vector();
		
		String text1 = textArea1.getText();
		String text = textArea.getText();
		String prevToken = "";
		StringTokenizer st = new StringTokenizer(text, "\n\r", true);
		while (st.hasMoreTokens()) {
			String line = st.nextToken();
			if (line.equals("\r"))
				continue;
			// StringTokenizer will ignore empty lines, so it's a bit tricky to get them...
			if (line.equals("\n") && prevToken.equals("\n"))
				v.add("");
			prevToken = line;
			if (line.equals("\n"))
				continue;

			StringTokenizer st2 = new StringTokenizer(line, " \t", true);
			String line2 = "";
			while (st2.hasMoreTokens()) {
				String token = st2.nextToken();
				if (token.equals("\t")) {
					int numSpaces = TAB_SIZE - line2.length() % TAB_SIZE;
					token = "";
					for (int k = 0; k < numSpaces; k++)
						token += " ";
				}
				int lineLength = fm.stringWidth(line2 + token);
				if (lineLength > wPage && line2.length() > 0) {
					v.add(line2);
					line2 = token.trim();
					continue;
				}
				line2 += token;
			}
			v.add(line2);
		}
		return v;
	}
	
	
	
}