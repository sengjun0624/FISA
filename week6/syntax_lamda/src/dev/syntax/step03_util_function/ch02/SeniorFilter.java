package dev.syntax.step03_util_function.ch02;

import dev.syntax.step03_util_function.model.Employee;

public class SeniorFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getExperience() > 10;
	}
}
