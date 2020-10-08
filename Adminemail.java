package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Adminemail {

	String To,Subject,Message;

	public String getTo() {
		return To;
	}

	public void setTo(String To) {
		this.To = To;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String Subject) {
		this.Subject = Subject;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}
	public boolean complain()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test");
		PreparedStatement psmt=
			con.prepareStatement("insert into email values(?,?,?)");
		psmt.setString(1, To);
		psmt.setString(2, Subject);
		psmt.setString(3, Message);
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
