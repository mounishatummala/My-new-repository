import java.sql.*;
public class Samplejdbc {
public static void main(String[] args)
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mouni123");
		Statement stmt=con.createStatement();
		String sql="select * from Empl";
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println("employee details");
		System.out.println("-----------------");
		while(rs.next())
		{
			int empId=rs.getInt(1);
			String empName=rs.getString(2);
		float empSal=rs.getFloat(3);
		Date empDoj=rs.getDate(4);
		System.out.println(empId+"\t"+empName+"\t"+empSal+"\t"+empDoj+"\t");
		
		}
		stmt.close();
		rs.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println("error:"+e.getMessage());
	}

}
}
