package xpug.kata.birthday_greetings;

import java.util.*;

import java.io.IOException;
import java.text.ParseException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {
	
	private EmployeeRepository repository;
	private EmailService emailService;

	public BirthdayService(EmployeeRepository repository, EmailService emailService) {
		 this.repository = repository;
		 this.emailService = emailService;
	}
	
	public void sendGreetings(OurDate ourDate) throws IOException, ParseException, AddressException, MessagingException {
		List<Employee> employees = repository.getEmployees();
		for (Employee employee: employees) {
			if (employee.isBirthday(ourDate))
				emailService.sendMessage("sender@here.com", employee);
		}
		
	}

	public static void main(String[] args) {
		EmailService mail = new SMTPMailService("localhost", 25);
		EmployeeRepository repository = new FileEmployeeRepository("employee_data.txt");
		BirthdayService service = new BirthdayService(repository, mail);
		try {
			service.sendGreetings(new OurDate("2008/10/08"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
