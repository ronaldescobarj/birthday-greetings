package xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.*;

public interface EmployeeRepository {
	List<Employee> getEmployees() throws IOException, ParseException, AddressException, MessagingException;
}
