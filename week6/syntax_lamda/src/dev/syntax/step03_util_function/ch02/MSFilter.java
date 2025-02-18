package dev.syntax.step03_util_function.ch02;

import dev.syntax.step03_util_function.model.Employee;
import dev.syntax.step03_util_function.model.Unit;

public class MSFilter implements EmployeeFilter {
	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getUnit() == Unit.MS;
	}
}
