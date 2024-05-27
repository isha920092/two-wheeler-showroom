import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class order_list extends JPanel {
    private boolean DEBUG = false;
        // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver"; // use specific driver for your database
    static final String DB_URL = "jdbc:postgresql://localhost:5432/raj";
    // Database credentials
    static final String USER = "postgres";
    static final String PASS = "password";
    Connection conn = null;
    Statement stmt = null;
    static Vector<Vector<String>> data = new Vector<Vector<String>>();

    public order_list() {
        super(new GridLayout(1,0));


        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Order no");
        columnNames.add("Quotaion Number");
        columnNames.add("Date of Order");
        columnNames.add("Customer no");
        columnNames.add("Customer name");
        columnNames.add("Age");
        columnNames.add("Address");
        columnNames.add("Telephone no");
        columnNames.add("Ordered vehicle");
        columnNames.add("Color");
        columnNames.add("Vehicle price");
        columnNames.add("Address proof");
        columnNames.add("Estimate Delivery Date");
        columnNames.add("Payment mode");




      String query =
                "select * from order1;";


        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {

                Vector<String> vstring = new Vector<String>();


                vstring.add(rs.getString(1));
                vstring.add(rs.getString(2));
                vstring.add(rs.getString(3));
                vstring.add(rs.getString(4));
                vstring.add(rs.getString(5));
                vstring.add(rs.getString(6));                
                vstring.add(rs.getString(7));
                vstring.add(rs.getString(8));
                
                vstring.add(rs.getString(9));
                vstring.add(rs.getString(10));
                vstring.add(rs.getString(11));
                vstring.add(rs.getString(12));                
                vstring.add(rs.getString(13));
                vstring.add(rs.getString(14));
                 vstring.add("\n\n\n\n\n\n\n");

                data.add(vstring);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(FlashBuilderGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

      //  final JTable table = new JTable(data, columnNames);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
     }

