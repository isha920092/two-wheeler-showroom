
import javax.swing.table.AbstractTableModel;
import java.sql.*;


public class ResultSetTableModel extends AbstractTableModel {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	private boolean connectedToDatabase = false;

	public ResultSetTableModel(String query) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver"); 
		connection = DriverManager.getConnection("jdbc:org.postgresql;//localhost:5432/raj","postgres","passwod"); 
		
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		connectedToDatabase = true;
		setQuery(query); 
	}


	public Class getColumnClass(int column) throws IllegalStateException {

		if (!connectedToDatabase) throw new IllegalStateException("Not Connected to Database");

		try {
			String className = metaData.getColumnClassName(column + 1);
			return Class.forName(className); 
		}
		        
		catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return Object.class;
	}


	public int getColumnCount() throws IllegalStateException {

		if (!connectedToDatabase) throw new IllegalStateException("Not Connected to Database");

		try {
			return metaData.getColumnCount();
		}

		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return 0;
	}


	public String getColumnName(int column) throws IllegalStateException {

		if (!connectedToDatabase) throw new IllegalStateException("Not Connected to Database");

		try {
			return metaData.getColumnName(column + 1);
		}

		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return "";
	}


	public int getRowCount() throws IllegalStateException {

		if (!connectedToDatabase) throw new IllegalStateException("Not Connected to Database");
		return numberOfRows;
	}


	public Object getValueAt(int row, int column) throws IllegalStateException {

		if (!connectedToDatabase) throw new IllegalStateException("Not Connected to Database");

		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		}

		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return "";
	}


	public void setQuery(String query) throws SQLException, IllegalStateException {

		if (!connectedToDatabase) throw new IllegalStateException("Not Connected to Database");

		resultSet = statement.executeQuery(query);

		metaData = resultSet.getMetaData();

		resultSet.last(); 
		numberOfRows = resultSet.getRow(); 
		fireTableStructureChanged(); 
	}

	
	public void disconnectFromDatabase() {
	
		try {
			statement.close();
			connection.close();
		}
	
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	
		finally {
			connectedToDatabase = false;
		}
	}
} 
