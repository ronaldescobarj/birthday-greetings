package xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class FileEmployeeRepository implements EmployeeRepository {
	
	private String fileName;
	
	public FileEmployeeRepository(String fileName) {
		this.fileName = fileName;
	}
	
	public List<Employee> getEmployees()  throws IOException, ParseException, AddressException, MessagingException {
		System.out.println("Abriendo archivo");
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str = "";
		str = in.readLine(); // skip header
		System.out.println("Primera linea de archivo");
		List<Employee> employees = new ArrayList<Employee>();
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0],
					employeeData[2], employeeData[3]);
			employees.add(employee);
		}
		in.close();
		return employees;
	}
}
