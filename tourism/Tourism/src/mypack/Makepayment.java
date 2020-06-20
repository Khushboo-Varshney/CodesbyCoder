package mypack;
import java.sql.*;
public class Makepayment {
	String mode_of_payment,card_no,expiry_date,CVV;

	public String getmode_of_payment() {
		return mode_of_payment;
	}

	public void setmode_of_paymnet(String mode_of_payment) {
		this.mode_of_payment = mode_of_payment;
	}

	public String getcard_no() {
		return card_no;
	}

	public void setcard_no(String Card_no) {
		this.card_no = card_no;
	}
	public String getexpiry_date() {
		return expiry_date;
	}

	public void setexpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String CVV) {
		this.CVV = CVV;
	}
	
	
	public boolean makepayment()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test");
		PreparedStatement psmt=
			con.prepareStatement("insert into payment values(?,?,?,?)");
		psmt.setString(1, mode_of_payment);
		psmt.setString(2, card_no);
		psmt.setString(3, expiry_date);
		psmt.setString(4, CVV);
		
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



