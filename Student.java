package bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Student 
{
	private String contact;
	private String fst_name;
	private String lst_name;
	private String email;
	private String address;
	private String stream;
	private String clubs;
	
	public String getFst_name() {
		return fst_name;
	}
	public void setFst_name(String fst_name) {
		this.fst_name = fst_name;
	}
	public String getLst_name() {
		return lst_name;
	}
	public void setLst_name(String lst_name) {
		this.lst_name = lst_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getStream() {
		
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getClubs() {
		return clubs;
	}
	public void setClubs(String clubs) {
		this.clubs = clubs;
	}
	public static Connection connect() throws SQLException
	{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
		String url = "jdbc:mysql://localhost:3306/my_1st_database";
		String user = "root";
		String password = "";
		
		Connection conn = DriverManager.getConnection(url,user,password);
		
		return conn;
		
	}
	
	public int addstudent() throws SQLException
	{
		Connection conn = connect();
		
		String sql = "insert into registration values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, fst_name);
		ps.setString(2, lst_name);
		ps.setString(3, email);
		ps.setString(4, address);
		ps.setString(5, contact);
		ps.setString(6, stream);
		ps.setString(7, clubs);
		
		int response = ps.executeUpdate();
		

		conn.close();
		return response;
		
	}

}
