package dev.syntax.step03_util_function.ch02;

import dev.syntax.step03_util_function.model.Employee;
import dev.syntax.step03_util_function.model.Skill;

public class JavaSkillFilter implements EmployeeFilter {
	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getSkills().contains(Skill.JAVA);
	}
}
