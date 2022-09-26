package com.glearning.email.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.glearning.email.model.Employee;
import com.glearning.email.service.CredentialService;
import com.glearning.email.service.EmployeeService;

public class EmailServiceClient{
	private static CredentialService credentialService = new CredentialService();
	public static EmployeeService employeeService = new EmployeeService(credentialService);

	//entry point to access the service
	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter First Name");
		String firstName = scanner.next();
		
		System.out.println("Please enter Last Name");
		String lastName = scanner.next();
		
		System.out.println("Please enter date of birth in dd/MM/yyyy format");
		
		String strDOB = scanner.next();
		LocalDate dob = null;
		Employee newHire = null;
		try {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dob = LocalDate.parse(strDOB, pattern);
		} catch (Exception exception) {
			System.out.println("invalid date format passed. Example: 01/12/1990");
		}

		if (dob != null) {
			newHire = new Employee(firstName, lastName, dob);
		} else {
			newHire = new Employee(firstName, lastName);
		}
		newHire = new Employee(firstName, lastName);
		System.out.println("Enter your department from following:\n Technical or Admin or HR or Legal");
		String dept = scanner.next();
		newHire.setDept(dept);
		employeeService.generateEmailAddress(newHire);


		System.out.println("Enter your options from the following:: ");
		System.out.println("1 -> Generate Password ");
		System.out.println("2 -> Show Details ");

		int result = scanner.nextInt();

		switch (result) {
		case 1:
			employeeService.saveCredentials(8, newHire);
			
			break;
		case 2:
			employeeService.saveCredentials(8, newHire);
			employeeService.printEmployeeDetails(newHire);
			break;
		}
		
		scanner.close();

	}

}
