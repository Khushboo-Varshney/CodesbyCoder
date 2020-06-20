package mypack;
import java.sql.*;
public class Makeorder {
	String name,contact_no,address,email,tour_name;

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getcontact_no() {
		return contact_no;
	}

	public void setcontact_no(String Contact_no) {
		this.contact_no = contact_no;
	}
	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String tour_name() {
		return tour_name;
	}

	public void settour_name(String tour_name) {
		this.tour_name = tour_name;
	}
	
	public boolean makeorder()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test");
		PreparedStatement psmt=
			con.prepareStatement("insert into orders values(?,?,?,?,?)");
		psmt.setString(1, name);
		psmt.setString(2, contact_no);
		psmt.setString(3, address);
		psmt.setString(4, email);
		psmt.setString(5, tour_name);
		int a=psmt.executeUpdate();
		con.close();
		if(a>0)
			return true;
		else
			return false;
				
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}

}
}
