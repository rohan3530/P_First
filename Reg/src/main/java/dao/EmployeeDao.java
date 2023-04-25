 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mod.Employee;

public class EmployeeDao {
	

	public int registerEmployee(Employee employee)throws ClassNotFoundException{
		String qwe ="INSERT INTO emp" +"(idemp,first name, last name, address, contact) VALUES  "+"(?, ?, ?, ?, ?);";
		int result=0;
		
		Class.forName("con.mysql.jdbc.Driver");

		try (

				Connection connection =DriverManager
				.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				
		
				
				PreparedStatement preparedstatment=connection.prepareStatement(qwe))
			   {
	
							preparedstatment.setInt(1,1);
				            preparedstatment.setString(2,employee.getFirstName());
				            preparedstatment.setString(3,employee.getLastName());
				            preparedstatment.setString(4,employee.getAddress());
				            preparedstatment.setString(5,employee.getContact());
				            
				            System.out.println(preparedstatment);
				            result=preparedstatment.executeUpdate();
				            
			   } catch(SQLException e)
		{
							e.printStackTrace();
		}
	   return result; 
	}

}

