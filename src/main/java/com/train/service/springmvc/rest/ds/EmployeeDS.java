package com.train.service.springmvc.rest.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.train.service.model.Employee;

public class EmployeeDS {

	private static Map<String, Employee> allEmployees;
	static {
		allEmployees = new HashMap<String, Employee>();
		Employee employee1 = new Employee();
		employee1.setEmployeeId("1");
		employee1.setEmployeeName("Fabrizio");
		employee1.setJob("Software Engineer");
		allEmployees.put(employee1.getEmployeeId(), employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeId("2");
		employee2.setEmployeeName("Justin");
		employee2.setJob("Business Analyst");
		allEmployees.put(employee2.getEmployeeId(), employee2);

	}

	public void add(Employee e) {
		allEmployees.put(e.getEmployeeId(), e);
	}

	public Employee get(String id) {
		return allEmployees.get(id);
	}

	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		for (Iterator<Employee> it = allEmployees.values().iterator(); it
				.hasNext();) {
			Employee e = it.next();
			employees.add(e);
		}
		return employees;
	}

	public void remove(String id) {
		allEmployees.remove(id);
	}

	public void update(Employee e) {
		allEmployees.put(e.getEmployeeId(), e);
	}

}
