package dev.syntax.step03_util_function.ch02;

import dev.syntax.step03_util_function.model.Employee;

public interface EmployeeFilter {
	/**
	 * Employee 객체를 전달받아 필터링을 수행하는 추상 메서드
	 * @param employee
	 * @return boolean
	 */
	boolean filterEmployee(Employee employee);
}
