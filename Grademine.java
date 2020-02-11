import java.sql.*;

public class Grademine 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mouni123");
			
			Statement stmt=con.createStatement();
			
			String sql = "select * from grade";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("student details");
			System.out.println("-----------------");
	
			while(rs.next())
			{
				String student_name 	= rs.getString(1);
				int hall_no 			= rs.getInt(2);
				int subject_code 		= rs.getInt(3);
				int internal_marks 		= rs.getInt(4);
				int external_marks 		= rs.getInt(5);
				
				int totalmarks 			= internal_marks + external_marks;

				System.out.print(student_name+"\t"+hall_no+"\t"+subject_code+"\t"+internal_marks+"\t"+external_marks+"\t"+totalmarks+"\t");
			
				if(totalmarks>=80 && totalmarks<100)
				{
					System.out.print("Grade = O");
					System.out.println("\t result = Pass");
				}
				else if(totalmarks>=70 && totalmarks<80)
				{
					System.out.print("Grade = A+");
					System.out.println("\t result = Pass");
				}	
				else if(totalmarks>=60 && totalmarks<70)
				{
					System.out.print("Grade = A");
					System.out.println("\t result = Pass");
				}
				else if(totalmarks>=55 && totalmarks<60)
				{
					System.out.print("Grade = B+");
					System.out.println("\t result = Pass");
				}
				else if(totalmarks>=50 && totalmarks<55)
				{
					System.out.print("Grade = B");
					System.out.println("\t result = Pass");
				}
				else if(totalmarks>=45 && totalmarks<50)
				{
					System.out.print("Grade = C");
					System.out.println("\t result = Pass");
				}
				else if(totalmarks>=40 && totalmarks<45)
				{
					System.out.print("Grade = P");
					System.out.println("\t result = Pass");
				}
				else
				{
					System.out.print("Grade = F");
					System.out.println("\t result = FAIL");
				}
				System.out.println("");
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