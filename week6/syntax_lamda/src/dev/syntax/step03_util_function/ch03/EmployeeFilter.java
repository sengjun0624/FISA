package dev.syntax.step03_util_function.ch03;

import dev.syntax.step03_util_function.model.Employee;

@FunctionalInterface
public interface EmployeeFilter {
	boolean filterEmployee(Employee employee);
}
