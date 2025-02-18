package dev.syntax.step03_util_function.ch02;

import dev.syntax.step03_util_function.model.Employee;
import dev.syntax.step03_util_function.model.Unit;

public class FSFilter implements EmployeeFilter {

	// FS 팀에 속한 사원만 필터링하는 클래스
	@Override
	public boolean filterEmployee(Employee employee) {

		return employee.getUnit()== Unit.FS;
	}
}
