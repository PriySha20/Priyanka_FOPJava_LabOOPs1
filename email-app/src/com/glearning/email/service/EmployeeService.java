package com.glearning.email.service;

import com.glearning.email.model.Employee;

public class EmployeeService {
	
	private final CredentialService credentialService;
	
	public EmployeeService(CredentialService credentialService) {
		this.credentialService = credentialService;
		
	}
	public void generateEmailAddress(Employee employee) {
		String emailAddress = this.credentialService.generateEmailAddress(employee.getFirstName(), employee.getLastName(), employee.getDept());
		employee.setEmailAddress(emailAddress);
	}
	public Employee saveCredentials(int length, Employee employee) {
		String password = this.credentialService.generatePassword();
		employee.setPassword(password);
		return employee;
		
	}
	public void printEmployeeDetails(Employee employee) {
		this.credentialService.showCredentials(employee);
	}
}
