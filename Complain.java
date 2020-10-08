package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Complain {
	String name,pass,complain;

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getpass() {
		return pass;
	}

	public void setpass(String pass) {
		this.pass = pass;
	}

	public String getcomplain() {
		return complain;
	}

	public void setcomplain(String complain) {
		this.complain = complain;
	}
	public boolean complain()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test");
		PreparedStatement psmt=
			con.prepareStatement("insert into complain values(?,?,?)");
		psmt.setString(1, name);
		psmt.setString(2, pass);
		psmt.setString(3, complain);
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
